/*
package local.com.tabs.Databases;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;

public class Diary extends AppCompatActivity {

    private TextView mTextMessage;
    private LineChart dataChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_layout);

        */
/*mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*//*


        dataChart = (LineChart) findViewById(R.id.chartH1);

        DBTrains gestion = new DBTrains(this);

        Cursor c = gestion.getTrains("Run");

        final Calendar cal = Calendar.getInstance();
        int actmonth = cal.get(Calendar.MONTH) + 1;
        int actyear = cal.get(Calendar.YEAR);

        int[][] datosArray2 = mostrarDatos(c, actmonth, actyear);

        gestion.close();


        */
/*int yValuesRun [] = {30, 50, 10, 40, 5, 60, 30};
        int yValuesBike [] = {40, 60, 20, 0, 50, 30, 60};
        int yValuesSwim [] = {10, 20, 30, 40, 50, 60, 10};
        int yValuesGym [] = {20, 30, 50, 20, 10, 20, 40};*//*


        int yValues[] = {30, 50, 10, 40, 5, 60, 30};
        int xValues[] = {18, 20, 21, 24, 25, 27, 29};

        int yValuesBike[] = {40, 20, 30, 60};
        int xValuesBike[] = {19, 20, 28, 30};

        int yValuesRun[] = new int[datosArray2.length];
        int xValuesRun[] = new int[datosArray2.length];

        for (int i=0; i<datosArray2.length; i++ ) {

            xValuesRun[i]= datosArray2[i][1];
            yValuesRun[i]= datosArray2[i][0];

        }


        lineChart(yValues, xValues, yValuesBike, xValuesBike, yValuesRun, xValuesRun);

        */
/*lineChartRun(yValuesRun, xValues);
        lineChartBike(yValuesBike, xValues);
        lineChartSwim(yValuesSwim, xValues);
        lineChartGym(yValuesGym, xValues);*//*


        */
/*LineData data = new LineData(set1, set2, set3, set4);
        dataChart.setData(data);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.BLACK);*//*



    }

    private void lineChart(int yValues[], int[] xValues, int yValuesBike[], int xValuesBike[],
                           int [] yValuesRun, int [] xValuesRun) {


        ArrayList<Entry> yRun = new ArrayList<>();
        for (int i = 0; i < yValuesRun.length; i++) {
            yRun.add(new Entry(xValuesRun[i], yValuesRun[i]));
        }

        ArrayList<Entry> yBike = new ArrayList<>();
        for (int i = 0; i < yValuesBike.length; i++) {
            yBike.add(new Entry(xValuesBike[i], yValuesBike[i]));
        }


        ArrayList<Entry> ySwim = new ArrayList<>();
        for (int i = 0; i < yValues.length; i++) {
            ySwim.add(new Entry(xValues[i], yValues[i]));
        }


        ArrayList<Entry> yGym = new ArrayList<>();
        for (int i = 0; i < yValues.length; i++) {
            yGym.add(new Entry(xValues[i], yValues[i] + 20));
        }

        LineDataSet set1, set2, set3, set4;

        set1 = new LineDataSet(yRun, "Running");
        set1.setColor(Color.RED);


        set2 = new LineDataSet(yBike, "Cycling");
        set2.setColor(Color.YELLOW);

        set3 = new LineDataSet(ySwim, "Swimming");
        set3.setColor(Color.BLUE);

        set4 = new LineDataSet(yGym, "Gym");
        set4.setColor(Color.GREEN);


        LineData data = new LineData(set1, set2, set3, set4);
        dataChart.setData(data);
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);


    }


    //dataChart.setData(lineData);
    //dataChart.invalidate();



*/
/*
    private void lineChartRun(int yValuesRun [], String [] xValues){
        ArrayList<Entry> yRun = new ArrayList<>();
        for (int i = 0; i<yValuesRun.length; i++){
            int run2 = 10;
            yRun.add(new Entry(i, run2));
        }
        set1 = new LineDataSet(yRun, "Running");
        set1.setColor(Color.RED);


    }
    private void lineChartBike(int yValuesBike [], String [] xValues){
        ArrayList<Entry> yBike = new ArrayList<>();
        for (int i = 0; i<yValuesBike.length; i++){
            yBike.add(new Entry(i,yValuesBike[i]));
        }
        set2 = new LineDataSet(yBike, "Cycling");
        set2.setColor(Color.YELLOW);

    }
    private void lineChartSwim(int yValuesSwim [], String [] xValues){
        ArrayList<Entry> ySwim = new ArrayList<>();
        for (int i = 0; i<yValuesSwim.length; i++){
            ySwim.add(new Entry(i,yValuesSwim[i]));
        }
        set3 = new LineDataSet(ySwim, "Swimming");
        set3.setColor(Color.BLUE);

    }
    private void lineChartGym(int yValuesGym [], String [] xValues){
        ArrayList<Entry> yGym = new ArrayList<>();
        for (int i = 0; i<yValuesGym.length; i++){
            yGym.add(new Entry(i, yValuesGym[i]));
        }
        set4 = new LineDataSet(yGym, "Gym");
        set4.setColor(Color.GREEN);

    }*//*





        */
/*ArrayList<Entry> yBike = new ArrayList<>();
        for (int i = 0; i<yValues.length; i++){
            float run2 = (float) (Math.random()*day)+10;
            yBike.add(new Entry(i, run2));
        }
        ArrayList<Entry> ySwim = new ArrayList<>();
        for (int i = 0; i<time; i++){
            float run2 = (float) (Math.random()*day)+10;
            ySwim.add(new Entry(i, run2));
        }*//*



    */
/*   public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mTextMessage.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_dashboard:
                        mTextMessage.setText(R.string.title_dashboard);
                        return true;
                    case R.id.navigation_notifications:
                        mTextMessage.setText(R.string.title_notifications);
                        return true;
                }
                return false;
            }
        };*//*

    public int[][] mostrarDatos(Cursor c, int actmonth, int actyear) {


        int cuenta = c.getCount();
        int aux = 0;
        String datos = "";
        int[][] datosArr = new int[cuenta][2];

        if (c.moveToFirst()) {
            do {
                Log.d("TAG", "Nombre: " + c.getString(1));

                datos += "\nTiempo: " + c.getInt(2) +
                        "\nDay: " + c.getInt(4) +
                        "\nMes: " + c.getInt(5) +
                        "\nAño: " + c.getInt(6) +
                        "\n\n";

                if (c.getInt(6)== actyear) {

                    if (c.getInt(5)== actmonth) {
                        datosArr[aux][0] = c.getInt(2);
                        //Recogemos el dato de día.
                        datosArr[aux][1] = c.getInt(4);

                        aux++;

                    }

                }


            } while (c.moveToNext() && aux < cuenta);
        }
        return datosArr;
    }
}*/
