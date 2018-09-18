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
    private Double netIncome;

    @Column
    private Double eps;

    @Column
    private Double totalAssets;

    @Column
    private Double totalLiabilities;

    @Column
    private Double sales;

    @Column
    private Double yearHigh;

    @Column
    private Double yearLow;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Comment> comments;

    public Company(){

    }

    public Company(String name, String ticker, Double netIncome, Double eps, Double totalAssets, Double totalLiabilities, Double sales, Double yearHigh, Double yearLow, List<Comment> comments) {
        this.name = name;
        this.ticker = ticker;
        this.netIncome = netIncome;
        this.eps = eps;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.sales = sales;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
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

    public Double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Double netIncome) {
        this.netIncome = netIncome;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(Double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(Double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public Double getYearLow() {
        return yearLow;
    }

    public void setYearLow(Double yearLow) {
        this.yearLow = yearLow;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}
