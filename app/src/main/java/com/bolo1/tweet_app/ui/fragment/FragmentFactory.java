package com.bolo1.tweet_app.ui.fragment;

import com.lidroid.xutils.util.LogUtils;

import java.util.HashMap;

/**
 * Created by 菠萝 on 2017/10/16.
 */

public class FragmentFactory {
    public static HashMap<Integer,BaseListFragment> fragmentHashMap=new HashMap<Integer, BaseListFragment>();
    public static BaseListFragment onCreateFragment(int pos) {
        //先从集合中取如果没有才去new对象，提高性能
        BaseListFragment fragment = fragmentHashMap.get(pos);
        LogUtils.d("当前选中的fragment"+fragment);
        if(fragment==null){
            switch (pos) {
                case 2:
                    fragment = new SubjectFragment();
                    break;
                default:
                    break;
            }
        }
        fragmentHashMap.put(pos,fragment);
        LogUtils.d("创建fragment后的布局====="+fragment);
            return fragment;
    }


}
