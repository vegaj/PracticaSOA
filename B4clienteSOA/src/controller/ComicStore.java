package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import service.ComicService;
import ws.Serie;
import ws.Vinieta;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

public class ComicStore implements Initializable {

    //La anotacion @FXML conecta elementos de la vista cuya id es igual al nombre de la variable en el controlador
    @FXML
    private Button editVinieta;
    @FXML
    private DatePicker selectedVFecha;
    @FXML
    private ComboBox<Integer> selectedVPuntuacion;
    @FXML
    private TextField selectedVNombre;
    @FXML
    private TextField selectedVId;
    @FXML
    private VBox editVinietaPanel;
    @FXML
    private VBox editSeriePanel;
    @FXML
    private Button editSerie;
    @FXML
    private TextField selectedAutor;
    @FXML
    private ComboBox<Integer> selectedSeriePuntuacion;
    @FXML
    private TextField selectedSerieNombre;
    @FXML
    private TextField selectedSerieID;
    @FXML
    private Label seriesLabel;
    @FXML
    private TableView<Serie> seriesTable;
    @FXML
    private Label currentSerieLabel;
    @FXML
    private TextField nombre;
    @FXML
    private ComboBox<Integer> puntuacion;
    @FXML
    private TextField autor;
    @FXML
    private TableView<Vinieta> vinietasTable;
    @FXML
    private TableColumn<Vinieta, Integer> colVId;
    @FXML
    private TableColumn<Vinieta, XMLGregorianCalendar> colVFecha;
    @FXML
    private TableColumn<Vinieta, String> colVNombre;
    @FXML
    private TableColumn<Vinieta, Integer> colVPuntuacion;
    @FXML
    private TableColumn<Serie, Integer> colSerieId;
    @FXML
    private TableColumn<Serie, String> colNombre;
    @FXML
    private TableColumn<Serie, Integer> colPuntuacion;
    @FXML
    private TableColumn<Serie, String> colAutor;

    private ComicService comicService = ComicService.getInstance();

    /**
     * Funcion llamada al iniciar el servicio
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeView();
        reloadSeries();
    }

    /**
     * Guardar nueva serie en el servicio web y actualizacion de la vista
     */
    public void saveSerie(ActionEvent actionEvent) {
        Serie s = new Serie();
        s.setNombre(nombre.getText());
        s.setPuntuacion(puntuacion.getValue());
        s.setAutor(autor.getText());
        comicService.createSerie(s);
        reloadSeries();
    }

    /**
     * Modificar serie en servicio web y actualizacion de la vista
     */
    public void editSerie(ActionEvent actionEvent) {
        Serie s = new Serie();
        s.setId(Integer.valueOf(selectedSerieID.getText()));
        s.setNombre(selectedSerieNombre.getText());
        s.setPuntuacion(selectedSeriePuntuacion.getValue());
        s.setAutor(selectedAutor.getText());
        comicService.editSerie(s);
        editSeriePanel.setVisible(false);
        reloadSeries();
    }

    /**
     * Borrar serie en servicio web y actualizacion de la vista
     */
    public void deleteSerie(ActionEvent actionEvent) {
        Serie s = comicService.findSerie(Integer.valueOf(selectedSerieID.getText()));
        comicService.removeSerie(s);
        reloadSeries();
        editSeriePanel.setVisible(false);
    }

