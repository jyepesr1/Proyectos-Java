package StaticMaps;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * It's the kind of which the rest are derived and contains a number of functions and (static)
 * properties mainly for the different options when making requests to the API Google Maps 
 * (sensor, language, etc..) And track the status each request.
 * @author Luis Marcos
 */
public abstract class MapsJava {

    /**Application properties*/
    private static int connectTimeout= 300;
    private static String region="es";
    private static String language="es";
    private static Boolean sensor= Boolean.FALSE;
    private static String APIKey="";
    
    //Stock request
    private static String[][] stockRequest=new String[0][6];
    
    //Abstract methods
    protected abstract void onError(URL urlRequest,String status,Exception ex);
    protected abstract String getStatus(XPath xpath, Document document);
    protected abstract void storeInfoRequest(URL urlRequest,String info,String status,Exception exception);
    

    //Protected methods
    private static int numRequest=0;
    protected void storageRequest(String urlRequest,String info,String status, Exception exception)
    {
        Date date = new Date();
        numRequest+=1;
        MapsJava.stockRequest=(String[][])(this.resizeArray(MapsJava.stockRequest,numRequest));
        if(MapsJava.stockRequest[numRequest-1]==null)
        {
                MapsJava.stockRequest[numRequest-1]=new String[6];
        }
        MapsJava.stockRequest[numRequest-1][0]=String.valueOf(numRequest);
        MapsJava.stockRequest[numRequest-1][1]=date.toString();
        MapsJava.stockRequest[numRequest-1][2]=status;
        MapsJava.stockRequest[numRequest-1][3]=urlRequest;
        MapsJava.stockRequest[numRequest-1][4]=info;
        if(exception==null){
            MapsJava.stockRequest[numRequest-1][5]="No exception";
        }else{
            MapsJava.stockRequest[numRequest-1][5]=exception.toString();
        }
        
    }
    
    protected String getSelectPropertiesRequest(){
        return "&region=" + MapsJava.region + "&language=" + MapsJava.language + 
                "&sensor=" + MapsJava.sensor;
    }
    
