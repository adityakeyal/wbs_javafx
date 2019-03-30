/**
 */
package com.adityak.wbs.controller.keymap;

import com.adityak.wbs.model.Task;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

public interface TableKeyBindingStrategy {

     void process(TableView<Task> tableView , KeyEvent keyEvent);


}
