package com.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;


public class CommonVoid {
    private static final String TAG = "commomvoid";


    public static CountAngleData makeShuJiaoQuestion() {
        CountAngleData mShujiaodata = new CountAngleData();
        Random mRandom = new Random();
        int state = mRandom.nextInt(2);

        ;
        switch (state) {
            case 0:

                mShujiaodata.setQuestionBitmap();

                break;
            case 1:

                mShujiaodata.setQuestionBitmap();

                break;
            default:
                break;
        }
        return mShujiaodata;
    }

    private static float base = 10;
    private static float formH = 100;
    private static float formW = 100;

    public static ResolveDigitalData makefenjieshuquestion() {
        ResolveDigitalData mFenjieshudata = new ResolveDigitalData();
        PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0,
                Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        Random mRandom = new Random();
        int tarNumber = mRandom.nextInt(5) + 2;
        mFenjieshudata.setBaseNumber(mRandom.nextInt(3) + 1);
        mFenjieshudata.setTarNumber(tarNumber);
        mFenjieshudata.getAnswer1();
        mFenjieshudata.getAnswer2();
        mFenjieshudata.getQuestion();
        Bitmap mbmpTest = Bitmap.createBitmap(((int) formW + 30),// 根据参数创建新位图
                ((int) formH + 30), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mbmpTest);
        Paint paint = new Paint();
        paint.setAntiAlias(true);//Canvas就是提供了众多方法操作Bitamp的平台；
        canvas.setDrawFilter(pfd);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(new Rect(((int) base), ((int) base),//绘制一个矩型
                ((int) (formW + base)), ((int) (formH + base))), paint);
        canvas.drawLine(base, formH / 3, formW + base, formH / 3, paint);
        canvas.drawLine(base, formH / 3 * 2, formW + base, formH / 3 * 2, paint);//画三条线
        float each = formW / tarNumber;
        for (int i = 0; i < (tarNumber); i++) {
            canvas.drawLine(base + each * (i + 1), formH / 3, base + each
                    * (i + 1), formH + base, paint);
            canvas.drawLine(base + each * (i + 1) - (each / 2), formH / 3 * 2,
                    base + each * (i + 1) - (each / 2), formH + base, paint);
        }
        paint.setColor(Color.RED);
        paint.setTextSize(7);
        canvas.drawText("" + mFenjieshudata.getQuestion(), formW / 2 + base,//canvas.drawText(text, x, y, paint)，第一个参数是我们需要绘制的文本，第四个参数是我们的画笔，这两个不用多说，主要是第二和第三个参数的含义，这两个参数在不同的情况下的值还是不一样的，x默认是这个字符串的左边在屏幕的位置，如果设置了paint.setTextAlign(Paint.Align.CENTER);那就是字符的中心，y是指定这个字符baseline在屏幕上的位置
                formH / 6 + base, paint);
        for (int i = 0; i < tarNumber; i++) {
            canvas.drawText("B", base + each * (i + 1) - (each / 2), formH / 2
                    + base, paint);
            canvas.drawText("A", base + each * (i + 1) - (each / 4 * 3), formH
                    / 6 * 5 + base, paint);
            canvas.drawText("A", base + each * (i + 1) - (each / 4), formH / 6
                    * 5 + base, paint);
        }
        canvas.save();
        canvas.restore();
        mFenjieshudata.setmBitmap(mbmpTest);
        return mFenjieshudata;
    }


    public static ArrayList<VerticalFormulaData> makeshushitianci(
            ArrayList<VerticalFormulaData> mDatalist) {
        ArrayList<VerticalFormulaData> mBaseDatalist = mDatalist;
        Random mRandom = new Random();
        return testnumber(mBaseDatalist);

    }

