package com.epam.jmpDto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class User {
    private String name;
    private String surname;
    private LocalDate birthday;
}
