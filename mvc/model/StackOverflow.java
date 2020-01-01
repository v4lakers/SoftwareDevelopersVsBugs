package _08final.mvc.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class StackOverflow extends Sprite {

    // SPEED
    private final double FIRE_POWER = 5;



    public StackOverflow(Falcon fal, int shift){

        super();
        setTeam(Team.FRIEND);

        //defined the points on a cartesean grid
        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        pntCs.add(new Point2D.Double(173,92));
        pntCs.add(new Point2D.Double(136,42));
        pntCs.add(new Point2D.Double(127,48));
        pntCs.add(new Point2D.Double(164,97));
        pntCs.add(new Point2D.Double(159,104));
        pntCs.add(new Point2D.Double(113,63));
        pntCs.add(new Point2D.Double(105,70));
        pntCs.add(new Point2D.Double(153,110));
        pntCs.add(new Point2D.Double(149,116));
        pntCs.add(new Point2D.Double(94,89));
        pntCs.add(new Point2D.Double(89,99));
        pntCs.add(new Point2D.Double(144,125));
        pntCs.add(new Point2D.Double(143,133));
        pntCs.add(new Point2D.Double(83,118));
        pntCs.add(new Point2D.Double(81,127));
        pntCs.add(new Point2D.Double(141,141));
        pntCs.add(new Point2D.Double(141,148));
        pntCs.add(new Point2D.Double(79,148));
        pntCs.add(new Point2D.Double(79,156));
        pntCs.add(new Point2D.Double(142,158));
        pntCs.add(new Point2D.Double(155,135));
        pntCs.add(new Point2D.Double(156,171));
        pntCs.add(new Point2D.Double(65,172));
        pntCs.add(new Point2D.Double(64,136));
        pntCs.add(new Point2D.Double(52,135));
        pntCs.add(new Point2D.Double(54,184));
        pntCs.add(new Point2D.Double(166,184));
        pntCs.add(new Point2D.Double(167,133));
        pntCs.add(new Point2D.Double(158,135));
        pntCs.add(new Point2D.Double(147,131));
        pntCs.add(new Point2D.Double(147,128));
        pntCs.add(new Point2D.Double(148,124));
        pntCs.add(new Point2D.Double(149,119));
        pntCs.add(new Point2D.Double(152,116));
        pntCs.add(new Point2D.Double(155,113));
        pntCs.add(new Point2D.Double(158,109));
        pntCs.add(new Point2D.Double(161,103));
        pntCs.add(new Point2D.Double(167,99));
        pntCs.add(new Point2D.Double(172,95));


        assignPolarPoints(pntCs);

        //a nuke expires after 60 frames
        setExpire(60);

        // Make this bad boi thicc
        setRadius(200);


        //everything is relative to the falcon ship that fired the bullet
        setDeltaX( fal.getDeltaX() +
                Math.cos( Math.toRadians( fal.getOrientation()+shift ) ) * FIRE_POWER );
        setDeltaY( fal.getDeltaY() +
                Math.sin( Math.toRadians( fal.getOrientation()+shift ) ) * FIRE_POWER );
        setCenter( fal.getCenter() );

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(fal.getOrientation()+shift);

        setColor(Color.decode("#ef8236"));




    }

    @Override
    public void move(){

        super.move();

        if (getExpire() == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        }

        else
            setExpire(getExpire() - 1);

    }

    // Draw
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.ORANGE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

}

