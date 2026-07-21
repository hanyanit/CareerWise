package za.ac.cput.domain;

import jakarta.persistence.*;

/**
 * User.java
 * Author: Hanyani Masinge, 222693452
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @Id
    private String userId;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String phoneNumber;
    private String location;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return userId != null && userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder<T extends Builder<T>> {

        protected String userId;
        protected String email;
        protected String password;
        protected String firstName;
        protected String lastName;
        protected String profilePicture;
        protected String phoneNumber;
        protected String location;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T setUserId(String userId) {
            this.userId = userId;
            return self();
        }

        public T setEmail(String email) {
            this.email = email;
            return self();
        }

        public T setPassword(String password) {
            this.password = password;
            return self();
        }

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return self();
        }

        public T setLastName(String lastName) {
            this.lastName = lastName;
            return self();
        }

        public T setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
            return self();
        }

        public T setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return self();
        }

        public T setLocation(String location) {
            this.location = location;
            return self();
        }

        public T copy(User user) {
            this.userId = user.getUserId();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.profilePicture = user.getProfilePicture();
            this.phoneNumber = user.getPhoneNumber();
            this.location = user.getLocation();

            return self();
        }

        public User build() {
            return new User(this);
        }
    }

}
