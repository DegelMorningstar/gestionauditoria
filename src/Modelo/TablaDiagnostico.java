
package Modelo;

public class TablaDiagnostico {
    private String promedioAnterior, promedioActual, pregunta;
    
    public TablaDiagnostico(String promedioAnterior, String promedioActual, String pregunta) {
        this.promedioAnterior = promedioAnterior;
        this.promedioActual = promedioActual;
        this.pregunta = pregunta;
    }

    public TablaDiagnostico() {
    }

    public String getPromedioAnterior() {
        return promedioAnterior;
    }

    public void setPromedioAnterior(String promedioAnterior) {
        this.promedioAnterior = promedioAnterior;
    }

    public String getPromedioActual() {
        return promedioActual;
    }

    public void setPromedioActual(String promedioActual) {
        this.promedioActual = promedioActual;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

}
