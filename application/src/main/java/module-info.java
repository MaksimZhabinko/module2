module application {
    requires dto;
    requires bank;
    requires service;
    requires lombok;
    requires java.logging;

    uses com.epam.jmpServiceApi.Service;
    uses com.epam.jmpBankApi.Bank;
}