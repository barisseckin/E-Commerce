package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.core.concretes.DataResult;
import com.eCommerceProject.core.concretes.ErrorResult;
import com.eCommerceProject.core.concretes.SuccessDataResult;
import com.eCommerceProject.dataAccess.abstracts.ProductDao;
import com.eCommerceProject.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public void add(Product product) {

        if(product.getProductPrice() <= 0) {
            new ErrorResult("Urun Fiyati 0 dan Kucuk Olamaz!");
        }
        else if(product.getStock() <= 0) {
            new ErrorResult("urun Stok adedi 0 dan kucuk olamaz");
        }
        else {
            new SuccessDataResult<Product>("Urun Basariyla Eklendi");
        }

    }

    @Override
    public List<Product> getByproductName(String productName) {
        return this.productDao.getByproductName(productName);
    }

    @Override
    public List<Product> getByproductBrand(String productBrand) {
       return this.productDao.getByproductBrand(productBrand);
    }

    @Override
    public void deleteById(int id) {
        this.productDao.deleteById(id);
    }
}
