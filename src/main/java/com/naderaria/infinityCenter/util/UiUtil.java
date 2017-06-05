package com.naderaria.infinityCenter.util;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by NaderAria on 5/25/2017.
 */
public class UiUtil {

    public static void setControlDefaultUi( Control control ){

        control.setPrefSize( 120 , 20 );
        control.setPadding( new Insets(2) );
    }

    public static void setControlDefaultUi( Control control , String toolTip ){

        control.setPrefSize( 200 , 20 );
        control.setPadding( new Insets(2) );
        control.setTooltip( new Tooltip( toolTip ) );

    }

    public static void setControlDefaultUi( Control control , String toolTip , boolean active ){

        control.setPrefSize( 200 , 20 );
        control.setPadding( new Insets(2) );
        control.setTooltip( new Tooltip( toolTip ) );
        control.setDisable( active );

    }

    public static Map<Node,Node> createNewRecordFromNodes(Node nodeOne , Node nodeTwo ){

        Map<Node,Node> nodes = new HashMap<>();
        nodes.put( nodeOne , nodeTwo );
        return nodes;
    }

    public static TitledPane getTitledPane(String title , SortedMap<Integer,Map<Node,Node>> nodes ){

        TitledPane titledPane =new TitledPane();
        titledPane.setText( title );
        VBox elements = new VBox();
        elements.setPadding(new Insets(2) );
        elements.setFillWidth(true);
        elements.setPrefSize( 400 , 180 );
        for(Map.Entry<Integer,Map<Node,Node>> entry : nodes.entrySet() ){

            for( Map.Entry<Node,Node> n : entry.getValue().entrySet() ){
                elements.getChildren().add( getHorizontalElements( n.getKey(), n.getValue() ));
            }


        }
        titledPane.setContent( elements );
        titledPane.setAlignment( Pos.BASELINE_LEFT );
        titledPane.setPadding(new Insets(4) );
        titledPane.setCollapsible( false );
        return titledPane;
    }

    public static HBox getHorizontalElements(Node... elements){

        HBox hBox = new HBox();
        hBox.setPadding( new Insets(2) );
        hBox.setSpacing( 5 );
        hBox.setAlignment( Pos.BASELINE_LEFT );
        hBox.getChildren().addAll(elements);
        return hBox;
    }

    public static void setActiveState( Node n , boolean active ){

        n.setDisable( active );
    }

    public static void setActiveState( List<Node> nodes ,boolean active ){

        for( Node n : nodes ){
            n.setDisable( active );
        }
    }

    public static Calendar convertFxDateToCalendar(DatePicker datePicker ){

        LocalDate localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        return calendar;
    }

    public static byte[] extractToBytes ( Image image ) throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage( image , null);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", s);
        byte[] imageArray  = s.toByteArray(); //new byte[ s.toByteArray().length ];
        s.close();
        return imageArray;
    }
}
