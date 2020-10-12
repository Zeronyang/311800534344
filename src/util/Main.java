package util;

import entity.Generics.TwoTuple;
import service.Check;
import service.CreatFormula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("�����ܣ�");
        System.out.println("��1��������ҵ ��2��������ҵ ��3���˳�����");
        System.out.print("��ѡ���ܣ�");
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
                //�ж��Ƿ�Ϊ����
                parameters.add(arg);
            }
            System.out.println("��������Ŀ��Ŀ");
            do {
                input = scanner.next();
                if (isNum(input)) {
                    expAmount = Integer.parseInt(input);
                    break;
                }
                System.out.println("�����������������");
            } while (true);

            System.out.println("��������ֵ��Χ");
            do {
                input = scanner.next();
                if (isNum(input)) {
                    numRange = Integer.parseInt(input);
                    break;
                }
                System.out.println("�����������������");
            } while (true);

            CreatFormula CF = new CreatFormula(numRange);
            TwoTuple<String, String> twoTuple = CF.expBuilder(expAmount);
            FileUtil.write("exercise.txt", twoTuple.first);
            FileUtil.write("answer.txt", twoTuple.second);
            System.out.println("��Ŀ���ɳɹ���");
            System.out.println("���������뽫�����롾useranswer.txt���ļ���");
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
