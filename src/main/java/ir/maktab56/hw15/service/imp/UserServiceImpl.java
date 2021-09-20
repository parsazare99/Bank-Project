package ir.maktab56.hw15.service.imp;


import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.User;
import ir.maktab56.hw15.repository.UserRepository;
import ir.maktab56.hw15.service.UserService;
import ir.maktab56.hw15.service.UserService;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Integer, UserRepository>
        implements UserService {

    Scanner input = new Scanner(System.in);

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User register() {

        User user = new User();

        System.out.println("Enter your UserName :");
        user.setUsername(input.next());

        System.out.println("Enter your passWord :");
        while (true) {
            System.out.println("Password length must be 8 or more ");
            String password = input.next();
            if (password.length() >= 8) {
                user.setPassword(password);
                break;
            }
            System.out.println("The length of the password is shor\nplease try againe");
        }

        System.out.println("Enter your age :");
        user.setAge(input.nextInt());

        System.out.println("Enter your phone number :");
        user.setPhonenumber(input.next());

        System.out.println("Wellcome to System !");
        save(user);
        return user;
    }

    @Override
    public User logIn() {

        String username;
        String password;
        while (true) {

            System.out.println("Enter your Username :");
            username = input.next();
            if (repository.existByUsername(username)) {

                while (true) {
                    System.out.println("please Enter your password : ");
                    password = input.next();
                    if (repository.existByPassword(username, password)) {

                        System.out.println("The log in was successful !");
                        return repository.findByUsername(username, password);
                    } else {
                        System.out.println("password is Wrong!!!!");
                    }
                }

            } else {
                System.out.println("username is Wrong!!!!");

            }

        }

    }


    @Override
    public User editProfile(User user) {
        Scanner input = new Scanner(System.in);
        System.out.println(user.toString());

        System.out.println("1 : Change Username  \n" +
                "2 : Change Password\n" +
                "3 : Change Age \n" +
                "4 : Change Phone Number\n" +
                "5 : Change Bio\n" +
                "6 : Change City\n" +
                "7 : Change Country \n" +
                "8 : Change Address\n" +
                "9 : Exit");

        int a = input.nextInt();
        if (a == 1) {
            System.out.println("Enter new username : ");
            user.setUsername(input.next());

        } else if (a == 2) {

            System.out.println("Enter new password : ");
            user.setPassword(input.next());

        } else if (a == 3) {
            System.out.println("Enter uour Age : ");
            user.setAge(input.nextInt());

        } else if (a == 4) {
            System.out.println("Enter your phone number : ");
            user.setPhonenumber(input.next());

        } else if (a == 5) {
            System.out.println("Enter your bio : ");
            String bio = input.next();
           // user.setBio(bio);


        } else if (a == 7) {


            System.out.println("Enter your country name : ");
         //   user.setCountry(input.next());
        }  else {
            return user;
        }
        save(user);
        return user;

    }

    @Override
    public void showProfile(User user) {
        System.out.println(user.toString());

    }

    @Override
    public void deleteAccount(User user) {
        String password;
        while (true) {
            System.out.println("please Enter your password : ");
            password = input.next();
            if (repository.existByPassword(user.getUsername(), password)) {

                delete(user);
                System.out.println("Account deletion was successful ! ");
                break;

            } else {

                System.out.println("password is Wrong!!!!");
            }
        }

    }

    @Override
    public List<User> userSearch() {

        System.out.println("enter search key :");
        String s = new Scanner(System.in).next();

        CriteriaBuilder criteriaBuilder = repository.getEntityManager().getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(
                root.get("username"), s + "%"));

        TypedQuery<User> query = repository.getEntityManager().createQuery(criteriaQuery);


        List<User> userList = query.getResultList();
        if (userList.size() == 0) {

            System.out.println("user not found !!!!");


        } else {
            for (User u : userList) {
                System.out.println(u);

            }
        }


        return userList;


    }


}