package com.mycompany.models;

import java.sql.Date;

public class Purchases {
    private int id;
    private int supplierId;
    private int productId;
    private int quantity;
    private Date purchaseDate;
    private double totalCost;
    private String notes;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
