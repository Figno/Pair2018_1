package com.liguanrui.Pair2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class mathExam {
	
    ArrayList<String> list = new ArrayList<>();// 创建一个用于存储原式表达式的数组
 // 创建一个用于储存转换后的逆波兰式（ReversePolishNotation太长了 可以简写成RPO吗  不知道符不符合规范）
    ArrayList<String> RPOlist = new ArrayList<>();
    
    Stack<String> stack1 = new Stack<>();// 用于存放字符的栈
	Stack<String> stack2 = new Stack<>();// 用于运算的栈
	public  mathExam(String str) {
		// 构造一个用来解析str的StringTokenizer对象，并提供“+-×÷()”为分隔符，指定需要返回分隔符
		 StringTokenizer StringTokenizer = new StringTokenizer(str,"+-×÷()",true);
		 while(StringTokenizer.hasMoreTokens()) {
			 list.add(StringTokenizer.nextToken());
			 }
		 }
	
	// 将中缀表达式转转化为逆波兰表达式
	public void ReversePolishNotation() {
		for (String str : list) {
			if (str.matches("[0-9]+")) {
				RPOlist.add(str);			
			}else if (str.matches("[\\+\\-\\×\\÷\\(\\)]")) {
				stack(str);
			}else {
				System.out.println("非法表达式！");
			}
		}
		while(!stack1.isEmpty()) {
			RPOlist.add(stack1.pop());
		}
	}
	
	// 创建一个用于存放字符的方法，将“+-×÷()”放进stack1中
	 public void stack(String zf) {
		 if (stack1.isEmpty()) { // 若为空栈，将字符存入栈中
			 stack1.push(zf);
			 return ;
		 }if ("(".equals(zf)){ // 判断字符是否为为“(”
			 stack1.push(zf);
			 return ;
		 }if (")".equals(zf)) { // 判断字符是否为为“)”
			 String string = "";
			 while(!"(".equals(string = stack1.pop())) {
				 RPOlist.add(string);
			 }return ;
		 }if ("(".equals(stack1.peek())) { // 若当前栈顶的元素为“(”,则直接入栈
			 stack1.push(zf);
			 return ;
		 }if (judge(zf,stack1.peek())) {// 判断优先级,若预存的字符优先级大于栈顶元素，将此字符存入栈中
			 stack1.push(zf);
			 return ;
		 }else{ // 若优先级低于栈顶元素，则将字符存入存逆波兰式子的数组中
			 RPOlist.add(stack1.pop());
			 stack(zf);
		 }
	 }
    // 创建一个方法用来判断当前字符与栈顶元素的优先级，返回true或false	
	private boolean judge(String str1, String str2) {
		// TODO Auto-generated method stub
		int a ,b;
		switch(str1) {
		case "(" :a = 3; 
		case "×" :
		case "÷" :a = 2;	 
		case "+" :
		case "-" :a = 1;
		case ")" :a = 0;
		default:a = -1;
		}
		
		switch(str2) {
		case "(" :b = 3; 
		case "×" :
		case "÷" :b = 2;	 
		case "+" :
		case "-" :b = 1;
		case ")" :b = 0;
		default:b = -1;
		}
		return a>b;
	}
	
	
	// 创建一个用来计算逆波兰式子结果的方法
	 public int count(String s1,String s2,String s3) {
		 int a = Integer.parseInt(s2);
		 int b = Integer.parseInt(s1);
		 switch(s3) {
		 case "+":
			 return a+b;
		 case "-":
			 return a-b;
		 case "×":
			 return a*b;
		 case "÷":
			 return a/b;
		 default :
			 return 0;
		 }
	 }
	 
	 public int count() {
		 for (String str:RPOlist) {
			 if (str.matches("[0-9]+")) {
				 stack2.push(str);
			 }else {
				 stack2.push(String.valueOf(count(stack2.pop(),stack2.pop(),str)));
			 }
		 }
		 return Integer.parseInt(stack2.pop());
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		mathExam me = new mathExam(str);
		String cc = new String();
		me.ReversePolishNotation();
		System.out.println("对应的逆波兰式为："+cc);
		System.out.println("结果是："+me.count());
		}
}
