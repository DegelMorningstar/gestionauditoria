
package Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ResultadosTabla {
    private int noPregunta, noCalificacionUno, noCalificacionDos, noCalificacionTres, noCalificacionCuatro, noCalificacionCinco;
    private double promedio;
    private double valorParcial;

    public ResultadosTabla(int noPregunta, int noCalificacionUno, int noCalificacionDos, int noCalificacionTres, int noCalificacionCuatro, int noCalificacionCinco) {
        this.noPregunta = noPregunta;
        this.noCalificacionUno = noCalificacionUno;
        this.noCalificacionDos = noCalificacionDos;
        this.noCalificacionTres = noCalificacionTres;
        this.noCalificacionCuatro = noCalificacionCuatro;
        this.noCalificacionCinco = noCalificacionCinco;
    }
    
    public ResultadosTabla(int noPregunta) {
        this.noPregunta = noPregunta;
        noCalificacionUno = 0;
        noCalificacionDos = 0;
        noCalificacionTres = 0;
        noCalificacionCuatro = 0;
        noCalificacionCinco = 0;
    }

    public int getNoPregunta() {
        return noPregunta;
    }

    public void setNoPregunta(int noPregunta) {
        this.noPregunta = noPregunta;
    }

    public int getNoCalificacionUno() {
        return noCalificacionUno;
    }

    public void setNoCalificacionUno(int noCalificacionUno) {
        this.noCalificacionUno = noCalificacionUno;
    }

    public int getNoCalificacionDos() {
        return noCalificacionDos;
    }

    public void setNoCalificacionDos(int noCalificacionDos) {
        this.noCalificacionDos = noCalificacionDos;
    }

    public int getNoCalificacionTres() {
        return noCalificacionTres;
    }

    public void setNoCalificacionTres(int noCalificacionTres) {
        this.noCalificacionTres = noCalificacionTres;
    }

    public int getNoCalificacionCuatro() {
        return noCalificacionCuatro;
    }

    public void setNoCalificacionCuatro(int noCalificacionCuatro) {
        this.noCalificacionCuatro = noCalificacionCuatro;
    }

    public int getNoCalificacionCinco() {
        return noCalificacionCinco;
    }

    public void setNoCalificacionCinco(int noCalificacionCinco) {
        this.noCalificacionCinco = noCalificacionCinco;
    }

    public double getPromedio() {
        double suma;
        suma = getNoCalificacionUno() + (getNoCalificacionDos()*2) + (getNoCalificacionTres()*3) + (getNoCalificacionCuatro()*4) + (getNoCalificacionCinco()*5);
        //promedio = suma / getTotalUnidades();
        valorParcial = suma / getTotalUnidades();
        BigDecimal bd = new BigDecimal(valorParcial).setScale(2, RoundingMode.HALF_UP);
        double promedio = bd.doubleValue();
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    private int getTotalUnidades() {
        int total;
        total = getNoCalificacionUno() + getNoCalificacionDos() + getNoCalificacionTres() + getNoCalificacionCuatro() + getNoCalificacionCinco();
        return total;
    }
    
    
    
}
