package maps;

import java.io.*;
import java.sql.*;
import java.util.*;
import org.newdawn.slick.*;
import interfaces.Objet;
import lanceur.App;

public class Maps implements Objet
{	
	public static HashMap<Integer,HashMap<Integer,Case>> map;
	
	public Maps() throws SlickException, FileNotFoundException, SQLException
	{
		map = new HashMap<Integer,HashMap<Integer,Case>>();
		int nbMap = 0;
		ResultSet rs = App.SQL.executeQuery("SELECT *, (CASE WHEN EXISTS(SELECT * FROM CASES C2 WHERE C2.MAP="+nbMap+" AND C2.X=C1.X AND C2.Y=C1.Y-1) THEN 1 ELSE 0 END) AS TOP FROM CASES C1 WHERE C1.MAP="+nbMap+" ORDER BY X, Y");
		while(rs.next())
		{
			HashMap<Integer,Case> tmp;
			if(map.containsKey(rs.getInt(3))) tmp = map.get(rs.getInt(3));
			else tmp = new HashMap<Integer,Case>();
			tmp.put(rs.getInt(2),new Case(rs.getInt(4),rs.getInt(5)));
			map.put(rs.getInt(3),tmp);
		}
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException 
	{
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext())
		{
			int y = it.next();
			HashMap<Integer,Case> tmp = map.get(y);
			Iterator<Integer> it2 = tmp.keySet().iterator();
			while(it2.hasNext())
			{
				int x = it2.next();
				Case temp = tmp.get(x);
				temp.getImage().draw(50*x,50*y);
			}
		}
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		
	}
	
	public boolean vertical(int x, int y, int xbis) 
	{
		if(map.containsKey(y)){if(map.get(y).containsKey(x)||map.get(y).containsKey(xbis))return false;}
		return true;
	}
	
	public boolean horizontal(int x, int y, int ybis) 
	{
		if(map.containsKey(y)) 		{if(map.get(y)		.containsKey(x))return false;}
		if(map.containsKey(ybis)) 	{if(map.get(ybis)	.containsKey(x))return false;}
		return true;
	}
}
