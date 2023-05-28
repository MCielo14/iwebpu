package com.lab4.excepciones;

public class DniException extends Exception{

    @Override
    public String getMessage(){



        return  "El dni se encuentra baneado y no se puede realizar ninguna compra en nuestro sitio web";
    }

    /*

    public DniException(String msg){
        super(msg);
    }

     */

}
