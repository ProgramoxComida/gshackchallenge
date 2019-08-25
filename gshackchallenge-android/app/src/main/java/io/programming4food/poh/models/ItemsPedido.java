package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

class ItemsPedido implements Serializable {

    @SerializedName("sku") @Attribute(name ="sku" , required = false)
    Integer sku;
    @SerializedName("brand") @Attribute(name ="brand" , required = false)
    String brand;
    @SerializedName("sku_name") @Attribute(name ="sku_name" , required = false)
    String sku_name;

}
