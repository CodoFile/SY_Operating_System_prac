class Prime implements Runnable{
	long j,c;
	Prime(){
		super();
		c=0;
	}
	public void run(){
		for(long i=0;i<=100;i++){
			for(j=2;j<=i;j++){
				if(i%j==0)
					break;
			}
			if(j==i){
				c++;
				System.out.println(c+"th"+" Prime no: ="+i);
			}
		}
	}	
}
public class Pract_4{
public static void main(String args[]){
	Thread ct = Thread.currentThread();
	System.out.println("main thread name: "+ct.getName());
	Prime p = new Prime();
	Thread Prime = new Thread(p,"Prime");
	Prime.start();
	System.out.println("Thread "+ Prime.getName()+ "Started. ");
}
}