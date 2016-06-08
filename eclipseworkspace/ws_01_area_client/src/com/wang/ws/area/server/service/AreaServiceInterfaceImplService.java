
package com.wang.ws.area.server.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AreaServiceInterfaceImplService", targetNamespace = "http://service.server.area.ws.wang.com/", wsdlLocation = "http://localhost:12345/area?wsdl")
public class AreaServiceInterfaceImplService
    extends Service
{

    private final static URL AREASERVICEINTERFACEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException AREASERVICEINTERFACEIMPLSERVICE_EXCEPTION;
    private final static QName AREASERVICEINTERFACEIMPLSERVICE_QNAME = new QName("http://service.server.area.ws.wang.com/", "AreaServiceInterfaceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:12345/area?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AREASERVICEINTERFACEIMPLSERVICE_WSDL_LOCATION = url;
        AREASERVICEINTERFACEIMPLSERVICE_EXCEPTION = e;
    }

    public AreaServiceInterfaceImplService() {
        super(__getWsdlLocation(), AREASERVICEINTERFACEIMPLSERVICE_QNAME);
    }

    public AreaServiceInterfaceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AREASERVICEINTERFACEIMPLSERVICE_QNAME, features);
    }

    public AreaServiceInterfaceImplService(URL wsdlLocation) {
        super(wsdlLocation, AREASERVICEINTERFACEIMPLSERVICE_QNAME);
    }

    public AreaServiceInterfaceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AREASERVICEINTERFACEIMPLSERVICE_QNAME, features);
    }

    public AreaServiceInterfaceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AreaServiceInterfaceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AreaServiceInterfaceImpl
     */
    @WebEndpoint(name = "AreaServiceInterfaceImplPort")
    public AreaServiceInterfaceImpl getAreaServiceInterfaceImplPort() {
        return super.getPort(new QName("http://service.server.area.ws.wang.com/", "AreaServiceInterfaceImplPort"), AreaServiceInterfaceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AreaServiceInterfaceImpl
     */
    @WebEndpoint(name = "AreaServiceInterfaceImplPort")
    public AreaServiceInterfaceImpl getAreaServiceInterfaceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.server.area.ws.wang.com/", "AreaServiceInterfaceImplPort"), AreaServiceInterfaceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AREASERVICEINTERFACEIMPLSERVICE_EXCEPTION!= null) {
            throw AREASERVICEINTERFACEIMPLSERVICE_EXCEPTION;
        }
        return AREASERVICEINTERFACEIMPLSERVICE_WSDL_LOCATION;
    }

}
