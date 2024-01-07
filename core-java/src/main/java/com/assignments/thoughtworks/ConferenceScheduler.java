package com.assignments.thoughtworks;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * class to schedule passed talks
 *
 */
public class ConferenceScheduler {

	/**
	 * public method to create and schedule conference.
	 * 
	 * @param talkList
	 * @throws Exception
	 */
	public List<List<Talk>> scheduleConference(List<String> talkList) throws Exception {
		
		List<Talk> talksList = validateAllTalksAndReturnValidTalksList(talkList);
		
		return getScheduleConferenceTrack(talksList);
	}

	/**
	 * validate talks list and parse necessary parts of the talk string and returns list
	 * 
	 * @param allTalksList
	 * @return
	 * @throws TalkException
	 */
	private List<Talk> validateAllTalksAndReturnValidTalksList(List<String> allTalksList) throws TalkException {
		
		if (Objects.isNull(allTalksList))
			throw new TalkException("Empty Talk List is supplied");

		List<Talk> validTalksList = new ArrayList<>();
		
		String minutesSuffix = "min";
		String lightningSuffix = "lightning";

		for (String talk : allTalksList) {
			
			int lastSpaceIndex = talk.lastIndexOf(" ");
			
			if (lastSpaceIndex == -1)
				throw new TalkException("Invalid talk name, " + talk + ". Talk time should be present");

			String name = talk.substring(0, lastSpaceIndex);
			String timeStr = talk.substring(lastSpaceIndex + 1);

			if (Objects.isNull(name) || name.isEmpty())
				throw new TalkException("Invalid talk name, " + talk);

			else if (!timeStr.endsWith(minutesSuffix) && !timeStr.endsWith(lightningSuffix))
				throw new TalkException("Invalid talk time, " + talk + ". Time must be in min or in lightning");

			int timeInMinutes = 0;

			try {
				if (timeStr.endsWith(minutesSuffix)) {
					timeInMinutes = Integer.parseInt(timeStr.substring(0, timeStr.indexOf(minutesSuffix)));
				} else if (timeStr.endsWith(lightningSuffix)) {
					String lightningTime = timeStr.substring(0, timeStr.indexOf(lightningSuffix));
					if ("".equals(lightningTime))
						timeInMinutes = 5;
					else
						timeInMinutes = Integer.parseInt(lightningTime) * 5;
				}
			} catch (NumberFormatException nfe) {
				throw new TalkException("Unbale to parse time " + timeStr + " for talk " + talk);
			}

			validTalksList.add(new Talk(talk, name, timeInMinutes));
		}

		return validTalksList;
	}

	/**
	 * Schedule Conference tracks for morning and evening session.
	 * 
	 * @param talksList
	 * @throws Exception
	 */
	private List<List<Talk>> getScheduleConferenceTrack(List<Talk> talksList) throws Exception {
		
		// per day 6 hours 
		int perDayTimeInMinutes = 6 * 60;
		
		int totalTalksTime = getTotalTalksTime(talksList);
		
		//find the number of days
		int totalDays = totalTalksTime / perDayTimeInMinutes;
		
		Collections.sort(talksList);
		
		//find all morning combinations
		List<List<Talk>> morningSessionsList = findSessionCombinations(talksList, totalDays, true);

		//remove all morning combinations from all talks list
		for (List<Talk> talkList : morningSessionsList) {
			talksList.removeAll(talkList);
		}
		
		//find all evening combinations
		List<List<Talk>> eveningSessionsList = findSessionCombinations(talksList, totalDays, false);

		for (List<Talk> talkList : eveningSessionsList) {
			talksList.removeAll(talkList);
		}

		int maxSessionTimeLimit = 240;
		
		//if any talks are remaining, try to accommodate them in the evening session time limit
		if (!talksList.isEmpty()) {
			
			List<Talk> scheduledTalkList = new ArrayList<>();
			
			for (List<Talk> talkList : eveningSessionsList) {
				
				int totalTime = getTotalTalksTime(talkList);

				for (Talk talk : talksList) {
					int talkTime = talk.getTimeDuration();

					if (talkTime + totalTime <= maxSessionTimeLimit) {
						talkList.add(talk);
						talk.setScheduled(true);
						scheduledTalkList.add(talk);
					}
				}

				talksList.removeAll(scheduledTalkList);
				
				if (talksList.isEmpty())
					break;
			}
		}

		// If list is still not empty, its mean the conference can not be
		// scheduled with the provided data.
		if (!talksList.isEmpty()) {
			throw new Exception("Unable to schedule all task for conferencing.");
		}

		// Schedule the day event from morning session and evening session.
		return getScheduledTalksList(morningSessionsList, eveningSessionsList);
	}

