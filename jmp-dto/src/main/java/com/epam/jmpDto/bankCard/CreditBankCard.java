package com.epam.jmpDto.bankCard;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class CreditBankCard extends BankCard {
    private BankCardType bankCardType;
}
