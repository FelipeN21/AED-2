public class is {
  public static void main(String[] args) { // funcao main (printa os resultados processados nas funcoes)
    String palavra = MyIO.readLine();
    while (Vef(palavra) == true) {
      if (vogal(palavra) == true) {
        System.out.print("SIM ");
      } else {
       System.out.print("NAO ");
      }
      if (consoante(palavra) == true) {
        System.out.print("SIM ");
      } else {
        System.out.print("NAO ");
      }
      if (temNumeroInteiro(palavra) == true) {
        System.out.print("SIM ");
      } else {
        System.out.print("NAO ");
      }
      if (temNumeroReal(palavra) == true) {
        System.out.print("SIM\n");
      } else {
        System.out.print("NAO\n");
      }

      palavra = MyIO.readLine();
    }

  }

  public static boolean vogal(String y) { // verifica se sao so vogais
    char x;
    boolean trader = true;
    for (int i = 0; i < y.length() - 1; i = i + 1) {
      x = y.charAt(i);

      if( !(x == 'a' || x == 'A' || x == 'e' || x == 'E' || x == 'i' || x == 'u' || x == 'U' || x == 'o' || x == 'O')) {
        trader = false;
       
      }
  
    }
    return trader;
  }

  public static boolean consoante(String y) { //verigica se sao so consoantes
    char x;
    boolean trader = true;
    for (int i = 0; i < y.length() - 1; i = i + 1) {
      x = y.charAt(i);

      if ((x == 'a' || x == 'A' || x == 'e' || x == 'E' || x == 'i' || x == 'u' || x == 'U' || x == 'o' || x == 'O') || !dentro(y.charAt(i))) {
        trader = false;
       
      }
  
    }
    return trader;
  }

 public static boolean desaparecaEspecial(String y) // retira caracteres indesejados
 {
   boolean ret1 = false;
   for(int i = 0; i<y.length();i = i + 1)
   {
     if((y.charAt(i) >= '0' && y.charAt(i) <= '9'))
     ret1 = true;
   }
   return ret1;
 }


 public static boolean dentro(char x) // verifica se é letra
 {
   boolean ret1 = false;
if(x >= 'A' && x <= 'Z' || x >= 'a' && x <= 'z')
ret1 = true;

   return ret1;
 }

 public static boolean temNumeroInteiro (String y){ // verifica se a string so tem numeros inteiros
  boolean saber = true;
   for (int i =0 ;i<y.length();i++  ) {

           if(y.charAt(i)=='.'||y.charAt(i)==','||dentro(y.charAt(i))){

             saber = false;

           }
     }
 return saber; 
}
public static boolean temNumeroReal(String y){ //verifica se so tem numeros reais

  boolean saber = false;
 // System.out.println(pato);
   for (int i =0 ;i<y.length();i++  ) {

           if(!dentro(y.charAt(i)) ){

             saber = desaparecaEspecial(y);
           }
     }
 return saber;

}



  public static boolean Vef(String teste) {// Metodo para verificar o flag
    boolean pa = true;

    if (teste.length() == 3 && teste.charAt(0) == 'F' && teste.charAt(1) == 'I' && teste.charAt(2) == 'M') {
      pa = false;
    }
    return pa;
  }

}