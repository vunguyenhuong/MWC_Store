package utilities;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import java.util.Properties;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class SendMailUltil {

    public String sendMail(String email, String newPassWord) {
        final String username = "reset.mwcstore@gmail.com";
        final String password = "gialpqmuyhqulten";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("reset.mwcstore@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("[MWC_STORE] Mat khau da duoc dat lai!");
            message.setText("Xin chao, mat khau moi cua ban la: " + newPassWord);

            Transport.send(message);

            System.out.println("Done");
            return "Mật khẩu đã được đặt lại! Vui lòng kiểm tra Email!!!";
        } catch (MessagingException e) {
//            e.printStackTrace();
            return "Email không tồn tại!";
        }
    }
}
