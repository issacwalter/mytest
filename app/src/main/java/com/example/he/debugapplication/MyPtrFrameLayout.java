package com.example.he.debugapplication;

import android.content.Context;
import android.util.AttributeSet;

import com.chanven.lib.cptr.PtrClassicDefaultHeader;
import com.chanven.lib.cptr.PtrFrameLayout;

/**
 * Created by He on 2016/3/17.
 */
public class MyPtrFrameLayout extends PtrFrameLayout {
    private MyPtrHandler mPtrClassicHeader;

    public MyPtrFrameLayout(Context context) {
        super(context);
        initViews();
    }

    public MyPtrFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public MyPtrFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        mPtrClassicHeader = new MyPtrHandler(getContext());
        setHeaderView(mPtrClassicHeader);
        addPtrUIHandler(mPtrClassicHeader);
    }

    public MyPtrHandler getHeader() {
        return mPtrClassicHeader;
    }

    /**
     * Specify the last update time by this key string
     *
     * @param key
     */
    public void setLastUpdateTimeKey(String key) {
        if (mPtrClassicHeader != null) {
            mPtrClassicHeader.setLastUpdateTimeKey(key);
        }
    }

    /**
     * Using an object to specify the last update time.
     *
     * @param object
     */
    public void setLastUpdateTimeRelateObject(Object object) {
        if (mPtrClassicHeader != null) {
            mPtrClassicHeader.setLastUpdateTimeRelateObject(object);
        }
    }


}
