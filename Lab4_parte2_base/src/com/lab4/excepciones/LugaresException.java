package com.lab4.excepciones;

public class LugaresException extends Exception{

    @Override
    public String getMessage(){
        return  "El lugar actualmente no se encuentra disponible para la compra de vuelos";
    }
}
