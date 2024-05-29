package notification;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotification implements INotification {

	@Override
	public void SendNotification(String MessageApp) {
		// TODO Auto-generated method stub
		final String mail="bonsoincentre.info@gmail.com";
		final String pass="ijfblvadxezpluiz";
		
		Properties props= new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mail, pass);
            }
        });
        
        try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bonsoincentre.info@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("okhelifi1998@gmail.com"));
			message.setSubject("ProjectDS");
			message.setText("Dear Mail BONSOINS,"+"\n\n"+MessageApp);
			
			Transport.send(message);
			
			System.out.println("Email Notification DONE");
		} catch (MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
