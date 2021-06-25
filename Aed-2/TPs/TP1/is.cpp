
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


bool temVogal(char y)
{ // verifica se o char e vogal
// serve como funcao auxiliar ao metodo onlyvogais
  bool pa = false;
  if (y == 'a' || y == 'A' || y == 'e' || y == 'E' || y == 'i' || y == 'I' || y == 'o' || y == 'O' || y == 'u' || y == 'U')
  {pa = true;}
  return pa;
}
//Trata os caracteres especiais ("ignora eles e elimina algumas possibilidades de resposta")
bool eliminaEspecial(char cha[], int leng){
  bool pa = false;
  for (int j =0 ;j<leng;j = j + 1  ) {
          if((cha[j] >= '0' && cha[j] <= '9')){
           pa =true;
      }
  }
  return pa;
}

// verifica se o vetor de caracteres e composto apenas por consoantes
bool onlyVogais(char cha[], int leng)
{
  bool guarda = true;
  for (int j = 0; j < leng; j = j + 1)
  {
    if (!temVogal(cha[j]))// se aparecer qualquer coisa diferente de vogal sai do metodo
    {
      guarda = false;
    }
  }
  return guarda;
}
// verifica se o vetor de caracteres esta contido totalmente dentro desse intervalo(Letras)(Olha char a char)
bool contemletra(char y)
{
  bool pa = false;
  if (y >= 'A' && y <= 'Z' || y >= 'a' && y <= 'z')
    {pa = true;}
  return pa;
}

// verifica se o vetor de caracteres e composto apenas por consoantes
bool temConsoante(char cha[], int leng) 
{
  bool pa = true;
  for (int j = 0; j < leng; j = j + 1)
  {
    if (temVogal(cha[j]) || !contemletra(cha[j]))// se tiver vogal ou nao for letra sai do metodo
    {
      pa = false;
    }
  }
  return pa;
}

 // verifica se o vetor de caracteres e composto apenas por Numeros Inteiros
bool temInteiro(char cha[], int leng)
{
  bool pa = true;
  for (int j = 0; j < leng; j = j + 1)
  {
    if (contemletra(cha[j]) || cha[j] == ',' || cha[j] == '.') // exclui a possibilidade de letras e numeros Reais
    {pa = false;}
  }
  return pa;
} 

// verifica se o vetor de caracteres e composto apenas por Numeros Reais
bool temReal(char cha[], int leng)
{
  bool guarda = false;

  for (int i = 0; i < leng; i++)
  {
    if (!contemletra(cha[i])) // exclui a possibilidade de existerem letrar 
    {
      guarda = eliminaEspecial(cha,leng);
    }
  }
  return guarda;
}


    

int main() // metodo principal
{

  char palavra[3000];
  
  fgets(palavra, 400, stdin);
  palavra[strlen(palavra) - 1] = '\0';
  int leng = strlen(palavra) - 1;

 bool pa = true;
  while (pa == true)
  {
   // verifica se a entrada  ==  flag (saida)
  if (strlen(palavra) == 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M') 
       {
        pa = false;
       }
else{
    if ( onlyVogais(palavra, leng) == true)
    { printf("SIM ");}
    else{printf("NAO ");}

    if (temConsoante(palavra, leng) == true)
    {  printf("SIM ");}
    else
    {  printf("NAO ");}

    if (temInteiro(palavra, leng) == true)
    { printf("SIM ");}
    else
    {  printf("NAO ");}

    if (temReal(palavra, leng) == true)
    {  printf("SIM\n");}
    else
    {  printf("NAO\n");}

    
    fgets(palavra, 400, stdin); // le novamente para reentrar na verificacao da palavra
    palavra[strlen(palavra) - 1] = '\0';
    leng = strlen(palavra) - 1;
}
  }
}
