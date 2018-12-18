package com.faheem.mvvmdemopractice.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.faheem.mvvmdemopractice.R;
import com.faheem.mvvmdemopractice.databinding.ProjectListRowItemBinding;
import com.faheem.mvvmdemopractice.model.Project;
import com.faheem.mvvmdemopractice.view.callbacks.ProjectListCallback;

import java.util.List;
import java.util.Objects;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private List<Project> projects;
    private ProjectListCallback callback;

    public ProjectAdapter(ProjectListCallback callback) {
        this.callback = callback;
    }

    public void setProjects(final List<Project> projects) {
        if (this.projects == null) {
            this.projects = projects;
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return ProjectAdapter.this.projects.size();
                }

                @Override
                public int getNewListSize() {
                    return projects.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return ProjectAdapter.this.projects.get(oldItemPosition).getId() ==
                            projects.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Project newProject = projects.get(newItemPosition);
                    Project oldProject = projects.get(oldItemPosition);
                    return newProject.getId() == oldProject.getId() &&
                            Objects.equals(newProject.getGitUrl(), oldProject.getGitUrl());
                }
            });
            this.projects = projects;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProjectListRowItemBinding mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.project_list_row_item,
                parent,
                false
        );
        mBinding.setCallback(callback);
        return new ViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setProject(projects.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return projects == null ? 0 : projects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final ProjectListRowItemBinding binding;

        ViewHolder(ProjectListRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}