package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    // Метод добавления объекта в поисковый движок
    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // Метод поиска всех подходящих результатов
    public Map<String, Searchable> search(String query) {
        // Компаратор для сортировки по длине имени (от самого длинного к самому короткому)
        Comparator<String> lengthComparator = Comparator
                .<String>comparingInt(String::length)
                .reversed()
                .thenComparing(Comparator.naturalOrder()); // Если длины равны, сортируем по алфавит
        Map<String, Searchable> results = new TreeMap<>(lengthComparator);
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
