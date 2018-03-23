package local.com.tabs.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;

import local.com.tabs.Databases.DBTrains;
import local.com.tabs.R;

/**
 * Created by user on 16/03/2018.
 */

public class DiaryFragment extends Fragment implements View.OnClickListener{

    private LineChart dataChart;

    public DiaryFragment() {
        // Required empty public constructor
    }

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.diary_layout, container, false);

        //mTextMessage = (TextView) findViewById(R.id.message);

        dataChart = (LineChart) view.findViewById(R.id.chartH1);

        final Calendar cal = Calendar.getInstance();
        int actmonth = cal.get(Calendar.MONTH) + 1;
        int actyear = cal.get(Calendar.YEAR);

        DBTrains gestion1 = new DBTrains(getActivity());
        Cursor c1 = gestion1.getTrains("Run");
        int[][] datosArray1 = mostrarDatos(c1, actmonth, actyear);
        gestion1.close();

        int yValuesRun[] = new int[datosArray1.length];
        int xValuesRun[] = new int[datosArray1.length];
        for (int i=0; i<datosArray1.length; i++ ) {
            xValuesRun[i]= datosArray1[i][1];
            yValuesRun[i]= datosArray1[i][0];
        }

        DBTrains gestion2 = new DBTrains(getActivity());
        Cursor c2 = gestion2.getTrains("Bike");
        int[][] datosArray2 = mostrarDatos(c2, actmonth, actyear);
        gestion2.close();

        int yValuesBike[] = new int[datosArray2.length];
        int xValuesBike[] = new int[datosArray2.length];
        for (int i=0; i<datosArray2.length; i++ ) {
            xValuesBike[i]= datosArray2[i][1];
            yValuesBike[i]= datosArray2[i][0];
        }

        DBTrains gestion3 = new DBTrains(getActivity());
        Cursor c3 = gestion3.getTrains("Swim");
        int[][] datosArray3 = mostrarDatos(c3, actmonth, actyear);
        gestion3.close();

        int yValuesSwim[] = new int[datosArray3.length];
        int xValuesSwim[] = new int[datosArray3.length];
        for (int i=0; i<datosArray3.length; i++ ) {
            xValuesSwim[i]= datosArray3[i][1];
            yValuesSwim[i]= datosArray3[i][0];
        }

        DBTrains gestion4 = new DBTrains(getActivity());
        Cursor c4 = gestion4.getTrains("Gym");
        int[][] datosArray4 = mostrarDatos(c4, actmonth, actyear);
        gestion4.close();

        int yValuesGym[] = new int[datosArray4.length];
        int xValuesGym[] = new int[datosArray4.length];
        for (int i=0; i<datosArray4.length; i++ ) {
            xValuesGym[i]= datosArray4[i][1];
            yValuesGym[i]= datosArray4[i][0];
        }

        lineChart(yValuesGym, xValuesGym, yValuesSwim, xValuesSwim, yValuesBike, xValuesBike, yValuesRun, xValuesRun);

        return view;
    }

    private void lineChart(int[] yValuesGym, int[] xValuesGym, int[] yValuesSwim, int[] xValuesSwim, int[] yValuesBike, int[] xValuesBike,
                           int [] yValuesRun, int [] xValuesRun) {


        ArrayList<Entry> yRun = new ArrayList<>();
        for (int i = 0; i < xValuesRun.length; i++) {
            yRun.add(new Entry(xValuesRun[i], yValuesRun[i]));
        }

        ArrayList<Entry> yBike = new ArrayList<>();
        for (int i = 0; i < xValuesBike.length; i++) {
            yBike.add(new Entry(xValuesBike[i], yValuesBike[i]));
        }


        ArrayList<Entry> ySwim = new ArrayList<>();
        for (int i = 0; i < xValuesSwim.length; i++) {
            ySwim.add(new Entry(xValuesSwim[i], yValuesSwim[i]));
        }


        ArrayList<Entry> yGym = new ArrayList<>();
        for (int i = 0; i < xValuesGym.length; i++) {
            yGym.add(new Entry(xValuesGym[i], yValuesGym[i]));
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


    @Override
    public void onClick(View view) {
/*        switch (view.getId()) {
            case R.id.buttonFind:
                //findByEmail();
                break;
        }*/
    }
}
