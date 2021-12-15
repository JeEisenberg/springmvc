package com.gavin.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * bookstore
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookstore implements Serializable {
    private Integer bookid;

    private String bookname;

    private String bookpublish;

    private Double bookprice;

    private String bookkind;

    private Integer bookcount;

    private static final long serialVersionUID = 1L;
}