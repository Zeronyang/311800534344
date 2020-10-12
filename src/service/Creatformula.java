package service;

import entity.Formula;
import entity.Fraction;
import entity.Generics.TwoTuple;
import util.FractionUtil;

import java.util.Random;

import static entity.Generics.Tuple.tuple;

/**
 * ��ʽ������
 */

public class CreatFormula {

    public CreatFormula(int num) {
        this.num = num;
    }

    private static Random random = new Random(47);
    private int num;

    private Formula createFor(Formula F1) {
        Formula F2 = new Formula();
        char symbol = '+';
        int choice=random.nextInt(4);
        switch (choice) {
            case 0:
                symbol = '+';
                break;
            case 1:
                symbol = '-';
                break;
            case 2:
                symbol = '*';
                break;
            case 3:
                symbol = '��';
                break;

            default:
                break;
        }
        Fraction formula1 = FractionUtil.CreatFraction(num);
        if ((F1.getExpression()).equals("")) {//��ʽ��Ϊ��
            Fraction formula = FractionUtil.CreatFraction(num);
            if (formula1.getNumerator() == 0 && symbol == '��')
                //���ⱻ������0�����
                symbol = '+';
            if (!formula.greater(formula1) && symbol == '-') {
                //������ָ���
                F2.setExpression("" + formula1 + symbol + formula);
                F2.setFraction(FractionUtil.calculate(formula1, formula, symbol));
            } else {
                F2.setExpression("" + formula + symbol + formula1);
                F2.setFraction(FractionUtil.calculate(formula, formula1, symbol));
            }

        } else {//��ʽ��Ϊ��,������ԭ��ʽ�ϼ������
            if (random.nextBoolean()) {
                //���������ӵ�λ��
                //�����ɵļ���ԭ�������
                if (formula1.getNumerator() == 0 && symbol == '��')
                    //���ⱻ������0�����
                    symbol = '+';
                if (!F1.getFraction().greater(formula1) && symbol == '-') {
                    //������ָ���
                    F2.setExpression("" + formula1 + symbol + "(" + F1 + ")");
                    F2.setFraction(FractionUtil.calculate(formula1, F1.getFraction(), symbol));
                } else {
                    F2.setExpression("(" + F1 + ")" + symbol + formula1);
                    F2.setFraction(FractionUtil.calculate(F1.getFraction(), formula1, symbol));
                }

            } else {//�����ɵļ���ԭ�����ұ�
                if (F1.getFraction().getNumerator() == 0 && symbol == '��')
                    symbol = '+';
                //���ⱻ������0�����
                if (F1.getFraction().greater(formula1) && symbol == '-') {
                    //������ָ���
                    F2.setExpression("(" + F1 + ")" + symbol + formula1);
                    F2.setFraction(FractionUtil.calculate(F1.getFraction(), formula1, symbol));
                } else {
                    F2.setExpression("" + formula1 + symbol + "(" + F1 + ")");
                    F2.setFraction(FractionUtil.calculate(formula1, F1.getFraction(), symbol));
                }

            }
        }
        return F2;
    }

    public TwoTuple<String, String> expBuilder(int exAmount) {
        StringBuilder extext = new StringBuilder();
        StringBuilder anstext = new StringBuilder();
        for (int i = 1; i <= exAmount; i++) {
            Formula F3 = new Formula();
            int Num = random.nextInt(3) + 1;
            //���ɵ�ʽ��������4������3���������
            for (int n = 0; n < Num; n++) {
                F3 = createFor(F3);
            }
            //���ɵ���Ŀ�Ͷ�Ӧ�Ĵ�
            extext.append(i + ". " + F3.getExpression() + "=" + "\n");
            anstext.append(i + ". " + F3.getFraction() + "\n");
        }
        return tuple(extext.toString(), anstext.toString());
    }


}
