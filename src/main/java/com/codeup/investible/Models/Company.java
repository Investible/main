package com.codeup.investible.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="companies")
public class Company {

    @Id @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String ticker;

    @Column
    private Double income;

    @Column
    private Double eps;

    @Column
    private Double assets;

    @Column
    private Double liabilities;

    @Column
    private Double sales;

    @Column
    private Double yearHigh;

    @Column
    private Double yearLow;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Comment> comments;

}
