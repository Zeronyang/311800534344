package util;

import entity.Fraction;

import java.util.Random;

/**
 * 分数操作工具类
 */
public class FractionUtil {

    private static Random random = new Random(100);

    public static Fraction CreatFraction(int num) {
        int numerator, denominator;
        numerator = (int) (random.nextInt(num));//分子取0--num的随机数
        denominator = (int) (random.nextInt(num) + 1);//分母取1--num的随机数
        Fraction frac = new Fraction(numerator, denominator);
        return frac;
    }//创建随机分数

    public static Fraction add(Fraction f1, Fraction f2) {

        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fm2 + fm1 * fz2, fm1 * fm2);
        return f;

    }//加法运算

    public static Fraction sub(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fm2 - fm1 * fz2, fm1 * fm2);
        return f;
    }//减法运算

    public static Fraction mul(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fz2, fm1 * fm2);
        return f;
    }//乘法运算

    public static Fraction div(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fm2, fm1 * fz2);
        return f;
    }//除法运算

    public static boolean compare(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        if (fz1 * fm2 >= fz2 * fm1) {
            return true;
        } else
            return false;
    }//比较两分数的大小

    public static Fraction calculate(Fraction f1, Fraction f2, char opt) {
        switch (opt) {
            case '+':
                return add(f1, f2);
            case '-':
                return sub(f1, f2);
            case '*':
                return mul(f1, f2);
            case '÷':
                return div(f1, f2);
            default:
                return null;
        }
    }


}