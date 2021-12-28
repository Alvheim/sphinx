package org.alvheim.sphinx.services;

import java.util.Map;
import org.alvheim.sphinx.entities.ChannelOption;

public interface ChannelOptionService {

    public ChannelOption save(ChannelOption newUser);

    public ChannelOption replace(ChannelOption newChannelOption, Long id);


    public ChannelOption partialReplace(Map<String, Object> partialUpdates, Long id);


}