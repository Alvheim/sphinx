package org.alvheim.sphinx.controllers;

import org.alvheim.sphinx.entities.ChannelOption;
import org.alvheim.sphinx.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channeloptions")
public class ChannelOptionController {
    private final ChannelOptionServiceImpl channeloptionServiceImpl;

    public ChannelOptionController(ChannelOptionServiceImpl channeloptionServiceImpl) {
        this.channeloptionServiceImpl = channeloptionServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ChannelOption> save(@RequestBody ChannelOption newChannelOption) {
        return new ResponseEntity<>(channeloptionServiceImpl.save(newChannelOption), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChannelOption> replace(@RequestBody ChannelOption newChannelOption, @PathVariable Long id) {
        return new ResponseEntity<>(channeloptionServiceImpl.replace(newChannelOption, id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ChannelOption> replacePartially(@RequestBody ChannelOption newChannelOption, @PathVariable Long id) {
        return new ResponseEntity<>(channeloptionServiceImpl.replacePartially(newChannelOption, id), HttpStatus.OK);
    }

}
