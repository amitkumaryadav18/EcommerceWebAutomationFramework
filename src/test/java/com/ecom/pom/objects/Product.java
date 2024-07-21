package com.ecom.pom.objects;

import com.ecom.pom.utils.JacksonUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.io.IOException;

@Setter
@Getter
@Builder
@Jacksonized
public class Product {
    private int id;
    private String name;

    public static Product fetchProduct(int id) throws IOException{
        Product[] products = JacksonUtils.deserializeJson("products.json", Product[].class);
        for(Product product: products){
            if(product.getId() == id){
                return product;
            }
        }
        return products[0];
    }
}
