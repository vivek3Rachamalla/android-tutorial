package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    TextView headerText;

    TextView randomText;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        randomText=binding.getRoot().findViewById(R.id.textview_second);
        headerText=binding.getRoot().findViewById(R.id.textViewHeader);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Integer limit = this.getArguments().getInt("currentCount");
        setHeaderText(limit);
        setRandomText(limit);
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    public void setHeaderText(Integer limit){
        String text="Here is a number between 0 and "+limit;
        headerText.setText(text);
    }

    public void setRandomText(Integer limit){
        int randomNum =  (int)(Math.random() * limit);
        randomText.setText(Integer.toString(randomNum));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}