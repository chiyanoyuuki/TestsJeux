package maps;

import java.io.File;
import org.newdawn.slick.*;

public class Case 
{	
	private Image image;
	
	public Case(int type, int top) throws SlickException	
	{		
		String path = "C:/Users/ASC Arma/Desktop/TestJeu/TestJeu1/images/sols/"+type+"/"+top+"/";
		int nb = new File(path).list().length;
		nb = (int)(Math.random()*(nb-1));
		this.image = new Image(path+nb+".png");
	}
	
	public Image getImage() {return this.image;}
		
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		
	}
}