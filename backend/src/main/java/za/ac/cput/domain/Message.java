package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private String messageId;
    private String content;
    private LocalDateTime timestamp;
    private Boolean readStatus;

    public Message(Builder builder) {
        this.messageId = builder.messageId;
        this.content = builder.content;
        this.timestamp = builder.timestamp;
        this.readStatus = builder.readStatus;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Boolean getReadStatus() {
        return readStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) && Objects.equals(content, message.content) && Objects.equals(timestamp, message.timestamp) && Objects.equals(readStatus, message.readStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, content, timestamp, readStatus);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", readStatus=" + readStatus +
                '}';
    }

    public static class Builder{
        private String messageId;
        private String content;
        private LocalDateTime timestamp;
        private Boolean readStatus;

        public Builder setMessageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setReadStatus(Boolean readStatus) {
            this.readStatus = readStatus;
            return this;
        }

        public Builder copy(Message message){
            this.messageId = message.messageId;
            this.content = message.content;
            this.timestamp = message.timestamp;
            this.readStatus = message.readStatus;
            return this;
        }

        public Message build(){
            return new Message(this);
        }
    }
}
