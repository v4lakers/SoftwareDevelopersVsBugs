package _08final.mvc.view;

import _08final.mvc.controller.Game;
import _08final.mvc.model.Asteroid;
import _08final.mvc.model.CommandCenter;
import _08final.mvc.model.Falcon;
import _08final.mvc.model.Movable;

import java.awt.*;
import java.util.ArrayList;



public class GamePanel extends Panel {
	
	// ==============================================================
	// FIELDS 
	// ============================================================== 
	 
	// The following "off" vars are used for the off-screen double-bufferred image. 
	private Dimension dimOff;
	private Image imgOff;
	private Graphics grpOff;
	
	private GameFrame gmf;
	private Font fnt = new Font("SansSerif", Font.BOLD, 18);
	private Font fntBig = new Font("SansSerif", Font.BOLD + Font.ITALIC, 36);
	private FontMetrics fmt; 
	private int nFontWidth;
	private int nFontHeight;
	private String strDisplay = "";

	// Initialize the Background Color, current universe
	private Color background = Color.BLACK;
	private int current = 0;
	private String currentPlanet = "Basic (Hit 'H' to visit a cooler Universe)";
	private int uniqueUniverse = 0;
	

	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public GamePanel(Dimension dim){
	    gmf = new GameFrame();
		gmf.getContentPane().add(this);
		gmf.pack();
		initView();
		
		gmf.setSize(dim);
		gmf.setTitle("Game Base");
		gmf.setResizable(false);
		gmf.setVisible(true);
		this.setFocusable(true);
	}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	private void drawScore(Graphics g) {
		boolean go = true;
		g.setColor(Color.white);
		g.setFont(fnt);
		FontMetrics fm = g.getFontMetrics();

		//
		if (CommandCenter.getInstance().getScore() != 0) {
			if (getBackground().equals(Color.decode("#FFFFFF")) || getBackground().equals(Color.decode("#FFFC00")))
			{
				g.setColor(Color.BLACK);
			}

			if (getBackground().equals(Color.decode("#FFFFFF")) || getBackground().equals(Color.decode("#FFFC00")))
			{
				g.setColor(Color.BLACK);
			}


			// Display the Weapons, Controls, and Unique Worlds Visited
			g.drawString("WEAPONS", (Game.DIM.width / 2)+(Game.DIM.width / 6),nFontHeight);
			g.drawString("'SPACE'  :   NULL-POINTERS", (Game.DIM.width / 2)+(Game.DIM.width / 6),nFontHeight+ 10+fm.getAscent());
			g.drawString("'H'  :   TRAVEL TO NEW UNIVERSE", (Game.DIM.width / 2)+(Game.DIM.width / 6),nFontHeight+ 10+2*fm.getAscent());
			g.drawString("'F'  :   STACKOVERFLOW NUKE" , (Game.DIM.width / 2)+(Game.DIM.width / 6),nFontHeight+ 10+3*fm.getAscent());
			g.drawString("UNIVERSES VISITED  :  "+uniqueUniverse +"/6", (Game.DIM.width / 2)+(Game.DIM.width / 6),nFontHeight+ 10+4*fm.getAscent());


			// Display the Score and other game vitals
			g.drawString("SCORE :  " + CommandCenter.getInstance().getScore(), nFontWidth, nFontHeight);
			g.drawString( "BUGS DESTROYED :  " + CommandCenter.getInstance().getdAst(), nFontWidth, nFontHeight+ 10+fm.getAscent());
			g.drawString( "STACKOVERFLOW NUKES :  " + CommandCenter.getInstance().getNuke(), nFontWidth, nFontHeight+ 10+ 2*fm.getAscent());
			g.drawString( "CURRENT UNIVERSE :  "+currentPlanet, nFontWidth, nFontHeight+ 10+ 3*fm.getAscent());
			g.drawString( "LIVES :  ", nFontWidth, nFontHeight+ 10+ 4*fm.getAscent());
			g.drawString("Level  :  "+CommandCenter.getInstance().getLevel(),  nFontWidth*5, nFontHeight+ 10+ 4*fm.getAscent());


		} else {
			g.drawString("NO SCORE...YET", nFontWidth, nFontHeight);
		}
	}

	public void setBackground(String s)
	{
		background = Color.decode(s);
	}

	public Color getBackground()
	{
		return background;
	}


