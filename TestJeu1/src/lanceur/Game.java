package lanceur;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
import org.newdawn.slick.*;
import fonds.*;
import interfaces.Objet;
import maps.Maps;
import personnages.Personnages;

public class Game extends BasicGame 
{	
	private ArrayList<Objet> objets;
	
    public Game() {super("Jeu 1");}

    @Override
    public void init(GameContainer container) throws SlickException 
    {	
    	this.objets = new ArrayList<Objet>();
    	try {
    	this.objets.add(new Fonds());
    	this.objets.add(new Maps());
    	this.objets.add(new Personnages(this.objets.get(1)));
    	} catch (FileNotFoundException | SQLException e) {e.printStackTrace();}
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException 
    {
    	renderObjects(container,g);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
    	updateObjects(container,delta);
    }
    
    private void renderObjects(GameContainer container, Graphics g) throws SlickException
    {
    	for(Objet o:objets) {o.render(container, g);}
    }
    private void updateObjects(GameContainer container, int delta) throws SlickException
    {
    	for(Objet o:objets) {o.update(container, delta);}
    }
}