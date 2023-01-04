package com.ligong.poi.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章管理对象 cms_blog
 *
 * @author ning
 * @date 2022-01-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Double price;

    private Integer stock;

}
