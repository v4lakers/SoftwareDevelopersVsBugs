package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Ghost extends NewShipFloater {




    public Ghost() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        // Array List to Hold Points
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        // Create the Snapchat Ghost
        for (double tempX = -2; tempX < 2; tempX += .01) {
            double tempY = Math.sqrt(-1 * Math.pow(tempX, 2) + 4) + 1.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 2; tempX > 1.937; tempX -= .01) {
            double tempY = 15 * (tempX - 2) + 1.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 1.937; tempX < 2.692; tempX += .01) {
            double tempY = .4 * Math.pow(tempX - 2.1, 2) + .55;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 2.693; tempX < 2.93; tempX += .01) {
            double tempY = Math.sqrt(-Math.pow(tempX - 2.63, 2) + .088);
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 2.93; tempX > 1.949; tempX -= .01) {
            double tempY = 3 * Math.pow(tempX - 2.44, 3) + .05;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 1.949; tempX < 3.729; tempX += .01) {
            double tempY = (1 / (.12 * Math.pow(tempX, 2))) - 2.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 3.729; tempX > 2.626; tempX -= .01) {
            double tempY = .074 * Math.pow(tempX, 2) - 2.93;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 2.626; tempX > 2.534; tempX -= .01) {
            double tempY = 5 * (tempX - 2.61) - 2.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = 2.534; tempX > -2.534; tempX -= .01) {
            double tempY = -.38 * Math.cos(1.6 * tempX) - 3.11;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = -2.534; tempX > -2.626; tempX -= .01) {
            double tempY = -5 * (tempX + 2.61) - 2.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = -2.626; tempX > -3.729; tempX -= .01) {
            double tempY = .074 * Math.pow(tempX, 2) - 2.93;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = -3.729; tempX < -1.949; tempX += .01) {
            double tempY = (1 / (.12 * Math.pow(tempX, 2))) - 2.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = -1.949; tempX > -2.93; tempX -= .01) {
            double tempY = -3 * Math.pow(tempX + 2.44, 3) + .05;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }


        for (double tempX = -2.692; tempX < -1.937; tempX += .01) {
            double tempY = .4 * (Math.pow(tempX + 2.1, 2)) + .55;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }

        for (double tempX = -1.937; tempX >= -2; tempX -= .01) {
            double tempY = -15 * (tempX + 2) + 1.5;
            pntCs.add(new Point2D.Double(tempX, tempY));
        }


        assignPolarPoints(pntCs);
        setColor(CommandCenter.getInstance().getHeartColor());
        orientShape();
    }


    public void draw(Graphics g) {
        super.draw(g);

        // Draw
        g.setColor(Color.BLACK);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
        g2.setStroke(new BasicStroke(1));
    }


}
