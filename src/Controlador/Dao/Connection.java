/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;

/**
 *
 * @author sakotaz
 */
public class Connection {
    private static String URL = "data" + File.separatorChar;                    //s
    private static XStream xstream;
    
    private Connection(){        
    }

    public static String getURL() {
        return URL;
    }

//    public static void setURL(String URL) {
//        this.URL = URL;
//    }

    public static XStream getXstream() {
        if (xstream == null){
            xstream = new XStream(new JettisonMappedXmlDriver());
            //xstream.setMode(XStream.NO_REFERENCES);
            xstream.addPermission(AnyTypePermission.ANY);
        }
        return xstream;
    }
       
//    public static void setXstream(XStream xstream) {
//        this.xstream = xstream;
//    }
    
    
}
