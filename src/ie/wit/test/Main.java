package ie.wit.test;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*In order to use JavaFX, the class containing the main method must be a subclass of the
* Application class. This class must also implement the EventHandler interface to deal
* with button clicks.*/
public class Main extends Application implements EventHandler<ActionEvent>
{
    Button button01;
    Button button02;
    Button button03;
    VBox layout;
    Scene scene;
    Stage window;
    public static void main(String[] args)
    {
        /*This will be called first. This is a method in the Application class that
        * will set up this project as a JavaFX project. Once the program has been
        * set up as a JavaFX application, the start() method will be called*/
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("My App");

        button01 = new Button();
        button01.setText("Click me!");
        button02 = new Button("Click me too!");
        button03 = new Button("Me Three!");
        /*This tells the program that the handler for this button
        * is in this class.*/
        button01.setOnAction(this);
        /*This calls an Anonymous Inner Class to deal with the button click.
        * If using an anonymous inner class, it is not necessary to implement
        * the EventHandler interface. This also removes the need t ocheck the
        * source of the event*/
        button02.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Button two clicked!");
            }
        });

        button03.setOnAction(event -> System.out.println("I'm a lambda!"));
        layout = new VBox();
        layout.getChildren().addAll(button01, button02, button03);

        scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == button01){
            System.out.println("Button clicked");
        }
    }
}
