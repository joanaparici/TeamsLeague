package com.teamsleague.infrastructure.adapter.inbound.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamsleague.domain.model.Sponsor;
import com.teamsleague.domain.port.in.SponsorService;
import com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper.SponsorMapperController;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorCreateDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorDeleteDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorUpdateDTO;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JMSReceiver implements MessageListener {

    private final SponsorService sponsorService;
    private final SponsorMapperController sponsorMapper;

    private final String CREATE = "CREATE";
    private final String UPDATE = "UPDATE";
    private final String DELETE = "DELETE";

    private final ObjectMapper mapper = new ObjectMapper();

    public JMSReceiver(SponsorService sponsorService, SponsorMapperController sponsorMapper) {
        this.sponsorService = sponsorService;
        this.sponsorMapper = sponsorMapper;
    }

    @JmsListener(destination = "sponsorCRUD")
    public void onMessage(Message message) {
        String logMessage = "";
        try {
            var body = message.getBody(String.class);
            var operation = message.getStringProperty("operation");
            Sponsor sponsorEntity;

            switch (operation) {
                case CREATE:
                    SponsorCreateDTO sponsorToCreate = mapper.readValue(body, SponsorCreateDTO.class);
                    sponsorEntity = sponsorMapper.sponsorCreateToSponsor(sponsorToCreate);
                    sponsorEntity = sponsorService.create(sponsorEntity);
                    logMessage = "Sponsor created successfully: " + sponsorEntity.toString();
                    break;
                case UPDATE:
                    SponsorUpdateDTO sponsorToUpdate = mapper.readValue(body, SponsorUpdateDTO.class);
                    sponsorEntity = sponsorMapper.sponsorUpdateToSponsor(sponsorToUpdate);
                    sponsorEntity = sponsorService.update(sponsorToUpdate.getId(), sponsorEntity);
                    logMessage = "Sponsor updated successfully: " + sponsorEntity.toString();
                    break;
                case DELETE:
                    SponsorDeleteDTO sponsorToDelete = mapper.readValue(body, SponsorDeleteDTO.class);
                    sponsorService.delete(sponsorToDelete.getId());
                    logMessage = "Sponsor deleted successfully with ID: " + sponsorToDelete.getId();
                    break;
                default:
                    logMessage = "Operation not allowed";
                    break;
            }
            log.info(logMessage);
        } catch (Exception e) {
            logMessage = e.getMessage();
            log.error(logMessage, e);
        }
        log.info(logMessage);
    }
}
