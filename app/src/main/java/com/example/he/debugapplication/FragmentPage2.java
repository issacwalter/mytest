package com.example.he.debugapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He on 2016/2/21.
 */
public class FragmentPage2 extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;
    private List<String> datas = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,final ViewGroup container, Bundle savedInstanceState) {
        if (rootView ==null){
            rootView = inflater.inflate(R.layout.tab_4,container,false);
            for (int i = 'A'; i < 'Z'; i++) {
                datas.add("" + (char) i);
            }


            recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new RecyclerAdapter(datas));


        }

        ViewGroup parent = (ViewGroup)rootView.getParent();
        if(parent !=null){
            parent.removeView(rootView);
        }

        return rootView;
    }
}
