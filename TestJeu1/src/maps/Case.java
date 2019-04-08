package maps;

import java.io.File;
import org.newdawn.slick.*;

public class Case 
{	
	private Image image, bords;
	private int nbBords;
	
	public Case(int type, int top, int nbBords) throws SlickException	
	{		
		String path = "./images/sols/"+type+"/"+top+"/";
		int nb = new File(path).list().length;
		nb = (int)(Math.random()*(nb));
		this.image = new Image(path+nb+".png");
		this.nbBords = nbBords;
		this.bords = new Image("./images/sols/-1/"+nbBords+".png");
	}
	
	public Image getImage() {return this.image;}
		
	public void render(int x, int y, GameContainer container, Graphics g) throws SlickException
	{
		this.image.draw(x,y);
		if(this.nbBords>0) {this.bords.draw(x,y);}
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		
	}
}