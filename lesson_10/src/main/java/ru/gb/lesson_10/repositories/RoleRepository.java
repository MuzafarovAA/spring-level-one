package ru.gb.lesson_10.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_10.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
