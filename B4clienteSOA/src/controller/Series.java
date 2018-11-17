package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import service.SerieService;
import ws.Serie;

import java.net.URL;
import java.util.ResourceBundle;

public class Series implements Initializable {

    @FXML
    public TableView<Serie> seriesTable;
    @FXML
    private TextField nombre;
    @FXML
    private ComboBox puntuacion;
    @FXML
    private TextField autor;
    @FXML
    private TableView vinietasTable;
    @FXML
    private TableColumn colVId;
    @FXML
    private TableColumn colVFecha;
    @FXML
    private TableColumn colVNombre;
    @FXML
    private TableColumn<Serie, Integer> colSerieId;
    @FXML
    private TableColumn<Serie, String> colNombre;
    @FXML
    private TableColumn<Serie, Integer> colPuntuacion;
    @FXML
    private TableColumn<Serie, String> colAutor;
    @FXML
    private TableColumn<Serie, Boolean> colEditar;
    
    private SerieService serieService = SerieService.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setColumnProperties();
        reloadSeries();
    }

    private void setColumnProperties() {
        colSerieId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEditar.setCellFactory(cellFactory);
    }

    public void reloadSeries() {
        seriesTable.getItems().setAll(serieService.findAll());
    }

    public void saveSerie(ActionEvent actionEvent) {
        Serie s = new Serie();
        s.setNombre(nombre.getText());
        s.setPuntuacion(Integer.valueOf((String) puntuacion.getValue()));
        s.setAutor(autor.getText());
        serieService.create(s);
        reloadSeries();
    }

    Callback<TableColumn<Serie, Boolean>, TableCell<Serie, Boolean>> cellFactory =
            new Callback<TableColumn<Serie, Boolean>, TableCell<Serie, Boolean>>() {
                @Override
                public TableCell<Serie, Boolean> call(final TableColumn<Serie, Boolean> param) {
                    final TableCell<Serie, Boolean> cell = new TableCell<Serie, Boolean>() {
                        Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
                        final Button btnEdit = new Button();

                        @Override
                        public void updateItem(Boolean check, boolean empty) {
                            super.updateItem(check, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btnEdit.setOnAction(e -> {
                                    Serie user = getTableView().getItems().get(getIndex());
                                    updateSerie(user);
                                });

                                btnEdit.setStyle("-fx-background-color: transparent;");
                                ImageView iv = new ImageView();
                                iv.setImage(imgEdit);
                                iv.setPreserveRatio(true);
                                iv.setSmooth(true);
                                iv.setCache(true);
                                btnEdit.setGraphic(iv);

                                setGraphic(btnEdit);
                                setAlignment(Pos.CENTER);
                                setText(null);
                            }
                        }

                        private void updateSerie(Serie serie) {/*
                            serieId.setText(Long.toString(user.getId()));
                            firstName.setText(user.getFirstName());
                            lastName.setText(user.getLastName());
                            dob.setValue(user.getDob());
                            if(user.getGender().equals("Male")) rbMale.setSelected(true);
                            else rbFemale.setSelected(true);
                            cbRole.getSelectionModel().select(user.getRole());
                            */
                        }
                    };
                    return cell;
                }
            };
}
