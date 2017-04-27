package com.plus.rxjavademo.mvp.model;

import com.plus.rxjavademo.entity.ThemeList;
import com.plus.rxjavademo.mvp.RxService;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zw on 2017/4/27.
 */

public class ThemeModel {

    public ThemeModel() {
    }

    public Observable<ThemeList> getThemes(){
        return RxService.create(ThemeApi.class).getThemes();
    }

    public Observable<List<ThemeList.Theme>> getStories(@Path("themeId") int themeId){
        return RxService.create(ThemeApi.class).getStories(themeId);
    }

    public interface ThemeApi{
        @GET("themes")
        Observable<ThemeList> getThemes();

        @GET
        Observable<List<ThemeList.Theme>> getStories(@Path("themeId") int themeId);
    }
}
