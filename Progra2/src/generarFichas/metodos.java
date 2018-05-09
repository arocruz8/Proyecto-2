package generarFichas;
import estructurasDatos.*;
import java.util.LinkedList;
public class metodos{
    
    public void atender(Clientes pa, colaGenerica<Fichas> o, colaGenerica<Fichas> p, colaGenerica<Fichas> n) {
        if (pa.getEspecialidad1() == Constantes.Adulto_mayor) {
            Fichas fi = pa.getFicha1();
            o.add(fi);
            // reseteo
            pa.setFicha1(null);
            pa.setEspecialidad1(Constantes.Regular);
        } else if (pa.getEspecialidad1() == Constantes.Embarazada) {
            Fichas fi = pa.getFicha1();
            n.add(fi);
            // reseteo
            pa.setFicha1(null);
            pa.setEspecialidad1(Constantes.Regular);
        } else if (pa.getEspecialidad1() == Constantes.Embarazada) {
            Fichas fi = pa.getFicha1();
            n.add(fi);
            // reseteo
            pa.setFicha1(null);
            pa.setEspecialidad1(Constantes.Regular);
        }
    }
    
    public void calcularEspecidadMasRequerida(colaGenerica<Fichas> o, colaGenerica<Fichas> n, colaGenerica<Fichas> p) {
        int no = o.size();
        int np = p.size();
        int nn = n.size();

        if (no < np && no < nn) {
            System.out.println("Adulto mayor es la prioridad más requerida");
        }
        if (np < no && np < nn) {
            System.out.println("Embarazadas es la prioridad más requerido");
        }
        if (nn < no && nn < np) {
            System.out.println("Discapacidad es la prioridad más requerido");
        }
    }
    
    
    public void asignarFichas(colaGenerica<Fichas> o, colaGenerica<Fichas> n, colaGenerica<Fichas> p, LinkedList<Clientes> clientes) {
        int m = clientes.size();
        for (int i = 0; i < m; i++) {
            Clientes pa = clientes.remove();

            if (pa.getEspecialidad1() == Constantes.Embarazada) {
                Fichas fi = n.remove();
                pa.setFicha1(fi);
            } else if (pa.getEspecialidad1() == Constantes.Adulto_mayor) {
                Fichas fi = o.remove();
                pa.setFicha1(fi);
            } else if (pa.getEspecialidad1() == Constantes.Discapaciad) {
                Fichas fi = p.remove();
                pa.setFicha1(fi);
            }
            clientes.add(pa);
        }
    }
    
    public void mostrar(colaGenerica<Fichas> o) {

        colaGenerica<Fichas> temp = new colaGenerica<Fichas>();

        while (!o.isEmpty()) {
            Fichas fi = o.remove();
            System.out.println(" Ficha: " + fi.getEspecialidad() + " " + fi.getCodigo());
            temp.add(fi);
        }
        while (!temp.isEmpty()) {
            Fichas fi = temp.remove();
            o.add(fi);
        }
    }

    public void mostrar(LinkedList<Clientes> cola) {
        int n = cola.size();
        for (int i = 0; i < n; i++) {
            Clientes pa = cola.remove();
            System.out.println(" Cliente: " + pa.getNombre() + " Prioridad: " + pa.getEspecialidad1());
            cola.add(pa);
        }
    }
    
    public static void main(String[] args) {
        metodos m = new metodos();
        colaGenerica<Fichas> o = new colaGenerica<Fichas>();
        colaGenerica<Fichas> n = new colaGenerica<Fichas>();
        colaGenerica<Fichas> p = new colaGenerica<Fichas>();

        // llenar
        for (int i = 1; i <= 20; i++) {
            o.add(new Fichas(Constantes.Adulto_mayor, i));
            n.add(new Fichas(Constantes.Embarazada, i));
            p.add(new Fichas(Constantes.Discapaciad, i));
        }

        System.out.println("Adulto mayor");
        m.mostrar(o);
        System.out.println("Embarazada");
        m.mostrar(n);
        System.out.println("Discapacidad");
        m.mostrar(p);

        LinkedList<Clientes> clientes = new LinkedList<Clientes>();

        clientes.add(new Clientes("Juan", Constantes.Adulto_mayor, "percedero"));
        clientes.add(new Clientes("Rosa", Constantes.Discapaciad, "no percedero"));
        clientes.add(new Clientes("Irene", Constantes.Embarazada, "percedero"));
        clientes.add(new Clientes("Pedro", Constantes.Adulto_mayor, "no perceder"));
        

        System.out.println("CLIENTES");
        m.mostrar(clientes);

        // Solución 1
        m.asignarFichas(o, n, p, clientes);


        System.out.println("Adulto mayor");
        m.mostrar(o);
        System.out.println("Embarazada");
        m.mostrar(n);
        System.out.println("Discapaciad");
        m.mostrar(p);

        // Solución 2
        // Calcular cual es la especialidad mas requerida
        m.calcularEspecidadMasRequerida(o, n, p);

        // Solución 3
        // Realizar el metodo atender para devolver la ficha a su lugar

        Clientes pa = clientes.remove();
        System.out.println("> cliente: " + pa.getNombre());
        m.atender(pa, o, p, n);

    }
}
