import java.util.concurrent.Semaphore;
class Queue
{
//an item
int item;
//semCon initialized with 0 permits
//to ensure  put() executes first
static Semaphore semCon=new Semaphore(0);
static Semaphore semProd=new Semaphore(1);
//to get an item from buffer
void get()
{
try
{
//before consumer can consume an item,
//it must aquire a permit from semCon
semCon.acquire();
}
catch(InterruptedException e)
{
System.out.println("Interrrupted Exception Caught");
}
//consumer consuming an item
System.out.println("Consumer consumed item: " +item);
//after consumer consumes an item,
//it releases semProd to notify producer
semProd.release();
}
//to put an item in buffer
void put(int item)
{
try
{
//before producer can produce an item ,
//it must acquire a permit from semProd
semProd.acquire();
}
catch(InterruptedException e)
{
System.out.println("Interruped exception caught");
}
//producer producing an item
this.item=item;
System.out.println("Producer produced item: "+item);
//after producer produces the item,
//it releases semCon to notify consumer
semCon.release();
}
}

//producer class

class Producer implements Runnable
{
Queue q;
Producer(Queue q)
{
this.q=q;
new Thread(this,"Producer").start();
}
public void run()
{
for(int i=0;i<5;i++)
//producer put items
q.put(i);
}
}

//consumer class

class Consumer implements Runnable
{
Queue q;
Consumer (Queue q)
{
this.q=q;
new Thread(this,"Consumer ").start();
}
public void run()
{
for(int i=0;i<5;i++)
//producer put items
q.get();
}
}
//Driver class

class Pract_5
{
public static void main(String args[])
{
//creating buffer queue
Queue q=new Queue();
//Starting consumer thread 
new Consumer(q);
//Starting producer thread
new Producer (q);
}
}