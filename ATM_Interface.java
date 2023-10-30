import java.util.Scanner;
class BankAccount 
{
    private double bal;
    public BankAccount(double inibal)
	{
        bal = inibal;
    }
    public double getBalance() 
	{
        return bal;
    }
    public void deposit(double amt)
	{
        if (amt > 0) 
		  {
            bal += amt;
            System.out.println("Deposited: $" + amt);
          }
		else 
		{
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amt)
	{
        if (amt > 0 && amt <= bal)
			{
            bal -= amt;
            System.out.println("Withdrawn: $" + amt);
            return true;
           } 
		else if (amt > bal) 
		{
            System.out.println("Insufficient balance");
        } 
		else 
		{
            System.out.println("Invalid withdrawal amount");
        }
        return false;
    }
}

class ATM_Interface 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial account balance: $");
        double initialBalance = sc.nextDouble();

        BankAccount act = new BankAccount(initialBalance);
        boolean quit = false;

        while (!quit) 
		{
            System.out.println("\nATM Options:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");
            System.out.print("Choose an option (1/2/3/4): ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Account Balance: $" + act.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double da = sc.nextDouble();
                    act.deposit(da);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double wa = sc.nextDouble();
                    if (act.withdraw(wa)) 
					{
                        System.out.println("Remaining Balance: $" + act.getBalance());
                    }
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option");
            }
        }
    }
}
