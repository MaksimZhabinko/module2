package com.epam.jmpServiceApi;

import com.epam.jmpDto.Subscription;
import com.epam.jmpDto.User;
import com.epam.jmpDto.bankCard.BankCard;
import com.epam.jmpServiceApi.util.AgeUtil;

import java.util.List;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCard bankCard);

    Subscription getSubscriptionByBankCardNumber(String cardNumber);

    List<User> getAllUsers();

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);

    default double getAverageUsersAge() {
        var allUsers = getAllUsers();
        var average = allUsers.stream()
                .map(User::getBirthday)
                .mapToLong(AgeUtil::getAge)
                .average();
        return average.getAsDouble();
    }

    static boolean isPayableUser(User user) {
        var age = AgeUtil.getAge(user.getBirthday());
        return age > 18;
    }
}
