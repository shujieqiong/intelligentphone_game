package com.data;

import java.util.Random;

public class InEquationData {

    Random random = new Random();
    String question;
    char answer;

    public InEquationData() {

        int num, num1,num3, num2;

        num = random.nextInt(10);
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        num3=random.nextInt(10);
        question = "请在横杠处填入正确的符号："+num1 + "*" + num + "__" + num2 + "*"+num3;
        if (num1*num < num2*num3) {
            answer = '<';
        } else if (num1*num < num2*num3) {
            answer = '=';
        } else {
            answer = '>';
        }

    }

    public char getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
