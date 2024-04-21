import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class main {
    public static void main(String[] args) {
        // Thông tin tài khoản email của bạn
        String host = "smtp.gmail.com";
        String username = "";// email gửi
        String password = "";// mật khẩu
        String fromAddress = "";// email gửi
        String toAddress = "";// email nhận

        // Cấu hình thông tin về mail server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            message.setSubject("Kiểm tra gửi mail."); //nội dung thông báo
            message.setText("Eban Test mail java.");// nội dung đoạn mail

            // Gửi email
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

// truy cập link này để bật kém an toàn lên
//https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4Ow44SXf35hCyKml_Wvxx4CZ-E10XnkWDgijsWXH_fqrY-tZ020cFmZuyd9bVLnL8c1u92lDv4lHwVmfdD9uQkmPS6p7WwsqCcHVRlFBXK806Ingds