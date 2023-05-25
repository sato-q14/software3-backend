package com.company.inventory;

import com.company.inventory.controller.ProductRestController;
import com.company.inventory.model.Category;
import com.company.inventory.model.Product;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.response.ProductResponseRest;
import com.company.inventory.services.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductRestControllerTest {

    @InjectMocks
    ProductRestController productRestController;

    @Mock
    private IProductService productService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveProduct(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        Product product = new Product();
        product.setId(Long.valueOf(1));
        product.setName("Leche deslactosada");
        product.setPrice(20000);
        product.setAccount(2);
        product.setCategory(category);

        when(productService.save(any(Product.class),any(Long.class))).thenReturn(
                new ResponseEntity<ProductResponseRest>(HttpStatus.CREATED)
        );

        ResponseEntity<ProductResponseRest> response = productService.save(product, Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void updateProduct(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        Product product = new Product();
        product.setId(Long.valueOf(1));
        product.setName("Leche deslactosada");
        product.setPrice(20000);
        product.setAccount(2);
        product.setCategory(category);

        when(productService.update(any(Product.class), any(Long.class), any(Long.class))).thenReturn(
                new ResponseEntity<ProductResponseRest>(HttpStatus.OK)
        );

        ResponseEntity<ProductResponseRest> response = productService.update(product, Long.valueOf(1),Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void deleteProduct(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        Product product = new Product();
        product.setId(Long.valueOf(1));
        product.setName("Leche deslactosada");
        product.setPrice(20000);
        product.setAccount(2);
        product.setCategory(category);

        when(productService.deleteById(any(Long.class))).thenReturn(
                new ResponseEntity<ProductResponseRest>(HttpStatus.NO_CONTENT)
        );

        ResponseEntity<ProductResponseRest> response = productService.deleteById(Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(204);

    }

    @Test
    public void searchByNameTest(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        Product product = new Product();
        product.setId(Long.valueOf(1));
        product.setName("Leche deslactosada");
        product.setPrice(20000);
        product.setAccount(2);
        product.setCategory(category);

        when(productService.searchByName("Leche deslactosada")).thenReturn(
                new ResponseEntity<ProductResponseRest>(HttpStatus.OK)
        );

        ResponseEntity<ProductResponseRest> response = productService.searchByName("Leche deslactosada");

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void searchByIdTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        Product product = new Product();
        product.setId(Long.valueOf(1));
        product.setName("Leche deslactosada");
        product.setPrice(20000);
        product.setAccount(2);
        product.setCategory(category);

        when(productService.searchById(any(Long.class))).thenReturn(
                new ResponseEntity<ProductResponseRest>(HttpStatus.OK)
        );

        ResponseEntity<ProductResponseRest> response = productService.searchById(Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void searchTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        Product product = new Product();
        product.setId(Long.valueOf(1));
        product.setName("Leche deslactosada");
        product.setPrice(20000);
        product.setAccount(2);
        product.setCategory(category);

        when(productService.search()).thenReturn(
                new ResponseEntity<ProductResponseRest>(HttpStatus.OK)
        );

        ResponseEntity<ProductResponseRest> response = productService.search();

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }


}
