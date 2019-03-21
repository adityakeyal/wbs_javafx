/**
 */
package sample.factory;

import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import sample.Task;

/**

 */
public class EditingCell extends TableCell<Task,String> {

    private TextField textField;


    @Override
    public void startEdit() {
        super.startEdit();
        System.out.println("In Start Edit");
    }


}
