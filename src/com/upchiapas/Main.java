package com.upchiapas;

import com.upchiapas.models.CatalogoPizza;
import com.upchiapas.models.Compra;
import com.upchiapas.models.OrdenCompra;
import com.upchiapas.models.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        Boolean añadir = true;
        int id = 0;
        int id2 = 0;
        int idCompra = 0;
        Pizza pizza = new Pizza();
        CatalogoPizza catalogoPizza = new CatalogoPizza();
        OrdenCompra ordenCompra = new OrdenCompra();
        ArrayList<Pizza> especialidades = new ArrayList<Pizza>();
        ArrayList<OrdenCompra> ordenes = new ArrayList<OrdenCompra>();
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("Bienvenido a Flamingos Pizza's");
            System.out.println("Te presentamos el menu");
            System.out.println("1: Catalogo de especialidades ");
            System.out.println("2: Ordenar");
            System.out.println("3: Acceder a menu de administradores");
            System.out.println("4: Salir");
            System.out.print("Elije una opcion: ");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    do{
                        System.out.println("Bienvenido al menu de especialidades");
                        System.out.println("opcion 1: Registrar una especialidad");
                        System.out.println("opcion 2: Ver el catálogo de especialidades");
                        System.out.println("opcion 3: Volver al menu principal");
                        System.out.print("Elije una opcion: ");
                        opcion1 = teclado.nextInt();
                        switch (opcion1){
                            case 1:
                                id++;
                                System.out.println("Ingrese la nueva especialidad");
                                String especialidad = teclado.next();
                                System.out.println("Ingrese el precio");
                                float precio = teclado.nextFloat();
                                pizza = new Pizza(id, especialidad, precio);
                                especialidades.add(pizza);
                                catalogoPizza.setCatalogoPizzas(especialidades);
                                System.out.println("Especialidad guardada");
                                break;
                            case 2:
                                System.out.println("Lista de Especialidades");
                                for (int i=0; i<catalogoPizza.getCatalogoPizzas().size(); i++){
                                    System.out.println(catalogoPizza.getCatalogoPizzas().get(i).getEspecialidad());
                                }
                                break;
                        }
                    }while (opcion1 != 3);
                    break;
                case 2:
                    do {
                        System.out.println("Bienvenido al menu de ordenes");
                        System.out.println("opcion 1: Levantar orden de compra");
                        System.out.println("opcion 2: Volver al menu principal");
                        System.out.print("Elije una opcion: ");
                        opcion2 = teclado.nextInt();
                        switch (opcion2){
                            case 1:
                                System.out.println("Por favor ingresa tu nombre");
                                String nombre = teclado.next();
                                System.out.println("Vamos a levantar tu orden");
                                ArrayList<Compra> compras = new ArrayList<Compra>();
                                do{
                                    System.out.println("Ingresa el ID de la especialidad que deseas");
                                    System.out.println("Especialidades");
                                    for (int i=0; i<catalogoPizza.getCatalogoPizzas().size(); i++){
                                        System.out.println("ID: " + catalogoPizza.getCatalogoPizzas().get(i).getId() + " " + catalogoPizza.getCatalogoPizzas().get(i).getEspecialidad());
                                    }
                                    id2 = teclado.nextInt();

                                    System.out.println("Ingrese la cantidad deseada");
                                    int cantidad = teclado.nextInt();
                                    float subtotal = catalogoPizza.getCatalogoPizzas().get(id2-1).getPrecio() * cantidad;
                                    Compra compra = new Compra(catalogoPizza.getCatalogoPizzas().get(id2-1), cantidad, subtotal);
                                    compras.add(compra);
                                    System.out.println("Compra añadadida");
                                    System.out.println("¿Desea añadir otra compra?");
                                    System.out.println("1: Si");
                                    System.out.println("2: No");
                                    int respuesta = teclado.nextInt();
                                    if (respuesta == 1){
                                        añadir = true;
                                    }
                                    if (respuesta == 2){
                                        añadir = false;
                                    }
                                }while(añadir);
                                ordenCompra = new OrdenCompra(idCompra, compras, nombre);
                                ordenes.add(ordenCompra);

                        }
                    }while (opcion2 != 2);
                    break;
                case 3:
                    System.out.println("Caso 2");
                    do {
                        System.out.println("Bienvenido al menu de administradores");
                        System.out.println("Ingresa la opcion deseada");
                        System.out.println("Opcion 1: Reporte de ventas");
                        System.out.println("Opcion 2: Reporte de usuarios");
                        System.out.println("Opcion 3: Ordenar usuarios");
                        opcion3 = teclado.nextInt();
                        switch (opcion3){
                            case 1:
                                int totalcompras =0 ;
                                System.out.println("Ventas generadas");
                                for (int i=0; i<ordenes.size(); i++){
                                    System.out.println("Cliente: " + ordenes.get(i).getCliente());
                                    System.out.println("Compras: ");
                                    for (int j=0; j<ordenes.get(i).getCompras().size(); j++){
                                        System.out.println("Especialidad: " + ordenes.get(i).getCompras().get(j).getPizza().getEspecialidad() + " " + " Cantidad: " + ordenes.get(i).getCompras().get(j).getCantidad() + " " + " Subtotal: " + ordenes.get(i).getCompras().get(j).getSubTotal());
                                        totalcompras += ordenes.get(i).getCompras().get(j).getSubTotal();
                                    }
                                }
                                System.out.println("el total de ventas es "+totalcompras);
                                break;
                            case 2:
                                System.out.println("Reporte de Clientes");
                                for (int i=0; i<ordenes.size(); i++){
                                    System.out.println("Cliente: " + ordenes.get(i).getCliente());
                                }
                                break;
                            case 3:
                                String clientes[] = new String[ordenes.size()];
                                for (int i=0; i<ordenes.size(); i++){
                                    clientes[i] = ordenes.get(i).getCliente();
                                }
                                //Ordenamiento de burbuja
                                String auxiliar;
                                for (int i=0; i< (clientes.length-1); i++){
                                    for (int j=0; j< (clientes.length-1); j++){
                                        if(clientes[j].compareTo(clientes[j+1]) > 0){
                                            auxiliar = clientes[j];
                                            clientes[j] = clientes[j+1];
                                            clientes[j+1] = auxiliar;
                                        }
                                    }
                                }

                                //imprimir datos ordenados
                                for (int i=0; i<clientes.length; i++){
                                    System.out.println("Cliente: " + clientes[i]);
                                }
                                break;
                        }
                    }while (opcion3 != 4);
                    break;
            }
        }while (opcion != 5);
        System.out.println("Vuelve pronto");
    }
}

