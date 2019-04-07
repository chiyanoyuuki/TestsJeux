package lanceur;

import org.newdawn.slick.*;

public class App 
{
	public final static int width = 1600;
	public final static int height = 900;
	
	public App() throws SlickException
	{		
		AppGameContainer app = new AppGameContainer(new Game(), width, height, false);
    	app.setShowFPS(false);
    	app.start();
	}
	
	 public static void main(String[] args) throws SlickException {App app = new App();}
}
