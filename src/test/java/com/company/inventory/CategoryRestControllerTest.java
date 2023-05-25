package com.company.inventory;

import com.company.inventory.controller.CategoryRestController;
import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;
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

public class CategoryRestControllerTest {

    @InjectMocks
    CategoryRestController categoryRestController;

    @Mock
    private ICategoryService service;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        when(service.save(any(Category.class))).thenReturn(
                new ResponseEntity<CategoryResponseRest>(HttpStatus.CREATED)
        );
        ResponseEntity<CategoryResponseRest> response = categoryRestController.save(category);

        assertThat(response.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void updateTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        when(service.update(any(Category.class), any(Long.class))).thenReturn(
                new ResponseEntity<CategoryResponseRest>(HttpStatus.OK)
        );
        ResponseEntity<CategoryResponseRest> response = categoryRestController.update(category, Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void deleteTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        when(service.deleteById(any(Long.class))).thenReturn(
                new ResponseEntity<CategoryResponseRest>(HttpStatus.OK)
        );

        ResponseEntity<CategoryResponseRest> response = categoryRestController.delete(Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void searchById(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category();
        category.setId(Long.valueOf(1));
        category.setName("Lacteos");
        category.setDescription("producto derivado de la leche");

        when(service.searchById(any(Long.class))).thenReturn(
                new ResponseEntity<CategoryResponseRest>(HttpStatus.OK)
        );

        ResponseEntity<CategoryResponseRest> response = categoryRestController.searchCategoriesById(Long.valueOf(1));

        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

    }

}
