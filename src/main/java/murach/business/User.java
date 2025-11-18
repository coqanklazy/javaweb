package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String heardFrom;
    private boolean wantsUpdates;
    private boolean emailAnnouncements;
    private String contactMethod;

    public User () {
        firstName = "";
        lastName = "";
        email = "";
        dateOfBirth = null;
        heardFrom = "";
        wantsUpdates = false;
        emailAnnouncements = false;
        contactMethod = "";
    }
    public User(String firstName, String lastName, String email, String dateOfBirth, String heardFrom, boolean wantsUpdates, boolean emailAnnouncements, String contactMethod) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.dateOfBirth = dateOfBirth;
            this.heardFrom = heardFrom;
            this.wantsUpdates = wantsUpdates;
            this.emailAnnouncements = emailAnnouncements;
            this.contactMethod = contactMethod;
        }
    public String getHeardFrom() { return heardFrom; }
    public void setHeardFrom(String heardFrom) { this.heardFrom = heardFrom; }

    public boolean isWantsUpdates() { return wantsUpdates; }
    public void setWantsUpdates(boolean wantsUpdates) { this.wantsUpdates = wantsUpdates; }

    public boolean isEmailAnnouncements() { return emailAnnouncements; }
    public void setEmailAnnouncements(boolean emailAnnouncements) { this.emailAnnouncements = emailAnnouncements; }

    public String getContactMethod() { return contactMethod; }
    public void setContactMethod(String contactMethod) { this.contactMethod = contactMethod; }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}