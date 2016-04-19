package anna.kickstarter.dao.categorydao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.springframework.stereotype.Repository;

import anna.kickstarter.dao.HibernateUtil;
import anna.kickstarter.domain.Category;

@Repository
public class CategoryDAOSql implements CategoryDAO {

    @Override
    public Category getCategory(int categoryId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();        
        return session.get(Category.class, categoryId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getCategories(){
        //List<Category> categories = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        ThreadLocalSessionContext.bind(session);
        
        return (List<Category>) sessionFactory.getCurrentSession()
                .createCriteria(Category.class).list();
    }
}
