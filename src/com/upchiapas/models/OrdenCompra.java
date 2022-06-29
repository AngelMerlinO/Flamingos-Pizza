package com.upchiapas.models;

import com.upchiapas.models.Compra;

import java.util.ArrayList;

public class OrdenCompra {
    int id;
    ArrayList<Compra> compras;
    String cliente;

    public OrdenCompra() {
    }

    public OrdenCompra(int id, ArrayList<Compra> compras, String cliente) {
        this.id = id;
        this.compras = compras;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}

