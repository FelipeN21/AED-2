

class palindromorec {
    public static void main(String[] args) {
        boolean pa = true;
 pali(pa);//chama a funçao pela primeira vez
  
    }

    public static boolean pali(boolean pa) // checagem do flag e print da resposta
    {
       if(pa != true) //controle da recursividade
       { 
        
           return pa;
       }
       else{
        boolean vef = true;
        String y = MyIO.readLine();
        
          // verificador da flag
          if (y.length() == 3 && y.charAt(0) == 'F' && y.charAt(1) == 'I' && y.charAt(2) == 'M') {
            pa = false;
          } else {
            vef = verificador(y);
            if (vef == true) {
              System.out.println("SIM");
            }
             else{ 
    
              System.out.println("NAO");
             }
              
          }
    return pali(pa); // recursividade da funçao (ela se chama novamente)
        }
    }
  
    public static boolean verificador(String x) { // verifica a string que chega como parametro
      boolean bbb = true;
      int i = x.length()-1;
  
      for (int n = 0; n < x.length()-1; n = n + 1) {
  
          if (x.charAt(n) != x.charAt(i)) {
            bbb = false;
  
            n = x.length();
          }
          i--;
  
      }
      return bbb; // retorna true or false
  
    }
  
  }