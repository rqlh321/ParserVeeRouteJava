package com.example.alexander.parserveeroutejava.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alexander.parserveeroutejava.model.Statement;

import java.util.ArrayList;
import java.util.Collections;

@InjectViewState
public class ParserPresenter extends MvpPresenter<ParserView> {
    private ArrayList<Statement> incomplete = new ArrayList<>();
    private ArrayList<Statement> complete = new ArrayList<>();

    public void parse(String text) {
        incomplete.clear();
        complete.clear();

        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char element = array[i];
            if (Statement.isValid(element)) {
                if (Statement.isOpen(element)) handleOpen(i, element);
                else handleClose(i, element);
            } else {
                getViewState().error();
                return;
            }
        }
        if (incomplete.isEmpty() && !complete.isEmpty() && !text.isEmpty()) {
            Collections.sort(complete);
            getViewState().success(complete);
        } else getViewState().error();
    }

    private void handleClose(int i, char element) {
        Statement last = incomplete.get(incomplete.size() - 1);
        if (last.getClose() == element) {
            last.setEnd(i);
            incomplete.remove(last);
            complete.add(last);
        } else getViewState().error();
    }

    private void handleOpen(int i, char element) {
        Statement statement = new Statement(element, i);
        incomplete.add(statement);
    }

}
