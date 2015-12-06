package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.model.UserMeals;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by razor on 06.12.15.
 */
public class MealServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to mealList");

//        -  из сервлета обращаетесь к реализации хранения еды в памяти;
//        -  преобразуете результат в List<UserMealWithExceeded>;
//        -  кладете список в запрос (request.setAttribute);

        List<UserMealWithExceed> filteredMealsWithExceeded =
                UserMealsUtil.getFilteredMealsWithExceeded(
                        UserMeals.get().getMealList(),
                        LocalTime.of(7, 0), LocalTime.of(12, 0),
                        2000
                );

        request.setAttribute("meals", filteredMealsWithExceeded);
        request.getRequestDispatcher("/mealList.jsp").forward(request, response);
//        response.sendRedirect("mealList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String datetime = request.getParameter("datetime");
        String hour = request.getParameter("hour");
        String description = request.getParameter("description");
        String calories = request.getParameter("calories");
        String submit = request.getParameter("submit");
        LOG.debug(datetime);
        LOG.debug(hour);
        LOG.debug(description);
        LOG.debug(calories);
        LOG.debug(submit);
        switch (submit) {
            case "ADD" :
                UserMeals.get().addMeal(
                        new UserMeal(
                                LocalDateTime.of(LocalDate.parse(datetime, DateTimeFormatter.ISO_DATE), LocalTime.of(Integer.parseInt(hour), 0)),
                                description,
                                Integer.parseInt(calories)
                        ));
                break;
        }
        doGet(request, response);
    }
}
