package sadp;
import java.util.*;
import java.io.*;

interface Bank
{
	String getBankName();
	
}
class ICICI implements Bank
{
	public final String bn;
	public ICICI()
	{
		bn="ICICI bank";
	}
	public String getBankName()
	{
		return bn;
		
	}
}

class BOI implements Bank
{
	public final String bn;
	public BOI()
	{
		bn="bank of india";
	}
	public String getBankName()
	{
		return bn;
		
	}
}

class Axis implements Bank
{
	public final String bn;
	public Axis()
	{
		bn="axix bank";
	}
	public String getBankName()
	{
		return bn;
		
	}
}

abstract class Loan
{
	protected double rate;
	abstract void getIntrestRate(double rate);
	public void CalculateLoanPayment(double la,int y)
	{
		double EMI;
		int num;
		num=y+12;
		rate=rate/1200;
		EMI=((rate+Math.pow((1+rate),num))/((Math.pow((1+rate),num))-1))*la;
		System.out.println("ur monthlu emi is" +EMI +"for amount "+la+" u have borrowed");
	}
}
class HouseLoan extends Loan
{
	public void getIntrestRate(double r)
	{
		rate=r;
	}
}
class BLoan extends Loan
{
	public void getIntrestRate(double r)
	{
		rate=r;
	}
}
class CarLoan extends Loan
{
	public void getIntrestRate(double r)
	{
		rate=r;
	}
}
class ELoan extends Loan
{
	public void getIntrestRate(double r)
	{
		rate=r;
	}
}
abstract class AbstractFactory
{
	public abstract Bank getBank(String bank);
	public abstract Loan getLoan(String loan);
}
class BankFactory extends AbstractFactory
{
	public Bank getBank(String bank)
	
	{
	if(bank==null)
	{
		return null;
	}
	else if(bank.equalsIgnoreCase("BOI"))
	{
		return new BOI();
	}
	else if(bank.equalsIgnoreCase("ICICI"))
	{
		return new ICICI();
	}
	
	else
	{
		return null;
	}
	}
	public Loan getLoan(String loan) {
		return null;
	}
}
class LoanFactory extends AbstractFactory
{
	public Bank getBank(String bank) {
		return null;
	}
public Loan getLoan(String loan)
	
	{
	if(loan==null)
	{
		return null;
	}
	else if(loan.equalsIgnoreCase("House Loan"))
	{
		return new HouseLoan();
	}
	else if(loan.equalsIgnoreCase("Education Loan"))
	{
		return new ELoan();
	}
	else
	{
		return null;
	}
}
class FactoryCreator
{
	public static AbstractFactory getFactory(String ch)
	{
		if(ch.equalsIgnoreCase("Bank"))
		{
			return new BankFactory();
		}
		else if(ch.equalsIgnoreCase("Loan"))
		{
			return new LoanFactory();
		}
		else
		{
			return null;
		}
	}
		
	}
}
public class AbstractFactoryDP {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1:bank\n2:Loan");
		int n=sc.nextInt();
		switch(n)
		{
		case 1:	AbstractFactory BankFactory=sadp.LoanFactory.FactoryCreator.getFactory("bank");
				System.out.println("Enter bank name:");
				String bname=br.readLine();		
				Bank b=BankFactory.getBank(bname);
				System.out.println("\nur accout for "+b.getBankName()+" is created");
				break;
		case 2:	AbstractFactory LoanFactory=sadp.LoanFactory.FactoryCreator.getFactory("loan");
				System.out.println("Enter type of loan:");
				String lname=br.readLine();
				
				System.out.println("Enter loan amount:");
				double lamount =Double.parseDouble(br.readLine());
				
				System.out.println("Enter intrest rate:");
				double rate=Double.parseDouble(br.readLine());
				
				System.out.println("\nEnter years ");
				int years=Integer.parseInt(br.readLine());
				
				Loan l=LoanFactory.getLoan(lname);
				l.getIntrestRate(rate);
				l.CalculateLoanPayment(lamount,years);
				break;
				
		default:	System.out.println("wrong ch");
				
		}
	}

}
