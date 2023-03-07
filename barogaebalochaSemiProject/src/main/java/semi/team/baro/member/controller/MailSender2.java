package semi.team.baro.member.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender2 {
	
	public String sendMail(String email) {
		boolean result = false;
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smpt.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						PasswordAuthentication pa = new PasswordAuthentication("adiduckhoo", "xfgnztsshoqcqpwc");
						return pa;
					}
				}
		);
		
		MimeMessage msg = new MimeMessage(session);
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<8; i++) {
			int flag = r.nextInt(3);
			if(flag == 0) {
				int randomNumber = r.nextInt(10);
				sb.append(randomNumber);
			}else if(flag == 1) {
				char randomChar = (char)(r.nextInt(26)+65);
				sb.append(randomChar);
			}else if(flag == 2) {
				char randomChar = (char)(r.nextInt(26)+97);
				sb.append(randomChar);
			}
		}
		
		try {
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress("adiduckhoo@gmail.com","풋살데이트"));
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("풋살데이트 임시비밀번호입니다","utf-8");
			msg.setContent("<h1>안녕하세요. 풋살데이트입니다.</h1>"
					+"<h3>임시비밀번호는 [<span style='color:red;'>"
					+sb.toString()
					+"</span>]입니다.</h3><br>"
					+"<p>반드시 로그인 후 비밀번호를 변경해주시기 바랍니다.</p>"
					,"text/html;charset=utf-8");
			Transport.send(msg);
			result=true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result) {
			return sb.toString();
		}else {
			return null;			
		}
	}
}
