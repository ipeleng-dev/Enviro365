package com.enviro.assessment.grad001.ipelenglebelo.demo.Controller;

import com.enviro.assessment.grad001.ipelenglebelo.demo.DataTranfereObject.ProductDto;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.AddProductsRequest;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Services.InvestorService;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private InvestorService investorService;

    // Create a new product(delete)
        @PostMapping("/add-products")
    public ResponseEntity<String> addProductsToInvestor(@RequestBody AddProductsRequest request) {
        // Retrieve the investor by ID
        Investor investor = investorService.getInvestorById(request.getInvestorId());

        if (investor == null) {
            return new ResponseEntity<>("Investor not found", HttpStatus.NOT_FOUND);
        }

        // Create or update products associated with the investor
        productService.addProductsToInvestor(investor, request.getProducts());

        return new ResponseEntity<>("Products added to investor", HttpStatus.CREATED);
    }

    // Create a new product
    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        // Fetch the investor by ID
        Investor investor = investorService.getInvestorById(productDto.getInvestorId());

        if (investor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Convert ProductDto to Product entity
        Product product = new Product();
        product.setName(productDto.getName());
        product.setType(productDto.getType());
        product.setCurrentBalance(productDto.getCurrentBalance());
        product.setStartDate(productDto.getStartDate());
        product.setEndDate(productDto.getEndDate());
        product.setInvestor(investor); // Associate the product with the investor

        // Save the product to the database
        Product savedProduct = productService.saveProduct(product);

        // Convert the saved Product back to ProductDto for the response
        ProductDto savedProductDto = new ProductDto();
        savedProductDto.setName(savedProduct.getName());
        savedProductDto.setType(savedProduct.getType());
        savedProductDto.setCurrentBalance(savedProduct.getCurrentBalance());
        savedProductDto.setStartDate(savedProduct.getStartDate());
        savedProductDto.setEndDate(savedProduct.getEndDate());

        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    // Retrieve a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id) {
        Optional<Product> product = Optional.ofNullable(productService.getProductById(id));
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        // Convert the list of Product entities to a list of ProductDto
        List<ProductDto> productDtos = products.stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto();
                    productDto.setName(product.getName());
                    productDto.setType(product.getType());
                    productDto.setCurrentBalance(product.getCurrentBalance());
                    productDto.setStartDate(product.getStartDate());
                    productDto.setEndDate(product.getEndDate());


                    // Fetch investor details and populate the DTO
                    Investor investor = product.getInvestor();
                    if (investor != null) {
                        productDto.setInvestorFirstName(investor.getName());
                        productDto.setInvestorLastName(investor.getLastName());
                        productDto.setDateOfBirth(investor.getDateOfBirth());
                    }

                    return productDto;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

}
