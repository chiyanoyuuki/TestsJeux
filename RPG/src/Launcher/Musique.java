package Launcher;

import org.newdawn.slick.*;

public class Musique 
{
	private Music musique;
	
	public Musique()
	{
		init(1);
	}
	
	public void init(int i)
	{
		try 
		{
			
			musique = new Music("./musiques/"+i+".wav");
		} 
		catch (Exception e) {System.out.println("Erreur Initialisation Musique : " + i);}
		musique.loop(1f,0f);
		musique.fade(5000, 1f, false);
	}
}
