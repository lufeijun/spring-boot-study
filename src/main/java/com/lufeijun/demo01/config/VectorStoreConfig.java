package com.lufeijun.demo01.config;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.observation.conventions.VectorStoreProvider;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.SimpleVectorStoreContent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

@Configuration
public class VectorStoreConfig {

    @Bean
    public SimpleVectorStore vectorStore(EmbeddingModel embeddingClient,
                                           List<Document> pdfDocuments) {
        SimpleVectorStore build = SimpleVectorStore.builder(embeddingClient).build();

        build.add(pdfDocuments);

        File vectorStoreFile = new File("vectorstore.json");
        build.save(vectorStoreFile);

        return build;
    }
}
