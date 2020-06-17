package com.data;



import java.util.Random;

public class MeterData
{
  String question;
    int    answer, ans1, ans2, ans3;
Random random=new Random();
    int lengthcm=random.nextInt(50);
    int startcm=random.nextInt(50)+lengthcm;
int mi=random.nextInt(3);
    int mimax=random.nextInt(3)+mi;
    int a=random.nextInt(7);
    public MeterData() {
        switch (a) {
            case 0:
                question = "木材长" +lengthcm +"cm刻度上，木材的最后一端离尺子末端距离为在" +startcm+"cm，求尺子至少多长？";
                answer =startcm+lengthcm ;
                ans1 = startcm+lengthcm+random.nextInt(10);
                ans2 = startcm-lengthcm-random.nextInt(10);
                ans3 =startcm+lengthcm+random.nextInt(10);
                break;
            case 1:
                question = "小明与小青拿了一段开头断了一截的卷尺测量一根木材的长度，木材一端在"+lengthcm +"厘米的刻度上，另一端在" +startcm+"厘米的刻度上，这根木材长多少？";
                answer =startcm-lengthcm ;
                ans1 = startcm-lengthcm+random.nextInt(10);
                ans2 = startcm-lengthcm-random.nextInt(10);
                ans3 =startcm-lengthcm+random.nextInt(10);
                break;
            case 2:
                question ="用卷尺测量一根木材的长度，木材的一端在"+mi+"米"+lengthcm +"厘米刻度上，另一端在"+mimax+"米刻度上，这根木材长多少厘米？";
                answer =Math.abs(mimax*100-(mi*100+lengthcm));
                ans1 = answer+random.nextInt(10);
                ans2 =  answer-random.nextInt(10);
                ans3 =  answer-random.nextInt(10);
                break;
            case 3:
                question = "陈燕与李萍量一个花坛长度，她们将卷尺的"+mi+"米"+lengthcm +"厘米的刻度对准花坛的一端，另一端是"+mimax+"米这个花坛长多少？";
                answer =Math.abs(mimax*100-(mi*100+lengthcm));
                ans1 = answer+random.nextInt(10);
                ans2 =  answer-random.nextInt(10);
                ans3 =  answer-random.nextInt(10);
                break;
            case 4:
                question = "李玲一个人用自己的卷尺测量绳子的长度用脚踩着卷尺的一端，正好踩去" +lengthcm +"厘米长，在另一头的刻度是"+startcm+"厘米，李玲绳子的长度是多少？";
                answer =startcm-lengthcm ;
                ans1 = startcm-lengthcm+random.nextInt(10);
                ans2 = startcm-lengthcm-random.nextInt(10);
                ans3 =startcm-lengthcm+random.nextInt(10);
                break;
            case 5:
                question ="已知东西长度" +lengthcm+"厘米东西后端在"+startcm+"米刻度上，从哪开始测量的？";
                answer =Math.abs(startcm*100-lengthcm);
                ans1 = answer+random.nextInt(10);
                ans2 =  answer-random.nextInt(10);
                ans3 =  answer-random.nextInt(10);
                break;
            case 6:
                question = "小明与小青拿了一段开头断了一截的卷尺测量一根木材的长度，木材一端在"+mi+"米"+lengthcm +"厘米的刻度上，另一端在"+mimax+"米"+startcm+"厘米的刻度上，这根木材长多少？";
                answer = Math.abs((mimax*100+startcm)-(mi*100+lengthcm));
                ans1 = startcm-lengthcm+random.nextInt(10);
                ans2 = startcm-lengthcm-random.nextInt(10);
                ans3 =startcm-lengthcm+random.nextInt(10);
                break;
            case 7:
                question = "小明与小青拿了一段开头断了一截的卷尺测量一根木材的长度，木材一端在"+mi+"米"+lengthcm +"厘米的刻度上，另一端在"+mimax+"米"+startcm+"厘米的刻度上，这根木材长多少？";;
                answer = Math.abs((mimax*100+startcm)-(mi*100+lengthcm));
                ans1 = startcm-lengthcm+random.nextInt(10);
                ans2 = startcm-lengthcm-random.nextInt(10);
                ans3 =startcm-lengthcm+random.nextInt(10);
                break;

        }

    }

    public String getQuestion() {
        return question;
    }

    public int  getAnswer() {
        return answer;
    }

    public   int getAns1() {
        return ans1;
    }

    public   int  getAns2() {
        return ans2;
    }

    public    int getAns3() {
        return ans3;
    }

}
