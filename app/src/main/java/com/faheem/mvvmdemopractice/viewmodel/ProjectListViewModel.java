package com.faheem.mvvmdemopractice.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.faheem.mvvmdemopractice.model.Project;
import com.faheem.mvvmdemopractice.model.webservice.RetrofitClient;

import java.util.List;

public class ProjectListViewModel extends AndroidViewModel {

    private LiveData<List<Project>> projectListObserver;

    public ProjectListViewModel(@NonNull Application application) {
        super(application);
        projectListObserver = RetrofitClient.getInstance().getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObserver() {
        return projectListObserver;
    }
}
