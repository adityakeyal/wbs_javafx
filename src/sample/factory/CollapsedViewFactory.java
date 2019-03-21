package sample.factory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import sample.Task;

public class CollapsedViewFactory implements Callback<javafx.scene.control.TableColumn.CellDataFeatures<Task,String>,javafx.beans.value.ObservableValue> {


    @Override
    public ObservableValue call(TableColumn.CellDataFeatures<Task,String> param) {

        return new SimpleStringProperty("+");
    }
}
