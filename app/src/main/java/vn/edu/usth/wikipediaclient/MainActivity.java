package vn.edu.usth.wikipediaclient;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_explore);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_history);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_nearby);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup ViewPager, TabLayout
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }


}