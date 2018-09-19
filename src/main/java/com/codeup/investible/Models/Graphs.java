package com.codeup.investible.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="graph")
public class Graphs {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn (name = "graphs")
    private Graphs company;
    }


