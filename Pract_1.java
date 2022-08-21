import java.util.*;
class Pract_1{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n,AT[ ],BT[ ],WT[ ],TAT[ ],ST[ ],FT[ ];
		float AWT = 0, AVGTAT = 0;
		System.out.println("Enter no of Processes:");
		n=sc.nextInt();

		BT = new int[n];
		FT = new int[n];
		ST = new int[n];
		WT = new int[n];
		TAT = new int[n];
		AT = new int[n];
		System.out.println("*******************************************");
		for(int i=0;i<n;i++){
			System.out.println("Enter burst time for process: "+(i+1)+":");
			BT[i] = sc.nextInt();
		}
		System.out.println("******************************************");
		for(int i=0;i<n;i++){
			System.out.println("Enter arrival time for process"+(i+1)+";");
			AT[i] = sc.nextInt();
		}
		WT[0]=0;
		for(int i=1;i<n;i++){
			ST[i]=ST[i-1]+BT[i-1];
			WT[i]=ST[i]-AT[i];
		}
		for(int i=0;i<n;i++){
			FT[i]=ST[i]+BT[i];
			TAT[i] = FT[i]-AT[i];
			AWT = AWT+WT[i];
			AVGTAT = AVGTAT+TAT[i];
		}
		System.out.println("************************************************");
		System.out.println("PR BT ST FT WT TAT ");
		for (int i=0;i<n;i++){
			System.out.println(i+"  "+BT[i]+"  "+ST[i]+"  "+FT[i]+"  "+WT[i]+"  "+TAT[i]);
		}
		AWT = AWT/n;
		AVGTAT = AVGTAT/n;
		System.out.println("***********************\n Avg waiting time: "+AWT+"\n********************");
		System.out.println("Avg.trun around time:"+AVGTAT+"\n*******************************");
	}
}