package ru.gb.lesson_6.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_6.entities.Product;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    Product findAllById(int id);
    List<Product> findAllByIdIsBetween(int id1, int id2);
}
