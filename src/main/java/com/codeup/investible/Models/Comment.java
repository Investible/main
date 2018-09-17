package com.codeup.investible.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {

    @Id @GeneratedValue
    private long id;

    @Column
    private String body;

    @Column
    private Date timeStamp;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;

//    todo Connect to users and companies

}
