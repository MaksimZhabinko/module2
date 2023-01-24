package com.epam.application;

import com.epam.jmpBankApi.Bank;
import com.epam.jmpCloudBankImpl.BankImpl;
import com.epam.jmpCloudServiceImpl.ServiceImpl;
import com.epam.jmpDto.User;
import com.epam.jmpDto.bankCard.BankCardType;
import com.epam.jmpServiceApi.Service;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.ServiceLoader;

@Log
public class Main {
    private static final Bank bank = new BankImpl();
    private static final Service service = new ServiceImpl();
    public static void main(String[] args) {
        var firstUser = User.builder()
                .name("Maxim")
                .surname("Zhabinko")
                .birthday(LocalDate.of(1996, 02, 23))
                .build();
        var bankCreditCard = bank.createBankCard(firstUser, BankCardType.CREDIT);
        LOG.info(bankCreditCard.toString());
        var secondUser = User.builder()
                .name("Aliaksei")
                .surname("Blizlichenko")
                .birthday( LocalDate.of(2010,06,27))
                .build();
        var bankDebitCard = bank.createBankCard(secondUser, BankCardType.DEBIT);
        LOG.info(bankDebitCard.toString());

        service.subscribe(bankCreditCard);
        service.subscribe(bankDebitCard);

        var subscriptionByBankCardNumber = service.getSubscriptionByBankCardNumber(bankCreditCard.getCardNumber());
        LOG.info(subscriptionByBankCardNumber.toString());

        var allUsers = service.getAllUsers();
        LOG.info(allUsers.toString());

        LOG.info("_________________________________________________________________________________________");
        var random = new Random();
        for (var i = 0; i < 10; i++) {
            var randomNumber = random.nextInt(50);
            var user = User.builder()
                    .name("name" + i)
                    .surname("surname" + i)
                    .birthday(LocalDate.now().minus(randomNumber, ChronoUnit.YEARS))
                    .build();
            LOG.info(user.toString());
            var bankCard = bank.createBankCard(user, BankCardType.DEBIT);
            service.subscribe(bankCard);
        }
        var averageUsersAge = service.getAverageUsersAge();
        LOG.info(String.valueOf(averageUsersAge));
        LOG.info("_________________________________________________________________________________________");

        var payableUser = Service.isPayableUser(secondUser);
        LOG.info(String.valueOf(payableUser));


        var allSubscriptionsByCondition =
                service.getAllSubscriptionsByCondition(subscription -> subscription.getBankcard().startsWith("4"));
        LOG.info(allSubscriptionsByCondition.toString());
        LOG.info("_________________________________________________________________________________________");


        var services = ServiceLoader.load(Service.class);
        var service = services.iterator().next();
        var allUsersService = service.getAllUsers();
        LOG.info(allUsersService.toString());

        var banks = ServiceLoader.load(Bank.class);
        var bank1 = banks.iterator().next();
        var bankCard = bank1
                .createBankCard(User.builder()
                        .name("nameBank1")
                        .surname("surnameBank1")
                        .birthday(LocalDate.now())
                        .build(), BankCardType.DEBIT);
        LOG.info(String.valueOf(bankCard));

        var exception = service.getSubscriptionByBankCardNumber("fgdgd"); // ServiceException
    }
}
