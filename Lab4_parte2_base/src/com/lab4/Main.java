package com.lab4;

import com.lab4.bean.Pasaje;
import com.lab4.excepciones.DniException;
import com.lab4.excepciones.LugaresException;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        //Lista de personas con antecedentes y no pueden comprar boletos
        String[] dniBaneados = {"75407284","75603120","60255128","40845023","50874367"};

        //Lista de lugares disponibles para comparar vuelos
        String[] lugaresDisponibles = {"Rio de Janeiro", "Tokio"," Pucallpa", "Arequipa", "Ayacucho", "Bogota", "Canada"};

        System.out.println("\n***********************Bienvenido a TeleViajero************************\n");

        Pasaje pasaje = new Pasaje();

        Boolean fin = true;
        Scanner scanner = new Scanner(System.in);
        flujo:

        while (fin){

            String menu = "\nElige la acción que desea realizar:\n" +
                    "1. Registrar un viaje\n" +
                    "2. Resumen de datos ingresados \n" +
                    "3. Salir\n" +
                    "Opción: ";

            System.out.print(menu);
            String opcion = scanner.nextLine();
            try {
                int opcion_int = Integer.parseInt(opcion);

                switch (opcion_int){
                    case 1:
                        System.out.print("Ingresse el nombre: ");
                        pasaje.setNombre(scanner.nextLine());

                        pasaje.setDni(validarDni(dniBaneados));

                        pasaje.setLugarDestino(validarLugar(lugaresDisponibles));

                        System.out.println("********************** Registro exitoso del vuelo *****************************");
                        break ;
                    case 2:
                        System.out.println("2. Resumen de datos ingresados");
                        pasaje.imprimirResumenPasajero(pasaje);
                        break ;
                    case 3:
                        break flujo;
                    default:
                        System.out.println("Opcion incorrecta");
                }

            }catch (NumberFormatException e){
                System.out.println("Tiene que ingresar un numero");
            }
        }

    }


    public static String validarDni(String[] dniBaneados) throws DniException {
        String dni;
        fin:
        while (true) {
            System.out.print("Ingrese el numero de dni: ");
            Scanner scanner = new Scanner(System.in);
            dni = scanner.nextLine();
            try {
                // esta parte se pone para si a pasar el dni de string a int me sale un numero o unca cadena, si sale letras se va a NumberExceptio
                int dni_int = Integer.parseInt(dni);

                int num=0;
                for (int i=0; i<dniBaneados.length ; i++){
                    if (dniBaneados[i].equals(dni)){
                        num++;
                    }
                }
                if (num == 0){
                    break fin;
                }else {
                    throw new DniException();
                }

            } catch (NumberFormatException e) {
                System.out.println("Tiene que ingresar un numero");
            }
        }
        return dni;
    }

    public static String validarLugar(String[] lugaresPermitidos) throws LugaresException {
        String lugar;
        fin:
        while (true) {
            System.out.print("Ingrese el lugar  de destino: ");
            Scanner scanner = new Scanner(System.in);
            lugar = scanner.nextLine();

            int num=0;
            for (int i=0; i<lugaresPermitidos.length ; i++){
                if (lugaresPermitidos[i].equals(lugar)){
                    num++;
                }
            }
            if (num == 0){
                break fin;
            }else {
                throw new LugaresException();
            }

        }
        return lugar;

    }
}

/// el programa se acaba cuando el dni esta baneado o se eberia implementar un nuevo catch

// como llamo a dos exepciones para un mismo metodo
