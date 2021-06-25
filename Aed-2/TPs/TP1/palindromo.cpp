#include <stdio.h>
#include <ctype.h> 
#include <stdlib.h>
#include <string.h>
#define boolean short
#define true 1
#define false 0

int main()
{
   int z;
   int t;
   int final =0;
   char entrada [400];
   char check [400];
   boolean pa = true;
   
   while (pa == true) // verifica se tem a flag e le a entrada de dados
   {
      fgets(entrada, 400, stdin);
      entrada[strlen(entrada) - 1] = '\0';
      t = strlen(entrada) - 1;
      //if (strcmp(entrada, "FIM") != 0)
       if (strlen(entrada) == 3 && entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M') 
       {
        pa = false;
       }
      strcpy(check, entrada);   // verifica igualdade entre as strings (ve se sao palindromos ou nao)
      for (int z = 0; z < strlen(entrada); z++)
         {
            check[z] = entrada[t];
            check[z+1] = '\0';
            t--;
         } 
      
         final = strcmp(entrada, check);
      if(pa == true){
         if (final != 0)
            printf("NAO\n");
         else
         {
            printf("SIM\n");
         }
      }
}
   return 0;
}