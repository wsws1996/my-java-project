
package cn.com.webxml;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a> <strong>天气预报 Web 服务，</strong>数据来源于<strong>中国气象局</strong> <a href="http://www.cma.gov.cn/" target="_blank">http://www.cma.gov.cn/</a> ，数据每2.5小时左右自动更新一次，准确可靠。包括 340 多个中国主要城市和 60 多个国外主要城市三日内的天气预报数据。</br>此天气预报Web Services请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank">联系我们</a>，欢迎技术交流。 QQ：8698053<br /><strong>使用本站 WEB 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><span style="color:#999999;">通知：天气预报 WEB 服务如原来使用地址 http://www.onhap.com/WebServices/WeatherWebService.asmx 的，请改成现在使用的服务地址 http://www.webxml.com.cn/WebServices/WeatherWebService.asmx ，重新引用即可。</span><br /><br />&nbsp;
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WeatherWebService", targetNamespace = "http://WebXml.com.cn/", wsdlLocation = "file:/home/wang/\u684c\u9762/WeatherWebService.wsdl.xml")
public class WeatherWebService
    extends Service
{

    private final static URL WEATHERWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEATHERWEBSERVICE_EXCEPTION;
    private final static QName WEATHERWEBSERVICE_QNAME = new QName("http://WebXml.com.cn/", "WeatherWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/wang/\u684c\u9762/WeatherWebService.wsdl.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEATHERWEBSERVICE_WSDL_LOCATION = url;
        WEATHERWEBSERVICE_EXCEPTION = e;
    }

    public WeatherWebService() {
        super(__getWsdlLocation(), WEATHERWEBSERVICE_QNAME);
    }

    public WeatherWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEATHERWEBSERVICE_QNAME, features);
    }

    public WeatherWebService(URL wsdlLocation) {
        super(wsdlLocation, WEATHERWEBSERVICE_QNAME);
    }

    public WeatherWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEATHERWEBSERVICE_QNAME, features);
    }

    public WeatherWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeatherWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WeatherWebServiceSoap
     */
    @WebEndpoint(name = "WeatherWebServiceSoap")
    public WeatherWebServiceSoap getWeatherWebServiceSoap() {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceSoap"), WeatherWebServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWebServiceSoap
     */
    @WebEndpoint(name = "WeatherWebServiceSoap")
    public WeatherWebServiceSoap getWeatherWebServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceSoap"), WeatherWebServiceSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WeatherWebServiceSoap
     */
    @WebEndpoint(name = "WeatherWebServiceSoap12")
    public WeatherWebServiceSoap getWeatherWebServiceSoap12() {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceSoap12"), WeatherWebServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWebServiceSoap
     */
    @WebEndpoint(name = "WeatherWebServiceSoap12")
    public WeatherWebServiceSoap getWeatherWebServiceSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceSoap12"), WeatherWebServiceSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WeatherWebServiceHttpGet
     */
    @WebEndpoint(name = "WeatherWebServiceHttpGet")
    public WeatherWebServiceHttpGet getWeatherWebServiceHttpGet() {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceHttpGet"), WeatherWebServiceHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWebServiceHttpGet
     */
    @WebEndpoint(name = "WeatherWebServiceHttpGet")
    public WeatherWebServiceHttpGet getWeatherWebServiceHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceHttpGet"), WeatherWebServiceHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns WeatherWebServiceHttpPost
     */
    @WebEndpoint(name = "WeatherWebServiceHttpPost")
    public WeatherWebServiceHttpPost getWeatherWebServiceHttpPost() {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceHttpPost"), WeatherWebServiceHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWebServiceHttpPost
     */
    @WebEndpoint(name = "WeatherWebServiceHttpPost")
    public WeatherWebServiceHttpPost getWeatherWebServiceHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWebServiceHttpPost"), WeatherWebServiceHttpPost.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEATHERWEBSERVICE_EXCEPTION!= null) {
            throw WEATHERWEBSERVICE_EXCEPTION;
        }
        return WEATHERWEBSERVICE_WSDL_LOCATION;
    }

}
