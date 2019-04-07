package lanceur;

import java.util.*;
import org.newdawn.slick.*;
import fonds.*;
import interfaces.Objet;
import sols.Sols;

public class Game extends BasicGame 
{
	private HashMap<String,Objet> objets;
	
    public Game() {super("Jeu 1");}

    @Override
    public void init(GameContainer container) throws SlickException 
    {
    	this.objets = new HashMap<String,Objet>();
    	this.objets.put("fonds",new Fonds());
    	this.objets.put("sols",new Sols());
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
    	Iterator<String> it = this.objets.keySet().iterator();
    	while(it.hasNext())
    	{
    		String key = it.next();
    		Objet o = this.objets.get(key);
    		o.render(container, g);
    	}
    }
    private void updateObjects(GameContainer container, int delta) throws SlickException
    {
    	Iterator<String> it = this.objets.keySet().iterator();
    	while(it.hasNext())
    	{
    		String key = it.next();
    		Objet o = this.objets.get(key);
    		o.update(container, delta);
    	}
    }
}