/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Controlador.Dao.DataAccesObject;
import Controlador.TDALista.exeptions.VacioException;
import Controlador.TDALista.listaEnlazada;
import Controlador.Utilidades.Utilidades;
import java.lang.reflect.Field;
import modelo.Estudiante;

/**
 *
 * @author sakotaz
 */
public class EstudianteControlador extends DataAccesObject <Estudiante>{
    private listaEnlazada <Estudiante> estudiantes = new listaEnlazada<Estudiante>();
    private Estudiante estudiante = new Estudiante();

    public EstudianteControlador() {
        super(Estudiante.class);
    }

    public listaEnlazada <Estudiante> getEstudiantes() {
        if (estudiantes.isEmpty())
            estudiantes = listaAll();
        return estudiantes;
    }

    public void setEstudiantes(listaEnlazada <Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante getEstudiante() {
        if (estudiante == null)
            estudiante = new Estudiante();
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public Boolean guardar(){
        estudiante.setId(generated_id());
        return save(estudiante);
    }
    
    public Boolean modificar(Integer index){
        return update(estudiante, index);
    }
    
    private void intercambio(Estudiante e[], int i, int j){
        Estudiante aux = e[j];
        e[j] = e[i];
        e[i] = aux;
    }  
    
    public listaEnlazada <Estudiante> ordenarQuickSort (listaEnlazada <Estudiante> lista, Integer type, String atribute) throws VacioException{
        Estudiante estudent[] = lista.toArray();
        listaEnlazada <Estudiante> a = ordenarQuickSort(estudent, type, atribute, 0, lista.getSize()-1);
        return a;
    }
    
    
    public listaEnlazada <Estudiante> ordenarQuickSort(Estudiante estudiante[], Integer type, String atribute, Integer primero, Integer ultimo) throws VacioException{
        listaEnlazada <Estudiante> es = new listaEnlazada<>();
        Field faux = Utilidades.getField(Estudiante.class, atribute);
        if (faux != null) {
            int i, j, central;
            Estudiante pivote;
            central = (primero + ultimo) / 2;                   // establecemos el valor central del arreglo
            pivote = estudiante[central];    //id - 12500 -- pos - 2                       //fijamos al pivote como el valor central del arreglo  
            i = primero; //0
            j = ultimo; // 4
            do {                                //realizamos un ciclo siempre y cuando i y j no se crucen
                while (estudiante[i].comparar(pivote, type, atribute)) {
                    
                    i++;      // en estos dos whiles verificaremos que los valores sean menores y mayores respectivamente del pivote
                }
                while (estudiante[j].comparar(pivote, type, atribute, 1)) {
                    j--; //3
                }
                if (i <= j) {                     // si no estan bien colocados verificamos que i y j no se crucen y los intercambiamos para ordenar
                    intercambio(estudiante, i, j);
                    i++; //1  //4
                    j--; //2  //2
                }
            } while (i <= j);
            if (primero < j) // si el arreglo aun puede partirse se aplica la recursividadd y se vuelve a llamar la funcion 
            {
                //lista = lista.toList(a);
                ordenarQuickSort(estudiante, type, atribute, primero, j);
            }

            if (i < ultimo) {
                //lista = lista.toList(a);
                ordenarQuickSort(estudiante, type, atribute, i, ultimo);
            }
            
        } else {
            System.out.println("de algo valido pórfa");
        }
        es = es.toList(estudiante);        
        return es;
    }
    
    
}
