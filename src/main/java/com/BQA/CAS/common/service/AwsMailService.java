package com.BQA.CAS.common.service;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AwsMailService {

    @Autowired
    private MailSender mailSender;

    @Value("${fromEmail}")
    private String fromEmail ;

    private boolean isEmailEnabled = true;

    @Autowired
    private final SpringTemplateEngine thymeleafTemplateEngine;

    public AwsMailService(SpringTemplateEngine thymeleafTemplateEngine) {
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }

    @Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;

//    public void sendMessage(SimpleMailMessage simpleMailMessage){
//        System.out.println("Send email successfully");
//        this.mailSender.send(simpleMailMessage);
//    }

    public void sendSimpleEmail(String mailTo, String mailedBy, String message, String subject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailedBy);
        simpleMailMessage.setTo(mailTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSentDate(new Date());
        mailSender.send(simpleMailMessage);

    }

    public void sendMail(String toMail, Map<String, Object> templateModel, String mailHtmlPath, List<String> ccAdresses, String subect) {
        try{
            Context thymeleafContext = new Context();
            String mailBody = null;
            if(subect == null){
                subect = "BQA status";
            }
            thymeleafContext.setVariables(templateModel);
            mailBody = thymeleafTemplateEngine.process(mailHtmlPath, thymeleafContext);
            if (ccAdresses == null) {
                sendMessage1(toMail, subect, mailBody);
            } else if (ccAdresses.isEmpty()) {
                sendMessage1(toMail, subect, mailBody);
            } else {
                sendMessage(toMail, subect, mailBody, ccAdresses);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int sendMessage(String toEmail, String subject, String body, List<String> ccAdresses) {
        AmazonSimpleEmailService client =
                AmazonSimpleEmailServiceClientBuilder.standard()
                        // Replace US_WEST_2 with the AWS Region you're using for
                        // Amazon SES.
                        .withRegion(Regions.AP_SOUTH_1).build();
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(toEmail).withCcAddresses(ccAdresses))
                .withMessage(new Message()
                        .withBody(new Body()
                                .withHtml(new Content()
                                        .withCharset("UTF-8").withData(body))
                                .withText(new Content()
                                        .withCharset("UTF-8").withData(body)))
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(subject)))
                .withSource(fromEmail);
        // Comment or remove the next line if you are not using a
        // configuration set
//                .withConfigurationSetName("configset");
        if (isEmailEnabled) {
            amazonSimpleEmailService.sendEmail(request);
            System.out.println("Email  sent!");
        } else {
            System.out.println("Email not  sent!");
        }
        return 1;
    }

    public int sendMessage1(String toEmail, String subject, String body) {
        AmazonSimpleEmailService client =
                AmazonSimpleEmailServiceClientBuilder.standard()
                        // Replace US_WEST_2 with the AWS Region you're using for
                        // Amazon SES.
                        .withRegion(Regions.AP_SOUTH_1).build();
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(toEmail))
                .withMessage(new Message()
                        .withBody(new Body()
                                .withHtml(new Content()
                                        .withCharset("UTF-8").withData(body))
                                .withText(new Content()
                                        .withCharset("UTF-8").withData(body)))
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(subject)))
                .withSource(fromEmail);
        // Comment or remove the next line if you are not using a
        // configuration set
//                .withConfigurationSetName("configset");
        if (isEmailEnabled) {
            amazonSimpleEmailService.sendEmail(request);
            System.out.println("Email  sent!");
        } else {
            System.out.println("Email not  sent!");
        }
        return 1;
    }
}