package mc.alk.arena.objects;

import java.util.ArrayList;
import java.util.List;

import mc.alk.arena.objects.victoryconditions.VictoryType;


public class MatchParams extends ArenaParams implements Comparable<MatchParams>{

	List<String> matchWillBeginMsgs = null;
	List<String> startMsgs = null;
	String prefix;
	String prettyName;
	VictoryType vc = null;
	Integer matchTime, intervalTime;
	public int hashCode() { 
		return ((arenaType.ordinal()) << 27) +(rating.ordinal() << 25) + (minTeams<<12)+(vc.ordinal() << 8) + minTeamSize;
	}

	public MatchParams(ArenaType at, Rating rating, VictoryType vc) {
		super(at,rating);
		this.vc = vc;
	}

	public MatchParams(MatchParams q) {
		super(q);
		this.matchWillBeginMsgs = q.matchWillBeginMsgs;
		this.startMsgs = q.startMsgs;
		this.name = q.name;
		this.prefix = q.prefix;
		this.prettyName = q.prettyName;
		this.vc = q.vc;
		this.matchTime = q.matchTime;
		this.intervalTime = q.intervalTime;
	}

	public int getMinTeams(){return minTeams;}
	public int getMinTeamSize(){ return minTeamSize;}
	public VictoryType getVictoryType() {return vc;}

	public int getSize() {return minTeamSize;}
	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String str){prefix = str;}
	public void setCommand(String str){cmd = str;}
	public void setPrettyName(String str){prettyName = str;}
	public void addStartMessage(String str){
		if (startMsgs==null)
			startMsgs = new ArrayList<String>();
		startMsgs.add(str);
	}

	public String getStartMsgs(){return convertToString(startMsgs);}
	public String getSendMatchWillBeginMessage() {return convertToString(matchWillBeginMsgs);}

	public static String convertToString(List<String> strs){
		if (strs == null)
			return null;
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (String s : strs){
			if (!first) sb.append("\n");
			sb.append(s+"\n");
			first = false;
		}
		return sb.toString();
	}

	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof MatchParams)) return false;
		return this.hashCode() == ((MatchParams) other).hashCode();
	}


	public int compareTo(MatchParams other) {
		Integer hash = this.hashCode();
//		System.out.println("compareTo()="+(hash.compareTo(other.hashCode()))+"   " + this.toString() +"  and " + other);
		return hash.compareTo(other.hashCode());
	}

	public String getName() {
		return name;
	}

	public void setVictoryCondition(VictoryType victoryCondition) {
		this.vc = victoryCondition;
	}
	public String toString(){
		return super.toString()+",vc=" + vc.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Integer matchTime) {
		this.matchTime = matchTime;
	}

	public Integer getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}

}
