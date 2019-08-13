package kr.or.yi.hairshop.ui.frame;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public int emailSander() {
		String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
		String user = "kyg0816@naver.com"; //발신자의 이메일 아이디를 입력
		String password = "wjrwjrwjr2896!"; //발신자 이메일의 패스워드를 입력
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
		
        Random random = new Random();
        int CerNumber = random.nextInt(10000);
        
		try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("younggak@gmail.com"));
            message.setSubject("이메일 인증");
            message.setText("인증번호는 "+CerNumber+"입니다");

            Transport.send(message); ////전송
            System.out.println("message sent successfully...");
            
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
		return CerNumber;
		
	}
	
}
