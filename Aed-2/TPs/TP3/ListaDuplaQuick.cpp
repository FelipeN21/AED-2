#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <err.h>

#define true 1
#define false 0
#define MAX_LINE_SIZE 860
#define MAXTAM 400

typedef struct
{
    char id[30];
    char name[300];
    char key[30];
    char artistas[600];
    char release_date[11];
    char acousticness[20];
    double danceability;
    double energy;
    int duration_ms;
    char instrumentalness[10];
    double valence;
    int popularity;
    float tempo;
    double liveness;
    double loudness;
    double speechiness;
    int year;
} Musica;
//------------------------------------------------


#define bool   short
#define true   1
#define false  0

typedef struct CelulaDupla {
	Musica elemento;        // Elemento inserido na celula.
	struct CelulaDupla* prox; // Aponta a celula prox.
   struct CelulaDupla* ant;  // Aponta a celula anterior.
} CelulaDupla;

CelulaDupla* novaCelulaDupla(Musica elemento) {
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}
// como o start nao necessita de parametragem inicial, esse metodo incializa sem parametros
CelulaDupla* novaCelulaNull() {  
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}
//elementos da lista
CelulaDupla* primeiro;
CelulaDupla* ultimo;

void start () {
   primeiro = novaCelulaNull();
   ultimo = primeiro;
}

void inserirInicio(Musica x) {
   CelulaDupla* tmp = novaCelulaDupla(x);

   tmp->ant = primeiro;
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {                    
      ultimo = tmp;
   } else {
      tmp->prox->ant = tmp;
   }
   tmp = NULL;
}

void inserirFim(Musica x) {
   ultimo->prox = novaCelulaDupla(x);
   ultimo->prox->ant = ultimo;
   ultimo = ultimo->prox;
}



void mostrar() {
   CelulaDupla* i;
   for (i = primeiro->prox; i != NULL; i = i->prox) {
printf("%s ## %s ## %s ## %s ## %s ## %G ## %s ## %G ## %G ## %G ## %G ## %d\n", i->elemento.id, i->elemento.artistas, i->elemento.name, i->elemento.release_date, i->elemento.acousticness, i->elemento.danceability, i->elemento.instrumentalness, i->elemento.liveness, i->elemento.loudness, i->elemento.speechiness, i->elemento.energy, i->elemento.duration_ms);
//mostrar adaptado para imprimir os elementos na fila
   }
}

//------------------------------------------------
void set(char *string);
void ler(char *strfoog);
char *tratamento(char *string);
char* LimpaLimpa(char* string);
void quickSort(Musica *a, int left, int right);
int theRealOne(int MAX);
void PRINT();

Musica array[1024];
int countGlobal = 0;

int main()
{

        char *pubin[MAXTAM];
    for (int i = 0; i < MAXTAM; i++)
        pubin[i] = (char *)calloc(100, sizeof(char));
    int i = 0;
   // scanf("%s", pubin[i]);
    
    //leitura do pubin
    
    while (strncmp(pubin[i], "FIM", 3))
    {
        
        i = i + 1;
        scanf("%s", pubin[i]);
        ler(pubin[i]);
        
        //PRINT();
     countGlobal = countGlobal + 1;
    }
    //PRINT(); 
    

   theRealOne(i-1);
    start();
        for (int t = 0; t < i; t++) {
          
               inserirFim(array[t]);
            
        }
    mostrar();

}
//instrumentalness e acousticness
void set(char *string)
{
    char *foo = LimpaLimpa(string);
    
        strcpy(foo, strtok(foo, ";"));
        array[countGlobal].valence = atof(foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].year = atoi(foo);
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].acousticness, foo);
        //pegar nome
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].artistas, foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].danceability = atof(foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].duration_ms = atoi(foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].energy = atof(foo);
        strcpy(foo, strtok(NULL, ";"));
        //pulando o explicit
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].id, foo);
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].instrumentalness, foo);
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].key, foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].liveness = atof(foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].loudness = atof(foo);
        strcpy(foo, strtok(NULL, ";"));
        //pulando mode
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].name, foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].popularity = atoi(foo);
        strcpy(foo, strtok(NULL, ";"));
        strcpy(array[countGlobal].release_date, foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].speechiness = atof(foo);
    
  
    
}

//-----------------------------------------------


//chama o quicksort _-> ela nao e necessaria so deixei para ficar mais facil de localizar
int theRealOne(int MAX)
{
 quickSort(array, 0, MAX - 1);
 
 return 0;
}

void quickSort(Musica *musica, int bottom, int top) {
    int i, j,x;
    Musica y;
     
    i = bottom;
    j = top;
    x = musica[(bottom + top) / 2].duration_ms; //pegando pivot
     
    while(i <= j) {
        while(musica[i].duration_ms < x && i < top) { //verifica elementos menores que o pivot
            i++;
        }
        while(musica[j].duration_ms > x && j > bottom) { //verifica elementos maiores que o pivot
            j--;
        }
        if(i <= j) { // realiza as trocas entre elementos(Organizacao)
            y = musica[i];
            musica[i] = musica[j];
            musica[j] = y;
            i++;
            j--;
        }
    }
     //reconvoca a funcao baseado na necessidade de novos rearranjos dos valores que ainda se
     //encontram nao arrumados
    if(j > bottom) {
        quickSort(musica, bottom, j);
    }
    if(i < top) {
        quickSort(musica, i, top);
    }
}

//-----------------------------------------------
//le do arquivo data.csv e da set nas musicas dentro do array
void ler(char *strfoog)
{ 
    FILE *arquivo = fopen("/tmp/data.csv", "r");
    Musica *armazem = (Musica *)malloc(170625 * sizeof(Musica));
    char savefile[1000];
    fgets(savefile, 1000, arquivo);
    while (fgets(savefile, 1000, arquivo) != NULL)
    {
        if (strstr(savefile, strfoog) != NULL)
        {
            set(savefile);
            
        }
    }
    fclose(arquivo);
}

//Processar a linha recebida
char* LimpaLimpa(char* string){
    char* cleartoproceed = (char*) calloc(1000, sizeof(char));
    int h = 0;
    
    for (int i = 0; i < strlen(string); i++){
        if(string[i] == '\"'){//limpa os nomes de artistas e musicas que estajam em volta de "[]"
            i++;
            
            if (string[i] == '[') {
                while(string[i] != '\"'){
                    if (string[i] != '\'') { 
                        cleartoproceed[h] = string[i];
                        h++;
                    }

                    i++;
                }
            } else {
                while(string[i] != '\"'){
                    cleartoproceed[h] = string[i];
                    h++;    
                    i++;
                }
            }//limpa os nomes de artistas e musicas que estajam em volta de []
        } else if(string[i] == '['){
            while(string[i] != ']'){
                if(string[i] != '\''){
                    cleartoproceed[h] = string[i];
                    h++;    
                }
                
                i++;
            }

            cleartoproceed[h] = string[i];
            h++;   
            //facilitando o set de elementos
        } else if(string[i] == ','){
            cleartoproceed[h] = ';';//separa os elementos agora usando ; 
            h++; 
        } else {
            cleartoproceed[h] = string[i];
            h++;
        }
    }
    
    return cleartoproceed;
}