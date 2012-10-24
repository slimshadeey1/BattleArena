package mc.alk.arena.objects.events;

import java.lang.reflect.Method;

import mc.alk.arena.objects.MatchState;

import org.bukkit.event.Event;

public class MatchEventMethod implements Comparable<MatchEventMethod>{
	final Method callMethod;
	final Class<? extends Event> bukkitEvent;
	final Method getPlayerMethod;
	final MatchState beginState, endState, cancelState;
	final EventPriority priority;
	public MatchEventMethod(Method callMethod, Class<? extends Event> event,
			MatchState begin, MatchState end, MatchState cancel, EventPriority priority) {
		this.callMethod = callMethod;
		this.bukkitEvent = event;
		this.getPlayerMethod = null;
		this.beginState = begin;
		this.endState = end;
		this.cancelState = cancel;
		this.priority = priority;
	}
	public MatchEventMethod(Method callMethod, Class<? extends Event> event,
			Method getPlayerMethod, MatchState begin, MatchState end, MatchState cancel, EventPriority priority) {
		this.callMethod = callMethod;
		this.bukkitEvent = event;
		this.getPlayerMethod = getPlayerMethod;
		this.beginState = begin;
		this.endState = end;
		this.cancelState = cancel;
		this.priority = priority;
	}
	public Method getMethod(){
		return callMethod;
	}
	public Method getPlayerMethod(){
		return getPlayerMethod;
	}
	public Class<? extends Event> getBukkitEvent(){
		return bukkitEvent;
	}
	public MatchState getBeginState() {
		return beginState;
	}
	public MatchState getEndState() {
		return endState;
	}
	public MatchState getCancelState() {
		return cancelState;
	}
	@Override
	public String toString(){
		return "[MEM "+callMethod.getName()+", " + bukkitEvent.getSimpleName()+ " "  + beginState+":"+endState+
				"   playerMethod=" + getPlayerMethod.getName()+"]";
	}

	@Override
	public int compareTo(MatchEventMethod arg0) {
		return this.priority.compareTo(arg0.priority);
	}
}
