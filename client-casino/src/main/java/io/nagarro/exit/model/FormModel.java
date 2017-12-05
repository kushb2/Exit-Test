package io.nagarro.exit.model;

public class FormModel {
	
	private int first12;
	private int second12;
	private int third12;
	private int first18;
	private int zero;
	private int even;
	private int odd;
	private int last18;
	public FormModel(int first12, int second12, int third12, int first18, int zero, int even, int odd, int last18) {
		super();
		this.first12 = first12;
		this.second12 = second12;
		this.third12 = third12;
		this.first18 = first18;
		this.zero = zero;
		this.even = even;
		this.odd = odd;
		this.last18 = last18;
	}
	public FormModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFirst12() {
		return first12;
	}
	public void setFirst12(int first12) {
		this.first12 = first12;
	}
	public int getSecond12() {
		return second12;
	}
	public void setSecond12(int second12) {
		this.second12 = second12;
	}
	public int getThird12() {
		return third12;
	}
	public void setThird12(int third12) {
		this.third12 = third12;
	}
	public int getFirst18() {
		return first18;
	}
	public void setFirst18(int first18) {
		this.first18 = first18;
	}
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getEven() {
		return even;
	}
	public void setEven(int even) {
		this.even = even;
	}
	public int getOdd() {
		return odd;
	}
	public void setOdd(int odd) {
		this.odd = odd;
	}
	public int getLast18() {
		return last18;
	}
	public void setLast18(int last18) {
		this.last18 = last18;
	}
	
	
	public void  setIntial(){
		first12 = second12 = third12 = first18 = zero = even = odd = last18 = 0;
	}
	
	
	public int calculateTotalBet(){
		return first12 + second12 + third12 + first18 + zero + even + odd + last18 ;

	}
	
	
	
	
	
	
}
