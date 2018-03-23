package local.com.tabs.Databases;

import java.io.Serializable;

/**
 * Created by user on 15/03/2018.
 */

public class User implements Serializable {

    private String name;
    private int age;
    private int height;
    private int sex;
    float targetweight;

    public User(String name, int age, int height, int sex, float targetweight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
        this.targetweight = targetweight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public float getTargetweight() {
        return targetweight;
    }

    public void setTargetweight(float targetweight) {
        this.targetweight = targetweight;
    }
}


