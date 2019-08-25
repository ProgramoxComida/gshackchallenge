package io.programming4food.poh.models;


import java.io.Serializable;

class Imagenes implements Serializable {
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
