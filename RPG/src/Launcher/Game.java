package Launcher;

import org.newdawn.slick.*;

public class Game extends BasicGame 
{		
	private Musique musique;
	private Background background;
	
    public Game() {super("Jeu 1");}

    @Override
    public void init(GameContainer container) throws SlickException 
    {	
    	musique 	= new Musique();
    	background 	= new Background();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException 
    {
    	background.render(container,g);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
    	Input c = container.getInput();
    	if(c.isMousePressed(Input.MOUSE_LEFT_BUTTON))musique.init(0);
    }
}