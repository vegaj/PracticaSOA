/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.xml.ws.WebServiceRef;
import ws.ComicWS_Service;
import ws.Serie;
import ws.Vinieta;

/**
 *
 * @author Félix
 */
@Named(value = "seriesBean")
@SessionScoped
public class ComicsBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ComicWS/ComicWS.wsdl")
    private ComicWS_Service service;

    /* VARIABLES SERIE */
    private Serie serie; 
    private List<Serie> series;
    private List<String> seriesAutor;
    private Serie serieEditada;
    private Integer idBuscar;
    private Serie serieBuscada;
    private String autorSeleccionado;
    private List<String> autores;
    private List<Integer> rango; //rango de findRange
    private Integer min; //minimo del rango de findRange
    private Integer max; //maximo del rango de findRange

    /* VARIABLES VINIETAS */
    private Vinieta vinieta;
    private Vinieta vinietaEditada;
    private List<Vinieta> vinietas;
    private String fecha; //fecha para buscar las viñetas
    private String fechaMin; //fecha minima para buscar viñetas entre dos fechas
    private String fechaMax; //fecha minima para buscar viñetas entre dos fechas
    private Integer serieBuscaVin;
    private List<Integer> rangoV; //rango de findRange
    private Integer minV; //minimo del rango de findRange
    private Integer maxV; //maximo del rango de findRange
    private Vinieta vinietaBuscada;
    private Integer idBuscarV;

    /**
     * Creates a new instance of SeriesBean
     */
    public ComicsBean() {
    }

    @PostConstruct
    public void init() {
        this.serie = new Serie();
        this.autores = findAutores();
    }

    /* GETTERS AND SETTERS */
    public String getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(String autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public Serie getSerieEditada() {
        return serieEditada;
    }

    public void setSerieEditada(Serie serieEditada) {
        this.serieEditada = serieEditada;
    }

    public Serie getSerieBuscada() {
        return serieBuscada;
    }

    public void setSerieBuscada(Serie serieBuscada) {
        this.serieBuscada = serieBuscada;
    }

    public Integer getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(Integer idBuscar) {
        this.idBuscar = idBuscar;
    }

    public List<Integer> getRango() {
        return rango;
    }

    public void setRango(List<Integer> rango) {
        this.rango = rango;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(String fechaMin) {
        this.fechaMin = fechaMin;
    }

    public String getFechaMax() {
        return fechaMax;
    }

    public void setFechaMax(String fechaMax) {
        this.fechaMax = fechaMax;
    }

    public List<Vinieta> getVinietas() {
        return vinietas;
    }

    public void setVinietas(List<Vinieta> vinietas) {
        this.vinietas = vinietas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Vinieta getVinieta() {
        return vinieta;
    }

    public void setVinieta(Vinieta vinieta) {
        this.vinieta = vinieta;
    }

    public Vinieta getVinietaEditada() {
        return vinietaEditada;
    }

    public void setVinietaEditada(Vinieta vinietaEditada) {
        this.vinietaEditada = vinietaEditada;
    }

    public Integer getSerieBuscaVin() {
        return serieBuscaVin;
    }

    public void setSerieBuscaVin(Integer serieBuscaVin) {
        this.serieBuscaVin = serieBuscaVin;
    }

    public Integer getMinV() {
        return minV;
    }

    public void setMinV(Integer minV) {
        this.minV = minV;
    }

    public Integer getMaxV() {
        return maxV;
    }

    public void setMaxV(Integer maxV) {
        this.maxV = maxV;
    }

    public List<Integer> getRangoV() {
        return rangoV;
    }

    public void setRangoV(List<Integer> rangoV) {
        this.rangoV = rangoV;
    }

    public Vinieta getVinietaBuscada() {
        return vinietaBuscada;
    }

    public void setVinietaBuscada(Vinieta vinietaBuscada) {
        this.vinietaBuscada = vinietaBuscada;
    }

    public Integer getIdBuscarV() {
        return idBuscarV;
    }

    public void setIdBuscarV(Integer idBuscarV) {
        this.idBuscarV = idBuscarV;
    }

    public List<String> getSeriesAutor() {
        return seriesAutor;
    }

    public void setSeriesAutor(List<String> seriesAutor) {
        this.seriesAutor = seriesAutor;
    }

    /* METODOS PARA PROBAR LOS SERVICIOS */
    public String nuevaSerie() {
        //redirige al formulario para introducir los datos de la serie
        return "nuevaSerie.xhtml";
    }

    public String crear() {
        //llama al servicio para insertar la serie en la BD
        createSerie(serie);
        // una vez se ha insertado se vuelve a inicializar para que se pueda volver a utilizar
        this.serie = new Serie();
        return "index.xhtml";
    }

    public String borrarSerie(Serie s) {
        //borra la serie de la base de datos
        removeSerie(s);
        return "index.xhtml";
    }

    public String editarSerie(Serie s) {
        //le pasa la serie seleccionada para editarla
        serieEditada = s;
        return "editarSerie.xhtml";
    }

    public String guardar() {
        //edita la serie seleccionada en la base de datos
        editSerie(serieEditada);
        return "index.xhtml";
    }

    public String mostrarSeries() {
        //recoge el listado de series para mostrarlas
        series = findAllSeries();
        return "listadoSeries.xhtml";
    }

    public String volver() {
        //vuelve a la pagina de index
        return "index.xhtml";
    }

    public String actualizarTabla() {
        //recoge las cinco primeras series con mayor puntuacion
        series = topFiveSeries();
        return "listadoSeries.xhtml";
    }

    public String buscarAutor() {
        //busca las series con el autor seleccionado
        seriesAutor = searchSerieByAutor(autorSeleccionado);
        return "seriesAutor.xhtml";
    }

    public Integer contar() {
        //cuenta el numero de series total
        return countSeries();
    }

    public String buscarSeriePorId() {
        String res = null;
        if (idBuscar > 0) {
            serieBuscada = findSerie(idBuscar);
            if (serieBuscada != null) {
                res = "mostrarSerieBuscada.xhtml";
            } else {
                res = "index.xhtml";
            }
        } else {
            res = "index.xhtml";
        }
        return res;
    }

    public String buscarSerieRango() {
        rango.add(min);
        rango.add(max);
        series = findRangeSeries(rango);
        return "listadoSeries.xhtml";
    }

    public String buscarVinietasEntreFechas() {
        vinietas = findVinietasBetweenDates(fechaMin, fechaMax);
        return "listadoVinietas.xhtml";
    }

    public String buscarVinietasByFecha() {
        vinietas = findVinietasByDate(fecha);
        return "listadoVinietas.xhtml";
    }

    public String nuevaVinieta() {
        return "nuevaVinieta.xhtml";
    }

    public String crearVinieta() {
        createVinieta(vinieta);
        vinieta = new Vinieta();
        return "index.xhtml";
    }

    public String editarVinieta(Vinieta v) {
        vinietaEditada = v;
        return "editarVinieta.xhtml";
    }

    public String guardarVinieta() {
        editVinieta(vinietaEditada);
        return "index.xhtml";
    }

    public String buscarVinietaPorId() {
        String res = null;
        if (idBuscarV > 0) {
            vinietaBuscada = findVinieta(idBuscarV);
            if (vinietaBuscada != null) {
                res = "mostrarVinietaBuscada.xhtml";
            } else {
                res = "index.xhtml";
            }
        } else {
            res = "index.xhtml";
        }
        return res;
    }

    public String buscarVinietaRango() {
        rangoV.add(minV);
        rangoV.add(maxV);
        vinietas = findRangeVinietas(rangoV);
        return "listadoVinietas.xhtml";
    }

    public String mostrarVinieta() {
        vinietas = findAllVinietas();
        return "listadoVinietas.xhtml";
    }

    public String borrarVinieta(Vinieta v) {
        removeVinieta(v);
        return "index.xhtml";
    }

    public String buscarVinietasBySerie() {        
        searchVinietaBySerie(serieBuscaVin);
        return "mostrarVinietaBuscada.xhtml";
    }

    /* OPERACIONES DE LOS SERVICIOS */
    private int countSeries() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.countSeries();
    }

    private int countVinietas() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.countVinietas();
    }

    private void createSerie(ws.Serie entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        port.createSerie(entity);
    }

    private void createVinieta(ws.Vinieta entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        port.createVinieta(entity);
    }

    private void editSerie(ws.Serie entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        port.editSerie(entity);
    }

    private void editVinieta(ws.Vinieta entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        port.editVinieta(entity);
    }

    private java.util.List<ws.Serie> findAllSeries() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findAllSeries();
    }

    private java.util.List<ws.Vinieta> findAllVinietas() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findAllVinietas();
    }

    private java.util.List<java.lang.String> findAutores() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findAutores();
    }

    private java.util.List<ws.Serie> findRangeSeries(java.util.List<java.lang.Integer> range) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findRangeSeries(range);
    }

    private java.util.List<ws.Vinieta> findRangeVinietas(java.util.List<java.lang.Integer> range) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findRangeVinietas(range);
    }

    private Serie findSerie(java.lang.Object id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findSerie(id);
    }

    private Vinieta findVinieta(java.lang.Object id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findVinieta(id);
    }

    private java.util.List<ws.Vinieta> findVinietasBetweenDates(java.lang.String from, java.lang.String to) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findVinietasBetweenDates(from, to);
    }

    private java.util.List<ws.Vinieta> findVinietasByDate(java.lang.String date) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.findVinietasByDate(date);
    }

    private void removeSerie(ws.Serie entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        port.removeSerie(entity);
    }

    private void removeVinieta(ws.Vinieta entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        port.removeVinieta(entity);
    }

    private java.util.List<java.lang.String> searchSerieByAutor(java.lang.String autor) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.searchSerieByAutor(autor);
    }

    private java.util.List<ws.Serie> searchSerieByName(java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.searchSerieByName(nombre);
    }

    private java.util.List<ws.Vinieta> searchVinietaBySerie(java.lang.Object serie) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.searchVinietaBySerie(serie);
    }

    private java.util.List<ws.Vinieta> top5Vinietas() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.top5Vinietas();
    }

    private java.util.List<ws.Serie> topFiveSeries() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.topFiveSeries();
    }

    private java.util.List<ws.Vinieta> ultimasVinietas() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ComicWS port = service.getComicWSPort();
        return port.ultimasVinietas();
    }

}
