package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;

import static java.util.Collections.*;

/**
 * Совет:
 * Начните с реализации метода {@link SimpleTextStatisticsAnalyzer#getWords(String)}.
 * Затем переиспользуйте данный метод при реализации других.
 * <p>
 * При необходимости, можно создать внутри данного класса дополнительные вспомогательные приватные методы.
 */
public class SimpleTextStatisticsAnalyzer implements TextStatisticsAnalyzer {

    /**
     * Необходимо реализовать функционал подсчета суммарной длины всех слов (пробелы, знаким препинания итд не считаются).
     * Например для текста "One, I - tWo!!" - данный метод должен вернуть 7.
     *
     * @param text текст
     */
    @Override
    public int countSumLengthOfWords(String text) {
        int charCounter = 0;

        for (String word : getWords(text)) {
            charCounter += word.length();
        }

        return charCounter;
    }

    /**
     * Необходимо реализовать функционал подсчета количества слов в тексте.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" - данный метод должен вернуть 7.
     *
     * @param text текст
     */
    @Override
    public int countNumberOfWords(String text) {
        return getWords(text).size();
    }

    /**
     * Необходимо реализовать функционал подсчета количества уникальных слов в тексте (с учетом регистра).
     * Например для текста "One, two, three, three - one, tWo, tWo!!" - данный метод должен вернуть 5.
     * param text текст
     */
    @Override
    public int countNumberOfUniqueWords(String text) {
        return getUniqueWords(text).size();
    }

    /**
     * Необходимо реализовать функционал получения списка слов из текста.
     * Пробелы, запятые, точки, кавычки и другие знаки препинания являются разделителями слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должен вернуться список :
     * {"One", "two", "three", "three", "one", "tWo", "tWo"}
     *
     * @param text текст
     */
    @Override
    public List<String> getWords(String text) {
        List<String> wordList = new ArrayList<>();

        for (String word : text.split("\\W+")) {
            addAll(wordList, word);
        }

        return wordList;
    }

    /**
     * Необходимо реализовать функционал получения списка уникальных слов из текста.
     * Пробелы, запятые, точки, кавычки и другие знаки препинания являются разделителями слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должен вернуться список :
     * {"One", "two", "three", "one", "tWo"}
     *
     * @param text текст
     */
    @Override
    public Set<String> getUniqueWords(String text) {
        return new HashSet<>(getWords(text));
    }

    /**
     * Необходимо реализовать функционал подсчета количества повторений слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должны вернуться результаты :
     * {"One" : 1, "two" : 1, "three" : 2, "one" : 1, "tWo" : 2}
     *
     * @param text текст
     */
    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        List<String> wordList = getWords(text);
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : wordList) {
            wordMap.putIfAbsent(word, frequency(wordList, word));
        }

        return wordMap;
    }

    /**
     * Необходимо реализовать функционал вывода слов из текста в отсортированном виде (по длине) в зависимости от параметра direction.
     * Например для текста "Hello, Hi, mother, father - good, cat, c!!" должны вернуться результаты :
     * ASC : {"mother", "father", "Hello", "good", "cat", "Hi", "c"}
     * DESC : {"c", "Hi", "cat", "good", "Hello", "father", "mother"}
     *
     * @param text текст
     */
    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        List<String> wordList = getWords(text);
        sort(wordList, direction);
        return wordList;
    }
}
