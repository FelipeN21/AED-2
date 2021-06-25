import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.File;
import java.io.FileWriter; 

class CelulaD {
    public Musica elemento; //elementos da celula
    public CelulaD ant;
    public CelulaD prox;

    //construtor da celulda dupla
    public CelulaD() {
        this(null);
    }
    //construtor com passagem de parametros da celula 
    public CelulaD(Musica elemento) {
        this.elemento = elemento;
        this.ant = this.prox = null;
    }
}

class ListaDupla {
	private CelulaD first; // cria as referencias para inicio e fim da lista
	private CelulaD last;

	public ListaDupla() {
		first = new CelulaD(); //construtor padrao da classe
		last = first;
	}

    public void inserirFim(Musica x) { //insere no fim da lista
        last.prox = new CelulaD(x);
      last.prox.ant = last;
        last = last.prox;
    }

	public void mostrar() {
		
		for (CelulaD i = first.prox; i != null; i = i.prox) {
			System.out.println(i.elemento);
		}
		
	}




}


class Quicksort  {
    private Musica[] musicas;
    private int n;

    public int comparacoes = 0;

    public int voltacomp()
    {
        return this.comparacoes;
    } 

    private void Troca(int i, int j) { //swap de elementos
        Musica aux = musicas[i];//variavel auxiliar para realizar troca entre os elementos
        musicas[i] = musicas[j];
        musicas[j] = aux;

    }


    private void quc(int inicio, int fim) {
        int i = inicio, j = fim;
        //calculo do pivot
        int pivot = musicas[inicio + (fim-inicio)/2].getDuration_ms();
        while (i <= j) {
            while (musicas[i].getDuration_ms() < pivot) {
                i = i  +1; //contabiliza elementos menores que o pivot
            }
            while (musicas[j].getDuration_ms() > pivot) {
                j = j - 1; //contabiliza elementos maiores que o pivo
                //e baseado na subtracao do valor base da ultima casa do array
            }
            if (i <= j) {
                Troca(i, j);
                i = i  +1 ;
                j = j - 1;
            }
        }
        //rechama a organizacao baseada nos elementos maiores ou menores que o pivot
        if (inicio < j)
            quc(inicio, j);
        if (i < fim)
            quc(i, fim);
            comparacoes = comparacoes + 5;
    }


    public void pot(Musica[] mrs) { //chamada inicial que redireciona para o metodo de organizacao
        this.musicas = mrs;
        n = mrs.length;
        quc(0, n - 1);
    }

   

  
}

class Musica {

    String id;
    String name;
    String key;
    String release_date;
    double acousticness;
    double danceability;
    double energy;
    int duration_ms;
    double instrumentalness;
    double valence;
    int popularity;
    float tempo;
    double liveness;
    double loudness;
    double speechiness;
    int year;
    List<String> artistas = new ArrayList<>();
    //get/set da classe musica
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<String> artistas) {
        this.artistas = artistas;
    }

    public String getRealease_date() {
        return release_date;
    }

    public void setRealease_date(String realease_date) {
        this.release_date = realease_date;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //transformaçao em string
    public String toString() {

        return this.id + " ## " + this.artistas + " ## " + this.name + " ## " + this.release_date + " ## "
                + this.acousticness + " ## " + this.danceability + " ## " + this.instrumentalness + " ## "
                + this.liveness + " ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy + " ## "
                + this.duration_ms;
    }
//setando valores base para evitar erros
    public Musica() {

        this.id = "";
        this.name = "";
        this.key = "";
        this.release_date = "1";
        this.acousticness = 1;
        this.danceability = 1;
        this.energy = 1;
        this.duration_ms = 1;
        this.instrumentalness = 1;
        this.valence = 1;
        this.popularity = 1;
        this.tempo = 1;
        this.liveness = 1;
        this.loudness = 1;
        this.speechiness = 1;
        this.year = 1;
    }
}

public class doubleQuick {
    //separa os nomes das artistas
    public static String pegaNomeMusica(String pit) {
        int inicio = pit.indexOf("]");
        int fim = pit.lastIndexOf(",");
        String[] resto = new String[fim - inicio + 2];
        String nomedevolve = "";
        if (removeParteString(pit, inicio + 2, fim).contains("\"")) {

            resto = removeParteString(pit, inicio + 2, fim).split("\"");
            nomedevolve = resto[1];
        } else {
            resto = removeParteString(pit, inicio + 3, fim).split(",");
            nomedevolve = resto[10];
        }
        return nomedevolve;
    }
    //corta string
    public static String retornaFim(String pit) {
        int fimaSerCortado = pit.indexOf("]");
        String retirada = pit.substring(fimaSerCortado);
        fimaSerCortado = retirada.indexOf(",");
        String novaString = retirada.substring(fimaSerCortado + 1);

        return novaString;
    }
    //verifica existencia de aspas
    public static boolean verificaAspas(String pit) {
        for (int i = 0; i < pit.length(); i = i + 1) {
            if (pit.charAt(i) == '"') {
                return true;

            }
        }

        return false;
    }
    //da split nas virgulas
    public static String[] spliTvirgula(String pit) {

        String[] tiravirgula = pit.split(",");

        return tiravirgula;
    }
    //pega nome das musicas
    public static String pegaMusicanome(String pit) {

        int aspasd = pit.indexOf("\"");
        String nova = "";
        int aspasdf = pit.lastIndexOf("\"");
        for (int i = aspasd + 1; i < aspasdf; i++) {
            nova += pit.charAt(i);

        }
        return nova;

    }

