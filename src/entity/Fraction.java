package entity;

/**
 * 分数实体类
 */
public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction() {
    	
    }
    public Fraction(int numerator, int denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
        this.simplify(numerator, denominator);
    }

    public static int GCD(int m, int n) {
        if(m<n) {//保证被除数大于除数
        	int temp = m;
        	m = n;
        	n = temp;
        }
       
        while(m%n != 0) {//在余数不能为0时，进行循环
        	int temp = m%n;
        	m = n;
        	n = temp;
        }
        return n; //返回最大公约数
    }

    //化简分数
    public void simplify(int numerator, int denominator) { 
    	if(numerator!=0) {
    		int GCD = GCD(numerator, denominator);
            this.numerator = numerator / GCD;
            this.denominator = denominator / GCD;

    	}
    }

    @Override
    public String toString() {
    
    	int integer=numerator/denominator;
    	
    	int remainder=numerator % denominator;
        if (numerator == 0) {
            return 0 + "";
        } else if (remainder == 0) {
            return integer + "";
        } else {	
        	if(integer == 0){
        		return numerator + "/" + denominator;
        	}else{
        		return ""+integer+"'"+remainder+"/"+denominator;
        	}
        }
    }//改写toString，输出为分数形式

    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fraction other = (Fraction) obj;
        if (denominator != other.denominator)
            return false;
        if (numerator != other.numerator)
            return false;
        return true;
    }
    public boolean greater(Fraction f1) {
    	if(f1==null)
    		return false;
    	if(this.numerator*f1.denominator>=this.denominator*f1.numerator) {
    		return true;
    	}else {
    		return false;
    	}
    }


}