    /**
     * Editar viñeta en servicio web y actualizacion de la vista
     */
    public void editVinieta(ActionEvent actionEvent) throws DatatypeConfigurationException {

        //Nueva viñeta con datos actualizados
        Vinieta v = comicService.findVinieta(Integer.valueOf(selectedVId.getText()));
        v.setNombre(selectedVNombre.getText());
        v.setPuntuacion(selectedVPuntuacion.getValue());
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Date.from(selectedVFecha.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        v.setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        //Editar en servicio web
        comicService.editVinieta(v);
        editVinietaPanel.setVisible(false);
        reloadSelectedVinieta(v);
    }

    /**
     * Borrar viñeta en servicio web y actualizacion de la vista
     */
    public void deleteVinieta(ActionEvent actionEvent) {
        //Delete en servicio web
        Vinieta v = comicService.findVinieta(Integer.valueOf(selectedVId.getText()));
        comicService.removeVinieta(v);
        editVinietaPanel.setVisible(false);
        removeSelectedVinieta();
    }

    /**
     * Actualizacion del panel de editar serie
     */
    private void updateSelectedSerie(Serie selected) {
        selectedSerieID.textProperty().set(selected.getId().toString());
        selectedSerieNombre.textProperty().set(selected.getNombre());
        selectedSeriePuntuacion.getSelectionModel().select(selected.getPuntuacion());
        selectedAutor.textProperty().set(selected.getAutor());
        editSeriePanel.setVisible(true);
    }


    /**
     * Actualizacion del panel de editar viñeta
     */
    private void updateSelectedVinieta(Vinieta clickedRow) {
        selectedVId.textProperty().set(clickedRow.getId().toString());
        selectedVNombre.textProperty().set(clickedRow.getNombre());
        selectedVPuntuacion.getSelectionModel().select(clickedRow.getPuntuacion());
        selectedVFecha.setValue(LocalDate.of(clickedRow.getFecha().getYear(), clickedRow.getFecha().getMonth(), clickedRow.getFecha().getDay()));
        editVinietaPanel.setVisible(true);
    }

    /**
     * Elimina una viñeta con datos antiguos y añade la viñeta actualizada en la tabla de viñetas
     */
    private void reloadSelectedVinieta(Vinieta v) {
        removeSelectedVinieta();
        vinietasTable.getItems().add(v);
    }

    /**
     * Elimina la viñeta seleccionada en la tabla de viñetas
     */
    private void removeSelectedVinieta() {
        Vinieta selectedItem = vinietasTable.getSelectionModel().getSelectedItem();
        vinietasTable.getItems().remove(selectedItem);
    }


    /**
     * Carga todas las series disponibles
     */
    private void reloadSeries() {
        loadSeries(comicService.findAllSeries());
    }

    /**
     * Carga una lista de series en la tabla de series
     */
    private void loadSeries(List<Serie> series) {
        seriesTable.getItems().setAll(series);
    }

    /**
     * Carga la lista de viñetas correspondientes a una serie en la tabla de viñetas
     */
    private void loadVinietas(Serie serie) {
        vinietasTable.getItems().setAll(comicService.searchVinietasBySerie(serie));
    }

    /**
     * Actualiza el label de la tabla de viñetas y carga las viñetas correspondientes
     */
    private void updateVinietasPanel(Serie selected) {
        currentSerieLabel.setText(selected.getNombre());
        loadVinietas(selected);
    }

    /**
     * Inicializa la vista, añade funcionalidades a los elementos de la vista
     */
    private void initializeView() {
        //Añade funcionalidad al hacer click en una fila
        seriesTable.setRowFactory(tr -> {
            TableRow<Serie> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Serie clickedRow = row.getItem();
                    updateSelectedSerie(clickedRow);
                    updateVinietasPanel(clickedRow);
                }
            });
            return row;
        });
        vinietasTable.setRowFactory(tr -> {
            TableRow<Vinieta> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Vinieta clickedRow = row.getItem();
                    updateSelectedVinieta(clickedRow);
                }
            });
            return row;
        });

        //Adaptador entre las entidades y las columnas de las tablas
        colSerieId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colVId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colVNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colVPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        colVFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colVFecha.setCellFactory((column -> new TableCell<Vinieta, XMLGregorianCalendar>() {
            private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

            @Override
            protected void updateItem(XMLGregorianCalendar item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.toGregorianCalendar() == null) {
                    setText(null);
                } else {
                    setText(format.format(item.toGregorianCalendar().getTime()));
                }
            }
        }));
        puntuacion.getSelectionModel().select(1);
    }

}
