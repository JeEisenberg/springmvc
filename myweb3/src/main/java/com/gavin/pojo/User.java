package com.gavin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private String pwd;

    private static final long serialVersionUID = 1L;
}