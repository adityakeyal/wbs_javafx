/**
 */
package com.adityak.wbs.model;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**

 */
public class Task {

    private final SimpleBooleanProperty collapsed = new SimpleBooleanProperty(false);
    private final SimpleStringProperty slNo = new SimpleStringProperty("");
    private final SimpleIntegerProperty level = new SimpleIntegerProperty(0);
    private final SimpleStringProperty task = new SimpleStringProperty("");


    private final SimpleStringProperty jira =  new SimpleStringProperty("");
    private final SimpleStringProperty assignee =  new SimpleStringProperty("");
    private final SimpleStringProperty status =  new SimpleStringProperty("");
    private final SimpleStringProperty comments =  new SimpleStringProperty("");


    public String getComments() {
        return comments.get();
    }

    public SimpleStringProperty commentsProperty() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments.set(comments);
    }

    public String getAssignee() {
        return assignee.get();
    }

    public SimpleStringProperty assigneeProperty() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee.set(assignee);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getJira() {
        return jira.get();
    }

    public SimpleStringProperty jiraProperty() {
        return jira;
    }

    public void setJira(String jira) {
        this.jira.set(jira);
    }


    public Task() {
        this("");
    }

    public Task(String stask) {

        this.task.set(stask);
        this.level.addListener( x-> task.set(task.get()+" "));

    }

    public boolean isCollapsed() {
        return collapsed.get();
    }

    public SimpleBooleanProperty collapsedProperty() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed.set(collapsed);
    }

    public String getSlNo() {
        return slNo.get();
    }

    public void setSlNo(String slNo) {
        this.slNo.set(slNo);
    }

    public String getTask() {
        return this.task.get();
    }

    public void setTask(String task) {
        this.task.set(task);
    }

    public SimpleStringProperty slNoProperty() {
        return slNo;
    }

    public SimpleStringProperty taskProperty() { return task; }

    public void increaseLevel() {
        level.set(level.get()+1);
    }

    public void decreaseLevel() {
        if(level.get()>0){
            level.set(level.get()-1);
        }


    }

    public int getLevel() {
        return level.get();
    }

    public ObservableValue formattedTaskProperty() {



        return new ReadOnlyStringWrapper(">" + task.get());
    }


    public SimpleIntegerProperty levelProperty() {
        return level;
    }

    public void setLevel(int level) {
        this.level.set(level);
    }
}
