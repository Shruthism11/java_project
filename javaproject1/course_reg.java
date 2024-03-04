package javaproject1;
import course_menu.*;


import java.util.*;


 class student {
	 String name;
	 String stu_id;
	 
	 student()
	 {
		 name="Sanjana";
		 stu_id="4NI20IS097";
	}
	 
     student(String name,String stu_id)
     {
    	 this.name=name;
    	 this.stu_id=stu_id;
    	 
     }
     student(String name)     //OVERLOADING
     {
    	 this.name=name;
    	 stu_id="4NI20IS093";
    	 
     }
     student(student obj)
     {
    	 name=obj.name;
    	 stu_id=obj.stu_id;
    	 
     }
     
     void display()
     {
    	 System.out.println("STUDENT NAME : " + this.name);
    	 System.out.println("STUDENT ID : " + this.stu_id);
     }
     
     
 }
 
 //inherited class
 class course extends student{
	 String courseid;
	 String coursename;
	 
	 course(String name,String stu_id,String courseid,String coursename)
	 {
		 super(name,stu_id);
		 this.courseid = courseid;
		 this.coursename = coursename;
	 }
	 
	 course(String courseid,String coursename)
	 {
		 this.courseid = courseid;
		 this.coursename = coursename;
	 }
	 
	 void display()   //6 --> method overriding
	 {
//		 super.display();
		 System.out.println("COURSE NAME : " + this.coursename);
		 System.out.println("COURSE ID : " + this.courseid);
	 }
	
 }
 
 //multilevel inheritance;
 class credits extends course
 {
	 int credits;
	 
	 credits(String name,String stu_id,String courseid,String coursename,int credits)
	 {
		 super(name,stu_id,courseid,coursename);
		 this.credits = credits;
	 }
	 
	 credits(String courseid,String coursename,int credits)
	 {
		 super(courseid,coursename);
		 this.credits = credits;
	 }
	 
	 void display()   //6 --> method overriding
	 {
		 super.display();
		 System.out.println("COURSE CREDITS : " + this.credits);
	 } 
 }
 
 
class min_credit_exception extends Exception
{
	min_credit_exception(String msg)
	{
		super(msg);
	}
}

 
 public class course_reg {
		
    public static void main(String args[])
    {
    	menu m = new menu();
   	   System.out.println("============================================================================================================");
   	   
   	   Scanner sc = new Scanner(System.in);
   	   
       System.out.println("ENTER THE STUDENT NAME : ");
	   String name = sc.next();
   	   
	   System.out.println("ENTER THE STUDENT Id : ");
   	   String id = sc.next();
   	   
   	   System.out.println("HOW MANY COURSES TO REGISTER??");
   	   int n = sc.nextInt();
   	   String co_id[] = new String[10];
   	   String co_name[] = new String[10];
   	   int co_credit[] = new int[10];
   			   
   	   
   	   int i = 1;
   	   while(i<=n)
   	   {
   		   System.out.println("ENTER THE DETAILS OF COURSE " + i);
   		   System.out.println("ENTER THE COURSE NAME : ");
    	   String cname = sc.next();
    	   sc.nextLine();
    	   System.out.println("ENTER THE COURSE ID : ");
       	   String cid = sc.next();
           sc.nextLine();
           System.out.println("NUMBER OF CREDITS OFFERED FOR THIS COURSE IN THE MENU IS : ");
       	   int ccredit = sc.nextInt();
           sc.nextLine();
       	   System.out.println("NUMBER OF CREDITS YOU ARE ELIGIBLE FOR  : ");
    	   int scredit = sc.nextInt();
    	   sc.nextLine();
    	   if(ccredit > scredit)
    	   {
    		   try
    		   {
    		     throw new min_credit_exception("AVAILABLE CREDITS TO YOU IS LOW!!");
    		   }
    		   catch(min_credit_exception e)
    		   {
    			   System.out.println("SORRY, YOU ARE NOT ELIGIBLE TO REGISTER FOR THIS COURSE ."+ e);
    		   }
    	   }
    	   co_id[i] = cid;
    	   co_name[i] = cname;
    	   co_credit[i] = ccredit;
    	   i++;
   	   }
   	   
   	   
      
   	System.out.println("STUDENT DETAILS ALONG WITH REGISTERED SUBJECT : ");
   		student s1 = new student(name,id);
   		s1.display();
   		
   		int j = 1;
   		while(j<=n)
   		{
   			System.out.println("REGISTERED COURSE " + j + " DETAILS");
   			credits k = new credits(co_id[j],co_name[j],co_credit[j]);
   			k.display();
   			j++;
   		}
   	   
   	   
   		class stu{  
   		 synchronized void printcourse(int n){//synchronized method  
   		   for(int i=1;i<=5;i++){  
   		     System.out.println(Thread.currentThread().getName()+"  "+n*i);  
   		     try{  
   		      Thread.sleep(400);  
   		     }catch(Exception e)
   		     {
   		    	 System.out.println(e);}  
   		   }  
   		  
   		 }  
   		}  
   		  
   		class MyThread1 extends Thread{  
   		stu t;  
   		MyThread1(stu t){  
   		this.t=t;  
   		}  
   		public void run(){  
   		t.printcourse(5);  
   		}  
   		  
   		}  
   		class MyThread2 extends Thread{  
   		stu t;  
   		MyThread2(stu t){  
   		this.t=t;  
   		}  
   		public void run(){  
   		t.printcourse(100);  
   		}  
   		}
   		class meException extends Exception{
   		     meException(String s) {
   		        super(s);
   		    }
   		}
    }
	 
 }
