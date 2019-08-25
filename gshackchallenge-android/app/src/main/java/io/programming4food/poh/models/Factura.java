package io.programming4food.poh.models;


import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.sql.Date;

enum TipoPersona{
    FISICA("Fisica"),
    MORAL("Moral");
    public final String val;
    TipoPersona(String val){
        this.val = val;
    }
}

public class Factura {
    @SerializedName("RFC") @Attribute(name ="RFC" , required = false)
    String RFC;
    @SerializedName("tipoPersona") @Attribute(name ="tipoPersona" , required = false)
    TipoPersona tipoPersona;
    @SerializedName("numeroTienda") @Attribute(name ="numeroTienda" , required = false)
    Integer numeroTienda;
    @SerializedName("rfcEmail") @Attribute(name ="rfcEmail" , required = false)
    String rfcEmail;
    @SerializedName("fechaEntrega") @Attribute(name ="fechaEntrega" , required = false)
    Date fechaEntrega;
}
