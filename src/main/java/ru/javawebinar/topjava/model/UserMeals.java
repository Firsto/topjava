package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by razor on 06.12.15.
 */
public class UserMeals {

    private static UserMeals userMeals;
    private final List<UserMeal> mealList;

    private UserMeals() {
        mealList = initMealList();
    }

    private List<UserMeal> initMealList() {
        List<UserMeal> userMeals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        return new ArrayList<>(userMeals);
    }

    public static UserMeals get() {
        if (userMeals == null) userMeals = new UserMeals();
        return userMeals;
    }

    public void addMeal(UserMeal userMeal) {
        mealList.add(userMeal);
    }
    public void getMeal() {
        System.out.println("get");
    }
    public void editMeal() {
        System.out.println("edit");
    }
    public void deleteMeal() {
        System.out.println("delete");
    }

    public List<UserMeal> getMealList() {
        return mealList;
    }
}
