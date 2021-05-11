package com.vsii.scanfolder.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

@Component
public class JmsUtils {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendFolderUrlMessage(String fullPath, String queueName) throws Exception {
        String correlationID ="scan folder";
        jmsTemplate.convertAndSend(queueName, fullPath, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setJMSCorrelationID(correlationID);
                return message;
            }
        });
    }
}
