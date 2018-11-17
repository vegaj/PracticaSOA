
package ws;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSVinieta", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSVinieta {


    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "remove", targetNamespace = "http://ws/", className = "ws.Remove")
    @Action(input = "http://ws/WSVinieta/remove")
    public void remove(
        @WebParam(name = "entity", targetNamespace = "")
        Vinieta entity);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://ws/", className = "ws.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://ws/", className = "ws.CountResponse")
    @Action(input = "http://ws/WSVinieta/countRequest", output = "http://ws/WSVinieta/countResponse")
    public int count();

    /**
     * 
     * @param id
     * @return
     *     returns ws.Vinieta
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://ws/", className = "ws.Find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://ws/", className = "ws.FindResponse")
    @Action(input = "http://ws/WSVinieta/findRequest", output = "http://ws/WSVinieta/findResponse")
    public Vinieta find(
        @WebParam(name = "id", targetNamespace = "")
        Object id);

    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "create", targetNamespace = "http://ws/", className = "ws.Create")
    @Action(input = "http://ws/WSVinieta/create")
    public void create(
        @WebParam(name = "entity", targetNamespace = "")
        Vinieta entity);

    /**
     * 
     * @param range
     * @return
     *     returns java.util.List<ws.Vinieta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRange", targetNamespace = "http://ws/", className = "ws.FindRange")
    @ResponseWrapper(localName = "findRangeResponse", targetNamespace = "http://ws/", className = "ws.FindRangeResponse")
    @Action(input = "http://ws/WSVinieta/findRangeRequest", output = "http://ws/WSVinieta/findRangeResponse")
    public List<Vinieta> findRange(
        @WebParam(name = "range", targetNamespace = "")
        List<Integer> range);

    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "edit", targetNamespace = "http://ws/", className = "ws.Edit")
    @Action(input = "http://ws/WSVinieta/edit")
    public void edit(
        @WebParam(name = "entity", targetNamespace = "")
        Vinieta entity);

    /**
     * 
     * @return
     *     returns java.util.List<ws.Vinieta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://ws/", className = "ws.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://ws/", className = "ws.FindAllResponse")
    @Action(input = "http://ws/WSVinieta/findAllRequest", output = "http://ws/WSVinieta/findAllResponse")
    public List<Vinieta> findAll();

}
