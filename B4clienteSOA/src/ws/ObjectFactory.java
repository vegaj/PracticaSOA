
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateSerie_QNAME = new QName("http://ws/", "createSerie");
    private final static QName _FindRangeVinietasResponse_QNAME = new QName("http://ws/", "findRangeVinietasResponse");
    private final static QName _EditSerie_QNAME = new QName("http://ws/", "editSerie");
    private final static QName _FindVinietaResponse_QNAME = new QName("http://ws/", "findVinietaResponse");
    private final static QName _Top5VinietasResponse_QNAME = new QName("http://ws/", "top5VinietasResponse");
    private final static QName _UltimasVinietas_QNAME = new QName("http://ws/", "ultimasVinietas");
    private final static QName _RemoveSerie_QNAME = new QName("http://ws/", "removeSerie");
    private final static QName _RemoveVinieta_QNAME = new QName("http://ws/", "removeVinieta");
    private final static QName _FindRangeSeriesResponse_QNAME = new QName("http://ws/", "findRangeSeriesResponse");
    private final static QName _FindAllVinietasResponse_QNAME = new QName("http://ws/", "findAllVinietasResponse");
    private final static QName _FindAllSeries_QNAME = new QName("http://ws/", "findAllSeries");
    private final static QName _FindAllVinietas_QNAME = new QName("http://ws/", "findAllVinietas");
    private final static QName _FindAutores_QNAME = new QName("http://ws/", "findAutores");
    private final static QName _FindVinietasByDate_QNAME = new QName("http://ws/", "findVinietasByDate");
    private final static QName _Top5Vinietas_QNAME = new QName("http://ws/", "top5Vinietas");
    private final static QName _TopFiveSeries_QNAME = new QName("http://ws/", "topFiveSeries");
    private final static QName _CountVinietasResponse_QNAME = new QName("http://ws/", "countVinietasResponse");
    private final static QName _FindSerieResponse_QNAME = new QName("http://ws/", "findSerieResponse");
    private final static QName _UltimasVinietasResponse_QNAME = new QName("http://ws/", "ultimasVinietasResponse");
    private final static QName _CountSeriesResponse_QNAME = new QName("http://ws/", "countSeriesResponse");
    private final static QName _CountSeries_QNAME = new QName("http://ws/", "countSeries");
    private final static QName _FindAllSeriesResponse_QNAME = new QName("http://ws/", "findAllSeriesResponse");
    private final static QName _SearchSerieByAutor_QNAME = new QName("http://ws/", "searchSerieByAutor");
    private final static QName _SearchSerieByAutorResponse_QNAME = new QName("http://ws/", "searchSerieByAutorResponse");
    private final static QName _Vinieta_QNAME = new QName("http://ws/", "vinieta");
    private final static QName _FindSerie_QNAME = new QName("http://ws/", "findSerie");
    private final static QName _TopFiveSeriesResponse_QNAME = new QName("http://ws/", "topFiveSeriesResponse");
    private final static QName _EditVinieta_QNAME = new QName("http://ws/", "editVinieta");
    private final static QName _FindAutoresResponse_QNAME = new QName("http://ws/", "findAutoresResponse");
    private final static QName _FindVinieta_QNAME = new QName("http://ws/", "findVinieta");
    private final static QName _FindVinietasBetweenDates_QNAME = new QName("http://ws/", "findVinietasBetweenDates");
    private final static QName _CountVinietas_QNAME = new QName("http://ws/", "countVinietas");
    private final static QName _FindRangeVinietas_QNAME = new QName("http://ws/", "findRangeVinietas");
    private final static QName _FindVinietasBetweenDatesResponse_QNAME = new QName("http://ws/", "findVinietasBetweenDatesResponse");
    private final static QName _Serie_QNAME = new QName("http://ws/", "serie");
    private final static QName _CreateVinieta_QNAME = new QName("http://ws/", "createVinieta");
    private final static QName _FindRangeSeries_QNAME = new QName("http://ws/", "findRangeSeries");
    private final static QName _FindVinietasByDateResponse_QNAME = new QName("http://ws/", "findVinietasByDateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateSerie }
     * 
     */
    public CreateSerie createCreateSerie() {
        return new CreateSerie();
    }

    /**
     * Create an instance of {@link FindRangeVinietasResponse }
     * 
     */
    public FindRangeVinietasResponse createFindRangeVinietasResponse() {
        return new FindRangeVinietasResponse();
    }

    /**
     * Create an instance of {@link EditSerie }
     * 
     */
    public EditSerie createEditSerie() {
        return new EditSerie();
    }

    /**
     * Create an instance of {@link FindVinietaResponse }
     * 
     */
    public FindVinietaResponse createFindVinietaResponse() {
        return new FindVinietaResponse();
    }

    /**
     * Create an instance of {@link Top5VinietasResponse }
     * 
     */
    public Top5VinietasResponse createTop5VinietasResponse() {
        return new Top5VinietasResponse();
    }

    /**
     * Create an instance of {@link UltimasVinietas }
     * 
     */
    public UltimasVinietas createUltimasVinietas() {
        return new UltimasVinietas();
    }

    /**
     * Create an instance of {@link RemoveSerie }
     * 
     */
    public RemoveSerie createRemoveSerie() {
        return new RemoveSerie();
    }

    /**
     * Create an instance of {@link RemoveVinieta }
     * 
     */
    public RemoveVinieta createRemoveVinieta() {
        return new RemoveVinieta();
    }

    /**
     * Create an instance of {@link FindRangeSeriesResponse }
     * 
     */
    public FindRangeSeriesResponse createFindRangeSeriesResponse() {
        return new FindRangeSeriesResponse();
    }

    /**
     * Create an instance of {@link FindAllVinietasResponse }
     * 
     */
    public FindAllVinietasResponse createFindAllVinietasResponse() {
        return new FindAllVinietasResponse();
    }

    /**
     * Create an instance of {@link FindAllSeries }
     * 
     */
    public FindAllSeries createFindAllSeries() {
        return new FindAllSeries();
    }

    /**
     * Create an instance of {@link FindAllVinietas }
     * 
     */
    public FindAllVinietas createFindAllVinietas() {
        return new FindAllVinietas();
    }

    /**
     * Create an instance of {@link FindAutores }
     * 
     */
    public FindAutores createFindAutores() {
        return new FindAutores();
    }

    /**
     * Create an instance of {@link FindVinietasByDate }
     * 
     */
    public FindVinietasByDate createFindVinietasByDate() {
        return new FindVinietasByDate();
    }

    /**
     * Create an instance of {@link Top5Vinietas }
     * 
     */
    public Top5Vinietas createTop5Vinietas() {
        return new Top5Vinietas();
    }

    /**
     * Create an instance of {@link TopFiveSeries }
     * 
     */
    public TopFiveSeries createTopFiveSeries() {
        return new TopFiveSeries();
    }

    /**
     * Create an instance of {@link CountVinietasResponse }
     * 
     */
    public CountVinietasResponse createCountVinietasResponse() {
        return new CountVinietasResponse();
    }

    /**
     * Create an instance of {@link FindSerieResponse }
     * 
     */
    public FindSerieResponse createFindSerieResponse() {
        return new FindSerieResponse();
    }

    /**
     * Create an instance of {@link UltimasVinietasResponse }
     * 
     */
    public UltimasVinietasResponse createUltimasVinietasResponse() {
        return new UltimasVinietasResponse();
    }

    /**
     * Create an instance of {@link CountSeriesResponse }
     * 
     */
    public CountSeriesResponse createCountSeriesResponse() {
        return new CountSeriesResponse();
    }

    /**
     * Create an instance of {@link CountSeries }
     * 
     */
    public CountSeries createCountSeries() {
        return new CountSeries();
    }

    /**
     * Create an instance of {@link FindAllSeriesResponse }
     * 
     */
    public FindAllSeriesResponse createFindAllSeriesResponse() {
        return new FindAllSeriesResponse();
    }

    /**
     * Create an instance of {@link SearchSerieByAutor }
     * 
     */
    public SearchSerieByAutor createSearchSerieByAutor() {
        return new SearchSerieByAutor();
    }

    /**
     * Create an instance of {@link SearchSerieByAutorResponse }
     * 
     */
    public SearchSerieByAutorResponse createSearchSerieByAutorResponse() {
        return new SearchSerieByAutorResponse();
    }

    /**
     * Create an instance of {@link Vinieta }
     * 
     */
    public Vinieta createVinieta() {
        return new Vinieta();
    }

    /**
     * Create an instance of {@link FindSerie }
     * 
     */
    public FindSerie createFindSerie() {
        return new FindSerie();
    }

    /**
     * Create an instance of {@link TopFiveSeriesResponse }
     * 
     */
    public TopFiveSeriesResponse createTopFiveSeriesResponse() {
        return new TopFiveSeriesResponse();
    }

    /**
     * Create an instance of {@link EditVinieta }
     * 
     */
    public EditVinieta createEditVinieta() {
        return new EditVinieta();
    }

    /**
     * Create an instance of {@link FindAutoresResponse }
     * 
     */
    public FindAutoresResponse createFindAutoresResponse() {
        return new FindAutoresResponse();
    }

    /**
     * Create an instance of {@link FindVinieta }
     * 
     */
    public FindVinieta createFindVinieta() {
        return new FindVinieta();
    }

    /**
     * Create an instance of {@link FindVinietasBetweenDates }
     * 
     */
    public FindVinietasBetweenDates createFindVinietasBetweenDates() {
        return new FindVinietasBetweenDates();
    }

    /**
     * Create an instance of {@link CountVinietas }
     * 
     */
    public CountVinietas createCountVinietas() {
        return new CountVinietas();
    }

    /**
     * Create an instance of {@link FindRangeVinietas }
     * 
     */
    public FindRangeVinietas createFindRangeVinietas() {
        return new FindRangeVinietas();
    }

    /**
     * Create an instance of {@link FindVinietasBetweenDatesResponse }
     * 
     */
    public FindVinietasBetweenDatesResponse createFindVinietasBetweenDatesResponse() {
        return new FindVinietasBetweenDatesResponse();
    }

    /**
     * Create an instance of {@link Serie }
     * 
     */
    public Serie createSerie() {
        return new Serie();
    }

    /**
     * Create an instance of {@link CreateVinieta }
     * 
     */
    public CreateVinieta createCreateVinieta() {
        return new CreateVinieta();
    }

    /**
     * Create an instance of {@link FindRangeSeries }
     * 
     */
    public FindRangeSeries createFindRangeSeries() {
        return new FindRangeSeries();
    }

    /**
     * Create an instance of {@link FindVinietasByDateResponse }
     * 
     */
    public FindVinietasByDateResponse createFindVinietasByDateResponse() {
        return new FindVinietasByDateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSerie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "createSerie")
    public JAXBElement<CreateSerie> createCreateSerie(CreateSerie value) {
        return new JAXBElement<CreateSerie>(_CreateSerie_QNAME, CreateSerie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeVinietasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findRangeVinietasResponse")
    public JAXBElement<FindRangeVinietasResponse> createFindRangeVinietasResponse(FindRangeVinietasResponse value) {
        return new JAXBElement<FindRangeVinietasResponse>(_FindRangeVinietasResponse_QNAME, FindRangeVinietasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditSerie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "editSerie")
    public JAXBElement<EditSerie> createEditSerie(EditSerie value) {
        return new JAXBElement<EditSerie>(_EditSerie_QNAME, EditSerie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindVinietaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findVinietaResponse")
    public JAXBElement<FindVinietaResponse> createFindVinietaResponse(FindVinietaResponse value) {
        return new JAXBElement<FindVinietaResponse>(_FindVinietaResponse_QNAME, FindVinietaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Top5VinietasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "top5VinietasResponse")
    public JAXBElement<Top5VinietasResponse> createTop5VinietasResponse(Top5VinietasResponse value) {
        return new JAXBElement<Top5VinietasResponse>(_Top5VinietasResponse_QNAME, Top5VinietasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UltimasVinietas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "ultimasVinietas")
    public JAXBElement<UltimasVinietas> createUltimasVinietas(UltimasVinietas value) {
        return new JAXBElement<UltimasVinietas>(_UltimasVinietas_QNAME, UltimasVinietas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSerie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "removeSerie")
    public JAXBElement<RemoveSerie> createRemoveSerie(RemoveSerie value) {
        return new JAXBElement<RemoveSerie>(_RemoveSerie_QNAME, RemoveSerie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveVinieta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "removeVinieta")
    public JAXBElement<RemoveVinieta> createRemoveVinieta(RemoveVinieta value) {
        return new JAXBElement<RemoveVinieta>(_RemoveVinieta_QNAME, RemoveVinieta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeSeriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findRangeSeriesResponse")
    public JAXBElement<FindRangeSeriesResponse> createFindRangeSeriesResponse(FindRangeSeriesResponse value) {
        return new JAXBElement<FindRangeSeriesResponse>(_FindRangeSeriesResponse_QNAME, FindRangeSeriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllVinietasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllVinietasResponse")
    public JAXBElement<FindAllVinietasResponse> createFindAllVinietasResponse(FindAllVinietasResponse value) {
        return new JAXBElement<FindAllVinietasResponse>(_FindAllVinietasResponse_QNAME, FindAllVinietasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllSeries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllSeries")
    public JAXBElement<FindAllSeries> createFindAllSeries(FindAllSeries value) {
        return new JAXBElement<FindAllSeries>(_FindAllSeries_QNAME, FindAllSeries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllVinietas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllVinietas")
    public JAXBElement<FindAllVinietas> createFindAllVinietas(FindAllVinietas value) {
        return new JAXBElement<FindAllVinietas>(_FindAllVinietas_QNAME, FindAllVinietas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAutores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAutores")
    public JAXBElement<FindAutores> createFindAutores(FindAutores value) {
        return new JAXBElement<FindAutores>(_FindAutores_QNAME, FindAutores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindVinietasByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findVinietasByDate")
    public JAXBElement<FindVinietasByDate> createFindVinietasByDate(FindVinietasByDate value) {
        return new JAXBElement<FindVinietasByDate>(_FindVinietasByDate_QNAME, FindVinietasByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Top5Vinietas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "top5Vinietas")
    public JAXBElement<Top5Vinietas> createTop5Vinietas(Top5Vinietas value) {
        return new JAXBElement<Top5Vinietas>(_Top5Vinietas_QNAME, Top5Vinietas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopFiveSeries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "topFiveSeries")
    public JAXBElement<TopFiveSeries> createTopFiveSeries(TopFiveSeries value) {
        return new JAXBElement<TopFiveSeries>(_TopFiveSeries_QNAME, TopFiveSeries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountVinietasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countVinietasResponse")
    public JAXBElement<CountVinietasResponse> createCountVinietasResponse(CountVinietasResponse value) {
        return new JAXBElement<CountVinietasResponse>(_CountVinietasResponse_QNAME, CountVinietasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSerieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findSerieResponse")
    public JAXBElement<FindSerieResponse> createFindSerieResponse(FindSerieResponse value) {
        return new JAXBElement<FindSerieResponse>(_FindSerieResponse_QNAME, FindSerieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UltimasVinietasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "ultimasVinietasResponse")
    public JAXBElement<UltimasVinietasResponse> createUltimasVinietasResponse(UltimasVinietasResponse value) {
        return new JAXBElement<UltimasVinietasResponse>(_UltimasVinietasResponse_QNAME, UltimasVinietasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountSeriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countSeriesResponse")
    public JAXBElement<CountSeriesResponse> createCountSeriesResponse(CountSeriesResponse value) {
        return new JAXBElement<CountSeriesResponse>(_CountSeriesResponse_QNAME, CountSeriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountSeries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countSeries")
    public JAXBElement<CountSeries> createCountSeries(CountSeries value) {
        return new JAXBElement<CountSeries>(_CountSeries_QNAME, CountSeries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllSeriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllSeriesResponse")
    public JAXBElement<FindAllSeriesResponse> createFindAllSeriesResponse(FindAllSeriesResponse value) {
        return new JAXBElement<FindAllSeriesResponse>(_FindAllSeriesResponse_QNAME, FindAllSeriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSerieByAutor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "searchSerieByAutor")
    public JAXBElement<SearchSerieByAutor> createSearchSerieByAutor(SearchSerieByAutor value) {
        return new JAXBElement<SearchSerieByAutor>(_SearchSerieByAutor_QNAME, SearchSerieByAutor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSerieByAutorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "searchSerieByAutorResponse")
    public JAXBElement<SearchSerieByAutorResponse> createSearchSerieByAutorResponse(SearchSerieByAutorResponse value) {
        return new JAXBElement<SearchSerieByAutorResponse>(_SearchSerieByAutorResponse_QNAME, SearchSerieByAutorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Vinieta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "vinieta")
    public JAXBElement<Vinieta> createVinieta(Vinieta value) {
        return new JAXBElement<Vinieta>(_Vinieta_QNAME, Vinieta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSerie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findSerie")
    public JAXBElement<FindSerie> createFindSerie(FindSerie value) {
        return new JAXBElement<FindSerie>(_FindSerie_QNAME, FindSerie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopFiveSeriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "topFiveSeriesResponse")
    public JAXBElement<TopFiveSeriesResponse> createTopFiveSeriesResponse(TopFiveSeriesResponse value) {
        return new JAXBElement<TopFiveSeriesResponse>(_TopFiveSeriesResponse_QNAME, TopFiveSeriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditVinieta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "editVinieta")
    public JAXBElement<EditVinieta> createEditVinieta(EditVinieta value) {
        return new JAXBElement<EditVinieta>(_EditVinieta_QNAME, EditVinieta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAutoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAutoresResponse")
    public JAXBElement<FindAutoresResponse> createFindAutoresResponse(FindAutoresResponse value) {
        return new JAXBElement<FindAutoresResponse>(_FindAutoresResponse_QNAME, FindAutoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindVinieta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findVinieta")
    public JAXBElement<FindVinieta> createFindVinieta(FindVinieta value) {
        return new JAXBElement<FindVinieta>(_FindVinieta_QNAME, FindVinieta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindVinietasBetweenDates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findVinietasBetweenDates")
    public JAXBElement<FindVinietasBetweenDates> createFindVinietasBetweenDates(FindVinietasBetweenDates value) {
        return new JAXBElement<FindVinietasBetweenDates>(_FindVinietasBetweenDates_QNAME, FindVinietasBetweenDates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountVinietas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countVinietas")
    public JAXBElement<CountVinietas> createCountVinietas(CountVinietas value) {
        return new JAXBElement<CountVinietas>(_CountVinietas_QNAME, CountVinietas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeVinietas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findRangeVinietas")
    public JAXBElement<FindRangeVinietas> createFindRangeVinietas(FindRangeVinietas value) {
        return new JAXBElement<FindRangeVinietas>(_FindRangeVinietas_QNAME, FindRangeVinietas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindVinietasBetweenDatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findVinietasBetweenDatesResponse")
    public JAXBElement<FindVinietasBetweenDatesResponse> createFindVinietasBetweenDatesResponse(FindVinietasBetweenDatesResponse value) {
        return new JAXBElement<FindVinietasBetweenDatesResponse>(_FindVinietasBetweenDatesResponse_QNAME, FindVinietasBetweenDatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Serie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "serie")
    public JAXBElement<Serie> createSerie(Serie value) {
        return new JAXBElement<Serie>(_Serie_QNAME, Serie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateVinieta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "createVinieta")
    public JAXBElement<CreateVinieta> createCreateVinieta(CreateVinieta value) {
        return new JAXBElement<CreateVinieta>(_CreateVinieta_QNAME, CreateVinieta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeSeries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findRangeSeries")
    public JAXBElement<FindRangeSeries> createFindRangeSeries(FindRangeSeries value) {
        return new JAXBElement<FindRangeSeries>(_FindRangeSeries_QNAME, FindRangeSeries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindVinietasByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findVinietasByDateResponse")
    public JAXBElement<FindVinietasByDateResponse> createFindVinietasByDateResponse(FindVinietasByDateResponse value) {
        return new JAXBElement<FindVinietasByDateResponse>(_FindVinietasByDateResponse_QNAME, FindVinietasByDateResponse.class, null, value);
    }

}
