package domain;

/**
 * @author lbf
 * @date 2020/8/30 8:49
 */
public class User {
    private int id;
    private String usrname;
    private String password;
    private String gender;

    public User() {
    }

    public User(int id, String usrname, String password, String gender) {
        this.id = id;
        this.usrname = usrname;
        this.password = password;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usrname='" + usrname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
