package com.example.Rainbow.clean.init;

import com.example.Rainbow.clean.model.entity.Type;
import com.example.Rainbow.clean.model.enums.TypeName;
import com.example.Rainbow.clean.repo.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TypeInit  implements CommandLineRunner {
    private final TypeRepository typeRepository;

    public TypeInit(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void run(String... args) {
        if(typeRepository.count() == 0) {
            List<Type> types = new ArrayList<>();

            Arrays.stream(TypeName.values()).forEach(typeName -> {
                Type type = new Type();
                type.setName(typeName);
                types.add(type);
            });

            typeRepository.saveAll(types);
        }
    }
}
