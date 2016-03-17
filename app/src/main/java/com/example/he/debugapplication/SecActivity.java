package com.example.he.debugapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by He on 2016/3/5.
 */
public class SecActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyPtrFrameLayout myPtrFrameLayout;
    private List<String> datas = new ArrayList<String>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerAdapterWithHF recyclerAdapterWithHF;
    Handler handler = new Handler();
    int page = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_layout);
        getSupportActionBar().hide();

        myPtrFrameLayout = (MyPtrFrameLayout) findViewById(R.id.sec_header);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        init();
    }

    private void init() {
        recyclerAdapter = new RecyclerAdapter(this,datas);
        recyclerAdapterWithHF = new RecyclerAdapterWithHF(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapterWithHF);
        myPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                myPtrFrameLayout.autoRefresh(true);
            }
        }, 150);

        myPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 0;
                        datas.clear();
                        for (int i = 0; i < 17; i++) {
                            datas.add(new String("   RecyclerView item  " + i));
                        }
                        recyclerAdapterWithHF.notifyDataSetChanged();
                        myPtrFrameLayout.refreshComplete();
                        myPtrFrameLayout.setLoadMoreEnable(true);
                    }
                }, 2000);
            }
        });

        myPtrFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add(new String("  RecyclerView item  - add " + page));
                        recyclerAdapterWithHF.notifyDataSetChanged();
                        myPtrFrameLayout.loadMoreComplete(true);
                        page++;
                        Toast.makeText(getApplicationContext(), "load more complete", Toast.LENGTH_SHORT)
                                .show();
                    }
                }, 1000);
            }
        });

    }
}
