package com.example.ahhhokay.mapStuff;

import com.example.ahhhokay.controls.ObjectId;
import com.example.ahhhokay.models.Player;
import com.example.ahhhokay.rendering.Renderer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FirstMap implements MapHandler{
    double x = 36;
    double y = 36;

    // FOR NOW GIDECLARE LANG SA IF MAG ADD UG MORE MAPS IPUT NI SHAS CONSTRUCTOR width,height, ug size;
    int mapWidth = 1440;
    int mapHeight = 512;
    int tileSize = 16;
    int numRows = mapWidth/tileSize;
    int numCols = mapHeight/tileSize;
//    private /*Entity*/ Player player = new Player/*Entity*/(new Image(getClass().getResourceAsStream("/img/hutao_uwu.png")), ObjectId.PLAYER);

    @Override
    public Group loadMap(String filePath, double sceneWidth,double sceneHeight) {
        try {
//          FOR PARSING THE TMX TURN IT INTO SOMETHING READABLE BY TURNING IT TO A DOCUMENT??
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(filePath));
//            System.out.println(doc);

            doc.getDocumentElement().normalize();
            Group root = new Group();
            NodeList layerNodes = doc.getElementsByTagName("layer");

//          THIS IS SIMILAR TO SOMETHING LIKE GETELEMENTBYID

            for(int i=0;i< layerNodes.getLength();i++ ){
                Element layerElement = (Element) layerNodes.item(i);
                NodeList dataNodes = layerElement.getElementsByTagName("data");
//              CHECKS EACH LAYER AND OPENS THE DATA THEN SEPARATES EACH ELEMENT OF THE DATA SEPARATED BY A COMMA
//              FOR THE TILES ETC
                if(dataNodes.getLength() > 0){
                    Element dataElement = (Element) dataNodes.item(0);
                    String[] tileIds = dataElement.getTextContent().trim().split(",");
//                    System.out.println(tileIds.length+" ids nudes uwuw");

                    for(int tileIndex=0; tileIndex<tileIds.length;tileIndex++){
                        int tileId = Integer.parseInt(tileIds[tileIndex].trim());
                        int row = tileIndex / (mapWidth/tileSize);
                        int col = tileIndex % (mapWidth/tileSize);

                        double tileX = col*tileSize;
                        double tileY = row*tileSize;
                        Rectangle tile = new Rectangle(tileX, tileY,tileSize,tileSize);
                        switch(tileId){
                            case 0:
                                tile.setFill(Color.BLUE);
                                break;
                            case 129:
                                tile.setFill(Color.GREEN);
                                break;
                            case 146:
                                tile.setFill(Color.GRAY);
                                break;
                            case 124:
                                tile.setFill(Color.WHITE);
                                break;
                            case 18:
//                                tile.setFill(Color.PINK);
//                                AnchorPane loader = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
//
//                                root.getChildren().add(loader);

                                break;
                            case 20:
                                tile.setFill(Color.YELLOW);
                                break;
                            case 163:
                                tile.setFill(Color.BROWN);
                                break;
                        }
                        root.getChildren().add(tile);


                    }
                }
            }

            return root;
        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
            System.out.println("WALA NAKITA ANG FILE");
        } catch ( SAXException e) {
//            System.out.println("WALA NAKITA ANG FILE");
        }catch (IOException e){
            System.out.println("uwu");
        }

        return null;
    }
}
