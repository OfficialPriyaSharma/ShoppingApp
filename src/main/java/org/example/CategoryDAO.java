package org.example;

import java.util.List;

public interface CategoryDAO {

    public boolean addCategory(Category_Model category_model);
    public boolean deleteCategory(Category_Model category_model);
    public boolean updateCategory(Category_Model category_model);

    public List<Category_Model> listCategories();
    public Category_Model getCategory(int categoryId);

}
