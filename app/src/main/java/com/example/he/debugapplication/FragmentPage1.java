package com.example.he.debugapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He on 2016/2/21.
 */
public class FragmentPage1 extends Fragment{
    private static final int PAGE_NUMBER = 5;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LayoutInflater layoutInflater;
    private List<String> titleList = new ArrayList<>();
    private List<View> viewList = new ArrayList<>();
    private View view1, view2, view3, view4, view5,viewbefore,viewafter;
    private View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(R.layout.tab_1, null);
            viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
            tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
            layoutInflater = LayoutInflater.from(this.getActivity());

            viewbefore = inflater.inflate(R.layout.viewbefore, null);
            view1 = inflater.inflate(R.layout.view1, null);
            view2 = inflater.inflate(R.layout.view2, null);
            view3 = inflater.inflate(R.layout.view3, null);
            view4 = inflater.inflate(R.layout.view4, null);
            view5 = inflater.inflate(R.layout.view5, null);
            viewafter = inflater.inflate(R.layout.viewafter,null);

            viewList.add(viewbefore);
            viewList.add(view1);
            viewList.add(view2);
            viewList.add(view3);
            viewList.add(view4);
            viewList.add(view5);
            viewList.add(viewafter);

            titleList.add(null);
            titleList.add("A");
            titleList.add("B");
            titleList.add("C");
            titleList.add("D");
            titleList.add("E");
            titleList.add(null);

            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            for (int i = 0; i < titleList.size(); i++) {
                tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
            }

            MyPagerAdapter pagerAdapter = new MyPagerAdapter(viewList, titleList);
            viewPager.setAdapter(pagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            viewPager.setCurrentItem(1);

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    int pageIndex = position;
                    if(position == 0){
                        pageIndex = titleList.size()-2;
                    }else if(position == titleList.size()-1){
                        pageIndex = 1;
                    }
                    Log.d("TTEST","pageIndex=  "+  pageIndex +    "    &&&     position=  " + position);
                    if(position !=pageIndex){
                        viewPager.setCurrentItem(pageIndex,false);
                        return;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

        ViewGroup parent = (ViewGroup)rootView.getParent();
        if(parent !=null){
            parent.removeView(rootView);
        }

        return rootView;
    }
}
