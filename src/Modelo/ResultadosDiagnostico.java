
package Modelo;


public class ResultadosDiagnostico {
    private String imagenDiagnostico, recomendaciones;

    public ResultadosDiagnostico() {
    }

    public ResultadosDiagnostico(String imagenDiagnostico, String recomendaciones) {
        this.imagenDiagnostico = imagenDiagnostico;
        this.recomendaciones = recomendaciones;
    }

    public String getImagenDiagnostico() {
        return imagenDiagnostico;
    }

    public void setImagenDiagnostico(String imagenDiagnostico) {
        this.imagenDiagnostico = imagenDiagnostico;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    
}
