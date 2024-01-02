/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.TDALista.listaEnlazada;
import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakotaz
 */
public class DataAccesObject <T> implements TransferObject<T>{
    
    private XStream xstream;
    private Class clazz;   
    private String URL;

    public DataAccesObject(Class <T> clazz) {
        xstream = Connection.getXstream();
        this.clazz = clazz;
        URL = Connection.getURL() + this.clazz.getSimpleName()+".json";
    }
    
    //clazz propeidad de los objetos para manipular los datos de los objetos 
    
    
    @Override
    public Boolean save(T data) {
        listaEnlazada <T> list = listaAll();
        list.add(data);
        try {
            //this.xstream.alias("lista", listaEnlazada.class);
            this.xstream.toXML(list, new FileOutputStream(URL));    
            return true;
        } catch (Exception e) {
            System.out.println("EROR save error + "+ e.getMessage());
            return false;
        }
       
    }

    @Override
    public Boolean update(T data, Integer index) {
        listaEnlazada <T> list = listaAll();
        try {
            list.update(data, index);
            this.xstream.toXML(list, new FileOutputStream(URL));
            return true;
        } catch (Exception e) {
            System.out.println("Error no se pudo moficiar ERROr" + e.getMessage());
            return false;
        }
        
    }

    @Override
    public listaEnlazada<T> listaAll() {
       listaEnlazada <T> list = new listaEnlazada<>();
       try {
           list = (listaEnlazada<T>)xstream.fromXML(new FileReader(URL));
       } catch (Exception e) {
           System.out.println("ERROR listar all " + e.getMessage());
       }
       
       return list;
    }

    @Override
    public T find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Integer generated_id(){
        return listaAll().getSize() + 1;
    }
}


