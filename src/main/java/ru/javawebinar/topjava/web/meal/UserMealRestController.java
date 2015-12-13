package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMealRestController {

    @Autowired
    private UserMealServiceImpl service;

}
