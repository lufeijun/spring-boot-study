package com.lufeijun.demo01.config;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PdfConfig {

    @Bean
    public PagePdfDocumentReader pdfDocumentReader() {
        return new PagePdfDocumentReader(
                "classpath:/ali-java.pdf",  // PDF文件路径
                PdfDocumentReaderConfig.builder()
                        .withPageTopMargin(0)
                        .withPageExtractedTextFormatter(
                                ExtractedTextFormatter
                                        .builder()
                                        .withNumberOfTopTextLinesToDelete(0)
                                        .build()
                        )
                        .withPagesPerDocument(1)  // 每页作为一个文档
                        .build()
        );
    }

    @Bean
    public TextSplitter textSplitter() {
        return new TokenTextSplitter();
    }

    @Bean
    public List<Document> pdfDocuments(PagePdfDocumentReader pdfDocumentReader,
                                       TextSplitter textSplitter) {
        // 读取PDF并分块
        return textSplitter.apply(pdfDocumentReader.get());
    }
}
