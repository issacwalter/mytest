package com.example.he.debugapplication;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He on 2016/2/21.
 */
public class FragmentPage3 extends Fragment {
    private RecyclerView recyclerView;
    private List<String> datas = new ArrayList<String>();
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null){
            rootView = inflater.inflate(R.layout.tab_3,container,false);
            for (int i = 'A'; i < 'P'; i++) {
                datas.add("" + (char) i);
            }


            recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(gridLayoutManager);
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