    protected ArrayList<String> getNodesString(NodeList node){
         ArrayList<String> result=new ArrayList<>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(nodeString);
             }
        return result;
    }
     
    protected ArrayList<Double> getNodesDouble(NodeList node){
         ArrayList<Double> result=new ArrayList<>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(Double.valueOf(nodeString));
             }
        return result;
    }
    
    protected ArrayList<Integer> getNodesInteger(NodeList node){
         ArrayList<Integer> result=new ArrayList<>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(Integer.valueOf(nodeString));
             }
        return result;
    }
    
    /**
     *Author: Christian d'Heureuse (www.source-code.biz, www.inventec.ch/chdh)
     *Allocate an array with a new size and copy the contents of the old array to the new array.
     * @ Param oldArray the old matrix to be reassigned.
     * @ Param newSize the new size of the array.
     * @ Return a new array with the same content.
     * @param oldArray
     * @param newSize
     * @return 
    */
    protected Object resizeArray (Object oldArray, int newSize) {
       int oldSize = java.lang.reflect.Array.getLength(oldArray);
       Class elementType = oldArray.getClass().getComponentType();
       Object newArray = java.lang.reflect.Array.newInstance(
             elementType, newSize);
       int preserveLength = Math.min(oldSize, newSize);
       if (preserveLength > 0)
          System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
       return newArray; 
    }
    
    //Public methods
    /**
     * Check if the developer key is valid Google Maps API. 
     * @param key ckey Google Maps API Developer 
     * @return deturns the status of a request API key. If valid, returns 
      * "OK" in any other case the key is not correct. 
     * @see MapsJava#setKey(java.lang.String) 
     * @see MapsJava#getKey() 
     */
    public static String APIkeyCheck(String key){
        try{
            URL url=new URL("https://maps.googleapis.com/maps/api/place/search/xml?location=0,0&radius=1000" + 
                    "&sensor=false&key=" + key);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document document = builder.parse(url.openStream()); 
            XPathFactory xpathFactory = XPathFactory.newInstance(); 
            XPath xpath = xpathFactory.newXPath(); 

            NodeList nodeLatLng = (NodeList) xpath.evaluate("PlaceSearchResponse/status", 
                            document, XPathConstants.NODESET);
            String status = nodeLatLng.item(0).getTextContent();
            return status;
        }catch (IOException | ParserConfigurationException | XPathExpressionException | DOMException | SAXException e){
            return "NO STATUS";
        }
    }
    
    //Public access to properties of the request (Getters/Setters)
    /**
     * Returns the maximum connection time (milliseconds) waiting to server (NOT WORKING)
     * @return int with maximum connection time
     * @see MapsJava#setConnectTimeout(int) 
     */
    public static int getConnectTimeout() {
        return connectTimeout;
    }
    /**
     * Sets the maximum wait time (milliseconds) by the server (NOT WORKING)
     * @param aConnectTimeout assign maximum connection time
     * @see MapsJava#getConnectTimeout() 
     */
    public static void setConnectTimeout(int aConnectTimeout) {
        connectTimeout = aConnectTimeout;
    }
    
    /**
     * Gets the search region results (by default "es").
     * More information about regions http://es.wikipedia.org/wiki/CcTLD
     * @return returns the current search region
     * @see MapsJava#setRegion(java.lang.String) 
     */
    public static String getRegion() {
        return region;
    }
    
    /**
     * Sets the search region results (by default "es").
     * More information about regions  http://es.wikipedia.org/wiki/CcTLD
     * @param aRegion assigns the search region
     * @see MapsJava#getRegion() 
     */
    public static void setRegion(String aRegion) {
        region = aRegion;
    }

    /**
     * Gets the language in which the results are shown (by default "es")
     * More information about regions  https://spreadsheets.google.com/pub?key=p9pdwsai2hDMsLkXsoM05KQ&gid=1
     * @return returns the current language of results
     * @see MapsJava#setLanguage(java.lang.String) () 
     */
    public static String getLanguage() {
        return language;
    }
    /**
     * Sets the language in which the results are shown (de forma predeterminada "es")
     * More information about regions  https://spreadsheets.google.com/pub?key=p9pdwsai2hDMsLkXsoM05KQ&gid=1
     * @param aLanguage sets the language of results
     * @see MapsJava#getLanguage() 
     */
    public static void setLanguage(String aLanguage) {
        language = aLanguage;
    }

    /**
     * Gets if using GPS (GNSS) sensor on requests for location (default is false)
     * @return returns true in case of use of sensor and false otherwise
     * @see MapsJava#setSensor(java.lang.Boolean) 
     */
    public static Boolean getSensor() {
        return sensor;
    }
    /**
     * Sets the use or non-use of a GPS (GNSS) sensor on requests for location (by default false)
     * @param aSensor should be true, it is forced to use sensor. If false, not used
     * @see MapsJava#getSensor() 
     */
    public static void setSensor(Boolean aSensor) {
        sensor = aSensor;
    }
    
    /**
     * Gets the current developer key Google Maps API (required for Places)
     * @return get string with current key
     * @see MapsJava#setKey(java.lang.String) 
     * @see MapsJava#APIkeyCheck(java.lang.String) 
     */
    public static String getKey() {
        return APIKey;
    }

    /**
     * Set developer key Google Maps API (required for Places)
     * @param aKey string API developer key
     * @see MapsJava#getKey() 
     * @see MapsJava#APIkeyCheck(java.lang.String) 
     */
    public static void setKey(String aKey) {
        APIKey = aKey;
    }
    
    
    //Public acces to stockRequest 
    /**
     *Get log of all HTTP requests made. Forms a String [n] [6] with the following structure:
     * [0][0]="Request Number"
     * [0][1]="Date / Time request"
     * [0][2]="status request"
     * [0][3]="Requested URL"
     * [0][4]="Information request made"
     * [0][5]=""Exceptions generated"
     *Types of status:
     * OK: indicates that the API request was successful.
     * @INVALID_REQUEST: indicates that the API request is incorrectly formed.
     * @OVER_QUERY_LIMIT: indicates that the applicant has exceeded the limits.
     * @REQUEST_DENIED: indicates that the API did not complete the application, possibly because the applicant can not include a valid parameter sensor correctly.
     * @UNKNOWN_ERROR: Indicates an unknown error.
     * @NO STATUS: indicates a failure to make the request.
     * @return returns a two dimensional array with the different requests made.
     */
    public static String[][] getStockRequest() {
        return stockRequest;
    }

    /**
     * Get the latest log HTTP request. Forms a String [6] with the following structure:
     * [0]="Request Number"
     * [1]="Date / time request"
     * [2]="status request"
     * [3]="Requested URL"
     * [4]="Information request made"
     * [5]="Exceptions generated"
     *Types of status:
     * OK: ndicates that the API request was successful.
     * @INVALID_REQUEST: indicates that the API request is incorrectly formed.
     * @OVER_QUERY_LIMIT: indicates that the applicant has exceeded the limits.
     * @REQUEST_DENIED: indicates that the API did not complete the application, possibly because the applicant can not include a valid parameter sensor correctly.
     * @UNKNOWN_ERROR: indicates an unknown error.
     * @NO STATUS: indicates a failure to make the request.
     * @return array of one dimension with the last request made
     * @see MapsJava#getStockRequest() 
     */
    public static  String[] getLastRequestRequest() {
        String[] stockRequestTemp=new String[6];
        System.arraycopy(stockRequest[stockRequest.length-1], 0, stockRequestTemp, 0, 6);
        return stockRequestTemp;
    }
    
    /**
     * Gets the status of the last call made.
     *Types of status:
     * OK: indicates that the API request was successful.
     * @INVALID_REQUEST: indicates that the API request is incorrectly formed.
     * @OVER_QUERY_LIMIT: indicates that the applicant has exceeded the limits.
     * @REQUEST_DENIED:indicates that the API did not complete the application, possibly because the applicant can not include a valid parameter sensor correctly.
     * @UNKNOWN_ERROR: indicates an unknown error.
     * @NO STATUS: indicates a failure to make the request.
     * @return returns string with state last request.
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestStatus() {
         return stockRequest[stockRequest.length-1][2];
    }
    /**
     * Returns URL associated with the last call made.
     * @return returns string with the last request URL (for example: "http://maps.google.com/maps/api/geocode/xml?address=Madrid&region=es&language=es&sensor=false").
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestURL() {
        return stockRequest[stockRequest.length-1][3];
    }
    /**
     * Returns information about the type of the last request made
     * @return returns string with information on the last request (for example: "Geocoding request").
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestInfo() {
         return stockRequest[stockRequest.length-1][4];
    }
    /**
     * Returns information about the possible exception generated in the last request.
     * @return eturns string with error information about the last request (for example, "No exception")
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestException() {
         return stockRequest[stockRequest.length-1][5];
    }
    
    
    
}