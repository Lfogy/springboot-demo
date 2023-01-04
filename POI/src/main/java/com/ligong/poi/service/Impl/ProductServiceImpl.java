package com.ligong.poi.service.Impl;

import com.ligong.poi.domain.Product;
import com.ligong.poi.mapper.ProductMapper;
import com.ligong.poi.service.ProductService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectAll() {
        List<Product> product = productMapper.selectAll();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("product");
        return null;
    }
}
