package ie.wit.test;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*In order to use JavaFX, the class containing the main method must be a subclass of the
* Application class. This class must also implement the EventHandler interface to deal
* with button clicks.*/
public class Main extends Application implements EventHandler<ActionEvent>
{
    Button basicEventHandler;
    Button anonymousInnerClass;
    Button lambdaExpression;
    Button switchToScene02;
    Button switchToScene01;

    Label firstLabel;

    VBox verticalLayout;
    StackPane singleButtonLayout;

    Scene firstScene;
    Scene scene02;

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

        basicEventHandler = new Button();
        basicEventHandler.setText("Basic Handler");
        anonymousInnerClass = new Button("Anonymous Inner Class");
        lambdaExpression = new Button("Lambda");
        switchToScene02 = new Button("Go to scene two");
        switchToScene01 = new Button("Back to the first scene");

        firstLabel = new Label("This is the first scene");
        /*This tells the program that the handler for this button
        * is in this class.*/
        basicEventHandler.setOnAction(this);
        /*This calls an Anonymous Inner Class to deal with the button click.
        * If using an anonymous inner class, it is not necessary to implement
        * the EventHandler interface. This also removes the need to check the
        * source of the event*/
        anonymousInnerClass.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Button two clicked!");
            }
        });

        /*This is a lambda. It is shorthand for using the anonymous inner class above.
        * The reason that this works is because there is only one method in the EventHandler
        * interface. Java knows, by context, that this is the method that we want*/
        lambdaExpression.setOnAction(event -> {
            System.out.print("I'm a lambda!");
            System.out.println(" And you just clicked me!");
        });

        switchToScene02.setOnAction(event -> {
            window.setScene(scene02);
        });
        switchToScene01.setOnAction(event -> {
            window.setScene(firstScene);
        });
        verticalLayout = new VBox(20);
        verticalLayout.getChildren().addAll(firstLabel ,basicEventHandler, anonymousInnerClass, lambdaExpression, switchToScene02);
        singleButtonLayout = new StackPane();
        singleButtonLayout.getChildren().addAll(switchToScene01);

        firstScene = new Scene(verticalLayout, 300, 250);
        scene02 = new Scene(singleButtonLayout, 250, 200);

        window.setScene(firstScene);
        window.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == basicEventHandler){
            System.out.println("Button clicked");
        }
    }
}
