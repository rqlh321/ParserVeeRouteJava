package com.example.alexander.parserveeroutejava.view;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexander.parserveeroutejava.R;
import com.example.alexander.parserveeroutejava.model.Statement;
import com.example.alexander.parserveeroutejava.presenter.ParserPresenter;
import com.example.alexander.parserveeroutejava.presenter.ParserView;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements ParserView {
    private StatementAdapter adapter;
    private TextView message;

    @InjectPresenter
    ParserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
        ((EditText) findViewById(R.id.input)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.parse(editable.toString());
            }
        });

        RecyclerView output = findViewById(R.id.output);
        output.setHasFixedSize(true);
        output.setLayoutManager(new LinearLayoutManager(this));
        output.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        adapter = new StatementAdapter();
        output.setAdapter(adapter);
    }

    @Override
    public void success(List<Statement> elements) {
        message.setText(R.string.valid);
        adapter.refresh(elements);
    }

    @Override
    public void error() {
        message.setText(R.string.invalid);
        adapter.clear();
    }

}
