package com.mr.wh.controller;

import com.mr.wh.service.IMessageProvider;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider IMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return IMessageProvider.send();
    }
}
