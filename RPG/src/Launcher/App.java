package Launcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.newdawn.slick.*;

public class App 
{
	public static Statement SQL;
	public final static int width = 1200;
	public final static int height = 700;
	
	public App() throws SlickException
	{		
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mariadb://212.227.203.214/rpg?user=ADMIN&password=Chiyanoyuuki1512.");
			SQL = connection.createStatement();
		} 
		catch (Exception e) {System.out.println("Erreur connection BDD");}
		
		AppGameContainer app = new AppGameContainer(new Game(), width, height, false);
    	app.setShowFPS(false);
    	app.setTargetFrameRate(60);
    	app.start();
	}
	
	 public static void main(String[] args) throws SlickException {App app = new App();}
}
