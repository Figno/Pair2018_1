
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class mathExam {
	ArrayList<String> list = new ArrayList<>();// ����һ�����ڴ洢ԭʽ���ʽ������
	 static // ����һ�����ڴ���ת������沨��ʽ��ReversePolishNotation̫���� ���Լ�д��RPO��  ��֪���������Ϲ淶��
	    ArrayList<String> RPOlist = new ArrayList<>();
	    
	    Stack<String> stack1 = new Stack<>();// ���ڴ���ַ���ջ
		Stack<String> stack2 = new Stack<>();// ���������ջ
		
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
   	 	int num =sc.nextInt();
			char[] operator=new char[]{'+','-','��','��'};
			Random random=new Random();
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 1;i <= num;i ++){
				int n = random.nextInt(2)+2; //2-4�������
				int[] number = new int[n+1]; 
				String bds = new String();
				for(int j = 0;j <= n;j ++){
					number[j] = random.nextInt(100)+1; //4-5������
				}
				for(int j = 0;j < n;j ++){
					int s = random.nextInt(4);//���ѡ��ĳ�������
					bds += String.valueOf(number[j]) + String.valueOf(operator[s]);
					if(s == 3){number[j+1] = ys(number[j],number[j+1]);}
				}
				bds += String.valueOf(number[n]);
				list.add(bds);
				System.out.println("("+i+")"+" "+bds);
			}
			System.out.println();
			for (int i = 0; i < list.size(); i++) {
			String str =String.join("", list.get(i));
			mathExam me = new mathExam(str);
			me.ReversePolishNotation();
			System.out.println("("+(i+1)+")"+" "+list.get(i)+"="+me.count());
			System.out.println(RPOlist);
			}
		}
	private static int ys(int x,int y){
		Random random=new Random();
		if(x%y!=0){
			y=random.nextInt(100)+1;
			return ys(x,y);
		}
		else{
			return y; 
		}
	}
	public   mathExam(String str) {
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
		 }/*if ("(".equals(zf)){ // �ж��ַ��Ƿ�ΪΪ��(��
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
		 }*/if (judge(zf,stack1.peek())) {// �ж����ȼ�,��Ԥ����ַ����ȼ�����ջ��Ԫ�أ������ַ�����ջ��
			 stack1.push(zf);
			 return ;
		 }else{ // �����ȼ�����ջ��Ԫ�أ����ַ�������沨��ʽ�ӵ�������
			 RPOlist.add(stack1.pop());			 
			 stack(zf);
		 }
	 }
    // ����һ�����������жϵ�ǰ�ַ���ջ��Ԫ�ص����ȼ�������true��false	
	private boolean judge(String str1, String str2) {
		return Judge(str1) > Judge(str2);
	}
	
	private int Judge(String str) {
		switch(str) {
		 case "(" :return 3;
		 
		 case "��" :
		 case "��" :return 2;
		 
		 case "+" :
		 case "-" :return 1;
		 
		 case ")" :return 0;
		 
		 default:return -1;
		 }
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
}



	
