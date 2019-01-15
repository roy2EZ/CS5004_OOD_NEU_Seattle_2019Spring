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

    public Time getDuration() {
        Time duration = new Time((startTime.getTotalSec()-endTime.getTotalSec())/3600,
                (startTime.getTotalSec()-endTime.getTotalSec())%3600/60,
                (startTime.getTotalSec()-endTime.getTotalSec())%3600%60);
        return duration;
    }



}

