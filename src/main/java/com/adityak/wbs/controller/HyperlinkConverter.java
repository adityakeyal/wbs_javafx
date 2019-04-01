package com.adityak.wbs.controller;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.converter.DefaultStringConverter;

public class HyperlinkConverter<S> extends TextFieldTableCell<S,String> {

    final Text icon = GlyphsDude.createIcon(FontAwesomeIcon.EXTERNAL_LINK);



    public HyperlinkConverter(Object param) {
        super(new DefaultStringConverter());
        setEditable(true);

        icon.setOnMouseClicked(x->{


        });
        icon.setCursor(Cursor.HAND);
        setGraphic(icon);
        setTextAlignment(TextAlignment.LEFT);
        setGraphicTextGap(10);
        setContentDisplay(ContentDisplay.RIGHT);

}


    @Override
    public void cancelEdit() {
        super.cancelEdit();

        if(getItem()!=null && !getItem().trim().isEmpty()){
            setGraphic(icon);
        }

    }

    @Override
    public void updateItem(String item, boolean empty) {



        super.updateItem(item, empty);

        if(getItem()!=null && !getItem().trim().isEmpty()){
            setGraphic(icon);


        }

    }
}
