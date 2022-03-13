package io.kimmking.javacourse.demo.entity;

import lombok.Data;

@Data
public class InsertDataEntity {
    private int idOrder;//订单id
    private String idProduct;//商品编号
    private String productName;//商品名称
    private Double productPrice;//商品价格
    private String productMarque;//商品型号

}
