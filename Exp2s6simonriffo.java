package com.mycompany.exp2s6simonriffo;

import java.util.Scanner;

public class Exp2s6simonriffo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("Bienvenido al Teatro Moro!");
            System.out.println("Venga a disfrutar de nuestra funcion");
            System.out.println("Que desea hacer?");
            System.out.println("1. Comprar Entrada");
            System.out.println("2. Salir");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    comprarEntrada(scanner);
                    break;
                case "2":
                    System.out.println("Gracias por visitar el Teatro Moro.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        } while (!opcion.equals("2"));
    }

    public static void comprarEntrada(Scanner scanner) {
        String entrada, categoria, pago, continuar;
        int vip = 0, plateabaja = 0, plateaalta = 0, palcos = 0, total = 0;
        double descuento = 0;
        String ubicacion = "";
        int precioBase = 0;

        do {
            pago = "";

            System.out.println("Por favor, ingrese su edad:");
            int edad = Integer.parseInt(scanner.nextLine());
            
            //Aquí pondría un punto de debug
            //Para confirmar que se leyeron bien los datos

            if (edad < 18) {
                entrada = "estudiante";
            } else if (edad >= 60) {
                entrada = "tercera edad";
            } else {
                entrada = "general";
            }

            System.out.println("Usted califica como " + entrada + " para la entrada.");

            System.out.println("Que categoria necesitas?");
            System.out.println("Por favor escribir la opcion en minuscula");
            System.out.println("Zona A - Vip");
            System.out.println("Zona B - Platea baja");
            System.out.println("Zona C - Platea alta");
            System.out.println("Zona D - Palcos");

            categoria = scanner.nextLine();
            
            //Otro punto de depuración
            //Para verificar que se leyó bien la categoría de asiento
            
            switch (categoria.toLowerCase()) {
                case "vip":
                    vip = entrada.equalsIgnoreCase("estudiante") ? 13000 : 25000;
                    total += vip;
                    ubicacion = "Zona A - Vip";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 13000 : 25000;
                    break;
                case "platea baja":
                    plateabaja = entrada.equalsIgnoreCase("estudiante") ? 10000 : 19000;
                    total += plateabaja;
                    ubicacion = "Zona B - Platea baja";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 10000 : 19000;
                    break;
                case "platea alta":
                    plateaalta = entrada.equalsIgnoreCase("estudiante") ? 9000 : 11000;
                    total += plateaalta;
                    ubicacion = "Zona C - Platea alta";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 9000 : 11000;
                    break;
                case "palcos":
                    palcos = entrada.equalsIgnoreCase("estudiante") ? 6500 : 7200;
                    total += palcos;
                    ubicacion = "Zona D - Palcos";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 6500 : 7200;
                    break;
                default:
                    System.out.println("Categoria invalida.");
                    return;
            }

            //Descuentos según edad
            if (entrada.equalsIgnoreCase("estudiante")) {
                descuento = 0.10;
            } else if (entrada.equalsIgnoreCase("tercera edad")) {
                descuento = 0.15;
            }

            //Aplicar descuento al total
            double descuentoAplicado = total * descuento;
            total -= descuentoAplicado;

            //Boleta de la compra
            System.out.println("Resumen de la compra:");
            System.out.println("Ubicación del asiento: " + ubicacion);
            System.out.println("Precio base de la entrada: $" + precioBase);
            System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
            System.out.println("Precio final a pagar: $" + total);

            System.out.println("¿Desea comprar otra entrada? (si/no)");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("Gracias por visitar el Teatro Moro.");
    }
}