package generaux;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import interfaces.Forme;

public class Rond extends Forme
{
	public Rond(int x, int y)
	{
		super(x,y);
	}
	
	public void render(int x, int y, GameContainer container, Graphics g) throws SlickException 
	{
		g.fillOval(x+getX(), y+getY(), 50, 50);
	}
}