	public void hyper(Graphics g)
	{

		// Array of all the Universes (planets) and their respective background color, bug color, and power up color
		String [] planets = {"Google", "Snapchat", "Facebook", "Instagram", "Tinder", "YouTube"};
		String [] background = {"#4285F4", "#FFFC00", "#4267B2", "#833AB4", "#FE3C72", "#FFFFFF"};
		String [] asteroids = {"#DB4437", "#000000", "#ffffff", "#FFDC80", "#424242", "#282828"};
		String [] hearts = {"#a8ccd7", "#FFFFFF", "#898F9C", "#E1306C", "#FF655B",  "#FF0000"};


		int length = planets.length;
		if (current == length)
		{
			current = 0;
		}

		// Set new Planet variables when H is hit.
		currentPlanet = planets[current];
		setBackground(background[current]);
		CommandCenter.getInstance().setAstColor(asteroids[current]);
		CommandCenter.getInstance().setPlanet(currentPlanet);
		CommandCenter.getInstance().setHearColor(hearts[current]);

		current++;
		if(uniqueUniverse != planets.length)
		{
			uniqueUniverse++;
		}

	}

	
	@SuppressWarnings("unchecked")
	public void update(Graphics g) {
		if (grpOff == null || Game.DIM.width != dimOff.width
				|| Game.DIM.height != dimOff.height) {
			dimOff = Game.DIM;
			imgOff = createImage(Game.DIM.width, Game.DIM.height);
			grpOff = imgOff.getGraphics();
		}
		// Fill in background with black.
		grpOff.setColor(background);
		grpOff.fillRect(0, 0, Game.DIM.width, Game.DIM.height);



		drawScore(grpOff);
		
		if (!CommandCenter.getInstance().isPlaying()) {
			displayTextOnScreen();
		} else if (CommandCenter.getInstance().isPaused()) {
			strDisplay = "Game Paused";
			grpOff.drawString(strDisplay,
					(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);
		}
		
		//playing and not paused!
		else {
			
			//draw them in decreasing level of importance
			//friends will be on top layer and debris on the bottom
			iterateMovables(grpOff,
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovFriends(),
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovFoes(),
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovFloaters(),
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovDebris());


			drawNumberShipsLeft(grpOff);
			if (CommandCenter.getInstance().isGameOver()) {
				CommandCenter.getInstance().setPlaying(false);
				//bPlaying = false;
			}
		}
		//draw the double-Buffered Image to the graphics context of the panel
		g.drawImage(imgOff, 0, 0, this);
	} 


	
	//for each movable array, process it.
	private void iterateMovables(Graphics g, ArrayList<Movable>...movMovz){
		
		for (ArrayList<Movable> movMovs : movMovz) {
			for (Movable mov : movMovs) {

				mov.move();
				mov.draw(g);

			}
		}
		
	}
	

	// Draw the number of falcons left on the bottom-right of the screen. 
	private void drawNumberShipsLeft(Graphics g) {
		Falcon fal = CommandCenter.getInstance().getFalcon();
		double[] dLens = fal.getLengths();
		int nLen = fal.getDegrees().length;
		Point[] pntMs = new Point[nLen];
		int[] nXs = new int[nLen];
		int[] nYs = new int[nLen];

	
		//convert to cartesean points
		for (int nC = 0; nC < nLen; nC++) {
			pntMs[nC] = new Point((int) (10 * dLens[nC] * Math.sin(Math
					.toRadians(90) + fal.getDegrees()[nC])),
					(int) (10 * dLens[nC] * Math.cos(Math.toRadians(90)
							+ fal.getDegrees()[nC])));
		}
		
		//set the color to white
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics();

		//for each falcon left (not including the one that is playing)
		for (int nD = 1; nD < CommandCenter.getInstance().getNumFalcons(); nD++) {
			//create x and y values for the objects to the bottom right using cartesean points again
			for (int nC = 0; nC < fal.getDegrees().length; nC++) {
				nXs[nC] = pntMs[nC].x + nFontWidth+60 + (nD*20);
				nYs[nC] = pntMs[nC].y + nFontHeight+5+ 4*fm.getAscent();
			}
			g.drawPolygon(nXs, nYs, nLen);
		} 
	}
	
	private void initView() {
		Graphics g = getGraphics();			// get the graphics context for the panel
		g.setFont(fnt);						// take care of some simple font stuff
		fmt = g.getFontMetrics();
		nFontWidth = fmt.getMaxAdvance();
		nFontHeight = fmt.getHeight();
		g.setFont(fntBig);					// set font info
		hyper(g);
	}
	
	// This method draws some text to the middle of the screen before/after a game
	private void displayTextOnScreen() {

		strDisplay = "SOFTWARE DEVELOPERS VS BUGS";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);

		strDisplay = "Arrow Keys to Turn and Thrust";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 40);

		strDisplay = "'Space Bar' to Fire Null Pointer Exceptions (Bullets)";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 80);

		strDisplay = "'F' for StackOverFlow Nuke";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 120);

		strDisplay = "'H' to visit a New Universe (There are a Bunch)";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 160);

		strDisplay = "'S' to Start";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 200);
		strDisplay = "'P' to Pause";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 240);

		strDisplay = "'Q' to Quit";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 280);

	}
	
	public GameFrame getFrm() {return this.gmf;}
	public void setFrm(GameFrame frm) {this.gmf = frm;}	
}