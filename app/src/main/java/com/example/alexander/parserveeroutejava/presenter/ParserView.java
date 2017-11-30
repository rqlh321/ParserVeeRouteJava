package com.example.alexander.parserveeroutejava.presenter;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.alexander.parserveeroutejava.model.Statement;

import java.util.List;

public interface ParserView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void success(List<Statement> elements);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void error();

}
