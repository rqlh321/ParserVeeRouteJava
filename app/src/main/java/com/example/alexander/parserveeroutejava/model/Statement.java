package com.example.alexander.parserveeroutejava.model;

import android.support.annotation.NonNull;

public class Statement implements Comparable<Statement> {
    private static final char[] OPEN = {'(', '[', '{' };
    private static final char[] CLOSE = {')', ']', '}' };

    private char open;
    private char close;
    private int start = -1;
    private int end = -1;

    public Statement(char element, int start) {
        this.start = start;

        for (int i = 0; i < OPEN.length; i++) {
            if (OPEN[i] == element) {
                open = OPEN[i];
                close = CLOSE[i];
                break;
            }
        }
    }

    public char getClose() {
        return close;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public static boolean isOpen(char element) {
        for (char item : OPEN) {
            if (element == item) return true;
        }
        return false;
    }

    public static boolean isClose(char element) {
        for (char item : CLOSE) {
            if (element == item) return true;
        }
        return false;
    }

    public static boolean isValid(char element) {
        return isOpen(element) || isClose(element);
    }

    @Override
    public int compareTo(@NonNull Statement statement) {
        if (this.start > statement.start) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return open + " - " + close + " " + start + " - " + end;
    }
}
