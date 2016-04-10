package anna.kickstarter.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import anna.kickstarter.domain.Project;
import anna.kickstarter.projectdao.ProjectDAO;

public class ProjectDetailsServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    @Autowired
    private ProjectDAO projectDAO;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String projectIdStr = req.getParameter("projectId");
        int projectId = 0;
        try {
            projectId = Integer.parseInt(projectIdStr);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
        Project project = null;
        try {
            project = projectDAO.getProjectById(projectId);
        } catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("project", project);
        getServletContext().getRequestDispatcher("/ProjectDetails.jsp").forward(req, resp);
        
    }
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
