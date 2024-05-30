package com.teamsleague.jms;

import com.teamsleague.contract.mapper.SponsorMapperController;
import com.teamsleague.contract.model.sponsor.SponsorCreateDTO;
import com.teamsleague.contract.model.sponsor.SponsorUpdateDTO;
import com.teamsleague.contract.model.sponsor.SponsorDeleteDTO;
import com.teamsleague.model.domain.service.SponsorService;
import com.teamsleague.model.domain.entity.Sponsor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JMSReceiver {

    @Autowired
    private final SponsorService sponsorService;

    @Autowired
    private final SponsorMapperController sponsorMapper;

    private final String CREATE = "CREATE";
    private final String UPDATE = "UPDATE";
    private final String DELETE = "DELETE";

    private final ObjectMapper mapper = new ObjectMapper();

    @JmsListener(destination = "sponsorCRUD")
    public void receive(Message message) throws JmsException {
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
