package com.example.homework2.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework2.R;

public class First_Fragment extends Fragment {
    View v;
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    public First_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.first_fragment, container, false);
        Resources res = getResources();
        String[] city = res.getStringArray(R.array.city);
        mRecyclerView = v.findViewById(R.id.recyclerview);
        mAdapter = new RecyclerViewAdapter(getContext(), city);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}