package za.ac.cput.domain;

public class User {

    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String phoneNumber;
    private String location;

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    protected User() {
    }

    protected User(Builder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.profilePicture = builder.profilePicture;
        this.phoneNumber = builder.phoneNumber;
        this.location = builder.location;
    }


    public static class Builder {
        private String userId;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String profilePicture;
        private String phoneNumber;
        private String location;

        public Builder(String userId, String email, String password) {
            this.userId = userId;
            this.email = email;
            this.password = password;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder profilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
