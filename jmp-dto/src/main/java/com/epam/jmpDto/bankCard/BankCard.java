package com.epam.jmpDto.bankCard;

import com.epam.jmpDto.User;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
public class BankCard {
    private String cardNumber;
    private User user;
}
