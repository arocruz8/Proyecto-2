/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generarFichas;

/**
 *
 * @author Gilberto Rodriguez
 */
public class Fichas {
    //atributos de la clase ficha
    private int especialidad;
    private int codigo;
    
    //constructor
    public Fichas(int especialidad, int codigo) {
        this.especialidad = especialidad;
        this.codigo = codigo;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
