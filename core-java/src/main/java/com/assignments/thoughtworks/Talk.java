package com.assignments.thoughtworks;

/**
 * POJO to hold Talk information. Talk should be comparable on duration.
 */
public class Talk implements Comparable<Talk> {
	
	private String title;
	private String name;
	private int timeDuration;
	private boolean scheduled = false;
	private String scheduledTime;

	public Talk(String title, String name, int time) {
		this.title = title;
		this.name = name;
		this.timeDuration = time;
	}

	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}

	public boolean isScheduled() {
		return this.scheduled;
	}

	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public String getScheduledTime() {
		return this.scheduledTime;
	}

	public int getTimeDuration() {
		return this.timeDuration;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public int compareTo(Talk talk) {
		if (this.timeDuration > talk.timeDuration)
			return -1;
		else if (this.timeDuration < talk.timeDuration)
			return 1;
		else
			return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Talk [title=");
		builder.append(this.title);
		builder.append(", name=");
		builder.append(this.name);
		builder.append(", timeDuration=");
		builder.append(this.timeDuration);
		builder.append(", scheduled=");
		builder.append(this.scheduled);
		builder.append(", scheduledTime=");
		builder.append(this.scheduledTime);
		builder.append("]");
		return builder.toString();
	}
	
}
