package Domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Interview {
    private String interviewID;
    private LocalDateTime scheduledDate;
    private int duration;
    private InterviewType type;
    private String location;
    private String meetingLink;
    private String notes;
    private InterviewStatus status;

    public Interview(Builder builder) {
        this.interviewID = builder.interviewID;
        this.scheduledDate = builder.scheduledDate;
        this.duration = builder.duration;
        this.type = builder.type;
        this.location = builder.location;
        this.meetingLink = builder.meetingLink;
        this.notes = builder.notes;
        this.status = builder.status;
    }

    public String getInterviewID() {
        return interviewID;
    }

    public LocalDateTime getScheduledDate() {
        return scheduledDate;
    }

    public int getDuration() {
        return duration;
    }

    public InterviewType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public String getNotes() {
        return notes;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return duration == interview.duration && Objects.equals(interviewID, interview.interviewID) && Objects.equals(scheduledDate, interview.scheduledDate) && Objects.equals(type, interview.type) && Objects.equals(location, interview.location) && Objects.equals(meetingLink, interview.meetingLink) && Objects.equals(notes, interview.notes) && Objects.equals(status, interview.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interviewID, scheduledDate, duration, type, location, meetingLink, notes, status);
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interviewID='" + interviewID + '\'' +
                ", scheduledDate=" + scheduledDate +
                ", duration=" + duration +
                ", type=" + type +
                ", location='" + location + '\'' +
                ", meetingLink='" + meetingLink + '\'' +
                ", notes='" + notes + '\'' +
                ", status=" + status +
                '}';
    }

    public static class Builder{
        private String interviewID;
        private LocalDateTime scheduledDate;
        private int duration;
        private InterviewType type;
        private String location;
        private String meetingLink;
        private String notes;
        private InterviewStatus status;

        public Builder setInterviewID(String interviewID) {
            this.interviewID = interviewID;
            return this;
        }

        public Builder setScheduledDate(LocalDateTime scheduledDate) {
            this.scheduledDate = scheduledDate;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setType(InterviewType type) {
            this.type = type;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setMeetingLink(String meetingLink) {
            this.meetingLink = meetingLink;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder setStatus(InterviewStatus status) {
            this.status = status;
            return this;
        }

        public Builder copy(Interview interview){
            this.interviewID = interview.interviewID;
            this.scheduledDate = interview.scheduledDate;
            this.duration = interview.duration;
            this.type = interview.type;
            this.location = interview.location;
            this.meetingLink = interview.meetingLink;
            this.notes = interview.notes;
            this.status = interview.status;
            return this;
        }

        public Interview build(){
            return new Interview(this);
        }
    }
}
