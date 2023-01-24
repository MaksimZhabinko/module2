package com.epam.jmpDto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class Subscription {
    private String bankcard;
    private LocalDate startDate;
}
