import java.util.*;
public class Pract_3{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int wtime[ ] ,btime[ ] ,rtime[ ] ,num,quantum, total;
		wtime = new int[10];
		btime = new int[10];
		rtime = new int[10];
		System.out.println("Enter number of processes(Max 10):");
		num = sc.nextInt();
		System.out.println("Enter burst time:");
		for(int i=0;i<num;i++){
			System.out.println("\n P["+(i+1)+"];");
			btime[i] = sc.nextInt();
			rtime[i] = btime[i];
			wtime[i] = 0;
		}
		System.out.println("\n\n Enter quantum:");
		quantum = sc.nextInt();
		int rp = num;
		int i = 0;
		int time = 0;
		System.out.println("0");
		wtime[0] = 0;
		while(rp!=0){
			if(rtime[i]>quantum){
				rtime[i] = rtime[i] - quantum;
				System.out.println("IP["+(i+1)+"]I");
				time += quantum;
				System.out.println(time);
			}		
			else if(rtime[i] <= quantum && rtime[i]>0){
				time+=rtime[i];
				rtime[i] = rtime[i]-rtime[i];
				System.out.println("|P["+(i+1)+"]|");
				rp--;
				System.out.println(time);
			}
			i++;
			if(i==num){
				i=0;
			}
		}
	}
}