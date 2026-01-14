import java.time.LocalDate;
public class Expense 
{
private int id;
private double amount;
private String category;
private String type;
private LocalDate date;
public Expense(int id,double amount,String category,String type,LocalDate date)
{
//we have written the constructor because an expense will not be able to exsist without these fields.
this.id=id;
this.amount=amount;
this.category=category;
this.type=type;
this.date=date;
}
public LocalDate getDate()
{
	return date;
}
public int getId()
{
	return id;
}
public double getAmount()
{
	return amount;
}
public String getCategory()
{
	return category;
}
public String getType()
{
	return type;
}
}