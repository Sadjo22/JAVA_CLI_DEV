package user;


import java.io.File;
import java.util.List;
import java.util.UUID;

public class userService {
    private UserDao userDao;

    public userService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public User getUserById(UUID uuid){
        for (User user : userDao.getUsers()){
            if (user.getUserId().equals(uuid)){
                return user;
            }
        }
        return null;


    }
}
