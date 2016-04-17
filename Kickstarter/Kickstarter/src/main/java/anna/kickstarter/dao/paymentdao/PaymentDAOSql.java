package anna.kickstarter.dao.paymentdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import anna.kickstarter.domain.Payment;

@Repository
public class PaymentDAOSql implements PaymentDAO {
    @Autowired
    private DataSource dataSource;
    private static final String SELECT_PAYMENT_DATA = "SELECT cardholder_name, card_number, amount FROM payment WHERE project_id=?";
    private static final String INSERT_PAYMENT_DATA = "INSERT INTO payment (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";

    @Override
    public void insertPayment(Payment payment) {
        try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT_DATA)){
            statement.setInt(1, payment.getProject_id());
            statement.setString(2, payment.getCardholderName());
            statement.setString(3, payment.getCardNumber());
            statement.setInt(4, payment.getAmount());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    @Override
    public List<Payment> getPaymentsById(int projectId) {
        List<Payment> payments = new ArrayList<>();
        Payment payment = new Payment();
        try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_PAYMENT_DATA)){
            statement.setInt(1, projectId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String cardholderName = rs.getString("cardholder_name");
                String cardNumber = rs.getString("card_number");
                int amount = rs.getInt("amount");
                payment.setId(id);
                payment.setCardholderName(cardholderName);
                payment.setCardNumber(cardNumber);
                payment.setAmount(amount);
                payments.add(payment);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return payments;
    }


}
