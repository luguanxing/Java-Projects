package javamail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo {

	public static void main(String[] args) throws Exception {
		//使用163邮箱发送一封邮件
		String username = "username";	//帐号用户名
		String password = "password";			//帐号密码
		String emailAddressName = username + "@163.com";	//邮箱帐号,一般是username+"@163.com"
		String authorizationCode = "authorizationCode";		//邮箱帐号授权码，要在163邮箱申请打开SMTP服务后填写
		String targetEmail = "targetEmail";
		
		//准备环境
		Properties props = new Properties();
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
	    Session session = Session.getDefaultInstance(props, new Authenticator() {  
	        //认证信息，需要提供"用户账号","授权码"  
	        public PasswordAuthentication getPasswordAuthentication() {  
	          return new PasswordAuthentication(emailAddressName, authorizationCode);  
	        }  
	      });  
		
		//准备信件
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(emailAddressName));	//这里内容的收件人理论上可以不和实际发件人一样，但不一样163邮箱无法发出
		msg.setText("java的邮件");
		msg.setSubject("subject");
		msg.setSentDate(new Date());
		
		//发送信件
		Transport transport = session.getTransport();
		transport.connect("smtp.163.com", 25, username, password);
		transport.sendMessage(msg, new Address[]{new InternetAddress(targetEmail)});
		transport.close();
		
	}
	
}
