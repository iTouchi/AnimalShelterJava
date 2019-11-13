package sample;

import com.AnimalShelterJava.WebsocketClient;
import domain.Gender;
import domain.animal.Animal;
import domain.managers.AnimalFactory;
import domain.managers.Webshop;
import domain.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ComboBox cbSpecies;
    public TextField tfName;
    public Label lbGender;
    public RadioButton rbMale;
    public RadioButton rbFemale;
    public TextField tfBadHabits;
    public Button btnAddAnimal;
    public Label lbAnimals;
    public ListView lvAnimals;
    public TextField tfReservorName;
    public Button btnReserveAnimal;
    public TextField tfProductName;
    public TextField tfProductPrice;
    public TextField tfSocketName;
    public TextField tfSocketAge;

    private AnimalFactory animalFactory = new AnimalFactory();

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    SimpleRestClient client = new SimpleRestClient();


    @FXML
    private ListView<Product> lvProducts;
    @FXML
//    private NumericTextField tfProductPrice;

    private Webshop webshop = new Webshop();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvAnimals.getItems().addAll(animalFactory.loadAnimals());
        tfBadHabits.setEditable(false);
        lvProducts.setItems(webshop.getProducts());


    }

    public void onActionAddProduct(ActionEvent actionEvent) {
        String name = tfProductName.getText();
        String stringPrice = tfProductPrice.getText();

        Double productPrice = Double.parseDouble(stringPrice);
        Product product = new Product(name, productPrice);

        webshop.addProducts(product);

        postProduct(product);
    }


    public void postProduct(Product p) {
        //Post Product
        Product product = client.postProduct(p);
        logProduct(product);

        //Get a product
        product = client.getProduct(p.getName());
        logProduct(product);
    }

    public static void logProduct(Product product) {
        if (product != null) {
            log.info("{} {}", product.getName(), product.getPrice());
        } else {
            log.info("No product found.");
        }
    }

    public void OnClickAddAnimal(ActionEvent actionEvent) {
        if (checkFields()) {
            this.createAnimal();
            this.refreshControls();
        }
    }

    public void OnActionAddReservor(ActionEvent actionEvent) {
        Animal animal = (Animal) lvAnimals.getSelectionModel().getSelectedItem();

        if (animal != null) {
            animal.reserve(tfReservorName.getText());
            this.refreshControls();
        }
    }

    public void OnActionRbMale(ActionEvent actionEvent) {
        rbFemale.setSelected(false);
    }

    public void OnActionRbFemale(ActionEvent actionEvent) {
        rbMale.setSelected(false);
    }

    private void refreshControls() {
        lvAnimals.getItems().clear();
        animalFactory.saveAnimals();
        animalFactory.loadAnimals();
        lvAnimals.getItems().addAll(animalFactory.getAnimals());
        tfBadHabits.clear();
        tfName.clear();
    }

    private void createAnimal() {

        String species = cbSpecies.getSelectionModel().getSelectedItem().toString();
        String name = tfName.getText();
        String badHabits = tfBadHabits.getText();
        Gender gender = getGender();


        if (species.equals("Cat")) {
            animalFactory.createCat(name, gender, badHabits);
        } else if (species.equals("Dog")) {
            animalFactory.createDog(name, gender);
        }
    }

    private Gender getGender() {
        if (rbFemale.isSelected()) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    public void onActionDelete(ActionEvent actionEvent) {
        Animal animal = (Animal) lvAnimals.getSelectionModel().getSelectedItem();

        if (animal != null) {
            animalFactory.deleteAnimal(animal);
            this.refreshControls();
        }
    }

    public boolean checkFields() {
        String species = cbSpecies.getSelectionModel().getSelectedItem().toString();


        if (species.equals("Cat") && tfName.getText().isEmpty() == false && tfBadHabits.getText().isEmpty() == false) {
            if (rbFemale.isSelected() || rbMale.isSelected()) {
                return true;
            }
        }
        if (species.equals("Dog") && tfName.getText().isEmpty() == false) {
            if (rbFemale.isSelected() || rbMale.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void OnActionSpecies(ActionEvent actionEvent) {
        if (cbSpecies.getSelectionModel().isSelected(0)) {
            tfBadHabits.setEditable(true);
        } else {
            tfBadHabits.setEditable(false);
            tfBadHabits.clear();
        }

    }

    public void OnClickedListView(MouseEvent mouseEvent) {
//        tfReservorName.setEditable(true);
//        btnReserveAnimal.setDisable(false);
    }

    public void onActionSockets(ActionEvent actionEvent) {
        String name = tfSocketName.getText();
        String stringAge = tfSocketAge.getText();
        int age = Integer.parseInt(stringAge);

        WebsocketClient websocketClient = new WebsocketClient();
        websocketClient.start(name,age);
    }
}
