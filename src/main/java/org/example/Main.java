package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            ArrayList <Venta> ventas = new ArrayList<Venta>();
            ArrayList <Productos> inventario = new ArrayList<Productos>();
            ArrayList <Caja> cajas = new ArrayList<Caja>();
            boolean bandera = true;
            boolean ban = true;
            do {
                System.out.println("...........Menu............");
                System.out.println("...Ingresar como Cajero....");
                System.out.println("Ingresar como Administrador");
                System.out.println("...........................");
                String opcion = keyboard.next();
                switch (opcion) {
                    case "1":
                        if (!cajas.isEmpty()) {
                            System.out.println("Caja abierta"+cajas.get(0));
                            System.out.println("1.- Alta de productos");
                            System.out.println("2.- Ingresar nueva venta");
                            System.out.println("3.- Ver inventario...");
                            System.out.println("..........................");
                            String option4 = keyboard.next();
                            switch (option4) {
                                case "1":
                                    boolean ban2 = true;
                                    do {
                                        System.out.println("....Dar de alta...");
                                        System.out.println("Ingrese el nombre del articulo");
                                        String name = keyboard.next();
                                        System.out.println("Ingrese la cantidad");
                                        int cantidad = keyboard.nextInt();
                                        System.out.println("Ingrese su precio individual");
                                        double prezio = keyboard.nextDouble();
                                        Productos producto = new Productos(name, cantidad, prezio);
                                        inventario.add(producto);
                                        if (!inventario.isEmpty()) {
                                            System.out.println("Desea agregar otro producto?");
                                            String option5 = keyboard.next();
                                            if (!option5.equals("s")) {
                                                ban2 = false;
                                            }
                                        }
                                    } while (ban2);

                                    break;
                                case "2":
                                    System.out.println("...Agregar venta...");
                                    System.out.println("Ingrese los datos actuales del articulo a vender: ");
                                    System.out.println("Ingrese el nombre del articulo");
                                    String articulo = keyboard.next();
                                    System.out.println("Ingrese la cantidad");
                                    int cantidad = keyboard.nextInt();
                                    System.out.println("Ingrese su precio");
                                    double precio = keyboard.nextDouble();
                                    Productos clone = new Productos(articulo, cantidad, precio);
                                    System.out.println("Ingrese la cantidad que se vendio: ");
                                    int cantidadv = keyboard.nextInt();
                                    double newvent = 0;
                                    if (inventario.contains(clone)) {
                                        for (Productos ver : inventario) {
                                            int removes = ver.getCantidad();
                                            cantidadv = cantidadv-removes;
                                            ver.setCantidad(cantidadv);
                                            newvent = ver.getPrecio() * cantidadv;
                                        }
                                        Venta venta = new Venta(articulo, newvent);
                                        ventas.add(venta);
                                    }else{System.out.println("No hay ningun articulo con ese nombre, intentelo de nuevo");}
                                    break;
                                case "3":
                                    System.out.println(inventario);
                                    break;
                                default:
                                    break;
                            }
                        }else{System.out.println("No hay ninguna caja intente agregar una.");}
                        break;
                    case "2":
                        do {
                            System.out.println("....Admin....");
                            System.out.println("Arqueo de caja");
                            System.out.println("Abrir caja");
                            System.out.println("Salir..");
                            String option = keyboard.next();
                            switch (option) {
                                case "1":
                                    System.out.println("......Ventas......");
                                    for (Venta ven : ventas) {
                                        System.out.println(ven);
                                    }
                                    break;
                                case "2":
                                    System.out.println("Desea abrir una caja?");
                                    String option2 = keyboard.next();
                                    if (option2.equals("s")) {
                                        boolean open = true;
                                        Caja caja = new Caja(open);
                                        cajas.add(caja);
                                    }else{ban = false;}
                                    break;
                                case "3":
                                    System.out.println("Desea salir del menu de administrador?");
                                    String option3 = keyboard.next();
                                    if (option3.equals("s")) {
                                        ban = false;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (ban);
                        break;
                    default:
                        break;
                }
            } while (bandera);

        }
    }
}