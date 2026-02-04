package com.restapi.user.service;

import com.restapi.user.domain.User;
import com.restapi.user.exception.UserDuplicatedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Jone", new Date(), "1111-1111"));
        users.add(new User(2, "Kris", new Date(), "2222-2222"));
        users.add(new User(3, "Peter", new Date(), "3333-3333"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }

        return null;
    }

    public User save(User user) {

        if(user.getUserId() == null){
            users.add(user);
        }else{
            throw new UserDuplicatedException(String.format("User with id[%s] already exists", user.getUserId()));
        }

        return user;
    }

    public User deleteById(Integer userId) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if(user.getUserId().equals(userId)){
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
