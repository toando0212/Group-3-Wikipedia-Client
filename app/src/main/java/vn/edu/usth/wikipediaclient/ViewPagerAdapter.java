package vn.edu.usth.wikipediaclient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private TabLayout tabLayout;
    public ViewPagerAdapter(FragmentManager manager, TabLayout tabLayout) {
        super(manager);
        this.tabLayout = tabLayout;
    }



    //return item
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ExploreFragment();
        } else if (position == 1) {
            return new HistoryFragment();
        } else if (position == 2) {
            return  new AddArticleFragment();
        } else if (position == 3) {
            return new AccountFragment();
        } else {
            return new ExploreFragment();
        }
    }



    @Override
    public int getCount() {
        return 4;
    }

    //return page title
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Explore";
        } else if (position == 1) {
            return "History";
        } else if (position == 2) {
            return "Add Article";
        } else if (position == 3) {
            return "Account";
        } else {
            return "Explore";
        }
    }

    //setup icon for tabs
    public void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_explore);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_history);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_add_article);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_account);
    }
}
