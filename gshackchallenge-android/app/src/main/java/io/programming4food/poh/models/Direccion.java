package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Direccion implements Serializable {

    @SerializedName("nombreDeQuienRecibe") @Attribute(name ="nombreDeQuienRecibe" , required = false)
    String nombreDeQuienRecibe;
    @SerializedName("calle") @Attribute(name ="calle" , required = false)
    String calle;
    @SerializedName("referencia") @Attribute(name ="referencia" , required = false)
    String referencia;
    @SerializedName("numeroExterior") @Attribute(name ="numeroExterior" , required = false)
    String numeroExterior;
    @SerializedName("numeroInterior") @Attribute(name ="numeroInterior" , required = false)
    String numeroInterior;
    @SerializedName("codigoPostal") @Attribute(name ="codigoPostal" , required = false)
    String codigoPostal;
}
