/**
 */
package com.adityak.wbs.controller.keymap;

import com.adityak.wbs.model.Task;
import javafx.scene.control.TableView;

import java.util.Stack;
import java.util.stream.Collectors;

/**

 */
public class KeymapUtils {

    public static  void populateSlNo(TableView<Task> taskTable){


        if(!taskTable.getItems().isEmpty()){

            int previousLevel = taskTable.getItems().get(0).getLevel();
            Stack<Integer> levels = new Stack<>();
            levels.push(1);

            taskTable.getItems().get(0).setSlNo(printStack(levels));



            for (int i = 1; i < taskTable.getItems().size(); i++) {

                final Task task = taskTable.getItems().get(i);

                if (task.getLevel() == previousLevel) {
                    Integer pop = levels.pop();
                    levels.push(++pop);
                } else if (task.getLevel() > previousLevel) {
                    // add a new point
                    levels.push(1);
                } else {

                    for (int j=0;j<(previousLevel - task.getLevel());j++){
                        levels.pop();
                    }


                    Integer pop = levels.pop();
                    levels.push(++pop);
                }

                previousLevel = task.getLevel();

                task.setSlNo(printStack(levels));


            }

        }
    }

    private static String printStack(Stack<Integer> levels) {
        return levels.stream().map(String::valueOf).collect(Collectors.joining("."));
    }

}
