package com.epam.jmpCloudServiceImpl;

import com.epam.jmpCloudServiceImpl.exception.ServiceException;
import com.epam.jmpDto.Subscription;
import com.epam.jmpDto.User;
import com.epam.jmpDto.bankCard.BankCard;
import com.epam.jmpServiceApi.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceImpl implements Service {
    private static final List<BankCard> DB_CARD = new ArrayList<>();
    private static final List<Subscription> DB_SUBSCRIPTION = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        if (bankCard != null) {
            DB_CARD.add(bankCard);
            DB_SUBSCRIPTION.add(Subscription.builder()
                            .bankcard(bankCard.getCardNumber())
                            .startDate(LocalDate.now())
                    .build());
        }
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String cardNumber) {
        var subscription = DB_SUBSCRIPTION.stream()
                .filter(e -> e.getBankcard().equals(cardNumber))
                .findFirst()
                .orElseThrow(() -> new ServiceException("Subscription is empty"));
        return subscription;
    }

    @Override
    public List<User> getAllUsers() {
        var users = DB_CARD.stream()
                .map(BankCard::getUser)
                .toList();
        return users;
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        var subscriptions = DB_SUBSCRIPTION.stream()
                .filter(predicate)
                .toList();
        return subscriptions;
    }
}
