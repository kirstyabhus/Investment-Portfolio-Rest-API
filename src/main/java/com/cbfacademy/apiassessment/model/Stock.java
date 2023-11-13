package com.cbfacademy.apiassessment.model;

import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class Stock implements Investment {
    // private final UUID id;
    private UUID id;
    private String symbol;
    private String name;
    // TODO value of what? or maybe currentPrice & Purchase price
    // TODO could determine purchasePrice
    private Double value;
    private Portfolio portfolio;// ?
    private Double esgScore; // TODO

    public Double getEsgScore() {
        return esgScore;
    }

    public void setEsgScore(Double esgScore) {
        this.esgScore = esgScore;
    }

    public Stock(UUID id, String symbol, String name, double value, Portfolio portfolio) { // TODO does portfolio need
                                                                                           // to be in Constructor??
        this.id = UUID.randomUUID();
        this.symbol = symbol;
        this.name = name;
        this.value = value;
        this.portfolio = portfolio;
    }

    public UUID getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    };

    public void setValue(Double value) {
        this.value = value;
    };

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPorfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
