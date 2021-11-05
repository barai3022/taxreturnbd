package com.dvillage.taxreturnbd.model;

public class TaxYearModel {
    private String tax_year;
    private String tax_year_text;
    private long timestamp;

    public TaxYearModel() {
    }

    public TaxYearModel(String tax_year, String tax_year_text, long timestamp) {
        this.tax_year = tax_year;
        this.tax_year_text = tax_year_text;
        this.timestamp = timestamp;
    }

    public String getTax_year() {
        return tax_year;
    }

    public void setTax_year(String tax_year) {
        this.tax_year = tax_year;
    }

    public String getTax_year_text() {
        return tax_year_text;
    }

    public void setTax_year_text(String tax_year_text) {
        this.tax_year_text = tax_year_text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
