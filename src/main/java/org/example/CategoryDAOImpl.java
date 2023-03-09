package org.example;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    SessionFactory sessionFactory;

    public boolean addCategory(Category_Model category_model) {
        try
        {
            sessionFactory.getCurrentSession().save(category_model);
            return true;
        }

        catch(Exception e)
        {
            return false;
        }
    }

    public boolean deleteCategory(Category_Model category_model) {
        try
        {
            sessionFactory.getCurrentSession().delete(category_model);
            return true;
        }

        catch(Exception e)
        {
            return false;
        }
    }

    public boolean updateCategory(Category_Model category_model) {
        try
        {
            sessionFactory.getCurrentSession().update(category_model);
            return true;
        }

        catch(Exception e)
        {
            return false;
        }
    }

    public List<Category_Model> listCategories() {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Category");
        List<Category_Model> listCategories = query.list();
        session.close();
        return listCategories;
    }

    public Category_Model getCategory(int categoryId) {

        Session session = sessionFactory.openSession();
        Category_Model category_model = session.get(Category_Model.class, categoryId);
        return null;
    }
}
