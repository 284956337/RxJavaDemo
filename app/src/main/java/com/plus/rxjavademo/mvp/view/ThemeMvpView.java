package com.plus.rxjavademo.mvp.view;

import com.plus.rxjavademo.entity.ThemeList;
import com.plus.rxjavademo.mvp.MvpView;

import java.util.List;

/**
 * Created by zw on 2017/4/27.
 */

public interface ThemeMvpView extends MvpView{
    void loadThemes(List<ThemeList.Theme> themes);

    void showGetThemesFailMsg(String msg);
}
