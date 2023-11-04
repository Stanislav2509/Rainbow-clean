package com.example.Rainbow.clean.model.entity;

import com.example.Rainbow.clean.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @NotNull
    private double price;
    @Column(name = "order_date", nullable = false)
    // @CreationTimestamp
    private Timestamp orderDate;
    @Column(name = "execution_date", nullable = false)
    //  @CreationTimestamp
    private Timestamp executionDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_options",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")}
    )
    private Set<Option> options;
    @NotNull
    @ManyToOne
    private UserEntity user;
}