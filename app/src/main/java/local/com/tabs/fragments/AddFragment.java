package local.com.tabs.fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import local.com.tabs.R;
import local.com.tabs.popups.BikeDialogFragment;
import local.com.tabs.popups.GymDialogFragment;
import local.com.tabs.popups.RunDialogFragment;
import local.com.tabs.popups.SwimDialogFragment;
import local.com.tabs.popups.WeightDialogFragment;

/**
 * Created by user on 16/03/2018.
 */

public class AddFragment extends Fragment implements View.OnClickListener {

    //FragmentManager manager = getFragmentManager();
    
    public AddFragment(){
        //  Required empty public constructor
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        //View view = inflater.inflate(R.layout.add_layout, container, false);
        View v = inflater.inflate(R.layout.add_layout, container, false);


        Button buttonRun = (Button) v.findViewById(R.id.buttonRRun);
        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new RunDialogFragment();
                dialog.show(getFragmentManager(), "test");
            }
        });



        Button buttonBike = (Button) v.findViewById(R.id.buttonRBike);
        buttonBike.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view) {
                    DialogFragment dialog = new BikeDialogFragment();
                    dialog.show(getFragmentManager(), "test");
                }

        });

        Button buttonSwim = (Button) v.findViewById(R.id.buttonRSwim);
        buttonSwim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new SwimDialogFragment();
                dialog.show(getFragmentManager(), "test");
            }
        });

        Button buttonGym = (Button) v.findViewById(R.id.buttonRGym);
        buttonGym.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    DialogFragment dialog = new GymDialogFragment();
                    dialog.show(getFragmentManager(), "test");
                }
        });

        Button buttonWeight = (Button) v.findViewById(R.id.buttonRWeight);
        buttonWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new WeightDialogFragment();
                dialog.show(getFragmentManager(), "test");
            }
        });



        // Devolvemos la vista al fragment
        return v;



    }

    /*private void insertInto(){

        // TODO: Creamos referencia de la clase AgendaSQL
        AgendaSql agendaSql = new AgendaSql(getActivity());

        // Llamamos método para insertar el registro
        agendaSql.insertDeveloper(getActivity(), editTextName, spinnerPosition, editTextAge);

        // Cerramos la base de datos
        agendaSql.close();

    }*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //case R.id.buttonInsert:
                //Introduce en la DB con insertInto();
                //break;
        }
    }


    /**
     *
     * pushFragment Method
     * Purpose :  Method to push any fragment into give id
     *
     *
     * @param fragment -> An instance of fragment to show into the given id
     */
    protected void pushFragment(Fragment fragment){

        if(fragment == null)
            return;

        android.app.FragmentManager fragmentManager = getFragmentManager();

        if(fragmentManager != null){
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(fragmentTransaction != null){
                fragmentTransaction.replace(R.id.content, fragment);
                fragmentTransaction.commit();
            }
        }

    }
}
