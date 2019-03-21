/**
 */
package sample;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**

 */
public class Task {

    private final SimpleBooleanProperty collapsed = new SimpleBooleanProperty(false);
    private final SimpleStringProperty slNo = new SimpleStringProperty("");
    private final SimpleStringProperty task = new SimpleStringProperty("");
    private final SimpleStringProperty subTask = new SimpleStringProperty("");


    public Task() {
        this("","","");
    }

    public Task(String slNo, String task, String subTask) {
        this.slNo.set(slNo);
        this.task.set(task);
        this.subTask.set(subTask);
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
        return task.get();
    }

    public void setTask(String task) {
        this.task.set(task);
    }

    public String getSubTask() {
        return subTask.get();
    }

    public void setSubTask(String subTask) {
        this.subTask.set(subTask);
    }

    public SimpleStringProperty slNoProperty() {
        return slNo;
    }

    public SimpleStringProperty taskProperty() {
        return task;
    }

    public SimpleStringProperty subTaskProperty() {
        return subTask;
    }
}
