package com.etiya.ecommerce.api.controllers;

import com.etiya.ecommerce.core.utils.result.DataResult;
import com.etiya.ecommerce.services.concretes.ProductManager;
import com.etiya.ecommerce.services.dtos.requests.product.AddProductRequest;
import com.etiya.ecommerce.services.dtos.requests.product.DeleteProductRequest;
import com.etiya.ecommerce.services.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommerce.services.dtos.responses.product.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {

    private ProductManager productManager;

    @GetMapping("")
    public DataResult<List<ListProductResponse>> getAll() {
        return productManager.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetByIdProductResponse> getById(@PathVariable Integer id) {
        return productManager.getById(id);
    }

    @PostMapping("/save")
    public DataResult<AddProductResponse> add(@Valid @RequestBody AddProductRequest addProductRequest) {
        return productManager.add(addProductRequest);
    }

    @PutMapping("{id}")
    public DataResult<UpdateProductResponse> updateProduct(@PathVariable int id,
                                                           @RequestBody UpdateProductRequest request) {
       return productManager.updateProduct(id, request);
    }

    @PostMapping("/delete")
    public DataResult<DeleteProductResponse> deleteProduct(@Valid @RequestBody DeleteProductRequest deleteProductRequest) {
        return productManager.deleteProduct(deleteProductRequest);
    }


}
