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
	private Personnage j1, j2;
	
	public Personnages(Objet map) throws SlickException, FileNotFoundException, SQLException
	{
		j1 = new Personnage(map,"kaneki", 1);
		j2 = new Personnage(map,"kaneki", 2);
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		j1.render(container, g);
		j2.render(container, g);
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		j1.update(container, delta); j2.update(container, delta);
		
		Input i = container.getInput();
		
		if(i.isKeyDown(Input.KEY_Q))j1.reculer();
		if(i.isKeyDown(Input.KEY_D))j1.avancer();
		
		if(i.isKeyDown(Input.KEY_LEFT))j2.reculer();
		if(i.isKeyDown(Input.KEY_RIGHT))j2.avancer();
	}
}
