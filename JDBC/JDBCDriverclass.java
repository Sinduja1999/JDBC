package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;



public class JDBCDriverclass {
	static Connection connection=null;
	static Connection createConnection() {

		try {
			String userName="root";
			String passWord="Jesus@123";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/busdetails",userName,passWord);

		}
		catch(Exception object) {
			System.out.println(object);
		}
		return connection;
	}

	public static void main(String args[]) throws Exception{
		BusDetails busObject= new BusDetails();
		DataBaseBus bus=new DataBaseBus();
		Connection connect =createConnection();
		Scanner scan=new Scanner(System.in);
		System.out.println("*WELCOME TO REDBUS*");
		System.out.println("Enter 1 to insert Bus Information");
		System.out.println("Enter 2 to display Bus Information");
		System.out.println("Enter 3 to Search Bus Information");
		System.out.println("Enter 4 to Update Bus Information");
		System.out.println("Enter 5 For Delete Bus Information");
		System.out.println("Enter 6 for Logout Bus Information");
		byte userInput;
		do {
			userInput=scan.nextByte();
			switch(userInput) {
			case 1: 
				bus.toInsertBusInfo(connect);
				break;

			case 2:
				bus.toDisplayBusInfo(connect);
				break;
			case 3:
				bus.toSearchBusInfo(connect);
				break;
			case 4:
				bus.toUpdateBusInfo(connect);
				break;
			case 5:
				bus.toDeleteBusInfo(connect);
				break;
			case 6:
				BusDetails.tologout();
				connection.close();
				break;
			}
		}while(userInput!=6);
	}
}