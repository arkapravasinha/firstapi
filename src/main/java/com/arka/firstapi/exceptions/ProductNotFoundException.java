package com.arka.firstapi.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(Long id)
    {
        super("Product Id:"+id+"Not Found ind DB");
    }

    public ProductNotFoundException(Long id,Throwable err)
    {
        super("Product Id:"+id+"Not Found ind DB",err);
    }
}
