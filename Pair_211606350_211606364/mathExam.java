
import java.util.List;
import java.util.Random;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class MathExam {
	ArrayList<String> list = new ArrayList<>();// ����һ�����ڴ洢ԭʽ���ʽ������
	 // ����һ�����ڴ���ת������沨��ʽ��ReversePolishNotation̫���� ���Լ�д��RPO��  ��֪���������Ϲ淶��
	    ArrayList<String> RPOlist = new ArrayList<>();
	    
	    Stack<String> stack1 = new Stack<>();// ���ڴ���ַ���ջ
		Stack<String> stack2 = new Stack<>();// ���������ջ
		
 public static void main(String[] args) throws IOException  {
  // TODO Auto-generated method stub
  int a;
  int p = 1;
  while(true) {
	  	Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(" ");//���Կո�Ϊ�ָ��������ִ�������
        if(stringArray.length>1) {	//�ж��������һ�����뻹���������룬�����������������Ĳ����ж����������Ƿ���ϱ�׼
        try {
           a = Integer.parseInt(stringArray[0]);
           p = Integer.parseInt(stringArray[1]);
           } catch (NumberFormatException e) {		//�ж�����������Ƿ������ֲ��������쳣
            System.out.println("�����������������");
            continue;
           }
        if(stringArray.length>2) {System.out.println("���ݹ�������������");continue;}  //�������鳤������������
        if(Integer.parseInt(stringArray[0])<0) {System.out.println("������Ŀ������������������");continue;}//��������ĵ�һ������Ϊ��Ŀ�����ж��Ƿ�����쳣
        if(Integer.parseInt(stringArray[1])!=1 && Integer.parseInt(stringArray[1])!=2 && Integer.parseInt(stringArray[1])!=3) {System.out.println("�����꼶��������������");continue;}//��������ĵڶ�������Ϊ�꼶�ж��Ƿ�����쳣
        a = Integer.parseInt(stringArray[0]);
        p = Integer.parseInt(stringArray[1]);
        break;
        							}
        else {//��������������Ĭ��Ϊһ�꼶ֻ���ж�����������Ƿ��쳣
         try {
                a = Integer.parseInt(stringArray[0]);
                } catch (NumberFormatException e) {
                 System.out.println("�����������������");
                 continue;
                }
         if(Integer.parseInt(stringArray[0])<0) {System.out.println("������Ŀ������������������");continue;}
             a = Integer.parseInt(stringArray[0]);
             p=1;
             break;
       }
  }
        
  MathExam6350(a,p);
 
 }
 static void MathExam6350(int a,int e) throws IOException {
  List<String>  list  = new ArrayList<String>();
  PrintStream out = System.out;
  PrintStream ps = new PrintStream("e:/output.txt");
  if(e==1) {
  for(int i=1;i<=a;i++) {
   int b =(int)(Math.random()*100);
   int c =(int)(Math.random()*100);
   int d;
   int rd=Math.random()>0.5?1:0; 
   if(rd==1) {
    System.setOut(ps);
    System.out.println("("+i+")"+" "+b+" "+"+"+" "+c+" "+"=");
   d=b+c;list.add("("+i+")"+" "+b+" "+"+"+" "+c+" "+"="+" "+d);}
   if(rd==0) {
    while(b-c<0) {b=(int)(Math.random()*100);}
    System.setOut(ps);
    System.out.println("("+i+")"+" "+b+" "+"-"+" "+c+" "+"=");
    d=b-c;list.add("("+i+")"+" "+b+" "+"-"+" "+c+" "+"="+" "+d);}  
  }
  System.setOut(ps);
  System.out.println("-----------��׼��-----------");
  for (int i = 0; i < list.size(); i++) {
   System.setOut(ps);
   System.out.println( list.get(i));
 }  
}
  if(e==2) {
   for(int i=1;i<=a;i++) {
    int b =(int)(Math.random()*10);
    int c =(int)(Math.random()*10);
    int d;
    int f;
    int rd=Math.random()>0.5?1:0; 
    if(rd==1) {
     System.setOut(ps);
     System.out.println("("+i+")"+" "+b+" "+"��"+" "+c+" "+"=");
    d=b*c;list.add("("+i+")"+" "+b+" "+"��"+" "+c+" "+"="+" "+d);}
    if(rd==0) {
     while(c==0) {c=(int)(Math.random()*10);}
     System.setOut(ps);
     System.out.println("("+i+")"+" "+b+" "+"��"+" "+c+" "+"=");
     if(b%c==0) {d=b/c;list.add("("+i+")"+" "+b+" "+"��"+" "+c+" "+"="+" "+d);}
     if(b%c!=0) {d=b/c;f=b%c;list.add("("+i+")"+" "+b+" "+"��"+" "+c+" "+"="+" "+d+"."+"."+"."+f);}}
   }
   System.setOut(ps);
   System.out.println("-----------��׼��-----------");
   for (int i = 0; i < list.size(); i++) {
    System.setOut(ps);
    System.out.println( list.get(i));
  }
 }
  if(e==3) {
		char[] operator=new char[]{'+','-','��','��'};
		Random random=new Random();
		ArrayList<String> list1=new ArrayList<String>();
		for(int i=1;i<=a;i++){
			int n=random.nextInt(2)+2; //2-4�������
			int[] number=new int[n+1]; 
			String bds=new String();
			for(int j=0;j<=n;j++){
				number[j]=random.nextInt(100)+1; //4-5������
			}
			for(int j=0;j<n;j++){
				int s=random.nextInt(4);//���ѡ��ĳ�������
				bds+=String.valueOf(number[j])+String.valueOf(operator[s]);
				if(s==3){number[j+1]=ys(number[j],number[j+1]);}
			}
			bds+=String.valueOf(number[n]);
			list1.add(bds);
			System.setOut(ps);
			System.out.println("("+i+")"+" "+bds);
		}	
		System.setOut(ps);
		System.out.println("-----------��׼��-----------");
		for (int i = 0; i < list1.size(); i++) {
		String str =String.join("", list1.get(i));
		Main me = new Main(str);
		me.ReversePolishNotation();
		System.setOut(ps);
		System.out.println("("+(i+1)+")"+" "+list1.get(i)+"="+me.count());
		}
	  
  }
   SimpleDateFormat formater=new SimpleDateFormat("            211606364  ����� yyyy��MM��dd�� HH:mm");
   String strCurrentTime=formater.format(new Date());
   System.setOut(ps);
   System.out.println(strCurrentTime);
   File file = new File("e:/output.txt");
   FileReader reader = new FileReader(file);
   int fileLen = (int)file.length();
   char[] chars = new char[fileLen];
   reader.read(chars);
   String txt = String.valueOf(chars);
   System.setOut(out);
   System.out.println(txt);
System.out.println("e:/output.txt������");
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
	public    void Main(String str) {
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
