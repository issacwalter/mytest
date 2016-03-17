package com.example.he.debugapplication;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater inflater;
    private Class fragmentArray[] = {FragmentPage1.class,FragmentPage2.class,FragmentPage3.class,FragmentPage4.class};
    private int mImageViewArray[] = {R.drawable.home,R.drawable.globe,R.drawable.search,R.drawable.config};
    private String mTextviewArray[] = {"首页","测试","搜索","设置"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentIndicator();

    }

    private void setFragmentIndicator(){
        inflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        int count = fragmentArray.length;

        for(int i = 0 ;i < count;i++){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec,fragmentArray[i],null);
            //set backgroud of buttons;
            //mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.units);
        }
    }

    private View getTabItemView(int index){
        View view = inflater.inflate(R.layout.tab_item_view,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }
}
