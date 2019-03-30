/**
 */
package com.adityak.wbs.controller.keymap;

import com.adityak.wbs.model.Task;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.util.concurrent.atomic.AtomicInteger;

/**

 */
public class DecreaseLevelStrategy implements TableKeyBindingStrategy {

    @Override
    public void process(TableView<Task> taskTable , KeyEvent keyEvent) {

        addRow(taskTable);
        keyEvent.consume();

    }

    private void addRow(TableView<Task> taskTable) {

            int selectedIndex = taskTable.getSelectionModel().getSelectedIndex();

            if(selectedIndex>-1){
                final Task task = taskTable.getItems().get(selectedIndex);
                task.decreaseLevel();
            }

        KeymapUtils.populateSlNo(taskTable);





    }
}
