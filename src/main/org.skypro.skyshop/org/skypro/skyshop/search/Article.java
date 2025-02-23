package org.skypro.skyshop.search;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return toString(); // Поиск по названию и тексту статьи
    }

    @Override
    public String getContentType() {
        return "ARTICLE"; // Тип контента — статья
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
