package finalProject;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Platform 
{
	private PApplet parent;
	private PImage greenPlatform;
	private float speedX, speedY, AbsY;
	private float greenPfX =0,greenPfY = 0, brownPF = 0;
	
	public Platform(PApplet p, int cX, int cY)
	{
		parent = p;
		greenPfX = cX;
		//speedY =5;
		greenPfY = cY;
		
		greenPlatform = parent.loadImage("images/PLATFORM-removebg-preview.png");
	}
	
	public void drawPlat()// platform
	{
		parent.image(greenPlatform, greenPfX, greenPfY - DoodleJumpEnvironment.scrollY);
	}
	
	public float getY()
	{
		return greenPfY;
	}
	public float getX()
	{
		return greenPfX;
	}

	public void updateY()
	{
		greenPfY -= 10;
	}
	
	public void storeAbsY()
	{
		
	}
	
}
