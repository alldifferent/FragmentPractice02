package com.alldi.fragmentpractice02.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alldi.fragmentpractice02.R;
import com.alldi.fragmentpractice02.databinding.FragmentThreeBinding;

public class FragmentThree extends Fragment {

    FragmentThreeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_three, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.threeTxt.setText("세번째 바인딩 성공");
    }

    public void changeMessage(String inputMessage){
        binding.threeTxt.setText(inputMessage);
    }
}
