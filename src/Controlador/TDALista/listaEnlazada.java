/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDALista;

import Controlador.TDALista.exeptions.VacioException;



/**
 *
 * @author sakotaz
 */
public class listaEnlazada <E> {
    private Nodo <E> head;
    private Nodo <E> last;
    private Integer size;

    
    
    public listaEnlazada() {
        head = null;
        last = null;
        size = 0;
    }
    
    public Boolean isEmpty (){
        return head == null || getSize() == 0; 
    }
    
    public E[] toArray(){
        Class clazz = null;
        E[] matriz = null;
        if (this.size > 0){
            clazz = head.getData().getClass();
            matriz = (E[])java.lang.reflect.Array.newInstance(clazz, size);
            Nodo <E> aux = head;
            for (int i = 0; i < size; i++) {
                matriz[i] = aux.getData();
                aux = aux.getNext();
            }
        }
        return matriz;
    }
    
    public listaEnlazada <E> toList(E[] m){
        clear();
        for (int i = 0; i < m.length; i++) {
            this.add(m[i]);
        }
        return this;
    }
    
    protected void addFirts(E data ){
        if(isEmpty()){
            Nodo <E> aux = new Nodo<>(data, null);
            head = aux;
            last = aux;
        }else {
            Nodo <E> headOld = head;
            Nodo <E> aux = new Nodo<>(data, headOld);
            head = aux;
        }
        size++;
    }
    
    protected void addlast(E data){
        if(isEmpty()){
            addFirts(data);
        } else {
            Nodo <E> aux = new Nodo<>(data, null);
            last.setNext(aux);
            last = aux;
            size++;
        }
        
    }
    
    public void add(E data){
        addlast(data);
    }
    
    public void add(E data, Integer pos) throws VacioException{
        if(pos == 0){
            addFirts(data);
        } else if (pos == getSize()) {
            addlast(data);
        } else {
            //12 2 23 2 --> 2 jasmine / alice...
            Nodo <E> search_preview = getNode(pos - 1);
            Nodo <E> search = getNode(pos);
            Nodo <E> aux = new Nodo <> (data, search);
            search_preview.setNext(aux);
            size++;
        }
    }
    
    //head.lastSiguiente
    
    
        
    public void update(E data, Integer pos) throws VacioException{      
        //Nodo <E> search_preview = getNode(pos - 1);
        Nodo <E> search = getNode(pos);
        Nodo <E> newNodo = search;
        newNodo.setData(data);        
    }
    
    public String print(){
        StringBuilder sb = new StringBuilder();
        if(isEmpty()){
            sb.append("lista Vacia");
        } else {
            Nodo <E> aux = head;
            while (aux != null){
                sb.append(aux.getData().toString()).append("/n");
                aux = aux.getNext();
            }
        }
        return sb.toString();
    }
    
     public E getlast() throws VacioException{
        if(isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {
            return last.getData();
        }
    }
    
    public E getFirst() throws VacioException{
        if(isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {
            return head.getData();
        }
    }
    
    public E get(Integer index) throws VacioException{
        if(isEmpty()){
            throw new VacioException("Lista Vacia");
        } else if (index.intValue() < 0 || index.intValue() >= size){
            throw new IndexOutOfBoundsException("Fuera de rango ");
        } else if (index.intValue() ==  0 ){
            return getFirst();
        } else if (index.intValue() == (size - 1)) {
            return getlast();
        } else {
            Nodo <E> search = getNode(index);
            return search.getData();
        }
    }
    
    private Nodo <E> getNode(Integer pos) throws VacioException{
        if (isEmpty()){
            throw new VacioException("ERROR LA LISTA ESTA VACIA");
        } else if (pos < 0 || pos >= getSize()) {
            throw new IndexOutOfBoundsException("ERROR ESTA FUERA DE LS LIMITES DE LA LISTA");
        } else if (pos == 0 ) {
            return head;
        } else if (pos == (getSize() - 1)) {
            return last;
        } else {
            Nodo <E> search = head;
            Integer cont = 0;
            while(cont < pos) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }
    
    public static void main(String[] args) {
        listaEnlazada <Integer> numerics = new listaEnlazada<>();
        for (int i = 0; i < 10; i++) {
            Integer aux = (int)(Math.random()*1000);
            numerics.add(aux);
        }

        //Controlador punto lista crear y pegar eso
        
        try {
            numerics.add(1, numerics.getSize() - 2);
            System.out.println(numerics.print());
            System.out.println(numerics.getNode(9));
            System.out.println("Tmaño de la lista " + numerics.getSize());
            //System.out.println(numerics.getNode(1).getData().toString());
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
       
    }
    
    
    public Integer getSize() {
        return size;
    }
    
    public void clear(){
        head = null;
        last = null;
        size = 0;
    }
    
    public E deleteFirts() throws VacioException{
        if(isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {
            E element = head.getData();
            Nodo <E> aux = head.getNext();
            head = aux;
            if(size.intValue() == 1){
                last = null;
            }
            size--;
            return element;
        }
    }
    
    public E deleteLast() throws VacioException {
        if(isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {
            E element = head.getData();
            Nodo <E> aux = getNode(size - 2);
            if (aux == null){
                last = null;
                if(size == 2){
                    last = head;
                } else {
                    head = null;
                }
            } else {
                last = null;
                last = aux;
                last.setNext(null);
            }
            size--;
            return element;
        }
    }
    
    public E delete(Integer i) throws VacioException{
        if (isEmpty()){
            throw new VacioException("ERROR LA LISTA ESTA VACIA");
        } else if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException("ERROR ESTA FUERA DE LS LIMITES DE LA LISTA");
        } else if (i == 0 ) {
            return deleteFirts();
        } else if (i == (getSize() - 1)) {
            return deleteLast();
        } else {
            Nodo <E> preview = getNode(i - 1);
            Nodo <E> actually = getNode(i);
            E element = preview.getData();
            Nodo <E> next = actually.getNext();
            actually = null;
            preview.setNext(next);
            size--;
            return element;
        }
    }
    
}
///
//{[( --<> se meten en la pila 
// se elimina con las parejas
