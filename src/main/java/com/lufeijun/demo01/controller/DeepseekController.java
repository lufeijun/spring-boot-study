package com.lufeijun.demo01.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deepseek")
public class DeepseekController {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    public DeepseekController (ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();

        this.chatMemory = new InMemoryChatMemory();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message){
        System.out.println("message:"+message);
        if ( message.isEmpty() ) {
            return "message is empty";
        }
        return chatClient.prompt().user(message).call().content();
    }

    @GetMapping(value = "/chat2", produces = MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8")
    public Flux<String> chat2(@RequestParam String message, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");

        System.out.println("message:"+message);
        if ( message.isEmpty() ) {
            message = "我是手机助手，你好";
        }
        return chatClient.prompt().user(message).stream().content();
    }

    // 聊天记忆功能
    @GetMapping("/memory")
    public String memory(@RequestParam String message){

        String response = chatClient
                                .prompt()
                                .advisors( new MessageChatMemoryAdvisor(chatMemory))
                                .user(message)
                                .call()
                                .content();


        // 添加记忆
        chatMemory.add("chat_history", new UserMessage(message));
        chatMemory.add("chat_history", new AssistantMessage(response));

        return response;
    }

}
