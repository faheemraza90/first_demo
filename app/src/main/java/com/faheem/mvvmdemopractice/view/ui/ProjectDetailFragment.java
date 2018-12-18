package com.faheem.mvvmdemopractice.view.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faheem.mvvmdemopractice.R;
import com.faheem.mvvmdemopractice.databinding.FragmentProjectDetailBinding;
import com.faheem.mvvmdemopractice.model.Project;
import com.faheem.mvvmdemopractice.viewmodel.ProjectDetailViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectDetailFragment extends Fragment {

    private static final String KEY_PROJECT_ID = "project_id";
    private FragmentProjectDetailBinding binding;

    public ProjectDetailFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_detail, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProjectDetailViewModel.Factory factory = new ProjectDetailViewModel.Factory(
                getActivity().getApplication(),
                getArguments().getString(KEY_PROJECT_ID)
        );

        final ProjectDetailViewModel detailViewModel = ViewModelProviders.of(this, factory)
                .get(ProjectDetailViewModel.class);
        binding.setProjectDetail(detailViewModel);
        binding.setIsLoading(true);

        observeViewModel(detailViewModel);
    }

    private void observeViewModel(final ProjectDetailViewModel detailViewModel) {
        detailViewModel.getProjectObserver().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                if (project!=null){
                    detailViewModel.setProject(project);
                    binding.setIsLoading(false);
                }
            }
        });
    }

    public static ProjectDetailFragment forProject(String projectId){
        ProjectDetailFragment fragment = new ProjectDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PROJECT_ID, projectId);
        fragment.setArguments(bundle);
        return fragment;
    }
}
