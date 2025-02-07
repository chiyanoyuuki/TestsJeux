package interfaces;

import java.io.File;
import org.newdawn.slick.*;

public abstract class Graphique 
{	
	private int x;
	private int y;
	private int delai = 5;
	private long[] temps;
	private Image image;
	
	public Graphique(int x, int y)	
	{
		this.x = x;
		this.y = y;
		long tmp = System.currentTimeMillis();
		this.temps = new long[] {tmp,tmp,tmp,tmp};
	}
	
	public Graphique() 				{this(0, 0);}
	
	private boolean verif(int i)
	{
		long tmp = System.currentTimeMillis();
		if(tmp-temps[i]>delai)
		{
			temps[i] = tmp;
			return true;
		}
		return false;
	}

	public void reculer() 			{if(verif(0))this.x--;}
	public void monter() 			{if(verif(1))this.y--;}
	public void avancer() 			{if(verif(2))this.x++;}
	public void descendre() 		{if(verif(3))this.y++;}
		
	public int getX() 				{return this.x;}
	public int getY() 				{return this.y;}
	public int getDelai()			{return this.delai;}
	public Image getImage()			{return this.image;}
	
	public void setX(int x) 		{this.x=x;}
	public void setY(int y) 		{this.y=y;}
	public void setDelai(int delai) {this.delai=delai;}
	public void setImage(String path) throws SlickException
	{
		int nb = new File(path).list().length;
		this.image = new Image(path+(int)(Math.random()*nb)+".png");
	}
		
	public abstract void render(GameContainer container, Graphics g) throws SlickException;
	public abstract void update(GameContainer container, int delta) throws SlickException;
}
