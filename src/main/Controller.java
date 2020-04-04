package main;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

  void changeScene(URL nextScene, Node someNode) {

    // reference to the current scene
    Stage window = (Stage) someNode.getScene().getWindow();

    FXMLLoader loader = new FXMLLoader(nextScene);
    try {
      Parent sceneParent = loader.load();
      Scene newScene = new Scene(sceneParent);
      window.setScene(newScene);


    } catch (IOException e) {
      e.printStackTrace();
    }

  }



  protected URL getView(String name)
  {
    return Controller.class.getResource(name);
  }
}
