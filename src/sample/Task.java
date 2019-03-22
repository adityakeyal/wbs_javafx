/**
 */
package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**

 */
public class Task {

    private final SimpleBooleanProperty collapsed = new SimpleBooleanProperty(false);
    private final SimpleStringProperty slNo = new SimpleStringProperty("");
    private final SimpleIntegerProperty level = new SimpleIntegerProperty(1);
    private final SimpleStringProperty task = new SimpleStringProperty("");



    public Task() {
        this("","");
    }

    public Task(String slNo, String task) {
        this.slNo.set(slNo);
        this.task.set(task);
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

    public SimpleStringProperty slNoProperty() {
        return slNo;
    }

    public SimpleStringProperty taskProperty() {
        return new SimpleStringProperty(" > "+task.get());
    }

    public String tab() {

        StringBuilder build = new StringBuilder();
        for (int i = 0; i < this.level.get(); i++) {
            build.append(" ");
        }

        return build.toString();
    }
}
