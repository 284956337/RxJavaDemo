package com.plus.rxjavademo.mvp;

import android.content.Context;
import android.util.Log;

import com.plus.rxjavademo.app.MyApplication;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by zw on 2017/4/27.
 */

public class BasePresenter<V extends MvpView> implements Presenter<V> {

    private static final String TAG = "BasePresenter";
    protected Context mContext = MyApplication.APP_CONTEXT;
    private V mMvpView;
    private boolean mIsAttachViewMethodCalled = false;
    private CompositeSubscription mCompositeSubscription;

    public BasePresenter() {

    }

    protected void addSubscribe(Subscription subscription){
        if(mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }
        Log.d(TAG, "add Subscription");
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(V view) {
        mIsAttachViewMethodCalled = true;
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mIsAttachViewMethodCalled = false;
        unSubscribe();
    }

    private void unSubscribe() {
        if(mCompositeSubscription != null){
            Log.d(TAG, "unSubscription");
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public boolean isViewAttach() {
        return mMvpView != null;
    }

    @Override
    public V getMvpView() {
        if(!mIsAttachViewMethodCalled){
            throw new RuntimeException("please call attachView first");
        }
        return mMvpView;
    }

    protected String getString(int resId){
        return mContext.getString(resId);
    }
}
