package sample;

import domain.Gender;
import domain.Greeting;
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

    private AnimalFactory animalFactory = new AnimalFactory();

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

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

    public void onActionAddProduct(ActionEvent actionEvent){
        String name = tfProductName.getText();
        String price =tfProductPrice.getText();
        int pp = Integer.parseInt(price);
        Double p2 = Double.parseDouble(price);
        Product p = new Product(name, p2);
        webshop.addProducts(p);

//        restShizzle(name, pp);
        restProduct(p);
    }

    public void restShizzle(String s, int i){
        SimpleRestClient client = new SimpleRestClient();
        final String key = s;
        final int age = i;

        //Post new product
        Greeting greeting = client.postGreeting(new Greeting(key, age));
        logGreeting(greeting);

        //Get a greeting
        greeting = client.getGreeting(key);
        logGreeting(greeting);
    }

    public void restProduct(Product p){
        SimpleRestClient client = new SimpleRestClient();

        //Post new product
//      Product product = client.postProduct(new Product(key, Double.parseDouble(price)));
        Product product = client.postProduct(p);
        logProduct(product);

        //Get a product
        product = client.getProduct(p.getName());
        logProduct(product);
    }

    public static void logGreeting(Greeting greeting){
        if(greeting != null){
            log.info("{} {}", greeting.getName(), greeting.getAge());
        } else {
            log.info("No greeting found.");
        }
    }
    public static void logProduct(Product product){
        if(product != null){
            log.info("{} {}", product.getName(), product.getPrice());
        } else {
            log.info("No product found.");
        }
    }

    public void OnClickAddAnimal(ActionEvent actionEvent) {
        if (checkFields()){
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

    private void refreshControls()    {
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


        if (species.equals("Cat") && tfName.getText().isEmpty() == false && tfBadHabits.getText().isEmpty() == false)  {
            if(rbFemale.isSelected() || rbMale.isSelected()){
                return true;
            }
        }
        if (species.equals("Dog") && tfName.getText().isEmpty() == false) {
            if(rbFemale.isSelected()|| rbMale.isSelected()){
                return true;
            }
        }
        return false;
    }

    public void OnActionSpecies(ActionEvent actionEvent) {
        if (cbSpecies.getSelectionModel().isSelected(0)){
            tfBadHabits.setEditable(true);
        }
        else{
            tfBadHabits.setEditable(false);
            tfBadHabits.clear();
        }

    }

    public void OnClickedListView(MouseEvent mouseEvent) {
//        tfReservorName.setEditable(true);
//        btnReserveAnimal.setDisable(false);
    }

}
