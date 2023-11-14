package com.example.Rainbow.clean.repo;

import com.example.Rainbow.clean.model.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByCategoryId(long categoryId);

    Option findByCategoryId(long categoryId);

}
