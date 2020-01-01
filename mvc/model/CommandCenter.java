package _08final.mvc.model;

import _08final.sounds.Sound;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CommandCenter {

	private  int nNumFalcon;
	private  int nLevel;
	private  long lScore;
	private  Falcon falShip;
	private  boolean bPlaying;
	private  boolean bPaused;

	// How many Nukes you start with
	private int nukes = 2;


	// Track How Many Bugs have been destroyed
	private double dAst;

	// Checks to see if user is eligible for a power up
	private int thresh = 1000;
	private long temp;


	// Initial Bug Color, Power Up Color, and Plaent
	private Color astColor = Color.decode("#b4b4b4");
	private Color heartColor = Color.RED;
	private String planet = "";
	
	// These ArrayLists with capacities set
	private List<Movable> movDebris = new ArrayList<Movable>(700000);
	private List<Movable> movFriends = new ArrayList<Movable>(700000);
	private List<Movable> movFoes = new ArrayList<Movable>(700000);
	private List<Movable> movFloaters = new ArrayList<Movable>(500);

	private GameOpsList opsList = new GameOpsList();


	private static CommandCenter instance = null;

	// Constructor made private - static Utility class only
	private CommandCenter() {}


	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}


	public  void initGame(){
		setLevel(1);
		setScore(0);
		setNumFalcons(3);
		spawnFalcon(true);
	}
	
	// The parameter is true if this is for the beginning of the game, otherwise false
	// When you spawn a new falcon, you need to decrement its number
	public  void spawnFalcon(boolean bFirst) {
		if (getNumFalcons() != 0) {
			falShip = new Falcon();

			opsList.enqueue(falShip, CollisionOp.Operation.ADD);
			if (!bFirst)
			    setNumFalcons(getNumFalcons() - 1);
		}
		
		Sound.playSound("shipspawn.wav");

	}

	public GameOpsList getOpsList() {
		return opsList;
	}

	public void clearFoe()
	{
		movFoes.clear();
	}

	public void setOpsList(GameOpsList opsList) {
		this.opsList = opsList;
	}

	public  void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFloaters.clear();
	}

	public  boolean isPlaying() {
		return bPlaying;
	}


	public  void setPlaying(boolean bPlaying) {
		this.bPlaying = bPlaying;
	}

	public  boolean isPaused() {
		return bPaused;
	}

	public  void setPaused(boolean bPaused) {
		this.bPaused = bPaused;
	}
	
	public  boolean isGameOver() {		//if the number of falcons is zero, then game over
		if (getNumFalcons() == 0) {
			return true;
		}
		return false;
	}


	// Getter and Setter
	public Color getHeartColor() {
		return heartColor;
	}
	public void setHearColor(String s)
	{
		heartColor = Color.decode(s);
	}


	// Getters and Setters for which Planet/Universe we are in
	public void setPlanet(String s)
	{
		planet = s;
	}
	public String getPlanet()
	{
		return planet;
	}

	// Getter and Setter for Bug Color
	public Color getAstColor() {
		return astColor;
	}
	public void setAstColor(String s)
	{
		astColor = Color.decode(s);
	}

	// Getter and Setter For amount of asteroids destroyed
	public void addAst(double i)
	{
		dAst = dAst + i;
	}
	public double getdAst()
	{
		return dAst;
	}


	// Getter and Setters for Nuke Count
	public void addNuke()
	{
		nukes+=1;
	}
	public void subtractNuke()
	{
		nukes = nukes - 1;
	}
	public int getNuke()
	{
		return nukes;
	}


	public  int getLevel() {
		return nLevel;
	}

	public   long getScore() {
		return lScore;
	}

	public  void setScore(long lParam) {
		lScore = lParam;
	}

	// Add to the score when bug is destroyed
	public  void addScore(long lParam) {
		lScore = lScore + lParam;
		temp = temp + lParam;

		// Add Nuke if the score reaches a certain level
		if (temp>= thresh)
		{
			for(int i = 0; i < (temp/thresh); i++)
			{
				CommandCenter.getInstance().addNuke();
			}

			CommandCenter.getInstance().resetTemp();

		}
	}


	// Getter and Setters for the temp variable
	public void resetTemp()
	{
		temp = 0;
	}
	public long getTemp()
	{
		return temp;
	}

	public  void setLevel(int n) {
		nLevel = n;
	}

	// Getters and Setters for the amount of falcons
	public  int getNumFalcons() {
		return nNumFalcon;
	}
	public  void setNumFalcons(int nParam) {
		nNumFalcon = nParam;
	}
	
	public  Falcon getFalcon(){
		return falShip;
	}
	
	public  void setFalcon(Falcon falParam){
		falShip = falParam;
	}

	public  List<Movable> getMovDebris() {
		return movDebris;
	}



	public  List<Movable> getMovFriends() {
		return movFriends;
	}



	public  List<Movable> getMovFoes() {
		return movFoes;
	}



	public  List<Movable> getMovFloaters() {
		return movFloaters;
	}








}
