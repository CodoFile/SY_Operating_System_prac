class Fib implements Runnable
{
long a,b,c,n;
Fib()
{
a=c=n=0;
b=1;
}
public void run()
{
while(n++<20)
{
System.out.println(n+ "th" + "Fib.no: " + a);
c=a+b;
a=b;
b=c;
try
{
if(n==10)
{System.out.println("Thread Fibonacci is put into sleep.");
Thread.sleep(500);
}
}
catch(InterruptedException e)
{
System.out.println("Error : " + e);
}
}
}
}

public class Pract_4_B
{
public static void main(String args[])
{
Thread ct= Thread.currentThread();
System.out.println("Main thread name : "+ ct.getName());
Fib f=new Fib();
Thread fib=new Thread(f,"fibonacci");

fib.start();
System.out.println("Thread "+ fib.getName()+ "started.");
}
}