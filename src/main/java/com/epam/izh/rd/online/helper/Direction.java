package com.epam.izh.rd.online.helper;

import java.util.Comparator;

/**
 * Параметр сортировки
 */
public enum Direction implements Comparator<String> {

    /**
     * Сортировка по возрастанию
     */
    ASC {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    },
    /**
     * Сортировка по убыванию
     */
    DESC {
        @Override
        public int compare(String o1, String o2) {
            return o2.length() - o1.length();
        }
    }
}
