

class palindromo {
  public static void main(String[] args) { // le os dados e verifica a flag
    boolean notFim = true;
    boolean vef = true;
    String y = MyIO.readLine();
    while (notFim == true) //roda enquanto não ocorre a condicao de parada
      if (y.length() == 3 && y.charAt(0) == 'F' && y.charAt(1) == 'I' && y.charAt(2) == 'M') {//busca a condicao de parada
        notFim = false;
      } else {
        vef = verificador(y);
        if (vef == true) {
          System.out.println("SIM");
        }
         else{ 

          System.out.println("NAO");
         }
          y = MyIO.readLine();
      }

  }

  public static boolean verificador(String x) { // compara strings inversas para ver se a plavra e ou nao palindromo
    boolean toReturn = true;
    int i = x.length()-1;

    for (int n = 0; n < x.length()-1; n = n + 1) {

        if (x.charAt(n) != x.charAt(i)) {
          toReturn = false;

          n = x.length();
        }
        i--;

    }
    return toReturn;

  }

}
