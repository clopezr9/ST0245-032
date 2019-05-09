import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AhoraSI {
    Map <String,Bee> bOrga = new HashMap<String,Bee>();
    public void main(int bQuantity){
        hashFunction(readFile(bQuantity), bQuantity);
    }

    private Bee[] readFile(int bQuantity){
        long start = System.currentTimeMillis();
        Bee [] Bees = new Bee[bQuantity];
        final String nombreDelArchivo = "ConjuntoDeDatosCon" + bQuantity + "abejas.txt";
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            if (index<bQuantity){
                while (lineaActual != null){ // Mientras no llegue al fin del archivo
                    String [] coordenates = lineaActual.split(",");
                    Bee bee = new Bee(Float.parseFloat(coordenates[0]) * (-111111.2f),
                            Float.parseFloat(coordenates[1]) * (111111.2f),
                            Float.parseFloat(coordenates[2]));
                    Bees[index] = bee;
                    lineaActual = br.readLine();
                    index++;
                }
            }
        }   catch(IOException ioe) {
            System.out.println("There's a problem with the file");

        }
        long end = System.currentTimeMillis() - start;
        Runtime m=Runtime.getRuntime();
        long memoriaUsada=(m.totalMemory()-m.freeMemory());
        System.out.println(end);
        System.out.println(memoriaUsada);
        return Bees;
    }

    private String toCubeString(int n, int m, int d) {
        return "n" + Integer.toString(n) + "m" + Integer.toString(m) + "d" + Integer.toString(d);
    }

    private void hashFunction (Bee [] bees, int bQuantity){
        long start = System.currentTimeMillis();
        final String fileName = "respuestaConjuntoDeDatosCon" + bQuantity + "abejas.txt";  
        float l = 57.0f;
        int length = bees.length;
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for(int i=0; i<length; i++){
                int n = (int)Math.round(bees[i].getX()/l);
                int m = (int)Math.round(bees[i].getY()/l);
                int d = (int)Math.round(bees[i].getZ()/l);

                String cubeString = toCubeString(n, m, d);

                if (bOrga.get(cubeString) == null) {
                    bOrga.put(cubeString, bees[i]);
                } else {
                    writer.println((bees[i].getX()/-111111.2)+ "," 
                        + (bees[i].getY()/111111.2)+ "," + bees[i].getZ());
                }
            }
            writer.close();
        }
        catch(IOException ioe) {
            System.out.println("Error making new file");
        }  
        long end = System.currentTimeMillis() - start;
        Runtime m=Runtime.getRuntime();
        long memoriaUsada=(m.totalMemory()-m.freeMemory());
        System.out.println(end);
        System.out.println(memoriaUsada);
    }
}

