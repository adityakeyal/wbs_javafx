package com.adityak.wbs.factory;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.net.URL;

public class ImageCellView extends TableCell {



    @Override
    protected void updateItem(Object item, boolean empty) {

        if(!empty){
            URL resource = ImageCellView.class.getResource("notes.png");
            if (resource == null){
                resource = ImageCellView.class.getClassLoader().getResource("notes.png");

            }




            ImageView imageView = new ImageView(resource.toString());
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);

            final Popup popup = new Popup();


            this.setOnMouseEntered(x->{



                Point2D point2D = this.localToScreen(0, 0);


                popup.setX(point2D.getX()+20);
                popup.setY(point2D.getY()+20);


                VBox vbox = new VBox();
                Rectangle rectangle = new Rectangle(30, 30);
                rectangle.setFill(Paint.valueOf("#ffff88"));
                vbox.getChildren().add(rectangle);

                popup.getContent().addAll(vbox,new Label("Text"));
                popup.show(((Node)x.getSource()).getScene().getWindow());



            });

            this.setOnMouseExited(x->{
                System.out.println("Exit");
                popup.hide();
            });


            this.setOnMouseClicked( x->{
                System.out.println("1111");
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                Node source = (Node) x.getSource();
                Window theStage = source.getScene().getWindow();
                dialog.initOwner(theStage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("This is a Dialog"));
                final Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();

            } );


            this.setGraphic(imageView);

        }



    }
}
