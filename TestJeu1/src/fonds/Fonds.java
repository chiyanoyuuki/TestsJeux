package fonds;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import interfaces.Objet;

public class Fonds implements Objet
{
	private Objet fond;
	
	public Fonds() throws SlickException
	{
		this.fond = new Ciel();
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		this.fond.render(container,g);
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		this.fond.update(container,delta);
	}

}
