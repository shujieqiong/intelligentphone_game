package com.data;

import java.util.Random;

public class TableData {

    Random random = new Random();
    String question;
   String  answer;
    String answer1;
    String answer2;
    String answer3;
   // String [] a= new String[]{"*","+","-","/" };
    int sum;

    public TableData() {
        int x = random.nextInt(9) + 2;
        int y = random.nextInt(9) + 2;
        int z = random.nextInt(50) + 1;
        int suiji1=random.nextInt(3);
         int suiji2=random.nextInt(3);

        switch (suiji1){
            case 0:{switch (suiji2)
                           {case 0:{sum=x*y*z; answer = "*   *   =";
                               answer1 = "+   *   =";
                               answer2 = "+   -   =";
                               answer3 = "-  -  =";
                                       break;}
                               case 1:{sum=x*y+z; answer = "*   +   =";
                                   answer1 = "+   *   =";
                                   answer2 = "+   -   =";
                                   answer3 = "*   +   =";
                                                    break;}
                               case 2:{sum=x*y-z; answer = "*   -   =";
                                   answer1 = "+   +   =";
                                   answer2 = "+   *   =";
                                   answer3 = "/   +   =";
                                           break;}

                                      }

                 }
            case 1:{switch(suiji2)
            {case 0:{sum=x+y*z; answer = "+   *   =";
                answer1 = "/   *   =";
                answer2 = "/   +   =";
                answer3 = "-   +   =";
                       break;}
                case 1:{sum=x+y+z; answer = "+   +   =";
                    answer1 = "-   -   =";
                    answer2 = "*  +   =";
                    answer3 = "*   *   =";
                       break;}
                case 2:{sum=x+y-z; answer = "+   -   =";
                    answer1 = "+   *   =";
                    answer2 = "/   +   =";
                    answer3 = "-   +   =";
                    break;}

            }
            }
            case 2:
            {
                switch (suiji2)
                {
                    case 0:{sum=x-y*z;
                        answer ="-   *   =";
                        answer1 = "+   *   =";
                        answer2 = "+   -  =";
                        answer3 = "+   + =";
                        break;}
                    case 1:{sum=x-y+z; answer = "-   +   =";
                        answer1 = "+   *   =";
                        answer3 = "+   -   =";
                        answer2 = "*   -   =";
                        break;}
                    case 2:{sum=x-y-z; answer = "-   -   =";
                        answer3 = "+   *   =";
                        answer2 = "+   =   *";
                        answer1 = "*   *   =";
                        break;}

                }
            }


           /* case 3:{
                switch (suiji2)
                {case 0:{sum=x/y*z; answer = "/   +   =";
                    answer1 = "+   *   =";
                    answer2 = "+  -  =";
                    answer3 = "-  +   =";
                    break;}
                    case 1:{sum=x/y+z;
                        answer1 = "-   -   =";
                        answer3= "*  +   =";
                        answer2 = "*   *   =";
                        break;}
                    case 2:{sum=x/y-z;
                        answer3 = "-   -   =";
                        answer2 = "*  +   =";
                        answer1 = "*   *   =";
                        break;}


                }*/
            }





        question = "请在横线处填上合适的符号："+x+"__"+y+"__"+z+"__"+sum;

    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

}
