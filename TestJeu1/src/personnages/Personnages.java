package personnages;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.newdawn.slick.*;
import interfaces.Objet;
import maps.Case;
import maps.Maps;

public class Personnages implements Objet
{	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Image idle, idle2;
	private Maps map;

	private Animation run, run2;
	private int state;
	
	public Personnages(Objet map) throws SlickException, FileNotFoundException, SQLException
	{
		this.map = (Maps) map;
		this.x = 100;
		this.y = 100;
		this.idle = new Image("C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/images/personnages/kaneki/0.png");
		this.idle2 = new Image("C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/images/personnages/kaneki/-1.png");
		this.width = idle.getWidth();
		this.height = idle.getHeight()-4;
		File tmp = new File("C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/images/personnages/kaneki/run/loop/");
		String[] files = tmp.list();
		Image[] images = new Image[files.length];
		Image[] images2 = new Image[files.length];
		for(int i=0;i<files.length;i++) 
		{
			images[i] = new Image("C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/images/personnages/kaneki/run/loop/"+i+".png");
			images2[i] = new Image("C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/images/personnages/kaneki/run/loop2/"+i+".png");
		}
		run = new Animation(images,60);
		run2 = new Animation(images2,60);
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		if(state==-1)this.idle2.draw(x,y);
		else if(state==0)this.idle.draw(x,y);
		else if(state==1)this.run.draw(x,y);
		else if(state==2)this.run2.draw(x,y);
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		if(state==1)state=0;
		else if(state==2)state=-1;
		tomber();
		
		if (container.getInput().isControllerLeft(3)) 	{reculer();}
		if (container.getInput().isControllerRight(3)) 	{avancer();}
		if (container.getInput().isControllerUp(3)) 	{monter();}
		
		
		if (container.getInput().isKeyDown(Input.KEY_Q)) {reculer();}
		if (container.getInput().isKeyDown(Input.KEY_D)) {avancer();}
		if (container.getInput().isKeyDown(Input.KEY_Z)) {monter();}
	}
	
	private void monter() 	{int delta=2;if(map.vertical	(((x)/50			)	,(y-delta)/50			,(x+width)/50))		y-=delta;}
	private void tomber() 	{int delta=1;if(map.vertical	(((x)/50			)	,(y+height+delta)/50	,(x+width)/50))		y+=delta;}
	private void avancer() 	{int delta=1;if(map.horizontal	(((x+width+delta)/50)	,(y/50)					,(y+height)/50))	{x+=delta;state=1;}}
	private void reculer() 	{int delta=1;if(map.horizontal	(((x-delta)/50		)	,(y/50)					,(y+height)/50))	{x-=delta;state=2;}}
	
}
