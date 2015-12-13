package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal save(UserMeal meal) {
        return repository.save(meal);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public UserMeal get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public List<UserMeal> getAll() {
        return repository.getAll().stream()
                .sorted((m1, m2) -> (m1.getDateTime().compareTo(m2.getDateTime())))
                .collect(Collectors.toList());
    }

    @Override
    public void update(UserMeal meal) {
        repository.save(meal);
    }
}
