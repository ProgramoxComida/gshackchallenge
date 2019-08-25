package io.programming4food.poh.models;

import java.io.Serializable;
import java.util.List;

public class ProductoDetalle implements Serializable {
    String Id;
    String Name;
    Float Price;
    Float ListPrice;
    Boolean Availability;
    List<List<Imagenes>> Images;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public Float getListPrice() {
        return ListPrice;
    }

    public void setListPrice(Float listPrice) {
        ListPrice = listPrice;
    }

    public Boolean getAvailability() {
        return Availability;
    }

    public void setAvailability(Boolean availability) {
        Availability = availability;
    }

    public List<List<Imagenes>> getImages() {
        return Images;
    }

    public void setImages(List<List<Imagenes>> images) {
        Images = images;
    }
}

class Imagenes implements Serializable{
    String IdArchive;
    String Path;
    Boolean IsMain;

    public String getIdArchive() {
        return IdArchive;
    }

    public void setIdArchive(String idArchive) {
        IdArchive = idArchive;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public Boolean getMain() {
        return IsMain;
    }

    public void setMain(Boolean main) {
        IsMain = main;
    }
}