package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        searchables = new Searchable[capacity];
        size = 0;
    }

    // Метод для добавления объекта в поисковый движок
    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size++] = searchable;
        } else {
            System.out.println("Невозможно добавить больше объектов");
        }
    }

    // Метод для поиска
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count++] = searchable;
                if (count == 5) {
                    break;
                }
            }
        }

        return results;
    }
}
