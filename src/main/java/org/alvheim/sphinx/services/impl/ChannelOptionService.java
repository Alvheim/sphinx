package org.alvheim.sphinx.services.impl;

import static org.alvheim.sphinx.services.util.ServiceUtils.applyPatches;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.alvheim.sphinx.entities.ChannelOption;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
import org.alvheim.sphinx.repositories.ChannelOptionRepository;
import org.alvheim.sphinx.services.ChannelOptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChannelOptionServiceImpl implements ChannelOptionService {

    private final ChannelOptionRepository channeloptionRepository;

    public ChannelOptionServiceImpl(ChannelOptionRepository channeloptionRepository) {
        this.channeloptionRepository = channeloptionRepository;
    }

    @Override
    public ChannelOption save(ChannelOption newChannelOption) {
        return channeloptionRepository.save(newChannelOption);
    }

    @Transactional
    @Override
    public ChannelOption replace(ChannelOption newChannelOption, Long id) {
        return channeloptionRepository
                .findById(id)
                .map(
                        channeloption -> {
                            channeloption.setFirstName(newChannelOption.getFirstName());
                            channeloption.setLastName(newChannelOption.getLastName());
                            channeloption.setMiddleName(newChannelOption.getMiddleName());
                            channeloption.setEmail(newChannelOption.getEmail());
                            channeloption.setPassword(newChannelOption.getPassword());
                            channeloption.setBirthday(newChannelOption.getBirthday());
                            channeloption.setMobileNumber(newChannelOption.getMobileNumber());
                            channeloption.setAdditionalMobileNumber(newChannelOption.getAdditionalMobileNumber());
                            return channeloption;
                        })
                .orElseThrow(() -> new ResourceNotFoundException("No channeloption with id: " + id + " was found"));
    }

    @Transactional
    @Override
    public ChannelOption partialReplace(Map<String, Object> partialUpdates, Long id) {
        ChannelOption channeloptionToPatch =
                channeloptionRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No channeloption with id: " + id + " was found"));

        return applyPatches(channeloptionToPatch, partialUpdates, ChannelOption.class);
    }
}
