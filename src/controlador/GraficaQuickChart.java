package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class GraficaQuickChart {

    public static void generarGrafico(float[] promedios) throws Exception {
        String imageUrl = "https://quickchart.io/chart?c=%7B%0D%0A%20%20%20%20type%3A%20%27bar%27%2C%0D%0A%20%20%20%20data%3A%20%7B%0D%0A%20%20%20%20%20%20%20%20labels%3A%20%5B1%2C%202%2C%203%2C%204%2C%205%2C%206%2C%207%2C%208%2C%209%5D%2C%0D%0A%20%20%20%20%20%20%20%20datasets%3A%20%5B%7B%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20label%3A%20%27%27%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20data%3A%20%5B"
                +promedios[0]+"%2C%20"
                +promedios[1]+"%2C%20"
                +promedios[2]+"%2C%20"
                +promedios[3]+"%2C%20"
                +promedios[4]+"%2C%20"
                +promedios[5]+"%2C%20"
                +promedios[6]+"%2C%20"
                +promedios[7]+"%2C%20"
                +promedios[8]+
                "%5D%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20backgroundColor%3A%20%5B%27%23FE642E%27%2C%20%27%23FE9A2E%27%2C%20%27%2300FF80%27%2C%20%27%2381F7F3%27%2C%20%27%230174DF%27%2C%20%27%238000FF%27%2C%20%27%23DF0174%27%2C%20%27%236E6E6E%27%2C%20%27%23FE642E%27%5D%0D%0A%20%20%20%20%20%20%20%20%7D%5D%0D%0A%20%20%20%20%7D%2C%0D%0A%20%20%20%20options%3A%20%7B%0D%0A%20%20%20%20%20%20%20%20legend%3A%20%7B%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20display%3A%20false%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%7D%2C%0D%0A%20%20%20%20%20%20%20%20plugins%3A%20%7B%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20datalabels%3A%20%7B%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20anchor%3A%20%27end%27%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20align%3A%20%27top%27%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20color%3A%20%27%23000%27%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20backgroundColor%3A%20%27rgba(0%2C%200%2C%200%2C%200)%27%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20borderColor%3A%20%27rgba(0%2C%200%2C%200%2C%200)%27%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20borderWidth%3A%201%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20borderRadius%3A%205%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20formatter%3A%20(value)%20%3D%3E%20%7B%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20return%20value%20%2B%20%27%27%3B%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0D%0A%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0D%0A%20%20%20%20%20%20%20%20%7D%2C%0D%0A%20%20%20%20%7D%2C%0D%0A%7D";
        String destinationFile = "src/Archivos/" + "grafica.png";

        saveImage(imageUrl, destinationFile);
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
