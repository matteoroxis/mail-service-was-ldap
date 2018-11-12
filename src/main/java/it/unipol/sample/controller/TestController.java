package it.unipol.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;

@RestController("/test")
public class TestController {

    @Value("${message:Hello default}")
    private String message;

    @Value("${ibm.mq.testQueue:DEV.QUEUE.1}")
    private String testQueue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/test")
    String getMessage() {
        try {
            jmsTemplate.convertAndSend(testQueue, this.message);
            System.out.println("Message send to Queue");
        }catch(JmsException exception){
            exception.printStackTrace();
        }
        return this.message;
    }


    @RequestMapping("/test/read")
    String getMessageReceived() {
        String message = "";
        try {
            message = jmsTemplate.receiveAndConvert(testQueue).toString();
            System.out.println(message);
        }catch(JmsException exception){
            exception.printStackTrace();
            message = "No message to read";
        }
        return this.message;
    }
}
