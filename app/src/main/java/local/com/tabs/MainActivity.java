package local.com.tabs;

import android.app.DialogFragment;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import local.com.tabs.fragments.AddFragment;
import local.com.tabs.fragments.StateFragment;
import local.com.tabs.fragments.DiaryFragment;
import local.com.tabs.popups.ProfileDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigationView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                Log.d("TAG", "***prueba***");
                DialogFragment dialog = new ProfileDialogFragment();
                dialog.show(getFragmentManager(), "test");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setupNavigationView() {

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        if(bottomNavigationView != null){

            // Select first menu item by default and show Fragment accordingly
            Menu menu = bottomNavigationView.getMenu();

            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    selectFragment(item);

                    return false;
                }
            });

        }

    }

    /**
     *
     * selectFragment Method
     * Purpose: Perform action when any item is selected
     *
     *
     * @param item -> Item that is selected
     */
    protected void selectFragment(MenuItem item){

        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.navigation_add:
                // Action to perform when INSERT menu is selected
                pushFragment(new AddFragment());
                break;
            case R.id.navigation_diary:
                // Action to perform when SEARCH menu is selected
                pushFragment(new DiaryFragment());
                break;
            case R.id.navigation_state:
                // Action to perform when LIST menu is selected
                pushFragment(new StateFragment());
                break;

        }

    }

    /**
     *Metodo empleado para implementar los popups del primer fragment
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
