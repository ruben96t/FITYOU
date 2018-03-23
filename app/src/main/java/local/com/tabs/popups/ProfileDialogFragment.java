package local.com.tabs.popups;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

import local.com.tabs.Databases.DBTrains;
import local.com.tabs.Databases.DBUser;
import local.com.tabs.Databases.Train;
import local.com.tabs.Databases.User;
import local.com.tabs.R;

import static java.lang.String.valueOf;

/**
 * Created by user on 19/03/2018.
 */

public class ProfileDialogFragment extends DialogFragment implements View.OnClickListener{

    public ProfileDialogFragment(){
        //  Required
    }

    EditText nameET;
    EditText heightET;
    RadioButton manRB;
    RadioButton womanRB;
    Button btnDate;

    EditText editTextTarget;

    boolean woman = false;
    boolean man = false;

    int mYear;
    int mMonth;
    int mDay;
    int age;

    final Calendar c = Calendar.getInstance();
    int yearAct = c.get(Calendar.YEAR);
    int monthAct = c.get(Calendar.MONTH);
    int dayAct = c.get(Calendar.DAY_OF_MONTH);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.content_profile, null);

        nameET = view.findViewById(R.id.editTextName);
        heightET = view.findViewById(R.id.editTextHeight);

        womanRB = view.findViewById(R.id.radioButtonWoman);
        womanRB.setOnClickListener(this);

        manRB = view.findViewById(R.id.radioButtonMan);
        manRB.setOnClickListener(this);

        btnDate = view.findViewById(R.id.buttonInsertDate);
        btnDate.setOnClickListener(this);

        editTextTarget = view.findViewById(R.id.editTextTWeight);


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        setCancelable(false);

        builder.setView(view)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        getValorBoton(id);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                        getValorBoton(id);
                    }

                });

        Dialog dialog = builder.create();
        return dialog;
    }

    private void getValorBoton(int id) {
        switch (id) {
            case -1:
                Log.d("TAG", "Valor Id Ok: " + id);
                String DB_Name = nameET.getText().toString();
                String DB_HeightAux = heightET.getText().toString();
                String DB_AgeAux = valueOf(age);
                Float DB_TargetWeight = Float.parseFloat(editTextTarget.getText().toString());
                int DB_Sex=3;

                if (woman == true) {
                    DB_Sex = 0;
                } else if (man == true) {
                    DB_Sex = 1;
                }

                //Log.d("DataBase", "" + DB_Name + " " + DB_Height + " " + DB_Age + " " + DB_Sex);

                if ((DB_Name.equals("")) || (DB_HeightAux.equals("")) || (DB_AgeAux.equals(""))|| (DB_Sex>2)) {

                    Toast.makeText(getActivity(), "Complete all fields", Toast.LENGTH_LONG).show();

                } else {

                    //edad = Integer.parseInt(((EditText)this.findViewById(R.id.editTextEdad)).getText().toString());

                    int DB_Height = Integer.parseInt(DB_HeightAux);

                    User u = new User(DB_Name, age, DB_Height, DB_Sex, DB_TargetWeight);

                    //Lo añadimos a la coleccion
                    DBUser dbuser = new DBUser(getActivity());
                    dbuser.insertUser(u);

                    //cerrramos la base de datos
                    dbuser.close();
                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_LONG).show();
                    //this.finish();
                }

                break;

            case -2:
                Log.d("TAG", "Valor Id Cancel: " + id);
                break;

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.buttonInsertDate:
                new DatePickerDialog(
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //la fecha seleccionada la
                                //guardamos en la variable

                                mYear = year;
                                mMonth = monthOfYear + 1;
                                mDay = dayOfMonth;
                                monthAct++;

                                age = yearAct - mYear;

                                if (monthAct < mMonth) {
                                    age--;
                                } else if (monthAct > mMonth) {


                                } else if (monthAct == mMonth && dayAct < mDay) {
                                    age--;
                                } else if (monthAct == mMonth && dayAct >= mDay) {

                                }

                                Log.d("EDAD: ", "" + age);
                                Log.d("TAG", "*******Fecha Actual***********");
                                Log.d("yearAct: ", "" + yearAct);
                                Log.d("monthAct: ", "" + monthAct);
                                Log.d("dayAct: ", "" + dayAct);
                                Log.d("TAG", "*******Fecha Nacimiento***********");
                                Log.d("mYear: ", "" + mYear);
                                Log.d("mMonth: ", "" + mMonth);
                                Log.d("mDay: ", "" + mDay);
                            }
                        },
                        yearAct,
                        monthAct,
                        dayAct)
                        .show();

                break;

            case R.id.radioButtonWoman:
                woman = true;
                man = false;
                break;
            case R.id.radioButtonMan:
                woman = false;
                man = true;
                break;


        }

    }


}
