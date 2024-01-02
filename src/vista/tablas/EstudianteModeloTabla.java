/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import Controlador.TDALista.listaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;

/**
 *
 * @author sakotaz
 */
public class EstudianteModeloTabla extends AbstractTableModel{
    private listaEnlazada <Estudiante> lista = new listaEnlazada <Estudiante>();
    
    public EstudianteModeloTabla (listaEnlazada <Estudiante> list){
        this.lista = list;
    }
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Estudiante e = null;
        try {
            e = lista.get(i);  
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }    
        switch (i1) {
                case 0:
                    return (e != null) ? e.getId() : " ";
                case 1:
                    return (e != null) ? e.getNombres() : " ";
                case 2:
                    return (e != null) ? e.getApellidos(): " ";
                case 3:
                    return (e != null) ? e.getCedula() : " ";
                case 4: 
                    return (e != null) ? e.getTelefono(): " ";
                case 5:
                    return (e != null) ? (e.getGratuidad()== true ? "Si" : "No") : " ";
                default:
                    return null;
        } 
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombres";
            case 2: 
                return "Apellidos";
            case 3:
                return "Cedula";
            case 4:
                return "Telefono";
            case 5:
                return "¿Gratuidad?";
            default:
                return " ";
        }
    }

    public listaEnlazada <Estudiante> getAutos() {
        return lista;
    }

    public void setAutos(listaEnlazada <Estudiante> estudiantes) {
        this.lista = estudiantes;
    }
    
}
