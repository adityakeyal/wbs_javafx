package com.adityak.wbs.model;

import java.util.List;

public class Holder{
    List<Task> tasks;

    public Holder(){

    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
