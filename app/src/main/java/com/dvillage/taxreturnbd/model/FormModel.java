package com.dvillage.taxreturnbd.model;

public class FormModel {
    private String tin;
    private String tax_year;
    private String title;
    private String name;
    private String description;
    private long index;

    public FormModel() {
    }

    public FormModel(String tin, String tax_year, String title, String name, String description, long index) {
        this.tin = tin;
        this.tax_year = tax_year;
        this.title = title;
        this.name = name;
        this.description = description;
        this.index = index;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTax_year() {
        return tax_year;
    }

    public void setTax_year(String tax_year) {
        this.tax_year = tax_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }
}
