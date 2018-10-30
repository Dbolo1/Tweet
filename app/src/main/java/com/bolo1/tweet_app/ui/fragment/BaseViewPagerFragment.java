package com.bolo1.tweet_app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseViewPagerAdapter;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.PagerTab;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2018/3/8.
 */

public abstract class BaseViewPagerFragment extends Fragment {
    @InjectView(R.id.base_pager_tab)
    PagerTab base_pager_tab;
    @InjectView(R.id.vp_base_pager)
    ViewPager vp_base_pager;
    private BaseViewPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.base_viewpager_framgent, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new BaseViewPagerAdapter(getChildFragmentManager());

        addPagerToAdapter(adapter);
        vp_base_pager.setAdapter(adapter);
        base_pager_tab.setViewPager(vp_base_pager);
        base_pager_tab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    BaseListFragment fragment = FragmentFactory.onCreateFragment(position);
                    LogUtils.d("选中的位置====" + position + "选中的fragment===" + fragment);
                    fragment.loadData();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setOffscreenPageLimit();

    }

    private void setOffscreenPageLimit() {
        vp_base_pager.setOffscreenPageLimit(vp_base_pager.getAdapter().getCount() / 2 + 1);
    }


    /**
     * 向adapter中添加pager
     *
     * @param adapter
     */
    public abstract void addPagerToAdapter(BaseViewPagerAdapter adapter);
}
