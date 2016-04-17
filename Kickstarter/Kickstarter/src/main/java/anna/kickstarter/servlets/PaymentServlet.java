package anna.kickstarter.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import anna.kickstarter.dao.paymentdao.PaymentDAO;
import anna.kickstarter.domain.Payment;

public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private PaymentDAO paymentDAO;
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Payment payment = new Payment();
        payment.setProject_id(Integer.parseInt(req.getParameter("project_id")));
        payment.setCardholderName(req.getParameter("cardholder_name"));
        payment.setCardNumber(req.getParameter("card_number"));
        payment.setAmount(Integer.parseInt(req.getParameter("amount")));
        paymentDAO.insertPayment(payment);
        resp.sendRedirect("project?projectId=" + payment.getProject_id());
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String projectIdStr = req.getParameter("projectId");
        int projectId = 0;
        try {
            projectId = Integer.parseInt(projectIdStr);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
        List<Payment> payments = new ArrayList<>();
        try {
            payments.add((Payment) paymentDAO.getPaymentsById(projectId));//TODO ????? cast
        } catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("payment", payments);
        req.setAttribute("projectId", projectId);
        getServletContext().getRequestDispatcher("/Payment.jsp").forward(req, resp);
        
    }
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
