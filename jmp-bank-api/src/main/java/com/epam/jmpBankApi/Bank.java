package com.epam.jmpBankApi;

import com.epam.jmpDto.User;
import com.epam.jmpDto.bankCard.BankCard;
import com.epam.jmpDto.bankCard.BankCardType;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
