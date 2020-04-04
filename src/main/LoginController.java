package main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController extends Controller {

  @FXML
  private TextField tf_userName;

  @FXML
  private TextField tf_passWord;

  @FXML
  void clk_login(ActionEvent event) {
    // should validate password and login
    changeScene(getView("MainScreen.fxml"), tf_userName);
  }

  @FXML
  void initialize()
  {
    tf_userName.setText("SomeUsername");
    tf_passWord.setText("UsersPassword");
  }
}
