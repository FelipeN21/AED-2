

class palindromo {
  public static void main(String[] args) { // le os dados e verifica a flag
    boolean pa = true;
    boolean vef = true;
    String y = MyIO.readLine();
    while (pa == true)
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
          y = MyIO.readLine();
      }

  }

  public static boolean verificador(String x) { // compara strings inversas para ver se a plavra e ou nao palindromo
    boolean bbb = true;
    int i = x.length()-1;

    for (int n = 0; n < x.length()-1; n = n + 1) {

        if (x.charAt(n) != x.charAt(i)) {
          bbb = false;

          n = x.length();
        }
        i--;

    }
    return bbb;

  }

}