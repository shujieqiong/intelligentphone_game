package com.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;

//import java.util.ArrayList;
//import java.util.Iterator;
import org.apache.commons.logging.Log;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class CountAngleData extends dataBaseObject {
    private static final String TAG = "shujiaodata";
    private Bitmap QuestionBitmap;
    private int answer;

   private int jiaoshu = 0;

    public Bitmap getQuestionBitmap() {
        return QuestionBitmap;
    }
    public void setQuestionBitmap() {
        triShape();
    }


    private void triShape() {

        PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        QuestionBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(QuestionBitmap);
        Random mRandom = new Random();

        // Point mPoint1 = new Point();
        int dianshu = mRandom.nextInt(5) + 3;
        Point[] point = new Point[dianshu];
        int quanju=1;
       double  dushu  = 0.00;
       double  dushu1=0.0;
        double dushu2=0.0;
double pingfang=0.0;
      //  point[0] = new Point(0,0);
        point[0] = new Point(20,50);
        for (int i = 1; i < dianshu; ) {
            Random p1 = new Random();
            int X1 = p1.nextInt(100);
            Random p2 = new Random();
            int Y1 = p2.nextInt(100);
            dushu2 = Math.atan(Math.abs(Y1 - 0.0) / Math.abs(X1 - 0.0)) / Math.PI * 180;
            pingfang=Math.sqrt(X1*X1+Y1*Y1);
            if(pingfang>15) {
                if (dushu2 > 5) {
                    for (int n = 0; n <= quanju - 1; n++) {
                        dushu = Math.atan(Math.abs(Y1 - 0.0) / Math.abs(X1 - 0.0)) / Math.PI * 180;
                        dushu1 = Math.atan(Math.abs(point[n].y - 0.0) / Math.abs(point[n].x - 0.0)) / Math.PI * 180;
                        if (Math.abs(dushu - dushu1) >= 10)//数字数字这数字很大的问题！！！！！！！！
                        {
                            if (n == quanju - 1) {
                                point[i] = new Point(X1, Y1);
                                i++;
                                quanju++;
                                break;
                            }
                        } else break;

                    }
                }
            }
        }

        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        canvas.setDrawFilter(pfd);
        mPaint.setStrokeWidth(1);
       // Random suiji = new Random();
      // int sui = suiji.nextInt(dianshu);
       //����ӵ���ȡ��һ�����Ϊ���㣬����ͼ��
        int w;
        for (w = 0; w < dianshu; w++)
        {  canvas.drawLine(0, 0, point[w].x, point[w].y, mPaint);
        }
        int j;
        int i;
         for (i = 0; i <= dianshu-1; i++)
            for (j = i + 1; j <=dianshu-1; j++)
                jiaoshu++;
        canvas.save();
        canvas.restore();}


        //  canvas.drawLine(pointO.x, pointO.y, point2.x, point2.y, mPaint);

    public String getAnswer() {

            return "" + jiaoshu;

    }

    public String getAnswer1() {


            return "" + (jiaoshu + 2);

    }

    public String getAnswer2() {

        return "" + (jiaoshu + 3);

    }

    public String getAnswer3() {
        return "" + (jiaoshu + 4);
    }


    //PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);
    //   QuestionBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    //  if (type == 0) {
    ///    pointO = new Point(10, 90);//����point�ཨ��������
    // point1 = new Point(90, 90);
    //  point2 = getPointOne(pointO, point1, 80, 60);
    //  Canvas canvas = new Canvas(QuestionBitmap);

           /* Paint mPaint = new Paint();
            mPaint.setAntiAlias(true);
            canvas.setDrawFilter(pfd);
            mPaint.setStrokeWidth(1);
            canvas.drawLine(pointO.x, pointO.y, point1.x, point1.y, mPaint);
            canvas.drawLine(pointO.x, pointO.y, point2.x, point2.y, mPaint);*/
         /*   int a = 60 / triNum;
            int b = a;
            for (int i = 0; i < (triNum - 2); i++) {
                point2 = getPointOne(pointO, point1, 80, b + a * i);
                canvas.drawLine(10, 90, point2.x, point2.y, mPaint);
            }
            canvas.save();
            canvas.restore();
        } else {
            pointO = new Point(50, 10);
            point1 = new Point(10, 90);
            point2 = new Point(90, 90);
            Canvas canvas = new Canvas(QuestionBitmap);
            Paint mPaint = new Paint();
            mPaint.setAntiAlias(true);
            canvas.setDrawFilter(pfd);
            mPaint.setStrokeWidth(1);
            canvas.drawLine(pointO.x, pointO.y, point1.x, point1.y, mPaint);
            canvas.drawLine(pointO.x, pointO.y, point2.x, point2.y, mPaint);
            canvas.drawLine(point1.x, point1.y, point2.x, point2.y, mPaint);
            int b = 460;
            Set set = new TreeSet();//TreeSetʹ��Ԫ�ص���Ȼ˳���Ԫ�ؽ������򣬻��߸��ݴ��� set ʱ�ṩ�� Comparator �������򣬾���ȡ����ʹ�õĹ��췽����
            //ͨ��һ�㽲�����ǿ��԰����������б���ʾ��Ҳ���԰���ָ���Ĺ�������
          //  Random mRandom = new Random();
         //   Point mPoint1 = new Point();
            while (set.size() < triNum) {
                int a = 8 * (mRandom.nextInt(8)+2);
                if (!set.contains(a)) {
                    set.add(a);
                }
            }
            Iterator<Integer> aaa = set.iterator();//ʹ��next()��������е���һ��Ԫ�ء�
ʹ��hasNext()����������Ƿ���Ԫ�ء�
ʹ��remove()���������·��ص�Ԫ��ɾ����

            while (aaa.hasNext()) {
                b = aaa.next();
                mPoint1.set(b, 90);
                canvas.drawLine(pointO.x, pointO.y, mPoint1.x, mPoint1.y,
                        mPaint);
            }
            canvas.save();
            canvas.restore();
        }

    }








    public String getAnswer() {
        if (type > 1) {
            return "ֱ�Ǹ���Ϊ��" + sqranswer01 + " �ǵĸ���Ϊ��" + sqranswer00;
        } else {
            return "" + answer;
        }
    }

    public String getAnswer1() {

        if (type > 1) {
            return "ֱ�Ǹ���Ϊ��" + sqranswer11 + " �ǵĸ���Ϊ��" + sqranswer10;
        } else {
            return "" + (answer + 2);
        }
    }

    public String getAnswer2() {

        if (type > 1) {
            return "ֱ�Ǹ���Ϊ��" + sqranswer21 + " �ǵĸ���Ϊ��" + sqranswer20;
        } else {
            return "" + (answer + 1);
        }

    }

    public String getAnswer3() {
        if (type > 1) {
            return "ֱ�Ǹ���Ϊ��" + sqranswer31 + " �ǵĸ���Ϊ��" + sqranswer30;
        } else {
            return "" + (answer - 1);
        }
    }*/

    @Override
    public void relice() {
        // TODO Auto-generated method stub
        if (QuestionBitmap != null) {
            this.QuestionBitmap.recycle();
        }
    }
}
/*
    private int jiecheng(int a) {
        int b = 1;
        int c = a;
        for (int i = 0; i < (c - 1); i++) {
            a = (a - 1);
            b = b * a;
        }
        return b;
    }

    /**
     * ͨ������Բ��O���뾶R��Բ��һ��A�� �����������תĳ���ǶȺ��
     *
     * @param pointO
     *            ������Բ��
     * @param pointA
     *            ����һ��
     * @param R
     *            ԰�뾶
     * @param intAngel �ƶ��Ƕ�
     * @return �Ը�������ת�����ǶȺ�ĵ�����
     *
     *
     *
     */
    /*public Point getPointOne(Point pointO, Point pointA, int R, double intAngel) {
        Point returnPoint = new Point();

        // ������֪����X��ļн�
        int ang = (int) getAngleOne(pointO, pointA);
        intAngel += Math.abs(ang);

        // ��ʼ�����ж�
        float tmp = (float) (intAngel * 1.0f) + 360;
        float rf = 0;

        tmp = tmp % 360;
        if (tmp >= 0 && tmp < 90) {
            rf = (float) (tmp / 180.0f * Math.PI);
            returnPoint.x = (int) (pointO.x + R * Math.cos(rf));
            returnPoint.y = (int) (pointO.y - R * Math.sin(rf));
        }
        if (tmp >= 90 && tmp < 180) {
            tmp = 180 - tmp;
            rf = (float) (tmp / 180.0f * Math.PI);
            returnPoint.x = (int) (pointO.x - R * Math.cos(rf));
            returnPoint.y = (int) (pointO.y - R * Math.sin(rf));
        }
        if (tmp >= 180 && tmp < 270) {
            tmp = tmp - 180;
            rf = (float) (tmp / 180.0f * Math.PI);
            returnPoint.x = (int) (pointO.x - R * Math.cos(rf));
            returnPoint.y = (int) (pointO.y + R * Math.sin(rf));
        }
        if (tmp >= 270 && tmp < 360) {
            tmp = 360 - tmp;
            rf = (float) (tmp / 180.0f * Math.PI);
            returnPoint.x = (int) (pointO.x + R * Math.cos(rf));
            returnPoint.y = (int) (pointO.y + R * Math.sin(rf));
        }

        return returnPoint;
    }
/*
    /**
     * ͨ������Բ��O,����һ�� ���ص��Բ����X���γɵĽǶ�
     *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
   /*private double getAngleOne(Point pointO, Point pointA) {

        double dblAngle = 0;

        // ������֪����X��ļн�

        if (pointA.x >= pointO.x && pointA.y < pointO.y) {
            dblAngle = Math.atan(Math.abs(pointA.y - pointO.y) * 1.0f//���ؽǵķ����У���Χ�� -pi/2 �� pi/2 ֮�䡣 math.abs����float����ֵ,Y��X���Tan,��תΪ��
                    / Math.abs(pointA.x - pointO.x) * 1.0f)
                    / Math.PI * 180;
        }

        if (pointA.x >= pointO.x && pointA.y >= pointO.y) {
            dblAngle = Math.atan(Math.abs(pointA.y - pointO.y) * 1.0f
                    / Math.abs(pointA.x - pointO.x) * 1.0f)
                    / Math.PI * 180;
            dblAngle = 360 - dblAngle;
        }

        if (pointA.x < pointO.x && pointA.y >= pointO.y) {
            dblAngle = Math.atan(Math.abs(pointA.y - pointO.y) * 1.0f
                    / Math.abs(pointA.x - pointO.x) * 1.0f)
                    / Math.PI * 180;
            dblAngle = 180 + dblAngle;
        }

        if (pointA.x < pointO.x && pointA.y < pointO.y) {
            dblAngle = Math.atan(Math.abs(pointA.y - pointO.y) * 1.0f
                    / Math.abs(pointA.x - pointO.x) * 1.0f)
                    / Math.PI * 180;
            dblAngle = 180 - dblAngle;
        }
        return dblAngle;
    }*/
