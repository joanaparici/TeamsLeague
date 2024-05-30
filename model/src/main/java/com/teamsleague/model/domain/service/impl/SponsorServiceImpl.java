package com.teamsleague.model.domain.service.impl;

import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.domain.repository.SponsorRepository;
import com.teamsleague.model.domain.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor create(Sponsor sponsor) {
        if (sponsor.getDeleted() == null) {
            sponsor.setDeleted(false);
        }
        if (sponsor.getVersion() == null) {
            sponsor.setVersion(0);
        }
        return sponsorRepository.create(sponsor);
    }

    @Override
    public Sponsor update(int id, Sponsor sponsor) {
        Sponsor existingSponsor = sponsorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sponsor not found"));

        existingSponsor.setNombre(sponsor.getNombre());
        existingSponsor.setIndustria(sponsor.getIndustria());
        existingSponsor.setVersion(sponsor.getVersion());

        return sponsorRepository.update(id, existingSponsor);
    }

    @Override
    public void delete(int id) {
        Sponsor existingSponsor = sponsorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sponsor not found"));
        existingSponsor.setDeleted(true);
        sponsorRepository.update(id, existingSponsor);
    }

    @Override
    public Optional<Sponsor> findById(int id) {
        return sponsorRepository.findById(id);
    }

    @Override
    public List<Sponsor> findAllById(List<Integer> ids) {
        return sponsorRepository.findAllById(ids);
    }
}
