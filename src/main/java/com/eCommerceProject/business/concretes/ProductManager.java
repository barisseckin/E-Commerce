package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.ProductService;;
import com.eCommerceProject.dataAccess.abstracts.ProductDao;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public void add(ProductCreateDto productCreateDto) {

        this.productDao.save(new Product(productCreateDto.getProductName(), productCreateDto.getProductBrand(),
                productCreateDto.getProductDetails(), productCreateDto.getProductPrice(), productCreateDto.getStock(), productCreateDto.getProductImageUrl()));

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

    @Override
    public List<Product> slice(Pageable pageable) {

        final List<Product> products = this.productDao.findAll(pageable).stream().collect(Collectors.toList());
        return products;

    }

    @Override
    public List<ProductViewDto> getDto() {

        final List<ProductViewDto> products = this.productDao.findAll().stream().map(ProductViewDto :: of).collect(Collectors.toList());
        return products;

    }

}
