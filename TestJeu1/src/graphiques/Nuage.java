package graphiques;

import java.util.*;
import org.newdawn.slick.*;

import generaux.Rond;
import interfaces.*;
import lanceur.App;

public class Nuage extends Graphique
{
	private ArrayList<Rond> ronds;
	private Color color;
	private int nb;
	private float scale;
	
	public Nuage(int i) throws SlickException
	{		
		super((int)(Math.random()*App.width),(int)(Math.random()*App.height));
		this.nb = i;
		scale = (float) (0.5+nb%10*0.05);
		ronds = new ArrayList<Rond>();
		
		double delai = ((Math.random()*20)*2)+10;
		int tmp = 220+(int)((1-(delai/50))*35);
				
		this.setDelai((int)(delai));
		this.color = new Color(tmp,tmp,tmp);
		
		this.setImage("./images/fonds/ciel/nuage/");
	}
	
	public Nuage(int x, int i) throws SlickException
	{		
		super(App.width,(int)(Math.random()*App.height));
		this.nb = i;
		scale = (float) (0.5+nb%10*0.05);
		ronds = new ArrayList<Rond>();
		
		double delai = ((Math.random()*20)*2)+10;
		int tmp = 220+(int)((1-(delai/50))*35);
				
		this.setDelai((int)(delai));
		this.color = new Color(tmp,tmp,tmp);
		
		this.setImage("./images/fonds/ciel/nuage/");
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		getImage().draw(getX(), getY(), scale, color);
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		this.reculer();
	}
}