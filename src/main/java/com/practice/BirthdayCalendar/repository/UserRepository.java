package com.practice.BirthdayCalendar.repository;

import org.springframework.data.repository.CrudRepository;
import com.practice.BirthdayCalendar.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    List<User> findByUsername(String username);
    User findById(int id);
    void deleteById(int id);

}
