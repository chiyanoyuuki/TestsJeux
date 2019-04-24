package Launcher;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Background 
{
	private final int MAXHEIGHT = App.height-200;
	
	private Image image;
	private Color filter;
	private int fade;
	private int x,y,width,height;
	
	public Background()
	{
		init(0);
	}
	
	public void init(int i)
	{
		fade = 0;
		try 
		{
			image = new Image("./images/villes/"+i+".jpg");
			
			width = image.getWidth();
			height = image.getHeight();
			
			if(height>MAXHEIGHT)
			{
				int tmp = height-MAXHEIGHT;
				height = height-tmp;
				width = width-tmp;
			}
			else if(height<MAXHEIGHT)
			{
				int tmp = MAXHEIGHT-height;
				height = height+tmp;
				width = width+tmp;
			}
			
			if(width<App.width)x=(App.width-width/2);
		} 
		catch (Exception e) {System.out.println("Erreur Initialisation Background : " + i);}
	}
	
	public void render(GameContainer container, Graphics g)
	{
		if(fade<255) {fade++;filter=new Color(fade,fade,fade);}
		image.draw(x,y,width,height,filter);
	}
}
