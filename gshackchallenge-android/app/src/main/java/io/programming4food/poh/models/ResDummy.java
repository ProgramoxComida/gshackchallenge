package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

public class ResDummy<T> {

    @SerializedName("status") @Attribute(name ="status" , required = false)
    Boolean status;
    @SerializedName("data") @Attribute(name ="data" , required = false)
    T data;

    @Override
    public String toString() {
        return "ResDummy{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
