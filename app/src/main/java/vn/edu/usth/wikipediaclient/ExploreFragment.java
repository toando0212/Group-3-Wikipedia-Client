package vn.edu.usth.wikipediaclient;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    private RecyclerView recyclerView;
    private ExploreAdapter exploreAdapter;
    private List<Article> articleList;

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewExplore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize article list
        articleList = new ArrayList<>();

        // Fetch data from database
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        Cursor cursor = dbHelper.getAllArticles();
        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE));
                    String description = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION));

                    // Create Article objects with null for image and content (if not needed)
                    articleList.add(new Article(title, description, null, 0));
                }
            } finally {
                cursor.close(); // Always close the cursor to avoid memory leaks
            }
        }

        // Set adapter to RecyclerView
        exploreAdapter = new ExploreAdapter(articleList);
        recyclerView.setAdapter(exploreAdapter);

        return view;
    }
}
