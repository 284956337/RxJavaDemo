package com.plus.rxjavademo.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.plus.rxjavademo.R;
import com.plus.rxjavademo.entity.ThemeList;
import com.plus.rxjavademo.mvp.presenter.ThemeListPresenter;
import com.plus.rxjavademo.mvp.view.ThemeMvpView;

import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ThemeMvpView{

    TextView textView;

    private ThemeListPresenter themeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ButterKnife.bind(this);

        themeListPresenter = new ThemeListPresenter();
        themeListPresenter.attachView(this);
        themeListPresenter.getThemes();
    }

    @Override
    public void loadThemes(List<ThemeList.Theme> themes) {

    }

    @Override
    public void showGetThemesFailMsg(String msg) {

    }
}
