package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

public class Profile {

    String Nombre;
    String Apellidos;
    String Email;
    String Telefono;
    @SerializedName("Direccion") @Attribute(name ="Direccion" , required = false)
    DireccionP Direccion;
    @SerializedName("Pedidos") @Attribute(name ="Pedidos+" , required = false)
    String[] pedidosIds;
}


class DireccionP{
    String Calle;
    String NumExt;
    String NumInt;
    String CP;
    String Referencia;
}