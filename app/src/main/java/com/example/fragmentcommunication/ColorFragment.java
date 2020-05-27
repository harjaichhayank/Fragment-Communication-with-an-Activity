package com.example.fragmentcommunication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {

    private OnColorChangeListener onColorChangeListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.color_fragment_layout, container, false);
        RadioGroup radioGroup = view.findViewById(R.id.color_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.blue_color:
                        onColorChangeListener.colorChanged("BLUE");
                        break;
                    case R.id.green_color:
                        onColorChangeListener.colorChanged("GREEN");
                        break;
                    case R.id.red_color:
                        onColorChangeListener.colorChanged("RED");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity;
        if(context instanceof Activity)
        {
            activity = (Activity)context;
            try{
                onColorChangeListener = (OnColorChangeListener)activity;
            }catch (ClassCastException e){
                throw new ClassCastException(activity.toString()
                        + " must implement OnColorChangeListener");

            }
        }
    }
    public interface OnColorChangeListener {
        void colorChanged(String color_name);
    }
}
