package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

public class Marca {
    @SerializedName("id") @Attribute(name ="id" , required = false)
    Integer id;
    @SerializedName("name") @Attribute(name ="name" , required = false)
    String name;
    @SerializedName("isActive") @Attribute(name ="isActive" , required = false)
    Boolean isActive;
    @SerializedName("title") @Attribute(name ="title" , required = false)
    String title;
    @SerializedName("metaTagDescription") @Attribute(name ="metaTagDescription" , required = false)
    String metaTagDescription;
    @SerializedName("imgUrl") @Attribute(name ="imgUrl" , required = false)
    String imgUrl;

}
