package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(strict = false)
public class Categoria implements Serializable {

    @SerializedName("parentId") @Attribute(name ="parentId" , required = false)
    Integer parentId;
    @SerializedName("GlobalCategoryId") @Attribute(name ="GlobalCategoryId" , required = false)
    Integer globalCategoryId;
    @SerializedName("GlobalCategoryName") @Attribute(name ="GlobalCategoryName" , required = false)
    String globalCategoryName;
    @SerializedName("id") @Attribute(name ="id" , required = false)
    Integer id;
    @SerializedName("name") @Attribute(name ="name" , required = false)
    String name;
    @SerializedName("hasChildren") @Attribute(name ="hasChildren" , required = false)
    Boolean hasChildren;
    @SerializedName("url") @Attribute(name ="url" , required = false)
    String url;
    @SerializedName("children") @Attribute(name ="children" , required = false)
    List<Categoria> children;
    @SerializedName("Title") @Attribute(name ="Title" , required = false)
    String title;
    @SerializedName("MetaTagDescription") @Attribute(name ="MetaTagDescription" , required = false)
    String metaTagDescription;

    @Override
    public String toString() {
        return "Categoria{" +
                "parentId=" + parentId +
                ", globalCategoryId=" + globalCategoryId +
                ", globalCategoryName='" + globalCategoryName + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", hasChildren=" + hasChildren +
                ", url='" + url + '\'' +
                ", children=" + children +
                ", title='" + title + '\'' +
                ", metaTagDescription='" + metaTagDescription + '\'' +
                '}';
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getGlobalCategoryId() {
        return globalCategoryId;
    }

    public void setGlobalCategoryId(Integer globalCategoryId) {
        this.globalCategoryId = globalCategoryId;
    }

    public String getGlobalCategoryName() {
        return globalCategoryName;
    }

    public void setGlobalCategoryName(String globalCategoryName) {
        this.globalCategoryName = globalCategoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Categoria> getChildren() {
        return children;
    }

    public void setChildren(List<Categoria> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTagDescription() {
        return metaTagDescription;
    }

    public void setMetaTagDescription(String metaTagDescription) {
        this.metaTagDescription = metaTagDescription;
    }
}

/*
        {
    "parentId": null,
    "GlobalCategoryId": 77,
    "GlobalCategoryName": "Instrumentos de corda",
    "id": 1,
    "name": "Automotriz y Ferretería",
    "hasChildren": true,
    "url": "https://elektraqapre.vtexcommercestable.com.br/automotriz-y-ferreteria",
    "children": null,
    "Title": "Automotriz | Elektra online",
    "MetaTagDescription": "Compra artículos de automotríz, accesorios para auto, llantas y rines sin salir de casa y con envío gratis. Sólo en Elektra online."
}
*/