
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
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String phoneNumber;
    private String location;

//    public User(int id) {
//        this.id = id;
//    }

    protected User() {}

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

    public int getId(){
        return id;
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




    public static class Builder {
        protected int id;
        protected String userId;
        protected String email;
        protected String password;
        protected String firstName;
        protected String lastName;
        protected String profilePicture;
        protected String phoneNumber;
        protected String location;

        public Builder() {

        }

        public Builder setId(int id){
            this.id = id;
            return this;
        }
        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
