package interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class Forme 
{	
	private int x;
	private int y;
	
	public Forme(int x, int y)	
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX() 				{return this.x;}
	public int getY() 				{return this.y;}
	
	public void setX(int x) 		{this.x=x;}
	public void setY(int y) 		{this.y=y;}
		
	public abstract void render(int x, int y, GameContainer container, Graphics g) throws SlickException;
}