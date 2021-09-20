package ir.maktab56.hw15.service;


import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.domain.User;

import java.util.List;

public interface UserService extends BaseEntityService<User, Integer> {

    User register();

    User logIn();

    User editProfile(User user);

    void showProfile(User user);

    void deleteAccount(User user);

    List<User> userSearch();

}