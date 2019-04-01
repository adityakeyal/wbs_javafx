package com.adityak.wbs.controller;

import com.adityak.wbs.controller.keymap.AddNewRowStrategy;
import com.adityak.wbs.controller.keymap.DecreaseLevelStrategy;
import com.adityak.wbs.controller.keymap.IncreaseLevelStrategy;
import com.adityak.wbs.controller.keymap.TableKeyBindingStrategy;
import com.adityak.wbs.factory.ImageCellView;
import com.adityak.wbs.model.Task;
import com.adityak.wbs.repository.JsonFileRepository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller  implements Initializable{

    @FXML private TableView<Task> taskTable;

    @FXML private TableColumn taskCol;

    @FXML private TableColumn commentsCol;
    @FXML private TableColumn statusCol;
    @FXML private TableColumn jiraCol;


    private JsonFileRepository repo = new JsonFileRepository();






    public void processKeyPress(KeyEvent keyEvent) {


        if(keyEvent.getCode() == KeyCode.DOWN && keyEvent.isControlDown()){
            //add a new row
            //based on the selected row number
            TableKeyBindingStrategy tableKeyBindingStrategy = new AddNewRowStrategy();
            tableKeyBindingStrategy.process(this.taskTable,keyEvent);

        }
        else
            if(keyEvent.getCode() == KeyCode.TAB) {

                if(keyEvent.isShiftDown()){

                    TableKeyBindingStrategy tableKeyBindingStrategy = new DecreaseLevelStrategy();
                    tableKeyBindingStrategy.process(taskTable,keyEvent);

                }else{
                    TableKeyBindingStrategy tableKeyBindingStrategy = new IncreaseLevelStrategy();
                    tableKeyBindingStrategy.process(taskTable,keyEvent);
                }


            }


//        }

    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.taskTable.getSelectionModel().setCellSelectionEnabled(true);





        // switch to edit mode on keypress
        // this must be KeyEvent.KEY_PRESSED so that the key gets forwarded to the editing cell; it wouldn't be forwarded on KEY_RELEASED
        taskTable.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if( event.getCode() == KeyCode.ENTER) {
//                  event.consume(); // don't consume the event or else the values won't be updated;
                    return;
                }

                // switch to edit mode on keypress, but only if we aren't already in edit mode
                if( taskTable.getEditingCell() == null) {
                    if( event.getCode().isLetterKey() || event.getCode().isDigitKey()) {

                        TablePosition focusedCellPosition = taskTable.getFocusModel().getFocusedCell();
                        taskTable.edit(focusedCellPosition.getRow(), focusedCellPosition.getTableColumn());

                    }
                }

            }
        });

        taskTable.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if( event.getCode() == KeyCode.ENTER) {


                    // move focus & selection
                    // we need to clear the current selection first or else the selection would be added to the current selection since we are in multi selection mode
                    TablePosition pos = taskTable.getFocusModel().getFocusedCell();

                    if (pos.getRow() == -1) {
                        taskTable.getSelectionModel().select(0);
                    }
                    // add new row when we are at the last row
//                    else if (pos.getRow() == taskTable.getItems().size() -1) {
//                        addRow();
//                    }
                    // select next row, but same column as the current selection
                    else if (pos.getRow() < taskTable.getItems().size() -1) {
                        taskTable.getSelectionModel().clearAndSelect( pos.getRow() + 1, pos.getTableColumn());
                    }


                }

            }
        });



        this.jiraCol.setCellFactory(p -> new HyperlinkConverter(p));




        this.taskCol.setCellFactory(param -> new MyConverter<Object,String>((TableColumn) param));

        Callback<TableColumn<Object, String>, TableCell<Object, String>> tableColumnTableCellCallback = ComboBoxTableCell.forTableColumn("OPEN", "WIP", "CLOSED");
        this.statusCol.setCellFactory(tableColumnTableCellCallback);



        this.commentsCol.setCellFactory(x-> new ImageCellView());


        //load the saved rows
        List<Task> retrieve = repo.retrieve();
        taskTable.getItems().addAll(retrieve);



    }

    public void addNewRow(ActionEvent actionEvent) {

        TableKeyBindingStrategy tableKeyBindingStrategy = new AddNewRowStrategy();
        tableKeyBindingStrategy.process(this.taskTable,null);
    }

    public void save(ActionEvent actionEvent) {
        repo.save(this.taskTable.getItems());
    }

    public void deleteRow(ActionEvent actionEvent) {
        Task remove = this.taskTable.getItems().remove(this.taskTable.getSelectionModel().getSelectedIndex());


    }


    public static class MyConverter<S,T> extends TextFieldTableCell<S,T>{
    public MyConverter() {
                super((StringConverter<T>) new DefaultStringConverter());
            }

            private TableColumn param;



    public MyConverter(TableColumn param) {
                this();

                this.param = param;

            }


            @Override
            public void updateItem(T item, boolean empty) {

                super.updateItem((T)String.valueOf(item).trim(), empty);

                int currentIndex = indexProperty()
                        .getValue() < 0 ? 0
                        : indexProperty().getValue();


                if(currentIndex < this.param
                        .getTableView().getItems().size()){
                    int level = ((Task)this.param
                            .getTableView().getItems()
                            .get(currentIndex)).getLevel();

                    setPadding(new Insets(0 , 0, 0, level*10 + 5));
                }

            }



}
}