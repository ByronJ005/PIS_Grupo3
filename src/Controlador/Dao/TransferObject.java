/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.Dao;

import Controlador.TDALista.listaEnlazada;


/**
 *
 * @author sakotaz
 */
public interface TransferObject <T>{
    public Boolean save(T data);
    public Boolean update(T data, Integer index);
    public listaEnlazada <T> listaAll();
    public T find(Integer id); 
}
