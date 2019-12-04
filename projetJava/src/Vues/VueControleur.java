package Vues;

import Modeles.Case;
import Modeles.Chemin;
import Modeles.Grille;
import Modeles.Modele;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        
        GridPane mainPane = new GridPane();

        // gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
        BorderPane border = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();

        //Text[][] tabText = new Text[5][5];
        Case[][] grille = new Case[5][5];
        
        Grille grid = new Grille(grille);
        
        ImageView[][] grilleImgv = new ImageView[5][5];
        

        Text affichage = new Text("Puzzle");
        affichage.setFont(Font.font("Verdana", 30));
        affichage.setFill(Color.RED);
        border.setTop(affichage);

        // la vue observe les "update" du modèle, et réalise les mises à jour graphiques
      
        Chemin chemin = new Chemin(grille);
        
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
                
                grilleImgv[row][column]= t ;
                
                Case c = new Case(t, row, column);
                
                
                  c.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                
                Case laCase = (Case)o;
                
                grilleImgv[laCase.getX()][laCase.getY()].setImage(new Image (this.getClass().getResource(laCase.getRessource()).toExternalForm()));
                System.out.println(" update de l'image");
                
               
                }
                
        });
                
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
                
                
                

                gPane.add(grille[row][column].getImgv(), column, row);
            }
        }
        
          grid.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                Grille leGrille = (Grille)o ;
                
                System.out.print("test7");
                
               
                }
                
        });
        
        grid.createPuzzle(); 

        gPane.setGridLinesVisible(true);
        
          Button effacer = new Button("effacer");
        effacer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                grid.clean();
                
                event.consume();
            }
        });
        mainPane.add(effacer, 0, 1);

        mainPane.add(gPane, 0, 0);
        
        border.setCenter(mainPane);

        Scene scene = new Scene(border, Color.LIGHTBLUE);
        
      
        
       

        primaryStage.setTitle("puzzle");
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
