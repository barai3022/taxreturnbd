package com.dvillage.taxreturnbd.model;

public class A24Model {
    private String particular;
    private long amount;
    private long exempted;
    private long taxable;

    public A24Model() {
    }

    public A24Model(String particular, long amount, long exempted, long taxable) {
        this.particular = particular;
        this.amount = amount;
        this.exempted = exempted;
        this.taxable = taxable;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getExempted() {
        return exempted;
    }

    public void setExempted(long exempted) {
        this.exempted = exempted;
    }

    public long getTaxable() {
        return taxable;
    }

    public void setTaxable(long taxable) {
        this.taxable = taxable;
    }
}
