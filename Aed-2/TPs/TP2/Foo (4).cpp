#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

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
} Musica;
void set(char *string);
void ler(char *strfoog);
char *tratamento(char *string);
char* LimpaLimpa(char* string);
void PRINT();

Musica array[1024];
int countGlobal = 0;

int main()
{

    //char teste[] = "2q95XoeFGixx8b5LNF6Ey1";
    //   0.639,2016,0.245,"['Pitbull', 'Flo Rida', 'LunchMoney Lewis']",0.695,244174,0.8370000000000001,0,2q95XoeFGixx8b5LNF6Ey1,0.0,1,0.3670000000000001,-5.617000000000001,0,Greenlight (feat. Flo Rida & LunchMoney Lewis),59,2016-07-22,0.281,115.067

    //"0.282,1921,0.989,\"['Sergei Rachmaninoff', 'Ruth Laredo']\",0.384,221013,0.171,0,0NFeJgmTAV1kDfzSQNK41Z,0.82,7,0.116,-20.476,0,\"10 Préludes, Op. 23: No. 5 in G Minor. Alla marcia\",4,1921,0.0319,107.698";
    printf("aaaa\n");

        char *pubin[MAXTAM];
    for (int i = 0; i < MAXTAM; i++)
        pubin[i] = (char *)calloc(100, sizeof(char));
    int i = 0;
    scanf("%s", pubin[i]);
    while (strncmp(pubin[i], "FIM", 3))
    {
        i = i + 1;
        scanf("%s", pubin[i]);
        ler(pubin[i]);
        //PRINT();
     countGlobal = countGlobal + 1;
    }
    //PRINT(); 
    

   
 for (int k = 0; k < i; k++) {
        for (int t = 0; t < i; t++) {
           if (strcmp(array[t].id, pubin[k]) == 0) {
               // PRINT();
                //printf("%s  = %s\n", array[t].id, pubin[k]);
               printf("%s ## %s ## %s ## %s ## %G ## %G ## %G ## %G ## %G ## %G ## %G ## %d\n", array[t].id, array[t].artistas, array[t].name, array[t].release_date, array[t].acousticness, array[t].danceability, array[t].instrumentalness, array[t].liveness, array[t].loudness, array[t].speechiness, array[t].energy, array[t].duration_ms);
            }
        }
    }

}

void set(char *string)
{
    char *foo = LimpaLimpa(string);

 
    //valence,year,acousticness,artists,danceability,duration_ms,energy,explicit,id,instrumentalness,key,liveness,loudness,mode,name,popularity,release_date,speechiness,tempo
    //0.639,2016,0.245,"['Pitbull', 'Flo Rida', 'LunchMoney Lewis']",0.695,244174,0.8370000000000001,0,2q95XoeFGixx8b5LNF6Ey1,0.0,1,0.3670000000000001,-5.617000000000001,0,Greenlight (feat. Flo Rida & LunchMoney Lewis),59,2016-07-22,0.281,115.067

    
        strcpy(foo, strtok(foo, ";"));
        array[countGlobal].valence = atof(foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].year = atoi(foo);
        strcpy(foo, strtok(NULL, ";"));
        array[countGlobal].acousticness = atof(foo);
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
        array[countGlobal].instrumentalness = atof(foo);
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
//0.17600000000000002,2012,0.725,['Beach House'],0.247,332467,0.521,0,5sKb4ShexCtnNcZlWHGDrE,0.0494,3,0.0938,-7.664,1,On the Sea,44,2012-05-15,0.0334,102.276
//5sKb4ShexCtnNcZlWHGDrE ## [Beach House] ##  ## 44 ## 0.72 ## 0.25 ## 0.05 ## 0.09 ## -7.66 ## 2012.00 ## 0.52 ## 332467

void PRINT()
{
    printf("%s ## %s ## %s ## %s ## %0.2lf ## %0.2lf ## %0.2lf ## %0.2lf ## %0.2lf ## %0.2lf ## %0.2lf ## %d\n", array[countGlobal].id, array[countGlobal].artistas, array[countGlobal].name, array[countGlobal].release_date, array[countGlobal].acousticness, array[countGlobal].danceability, array[countGlobal].instrumentalness, array[countGlobal].liveness, array[countGlobal].loudness, array[countGlobal].speechiness, array[countGlobal].energy, array[countGlobal].duration_ms);
}

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
        if(string[i] == '\"'){
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
            }
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
        } else if(string[i] == ','){
            cleartoproceed[h] = ';';
            h++; 
        } else {
            cleartoproceed[h] = string[i];
            h++;
        }
    }
    
    return cleartoproceed;
}