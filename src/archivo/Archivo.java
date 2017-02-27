package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

    private File f;
    private String archivo;

    public Archivo(String archivo) {
        f = new File(archivo);
        f.mkdirs();
    }

    public void ingresarLinea(String line) throws IOException {
        FileWriter fw = new FileWriter(f, true);
        fw.write(line + "\r\n");
        fw.close();
    }

    public void leerArchivo() throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String p;
        while ((p = br.readLine()) != null) {
            System.out.println(p);
        }
        br.close();

    }

    public int CantidadLineas() throws IOException {
        int x = 0;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String p = null;
        while ((p = br.readLine()) != null) {
            x++;
        }
        br.close();
        return x;
    }
    
    // devuelve la linea que corresponde a la posicion
    public String getElemento(int pos) throws IOException {
        if (pos < 0 || pos > CantidadLineas()) {
            return null;
        } else {
            String x = null;
            String p = null, dato;
            int tam = 0, prioridad;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            p = br.readLine();
            while (i < pos) {
                p = br.readLine();
                i++;
            }
            x = p;
            return x;
        }
    }
    
    // devuelve todas las lineas del archivo en un vector de string
    public String[] getElementos() throws IOException {
        int i = 0;
        String[] x = new String[CantidadLineas()];
        String p = null;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((p = br.readLine()) != null) {
            x[i] = p;
            i++;
        }
        return x;
    }
}
