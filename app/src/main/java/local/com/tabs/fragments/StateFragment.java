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
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;

import local.com.tabs.Databases.DBTrains;
import local.com.tabs.Databases.DBUser;
import local.com.tabs.Databases.DBWeights;
import local.com.tabs.R;

/**
 * Created by user on 16/03/2018.
 */

public class StateFragment extends Fragment implements View.OnClickListener{

    private LineChart dataChart;
    TextView imcTV;
    int altura;


    public StateFragment(){
        // Required empty public constructor
    }

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.state_layout, container, false);
        dataChart = view.findViewById(R.id.chartHS);

        imcTV = view.findViewById(R.id.textViewIMC);




        final Calendar cal = Calendar.getInstance();
        int actmonth = cal.get(Calendar.MONTH) + 1;
        int actyear = cal.get(Calendar.YEAR);

        DBWeights gestion = new DBWeights(getActivity());
        Cursor c = gestion.getWeights();
        float[][] datosArray2 = mostrarDatos(c, actmonth, actyear);
        gestion.close();

        float yValues[] = new float[datosArray2.length];
        float xValues[] = new float[datosArray2.length];
        float pesoult = 0;

        for (int i=0; i<datosArray2.length; i++ ) {

            xValues[i]= datosArray2[i][1];
            yValues[i]= datosArray2[i][0];
            pesoult= datosArray2[datosArray2.length-1][1];
        }

        String pesoultStr;
        pesoultStr = String.valueOf(pesoult);

        imcTV.setText("IMC: " + pesoultStr);



        DBUser gestuser = new DBUser(getActivity());
        Cursor gu = gestuser.getUserData();
        float pesoObjetivo = extTarget(gu);

        altura = extHeight(gu);
        float pesoMin = 18.5f * altura/100 * altura/100;
        float pesoMax = 25f * altura/100 * altura/100;
        gestuser.close();



        lineChart(yValues, xValues, pesoObjetivo, pesoMin, pesoMax);

        return view;
    }

    private void lineChart(float[] yValues, float[] xValues, float pesoObjetivo, float pesoMin, float pesoMax) {


        ArrayList<Entry> y = new ArrayList<>();
        for (int i = 0; i < xValues.length; i++) {
            y.add(new Entry(xValues[i], yValues[i]));
        }

        ArrayList<Entry> pesoObjetivo1 = new ArrayList<>();
        for (int i = 0; i < xValues.length; i++) {
            pesoObjetivo1.add(new Entry(xValues[i], pesoObjetivo));
        }

        ArrayList<Entry> pesoMin1 = new ArrayList<>();
        for (int i = 0; i < xValues.length; i++) {
            pesoMin1.add(new Entry(xValues[i], pesoMin));
        }

        ArrayList<Entry> pesoMax1 = new ArrayList<>();
        for (int i = 0; i < xValues.length; i++) {
            pesoMax1.add(new Entry(xValues[i], pesoMax));
        }

        LineDataSet set1, set2, set3, set4;

        set1 = new LineDataSet(y, "Weight");
        set1.setColor(Color.GREEN);

        set2 = new LineDataSet(pesoObjetivo1, "target");
        set2.setColor(Color.BLUE);

        set3 = new LineDataSet(pesoMin1, "MIN");
        set3.setColor(Color.YELLOW);

        set4 = new LineDataSet(pesoMax1, "MAX");
        set4.setColor(Color.RED);

        LineData data = new LineData(set1, set2, set3, set4);
        dataChart.setData(data);
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);


    }


    public float[][] mostrarDatos(Cursor c, int actmonth, int actyear) {


        int cuenta = c.getCount();
        int aux = 0;
        String datos = "";
        float[][] datosArr = new float[cuenta][2];

        if (c.moveToFirst()) {
            do {
/*                Log.d("TAG", "Nombre: " + c.getString(1));

                datos += "\nTiempo: " + c.getInt(2) +
                        "\nDay: " + c.getInt(4) +
                        "\nMes: " + c.getInt(5) +
                        "\nAño: " + c.getInt(6) +
                        "\n\n";*/

                if (c.getInt(4)== actyear) {

                    if (c.getInt(3)== actmonth) {
                        datosArr[aux][0] = c.getInt(1);
                        //Recogemos el dato de día.
                        datosArr[aux][1] = c.getInt(2);

                        aux++;
                    }
                }
            } while (c.moveToNext() && aux < cuenta);
        }
        return datosArr;
    }



    public float extTarget(Cursor c) {

        float datosTar;
        c.moveToLast();
        datosTar = c.getFloat(5);
        return datosTar;
    }

    public int extHeight(Cursor c) {

        int datoHeight;
        c.moveToLast();
        datoHeight = c.getInt(3);
        return datoHeight;
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
