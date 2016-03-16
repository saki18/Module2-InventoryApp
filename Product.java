package edu.lcc.citp.inventory;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Contains inventory product data.  Each product is expected to have its own
 * unique UPC and to be naturally ordered according to the UPC.
 * 
 * @author hoffmanz
 */
public class Product implements Serializable, Comparable<Product> {

    private String upc;
    private String shortDetails;
    private String longDetails;
    private BigDecimal price;
    private Integer stock;

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getShortDetails() {
        return shortDetails;
    }

    public void setShortDetails(String shortDetails) {
        this.shortDetails = shortDetails;
    }

    public String getLongDetails() {
        return longDetails;
    }

    public void setLongDetails(String longDetails) {
        this.longDetails = longDetails;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int compareTo(Product t) {
        return this.getUpc().compareTo(t.getUpc());
    }
    
}
