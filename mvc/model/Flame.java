package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Flame extends NewShipFloater {


    public final static int EXPIRE = 80;
    public final static int RAD = 100;

    public Flame() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        // top of ship
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        // XY Coordinates to get a Tinder Flame
        pntCs.add(new Point2D.Double(428,61));
        pntCs.add(new Point2D.Double(439,73));
        pntCs.add(new Point2D.Double(452,86));
        pntCs.add(new Point2D.Double(466,99));
        pntCs.add(new Point2D.Double(485,111));
        pntCs.add(new Point2D.Double(493,121));
        pntCs.add(new Point2D.Double(508,141));
        pntCs.add(new Point2D.Double(520,154));
        pntCs.add(new Point2D.Double(533,169));
        pntCs.add(new Point2D.Double(541,184));
        pntCs.add(new Point2D.Double(560,200));
        pntCs.add(new Point2D.Double(573,224));
        pntCs.add(new Point2D.Double(587,241));
        pntCs.add(new Point2D.Double(600,262));
        pntCs.add(new Point2D.Double(615,287));
        pntCs.add(new Point2D.Double(625,313));
        pntCs.add(new Point2D.Double(634,335));
        pntCs.add(new Point2D.Double(647,364));
        pntCs.add(new Point2D.Double(653,396));
        pntCs.add(new Point2D.Double(666,424));
        pntCs.add(new Point2D.Double(666,465));
        pntCs.add(new Point2D.Double(667,518));
        pntCs.add(new Point2D.Double(666,546));
        pntCs.add(new Point2D.Double(659,579));
        pntCs.add(new Point2D.Double(654,600));
        pntCs.add(new Point2D.Double(643,620));
        pntCs.add(new Point2D.Double(633,638));
        pntCs.add(new Point2D.Double(626,655));
        pntCs.add(new Point2D.Double(605,674));
        pntCs.add(new Point2D.Double(601,687));
        pntCs.add(new Point2D.Double(582,695));
        pntCs.add(new Point2D.Double(566,704));
        pntCs.add(new Point2D.Double(546,710));
        pntCs.add(new Point2D.Double(531,722));
        pntCs.add(new Point2D.Double(508,731));
        pntCs.add(new Point2D.Double(483,734));
        pntCs.add(new Point2D.Double(452,740));
        pntCs.add(new Point2D.Double(427,739));
        pntCs.add(new Point2D.Double(389,739));
        pntCs.add(new Point2D.Double(371,737));
        pntCs.add(new Point2D.Double(346,734));
        pntCs.add(new Point2D.Double(310,730));
        pntCs.add(new Point2D.Double(284,723));
        pntCs.add(new Point2D.Double(262,713));
        pntCs.add(new Point2D.Double(234,699));
        pntCs.add(new Point2D.Double(205,684));
        pntCs.add(new Point2D.Double(184,664));
        pntCs.add(new Point2D.Double(169,650));
        pntCs.add(new Point2D.Double(157,632));
        pntCs.add(new Point2D.Double(149,604));
        pntCs.add(new Point2D.Double(145,586));
        pntCs.add(new Point2D.Double(139,560));
        pntCs.add(new Point2D.Double(136,544));
        pntCs.add(new Point2D.Double(137,523));
        pntCs.add(new Point2D.Double(140,506));
        pntCs.add(new Point2D.Double(145,485));
        pntCs.add(new Point2D.Double(149,452));
        pntCs.add(new Point2D.Double(160,428));
        pntCs.add(new Point2D.Double(171,402));
        pntCs.add(new Point2D.Double(184,380));
        pntCs.add(new Point2D.Double(190,354));
        pntCs.add(new Point2D.Double(208,327));
        pntCs.add(new Point2D.Double(225,306));
        pntCs.add(new Point2D.Double(234,291));
        pntCs.add(new Point2D.Double(253,271));
        pntCs.add(new Point2D.Double(260,253));
        pntCs.add(new Point2D.Double(279,251));
        pntCs.add(new Point2D.Double(287,250));
        pntCs.add(new Point2D.Double(289,257));
        pntCs.add(new Point2D.Double(293,267));
        pntCs.add(new Point2D.Double(293,276));
        pntCs.add(new Point2D.Double(296,295));
        pntCs.add(new Point2D.Double(301,306));
        pntCs.add(new Point2D.Double(305,318));
        pntCs.add(new Point2D.Double(313,326));
        pntCs.add(new Point2D.Double(318,339));
        pntCs.add(new Point2D.Double(323,346));
        pntCs.add(new Point2D.Double(335,339));
        pntCs.add(new Point2D.Double(346,321));
        pntCs.add(new Point2D.Double(363,309));
        pntCs.add(new Point2D.Double(379,280));
        pntCs.add(new Point2D.Double(398,264));
        pntCs.add(new Point2D.Double(410,247));
        pntCs.add(new Point2D.Double(417,225));
        pntCs.add(new Point2D.Double(426,204));
        pntCs.add(new Point2D.Double(431,180));
        pntCs.add(new Point2D.Double(434,158));
        pntCs.add(new Point2D.Double(436,136));
        pntCs.add(new Point2D.Double(432,112));
        pntCs.add(new Point2D.Double(424,86));
        pntCs.add(new Point2D.Double(423,72));
        pntCs.add(new Point2D.Double(426,55));


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
