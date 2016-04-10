package anna.kickstarter.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import anna.kickstarter.dao.categorydao.CategoryDAO;
import anna.kickstarter.dao.projectdao.ProjectDAO;
import anna.kickstarter.domain.Category;
import anna.kickstarter.domain.Project;

public class ProjectsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProjectDAO projectDAO;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String categoryIdStr = req.getParameter("categoryId");
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(categoryIdStr);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Category category = null;
        try {
            category = categoryDAO.getCategory(categoryId);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
        List<Project> projects = projectDAO.getProjectsByCategoryId(categoryId);
        
        req.setAttribute("category", category);
        req.setAttribute("projects", projects);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Projects.jsp");
        dispatcher.forward(req, resp);
    }
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
