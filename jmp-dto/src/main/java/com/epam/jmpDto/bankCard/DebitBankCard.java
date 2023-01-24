package com.epam.jmpDto.bankCard;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
@Getter
public class DebitBankCard extends BankCard {
    private BankCardType bankCardType;
}
