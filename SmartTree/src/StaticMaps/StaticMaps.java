package StaticMaps;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.imageio.ImageIO;
import javax.xml.xpath.XPath;
import org.w3c.dom.Document;

/**
 * This class contains static functions to create maps and get your image (Image format). 
 * These maps contain a marker in the center of that map.
 * @author Luis Marcos
 */
public class StaticMaps extends MapsJava {
    private final String URLRoot="http://maps.googleapis.com/maps/api/staticmap";
    
    /**
     * Sets the format type of the static map. Possible values ​​are:
     * @Roadmap: Specifies an image map standard roads, as is usually displayed on the page of Google Maps.
     * @Satellite: Specifies a satellite image.
     * @Hybrid: Specifies an image of physical relief map, which shows topography and vegetation.
     * @Terrain: Specifies a hybrid of satellite image and image map of roads, in which a transparent layer of major streets and place names in the satellite image appears.
     */
 
    public enum Maptype{roadmap, satellite, hybrid,terrain}
    
    @Override
    protected void onError(URL urlRequest, String status, Exception ex) {
        super.storageRequest(urlRequest.toString(), "Static maps request", "NO STATUS", ex);
    }

    @Override
    protected String getStatus(XPath xpath, Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void storeInfoRequest(URL urlRequest, String info, String status, Exception exception) {
        super.storageRequest(urlRequest.toString(), "Static maps request", "OK", exception);
    }
    
    /**
     * Create a static map to the data shown in the different parameters of the function
     * @param centerAddress center of the map to be created ("latitude, longitude")
     * @param zoom Sets the zoom level of the map, which determines the level of magnification. 
     * Values ​​0 worldwide and show greater than 21 show individual buildings
     * @param size map size that is generated
     * @param maptype defines the type of map that will generate
     * @return Returns a static map image with the associated. On error, returns null
     * @throws java.net.MalformedURLException
     * @throws java.io.UnsupportedEncodingException
     * @see Format
     * @see Maptype
     */
    public Image getStaticMap(String centerAddress,int zoom,Dimension size, Maptype maptype) throws MalformedURLException, UnsupportedEncodingException{
        URL url=new URL(URLRoot + "?center=" + URLEncoder.encode(centerAddress, "utf-8") + "&zoom=" + zoom +
                "&size=" + size.width + "x" + size.height + "&maptype=" + maptype.toString() + 
                "&markers=" + URLEncoder.encode(centerAddress, "utf-8") + super.getSelectPropertiesRequest());
        try {
            Image imageReturn;
            imageReturn=ImageIO.read(url);
            storeInfoRequest(url,null,null,null);
            return imageReturn;
        } catch (IOException e) {
            onError(url, "NO STATUS", e);
            return null;
        }
    }
   
   
}
