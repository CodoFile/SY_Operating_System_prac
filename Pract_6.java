/*write a program to print even and odd number and find reverse of number using concept multithreading */
import java.util.*;
class test1 extends Thread{
	String name;
	test1(String threadname){name=threadname;}
	public void run(){evenodd();}
	public void evenodd(){
		System.out.println(name);
		try{
			for(int i=0;i<=10;i++){
				if(i%2==0){
					System.out.println(i+" is even");
				}
				else{
					System.out.println(i +" is odd");
 				}
				this.sleep(1000);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
class test2 extends Thread{
	String name;
	test2(String threadname){name=threadname;}
	public void run(){ reverse();}
	public void reverse(){
		System.out.println(name);
		System.out.println("Enter friend name: ");
		Scanner sc = new Scanner(System.in);
		String friendname = sc.next();
		StringBuffer sb = new StringBuffer(friendname);
		System.out.println("friend name reverse is "+sb.reverse());
	}
}
public class Pract_6{
	public static void main(String args[]){
		try{
			test1 t1 = new test1("Thread  One: Even odd");
			t1.start();
			t1.join();
			test2 t2 = new test2("Thread Two: friend name reverse");
			t2.start();
			t2.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}