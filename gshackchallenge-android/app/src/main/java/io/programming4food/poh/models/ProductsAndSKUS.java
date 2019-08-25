package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ProductsAndSKUS implements Serializable {
    @SerializedName("data") @Attribute(name ="data" , required = false)
    Map<String, List<Integer>> data;
    @SerializedName("range") @Attribute(name ="range" , required = false)
    Range range;
}

class Range implements Serializable{
    @SerializedName("total") @Attribute(name ="total" , required = false)
    Integer  total;
    @SerializedName("from") @Attribute(name ="from" , required = false)
    Integer from;
    @SerializedName("to") @Attribute(name ="to" , required = false)
    Integer to;
}
