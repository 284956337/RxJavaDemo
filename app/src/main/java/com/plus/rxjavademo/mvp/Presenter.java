package com.plus.rxjavademo.mvp;

/**
 * Created by Administrator on 2017/4/27.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

    boolean isViewAttach();

    V getMvpView();
}
