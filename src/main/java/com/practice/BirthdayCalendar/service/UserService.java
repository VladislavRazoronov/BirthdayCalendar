package com.practice.BirthdayCalendar.service;

import com.practice.BirthdayCalendar.model.User;
import com.practice.BirthdayCalendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    UserRepository userRepository;

    public String getUser(User user){
        List<User> users = userRepository.findByUsername(user.getUsername());
        if( users != null && users.size() > 0){
            if(users.get(0).getPassword().equals(user.getPassword())){
                return "Success";
            }
        }
        return "Failed";
    }
}
