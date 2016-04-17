package anna.kickstarter.dao.paymentdao;

import java.util.List;

import anna.kickstarter.domain.Payment;

public interface PaymentDAO {
    public void insertPayment(Payment payment);
    public List<Payment> getPaymentsById(int projectId);
}
