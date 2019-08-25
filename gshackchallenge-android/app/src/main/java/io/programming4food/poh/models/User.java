package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

public class User {

    @SerializedName("Nombre") @Attribute(name ="Nombre" , required = false)
    String nombre;
    @SerializedName("Apellidos") @Attribute(name ="Apellidos" , required = false)
    String apellidos;
    @SerializedName("Email") @Attribute(name ="Email" , required = false)
    String email;
    @SerializedName("Telefono") @Attribute(name ="Telefono" , required = false)
    String telefono;

}
