package com.normaldeve.carelinkbackend.config;

import com.normaldeve.carelinkbackend.tools.ChatbotTools;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.Resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

/**
 * OpenAI 연동
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder,
                                 ChatMemoryRepository chatMemoryRepository,
                                 ChatbotTools tools,
                                 @Value("classpath:/prompt/carelink_prompt.st")Resource resource) {

        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(resource);

        String currentDateWithDay = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd (E요일)", Locale.KOREAN));

        String systemPromptText = systemPromptTemplate.render(Map.of("current_date", currentDateWithDay));

        ChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(chatMemoryRepository)
                .maxMessages(20)
                .build();

        return builder
                .defaultSystem(systemPromptText)
                .defaultTools(tools)
                .defaultAdvisors(new SimpleLoggerAdvisor(), MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }
}