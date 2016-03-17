package com.example.he.debugapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He on 2016/2/21.
 */
public class FragmentPage4 extends Fragment {
    private MyPtrFrameLayout myPtrFrameLayout;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerAdapterWithHF recyclerAdapterWithHF;
    private RecyclerView recyclerView;
    private List<String> datas = new ArrayList<String>();
    private View rootView;
    Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.tab_4, container, false);
            datas.clear();
            for (int i = 'A'; i < 'P'; i++) {
                datas.add("" + (char) i);
            }

            myPtrFrameLayout = (MyPtrFrameLayout) rootView.findViewById(R.id.header_tab4);
            recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_tab4);
            init();
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void init() {
        recyclerAdapter = new RecyclerAdapter(getContext(),datas);
        recyclerAdapterWithHF = new RecyclerAdapterWithHF(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapterWithHF);

        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("TTest", "myPtrFrameLayout.autoRefresh");
                myPtrFrameLayout.autoRefresh(true);
            }
        }, 150);



//        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

//            //LinearLayoutManager
//            recyclerView.setLayoutManager(linearLayoutManager);
//            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
//            recyclerView.setAdapter(new RecyclerAdapter(datas));
//            recyclerView.scrollToPosition(1);
//            //LinearLayoutManager

        //
//        recyclerView.setLayoutManager(gridLayoutManager);
//        final RecyclerAdapter adaper = new RecyclerAdapter(datas);
//
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return adaper.isHeaderView(position) ? gridLayoutManager.getSpanCount() : 1;
//            }
//        });
//        recyclerView.setAdapter(adaper);
    }


}
