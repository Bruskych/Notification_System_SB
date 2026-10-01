package sk.ukf.demo_spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo_spring.format.MessageFormatter;

@Component("smsNotification")
public class SMSNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    // Внедряем PlainText formatter
    public SMSNotification(@Qualifier("plainText") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu sms: " + formattedMessage;
    }
}