package com.ecommerce.onlineshopping.service;

import com.ecommerce.onlineshopping.repository.ProductRepository;
import com.ecommerce.onlineshopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String saveProduct(Product product) {
		if(product == null) {
			throw new IllegalArgumentException("Product cannot be null");
		}
        productRepository.saveAndFlush(product);
        return "Product Added Sucessfully";
    }

    @Override
    public List<Product> findAllProducts() {
        try {
            List<Product> products = new ArrayList<>();
            List<Product> productsCopy = new ArrayList<>();
            productRepository.findAll().forEach(products::add);
            productsCopy.addAll(products);
            for (Product p : products) {
                if (!p.isActive()) {
                    productsCopy.remove(p);
                }
            }
            return productsCopy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Product findProductById(Integer id) {
		if(id == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
        Product product;
        try {
            product = productRepository.getOne(id);
        } catch (EntityNotFoundException e) {
            return null;
        }

        if (!product.isActive())
            product = null;

        return product;
    }

    @Override
    public String deleteProduct(Integer id) {
    	if(id == null) {
    		throw new IllegalArgumentException("Id cannot be null");
		}

		Product product;
        try {
            product = productRepository.getOne(id);
        } catch (EntityNotFoundException e) {
            return "Product Deletion Failed";
        }

        product.setActive(false);
        productRepository.saveAndFlush(product);
        return "Product Deleted Sucessfully";
    }

    @Override
    public String updateProduct(Product product) {
        productRepository.saveAndFlush(product);
        return "Product Updated Sucessfully";
    }

    @Override
    public List<Product> findProductByCategoryId(Integer categoryId) {
        List<Product> products = new ArrayList<>();
        List<Product> productsCopy = new ArrayList<>();
        productRepository.findProductByCategoryId(categoryId).forEach(products::add);
        productsCopy.addAll(products);
        for (Product p : products) {
            if (!p.isActive()) {
                productsCopy.remove(p);
            }
        }
        return productsCopy;
    }

    @Override
    public List<Product> findAllProductsForAdmin() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product findProductByIdForAdmin(int id) {
        Product product = productRepository.getOne(id);
        return product;
    }

}
