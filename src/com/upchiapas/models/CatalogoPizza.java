package com.upchiapas.models;

import java.util.ArrayList;

public class CatalogoPizza {
    ArrayList<Pizza> catalogoPizzas = new ArrayList<Pizza>();

    public CatalogoPizza(){

    }

    public CatalogoPizza(ArrayList<Pizza> catalogoPizzas) {
        this.catalogoPizzas = catalogoPizzas;
    }

    public ArrayList<Pizza> getCatalogoPizzas() {
        return catalogoPizzas;
    }

    public void setCatalogoPizzas(ArrayList<Pizza> catalogoPizzas) {
        this.catalogoPizzas = catalogoPizzas;
    }
}
