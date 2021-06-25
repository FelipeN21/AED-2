#include <stdio.h>
#include <ctype.h> 
#include <stdlib.h>
#include <string.h>
#define boolean short
#define true 1
#define false 0



boolean verificador(boolean pa) // funcao que ve se e palindromo 
{
   int z;
   int t;
   int final =0;
   char entrada [400];
   char check [400];
   
   if(pa != true) // controlador de parada da recursividade
   {
       return pa;
   }
   else{
   
      fgets(entrada, 400, stdin);
      entrada[strlen(entrada) - 1] = '\0';
      t = strlen(entrada) - 1;
      //flag de parada da funcao
       if (strlen(entrada) == 3 && entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M') 
       { 
        pa = false;
       }
      strcpy(check, entrada);   
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

   return verificador(pa);//chamada recursiva da funcao
   }
}




int main()
{
   boolean pa = true;
verificador(pa);
}