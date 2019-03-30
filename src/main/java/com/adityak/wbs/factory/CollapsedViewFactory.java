package com.adityak.wbs.factory;

import com.adityak.wbs.model.Task;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class CollapsedViewFactory implements Callback<javafx.scene.control.TableColumn.CellDataFeatures,javafx.beans.value.ObservableValue> {


    @Override
    public ObservableValue call(TableColumn.CellDataFeatures param) {

        return new SimpleStringProperty("");
    }
}
