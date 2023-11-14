package com.example.Rainbow.clean.repo;

import com.example.Rainbow.clean.model.entity.Type;
import com.example.Rainbow.clean.model.enums.TypeNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(TypeNames typeName);
}
