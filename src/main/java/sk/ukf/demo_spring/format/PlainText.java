package sk.ukf.demo_spring.format;

import org.springframework.stereotype.Component;

@Component("plainText")
public class PlainText implements MessageFormatter{
    @Override
    public String format(String message) {
        return message;
    }
}
