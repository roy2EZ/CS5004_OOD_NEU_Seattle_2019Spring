package Problem2;

public class Bicyclist {
    private String name;
    private String team;
    private Time startTime;
    private Time endTime;

    public Bicyclist(String name, String team, Time startTime, Time endTime) {
        this.name = name;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getDuration() {
        Time duration = new Time((endTime.getTotalSec()-startTime.getTotalSec())/3600,
                (endTime.getTotalSec()-startTime.getTotalSec())%3600/60,
                (endTime.getTotalSec()-startTime.getTotalSec())%3600%60);
        return duration;
    }



}

