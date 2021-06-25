import java.io.File;
import java.io.RandomAccessFile;

public class arquivo {
// Chamamento das funçoes e captaçao de dados
    public static void main(String[] args) {
        int n = MyIO.readInt();
        op_File(n);
        rd_arch(n);

    }
//Leitura do arquivo
    public static void rd_arch(int n) {
        File arquivo = new File("arquivo.txt");

        try {// tenta abrir o arquivo
            if (!arquivo.exists()) {
                throw new Exception();
            }
            RandomAccessFile file = new RandomAccessFile(arquivo, "r");

            for (int i = 0; i < n; i++) {
                file.seek((n - 1 - i) * 8);
                double nu = file.readDouble();
                if (nu % 1 != 0)
                    MyIO.println(nu);
                else
                    MyIO.println((int) nu);
            }
            file.close();
        }
// caso ocorra algum erro ele o capta
        catch (Exception e) {

        }
    }
//Abertura do arquivo
    public static void op_File(int n) {
        double catar = 0;
        File arquivo = new File("arquivo.txt");
        try { // tenta abrir o arquivo
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            if (!arquivo.canWrite()) {
                throw new Exception();
            }
            RandomAccessFile file = new RandomAccessFile(arquivo, "rw");
            for (int i = 0; i < n; i++) {

                catar = MyIO.readDouble();
                file.writeDouble(catar);
            }
            file.close();
        }
// caso ocorra algum erro ele o capta
        catch (Exception e) {

        }

    }

}