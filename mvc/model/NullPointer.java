package _08final.mvc.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class NullPointer extends Sprite {

    // SPEED
    private final double FIRE_POWER = 50.0;



    public NullPointer(Falcon fal){

        super();
        setTeam(Team.FRIEND);

        //defined the points on a cartesean grid
        ArrayList<Point2D> pntCs = new ArrayList<Point2D>();

        pntCs.add(new Point2D.Double(112,380));
        pntCs.add(new Point2D.Double(114,7));
        pntCs.add(new Point2D.Double(44,79));
        pntCs.add(new Point2D.Double(115,7));
        pntCs.add(new Point2D.Double(181,81));
        pntCs.add(new Point2D.Double(115,7));
        pntCs.add(new Point2D.Double(112,380));




        assignPolarPoints(pntCs);

        //a bullet expires after 20 frames
        setExpire( 20 );

        // SIZE
        setRadius(50);

        if(CommandCenter.getInstance().getPlanet().equals("YouTube"))
        {
            setColor(Color.BLACK);
        }


        //everything is relative to the falcon ship that fired the bullet
        setDeltaX( fal.getDeltaX() +
                Math.cos( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
        setDeltaY( fal.getDeltaY() +
                Math.sin( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
        setCenter( fal.getCenter() );

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(fal.getOrientation()+180);


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

}
