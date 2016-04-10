package anna.kickstarter.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import anna.kickstarter.dao.categorydao.CategoryDAO;
import anna.kickstarter.domain.Category;

public class CategoriesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CategoryDAO categoryDAO;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        List<Category> categories = new ArrayList<>();
        categories = categoryDAO.getCategories();
        req.setAttribute("categories", categories);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Categories.jsp");
        dispatcher.forward(req, resp);
    }
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
