package Vues;

import Modeles.Case;
import Modeles.Chemin;
import Modeles.Grille;
import Modeles.Modele;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class VueControleur extends Application {

    
    Modele m;
    

    @Override
    public void start(Stage primaryStage) {

        // initialisation du modèle que l'on souhaite utiliser
        m = new Modele();

        // gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
        BorderPane border = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();

        //Text[][] tabText = new Text[5][5];
        Case[][] grille = new Case[5][5];
        
        Grille grid = new Grille(grille);
        

        Text affichage = new Text("Grille Drag&Drop");
        affichage.setFont(Font.font("Verdana", 30));
        affichage.setFill(Color.RED);
        border.setTop(affichage);

        // la vue observe les "update" du modèle, et réalise les mises à jour graphiques
      
        Chemin chemin = new Chemin();
        
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {

                final int fColumn = column;
                final int fRow = row;

                // final Text t = new Text(" " + column + "-" + row + " ");
                
                // tabText[column][row] = t;
                
                
                // final Text t = new Text(grille[column][row].toString());
                // t.setFont(Font.font("Verdana", 25));
                
                Image img = new Image((getClass().getResource("caseVide.png").toExternalForm()));
                ImageView t  = new ImageView(img);
                t.setFitHeight(80);
                t.setFitWidth(80);
                
                Case c = new Case(t, row, column);
                
                
                
            //    grid.addCase(column, row, c);
                

                grille[row][column] = c ;
                
                t.setOnDragDetected(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {

                        Dragboard db = t.startDragAndDrop(TransferMode.ANY);
                        ClipboardContent content = new ClipboardContent();       
                        content.putString(""); // non utilisé actuellement
                        db.setContent(content);
                        event.consume();
                        chemin.startDD(fColumn, fRow);
                    }
                });

                t.setOnDragEntered(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                        
                        chemin.parcoursDD(fColumn, fRow);
                         grid.getSymbole(chemin);
                        event.consume();
                    }
                });
                
                t.setOnDragDone(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                        
                        // attention, le setOnDragDone est déclenché par la source du Drag&Drop
                        
                        chemin.stopDD(fColumn, fRow);
                        
                    }
                });
                
                
                  chemin.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                Chemin leChemin = (Chemin)o ;
                
                if(leChemin.isStopped() == true || leChemin.isStarted() == true)
                {
                   
                   
                }
                else
                {
                    
                   
                    
                }
                
        }});

                gPane.add(grille[row][column].getImgv(), column, row);
            }
        }

        gPane.setGridLinesVisible(true);

        border.setCenter(gPane);

        Scene scene = new Scene(border, Color.LIGHTBLUE);

        primaryStage.setTitle("Drag & Drop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
