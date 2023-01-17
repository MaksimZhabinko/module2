package com.epam.jmpCloudBankImpl;

import com.epam.jmpBankApi.Bank;
import com.epam.jmpDto.User;
import com.epam.jmpDto.bankCard.BankCard;
import com.epam.jmpDto.bankCard.BankCardType;
import com.epam.jmpDto.bankCard.CreditBankCard;
import com.epam.jmpDto.bankCard.DebitBankCard;

import java.util.Random;

public class BankImpl implements Bank {
    private static final Random random = new Random();

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        var numberCard = random.nextLong((long) 10E14, (long) 10E15);
        return switch (bankCardType) {
            case CREDIT -> CreditBankCard.builder()
                    .cardNumber(String.valueOf(numberCard))
                    .user(user)
                    .bankCardType(BankCardType.CREDIT)
                    .build();
            case DEBIT -> DebitBankCard.builder()
                    .cardNumber(String.valueOf(numberCard))
                    .user(user)
                    .bankCardType(BankCardType.DEBIT)
                    .build();
        };
    }
}
