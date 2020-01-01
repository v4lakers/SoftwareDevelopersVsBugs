package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Triangle extends NewShipFloater {




    public Triangle() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        // XY Coordinates
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        // Draw Triangle
        pntCs.add(new Point2D.Double(-1,-.5));
        pntCs.add(new Point2D.Double(-.1,1.38));
        pntCs.add(new Point2D.Double(1.04,.16));
        pntCs.add(new Point2D.Double(-1,-.5));


        assignPolarPoints(pntCs);
        setColor(CommandCenter.getInstance().getHeartColor());
        orientShape();
    }

    // Draw
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }


}
