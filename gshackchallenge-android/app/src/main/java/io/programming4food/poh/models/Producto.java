package io.programming4food.poh.models;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Producto implements Serializable {
    @SerializedName("ID") @Attribute(name ="ID" , required = false)
    Integer ID;
    @SerializedName("Name") @Attribute(name ="Name" , required = false)
    String Name;
    @SerializedName("DepartamentId") @Attribute(name ="DepartamentId" , required = false)
    Integer DepartamentId;
    @SerializedName("CategoryId") @Attribute(name ="CategoryId" , required = false)
    Integer CategoryId;
    @SerializedName("BrandId") @Attribute(name ="BrandId" , required = false)
    Long BrandId;
    @SerializedName("LinkId") @Attribute(name ="LinkId" , required = false)
    String LinkId;
    @SerializedName("RefId") @Attribute(name ="RefId" , required = false)
    String RefId;
    @SerializedName("IsVisible") @Attribute(name ="IsVisible" , required = false)
    Boolean IsVisible;
    @SerializedName("Description") @Attribute(name ="Description" , required = false)
    String Description;
    @SerializedName("DescriptionShort") @Attribute(name ="DescriptionShort" , required = false)
    String DescriptionShort;
    @SerializedName("RelaseNote") @Attribute(name ="RelaseNote" , required = false)
    Date RelaseNote;
    @SerializedName("Keywords") @Attribute(name ="Keywords" , required = false)
    String Keywords;
    @SerializedName("Title") @Attribute(name ="Title" , required = false)
    String Title;
    @SerializedName("IsActive") @Attribute(name ="IsActive" , required = false)
    Boolean IsActive;
    @SerializedName("TaxCode") @Attribute(name ="TaxCode" , required = false)
    String TaxCode;
    @SerializedName("MetaDescription") @Attribute(name ="MetaDescription" , required = false)
    String MetaDescription;
    @SerializedName("SupplierId") @Attribute(name ="SupplierId" , required = false)
    Long SupplierId;
    @SerializedName("ShowWithoutStock") @Attribute(name ="ShowWithoutStock" , required = false)
    Boolean ShowWithoutStock;
    @SerializedName("ListStoreId") @Attribute(name ="ListStoreId" , required = false)
    List<Integer> ListStoreId;
    @SerializedName("AdWordsRemarketingCode") @Attribute(name ="AdWordsRemarketingCode" , required = false)
    Object AdWordsRemarketingCode;
    @SerializedName("LomadeeCampaignCode") @Attribute(name ="LomadeeCampaignCode" , required = false)
    Object LomadeeCampaignCode;


    @Override
    public String toString() {
        return "Producto{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", DepartamentId=" + DepartamentId +
                ", CategoryId=" + CategoryId +
                ", BrandId=" + BrandId +
                ", LinkId='" + LinkId + '\'' +
                ", RefId='" + RefId + '\'' +
                ", IsVisible=" + IsVisible +
                ", Description='" + Description + '\'' +
                ", DescriptionShort='" + DescriptionShort + '\'' +
                ", RelaseNote=" + RelaseNote +
                ", Keywords='" + Keywords + '\'' +
                ", Title='" + Title + '\'' +
                ", IsActive=" + IsActive +
                ", TaxCode='" + TaxCode + '\'' +
                ", MetaDescription='" + MetaDescription + '\'' +
                ", SupplierId=" + SupplierId +
                ", ShowWithoutStock=" + ShowWithoutStock +
                ", ListStoreId=" + ListStoreId +
                ", AdWordsRemarketingCode=" + AdWordsRemarketingCode +
                ", LomadeeCampaignCode=" + LomadeeCampaignCode +
                '}';
    }
}


/*
*
* "Id": 1,
    "Name": "Pantalla LCD Sony 46 Pulgadas HD KDL-46V5100",
    "DepartmentId": 167,
    "CategoryId+": 320,
    "BrandId": 2000000,
    "LinkId": "Pantalla-LCD-Sony-46-Pulgadas-HD-KDL-46V5100-13775",
    "RefId": "13775",
    "IsVisible": true,
    "Description": "",
    "DescriptionShort": "LCD SONY 46 KDL-46V5100..",
    "ReleaseDate": "2018-03-08T00:00:00",
    "KeyWords": "13775,SONY,pantallas,television,televisiones,Televicion,Televiciones, compra de televisores,comprar television,comprar television online,comprar televisor,comprar televisor samsung,ofertas de televisores,pantalla plana,pantallas smart tv baratas,smart tv baratas,teles baratas,televisor 32 pulgadas,televisor 32 pulgadas smart tv,televisor 40,televisor 40 pulgadas smart tv,televisor 40 smart tv,televisor 42,televisor 42 pulgadas,tv led,tv precios,comprar pantalla,comprar pantallas led,pantalla 42 pulgadas,pantalla hd,pantallas smart tv,smart tv mx",
    "Title": "Pantalla LCD Sony 46 Pulgadas HD KDL-46V5100 | Elektra Online",
    "IsActive": true,
    "TaxCode": "",
    "MetaTagDescription": "Encuentra una amplia variedad de artículos directos a la puerta de tu hogar en Elektra Online",
    "SupplierId": null,
    "ShowWithoutStock": true,
    "ListStoreId": [
        1,
        3
    ],
    "AdWordsRemarketingCode": null,
    "LomadeeCampaignCode": null
*
* */