    public static boolean Vef(String teste) {// Metodo para verificar o flag
        boolean pa = true;

        if (teste.length() == 3 && teste.charAt(0) == 'F' && teste.charAt(1) == 'I' && teste.charAt(2) == 'M') {
            pa = false;
        }
        return pa;
    }

    // remocao das partes ja lidas da string principal
    public static String removeParteString(String paracortar, int indexinicial, int indexfinal) {
        String cortada = paracortar.substring(indexinicial, indexfinal);

        return cortada;
    }
    //pega os 3 primeiros elementos listados
    public static String[] pega3primeiros(String pit) {
        int fim = pit.indexOf("[");

        String[] guarda = removeParteString(pit, 0, fim).split(",");

        return guarda;
    }
//pega nome artistas
    public static List<String> pegaNome(String pit) {
        List<String> artistas1 = new ArrayList<>();
        int fim = pit.indexOf("]");
        int inicio = pit.indexOf("[");
        String[] guarda = removeParteString(pit, inicio, fim).split("'");

        int x = 0;
        x = guarda.length;
        for (int n = 0; n < x; n = n + 1) {
            if (n % 2 != 0) {
                // System.out.println(guarda[n]);
                artistas1.add(guarda[n]);
            }
        }

        return artistas1;

    }
    //retira nome unico
    public static String[] semNomenoMeio(String linha) {
        int inicioaSerCortado = linha.indexOf("\"");
        int fimaSerCortado = linha.indexOf("\"", inicioaSerCortado + 1);
        String retirada = linha.substring(0, inicioaSerCortado);
        String depois = linha.substring(fimaSerCortado + 1);
        String retidadoNomes = retirada.concat(depois);
        String[] tirarVirgula = retidadoNomes.split(",");

        return tirarVirgula;
    }
    //coloca tudo dentro de um objeto musica com seus atributos
    public static Musica colocaNaClasse(String pit) {
        Musica musica = new Musica();

        // pegando acousticness
        String[] acoustics = pega3primeiros(pit);
        musica.setAcousticness(Double.parseDouble(acoustics[2]));
        musica.setArtistas(pegaNome(pit));
        musica.setNome(pegaNomeMusica(pit));// certo!!!!
        pit = retornaFim(pit);

        if (pit.contains("\"")) {
            String[] nova = semNomenoMeio(pit);

            musica.setDanceability(Double.parseDouble(nova[0]));
            musica.setDuration_ms(Integer.parseInt(nova[1]));
            musica.setEnergy(Double.parseDouble(nova[2]));
            musica.setId(nova[4]);
            musica.setInstrumentalness(Double.parseDouble(nova[5]));
            musica.setKey(nova[6]);
            musica.setLiveness(Double.parseDouble(nova[7]));
            musica.setLoudness(Double.parseDouble(nova[8]));
            musica.setPopularity(Integer.parseInt(nova[11]));
            musica.setSpeechiness(Double.parseDouble(nova[13]));

            musica.setTempo(Float.parseFloat(nova[14]));

        } else {
            String[] nova2 = pit.split(",");
            musica.setDanceability(Double.parseDouble(nova2[0]));
            musica.setDuration_ms(Integer.parseInt(nova2[1]));
            musica.setEnergy(Double.parseDouble(nova2[2]));
            musica.setId(nova2[4]);
            musica.setInstrumentalness(Double.parseDouble(nova2[5]));
            musica.setKey(nova2[6]);
            musica.setLiveness(Double.parseDouble(nova2[7]));
            musica.setLoudness(Double.parseDouble(nova2[8]));
            musica.setNome(nova2[10]);
            musica.setPopularity(Integer.parseInt(nova2[11]));

            musica.setSpeechiness(Double.parseDouble(nova2[13]));
            musica.setTempo(Float.parseFloat(nova2[14]));
        }

        // System.out.println(musica.toString());
        return musica;
    }

    public static void main(String[] args) throws Exception {
        long inity = System.currentTimeMillis();
        String[] pubin = new String[500];
       

        int x = 0;
        pubin[x] = MyIO.readString();

        while (Vef(pubin[x]) != false) {
            x = x + 1;
            pubin[x] = MyIO.readString();

        }
     
        try {

            int y = 0;
            BufferedReader conteudoCsv = null;
            conteudoCsv = new BufferedReader(new FileReader("/tmp/data.csv"));
            String arquivo = "";
            arquivo = conteudoCsv.readLine();
            String[] dedo = new String[300];
            Musica musica = new Musica();
            Musica[] musicarray2 = new Musica[x];
            ListaDupla listadupla = new ListaDupla();
            int ky = 0;

            while ((arquivo = conteudoCsv.readLine()) != null) {
                for (y = 0; y < x; y++) {
                    if (arquivo.contains(pubin[y])) {
                        musica = colocaNaClasse(arquivo);
                    
                         musicarray2[ky] = musica;
                        
                        dedo[y] = musica.toString();
                                          
                        ky = ky + 1;
                    }

                }

             
            }
         
           Quicksort qq = new Quicksort();
          qq.pot(musicarray2);
           for(int tj = 0;tj < musicarray2.length -1;tj = tj + 1)
           {
            listadupla.inserirFim(musicarray2[tj]);
            
           }
      
           listadupla.mostrar();

           File aqr = new File( "689661_quicksort2.txt" );
           aqr.createNewFile();
           FileWriter fw = new FileWriter( aqr );
           long fimt = System.currentTimeMillis();
           fw.write("689661"+ "\t" + (fimt - inity) +"\t" + qq.voltacomp());
           fw.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

