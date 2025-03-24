package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserPackage implements Serializable {

    public String email;
    public String username;
    public String password;
    public List<TestPackage> savedTestPackage;
    public List<TestPackage> postedTestPackage;

    public UserPackage(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
        this.savedTestPackage = new ArrayList<>();
        this.postedTestPackage = new ArrayList<>();
    }

    public UserPackage(String email, String username, String password, List<TestPackage> savedTestPackage, List<TestPackage> postedTestPackage){
        this.email = email;
        this.username = username;
        this.password = password;
        this.savedTestPackage = savedTestPackage;
        this.postedTestPackage = postedTestPackage;
    }

    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public List<TestPackage> getSavedTestPackage() {
        return savedTestPackage;
    }
    public List<TestPackage> getPostedTestPackage() {
        return postedTestPackage;
    }
}
