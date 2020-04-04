package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetailsController extends Controller {

  Company company;


  @FXML
  private Label lbl_name;

  @FXML
  private ImageView iv_image;

  @FXML
  private TextArea ta_description;

  @FXML
  private TextArea ta_location;

  @FXML
  private TableView<CompanyFile> tv_files;

  @FXML
  private TableColumn<?, ?> tc_file;


  @FXML
  void goBack(ActionEvent event) {

    changeScene(getView("MainScreen.fxml"), lbl_name);

  }



  public void setCompany(Company company) {
    tc_file.setCellValueFactory(new PropertyValueFactory<>("name"));

    this.company = company;
    lbl_name.setText(company.name);
    ta_description.setText(company.description);
    ta_location.setText(company.location);

    if(company.mapImage != null)
    {
      iv_image.setImage(new Image(String.valueOf(getClass().getResource("mapLocation.PNG"))));
    }


    for (CompanyFile companyFile: company.files)
    {
      tv_files.getItems().add(companyFile);
      System.out.println(companyFile.name);
    }

  }



}
