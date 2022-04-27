package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode>nematodes = new ArrayList<Nematode>();
	int i = 0;

	public void keyPressed()
	{
		switch(keyCode)
		{
			case LEFT:
			{
				i--;
				if(i == -1)
				{
					i = nematodes.size() - 1;
				}
				break;
			}
			case RIGHT:
			{
				i++;
				if(i == nematodes.size())
				{
					i = 0;
				}
				break;
			}	
		}	
					
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();			
	}
	
	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow row:table.rows())
		{
			Nematode nema = new Nematode(row);
			nematodes.add(nema);
		}
	}

	public void drawNematodes(int number)
	{
		nematodes.get(number).render(this);
	}

	public void draw()
	{
		drawNematodes(i);
	}
}
