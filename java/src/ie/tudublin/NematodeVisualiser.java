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

	public void mouseClicked()
	{
		if(mouseX > 0 && mouseX < width/3 && mouseY > height/3 && mouseY < height - height/3)
		{
			i--;
			if(i == -1)
			{
				i = nematodes.size() - 1;
			}
		}
		if(mouseX > width - width/3 && mouseX < width && mouseY > height/3 && mouseY < height - height/3)
		{
			i++;
			if(i == nematodes.size())
			{
				i = 0;
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

		line(width/4, height/2,  (width/4) - (width * 0.1f) , height/2);
		line((width/4) - (width * 0.1f) , height/2, (width/4) - (width * 0.075f), height/2 - (height * 0.02f));
		line((width/4) - (width * 0.1f) , height/2, (width/4) - (width * 0.075f), height/2 + (height * 0.02f));

		line(width - width/4, height/2,  width - (width/4) + (width * 0.1f) , height/2);
		line(width - (width/4) + (width * 0.1f) , height/2, width - width/4 + (width * 0.075f), height/2 - (height * 0.02f));
		line(width - (width/4) + (width * 0.1f) , height/2, width - width/4 + (width * 0.075f), height/2 + (height * 0.02f));

	}
}
