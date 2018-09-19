package com.codeup.investible.Models;

import com.fasterxml.jackson.databind.JsonNode;

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
    private double netIncome;

    @Column
    private double eps;

    @Column
    private double totalAssets;

    @Column
    private double totalLiabilities;

    @Column
    private double sales;

//    @Column
//    private double yearHigh;

//    @Column
//    private double yearLow;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="graphs",
            joinColumns={@JoinColumn(name="graphs")},
            inverseJoinColumns={@JoinColumn(name="company")}
    )
    private List<Graphs> company;

    public Company(){

    }

    public Company(String name, String ticker, double netIncome, double eps, double totalAssets, double totalLiabilities, double sales, List<Comment> comments) {
        this.name = name;
        this.ticker = ticker;
        this.netIncome = netIncome;
        this.eps = eps;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.sales = sales;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

//    public double getYearHigh() {
//        return yearHigh;
//    }
//
//    public void setYearHigh(double yearHigh) {
//        this.yearHigh = yearHigh;
//    }
//
//    public double getYearLow() {
//        return yearLow;
//    }
//
//    public void setYearLow(double yearLow) {
//        this.yearLow = yearLow;
//    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

