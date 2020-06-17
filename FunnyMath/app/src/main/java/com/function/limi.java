package com.function;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.example.funnymath.R;
import java.util.ArrayList;
import java.util.List;

public class limi extends Activity{//每次都忘记声明！！！！
    private ViewPager mPager;// 页卡内容
    private List<View> listViews; // Tab页面列表
    private View page0;
    private View page1;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limi);//将xml文件引入到class文件中
        InitViewPager(); // 初始化ViewPager
    }

    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.vPager);//连个页面相加
        listViews = new ArrayList<View>();//实例化listview
        LayoutInflater mInflater = getLayoutInflater();
        page0 = mInflater.inflate(R.layout.limi1, null);
        page1 = mInflater.inflate(R.layout.limi2, null);

        listViews.add(page0);//viewpager数据源
        listViews.add(page1);



        mPager.setAdapter(new MyPagerAdapter(listViews));//将自定义的页面加入带标题的页面中
    }
    //适配器加错！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public class MyPagerAdapter extends PagerAdapter {//viewpager实现的是三个三个页面的加载
        public List<View> mListViews;//

        public MyPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//把viewlist
        }
        @Override
        public void finishUpdate(View arg0) {
        }

        @Override
        public int getCount() {//返回页卡数量
            return mListViews.size();
        }

        @Override//实例化一个页卡
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(mListViews.get(arg1));
            return mListViews.get(arg1);
        }

        public void destroyItem(View arg0, int arg1, Object arg2) {//移除页卡
            ((ViewPager) arg0).removeView(mListViews.get(arg1));
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == (arg1);
        }//判断当前view是否来自于对象

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
    }

}


