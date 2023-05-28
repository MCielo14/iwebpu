package com.lab4.bean;

public class Pasaje {

    private String nombre;
    private String dni;
    private String lugarDestino;

    public void imprimirResumenPasajero(Pasaje pasaje){
        System.out.println("********************** RESUMEN DEL PASAJE *****************************");

        System.out.println("Nombre: "+ pasaje.getNombre());
        System.out.println("Lugar de destino: "+ pasaje.getLugarDestino());
        System.out.println("Dni: " + pasaje.getDni());

        System.out.println("************************************************************************");

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

}
