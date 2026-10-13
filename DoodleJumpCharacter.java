package finalProject;

import processing.core.PApplet;
import processing.core.PImage;

public class DoodleJumpCharacter
{
	private PApplet parent;
	private PImage doodler;
	private float speedX, speedY, accY;
	private float doodlerX =0, doodlerY = 0;
	public boolean goingLeft, goingright;
	
	public DoodleJumpCharacter(PApplet p, int cX, int cY)
	{
		
		parent = p;
		doodlerX = cX;
		doodlerY = cY;
		speedX = 0;
		speedY = 1;
		accY = 0.1f;
		doodler = parent.loadImage("images/doodler-removebg-preview(1).png");
	}
	
	public float getY()
	{
		return doodlerY;
	}
	
	public float getX()
	{
		return doodlerX;
	}
	
	public void drawSelf()
	{
		parent.image(doodler,doodlerX,doodlerY - DoodleJumpEnvironment.scrollY);
		updateDoodlerPosition();
	}
	
	public void setSpeedX(int newSpeedX)
	{
		speedX = newSpeedX;
	}
	
	public boolean bounce()
	{
		speedY = -5;
		return true;
	}
	
	public void updateDoodlerPosition()
	{
		// update the speed baed on the acceleration
		speedY += accY;
		
		// update the position based on the speed
		doodlerY += speedY;
		
		doodlerX += speedX;
		
		if( doodlerX >= 400)
		{
			doodlerX = 0;
		}
		else if (doodlerX <= 0)
		{
			doodlerX = 400;
		}
		
	}
	public void mirror()
	{
		
				
	}



}
