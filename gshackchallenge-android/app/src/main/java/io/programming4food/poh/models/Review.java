package io.programming4food.poh.models;

import java.io.Serializable;

public class Review implements Serializable {
    String id;
    Integer produc_id;
    String comment;
    Float rating;
}

/*"id": "RVW-0000004",
    "client_id": "1",
    "product_id": 11,
    "comment": "Bonita antena",
    "rating": 4.5

 */
