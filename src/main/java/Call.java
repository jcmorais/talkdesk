import java.time.LocalTime;

public class Call {
    private String from;
    private String to;
    private LocalTime start;
    private LocalTime end;


    public Call(String from, String to, LocalTime start, LocalTime end) {
        this.from = from;
        this.to = to;
        this.start = start;
        this.end = end;
    }

    public long getSecondsStart(){
        return start.getSecond() + start.getMinute()*60 +start.getHour()*60*60;
    }

    public long getSecondsEnd(){
        return end.getSecond() + end.getMinute()*60 +end.getHour()*60*60;
    }

    public long getCallTimeInSeconds(){
        return  getSecondsEnd()-getSecondsStart();
    }


    public long getCallTimeInMinutes(){
        long sec = getCallTimeInSeconds();
        long res = sec / 60;

        if ((sec%60) > 0)
            res++;

        return res;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Call{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
