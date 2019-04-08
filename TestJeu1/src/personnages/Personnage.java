package personnages;

import java.io.File;
import java.util.ArrayList;
import org.newdawn.slick.*;
import interfaces.Objet;
import maps.Maps;

public class Personnage 
{
	private Maps map;
	
	private int x, y;
	private int width, height;
	
	private int anim, img, orientation, joueur;
	private String nom;
	
	private ArrayList<Image[]> 		imgs;
	private ArrayList<Animation[]> 	anims;
	
	public Personnage(Objet map, String nom, int joueur) throws SlickException
	{
		this.map = (Maps) map;
		this.nom=nom;
		if(joueur==1) {this.x=200;this.y=50;this.orientation=1;}
		else if(joueur==2) {this.x=1400;this.y=50;this.orientation=0;}
		initImages();		
		initAnimations();
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		this.imgs.get(img)[orientation].draw(x,y);
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		tomber();
	}
	
	private void initImages() throws SlickException
	{
		this.imgs = new ArrayList<Image[]>();
		int nb = new File("./images/personnages/"+nom+"/droite/0/").list().length;
		for(int i=0;i<nb;i++)
		{
			Image[] tmp = new Image[2];
			tmp[0] = new Image("./images/personnages/"+nom+"/gauche/0/"+i+".png");
			tmp[1] = new Image("./images/personnages/"+nom+"/droite/0/"+i+".png");
			this.imgs.add(tmp);
			
			if(i==0) {this.width=tmp[0].getWidth();this.height=tmp[0].getHeight()-5;}
		}
		
	}
	
	private void initAnimations() throws SlickException
	{
		this.anims = new ArrayList<Animation[]>();
		int nb = new File("./images/personnages/"+nom+"/droite/1/").list().length;
		for(int i=0;i<nb;i++)
		{
			int nbPics = new File("./images/personnages/"+nom+"/droite/1/"+i+"/").list().length;
			Image[] tmp1 = new Image[nbPics];
			Image[] tmp2 = new Image[nbPics];
			for(int x=0;x<nbPics;x++)
			{
				tmp1[x] = new Image("./images/personnages/"+nom+"/gauche/1/"+i+"/"+x+".png");
				tmp2[x] = new Image("./images/personnages/"+nom+"/droite/1/"+i+"/"+x+".png");
			}
			Animation[] tmp = new Animation[2];
			tmp[0]=new Animation(tmp1,60);
			tmp[1]=new Animation(tmp2,60);
			this.anims.add(tmp);
		}
		
	}
	
	public void monter() 	{int delta=2;if(map.vertical	(((x)/50			)	,(y-delta)/50			,(x+width)/50))		y-=delta;}
	public void tomber() 	{int delta=1;if(map.vertical	(((x)/50			)	,(y+height+delta)/50	,(x+width)/50))		y+=delta;}
	public void avancer() 	{int delta=1;if(map.horizontal	(((x+width+delta)/50)	,(y/50)					,(y+height)/50))	{x+=delta;orientation=1;}}
	public void reculer() 	{int delta=1;if(map.horizontal	(((x-delta)/50		)	,(y/50)					,(y+height)/50))	{x-=delta;orientation=0;}}
}