	private List<List<Talk>> findSessionCombinations(List<Talk> talksList, int totalPossibleDays, boolean isMorning) {
		
		int minSessionTimeLimit = 180;
		int maxSessionTimeLimit = 240;

		if (isMorning)
			maxSessionTimeLimit = minSessionTimeLimit;

		int talkListSize = talksList.size();
		List<List<Talk>> sessionCombinationsList = new ArrayList<>();
		int combinationsCount = 0;
		
		for (int count = 0; count < talkListSize; count++) {
			
			int startPoint = count;
			int totalTime = 0;
			
			List<Talk> combinationsList = new ArrayList<>();

			while(startPoint != talkListSize) {
				
				int currentCount = startPoint;
				startPoint++;
				
				Talk currentTalk = talksList.get(currentCount);
				
				//not already considered
				if (currentTalk.isScheduled())
					continue;
				
				int talkTime = currentTalk.getTimeDuration();
				
				//talk is not fitting in the time limit
				if (talkTime > maxSessionTimeLimit || talkTime + totalTime > maxSessionTimeLimit) {
					continue;
				}

				combinationsList.add(currentTalk);
				totalTime += talkTime;

				// If total time is completed for this session than break this loop.
				if (isMorning) {
					if (totalTime == maxSessionTimeLimit)
						break;
				}
				else if (totalTime >= minSessionTimeLimit)
					break;
			}

			//check whether the session is valid or not
			boolean validSession = false;
			if (isMorning)
				validSession = (totalTime == maxSessionTimeLimit);
			else
				validSession = (totalTime >= minSessionTimeLimit && totalTime <= maxSessionTimeLimit);

			//if valid, set all talks are scheduled
			if (validSession) {
				sessionCombinationsList.add(combinationsList);				
				for (Talk talk : combinationsList) {
					talk.setScheduled(true);
				}
				combinationsCount++;
				if (combinationsCount == totalPossibleDays)
					break;
			}
			
		} //talks for loop ends here

		return sessionCombinationsList;
	}

	/**
	 * Print the scheduled talks with the expected text msg.
	 * 
	 * @param combForMornSessions
	 * @param combForEveSessions
	 */
	private List<List<Talk>> getScheduledTalksList(List<List<Talk>> combForMornSessions, List<List<Talk>> combForEveSessions) {
		
		List<List<Talk>> scheduledTalksList = new ArrayList<>();
		
		int totalPossibleDays = combForMornSessions.size();

		for (int dayCount = 0; dayCount < totalPossibleDays; dayCount++) {
			List<Talk> talkList = new ArrayList<>();

			// Create a date and initialize start time 09:00 AM.
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma ");
			date.setHours(9);
			date.setMinutes(0);
			date.setSeconds(0);

			int trackCount = dayCount + 1;
			String scheduledTime = dateFormat.format(date);

			System.out.println("Track " + trackCount + ":");

			List<Talk> mornSessionTalkList = combForMornSessions.get(dayCount);
			
			for (Talk talk : mornSessionTalkList) {
				talk.setScheduledTime(scheduledTime);
				System.out.println(scheduledTime + talk.getTitle());
				// get the next talk time
				scheduledTime = getNextScheduledTime(date, talk.getTimeDuration());
				talkList.add(talk);
			}

			// Scheduled Lunch Time for 60 mins.
			int lunchTimeDuration = 60;
			Talk lunchTalk = new Talk("Lunch", "Lunch", 60);
			lunchTalk.setScheduledTime(scheduledTime);
			talkList.add(lunchTalk);
			System.out.println(scheduledTime + "Lunch");

			// Evening Session - set the scheduled time in the talk and get the next time
			// using time duration of current talk.
			scheduledTime = getNextScheduledTime(date, lunchTimeDuration);
			
			List<Talk> eveSessionTalkList = combForEveSessions.get(dayCount);
			
			for (Talk talk : eveSessionTalkList) {
				talk.setScheduledTime(scheduledTime);
				talkList.add(talk);
				System.out.println(scheduledTime + talk.getTitle());
				scheduledTime = getNextScheduledTime(date, talk.getTimeDuration());
			}

			// Scheduled Networking Event at the end of session, Time duration is just to
			// initialize the Talk object.
			Talk networkingTalk = new Talk("Networking Event", "Networking Event", 60);
			networkingTalk.setScheduledTime(scheduledTime);
			talkList.add(networkingTalk);
			System.out.println(scheduledTime + "Networking Event\n");
			scheduledTalksList.add(talkList);
		}

		return scheduledTalksList;
	}

	private int getTotalTalksTime(List<Talk> talksList) {
		
		if (Objects.isNull(talksList) || talksList.isEmpty())
			return 0;

		int totalTime = 0;
		for (Talk talk : talksList) {
			totalTime += talk.getTimeDuration();
		}
		
		return totalTime;
	}

	private String getNextScheduledTime(Date date, int timeDuration) {
		long timeInLong = date.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma ");

		long timeDurationInLong = timeDuration * 60 * 1000;
		long newTimeInLong = timeInLong + timeDurationInLong;

		date.setTime(newTimeInLong);
		String str = dateFormat.format(date);
		return str;
	}

}