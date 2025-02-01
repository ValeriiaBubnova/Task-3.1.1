package com.example.crudApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_db_seq", allocationSize = 1)
    private Long id;
    @NotBlank(message = "Enter name")
    @Column(length = 20)
    private String name;
    @NotBlank(message = "Enter lastName")
    @Column(length = 30, name = "last_name")
    private String lastName;
    @NotBlank(message = "Enter e-mail")
    @Email(message = "Please enter a valid e-mail")
    @Column(length = 50, unique = true)
    private String email;

    public User(String lastName, String name, String email) {
        this.lastName = lastName;
        this.name = name;
        this.email = email;
    }
}
