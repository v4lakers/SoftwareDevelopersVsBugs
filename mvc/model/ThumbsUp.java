package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ThumbsUp extends NewShipFloater {



    public final static int EXPIRE = 80;
    public final static int RAD = 100;

    public ThumbsUp() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        // XY Coordinates
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        // Draw the Thumbs Up
        pntCs.add(new Point2D.Double(10,148));
        pntCs.add(new Point2D.Double(10,148));
        pntCs.add(new Point2D.Double(19,145));
        pntCs.add(new Point2D.Double(19,145));
        pntCs.add(new Point2D.Double(23,138));
        pntCs.add(new Point2D.Double(31,135));
        pntCs.add(new Point2D.Double(39,126));
        pntCs.add(new Point2D.Double(44,117));
        pntCs.add(new Point2D.Double(44,108));
        pntCs.add(new Point2D.Double(49,97));
        pntCs.add(new Point2D.Double(49,91));
        pntCs.add(new Point2D.Double(56,76));
        pntCs.add(new Point2D.Double(65,69));
        pntCs.add(new Point2D.Double(78,67));
        pntCs.add(new Point2D.Double(87,60));
        pntCs.add(new Point2D.Double(94,54));
        pntCs.add(new Point2D.Double(96,46));
        pntCs.add(new Point2D.Double(107,38));
        pntCs.add(new Point2D.Double(105,30));
        pntCs.add(new Point2D.Double(105,20));
        pntCs.add(new Point2D.Double(107,11));
        pntCs.add(new Point2D.Double(116,4));
        pntCs.add(new Point2D.Double(125,4));
        pntCs.add(new Point2D.Double(130,6));
        pntCs.add(new Point2D.Double(136,12));
        pntCs.add(new Point2D.Double(139,19));
        pntCs.add(new Point2D.Double(142,31));
        pntCs.add(new Point2D.Double(139,43));
        pntCs.add(new Point2D.Double(134,55));
        pntCs.add(new Point2D.Double(109,92));
        pntCs.add(new Point2D.Double(118,98));
        pntCs.add(new Point2D.Double(131,97));
        pntCs.add(new Point2D.Double(140,97));
        pntCs.add(new Point2D.Double(152,98));
        pntCs.add(new Point2D.Double(163,98));
        pntCs.add(new Point2D.Double(175,104));
        pntCs.add(new Point2D.Double(185,107));
        pntCs.add(new Point2D.Double(188,113));
        pntCs.add(new Point2D.Double(195,118));
        pntCs.add(new Point2D.Double(196,129));
        pntCs.add(new Point2D.Double(190,133));
        pntCs.add(new Point2D.Double(186,136));
        pntCs.add(new Point2D.Double(178,136));
        pntCs.add(new Point2D.Double(184,142));
        pntCs.add(new Point2D.Double(189,148));
        pntCs.add(new Point2D.Double(192,152));
        pntCs.add(new Point2D.Double(193,158));
        pntCs.add(new Point2D.Double(193,161));
        pntCs.add(new Point2D.Double(191,165));
        pntCs.add(new Point2D.Double(186,170));
        pntCs.add(new Point2D.Double(180,171));
        pntCs.add(new Point2D.Double(183,176));
        pntCs.add(new Point2D.Double(188,180));
        pntCs.add(new Point2D.Double(192,187));
        pntCs.add(new Point2D.Double(189,193));
        pntCs.add(new Point2D.Double(180,197));
        pntCs.add(new Point2D.Double(173,201));
        pntCs.add(new Point2D.Double(169,204));
        pntCs.add(new Point2D.Double(180,205));
        pntCs.add(new Point2D.Double(184,211));
        pntCs.add(new Point2D.Double(184,217));
        pntCs.add(new Point2D.Double(182,227));
        pntCs.add(new Point2D.Double(173,234));
        pntCs.add(new Point2D.Double(149,243));
        pntCs.add(new Point2D.Double(140,246));
        pntCs.add(new Point2D.Double(127,248));
        pntCs.add(new Point2D.Double(114,247));
        pntCs.add(new Point2D.Double(104,246));
        pntCs.add(new Point2D.Double(91,246));
        pntCs.add(new Point2D.Double(76,242));
        pntCs.add(new Point2D.Double(58,239));
        pntCs.add(new Point2D.Double(44,237));
        pntCs.add(new Point2D.Double(39,237));
        pntCs.add(new Point2D.Double(28,242));
        pntCs.add(new Point2D.Double(19,244));
        pntCs.add(new Point2D.Double(16,242));
        pntCs.add(new Point2D.Double(16,234));
        pntCs.add(new Point2D.Double(15,229));
        pntCs.add(new Point2D.Double(15,221));
        pntCs.add(new Point2D.Double(12,209));
        pntCs.add(new Point2D.Double(5,152));



        assignPolarPoints(pntCs);
        setColor(CommandCenter.getInstance().getHeartColor());
        orientShape();
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

    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }




}
