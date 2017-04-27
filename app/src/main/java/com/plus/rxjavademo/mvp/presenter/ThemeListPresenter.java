package com.plus.rxjavademo.mvp.presenter;

import com.plus.rxjavademo.entity.ThemeList;
import com.plus.rxjavademo.mvp.BasePresenter;
import com.plus.rxjavademo.mvp.model.ThemeModel;
import com.plus.rxjavademo.mvp.view.ThemeMvpView;

import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by zw on 2017/4/27.
 */

public class ThemeListPresenter extends BasePresenter<ThemeMvpView>{
    private ThemeModel themeModel;

    public ThemeListPresenter() {
        this.themeModel = new ThemeModel();
    }

    public void getThemes(){
        Subscription subscription = themeModel.getThemes()
                .subscribeOn(Schedulers.io()).subscribe(new Action1<ThemeList>() {
                    @Override
                    public void call(ThemeList themeList) {
                        if(themeList != null){
                            getMvpView().loadThemes(themeList.getOthers());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getMvpView().showGetThemesFailMsg(throwable.getMessage());
                    }
                });
        addSubscribe(subscription);
    }
}
