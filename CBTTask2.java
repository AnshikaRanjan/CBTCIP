package CBTTasks;

import java.util.Scanner;
import java.util.ArrayList;

class ATM{
    int BalanceA;
    int Balance;
     int[] PIN={1234,4572,4673,9865,2213};

    ArrayList<String> history=new ArrayList<String>();

    public void checkPin(){
        boolean found=false;
        System.out.println("Enter your PIN: ");
        Scanner sc= new Scanner(System.in);
        int EnterPIN= sc.nextInt();
        for (int element: PIN){
            if (element==EnterPIN){
                found=true;
                menu();
                break;
            }
        }
        if(!found){
            System.out.println("Enter a valid PIN: ");
            checkPin();
        }
    }


    public void menu(){
        System.out.println("Enter your choice: ");
        System.out.println("1. Check A/c Balance ");
        System.out.println("2. Check Transaction History ");
        System.out.println("3. Withdraw Money ");
        System.out.println("4. Deposit Money ");
        System.out.println("5. Transfer money to another A/c ");
        System.out.println("6. EXIT ");

        Scanner sc=  new Scanner(System.in);
        int choice= sc.nextInt();

        if(choice==1){
            checkBalance();
        }
        else if (choice==2){
            TransactionHistory();
        }
        else if (choice==3){
            withdrawMoney();
        }
        else if(choice==4){
            depositMoney();
        }
        else if(choice==5){
            TransferMoney();
        }
        else if(choice==6){
            System.out.println("Thank You!! Visit Again!!");
            return;
        }
        else {
            System.out.println("Enter a valid choice");
            menu();
        }
    }

    public void checkBalance(){
        System.out.println(" Available Balance: "+ Balance);
        menu();
    }

    public void withdrawMoney(){
        System.out.println("Enter the amount to be Withdrawn: ");
        Scanner sc= new Scanner(System.in);
        int amount= sc.nextInt();
        if(amount>Balance){
            System.out.println("Insufficient Balance.");
        }
        else {
            Balance=Balance-amount;
            history.add(Integer.toString(amount));
            history.add("Withdraw");
            System.out.println("Money Withdrawal successful.");
            System.out.println("Available Balance: " + Balance);
        }
        menu();
    }
    public void depositMoney(){
        System.out.println("Enter the amount to be Deposited: ");
        Scanner sc= new Scanner(System.in);
        int amountT= sc.nextInt();
        Balance= Balance+amountT;
        history.add(Integer.toString(amountT));
        history.add("Deposit");
        System.out.println("Money Deposited successfully.");
        System.out.println("Available Balance: " + Balance);
        menu();
    }

    public void TransferMoney(){
        System.out.println("\nEnter the Receiver's A/c number: ");
        Scanner sc= new Scanner(System.in);
        String acn= sc.nextLine();
            if(acn.length() != 10) {
                System.out.println("The A/c number you entered is invalid!!");
                return;
            }
        System.out.println("Enter the amount to be Transferred: ");
        int amountTT= sc.nextInt();
        if(amountTT<Balance) {
            Balance = Balance - amountTT;
            BalanceA = BalanceA + amountTT;
            history.add(Integer.toString(amountTT));
            history.add("Transferred");
            System.out.println("Available Balance: " + Balance);
        }
        else {
            System.out.println("Insufficient Balance.");
        }
        menu();
    }
    public void TransactionHistory(){
        System.out.println("Transaction History :");
        int k=0;
        if(Balance>0){
            for(int i=0;i<(history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.println(history.get(k)+" ");
                    k++;
                }
            }
        }
        else {
            System.out.println("Your account is empty");
        }
        menu();
    }
}


public class CBTTask2 {
    public static void main(String[] args) {
            ATM atm= new ATM();
            atm.checkPin();
    }
}
