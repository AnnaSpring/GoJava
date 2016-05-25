package anna.kickstarter.dao.quotedao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import anna.kickstarter.domain.Quote;

@Repository
public class QuoteDAOSql implements QuoteDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public Quote getRandomQuote() {
        return em.find(Quote.class, 1);
    }
}
