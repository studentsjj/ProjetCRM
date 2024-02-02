package com.example.CRM.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    public enum StateOrder { CANCELED, OPTION, CONFIRMED}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String typePresta;
    private String designation;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    private Integer nbDays;
    @Column(columnDefinition = "numeric")
    private Float unitPrice;
    @Transient
    @Column(columnDefinition = "numeric")
    private Float totalExcludeTaxe=0.0f;
    @Transient
    @Column(columnDefinition = "numeric")
    private Float totalWithTaxe=0.0f;

    @Enumerated
    @Column(name = "state", columnDefinition = "smallint")
    private StateOrder state;

    public Order() {
    }

    public Order(String typePresta, String designation, Client client, Integer nbDays, Float unitPrice, StateOrder state) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.client = client;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getTotalExcludeTaxe() {
        return nbDays*unitPrice;
    }

    public void setTotalExcludeTaxe(Float totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Float getTotalWithTaxe() {
        return  nbDays*unitPrice*1.2f;
    }

    public void setTotalWithTaxe(Float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public StateOrder getState() {
        return state;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", client=" + client +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", state=" + state +
                '}';
    }
}
