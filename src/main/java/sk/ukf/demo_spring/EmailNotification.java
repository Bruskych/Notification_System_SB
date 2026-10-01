package sk.ukf.demo_spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo_spring.format.MessageFormatter;

// @Component
@Component("emailNotification")
public class EmailNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public EmailNotification(@Qualifier("html") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu e-mailom: " + formattedMessage;
    }
}