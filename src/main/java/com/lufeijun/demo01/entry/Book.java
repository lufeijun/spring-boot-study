package com.lufeijun.demo01.entry;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private String title;
    private String author;
    private int year;
    private List<String> genres;
}
