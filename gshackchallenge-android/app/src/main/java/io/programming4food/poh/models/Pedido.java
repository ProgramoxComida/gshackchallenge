package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
    @SerializedName("id") @Attribute(name ="id" , required = false)
    String id;
    @SerializedName("created_at") @Attribute(name ="created_at" , required = false)
    Date created_at;
    @SerializedName("items") @Attribute(name ="items" , required = false)
    List<ItemsPedido> items;
}
