package fonds;

import java.util.*;
import org.newdawn.slick.*;
import graphiques.*;
import interfaces.*;
import lanceur.App;

public class Ciel implements Objet
{
	private ArrayList<Graphique> graphiques;
	
	public Ciel() throws SlickException
	{
		this.graphiques = new ArrayList<Graphique>();
		for(int i=0;i<10;i++) {this.graphiques.add(new Nuage());}
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		g.setColor(new Color(150,220,230));
		g.fillRect(0,0,App.width,App.height);
		for(Graphique graphique:graphiques) {graphique.render(container, g);}
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		for(int i=0;i<graphiques.size();i++) 
		{
			Graphique g = graphiques.get(i);
			g.update(container,delta);
			if(g.getX()<=g.getImage().getWidth()*-1)
			{
				graphiques.remove(i--);
				graphiques.add(new Nuage(0));
			}
				
		}
	}	
}
