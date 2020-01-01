package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NewShipFloater extends Sprite {


	private int nSpin;
	public final static int EXPIRE = 80;
	public final static int RAD = 50;


	public NewShipFloater() {

		super();
		setTeam(Team.FLOATER);

		ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

		// top of ship
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();

		for (double a = 0; a < 2 * Math.PI; a += .01) {
			double r = 10;
			double tempX = r * 16 * Math.pow(Math.sin(a), 3);
			double tempY = (-1) * r * (13 * Math.cos(a) - 5 * Math.cos(2 * a) - 2 * Math.cos(3 * a) - Math.cos(4 * a));
			pntCs.add(new Point2D.Double(tempX, tempY));

		}



		assignPolarPoints(pntCs);
		setColor(CommandCenter.getInstance().getHeartColor());
	}
	public void orientShape()
	{
		setExpire(EXPIRE);
		setRadius(RAD);
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
	}




	@Override
	public void move() {
		super.move();
		setOrientation(getOrientation() + getSpin());

		//adding expire functionality
		if (getExpire() == 0)
			CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
		else
			setExpire(getExpire() - 1);


	}

	public int getSpin() {
		return this.nSpin;
	}

	public void setSpin(int nSpin) {
		this.nSpin = nSpin;
	}



	public void draw(Graphics g) {
		super.draw(g);
		//fill this polygon (with whatever color it has)
		g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
		//now draw a white border
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
		g2.setStroke(new BasicStroke(1));
	}


}
