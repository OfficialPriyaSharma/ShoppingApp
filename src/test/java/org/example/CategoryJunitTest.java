package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertTrue;

public class CategoryJunitTest {

    static CategoryDAO categoryDAO;

    @BeforeClass

    public static void executeFirst()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("org.example");
        context.refresh();

        categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
    }

    @Test

    public void addCategoryTest()
    {
        Category_Model category_model = new Category_Model();

        category_model.setCategoryName("T-Shirt");
        category_model.setCategoryDesc("All variety of T-shirt");

        assertTrue("Problem in adding Category",categoryDAO.addCategory(category_model));
    }
}
