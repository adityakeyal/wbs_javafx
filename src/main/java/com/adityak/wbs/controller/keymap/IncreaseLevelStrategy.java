/**
 */
package com.adityak.wbs.controller.keymap;

import com.adityak.wbs.model.Task;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**

 */
public class IncreaseLevelStrategy implements TableKeyBindingStrategy {

    @Override
    public void process(TableView<Task> taskTable , KeyEvent keyEvent) {

        addRow(taskTable);
        keyEvent.consume();

    }

    private void addRow(TableView<Task> taskTable) {

        int selectedIndex = taskTable.getSelectionModel().getSelectedIndex();

        if(selectedIndex>0){
            final Task task = taskTable.getItems().get(selectedIndex);
            final Task previousTask = taskTable.getItems().get(selectedIndex - 1);

            if(task.getLevel() - previousTask.getLevel() <=0){
                task.increaseLevel();
            }
        }

        //set serial numbers as per above

        KeymapUtils.populateSlNo(taskTable);


    }



}
