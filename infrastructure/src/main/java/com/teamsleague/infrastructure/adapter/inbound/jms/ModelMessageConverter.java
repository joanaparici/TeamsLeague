package com.teamsleague.infrastructure.adapter.inbound.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorCreateDTO;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ModelMessageConverter implements MessageConverter {

    ObjectMapper mapper;

    public ModelMessageConverter() {
        mapper = new ObjectMapper();
    }

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        throw new MessageConversionException("Cannot convert object to Message");
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        TextMessage textMessage = (TextMessage) message;
        String payload = textMessage.getText();

        SponsorCreateDTO sponsorCreateDTO = null;
        try {
            sponsorCreateDTO = mapper.readValue(payload, SponsorCreateDTO.class);
        } catch (Exception e) {
            log.error("error converting");
        }
        return sponsorCreateDTO;
    }
}