
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

class Lista {
    private Musica[] array;
    private int n;

    public Lista() {
        this(6);
    }

    public Lista(int tamanho) {
        array = new Musica[tamanho];
        n = 0;
    }
 
    public Musica[] getarray() {
        return array;
    }


    public void inserirInicio(Musica musica) throws Exception {
        if (n >= array.length) {
            throw new Exception("ERRO1");
        }
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = musica;
        n++;
    }
  


    public void inserir(Musica musica, int posicao) throws Exception {
        if (n >= array.length || posicao < 0 || posicao > n) {
            throw new Exception("Erro3");
        }

        for (int i = n; i > posicao; i--) {
            array[i] = array[i - 1];
        }

        array[posicao] = musica;
        n++;
    }

    public String removerInicio() throws Exception {
        if (n == 0) {
            throw new Exception("Erro ao remover");
        }

        String ret = array[0].name;
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return ret;
    }

    public void mostrar(Lista a ) {
        for (int i = 0; i < n; i++) {
            System.out.println("[" + i + "] " + a.array[i]);
        }
    }
    int t = 0;
    public void mostrarInv(Lista a ) {
        for (int i = n-1; i >=0; i--) {
            System.out.println("[" + t + "] " + a.array[i]);
            t = t + 1;
        }
    }
/*
    public Musica[] organizar(String[] dedo, int y,String[] pubin, int x) {
		int o = 0;
		int t = 0;
		int contador = 0;
		String[] devolve = new String[300];
		for (o = 0; o < y; o = o + 1) {
			for (int i = 0; i < array.length; i++) {

				if (dedo[o].contains(lipa.get(i).id)) {
					
					
					// System.out.println("[" + contador + "] " + lipa.get(i).toString());
					// System.out.println("[" + contador + "] " +devolve[t]);
					t = t + 1;
					contador = contador + 1;
				}
			}
		}
		return devolve;
	}*/
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

    public String toString() {

        return this.id + " ## " + this.artistas + " ## " + this.name + " ## " + this.release_date + " ## "
                + this.acousticness + " ## " + this.danceability + " ## " + this.instrumentalness + " ## "
                + this.liveness + " ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy + " ## "
                + this.duration_ms;
    }

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

public class pilha {

 

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

    public static String retornaFim(String pit) {
        int fimaSerCortado = pit.indexOf("]");
        String retirada = pit.substring(fimaSerCortado);
        fimaSerCortado = retirada.indexOf(",");
        String novaString = retirada.substring(fimaSerCortado + 1);

        return novaString;
    }

    public static boolean verificaAspas(String pit) {
        for (int i = 0; i < pit.length(); i = i + 1) {
            if (pit.charAt(i) == '"') {
                return true;

            }
        }

        return false;
    }

    public static String[] spliTvirgula(String pit) {

        String[] tiravirgula = pit.split(",");

        return tiravirgula;
    }

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

    public static String[] pega3primeiros(String pit) {
        int fim = pit.indexOf("[");

        String[] guarda = removeParteString(pit, 0, fim).split(",");

        return guarda;
    }

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

    public static String[] semNomenoMeio(String linha) {
        int inicioaSerCortado = linha.indexOf("\"");
        int fimaSerCortado = linha.indexOf("\"", inicioaSerCortado + 1);
        String retirada = linha.substring(0, inicioaSerCortado);
        String depois = linha.substring(fimaSerCortado + 1);
        String retidadoNomes = retirada.concat(depois);
        String[] tirarVirgula = retidadoNomes.split(",");

        return tirarVirgula;
    }

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

        String[] pubin = new String[500];
        String[] pubin2 = new String[500];

        int x = 0;
        int z = 0;
        int gg = 0;
        int holder = 0;
        pubin[x] = MyIO.readString();

        while (Vef(pubin[x]) != false) {
            x = x + 1;
            pubin[x] = MyIO.readString();

        }
        gg = Integer.parseInt(MyIO.readString());
        holder = gg;
        String teste = "";
        String comando = "";
        int kk = 0;
        String[] ids = new String[500];
      
        while (gg > 0) {

            pubin2[z] = MyIO.readLine();
            if (pubin2[z].length() > 15) {
                ids = pubin2[z].split(" ");
                for (int jk = 0; jk < ids.length; jk++) {
                    if (ids[jk].length() > 10) {
                        teste += ids[jk];
                        teste += " ";
                        // System.out.println(teste);
                    }

                }
            }
            comando += pubin2[z];
            comando += ";";

            z = z + 1;
            gg = gg - 1;
        }
        // System.out.println(teste);
        String[] leituraperson = teste.split(" ");

        try {
            int l = 1;
            int y = 0;
            int ty = 0;
            BufferedReader conteudoCsv = null;
            conteudoCsv = new BufferedReader(new FileReader("/tmp/data.csv"));
            String arquivo = "";
            arquivo = conteudoCsv.readLine();
            String[] dedo = new String[300];
            String[] dedo2 = new String[500];
            Musica musica = new Musica();
            Musica musica2 = new Musica();
            List<Musica> list3 = new ArrayList<>();
            Musica[] musicarray = new Musica[300];
            Musica[] musicarray2 = new Musica[x];
            Lista lista = new Lista(300);
            int ky = 0;
            int ky2 = 0;
            while ((arquivo = conteudoCsv.readLine()) != null) {
                for (y = 0; y < x; y++) {
                    if (arquivo.contains(pubin[y])) {
                        musica = colocaNaClasse(arquivo);
                       // lista.adds(lista, musica, ky);
                       // lista.inserirFim(musica);
                         musicarray2[ky] = musica;
                         
                        dedo[y] = musica.toString();
                        // System.out.println(lista.getarray()[ky]);                   
                        ky = ky + 1;
                    }

                }

                for (int conta = leituraperson.length - 1; conta >= 0; conta = conta - 1) {
                    //pegando os dados Extras ja tratados (Musicas Add, remov, etc)
                    if (arquivo.contains(leituraperson[conta])) {
                        musica2 = colocaNaClasse(arquivo);
                        musicarray[ky2] = musica2;
                        //lista.inserirInicio(musica2);
                        dedo2[conta] = musica2.toString();
                        //System.out.println(musicarray[ky2]);
                        // System.out.println(salvador[ty]);
                        ty = ty + 1;
                        ky2 = ky2 + 1;
                    }
                }

            }
           // System.out.println(Arrays.toString(lista.getarray()));
          // System.out.println(comando);
           String[] junc = comando.split(";");
           int lo = 0;
           int res= 0;
           
           for(int t = 0;t < x;t++ )
           {
               for(int j = 0;j < ky;j++)
               {
                   if(musicarray2[j].id.contains(pubin[t]))
                   {
                       
                      lista.inserirInicio(musicarray2[j]);
                   }
               }
           }
         
         while(lo < holder)
           {
               if(junc[lo].contains("I")) //adiconar elementos a lista
               {
                   //split no jun[lo atual e pegar id]
                   String[] aux = junc[lo].split(" ");
                   String idadd = aux[1];
                   //System.out.println(idadd);
                   for(int navega = 0;navega < ky2 ;navega = navega + 1)
                   {
                      // System.out.println(musicarray.length);/*
                      
                    if(idadd.equals(musicarray[navega].getId()))
                    {
                       
                        lista.inserirInicio(musicarray[navega]);
                       
                    }
                   }
               }
               if(junc[lo].equals("R")){
                String str = lista.removerInicio();
                System.out.println("(R) "+ str );
           
                }
             

               lo = lo + 1;
           } 
           lista.mostrarInv(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
