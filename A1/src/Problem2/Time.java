package Problem2;

public class Time {
    private Integer hour;
    private Integer min;
    private Integer sec;

    public Time(Integer hour, Integer min, Integer sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public Integer getHour() {
        return this.hour;
    }

    public Integer getMin() {
        return this.min;
    }

    public Integer getSec() {
        return this.sec;
    }

    public Integer getTotalSec() {
        return sec + this.min*60 + this.hour*3600;
    }
}
