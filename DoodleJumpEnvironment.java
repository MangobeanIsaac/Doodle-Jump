package finalProject;

import java.util.ArrayList;

import processing.core.PApplet;

public class DoodleJumpEnvironment extends PApplet
{
//	private boolean rightArrowPressed, leftArrowPressed, upArrowPressed;
	private DoodleJumpCharacter doodler;
	private float viewYBot;//, relY; 
	private boolean collision = false;
	private ArrayList<Platform> plats;
	
	public static int scrollY = 0;

	
	public static void main(String[] args)
	{
		PApplet.main("finalProject.DoodleJumpEnvironment");
	}
	
	public void settings()
	{
		size(400,600);
	}
	
	public void setup()
	{
		doodler = new DoodleJumpCharacter (this, 75, 550);
		plats = new ArrayList<Platform>();

//		int platY = (int) (Math.random() * 4);
//		int platX = (int) (Math.random() * 6);
		
		plats.add(new Platform(this,189,30));
		plats.add(new Platform(this,284,51));
		plats.add(new Platform(this, 324,583));
		plats.add(new Platform(this,128,433));
		plats.add(new Platform(this,9,378));
		plats.add(new Platform(this,92,271));
		plats.add(new Platform(this,120,142));
		plats.add(new Platform(this,314,500));
		plats.add(new Platform(this,521,-124));
		
		viewYBot = this.height;
	}
	
	public void draw()
	{
		background(255);
		
		doodler.drawSelf();
		
		for(int i = 0; i < plats.size(); i++)
		{
//			if(viewYBot <= 600)
			if(plats.get(i).getY() <= viewYBot &&  plats.get(i).getY() >= viewYBot - height) // should thie platform at i be displayed right now
			{		
//				store relative plat Y
//				float relY = plats.get(i).getY();
				plats.get(i).drawPlat(); 
			}
		}
		
		scrollY = (int) (doodler.getY() - 400);
		platFunctions();
		game();
	}
	
	public void keyReleased()
	{
		if(key == CODED)
		{
			if(keyCode == RIGHT)
				
				doodler.setSpeedX(0);
			else if(keyCode == LEFT)
				doodler.setSpeedX(0);
// set to 0 
		}
	}
	
	public void keyPressed()
	{
		if(key == CODED)
		{
			if(keyCode == RIGHT)
			{
				doodler.setSpeedX(3);
			}
			else if (keyCode == LEFT)
			{
				doodler.setSpeedX(-3);
			}
		}
	}
	
	public void platFunctions()
	{
		if(doodler.getY() >= 550)
		{
			doodler.bounce();
		}
		
		for(int i = 0; i < plats.size(); i++)
		{
			if(!collision && dist(doodler.getX(), doodler.getY(), plats.get(i).getX(), plats.get(i).getY()) < 35)
			{
				doodler.bounce();
//				viewYBot 
			}
		}
	}
	public void game()
	{
		
	}
}
