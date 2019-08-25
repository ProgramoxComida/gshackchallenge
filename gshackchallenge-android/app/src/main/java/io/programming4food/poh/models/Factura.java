package io.programming4food.poh.models;


import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;
import java.sql.Date;

public class Factura implements Serializable {
    @SerializedName("RFC") @Attribute(name ="RFC" , required = false)
    String RFC;
    @SerializedName("tipoPersona") @Attribute(name ="tipoPersona" , required = false)
    String tipoPersona;
    @SerializedName("numeroTienda") @Attribute(name ="numeroTienda" , required = false)
    Integer numeroTienda;
    @SerializedName("rfcEmail") @Attribute(name ="rfcEmail" , required = false)
    String rfcEmail;
    @SerializedName("fechaEntrega") @Attribute(name ="fechaEntrega" , required = false)
    Date fechaEntrega;
}
