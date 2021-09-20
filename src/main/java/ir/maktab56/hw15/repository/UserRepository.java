package ir.maktab56.hw15.repository;


import ir.maktab56.hw15.base.repository.BaseEntityRepository;
import ir.maktab56.hw15.domain.User;

public interface UserRepository extends BaseEntityRepository<User, Integer> {

    boolean existByUsername(String username);

    boolean existByPassword(String username, String password);

    User findByUsername(String username, String password);

}