 #include <stdio.h>

 
void readarc(int n){ //metodo leitura
    
    
 
 FILE * arquivo =fopen("arquivo.txt", "rb");// abertura
    if(arquivo == NULL){
// gerenciamento de erros
        printf("Erro ao abrir arquivo\n");
    }
    else{
         for(int i=0;i<n;i++){
        double number=0;
        
        fseek(arquivo,  (n-1-i)*8, SEEK_SET);// procura por numeros de 8 bits
        fread(&number, sizeof(double), 1, arquivo);
        int numberInteiro;
        int res;
        res=number;
        if(number-res!=0)
        {
            printf("%g\n", number);
        }
        else
        {
            printf("%d\n", res);
        }
        
    }
    fclose(arquivo);
        
} 
}



void oparc(int n){//metodo criacao
   double catar=0;
       
    FILE * arquivo =fopen("arquivo.txt", "wb");//abertura
    
    if(arquivo == NULL){
// controle de erros
        printf("Erro ao abrir arquivo\n");
    }
    else{

        for(int i =0 ;i<n;i++){
             scanf("%lf",&catar);
           
             fwrite(&catar, sizeof(double), 1, arquivo); 

        }
         fclose(arquivo);
    }
} 





int main (){ //Metodo Principal
 int n=0;
 scanf("%d\n", &n);
 oparc(n);
 readarc(n);
} 