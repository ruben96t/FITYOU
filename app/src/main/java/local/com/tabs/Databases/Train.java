package local.com.tabs.Databases;

import java.io.Serializable;

/**
 * Created by user on 15/03/2018.
 */

public class Train implements Serializable {

    private String training;
    private int time;
    private int dist;
    private int day;
    private int month;
    private int year;


    public Train(String training, int time, int dist, int day, int month, int year) {
        this.training = training;
        this.time = time;
        this.dist = dist;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

