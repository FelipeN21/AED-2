import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter; 
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

public class countingsort{

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

    public static int pegaMaior( Musica [] devolucao) {
        int maior = devolucao[0].getPopularity();

        for (int i = 0; i < devolucao.length; i++) {
                if(maior <  devolucao[i].getPopularity()) {
                        maior =  devolucao[i].getPopularity();
                }
        }
        return maior;
}


    public static Musica [] CountingSort(Musica[] devolucao ){
        int n = devolucao.length;
        int [] count= new int[pegaMaior(devolucao)+1];//pega o tamanho riginal e coloca uma casa bucket
        Musica [] pronto=new Musica[devolucao.length];


        for(int i=0; i<count.length; i++)
                count[i]=0;


        for(int i=0; i<n; i++)
                
                count[devolucao[i].getPopularity()]++;//contabiliza os elementos 


        for(int i=1; i<count.length; i++)
                count[i] += count[i-1]; //contabilizacao o tamanho


        for(int i=n-1; i>=0; i--) //for para alteracoes
        {
                pronto[count[devolucao[i].getPopularity()]-1]=devolucao[i]; //altera o indice dos elementos necessarios
                count[devolucao[i].getPopularity()]--;
        }


        for(int i=0; i<n; i++)
                devolucao[i]=pronto[i];
        return devolucao;
}


public static Musica[] ordenador(Musica[] pit, int f) { //reutiliza????o do orderselect  Comentarios adicionais no programa do orderSelect
	for (int i = 0; i < f -1; i = i + 1) {

		int dex = i;
		String dexString = pit[i].getNome();
		for (int j = i + 1; j < f ; j = j + 1) {

			if (pit[j].getNome().compareTo(dexString) < 0) {

				dexString = pit[j].getNome();
				dex = j;
			}
		}
		if (dex != i) {
			Musica temp = pit[dex];
			pit[dex] = pit[i];
			pit[i] = temp;
		}
	}
	return pit;

}

	public static Musica colocaNaClasse(String pit) {
		Musica musica = new Musica();

		// pegando acousticness
		String[] acoustics = pega3primeiros(pit);
		musica.setAcousticness(Double.parseDouble(acoustics[2]));
		musica.setArtistas(pegaNome(pit));
		musica.setNome(pegaNomeMusica(pit));// certo!!!!
		// chamar funcao de ordernar
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
		long inicio = System.currentTimeMillis();
		String[] pubin = new String[101];
int comparacoes = 0;
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
			String[] dedo = new String[5000];
             Musica[] ooo = new Musica[x];
			while ((arquivo = conteudoCsv.readLine()) != null) {
				for (y = 0; y < x; y++) {
					if (arquivo.contains(pubin[y])) {
						ooo[y]  = colocaNaClasse(arquivo);
						 comparacoes = comparacoes + 1;
						//novaOrdem[y] = musica.getNome();
                        

					

					}

				}
			}
            int navega = ooo.length;
        
          // System.out.println(Arrays.toString(ooo)); //ooo[y].popularity;

			int p = 0;
			int o = 0;
//int[] aA =  
ordenador(ooo,y);//ordena os nomes primeiro para depois ordenar por popularidade
CountingSort(ooo);

		
			for (p = 0; p < x; p = p + 1) {
				
                System.out.println(ooo[p]);

				
			}
			File aqr = new File( "689661_coutingsort.txt" );
			aqr.createNewFile();
			FileWriter fw = new FileWriter( aqr );
			long fim = System.currentTimeMillis();
			fw.write("689661"+ "\t" + (fim - inicio) +"\t" + comparacoes);
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
