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
import java.util.Date;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class SendMailUltil {

    public String sendEmail(String toEmail, String subject, String body) {

        final String username = "reset.mwcstore@gmail.com";
        final String password = "pdcehhhjsvwnrfrr";

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
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("reset.mwcstore@gmail.com", "[MWC STORE]"));

            msg.setReplyTo(InternetAddress.parse("reset.mwcstore@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("Successfully!!");
            return "Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed!";
        }
    }

    public static void main(String[] args) {
        SendMailUltil smu = new SendMailUltil();
        smu.sendEmail("huongvnph27229@fpt.edu.vn", "Hướng đẹp trai", "Vũ Nguyên Hướng\n Lại Thị Kim Chi\n Vũ Thị Kim Chi\n Lại Nguyên Hướng");
    }
}
