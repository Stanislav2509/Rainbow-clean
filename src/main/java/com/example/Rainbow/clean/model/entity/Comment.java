package com.example.Rainbow.clean.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @NotNull
    private LocalDateTime created;
    @Column(name = "text_content", columnDefinition = "TEXT", nullable = false)
    private String textContent;
    @ManyToOne
    private User user;


}
