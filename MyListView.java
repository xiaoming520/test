package com.lava.longlist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;
import android.widget.OverScroller;

/**
 * Created by Ming.Xiao on 2017/5/2.
 */

public class MyListView extends ListView{

    OverScroller mOverScroller;
    public MyListView(Context context){
        this(context,null);
    }

    public MyListView(Context context, AttributeSet attrs){
        this(context,attrs,-1);
    }

    public MyListView(Context context, AttributeSet attrs,int instytle){
        super(context,attrs,instytle);
        mOverScroller = new OverScroller(context);
    }


    @Override
    public void computeScroll() {
        // 第三步，重写computeScroll()方法，并在其内部完成平滑滚动的逻辑
        if (mOverScroller.computeScrollOffset()) {
            Log.w("lava_Log","mOverScroller.getCurrX() " +mOverScroller.getCurrX());
            Log.w("lava_Log","mOverScroller.getCurrY() " +mOverScroller.getCurrY());
            scrollTo(mOverScroller.getCurrX(), mOverScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothBy(int startX,int StartY,int finalX,int finlayY){
        mOverScroller.startScroll(startX,StartY,finalX,finlayY);
    }

}
