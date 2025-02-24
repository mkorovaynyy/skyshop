package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    // Метод добавления объекта в поисковый движок
    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // Метод поиска всех подходящих результатов
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(searchable.getName(), searchable);
            }
        }
        return results;
    }

    // Метод поиска самого подходящего элемента
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm().toLowerCase();
            int count = countOccurrences(searchTerm, query.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + query);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringIndex = str.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = str.indexOf(substring, index);
        }

        return count;
    }
}
