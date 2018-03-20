package lambda.model;

import java.util.List;

/**
 * Created by xianchun.hu on 1/24/2018.
 */
public class User {
    private String username;
    private String password;
    private int age;
    private List<String> aihao;

    public User() {
    }

    public User(String username, String password, List<String> aihao) {
        this.username = username;
        this.password = password;
        this.aihao = aihao;
    }

    public User(String username, String password, int age, List<String> aihao) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.aihao = aihao;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAihao() {
        return aihao;
    }

    public void setAihao(List<String> aihao) {
        this.aihao = aihao;
    }
}
