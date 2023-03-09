package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Scanner;


public class DataBaseBus {
    private static Scanner scan=new Scanner(System.in);
    void toInsertBusInfo(Connection connection) throws SQLException {
		PreparedStatement addAll=connection.prepareStatement("INSERT INTO bus_management values(?,?,?,?,?,?)");
		System.out.println("Enter the StartingPoint ");
		addAll.setString(1, scan.next());
		System.out.println("Enter the EndingPoint ");
		addAll.setString(2, scan.next());
		System.out.println("Enter the DriverName ");
		addAll.setString(3, scan.next());
		System.out.println("Enter the DriverNo ");
		addAll.setLong(4, scan.nextLong());
		System.out.println("Enter the BusNo ");
		addAll.setString(5, scan.next());
		System.out.println("Enter the BusType ");
		addAll.setString(6, scan.next());
		int addValues=addAll.executeUpdate();
		System.out.println(addValues +"AddedValues");

	}	
	
		void toDisplayBusInfo(Connection connection)  throws SQLException,Exception{
			Statement stmt=connection.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM bus_management");
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getLong(4)+result.getString(5)+" "+result.getString(6));
			}
		}
		
		void toSearchBusInfo(Connection connection)throws SQLException, Exception{ 
			PreparedStatement prepare=connection.prepareStatement("SELECT * FROM bus_management where busNo=?");
			System.out.println("Enter the busno to search: ");
			String search_busNo=scan.next();
			prepare.setString(1,search_busNo);
			ResultSet search=prepare.executeQuery();
			while(search.next()) {
				System.out.println(search.getString(1)+" "+search.getString(2)+" "+search.getString(3)+" "+search.getLong(4)+search.getString(5)+" "+search.getString(6));

			}
		}
		
		void toUpdateBusInfo(Connection connection) throws SQLException,Exception {
			
		PreparedStatement prepareStmt=connection.prepareStatement("update bus_management set Bus_Type=?, Starting_point = ? where busNo=?");
		System.out.println("ENter the busno to update");
		prepareStmt.setString(3,scan.next());
		System.out.println("Enter the busType");
		prepareStmt.setString(1,scan.next());
		System.out.println("Enter the StartingPoint");
		prepareStmt.setString(2,scan.next());
		int update=prepareStmt.executeUpdate();
		System.out.println(update +"Record updated");


		}


		
		void toDeleteBusInfo(Connection connection)throws SQLException,Exception {
			PreparedStatement prepare=connection.prepareStatement("DELETE FROM bus_management where busNo=?");
			System.out.println("Enter the busno to delete: ");
			String delete_busNo=scan.nextLine();
			prepare.setString(1,delete_busNo);
			int deleterecord = prepare.executeUpdate();
			System.out.println(deleterecord);
		}
	}
	