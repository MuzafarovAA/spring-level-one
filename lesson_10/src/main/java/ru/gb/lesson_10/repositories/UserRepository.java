package ru.gb.lesson_10.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_10.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findOneByUserName(String username);
}
