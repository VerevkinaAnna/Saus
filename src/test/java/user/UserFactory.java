package user;

import utils.PropertyReader;

public class UserFactory {

    public static  User withAdminPermission(){
        return new User(PropertyReader.getProperty("saucedemmo.admin_user"),
              PropertyReader.getProperty("saucedemmo.password"));
    }

    public static  User withLockedPermission(){
        return new User(PropertyReader.getProperty("saucedemmo.locked_user"),
                PropertyReader.getProperty("saucedemmo.password"));
    }

    public static  User withHRPermission(){
        return new User(PropertyReader.getProperty("saucedemmo.admin_user"),
                PropertyReader.getProperty("saucedemmo.password"));
    }
}
