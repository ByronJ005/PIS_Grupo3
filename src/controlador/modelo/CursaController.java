/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelo;

import controlador.TDALista.LinkedList;
import controlador.TDALista.exceptions.VacioException;
import controlador.listas.DAO.DataAccesObject;
//import java.lang.reflect.InvocationTargetException;
import modelo.Cursa;

/**
 *
 * @author apolo
 */
public class CursaController extends DataAccesObject<Cursa>{
    
    public CursaController(Class<Cursa> clazz) {
        super(Cursa.class);
    }
    private Cursa cursa = new Cursa();
    private LinkedList<Cursa> cursas = new LinkedList<>();
    
    public Boolean guardar() {
        cursa.setId(generated_id());
        return save(cursa);
    }

    public Boolean update(int fila) {
        return update(cursa, fila);
    }

//    public String generatedCode() {
//        StringBuilder code = new StringBuilder();
//        Integer length = listall().getSize() + 1;
//        Integer pos = length.toString().length();
//        for (int i = 0; i < (10 - pos); i++) {
//            code.append("0");
//        }
//        code.append(length.toString());
//        return code.toString();
//    }


    public LinkedList<Cursa> mergeSort(LinkedList<Cursa> lista, Integer type, String field) {
        Cursa[] m = lista.toArray();
        mergeSort(m, 0, m.length - 1, field, type);
        return lista = lista.toList(m);
    }

    private void mergeSort(Cursa[] m, Integer ini, Integer fin, String field, Integer type) {
        if (ini < fin) {
            int medio = (ini + fin) / 2;
            mergeSort(m, ini, medio, field, type);
            mergeSort(m, medio + 1, fin, field, type);
            merge(m, ini, medio, fin, field, type);
        }
    }

    private void merge(Cursa[] m, Integer ini, Integer medio, Integer fin, String field, Integer type) {
        Integer izq = ini;
        Integer der = medio + 1;
        Integer k = 0;
        Integer n = fin - ini + 1;
        Cursa[] result = new Cursa[n];
        while (izq <= medio && der <= fin) {
            if (m[izq].comparar(m[der], field, type)) {
                result[k] = m[izq];
                izq++;
            } else {
                result[k] = m[der];
                der++;
            }
            k++;
        }
        while (izq <= medio) {
            result[k] = m[izq];
            izq++;
            k++;
        }
        while (der <= fin) {
            result[k] = m[der];
            der++;
            k++;
        }
        for (k = 0; k < n; k++) {
            m[ini + k] = result[k];
        }
    }

    public LinkedList<Cursa> quickSort(LinkedList<Cursa> lista, Integer type, String field) {
        Cursa[] m = lista.toArray();
        Integer fin = m.length - 1;
        quickSort(m, type, field, 0, fin);
        //setVentas(lista.toList(m));
        return lista = lista.toList(m);
    }

    private void quickSort(Cursa[] m, Integer type, String field, Integer inicio, Integer fin) {
        
        if (inicio >= fin) return;
        
        Cursa pivote = m[inicio];
        Integer elemIzq = inicio + 1;
        Integer elemDer = fin;
        while (elemIzq <= elemDer) {
            while (elemIzq <= fin && m[elemIzq].comparar(pivote, field, type)) {
                elemIzq++;
            }
            while (elemDer > inicio && !m[elemDer].comparar(pivote, field, type)) {
                elemDer--;
            }
            if (elemIzq < elemDer) {
                Cursa temp = m[elemIzq];
                m[elemIzq] = m[elemDer];
                m[elemDer] = temp;
            }
        }
        if (elemDer > inicio) {
            Cursa temp = m[inicio];
            m[inicio] = m[elemDer];
            m[elemDer] = temp;
        }
        quickSort(m, type, field, inicio, elemDer - 1);
        quickSort(m, type, field, elemDer + 1, fin);
    }

    public LinkedList<Cursa> buscar(LinkedList<Cursa> lista, String text) throws VacioException, Exception {
        LinkedList<Cursa> lo = this.quickSort(lista, 0, "id");
        Cursa[] m = lo.toArray();
        LinkedList<Cursa> result = new LinkedList<>();
        for (int i = 0; i < lo.getSize(); i++) {
            if (m[i].getId().toString().toLowerCase().contains(text.toLowerCase())) {
                result.add(m[i]);
            }
        }
        return result;
    }
    
//    public Cursa binaria(LinkedList<Cursa> lista, String field, String text) throws InvocationTargetException, IllegalAccessException{
//        Cursa[] m = this.quickSort(lista, 0, field).toArray();
//        Integer fin = m.length - 1;
//        Integer inicio = 0;
//        Cursa result = binaria(m, fin, inicio, field, text);
//        if(result != null)
//            return result;
//        else System.out.println("No se pudo encontrar na");
//        return null;
//        
//    }
//    public Cursa binaria(Cursa[] m, int fin, int inicio,String field, String text) throws InvocationTargetException, IllegalAccessException {
//            if (inicio > fin) {
//                return null;
//            } else {
//                Integer medio = (inicio + fin) / 2;
//                Object data = Utilidades.getData(m[medio], field);
//                System.out.println(data.toString());
//                //if(Double.parseDouble(data.toString()) == Double.parseDouble(text))
//                if (data.toString().equalsIgnoreCase(text)) {
//                    return m[medio];
//                } else 
//                    if (data.toString().compareToIgnoreCase(text) < 0) {
//                        return binaria(m,fin, medio + 1, field, text);
//                    } else {
//                        return binaria(m, medio - 1, inicio, field, text);
//                }
//            }
//    }
//    public LinkedList<Cursa> binariaLineal(LinkedList<Cursa> lista, String texto, String field) throws InvocationTargetException, IllegalAccessException {
//        LinkedList<Cursa> lo = this.quickSort(lista, 0, field);
//        Cursa[] m = lo.toArray();
//        Integer inicio = 0;
//        Integer fin = m.length - 1;
//        LinkedList<Cursa> result = new LinkedList<>();
//        //System.out.println(Utilidades.getData(m[inicio], field));
//        //Field fiel = Utilidades.getField(lista.getClass(), field);
//        //Object type = Utilidades.getTypeField(venta.getClass(), texto);
//        //System.out.println(type.toString());
//        while (inicio <= fin) {
//            int medio = (inicio + fin) / 2;
//            Object data = Utilidades.getData(m[medio], field);
//            
//            
//            if (Double.parseDouble(data.toString()) == Double.parseDouble(texto)){
//                System.out.println("Hola mundo");
//                result.add(m[medio]);
//                break;
//            } else {
//                if (Double.parseDouble(data.toString()) > Double.parseDouble(texto)) {
//                    fin = medio - 1;
//                } else {
//                    inicio = medio + 1;
//                }
//            }
//        }
//        return result;
//    }

    /**
     * @return the cursa
     */
    public Cursa getCursa() {
        if(cursa == null) cursa = new Cursa();
        return cursa;
    }

    /**
     * @param cursa the cursa to set
     */
    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }

    /**
     * @return the cursas
     */
    public LinkedList<Cursa> getCursas() {
        if(cursas.isEmpty()) cursas = listall();
        return cursas;
    }

    /**
     * @param cursas the cursas to set
     */
    public void setCursas(LinkedList<Cursa> cursas) {
        this.cursas = cursas;
    }
}
