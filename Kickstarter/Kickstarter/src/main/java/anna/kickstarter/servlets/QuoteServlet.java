package anna.kickstarter.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import anna.kickstarter.domain.Quote;
import anna.kickstarter.quotedao.QuoteDAO;

public class QuoteServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    @Autowired
    private QuoteDAO quoteDAO;
    

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            
        Quote quote = quoteDAO.getRandomQuote();
        req.setAttribute("quote", quote);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Quote.jsp");
        dispatcher.forward(req, resp);
        
        
        
        /*PrintWriter pw = resp.getWriter();
        pw.println("<H1>" + quote + "</H1>");*/
    }
    
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
