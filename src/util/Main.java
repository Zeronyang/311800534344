package util;

import entity.Generics.TwoTuple;
import service.Check;
import service.CreatFormula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("程序功能：");
        System.out.println("【1】生成作业 【2】批改作业 【3】退出程序");
        System.out.print("请选择功能：");
        Scanner scanner = new Scanner(System.in);
        String func = scanner.next();
        if (func.equals("2")) {
            try {
                Check.check("useranswer.txt", "answer.txt", "Grade.txt");
            } catch (IOException e) {
            }
            return;
        } else if (func.equals("1")) {
            ArrayList<String> parameters = new ArrayList<>();
            int expAmount;
            int numRange;
            String input;
            String numRegex = "[0-9]+";
            for (String arg : args) {
                //判断是否为参数
                parameters.add(arg);
            }
            System.out.println("请输入题目数目");
            do {
                input = scanner.next();
                if (isNum(input)) {
                    expAmount = Integer.parseInt(input);
                    break;
                }
                System.out.println("输入错误，请重新输入");
            } while (true);

            System.out.println("请输入数值范围");
            do {
                input = scanner.next();
                if (isNum(input)) {
                    numRange = Integer.parseInt(input);
                    break;
                }
                System.out.println("输入错误，请重新输入");
            } while (true);

            CreatFormula CF = new CreatFormula(numRange);
            TwoTuple<String, String> twoTuple = CF.expBuilder(expAmount);
            FileUtil.write("exercise.txt", twoTuple.first);
            FileUtil.write("answer.txt", twoTuple.second);
            System.out.println("题目生成成功！");
            System.out.println("若需批改请将答案输入【useranswer.txt】文件中");
        }else{}
        System.out.println();
        System.exit(0);
    }

    public static boolean isNum(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }
}
