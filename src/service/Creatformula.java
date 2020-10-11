package service;

import entity.Formula;
import entity.Fraction;
import entity.Generics.TwoTuple;
import util.FractionUtil;

import java.util.Random;

import static entity.Generics.Tuple.tuple;

/**
 * 生成一份四则运算题目类
 */
public class Creatformula {
	
	public Creatformula(int num) {
		this.num = num;
	}
	private static Random random = new Random(100);
	private  int num ;
	 public static boolean check(String input) {
	       	if (input.matches("[0-9]+")||input.matches("[0-9]+/[0-9]+")) {
	            return true;
	        } else
	            return false;
	  }
	  //用正则表达式处理

	 private Formula createExp(Formula expBean1) {
		 Formula expBean=new Formula();
	    	Boolean flagZero = false;
	    	Fraction f2= FractionUtil.CreatFraction(num);

	    	//随机设置f2自然数
	    	if(random.nextBoolean()){
				f2.setDenominator(1);
			}
	        char opt = '+';
	        switch(random.nextInt(4))  {
	            case 0 : opt = '+';    break;
	            case 1 : opt = '-';    break;
	            case 2 : opt = '*';    break;
	            case 3 : opt = '÷';    break;

	            default: break;
	        };
	       
	        if((expBean1.getExpression()).equals("")) {
	        	Fraction f1= FractionUtil.CreatFraction(num);
	        	if(f2.getNumerator()==0&&opt=='÷')
	        		opt = '+';
	        	if(!f1.greater(f2)&&opt=='-') {
	        		expBean.setExpression( "" + f2 + opt + f1);
		        	expBean.setFraction(FractionUtil.calculate(f2, f1, opt));
	        	}else {
	        		expBean.setExpression( "" + f1 + opt + f2);
		        	expBean.setFraction(FractionUtil.calculate(f1, f2, opt));
	        	}
	        	
	        }else {
	        	if(random.nextBoolean()) {
	        		if(f2.getNumerator()==0&&opt=='÷')
		        		opt = '+';
	        		if(!expBean1.getFraction().greater(f2)&&opt=='-') {
	        			expBean.setExpression("" + f2 + opt + "(" + expBean1 + ")");
		        		expBean.setFraction(FractionUtil.calculate(f2, expBean1.getFraction(), opt));
	        		}else {
	        			expBean.setExpression( "(" + expBean1 + ")" + opt + f2);
		        		expBean.setFraction(FractionUtil.calculate(expBean1.getFraction(), f2, opt));
	        		}

	        	}else {
	        		if(expBean1.getFraction().getNumerator()==0&&opt=='÷')
	        			opt = '+';
	        		if(expBean1.getFraction().greater(f2)&&opt=='-') {
	        			expBean.setExpression( "(" + expBean1 + ")" + opt + f2);
		        		expBean.setFraction(FractionUtil.calculate(expBean1.getFraction(), f2, opt));
	        		}else {
	            		expBean.setExpression("" + f2 + opt + "(" + expBean1 + ")");
		        		expBean.setFraction(FractionUtil.calculate(f2, expBean1.getFraction(), opt));
	        		}
	
	        	}
	        }
	        return expBean;
	    }
	 
	 public TwoTuple<String,String> expBuilder(int expAmount) {
		 StringBuilder exptext = new StringBuilder();
		 StringBuilder anstext = new StringBuilder();
		 for(int i=1; i<=expAmount; i++) {
			 Formula expBean = new Formula();

			 int optNum = random.nextInt(3)+1;
			 for(int n = 0; n < optNum; n++){
				 expBean=createExp(expBean);
			 }

			 exptext.append( i + ". " + expBean.getExpression() + "   ="+"\n");
			 anstext.append( i + ". " + expBean.getFraction() + "\n");
		 }
		 return tuple(exptext.toString(), anstext.toString());
	 }
	 

}
