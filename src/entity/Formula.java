package entity;
/*
 *题目表达式实体类
 */
public class Formula {

	private String expression = "";
	
	private Fraction fraction;
	
	
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public Fraction getFraction() {
		return fraction;
	}
	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}
	
	public String toString() {
		return this.expression;
	}
	
}
