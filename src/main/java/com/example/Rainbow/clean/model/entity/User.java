package com.example.Rainbow.clean.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "users")
public class User extends BaseEntity{

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Column(name = "last_name",nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, length = 30)
    private String password;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true, length = 10)
    private String gsm;
    @NotNull
    @OneToMany(mappedBy = "user")
    private Set<Order> order;
    @NotNull
    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

}
