import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.ComicService;
import service.ComicServiceException;

import javax.xml.ws.WebServiceException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            ComicService.getInstance();
        } catch (WebServiceException e) {
            throw new ComicServiceException("Servicio web no disponible\n" + e.getMessage());
        }
        Parent root = FXMLLoader.load(getClass().getResource("view/main.fxml"));
        primaryStage.setTitle("Comics");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
