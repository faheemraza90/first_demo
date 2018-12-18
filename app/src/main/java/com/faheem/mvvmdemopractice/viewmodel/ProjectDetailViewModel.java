package com.faheem.mvvmdemopractice.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.faheem.mvvmdemopractice.model.Project;
import com.faheem.mvvmdemopractice.model.webservice.RetrofitClient;

public class ProjectDetailViewModel extends AndroidViewModel {

    private final LiveData<Project> projectObserver;
    private String projectId;
    public ObservableField<Project> project = new ObservableField<>();

    public ProjectDetailViewModel(@NonNull Application application, String projectId) {
        super(application);
        this.projectId = projectId;
        projectObserver = RetrofitClient.getInstance().getProjectDetails("Google", projectId);
    }

    public LiveData<Project> getProjectObserver() {
        return projectObserver;
    }

    public void setProject(Project project) {
        this.project.set(project);
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final Application application;
        private final String projectId;

        public Factory(@NonNull Application application, String projectId) {
            this.application = application;
            this.projectId = projectId;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//            return super.create(modelClass);
            return (T) new ProjectDetailViewModel(application, projectId);
        }

    }
}
