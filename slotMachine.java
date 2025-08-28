import java.util.Scanner;
import java.util.Random;
public class slotMachine {
    public static void main(String[] args){
        System.out.print("*******WELCOME********\n");
        double balance=100;
        String choice="Yes";
        double bet=0;
        double payout=0;
        Random r=new Random();
        Scanner s=new Scanner(System.in);
        String []symbols={"7","🔔","♥","♦","💰","🍡","🍇","🍋"};
      while(choice.equalsIgnoreCase("Yes")||choice.equalsIgnoreCase("Y")){
          payout=0;
        int r1=r.nextInt(0,8);
        int r2=r.nextInt(0,8);
        int r3=r.nextInt(0,8);
        System.out.print("Place your bet: ");
        bet=s.nextDouble();
        while(bet>balance){
            System.out.println("You cannot bet more than what you have.\nEnter your bet again: ");
            bet=s.nextDouble();
        }
        while(bet<=0){
            System.out.print("At least bet $1 you broke.\nEnter correctly now: ");
            bet=s.nextDouble();
        }
          balance=balance-bet;
        System.out.printf("%s|%s|%s\n",symbols[r1],symbols[r2],symbols[r3]);
        if(r1==r2&&r2==r3){
          switch(r1){
              case 0-> payout=20*bet;
              case 1-> payout=10*bet;
              case 2-> payout=8*bet;
              case 3-> payout=6*bet;
              case 4-> payout=5*bet;
              case 5-> payout=4*bet;
              case 6-> payout=3*bet;
              case 7-> payout=2*bet;
          }
            System.out.printf("You won $%.2f.\n",payout);
        }
        else if(r1==r2||r2==r3||r1==r3){
            payout=bet*2;
            System.out.printf("You won $%.2f.\n",payout);
        }
        else{

            System.out.print("You lost.\n");
        }
        balance+=payout;
          System.out.printf("Current balance =$%.2f\n",balance);
        if(balance<=0){
            System.out.println("You have no money to bet.");
            return;
        }
        System.out.print("Do you want to play more(Yes/NO): ");
        s.nextLine();
        choice=s.nextLine();
        while( !(choice.equalsIgnoreCase("Yes"))&&!(choice.equalsIgnoreCase("No"))
               &&!(choice.equalsIgnoreCase("Y"))&&!(choice.equalsIgnoreCase("N"))){
            System.out.print("Please answer correctly.\nEnter again: ");
            choice=s.nextLine();
        }
    }
        System.out.println("Thank you for playing!");
}}
