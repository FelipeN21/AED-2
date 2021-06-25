import java.util.*;
import java.io.File;
import java.io.FileWriter; 
import java.io.BufferedWriter;

public class pesquisasequencial {
    public static boolean Vef(String teste) {// Metodo para verificar o flag
        boolean pa = true;

        if (teste.length() == 3 && teste.charAt(0) == 'F' && teste.charAt(1) == 'I' && teste.charAt(2) == 'M') {
            pa = false;
        }
        return pa;
    }

    public static void main(String args[]) {
long inicio = System.currentTimeMillis();// contabilizar o tempo de execucao
        String[] pubin = new String[500];
        String[] pubin2 = new String[500];

        int x = 0;

        pubin[x] = MyIO.readString();

        while (pubin[x].equals("FIM") != true) {
            x = x + 1;
            pubin[x] = MyIO.readString(); //leitura da entrada de dados
            // System.out.println(pubin[x]);

        }
        int y = 0;
        pubin2[y] = MyIO.readString();
        while (pubin2[y].equals("FIM") != true) { // leitura da segunda parte da entrada de dados
            y = y + 1;
            pubin2[y] = MyIO.readString();
            // System.out.println(pubin2[y]);

        }
int comparacoes = 0;
        boolean dale = false;
        for (int i = 0; i < y; i = i + 1) {
            dale = false;
            for (int j = 0; j < x; j = j + 1) {
                if (pubin2[i].equals(pubin[j])) { // realiza as comparacoes 
                    dale = true;

                }
comparacoes = comparacoes + 1;
            }
            if (dale == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }

        }


try {
    File arquivo = new File( "matricula_sequencial.txt" );
    arquivo.createNewFile();
    FileWriter fw = new FileWriter( arquivo );
    long fim = System.currentTimeMillis();
    fw.write("689661"+ "\t" + (fim - inicio) +"\t" + comparacoes);
    fw.close();
    
} catch (Exception e) {
  System.out.print("ERROR");
}


    }

}
