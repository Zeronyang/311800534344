package util;

import entity.Generics.TwoTuple;
import service.Creatformula;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		  //检验参数是否有效，并保存为parameter和fileName两部分
        ArrayList<String> parameters = new ArrayList<>();
        int expAmount ;
        int numRange ;
        String numRegex = "[0-9]+";
        String input;
        for (String arg : args) {
            //判断是否为参数
        	parameters.add(arg);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入题目数目");
        do {
            input = scanner.next();
            if(isNumeric(input)){
                expAmount = Integer.parseInt(input);
                break;
            }
            System.out.println("输入错误，请重新输入");
        }while (true);

        System.out.println("请输入数值范围");
        do {
            input = scanner.next();
            if(isNumeric(input)){
                numRange = Integer.parseInt(input);
                break;
            }
            System.out.println("输入错误，请重新输入");
        }while (true);


        Creatformula Gen = new Creatformula(numRange);
        TwoTuple<String,String> twoTuple = Gen.expBuilder(expAmount);
        FileUtil.write("exercise.txt", twoTuple.first);
        FileUtil.write("answer.txt", twoTuple.second);
        System.out.println("题目生成成功");
        System.out.println();
        System.exit(0);

	}

    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }
}
