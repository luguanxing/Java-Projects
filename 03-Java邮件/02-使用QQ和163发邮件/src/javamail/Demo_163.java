package javamail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo_163 {

	public static void main(String[] args) throws Exception {
		String emailAddressName = "xxx@163.com";	//邮箱帐号,一般是username+"@163.com"
		String authorizationCode = "zzz";		//邮箱帐号授权码，要在163邮箱申请打开SMTP服务后填写
		String targetEmail = "yyy@qq.com";
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");

		Session session = Session.getInstance(props, 
			new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailAddressName, authorizationCode);
				}
			}
		);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(emailAddressName));
		msg.setContent("<h1 style='color:blue'>这辈子不可能打工的</h1>", "text/html;charset=UTF-8");
		msg.setSubject("主题");
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetEmail));
		
		//send内部包含连接发送关闭 sendMessage则只是单独发送
		Transport.send(msg);
	}
	
}
