package io.programming4food.poh.models;


import java.sql.Date;

enum TipoPersona{
    FISICA,
    MORAL
}

public class Factura {
    String RFC;
    TipoPersona tipoPersona;
    Integer numeroTienda;
    String rfcEmail;
    Date fechaEntrega;
}
