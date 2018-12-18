package com.faheem.mvvmdemopractice.view.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.faheem.mvvmdemopractice.R;
import com.faheem.mvvmdemopractice.databinding.ActivityProjectListBinding;
import com.faheem.mvvmdemopractice.model.Project;
import com.faheem.mvvmdemopractice.view.adapter.ProjectAdapter;
import com.faheem.mvvmdemopractice.view.callbacks.ProjectListCallback;
import com.faheem.mvvmdemopractice.viewmodel.ProjectListViewModel;

import java.util.List;

public class ProjectListActivity extends AppCompatActivity {

    private ActivityProjectListBinding mBinding;
    private ProjectAdapter adapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_project_list);
        mContext = ProjectListActivity.this;
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_project_list);
        mBinding.setIsLoading(true);
        mBinding.rvProjectList.setLayoutManager(new LinearLayoutManager(
                mContext,
                LinearLayoutManager.VERTICAL,
                false
        ));

        adapter = new ProjectAdapter(new ProjectListCallback() {
            @Override
            public void onClick(Project project) {
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {

                    ProjectDetailFragment detailFragment = ProjectDetailFragment.forProject(project.getName());
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(ProjectDetailFragment.class.getSimpleName())
                            .replace(R.id.fragment_container, detailFragment, null)
                            .commit();
                }
            }
        });

        mBinding.rvProjectList.setAdapter(adapter);
        mBinding.setIsLoading(true);
        ProjectListViewModel viewModel = ViewModelProviders
                .of(this).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(ProjectListViewModel viewModel) {
        viewModel.getProjectListObserver().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                    mBinding.setIsLoading(false);
                    adapter.setProjects(projects);
                }
            }
        });
    }

}
