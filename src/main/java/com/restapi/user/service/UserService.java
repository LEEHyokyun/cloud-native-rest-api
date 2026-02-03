package com.restapi.user.service;

import com.restapi.user.domain.User;
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
        users.add(new User(1, "Jone", new Date()));
        users.add(new User(2, "Kris", new Date()));
        users.add(new User(3, "Peter", new Date()));
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
        }

        System.out.println(user.getUserId() + "에 해당하는 사용자는 이미 존재합니다.");

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
