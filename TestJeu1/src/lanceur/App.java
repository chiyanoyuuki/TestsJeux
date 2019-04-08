package lanceur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.newdawn.slick.*;

public class App 
{
	public static Statement SQL;
	public final static int width = 1600;
	public final static int height = 900;
	
	public App() throws SlickException
	{		
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1/testjeu?user=root&password=chiyanoyuuki1512.");
			SQL = connection.createStatement();
		} catch (SQLException | ClassNotFoundException e1) {e1.printStackTrace();}
		
		AppGameContainer app = new AppGameContainer(new Game(), width, height, false);
    	app.setShowFPS(false);
    	app.start();
	}
	
	 public static void main(String[] args) throws SlickException {App app = new App();}
}
