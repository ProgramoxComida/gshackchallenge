package io.programming4food.poh.models;

import java.util.List;

public class StatusPedido {
    String id;
    String pedido_id;
    List<Eventos> events;
}

class Eventos{
    String message;
    String receive;
}
/*
"id": "TRK-0000002",
      "pedido_id": "EKT-0000002",
      "status": "Entregado",
      "events": [
        {
          "message": "Paquete entregado a recepcion",
          "receive": "Martin Iglesias"
        }
      ]
 */