package service;

import entity.Formula;
import entity.Fraction;
import entity.Generics.TwoTuple;
import util.FractionUtil;

import java.util.Random;

import static entity.Generics.Tuple.tuple;

/**
 * 算式生成类
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
                symbol = '÷';
                break;

            default:
                break;
        }
        Fraction formula1 = FractionUtil.CreatFraction(num);
        if ((F1.getExpression()).equals("")) {//算式若为空
            Fraction formula = FractionUtil.CreatFraction(num);
            if (formula1.getNumerator() == 0 && symbol == '÷')
                //避免被除数是0的情况
                symbol = '+';
            if (!formula.greater(formula1) && symbol == '-') {
                //避免出现负数
                F2.setExpression("" + formula1 + symbol + formula);
                F2.setFraction(FractionUtil.calculate(formula1, formula, symbol));
            } else {
                F2.setExpression("" + formula + symbol + formula1);
                F2.setFraction(FractionUtil.calculate(formula, formula1, symbol));
            }

        } else {//算式若为空,继续在原算式上继续添加
            if (random.nextBoolean()) {
                //随机决定添加的位置
                //新生成的加在原来的左边
                if (formula1.getNumerator() == 0 && symbol == '÷')
                    //避免被除数是0的情况
                    symbol = '+';
                if (!F1.getFraction().greater(formula1) && symbol == '-') {
                    //避免出现负数
                    F2.setExpression("" + formula1 + symbol + "(" + F1 + ")");
                    F2.setFraction(FractionUtil.calculate(formula1, F1.getFraction(), symbol));
                } else {
                    F2.setExpression("(" + F1 + ")" + symbol + formula1);
                    F2.setFraction(FractionUtil.calculate(F1.getFraction(), formula1, symbol));
                }

            } else {//新生成的加在原来的右边
                if (F1.getFraction().getNumerator() == 0 && symbol == '÷')
                    symbol = '+';
                //避免被除数是0的情况
                if (F1.getFraction().greater(formula1) && symbol == '-') {
                    //避免出现负数
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
            //生成的式子最多包含4个数，3个运算符号
            for (int n = 0; n < Num; n++) {
                F3 = createFor(F3);
            }
            //生成的题目和对应的答案
            extext.append(i + ". " + F3.getExpression() + "=" + "\n");
            anstext.append(i + ". " + F3.getFraction() + "\n");
        }
        return tuple(extext.toString(), anstext.toString());
    }


}
