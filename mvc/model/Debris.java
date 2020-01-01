package _08final.mvc.model;

import _08final.mvc.model.Movable;

import java.awt.*;
import java.util.Arrays;

import _08final.mvc.controller.Game;
import _08final.mvc.model.Asteroid;


public class Debris extends _08final.mvc.model.Sprite
{
    private int nSpin;

    //radius of Debris
    private final int RAD = 10;

    //nSize determines if the Asteroid is Large (0), Medium (1), or Small (2)
    //when you explode a Large asteroid, you should spawn 2 or 3 medium asteroids
    //same for medium asteroid, you should spawn small asteroids
    //small asteroids get blasted into debris
    public Debris(Asteroid astExploded){


        //call Sprite constructor
        super();
        setTeam(Team.DEBRIS);
        int  nSizeNew =	astExploded.getSize() + 1;

        //the spin will be either plus or minus 0-9
        int nSpin = Game.R.nextInt(10);
        if(nSpin %2 ==0)
            nSpin = -nSpin;
        setSpin(nSpin);

        //random delta-x
        int nDX = Game.R.nextInt(10 + nSizeNew*2);
        if(nDX %2 ==0)
            nDX = -nDX;
        setDeltaX(nDX);

        //random delta-y
        int nDY = Game.R.nextInt(10+ nSizeNew*2);
        if(nDY %2 ==0)
            nDY = -nDY;
        setDeltaY(nDY);

        assignRandomShape();

        //an nSize of zero is a big Bug
        //a nSize of 1 or 2 is med or small Bug respectively

        setRadius(RAD/(nSizeNew * 2));
        setCenter(astExploded.getCenter());
        setColor(Color.pink);
        setExpire(15);


    }


    @Override
    public void move(){
        super.move();

        //a Bug spins, so you need to adjust the orientation at each move()
        setOrientation(getOrientation() + getSpin());

        if (getExpire() == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        }

        else
            setExpire(getExpire() - 1);

    }



    public int getSpin() {
        return this.nSpin;
    }


    public void setSpin(int nSpin) {
        this.nSpin = nSpin;
    }

    //this is for an asteroid only
    public void assignRandomShape ()
    {
        int nSide = Game.R.nextInt( 7 ) + 7;
        int nSidesTemp = nSide;

        int[] nSides = new int[nSide];
        for ( int nC = 0; nC < nSides.length; nC++ )
        {
            int n = nC * 48 / nSides.length - 4 + Game.R.nextInt( 8 );
            if ( n >= 48 || n < 0 )
            {
                n = 0;
                nSidesTemp--;
            }
            nSides[nC] = n;
        }

        Arrays.sort( nSides );

        double[]  dDegrees = new double[nSidesTemp];
        for ( int nC = 0; nC <dDegrees.length; nC++ )
        {
            dDegrees[nC] = nSides[nC] * Math.PI / 24 + Math.PI / 2;
        }
        setDegrees( dDegrees);

        double[] dLengths = new double[dDegrees.length];
        for (int nC = 0; nC < dDegrees.length; nC++) {
            if(nC %3 == 0)
                dLengths[nC] = 1 - Game.R.nextInt(40)/100.0;
            else
                dLengths[nC] = 1;
        }
        setLengths(dLengths);

    }

}