    private static ArrayList<VerticalFormulaData> testnumber(
            ArrayList<VerticalFormulaData> mBaseDatalist) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num11=0;
        int y;
        int num22=0;
        int num33;
        int FLag=0;
        Random random=new Random();
        while( FLag<=9)
        {
            y = random.nextInt(2)+1;
            Log.e("yag",y+ "");
            if (y == 1) {
                num1 = random.nextInt(70) + 10;
                num2 = random.nextInt(10) + 10;
                num3 = num1 + num2;
                VerticalFormulaData mBaseData = makequestion1(num1, num2, num3, true);
                if (mBaseData != null) {
                    FLag++;
                    mBaseDatalist.add(mBaseData);
                }
            } else {
                num11 = random.nextInt(50) + 50;
                num22 = random.nextInt(30) + 10;
                num33 = num11 - num22;
                VerticalFormulaData mBaseData = makequestion1(num11, num22, num33, false);
                if (mBaseData != null) {
                    FLag++;
                    mBaseDatalist.add(mBaseData);
                }
            }
        }
        return mBaseDatalist;
    }


    private static VerticalFormulaData makequestion1(int num1, int num2,
                                                     int num3, boolean state) {
        VerticalFormulaData mBaseData = new VerticalFormulaData();
        ArrayList<Integer> aaa = new ArrayList<Integer>();

        int a = 0;
        Set testSet = new TreeSet();
        String question = "";
        int X = 0;
        int Y = 0;
        int b = 0;
        int c1 = 0;//
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        c1 = num1 / 10;//将数字分解开来，分解为十位数和个位数
        c2 = num1 % 10;
        c3 = num2 / 10;
        c4 = num2 % 10;
        c5 = num3 / 10;
        c6 = num3 % 10;
        aaa.add(c1);
        aaa.add(c2);
        aaa.add(c3);
        aaa.add(c4);
        aaa.add(c5);
        aaa.add(c6);
       // aaa.add(0);
        if (state) {//为TURE表示加法，satae用来表示是加法还是减法
            question = "" + num1 + " + " + "" + num2 + " == " + "" + num3;
        } else {
            question = "" + num1 + " - " + "" + num2 + " == " + "" + num3;
        }
        int isthree = 0;
        int smenumber = 0;
        if (!testSet.add(c1)) { //：里面有c1执行被if，如果Set集合中不包含要添加的对象，则添加对象并返回true；否则返回false

            if (smenumber == 0) {
                smenumber = c1;
                isthree++;
            } else {
                if (smenumber == c1) {
                    isthree++;
                }
            }

        }
        ;
        if (!testSet.add(c2)) {
            if (smenumber == 0) {
                smenumber = c1;
                isthree++;
            } else {
                if (smenumber == c2) {
                    isthree++;
                }
            }
        }
        ;
        if (!testSet.add(c3)) {
            if (smenumber == 0) {
                smenumber = c3;
                isthree++;
            } else {
                if (smenumber == c3) {
                    isthree++;
                }
            }
        }
        ;
        if (!testSet.add(c4)) {
            if (smenumber == 0) {
                smenumber = c4;
                isthree++;
            } else {
                if (smenumber == c4) {
                    isthree++;
                }
            }
        }
        ;
        if (!testSet.add(c5)) {//加进去c5 11+34=45,虽然执行if，但是smenumber不符合
            if (smenumber == 0) {
                smenumber = c5;
                isthree++;
            } else {
                if (smenumber == c5) {
                    isthree++;
                }
            }
        }
        ;
        if (!testSet.add(c6)) {
            if (smenumber == 0) {
                smenumber = c6;
                isthree++;
            } else {
                if (smenumber == c6) {
                    isthree++;
                }
            }
        }
        ;
        if (testSet.size() == 4 && isthree == 1) {//保证只有2个数一样
            mBaseData.setNum1(num1);
            mBaseData.setNum2(num2);
            mBaseData.setNum3(num3);
            mBaseData.setState(state);//设置状态
            ArrayList<Integer> aaa1 = new ArrayList<Integer>();
            ArrayList<Integer> aaa2 = new ArrayList<Integer>();
            ArrayList<Integer> aaa3 = new ArrayList<Integer>();
            ArrayList<Integer> aaa4 = new ArrayList<Integer>();
            ArrayList<Integer> aaa6 = new ArrayList<Integer>();
            ArrayList<Integer> aaa7 = new ArrayList<Integer>();
            ArrayList<Point> aaa5 = new ArrayList<Point>();
            //ArrayList<Point> aaa3 = new ArrayList<Point>();
            Set mSet = new TreeSet();

            for (int i = 0; i < 6; i++) {//自己和自己遍历，找出一样的点
                for (int j = (i + 1); j < 6; j++) {
                    if (aaa.get(i) == aaa.get(j)) {//如果自己对自己遍历过程中出现相同的数，那么记录他的值和坐标
                        aaa1.add(aaa.get(i));
                        aaa2.add(i);//aa2记录两个相等的值得下标
                        aaa2.add(j);
                        Point mPoint = new Point();//建立一个2个point记录他的值和坐标
                        mPoint.x = aaa.get(i);
                        mPoint.y = j;
                        aaa5.add(mPoint);//aaa5记录的是X一样的值
                        Point mPoint1 = new Point();//
                        mPoint1.x = aaa.get(i);//把ide 值对应x
                        mPoint1.y = i;//i对应y值
                        aaa5.add(mPoint1);//POingt1记录的是值和内层循环的值。2记录值和外层循环的值，aaa3记录
                    } else {
                        aaa3.add(aaa.get(i));//aa3记录与其他值都不一样的i的值
                        aaa4.add(i);
                    }
                }


                //1 2 1 3 2 5
                //  值/aaa1=1 2
                //相同的坐标/aaa2=1 3 2 5
                //aaa3=1111  2222  1111   33  2
                ///aaa4=1111  2222 3333   44   5
                ///aaa5(1,1) (1,3) (2,2) (2,5)
            }
            for(int o=0;o<aaa.size();) {
                int flag=1;
                for (int t = 0; t < aaa2.size(); t++) {
                    if (aaa2.get(t) == o)
                    {   flag = 0;o++;
                    break;}
                }
                if(flag==1)
                { Point mPoint = new Point();//建立一个2个point记录他的值和坐标
                    mPoint.x = aaa.get(o);
                    mPoint.y = o;
                    aaa5.add(mPoint);
                    o++;//aaa5记录的是X一样的值
                }
            }





            mBaseData.setAp(aaa5.get(5));//把值和坐标存进去
            mBaseData.setBp(aaa5.get(4));
            mBaseData.setXp1(aaa5.get(0));//放四个XY坐标的函数
            mBaseData.setXp2(aaa5.get(1));
            mBaseData.setYp1(aaa5.get(2));
            mBaseData.setYp2(aaa5.get(3));
            aaa1.clear();
            aaa1 = null;
            aaa2.clear();
            aaa2 = null;
            aaa3.clear();
            aaa3 = null;
            aaa4.clear();
            aaa4 = null;
            aaa5.clear();
            aaa5 = null;
            aaa6.clear();
            aaa6 = null;
            aaa7.clear();
            aaa7 = null;
            mSet.clear();
            mSet = null;
        } else {
            mBaseData = null;
        }
        aaa.clear();
        aaa = null;
        testSet.clear();
        testSet = null;
        return mBaseData;
    }



}
