package com.example.clone_app;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clone_app.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class Home extends Fragment {



FragmentHomeBinding binding;
    dbHelper dbhelper;
    ArrayList<Item> itemList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        dbhelper = new dbHelper(requireContext());
        itemList = new ArrayList<>();
        Cursor cursor = dbhelper.readdata();

        while (cursor.moveToNext()) {

            String name = cursor.getString(1);
            String email = cursor.getString(2);

            itemList.add(new Item(name, email));
        }

        cursor.close();
        ItemAdapter adapter = new ItemAdapter(itemList);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);



        binding.save.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = binding.name.getText().toString();
                String email = binding.email.getText().toString();

                boolean success = dbhelper.insertdata(name, email);
                if (success) {
                    Toast.makeText(requireContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), "Failed to insert data", Toast.LENGTH_SHORT).show();
                }
            }


        });
        binding.display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbhelper.readdata();
                while (cursor.moveToNext()) {

                    String id = cursor.getString(0);
                    String name = cursor.getString(1);
                    String email = cursor.getString(2);

                    Toast.makeText(requireContext(),
                            "ID: " + id +
                                    "\nName: " + name +
                                    "\nEmail: " + email,
                            Toast.LENGTH_SHORT).show();
                }

                cursor.close();}

            });

        return(binding.getRoot());
    }
}