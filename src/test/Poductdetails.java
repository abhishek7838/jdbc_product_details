package test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.*;
public class Poductdetails {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","tiger");
				PreparedStatement ps1=con.prepareStatement("insert into productdetails44 values(?,?,?,?)");
				PreparedStatement ps2 =con.prepareStatement("Select * from productdetails44");
				PreparedStatement ps3=con.prepareStatement("select * from productdetails44");
				PreparedStatement ps4=con.prepareStatement("update productdetails set productprice=? ,peoductqunty=peoductqunty+? where code=?");
				PreparedStatement ps5=con.prepareStatement("delete from productdetails44 where poductcode=?");
				
				while(true)
				{
					System.out.println("****CHOICES*****");
					System.out.println("\t1.ADDPRODUCT"+"\n\t2.VIEWALLPRODUCTS"+"\n\t3.VIEWPRODUCTBYCODE"+"\n\t4.UpdateProductByCode(price and Qnty)"+"\n\t5.DeleteProductByCode"+"\n\t6.exit");
					System.out.println("enter the Choice");
					int choice=Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					   case 1: 
						     System.out.println("==AddProduct==");
						     System.out.println("Enter productCode");
						     String pc=sc.nextLine();
						     System.out.println("enter productName");
						     String pn=sc.nextLine();
						     System.out.println("enter productPrice");
						     float pp=sc.nextFloat();
						     System.out.println("enter productqnty");
						     int pq=sc.nextInt();
						     ps1.setString(1,pc);
						     ps1.setString(2, pn);
						     ps1.setFloat(3, pp);
						     ps1.setInt(4, pq);
						     int a=ps1.executeUpdate();
						     if(a>0)
						     {
						       System.out.println("product added successfully");
						     }
						   break;
					   case 2:
						   ResultSet rs=ps2.executeQuery();
						   while(rs.next())
						   {
							  System.out.println( rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
						   }
						   rs.close();
						   break;
					   case 3:
						   System.out.println("enter a productCode");
						   String code=sc.nextLine();
						   ps3.setString(1, code);
						   ResultSet rs2=ps3.executeQuery();
						   if(rs2.next())
						   {
							   System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
							   
						   }
						   else
						   {
							   System.out.println("invailid ProductCode");
						   }
						   break;
					   case 4:
						   System.out.println("enter productCode");
						   String pc3=sc.nextLine();
						   ps3.setString(1,pc3);
						   ResultSet rs4=ps4.executeQuery();
						   if(rs4.next())
						   {
							   System.out.println("old price "+rs4.getFloat(3));
							   System.out.println("enter new productPrice");
							   float nPPrice=Float.parseFloat(sc.nextLine());
							   ps4.setFloat(3, nPPrice);
							   System.out.println("Existing qantity"+rs4.getFloat(4));
							   System.out.println("enter a new quantity");
							   int nPQ=Integer.parseInt(sc.nextLine());
							   ps4.setInt(4, nPQ);
							   int m=ps4.executeUpdate();
							   if(m>0)
							   {
								   System.out.println("updated successful");
							   }
							   else
							   {
								   System.out.println("invailid product Code");
							   }
						   }
						   break;
					   case 5:
						   System.out.println("enter  productCode");
						   String pcDelete=sc.nextLine();
						   ps3.setString(1, pcDelete);
						   ResultSet rs6=ps3.executeQuery();
						   if(rs6.next())
						   {
							   System.out.println("product successful Deleted");
						   }
						   else
						   {
							   System.out.println("invailid Product code");
						   }
						   
						   break;
					   case 6:
						   System.out.println("Operation Stopped");
						   System.exit(0);
						   break;
						   default:
							   System.out.println("invalid choice");
							   
					}
				}
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
		}

	}

}
