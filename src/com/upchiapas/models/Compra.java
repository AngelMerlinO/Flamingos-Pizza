package com.upchiapas.models;

public class Compra {
    Pizza pizza;
    int cantidad;
    float subTotal;

    public Compra() {
    }

    public Compra(Pizza pizza, int cantidad, float subTotal) {
        this.pizza = pizza;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
}

