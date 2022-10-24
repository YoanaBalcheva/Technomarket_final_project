package com.example.technomarket.contoller;

import com.example.technomarket.model.dto.product.*;
import com.example.technomarket.model.exceptions.BadRequestException;
import com.example.technomarket.model.pojo.Product;
import com.example.technomarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ProductResponseDTO addProduct(@RequestBody AddProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PostMapping("/delete/{pid}")
    public ProductResponseDTO deleteProduct(@PathVariable long pid){
        return productService.deleteProduct(pid);
    }

    @PostMapping("/addToCart/{pid}")
    public ProductInCartDTO addToCart(@PathVariable long pid, @RequestBody AddProductToCartDTO addProductToCartDTO){
        return productService.addToCart(addProductToCartDTO, pid);
    }

    @GetMapping("/search/{product}")
    public ProductForClientDTO searchForProductByName(@PathVariable String product){
        return productService.searchForProductByName(product);
    }

    @GetMapping("/sortAsc/{subcategory}")
    public List<ProductForClientDTO> sortProductsAscending(@PathVariable String subcategory){
        return productService.sortProductsAscending(subcategory);
    }

    @GetMapping("/sortDesc/{subcategory}")
    public List<ProductForClientDTO> sortProductsDescending(@PathVariable String subcategory){
        return productService.sortProductsDescending(subcategory);
    }
}
