package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.util.List;
import java.util.Map;

public class ProductsAndSKUS {
    @SerializedName("data") @Attribute(name ="data" , required = false)
    Map<String, List<Integer>> data;
    @SerializedName("range") @Attribute(name ="range" , required = false)
    Range range;
}

class Range{
    @SerializedName("total") @Attribute(name ="total" , required = false)
    Integer  total;
    @SerializedName("from") @Attribute(name ="from" , required = false)
    Integer from;
    @SerializedName("to") @Attribute(name ="to" , required = false)
    Integer to;
}
