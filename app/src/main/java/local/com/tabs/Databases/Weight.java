package local.com.tabs.Databases;

import java.io.Serializable;

/**
 * Created by user on 15/03/2018.
 */

public class Weight implements Serializable {

    private float weight;
    private int day;
    private int month;
    private int year;

    public Weight(float weight, int day, int month, int year) {
        this.weight = weight;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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

