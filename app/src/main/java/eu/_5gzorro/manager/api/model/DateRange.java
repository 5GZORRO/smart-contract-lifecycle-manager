package eu._5gzorro.manager.api.model;

import java.time.LocalDateTime;

public class DateRange {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public DateRange() {
    }

    public DateRange(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public DateRange startTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public DateRange endTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public String toString() {
        if (isEmpty()) return "Empty Date Range";
        return startTime.toString() + " - " + endTime.toString();
    }

    public boolean isEmpty() {
        return startTime.isAfter(endTime);
    }

    public boolean includes (LocalDateTime arg) {
        return !arg.isBefore(startTime) && !arg.isAfter(endTime);
    }

    public boolean equals (Object arg) {
        if (! (arg instanceof DateRange)) return false;
        DateRange other = (DateRange) arg;
        return startTime.equals(other.startTime) && endTime.equals(other.endTime);
    }
    public int hashCode() {
        return startTime.hashCode();
    }

    public boolean overlaps(DateRange arg) {
        return arg.includes(startTime) || arg.includes(endTime) || this.includes(arg);
    }

    public boolean includes(DateRange arg) {
        return this.includes(arg.startTime) && this.includes(arg.endTime);
    }
}
