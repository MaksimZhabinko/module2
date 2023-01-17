module bank {
    requires transitive bankApi;
    requires dto;

    provides com.epam.jmpBankApi.Bank with com.epam.jmpCloudBankImpl.BankImpl;

    exports com.epam.jmpCloudBankImpl;
}