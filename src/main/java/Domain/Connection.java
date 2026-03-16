package Domain;

import java.util.Date;
import java.util.Objects;

public class Connection {
    private String connectionId;
    private Date connectionDate;
    private ConnectionStatus status;

    public Connection(Builder builder) {
        this.connectionId = builder.connectionId;
        this.connectionDate = builder.connectionDate;
        this.status = builder.status;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public Date getConnectionDate() {
        return connectionDate;
    }

    public ConnectionStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(connectionId, that.connectionId) && Objects.equals(connectionDate, that.connectionDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionId, connectionDate, status);
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connectionId='" + connectionId + '\'' +
                ", connectionDate=" + connectionDate +
                ", status=" + status +
                '}';
    }

    public static class Builder{
        private String connectionId;
        private Date connectionDate;
        private ConnectionStatus status;

        public Builder setConnectionId(String connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        public Builder setConnectionDate(Date connectionDate) {
            this.connectionDate = connectionDate;
            return this;
        }

        public Builder setStatus(ConnectionStatus status) {
            this.status = status;
            return this;
        }

        public Builder copy(Connection connection){
            this.connectionId = connection.connectionId;
            this.connectionDate = connection.connectionDate;
            this.status = connection.status;
            return this;
        }

        public Connection build(){
            return new Connection(this);
        }
    }
}
