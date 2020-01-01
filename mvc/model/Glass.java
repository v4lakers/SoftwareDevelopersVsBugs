package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Glass extends NewShipFloater {


    private static final double rad = 4.5;

    public Glass() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        // Array List to hold XY coordinates
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        // Create the Magnifying Glass
         for(double tempX = -rad; tempX <= rad; tempX+=.01)
         {
             double tempY = Math.sqrt(rad*rad-Math.pow(tempX, 2));
             pntCs.add(new Point2D.Double(tempX, tempY));

         }

        for(double tempX = rad; tempX >= -rad; tempX -=.01)
        {
            tempX = Math.round(tempX *100.0) / 100.0;
            if (tempX == 0)
            {
                for(double b = -rad; b >= - rad*2.5; b-=.01)
                {
                    pntCs.add(new Point2D.Double(0, b));
                }

                for(double b = -rad*2.5; b <= - rad; b+=.01)
                {
                    pntCs.add(new Point2D.Double(0, b));
                }

            }
            double tempY = -Math.sqrt(rad*rad-Math.pow(tempX, 2));
            pntCs.add(new Point2D.Double(tempX, tempY));

        }

         assignPolarPoints(pntCs);
         setColor(CommandCenter.getInstance().getHeartColor());
         orientShape();
    }

    public void draw(Graphics g) {
        super.draw(g);

        // draw
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }


}
