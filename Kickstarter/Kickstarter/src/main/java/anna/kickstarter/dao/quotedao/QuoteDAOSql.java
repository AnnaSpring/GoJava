package anna.kickstarter.dao.quotedao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import anna.kickstarter.dao.HibernateUtil;
import anna.kickstarter.domain.Quote;

@Repository
public class QuoteDAOSql implements QuoteDAO {

    public Quote getRandomQuote() {      
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(Quote.class, 1);
    }


}
