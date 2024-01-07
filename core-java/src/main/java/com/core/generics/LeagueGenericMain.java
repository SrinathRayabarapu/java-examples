package com.core.generics;

/**
 * class to demo generic way of adding game type to a league and teams.
 *
 * @author Srinath.Rayabarapu
 */
public class LeagueGenericMain {
	
	public static void main(String[] args) {
		League<Cricket> crickLeague = new League<>("Cricket");
		Cricket india = new Cricket("india");
		Cricket srilanka = new Cricket("srilanka");
		crickLeague.add(india);
		crickLeague.add(srilanka);
		
		crickLeague.print();
		
		League<FootBall> footLeague = new League<>("FootBall");
		FootBall chelsea = new FootBall("chelsea");
		//crickLeague.add(chelsea); compilation failure
		footLeague.add(chelsea);
		footLeague.print();
	}

}