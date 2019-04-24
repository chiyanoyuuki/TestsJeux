package Maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

public class MapFromCsv 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException
	{
		Class.forName("org.mariadb.jdbc.Driver");
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1/testjeu?user=root&password=chiyanoyuuki1512.");
		Statement st = connection.createStatement();
		
		int map = 0;
		
		try{st.executeQuery("INSERT INTO MAPS VALUES("+map+")");}
		catch(Exception e) {}
		
		Scanner sc = new Scanner(new FileReader(new File("C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/maps/"+map+".csv")));
		int y = 0;
		while(sc.hasNext())
		{
			String[] tmp = sc.nextLine().split(";");
			int x = 0;
			for(String s:tmp)
			{
				if(!s.equals(""))
				{
					try{st.executeQuery("INSERT INTO CASES VALUES("+map+","+x+","+y+","+s+")");}
					catch(Exception e) {}
				}
				x++;
			}
			y++;
		}
	}
}
