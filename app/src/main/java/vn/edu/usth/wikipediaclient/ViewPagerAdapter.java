package vn.edu.usth.wikipediaclient;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull

    //return item
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ExploreFragment();
        } else if (position == 1) {
            return new HistoryFragment();
        } else if (position == 2) {
            return  new MyArticleFragment();
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
            return "My Article";
        } else if (position == 3) {
            return "Account";
        } else {
            return "Explore";
        }
    }
}
