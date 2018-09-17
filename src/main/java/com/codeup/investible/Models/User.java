package com.codeup.investible.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;
}
