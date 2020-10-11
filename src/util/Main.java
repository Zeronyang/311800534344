package util;

import entity.Generics.TwoTuple;
import service.Creatformula;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		  //��������Ƿ���Ч��������Ϊparameter��fileName������
        ArrayList<String> parameters = new ArrayList<>();
        int expAmount ;
        int numRange ;
        String numRegex = "[0-9]+";
        String input;
        for (String arg : args) {
            //�ж��Ƿ�Ϊ����
        	parameters.add(arg);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("��������Ŀ��Ŀ");
        do {
            input = scanner.next();
            if(isNumeric(input)){
                expAmount = Integer.parseInt(input);
                break;
            }
            System.out.println("�����������������");
        }while (true);

        System.out.println("��������ֵ��Χ");
        do {
            input = scanner.next();
            if(isNumeric(input)){
                numRange = Integer.parseInt(input);
                break;
            }
            System.out.println("�����������������");
        }while (true);


        Creatformula Gen = new Creatformula(numRange);
        TwoTuple<String,String> twoTuple = Gen.expBuilder(expAmount);
        FileUtil.write("exercise.txt", twoTuple.first);
        FileUtil.write("answer.txt", twoTuple.second);
        System.out.println("��Ŀ���ɳɹ�");
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
