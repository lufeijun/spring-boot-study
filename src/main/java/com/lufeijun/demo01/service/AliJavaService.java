package com.lufeijun.demo01.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AliJavaService {
    private final SimpleVectorStore vectorStore;
    private final ChatClient chatClient;

    @Autowired
    public AliJavaService(SimpleVectorStore vectorStore, ChatClient chatClient) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient;
    }

    public String generateAnswer(String question) {
        // 1. 检索相关文档片段
        List<Document> relevantDocs = vectorStore.similaritySearch(question);

        // 2. 构建上下文
        String context = relevantDocs.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));

        System.out.println("=====上下文====");
        System.out.println(context);

        // 3. 构建提示词
        String prompt = String.format("""
            请基于以下上下文信息回答问题。如果上下文不包含答案，请回答"我不知道"。
            
            上下文:
            %s
            
            问题: %s
            答案:""", context, question);

        // 4. 调用AI生成回答
        return chatClient.prompt(prompt).call().content();
    }

}
