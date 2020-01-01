package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Heart extends NewShipFloater {



    public Heart() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        // XY Coordinates
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        // Create the Heart
        for (double a = 0; a < 2 * Math.PI; a += .01) {
            double r = 10;
            double tempX = r * 16 * Math.pow(Math.sin(a), 3);
            double tempY = (-1) * r * (13 * Math.cos(a) - 5 * Math.cos(2 * a) - 2 * Math.cos(3 * a) - Math.cos(4 * a));
            pntCs.add(new Point2D.Double(tempX, tempY));

        }

        assignPolarPoints(pntCs);
        setColor(CommandCenter.getInstance().getHeartColor());
        orientShape();
    }


}
