package anna.kickstarter.dao.quotedao;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import anna.kickstarter.dao.HibernateUtil;
import anna.kickstarter.domain.Quote;

@Repository
public class QuoteDAOSql implements QuoteDAO {

    public Quote getRandomQuote() {      
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Quote result = null;  // will later contain a random entity
        Criteria crit = session.createCriteria(Quote.class);
        crit.setProjection(Projections.rowCount());
        int count = ((Number) crit.uniqueResult()).intValue();
        if (count != 0) {
            int index = new Random().nextInt(count);
            crit = session.createCriteria(Quote.class);
            result = (Quote)(crit.setFirstResult(index).setMaxResults(1).uniqueResult());
            session.close();
        }
        return result;
    }
}
