
package Modelo;


public class TablaDatos {
    private String promedio, tabla, grafica;

    public TablaDatos() {
    }

    public TablaDatos(String promedio, String tabla, String grafica) {
        this.promedio = promedio;
        this.tabla = tabla;
        this.grafica = grafica;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getGrafica() {
        return grafica;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }
    
}
