package sk.ukf.demo_spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo_spring.format.MessageFormatter;

@Component("pushNotification")
public class PushNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    // Внедряем UpperCase formatter
    public PushNotification(@Qualifier("upperCase") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam push notifikáciu: " + formattedMessage;
    }
}