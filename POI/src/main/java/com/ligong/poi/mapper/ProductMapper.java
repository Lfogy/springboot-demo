package com.ligong.poi.mapper;

import com.ligong.poi.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> selectAll();

}
