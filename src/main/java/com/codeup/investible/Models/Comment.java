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
    @JoinColumn(name="company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
