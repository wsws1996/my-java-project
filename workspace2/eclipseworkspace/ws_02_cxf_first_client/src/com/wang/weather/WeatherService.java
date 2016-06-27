package com.wang.weather;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2016-06-09T20:43:35.986+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebServiceClient(name = "WeatherService", 
                  wsdlLocation = "http://127.0.0.1:12345/weather?wsdl",
                  targetNamespace = "http://weather.wang.com/") 
public class WeatherService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://weather.wang.com/", "WeatherService");
    public final static QName WeatherInterfacePort = new QName("http://weather.wang.com/", "WeatherInterfacePort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:12345/weather?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WeatherService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:12345/weather?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WeatherService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WeatherService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeatherService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WeatherService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WeatherService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WeatherService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns WeatherInterface
     */
    @WebEndpoint(name = "WeatherInterfacePort")
    public WeatherInterface getWeatherInterfacePort() {
        return super.getPort(WeatherInterfacePort, WeatherInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherInterface
     */
    @WebEndpoint(name = "WeatherInterfacePort")
    public WeatherInterface getWeatherInterfacePort(WebServiceFeature... features) {
        return super.getPort(WeatherInterfacePort, WeatherInterface.class, features);
    }

}