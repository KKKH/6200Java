//Name: Jiawei Zhang
//NUID: 001531280

package week2_CurrencyDispenser;

import java.util.Scanner;
public class dispenser {
	public static void main(String ards[])
	{
		System.out.println("Welcome. This is currency dispenser.");
		int balance=0;
		int history[][]=new int[3][5]; //transactions history
		boolean full=true; //true means fewer than 3 items in transactions history, full means 3 items in transactions history 
		while(true) {
			//menu
			function_display();
			//function selection
			Scanner input_function=new Scanner(System.in);
			int menu_function= input_function.nextInt(); 
			
			//deposit
			if(menu_function==1) {
				System.out.println("Please input the value of currency to diposit.");
				Scanner input_deposit=new Scanner(System.in);
				int now_deposit=input_deposit.nextInt();
				//add items to transactions history
				if(full==false) { //3 items in transactions history
					for(int i=0;i<2;i++) {
						for(int j=0;j<5;j++) {
							history[i][j]=history[i+1][j];
						}
					}
					history[2][0]=1;
					history[2][1]=now_deposit;
				}
				for(int i=0;i<3;i++) { //fewer than 3 items in transactions history
					if (history[i][0]==0) {
						history[i][0]=1;
						history[i][1]=now_deposit;
						if(i==2) {
							full=false;
						}
						break;
					}
				}
				balance=balance+now_deposit;
				System.out.println("You have deposited $" + now_deposit + ", your balance is $" + balance + ".");
			}
			
			//withdraw
			if(menu_function==2) {
				System.out.println("Your account balance is $" + balance +" .");
				System.out.println("Please input the value of currency you want to withdraw.");
				Scanner input_withdraw=new Scanner(System.in);
				int now_withdraw=input_withdraw.nextInt();
				System.out.println("You decided to withdraw $" + now_withdraw + ".");
				//negative integer
				if(now_withdraw<0) {
					System.out.println("System error¡£");
					System.out.println("Please input a positive integer¡£");
				}
				//no enough balance
				else if(now_withdraw>balance) {
					System.out.println("Withdraw failed. Not enough balance in your account.");
				}
				//withdraw and dispense
				else {
					balance=balance-now_withdraw;
					int note_ten=0, note_five=0, note_one=0;
					System.out.println("Withdrawing $" + now_withdraw + " from your account.");
					note_ten=(now_withdraw-(now_withdraw%10))/10;
					now_withdraw=now_withdraw%10;
					System.out.println("$10 bill£º  "+note_ten);
					note_five=(now_withdraw-(now_withdraw%5))/5;
					System.out.println("$5  bill£º  "+note_five);
					now_withdraw=now_withdraw%5;
					note_one=now_withdraw;
					System.out.println("$1  bill£º  "+note_one);
					System.out.println("Your account balance is $" + balance +" .");
					//add to items to transactions history
					if(full==false) { //3 items in transactions history
						for(int i=0;i<2;i++) {
							for(int j=0;j<5;j++) {
								history[i][j]=history[i+1][j];
							}
						}
						history[2][0]=2;
						history[2][1]=10*note_ten+5*note_five+note_one;
						history[2][2]=note_ten;
						history[2][3]=note_five;
						history[2][4]=note_one;
					}
					for(int i=0;i<3;i++) { //fewer than 3 items in transactions history
						if (history[i][0]==0) {
							history[i][0]=2;
							history[i][1]=10*note_ten+5*note_five+note_one;
							history[i][2]=note_ten;
							history[i][3]=note_five;
							history[i][4]=note_one;
							if(i==2) {
								full=false;
							}
							break;
						}
					}
				}
			}
			
			//history
			else if(menu_function==3) {
				System.out.println("Last 3 transactions for your account");
				for(int i=0;i<3;i++) {
					if(history[i][0]==0) {
						if(i==0) {
							System.out.println("////////////////////////");
							System.out.println("No transactions recorded");
							System.out.println("////////////////////////");
						}
						break;
					}
					else if(history[i][0]==1) {
						System.out.println("Deposit:   $" + history[i][1]);
					}
					else if(history[i][0]==2) {
						System.out.println("Withdraw:  $"+history[i][1] + "------------$10 note:"+history[i][2] +"   $5 note:"+ history[i][3] + "   $1 note:" + history[i][4]);
					}
				}

			}
			
			//quit
			else if(menu_function==4) {
				System.out.println("You have already exited the system.");
				System.exit(0);
			}
		}
	}
	
	public static void function_display() {
		System.out.println("Function Selection");
		System.out.println("1. Diposit");
		System.out.println("2. Witdraw");
		System.out.println("3. Balance History");
		System.out.println("4. Exit");
		return;
	}
}
