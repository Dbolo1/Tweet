package com.bolo1.tweet_app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.tweet_app.ui.uitls.UIUtils;
import com.bolo1.tweet_app.view.LoadingPage;

import java.util.ArrayList;

public abstract class BaseListFragment extends Fragment {

    private LoadingPage loadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseListFragment.this.onCreateSuccessView();
            }
            @Override
            public LoadingPage.ResultState onLoad() {
                return BaseListFragment.this.initData();
            }
        };
        return loadingPage;
    }
    public abstract View onCreateSuccessView();
    public abstract LoadingPage.ResultState initData();
    public void loadData(){
        if(loadingPage!=null){
            loadingPage.onLoadData();
        }
    }



    public LoadingPage.ResultState check(Object object) {
        if (object != null) {
            if(object instanceof ArrayList) {
                ArrayList list = (ArrayList) object;
                if (list.isEmpty()) {
                    return LoadingPage.ResultState.STATE_EMPTY;
                }else{
                    return LoadingPage.ResultState.STATE_SUCCESS;
                }
            }
        }
        return LoadingPage.ResultState.STATE_ERROR;
    }
}

