package ru.gb.lesson_8.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_8.entities.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
}
