package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Nombre")
    String nombre;
    @SerializedName("Apellidos")
    String apellidos;
    @SerializedName("Email")
    String email;
    @SerializedName("Telefono")
    String telefono;

}
