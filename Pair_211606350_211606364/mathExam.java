

 import java.util.ArrayList;
 import java.util.Scanner;
 import java.util.Stack;
 import java.util.StringTokenizer;
 
 public class mathExam {

	 private Stack<String> czf_stack = new Stack<>();
	 private  ArrayList<String> ysbds_list = new ArrayList<>();
	 private  ArrayList<String> nblbds_list = new ArrayList<>();
	 private static final int One = 1;
	 private static final int Two = 2;
	 private static final int Three = 3;
	 
	 private static Stack<String> ys_stack=new Stack<>();
	 
	 public static void main(String[] args) {      
	 Scanner sc = new Scanner(System.in);
	 String input = sc.nextLine();
	 Pair2018 nbl = new Pair2018(input);
	 String nbls_cc = new String();
	 nbl.zz_hz();
	 System.out.println("对应的逆波兰式为："+ nbls_cc);
	 System.out.println("结果是：" + nbl.js_nbl());
		 } 
	 
	 
	 
	 
	 public  Pair2018(String bdString) {
		 StringTokenizer StringTokenizer = new StringTokenizer(bdString,"+-×÷()",true);
		 while(StringTokenizer.hasMoreTokens()) {
			 ysbds_list.add(StringTokenizer.nextToken());
			 } 
	 }
	 
	 
	 public boolean isNum(String str) {
		 if (str.matches("[0-9]+")) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 public boolean isCzf(String str) {
		 if (str.matches("[\\+\\-\\×\\÷\\(\\)]")) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 
	 public int getYxj(String str) {
		 switch(str) {
		 case "(" :return Three;
		 
		 case "×" :
		 case "÷" :return Two;
		 
		 case "+" :
		 case "-" :return One;
		 
		 case ")" :return 0;
		 
		 default:return -1;
		 }
	 }
	 
	 
	 public boolean isYxj(String str1,String str2) {
		return getYxj(str1) > getYxj(str2); 
	 }
	 
	 public void stack_czf(String czf) {
		 if (czf_stack.isEmpty()) {
			 czf_stack.push(czf);
			 return ;
		 }
		 if ("(".equals(czf)){
			 czf_stack.push(czf);
			 return ;
		 }
		 if (")".equals(czf)) {
			 String string = "";
			 while(!"(".equals(string = czf_stack.pop())) {
				 nblbds_list.add(string);
			 }
			 return ;
		 }
		 if ("(".equals(czf_stack.peek())) {
			 czf_stack.push(czf);
			 return ;
		 }
		 if (isYxj(czf,czf_stack.peek())) {
			 czf_stack.push(czf);
			 return ;
		 }
		 if (!isYxj(czf,czf_stack.peek())) {
			 nblbds_list.add(czf_stack.pop());
			 stack_czf(czf);
		 }
	 }
	 
	 public void zz_hz() {
		 for (String str:ysbds_list) {
			 if (isNum(str)) {
				 nblbds_list.add(str);
			 }else if (isCzf(str)) {
				 stack_czf(str);
			 }else {
				 System.out.println("非法！");
			 }
		 }
		 
		 while(!czf_stack.isEmpty()) {
			 nblbds_list.add(czf_stack.pop());
		 }
	 
	 }
	 
	 
	 
	 public int jsff(String s1,String s2,String s3) {
		 int a = Integer.parseInt(s2);
		 int b = Integer.parseInt(s1);
		 switch(s3) {
		 case "+":return a+b;
		 case "-":return a-b;
		 case "×":return a*b;
		 case "÷":return a/b;
		 default :return 0;
		 }
	 }
	 
	 
	 public int js_nbl() {
		 for (String str:nblbds_list) {
			 if (isNum(str)) {
				 ys_stack.push(str);
			 }else {
				 ys_stack.push(String.valueOf(jsff(ys_stack.pop(),ys_stack.pop(),str)));
			 }
		 }
		 return Integer.parseInt(ys_stack.pop());
	 }
	 
 
 }