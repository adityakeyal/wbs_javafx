/**
 */
package com.adityak.wbs.controller.keymap;

import com.adityak.wbs.model.Task;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.util.concurrent.atomic.AtomicInteger;

/**

 */
public class AddNewRowStrategy implements TableKeyBindingStrategy {

    @Override
    public void process(TableView<Task> taskTable , KeyEvent keyEvent) {

        addRow(taskTable);
        keyEvent.consume();

    }

    private void addRow(TableView<Task> taskTable) {

            int selectedIndex = taskTable.getSelectionModel().getSelectedIndex();
            selectedIndex = selectedIndex < 0 ? (taskTable.getItems().size()) : selectedIndex + 1;
            taskTable.getItems().add(selectedIndex,new Task());


            KeymapUtils.populateSlNo(taskTable);


//            final AtomicInteger count = new AtomicInteger(1);
//            taskTable.getItems().forEach( t -> t.setSlNo(String.valueOf((count.getAndIncrement()))));
    }
}
