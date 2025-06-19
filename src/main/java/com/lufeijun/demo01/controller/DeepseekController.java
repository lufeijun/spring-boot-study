package com.lufeijun.demo01.controller;

import com.lufeijun.demo01.entry.Book;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deepseek")
public class DeepseekController {

    @Autowired
    private ChatClient chatClient;

    @Autowired
    ChatMemory chatMemory;


    static List<Message> messages = new ArrayList<>();


    @GetMapping("/chat")
    public String chat(@RequestParam String message){
        System.out.println("message:"+message);

        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }


    // 结构化输出 ：最后，本质上是根据模型的输出来尝试转 json，可能会抛出异常
    @GetMapping("/generate-book")
    public ResponseEntity<ChatResponse, Book> generateBook() {
        // 定义提示词模板，要求返回 JSON 格式
        String template = """
            请生成一本虚构的书籍信息，包含书名、作者、出版年份和类型。
            请直接输出结果，不要包含任何思考过程或<think>标签。
            返回格式必须是 JSON，例如：
            {
                title: 书名,
                author: 作者,
                year: 年份,
                genres: [类型1, 类型2]
            }
            """;
        return chatClient.prompt(template).call().responseEntity(Book.class);
    }


    @GetMapping("/prompt")
    public String prompt() {
        // 定义提示词模板，要求返回 JSON 格式
        String template = """
            请生成一本虚构的书籍信息，包含书名、作者、出版年份和类型。
            请直接输出结果，不要包含任何思考过程或<think>标签。
            返回格式必须是 JSON，例如：
            {{
                title: '书名',
                author: '作者',
                year: '年份',
                genres: ['类型1', '类型2']
            }}
            """;
        PromptTemplate promptTemplate = new PromptTemplate(template);

        Prompt prompt = promptTemplate.create();

        return chatClient.prompt(prompt).call().content();
    }


    // 单纯的保存在内存中
    @GetMapping("/memory")
    public String memory(@RequestParam("msg") String userInput) {
        // 获取AI响应
        String content = chatClient.prompt().messages(messages).user(userInput).call().content();

        // 添加AI响应到历史
        messages.add(new UserMessage(userInput));
        if (content != null) {
            messages.add( new AssistantMessage(content));
        }
        System.out.println( "====================="  );
        System.out.println( messages );
        return content;
    }

    @GetMapping("/memory-two")
    public String memoryTwo(@RequestParam("msg") String userInput) {

        //
        String conversationId = "session-1";

        // 获取AI响应
        String content = chatClient
                .prompt()
                .messages(chatMemory.get(conversationId))
                .user(userInput)
                .call()
                .content();

        // 添加AI响应到历史
        chatMemory.add( conversationId ,new UserMessage(userInput));
        if (content != null) {
            chatMemory.add( conversationId , new AssistantMessage(content));
        }
        System.out.println( "====================="  );
        System.out.println( chatMemory.get(conversationId).size() );
        return content;
    }

}
