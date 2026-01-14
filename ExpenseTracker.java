import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.time.LocalDate;
public class ExpenseTracker
{
public static void main(String args[])
{
int choice;
int idCounter=1;
Scanner sc = new Scanner(System.in);
ArrayList<Expense> expenses = new ArrayList<>();
do
{
System.out.println("1 → Add expense");
System.out.println("2 → View expenses");
System.out.println("3 → Calculate total");
System.out.println("4 → Delete expense");
System.out.println("5 → Search Expense(Based on Category)");
System.out.println("6 → Exit");
System.out.print("Enter your Choice: ");
choice=sc.nextInt();
sc.nextLine();
switch(choice)
{
case 1: double amt;
	String cat,type;
	System.out.println("Enter Amount: ");
	amt=sc.nextDouble();
	sc.nextLine();
	System.out.println("Category: ");
	cat=sc.nextLine();
	System.out.println("Type: ");
	type=sc.nextLine();
	LocalDate today = LocalDate.now();
	Expense exp = new Expense(idCounter,amt,cat,type,today);
	expenses.add(exp);
	idCounter+=1;	
	break;
case 2: if(expenses.isEmpty())
	{
		System.out.println("No Expense Recorded");
	}
	else
	{
		for(Expense e : expenses)
		{
		 System.out.println(
                "ID: " + e.getId() +
                " | Amount: " + e.getAmount() +
                " | Category: " + e.getCategory() +
                " | Type: " + e.getType() + 
		" | Date: " + e.getDate()
            );
		}
	}
	break;
case 3: double total=0;
	if(expenses.isEmpty())
	{
		System.out.println("No Expense Recorded");
	}
	else
	{
		Iterator<Expense> it=expenses.iterator();
		while(it.hasNext())
		{
			Expense e = it.next();
			total=total+e.getAmount(); // for(Expense e : expenses) {total += e.getAmount();}
		}
		System.out.println("Total Amount Spent: "+total);
	}
	break;
case 4: if(expenses.isEmpty())
	{
		System.out.println("There is no record available.");
	} 
	else
	{	
		int delid;
		System.out.println("Enter the Id of the record which u would like to delete: ");
		delid=sc.nextInt();
		Iterator<Expense> it=expenses.iterator();
		boolean flag=false;
		while(it.hasNext())
		{
		Expense e = it.next();
		if(e.getId()==delid)
		{
			it.remove();
			System.out.println("Id Deleted");
			flag=true;
			break;
		}
		}
		if(flag==false)
		{
		System.out.println("Id Not Found");
		}		
	}
	break;
case 5: if(expenses.isEmpty())
	{
		System.out.println("No Expense till date");
	}
	else
	{
		System.out.println("Enter the category to search : ");
		String sea=sc.nextLine();
		Iterator<Expense> it = expenses.iterator();
		boolean flag=false;
		while(it.hasNext())
		{
			Expense e = it.next();
			if(e.getCategory().equalsIgnoreCase(sea)) // ignore case optionally
			{
			flag=true;
			System.out.println(
                "ID: " + e.getId() +
                " | Amount: " + e.getAmount() +
                " | Category: " + e.getCategory() +
                " | Type: " + e.getType() + 
		" | Date: " + e.getDate());
			}
						
		} 
		if(flag==false)
		{
			System.out.println("Not Found");
		}
	}
	break;
case 6: break;
default: System.out.println("Enter valid Choice!");
}
}while(choice!=6);
}
}