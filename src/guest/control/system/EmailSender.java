/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.control.system;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Ferreira
 */
public class EmailSender {

    private Properties props = new Properties();
    private final Session session;

    public EmailSender() {

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.port", "465"); 
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.socketFactory.port", "465"); 
        props.put("mail.smtp.socketFactory.fallback", "false"); 
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("01goncalvesferreira@cua.edu", "Gf100295#");
            }
        });
        session.setDebug(true);
        
    }

    public void sendMessageCheckInConfirmation(String emailDest, String checkInTime, String dormName) {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("01goncalvesferreira@cua.edu")); //from address

            Address[] toUser = InternetAddress //to address
                    .parse(emailDest);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Check In Confirmation");//subject
            message.setText("You just checked in at the " + dormName + " building!\nCheck in time: " + checkInTime + 
                    "\nThank you for your visit!");//message
            

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void sendMessageCheckOutConfirmation(String emailDest, String checkOutTime, String dormName) {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gabrifer@gmail.com")); //from address

            Address[] toUser = InternetAddress //to address
                    .parse(emailDest);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Check Out Confirmation");//subject
            message.setText("You successfully checked out at the " + dormName + " building!\nCheck in time: " + checkOutTime + 
                    "\nThank you for your visit!");//message
            

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void sendNotification(String email, String notification) {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gabrifer@gmail.com")); //from address

            Address[] toUser = InternetAddress //to address
                    .parse(email);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Check Out Confirmation");//subject
            message.setText(notification);//message
            

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
