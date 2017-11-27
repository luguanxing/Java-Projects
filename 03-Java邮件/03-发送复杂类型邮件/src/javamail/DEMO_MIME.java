package javamail;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class DEMO_MIME {

	public static void main(String[] args) throws Exception {
		String emailAddressName = "xxx@qq.com";		//邮箱帐号,一般是QQ号+"@qq.com"
		String authorizationCode = "zzz";		//邮箱帐号授权码，要在qq邮箱申请打开SMTP服务后获得
		String targetEmail = "yyy@qq.com";
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props, 
			new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailAddressName, authorizationCode);
				}
			}
		);
		session.setDebug(true);
		
		Message msg = DEMO_MIME.getMessage(session);
		msg.setSubject("java email");
		msg.setFrom(new InternetAddress(emailAddressName));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetEmail));
		
		//send内部包含连接发送关闭 sendMessage则只是单独发送
		Transport.send(msg);	
	}
	
	public static Message getMessage(Session session) throws Exception {
		Message msg = new MimeMessage(session);
		
		//主文件mmp包含多个附件
		MimeMultipart mmp = new MimeMultipart("mixed");
		
		MimeBodyPart mbp1 = new MimeBodyPart();
		DataSource ds1 = new FileDataSource("D:\\1.jpg");
		DataHandler dh1 = new DataHandler(ds1);
		mbp1.setDataHandler(dh1);
		mbp1.setFileName("1.jpg");
		mmp.addBodyPart(mbp1);
		
		MimeBodyPart mbp2 = new MimeBodyPart();
		DataSource ds2 = new FileDataSource("D:\\copyFile");
		DataHandler dh2 = new DataHandler(ds2);
		mbp2.setDataHandler(dh2);
		mbp2.setFileName(MimeUtility.encodeText("测试文件"));	//解决中文乱码问题
		mmp.addBodyPart(mbp2);
		
		MimeBodyPart mbp3 = new MimeBodyPart();
		mbp3.setContent("<span style=\'color:blue\'>测试</span>", "text/html;charset=utf-8");
		mmp.addBodyPart(mbp3);
		
		msg.setContent(mmp, "text/html; charset=utf-8");
		msg.saveChanges();
		
		return msg;
	}
	
}
