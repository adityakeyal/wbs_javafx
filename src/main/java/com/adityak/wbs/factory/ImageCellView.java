package com.adityak.wbs.factory;

import com.adityak.wbs.model.Task;
import com.sun.javafx.css.Style;
import de.jensd.fx.glyphs.GlyphIcons;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.octicons.OctIcon;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;


import java.net.URL;

public class ImageCellView extends TableCell {



    @Override
    protected void updateItem(Object item, boolean empty) {

        if(!empty){
            URL resource = ImageCellView.class.getResource("notes.png");
            if (resource == null){
                resource = ImageCellView.class.getClassLoader().getResource("notes.png");

            }



            boolean isCommentsPresent = item!=null && !String.valueOf(item).trim().isEmpty();




            final Popup popup = new Popup();


/*
            if(isCommentsPresent){
                this.setOnMouseEntered(x->{
                    Point2D point2D = this.localToScreen(0, 0);
                    popup.setX(point2D.getX()+20);
                    popup.setY(point2D.getY()+20);
                    VBox vbox = new VBox();
                    Rectangle rectangle = new Rectangle(30, 30);
                    rectangle.setFill(Paint.valueOf("#ffff88"));
                    vbox.getChildren().add(rectangle);
                    popup.getContent().addAll(vbox,new Label(String.valueOf(item)));
                    popup.show(((Node)x.getSource()).getScene().getWindow());
                });

                this.setOnMouseExited(x->{
                    popup.hide();
                });
            }
*/


            this.setOnMouseClicked( x->{
                final Stage dialog = new Stage();
                dialog.initModality(Modality.NONE);
                dialog.setTitle("Comments");
                dialog.setIconified(false);
                dialog.initStyle(StageStyle.UNDECORATED);
                Node source = (Node) x.getSource();
                Window theStage = source.getScene().getWindow();
                dialog.initOwner(theStage);
                VBox dialogVbox = new VBox(0);
                dialogVbox.setAlignment(Pos.TOP_RIGHT);
                final TextArea textArea = new TextArea();

                EventHandler<? super KeyEvent> eventHandler = (EventHandler<KeyEvent>) event -> {
                    final Task task =(Task) getTableView().getItems().get(getTableRow().getIndex());
                    task.setComments(textArea.getText());
                };

                textArea.setText(String.valueOf(item));

//                VBox.setMargin(textArea,new Insets(10,0,0,0));

                textArea.setOnKeyReleased( eventHandler);
                //textArea.setPadding(new Insets(20,20,0,0));
                final Text timesIcon = GlyphsDude.createIcon(FontAwesomeIcon.CHECK,"20px");
                timesIcon.setOnMouseClicked( z-> dialog.close());
                timesIcon.setTextAlignment(TextAlignment.RIGHT);
                timesIcon.setFill(Paint.valueOf("#11ff11"));
                dialogVbox.getChildren().addAll(timesIcon,textArea);
                final Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            } );


            final Text icon = GlyphsDude.createIcon(FontAwesomeIcon.STICKY_NOTE,"20px");
            if(isCommentsPresent){
                icon.setFill(Paint.valueOf("#FEFEA4"));
                icon.setStroke(Paint.valueOf("#4A2C2C"));
            }else{
                icon.setFill(Paint.valueOf("#dedede"));
                icon.setStroke(Paint.valueOf("#121212"));
            }
            this.setGraphic(icon);

        }



    }
}
