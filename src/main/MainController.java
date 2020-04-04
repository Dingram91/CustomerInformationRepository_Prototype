package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainController extends Controller{

  @FXML
  private TableView<Company> tv_company;

  @FXML
  private TableColumn<?, ?> tc_company;

  @FXML
  public void initialize()
  {

    // associate table column
    tc_company.setCellValueFactory(new PropertyValueFactory<>("name"));

    // add some example companies
    ArrayList<Company> companies = new ArrayList<>();
    for(int i = 0; i < 10; i++)
    {
      Company company = new Company("Company" + i, "Description for company" + i, "123 Spooned Street, Naples FL");
      company.setMapImage("mapLocation.PNG");

      // add a random number of files
      Random rand = new Random();
      int numberOfFiles = rand.nextInt(5);
      for(int n = 0; n < numberOfFiles; n++)
      {
        CompanyFile file = new CompanyFile();
        file.name = rand.nextInt(200) + ".txt";
        company.files.add(file);
      }

      companies.add(company);
    }

    for(Company company : companies)
    {
      tv_company.getItems().add(company);
    }


  }



  @FXML
  void clk_viewDetails(ActionEvent event) {
    if(tv_company.getSelectionModel().getSelectedItem() != null)
    {
      Stage window = (Stage) tv_company.getScene().getWindow();
      FXMLLoader loader = new FXMLLoader(MainController.class.getResource("DetailsView.fxml"));
      try {
        Parent parent = loader.load();
        DetailsController detailsController = loader.getController();

        // set the company field in the details controller
        detailsController.setCompany(tv_company.getSelectionModel().getSelectedItem());

        Scene detailsScene = new Scene(parent);

        window.setScene(detailsScene);

      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }

}
