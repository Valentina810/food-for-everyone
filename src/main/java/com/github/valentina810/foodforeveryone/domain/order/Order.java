package com.github.valentina810.foodforeveryone.domain.order;

import java.util.Date;

public class Order {
    private Long id;
    private Long idUser;
    private Long idStatusOrder;
    private String deliveryAddress;
    private Date deliveryDate;
    private StatusOrder status;
}