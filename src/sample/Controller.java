package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_domicilio;
    @FXML
    private TextField txt_cuit;
    @FXML
    private TextField txt_dni;
    @FXML
    private TextField txt_precio;
    @FXML
    private TextField txt_total;
    @FXML
    private ComboBox cb_productos;
    @FXML
    private Button btn_agregar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private TableView<Cliente> tv_tabla;

    public double total = 0 ;

    @FXML
    ObservableList<String> Productos = FXCollections.observableArrayList("Cemente","Arena","Cal");


    public void initialize(){

        cb_productos.setItems(Productos);
        cb_productos.setValue("Cemento");
        cargarGrilla();

    }

    public void cargarGrilla(){
        TableColumn col1 = new TableColumn("Nombre");

        col1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        TableColumn col2 = new TableColumn("Domicilio");
        col2.setCellValueFactory(new PropertyValueFactory<>("Domicilio"));
        TableColumn col3 = new TableColumn("Cuit");
        col3.setCellValueFactory(new PropertyValueFactory<>("Cuit"));
        TableColumn col4 = new TableColumn("Dni");
        col4.setCellValueFactory(new PropertyValueFactory<>("Dni"));
        TableColumn col5 = new TableColumn("Precio");
        col5.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        TableColumn col6 = new TableColumn("Material");
        col6.setCellValueFactory(new PropertyValueFactory<>("Material"));

        tv_tabla.getColumns().addAll(col1,col2,col3,col4,col5,col6);
    }

    public void mostrarError(String msj){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error al cargar Producto");
        alert.setResizable(false);
        alert.setContentText(msj);
        alert.showAndWait();

    }

    public void cargarCliente(){

        if (txt_nombre.getText().length() < 4 ){
            mostrarError("El nombre debe contener mas de 4 caracteres");
            return;
        }
        if (txt_domicilio.getText().length() < 5 ){
            mostrarError("El domicilio no puede contener menos de 5 caracteres.");
            return;
        }

        if (!numero(txt_cuit.getText())){
            mostrarError("El cuit debe contener caracteres numericos");
            return;
        }

        if (!numero(txt_dni.getText())){
            mostrarError("El dni debe contener caracteres numericos");
            return;
        }




        //String nombre, String domicilio, String cuit, String dni, int precio, String material Datos del constructor para cargar mas comodo el objeto.
        Cliente cli1 = new Cliente(txt_nombre.getText(),txt_domicilio.getText(),Long.parseLong(txt_cuit.getText()),Long.parseLong(txt_dni.getText()),Integer.parseInt(txt_precio.getText()),cb_productos.getValue().toString());

        tv_tabla.getItems().add(cli1);

        txt_nombre.setDisable(true);
        txt_domicilio.setDisable(true);
        txt_dni.setDisable(true);
        txt_cuit.setDisable(true);

        total = total+Integer.parseInt(txt_precio.getText());
        txt_total.setText(String.valueOf(total));

    }

    private static boolean numero(String cadena){
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }






}
