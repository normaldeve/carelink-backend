package com.normaldeve.carelinkbackend.controller;

import com.normaldeve.carelinkbackend.dto.ChatMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * 챗봇 Rest API
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class AiController {

    private final ChatClient chatClient;

    @PostMapping
    public String chat(
            @RequestBody ChatMessageDTO request,
            @RequestHeader(value = "conversationId", required = false) String conversationId
    ) {
        String userMessage = request.message();

        String currentConversationId = (conversationId != null) ? conversationId : UUID.randomUUID().toString();

        return chatClient.prompt()
                .user(userMessage)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, currentConversationId))
                .call()
                .content();
    }
}