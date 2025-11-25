package murach.data;

import murach.business.User;

public class UserIO {
    public static void add(User user, String path) {
        User u = new User();
        u.setEmail(user.getEmail());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
    }

    public static User getUser(String email, String path) {
        // TODO: Implement reading user from file
        User user = new User();
        user.setEmail(email);
        return user;
    }
}
