package vn.edu.usth.wikipediaclient;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class ExploreFragment extends Fragment {


    private RecyclerView recyclerView;
    private ExploreAdapter exploreAdapter;
    private List<Article> articleList;


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameter

    public ExploreFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);


        //set a lineả layout manager to Recycler View
        recyclerView = view.findViewById(R.id.recyclerViewExplore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        articleList = new ArrayList<>();
        Cursor cursor = dbHelper.getAllArticles();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE));
                String description = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION));

                articleList.add(new Article(title, description, null, 0 ));
            }
            cursor.close();
        }

       //set the adapter to RecyclerView
       exploreAdapter = new ExploreAdapter(articleList);
       recyclerView.setAdapter(exploreAdapter);

        return view;
    }
}