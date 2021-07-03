package responsi.miftahuraziz.covidjabar.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import responsi.miftahuraziz.covidjabar.R;
import responsi.miftahuraziz.covidjabar.view.fragment.CovidCaseFragment;
import responsi.miftahuraziz.covidjabar.view.fragment.HospitalFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new CovidCaseFragment();
    private BottomNavigationView bottomNavigationView;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_nav_kasus_covid:
                selectedFragment = new CovidCaseFragment();
                loadFragment(selectedFragment);
                title = "Covid Jabar";
                setTitle(title);
                break;
            case R.id.bottom_nav_rumahsakit:
                selectedFragment = new HospitalFragment();
                loadFragment(selectedFragment);
                title = "RS Rujukan";
                setTitle(title);
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}