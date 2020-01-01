package _08final.mvc.model;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import _08final.mvc.controller.Game;

public class Asteroid extends Sprite {



	private int nSpin;

	//radius of a large asteroid
	private final int RAD = 100;

	//nSize determines if the Asteroid is Large (0), Medium (1), or Small (2)
	//when you explode a Large asteroid, you should spawn 2 or 3 medium asteroids
	//same for medium asteroid, you should spawn small asteroids
	//small asteroids get blasted into debris
	public Asteroid(int nSize){

		//call Sprite constructor
		super();

		setTeam(Team.FOE);

		ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

		// top of ship
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();


		// TLDR: Bunch of For Loops to Create the Bug Object (the asteroid)
		for (double tempX = -2; tempX >= -2.75; tempX-=.01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}

		for (double tempX = -2.75; tempX >= -3.5; tempX-=.01)
		{

			pntCs.add(new Point2D.Double(tempX, -.5*(tempX+2.75)));
		}

		for (double tempX = -3.5; tempX <= -2.75; tempX += .01)
		{

			pntCs.add(new Point2D.Double(tempX, -.5*(tempX+2.75)));
		}


		for (double tempX = -2.75; tempX <= -2; tempX += .01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}


		for (double tempX = -2; tempX < 2; tempX+=.01)
		{
			tempX = Math.round(tempX*100.0)/100.0;


			double tempY = Math.sqrt(4-Math.pow(tempX,2));

			pntCs.add(new Point2D.Double(tempX, tempY));

			if (tempX == -1.32)
			{
				for(double a = -1.32; a<= 1.32; a+=.01)
				{
					a = Math.round(a*100.0)/100.0;

					double b = (-1/(1.5)) * Math.pow(a, 2) + 2.65;
					pntCs.add(new Point2D.Double(a, b));

					if (a == -.29)
					{
						for(double c = -.29; c >= -.75; c-=.01)
						{
							pntCs.add(new Point2D.Double(c, -2*(c-1)));

						}

						for(double c = -.75; c <= -.29; c+=.01)
						{
							pntCs.add(new Point2D.Double(c, -2*(c-1)));

						}
					}

					if (a == .29)
					{
						for(double c = .29; c <= .75; c+=.01)
						{
							pntCs.add(new Point2D.Double(c, 2*(c+1)));

						}

						for(double c = .75; c >= .29; c-=.01)
						{
							pntCs.add(new Point2D.Double(c, 2*(c+1)));

						}
					}

				}


				for(double a = 1.32; a>= -1.32; a-=.01)
				{
					a = Math.round(a*100.0)/100.0;
					double b = (-1/(1.5)) * Math.pow(a, 2) + 2.65;
					pntCs.add(new Point2D.Double(a, b));

				}
			}



			if (tempX == 1.64)
			{
				for(double a = 1.64; a<2.25; a+=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}


				for(double a = 2.25; a>1.64; a-=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}


			if (tempX == -1.64)
			{
				for(double a = -1.64; a >= - 2.25; a-=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

				for(double a = -2.25; a <= -1.64; a+=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}


			pntCs.add(new Point2D.Double(tempX, tempY));
		}


		for (double tempX = 2; tempX <= 2.75; tempX+=.01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}

		for (double tempX = 2.75; tempX <= 3.5; tempX+=.01)
		{

			pntCs.add(new Point2D.Double(tempX, .5*(tempX-2.75)));
		}

		for (double tempX = 3.5; tempX >= 2.75; tempX -= .01)
		{

			pntCs.add(new Point2D.Double(tempX, .5*(tempX-2.75)));
		}


		for (double tempX = 2.75; tempX >= 2; tempX -= .01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}


		for (double tempX = 2; tempX > - 2; tempX-=.01)
		{
			tempX = Math.round(tempX*100.0)/100.0;

			double tempY = -Math.sqrt(4-Math.pow(tempX,2));
			pntCs.add(new Point2D.Double(tempX, tempY));


			if (tempX == 1.64)
			{
				for(double a = 1.64; a<=2.0; a+=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

				for(double a = 2.0; a>= 1.64; a-=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}

			if (tempX == -1.64)
			{
				for(double a = -1.64; a >=- 2.0; a-=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}

				for(double a = -2.0; a <= -1.64; a+=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}


			pntCs.add(new Point2D.Double(tempX, tempY));


		}

		assignPolarPoints(pntCs);

		setExpire(50);
		setRadius(100);
		setColor(CommandCenter.getInstance().getHeartColor());


		int nX = Game.R.nextInt(10);
		int nY = Game.R.nextInt(10);
		int nS = Game.R.nextInt(4);

		//set random DeltaX
		if (nX % 2 == 0)
			setDeltaX(nX);
		else
			setDeltaX(-nX);

		//set rnadom DeltaY
		if (nY % 2 == 0)
			setDeltaX(nY);
		else
			setDeltaX(-nY);

		//set random spin
		if (nS % 2 == 0)
			setSpin(nS);
		else
			setSpin(-nS);

		//random point on the screen
		setCenter(new Point(Game.R.nextInt(Game.DIM.width),
				Game.R.nextInt(Game.DIM.height)));

		//random orientation
		setOrientation(Game.R.nextInt(360));
		if (nSize == 0)
			setRadius(RAD);
		else
			setRadius(RAD/(nSize * 2));


	}


	public Asteroid(Asteroid astExploded){


		//call Sprite constructor
		super();
		setTeam(Team.FOE);
		int  nSizeNew =	astExploded.getSize() + 1;

		ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

		// top of ship
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();


		// TLDR: Bunch of For Loops to Create the Bug Object, this time a smaller one
		for (double tempX = -2; tempX >= -2.75; tempX-=.01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}

		for (double tempX = -2.75; tempX >= -3.5; tempX-=.01)
		{

			pntCs.add(new Point2D.Double(tempX, -.5*(tempX+2.75)));
		}

		for (double tempX = -3.5; tempX <= -2.75; tempX += .01)
		{

			pntCs.add(new Point2D.Double(tempX, -.5*(tempX+2.75)));
		}


		for (double tempX = -2.75; tempX <= -2; tempX += .01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}



		for (double tempX = -2; tempX < 2; tempX+=.01)
		{
			tempX = Math.round(tempX*100.0)/100.0;


			double tempY = Math.sqrt(4-Math.pow(tempX,2));

			pntCs.add(new Point2D.Double(tempX, tempY));

			if (tempX == -1.32)
			{
				for(double a = -1.32; a<= 1.32; a+=.01)
				{
					a = Math.round(a*100.0)/100.0;

					double b = (-1/(1.5)) * Math.pow(a, 2) + 2.65;
					pntCs.add(new Point2D.Double(a, b));

					if (a == -.29)
					{
						for(double c = -.29; c >= -.75; c-=.01)
						{
							pntCs.add(new Point2D.Double(c, -2*(c-1)));

						}

						for(double c = -.75; c <= -.29; c+=.01)
						{
							pntCs.add(new Point2D.Double(c, -2*(c-1)));

						}
					}

					if (a == .29)
					{
						for(double c = .29; c <= .75; c+=.01)
						{
							pntCs.add(new Point2D.Double(c, 2*(c+1)));

						}

						for(double c = .75; c >= .29; c-=.01)
						{
							pntCs.add(new Point2D.Double(c, 2*(c+1)));

						}
					}

				}


				for(double a = 1.32; a>= -1.32; a-=.01)
				{
					a = Math.round(a*100.0)/100.0;
					double b = (-1/(1.5)) * Math.pow(a, 2) + 2.65;
					pntCs.add(new Point2D.Double(a, b));

				}
			}



			if (tempX == 1.64)
			{
				for(double a = 1.64; a<2.25; a+=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}


				for(double a = 2.25; a>1.64; a-=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}


			if (tempX == -1.64)
			{
				for(double a = -1.64; a >= - 2.25; a-=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

				for(double a = -2.25; a <= -1.64; a+=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}


			pntCs.add(new Point2D.Double(tempX, tempY));
		}


		for (double tempX = 2; tempX <= 2.75; tempX+=.01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}

		for (double tempX = 2.75; tempX <= 3.5; tempX+=.01)
		{

			pntCs.add(new Point2D.Double(tempX, .5*(tempX-2.75)));
		}

		for (double tempX = 3.5; tempX >= 2.75; tempX -= .01)
		{

			pntCs.add(new Point2D.Double(tempX, .5*(tempX-2.75)));
		}


		for (double tempX = 2.75; tempX >= 2; tempX -= .01)
		{

			pntCs.add(new Point2D.Double(tempX, 0));
		}


		for (double tempX = 2; tempX > - 2; tempX-=.01)
		{
			tempX = Math.round(tempX*100.0)/100.0;

			double tempY = -Math.sqrt(4-Math.pow(tempX,2));
			pntCs.add(new Point2D.Double(tempX, tempY));


			if (tempX == 1.64)
			{
				for(double a = 1.64; a<=2.0; a+=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

				for(double a = 2.0; a>= 1.64; a-=.01)
				{
					double atempY = -(a+.05);
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}

			if (tempX == -1.64)
			{
				for(double a = -1.64; a >=- 2.0; a-=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}

				for(double a = -2.0; a <= -1.64; a+=.01)
				{
					double atempY = a-.05;
					pntCs.add(new Point2D.Double(a, atempY));
				}

			}


			pntCs.add(new Point2D.Double(tempX, tempY));


		}

		assignPolarPoints(pntCs);
		setExpire(50);

		int nX = Game.R.nextInt(10);
		int nY = Game.R.nextInt(10);
		int nS = Game.R.nextInt(4);

		//set random DeltaX
		if (nX % 2 == 0)
			setDeltaX(nX);
		else
			setDeltaX(-nX);

		//set rnadom DeltaY
		if (nY % 2 == 0)
			setDeltaX(nY);
		else
			setDeltaX(-nY);

		//set random spin
		if (nS % 2 == 0)
			setSpin(nS);
		else
			setSpin(-nS);

		//random point on the screen



		setRadius(RAD/(nSizeNew * 2));
		setCenter(astExploded.getCenter());


	}

	public int getSize(){

		int nReturn = 0;

		switch (getRadius()) {
			case 100:
				nReturn= 0;
				break;
			case 50:
				nReturn= 1;
				break;
			case 25:
				nReturn= 2;
				break;
		}
		return nReturn;

	}


	@Override
	public void move(){
		super.move();

		//a Bug spins, so you need to adjust the orientation at each move()
		setOrientation(getOrientation() + getSpin());

	}

	public int getSpin() {
		return this.nSpin;
	}


	public void setSpin(int nSpin) {
		this.nSpin = nSpin;
	}


	// Draw Bug
	public void draw(Graphics g)
	{
		super.draw(g);
		//fill this polygon (with whatever color it has)
		g.setColor(CommandCenter.getInstance().getAstColor());
		g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);

		// Outline = Black
		g.setColor(Color.BLACK);
		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
	}





}
