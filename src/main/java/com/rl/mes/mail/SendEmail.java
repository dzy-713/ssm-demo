package com.rl.mes.mail;

/**
 * 发送邮件
 *
 */

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) throws GeneralSecurityException, InterruptedException {

        new SendEmail().send();
        return;
    }

    public void send() throws GeneralSecurityException {
        // 收件人电子邮箱
        String to = "xxxxxx@qq.com";

        // 发件人电子邮箱
        String from = "xxxxxx@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com  QQ 邮件服务器
        String host = "smtp.qq.com";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、密码
                return new PasswordAuthentication("xxxxxxx@qq.com", "qnajbtweiklsbcch");
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("MES系统出现异常");

            // 设置消息体
            message.setText("MES系统出现异常");
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}