package com.liguanrui.Pair2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class mathExam {
	
    ArrayList<String> list = new ArrayList<>();// ����һ�����ڴ洢ԭʽ���ʽ������
 // ����һ�����ڴ���ת������沨��ʽ��ReversePolishNotation̫���� ���Լ�д��RPO��  ��֪���������Ϲ淶��
    ArrayList<String> RPOlist = new ArrayList<>();
    
    Stack<String> stack1 = new Stack<>();// ���ڴ���ַ���ջ
	Stack<String> stack2 = new Stack<>();// ���������ջ
	public  mathExam(String str) {
		// ����һ����������str��StringTokenizer���󣬲��ṩ��+-����()��Ϊ�ָ�����ָ����Ҫ���طָ���
		 StringTokenizer StringTokenizer = new StringTokenizer(str,"+-����()",true);
		 while(StringTokenizer.hasMoreTokens()) {
			 list.add(StringTokenizer.nextToken());
			 }
		 }
	
	// ����׺���ʽתת��Ϊ�沨�����ʽ
	public void ReversePolishNotation() {
		for (String str : list) {
			if (str.matches("[0-9]+")) {
				RPOlist.add(str);			
			}else if (str.matches("[\\+\\-\\��\\��\\(\\)]")) {
				stack(str);
			}else {
				System.out.println("�Ƿ����ʽ��");
			}
		}
		while(!stack1.isEmpty()) {
			RPOlist.add(stack1.pop());
		}
	}
	
	// ����һ�����ڴ���ַ��ķ���������+-����()���Ž�stack1��
	 public void stack(String zf) {
		 if (stack1.isEmpty()) { // ��Ϊ��ջ�����ַ�����ջ��
			 stack1.push(zf);
			 return ;
		 }if ("(".equals(zf)){ // �ж��ַ��Ƿ�ΪΪ��(��
			 stack1.push(zf);
			 return ;
		 }if (")".equals(zf)) { // �ж��ַ��Ƿ�ΪΪ��)��
			 String string = "";
			 while(!"(".equals(string = stack1.pop())) {
				 RPOlist.add(string);
			 }return ;
		 }if ("(".equals(stack1.peek())) { // ����ǰջ����Ԫ��Ϊ��(��,��ֱ����ջ
			 stack1.push(zf);
			 return ;
		 }if (judge(zf,stack1.peek())) {// �ж����ȼ�,��Ԥ����ַ����ȼ�����ջ��Ԫ�أ������ַ�����ջ��
			 stack1.push(zf);
			 return ;
		 }else{ // �����ȼ�����ջ��Ԫ�أ����ַ�������沨��ʽ�ӵ�������
			 RPOlist.add(stack1.pop());
			 stack(zf);
		 }
	 }
    // ����һ�����������жϵ�ǰ�ַ���ջ��Ԫ�ص����ȼ�������true��false	
	private boolean judge(String str1, String str2) {
		// TODO Auto-generated method stub
		int a ,b;
		switch(str1) {
		case "(" :a = 3; 
		case "��" :
		case "��" :a = 2;	 
		case "+" :
		case "-" :a = 1;
		case ")" :a = 0;
		default:a = -1;
		}
		
		switch(str2) {
		case "(" :b = 3; 
		case "��" :
		case "��" :b = 2;	 
		case "+" :
		case "-" :b = 1;
		case ")" :b = 0;
		default:b = -1;
		}
		return a>b;
	}
	
	
	// ����һ�����������沨��ʽ�ӽ���ķ���
	 public int count(String s1,String s2,String s3) {
		 int a = Integer.parseInt(s2);
		 int b = Integer.parseInt(s1);
		 switch(s3) {
		 case "+":
			 return a+b;
		 case "-":
			 return a-b;
		 case "��":
			 return a*b;
		 case "��":
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
		System.out.println("��Ӧ���沨��ʽΪ��"+cc);
		System.out.println("����ǣ�"+me.count());
		}
}
