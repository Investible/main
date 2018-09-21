package com.codeup.investible.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String body;

    @Column
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

<<<<<<< HEAD
=======
    public Comment() {
    }

>>>>>>> a709d539558fdb00b4337dfdb3c47a1b085073db
    public Comment(String body, Date timeStamp, Company company, User user) {
        this.body = body;
        this.timeStamp = timeStamp;
        this.company = company;
        this.user = user;
    }

<<<<<<< HEAD
    public Comment(String body){
        this.body = body;
    }

    public Comment(){

    }

=======
>>>>>>> a709d539558fdb00b4337dfdb3c47a1b085073db
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
<<<<<<< HEAD

=======
>>>>>>> a709d539558fdb00b4337dfdb3c47a1b085073db
}
