class algebra {
    static String[] recepcao = { "not(0)", "not(1)", "or(0,0)", "or(0,1)", "or(1,0)", "or(1,1)", "and(0,0)",
            "and(0,1)", "and(1,0)", "and(1,1)", "or(0,0,0)", "or(0,0,1)", "or(0,1,0)", "or(0,1,1)", "or(1,0,0)",
            "or(1,0,1)", "or(1,1,0)", "or(1,1,1)", "and(0,0,0)", "and(0,0,1)", "and(0,1,0)", "and(0,1,1)", "and(1,0,0)",
            "and(1,0,1)", "and(1,1,0)", "and(1,1,1)", "or(0,0,0,0)", "or(0,0,0,1)", "or(0,0,1,0)", "or(0,0,1,1)",
            "or(0,1,0,0)", "or(0,1,0,1)", "or(0,1,1,0)", "or(0,1,1,1)", "or(1,0,0,0)", "or(1,0,0,1)", "or(1,0,1,0)",
            "or(1,0,1,1)", "or(1,1,0,0)", "or(1,1,0,1)", "or(1,1,1,0)", "or(1,1,1,1)", "and(0,0,0,0)", "and(0,0,0,1)",
            "and(0,0,1,0)", "and(0,0,1,1)", "and(0,1,0,0)", "and(0,1,0,1)", "and(0,1,1,0)", "and(0,1,1,1)",
            "and(1,0,0,0)", "and(1,0,0,1)", "and(1,0,1,0)", "and(1,0,1,1)", "and(1,1,0,0)", "and(1,1,0,1)",
            "and(1,1,1,0)", "and(1,1,1,1)" };




            
    static String[] outToBox = { "1", "0", "0", "1", "1", "1", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "1",
            "0", "0", "0", "0", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
            "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" };

   
            

//organiza os valores de entrada de forma que possam ser processados
            public static String putValues(String exp, int[] rep) {
                String valuefra = "";
                for (int i = 0; i < exp.length(); i = i + 1) {
                    int j = 0, boole = -1;
                    while (j < rep.length) {
                        if (exp.charAt(i) == ('A' + j)) {
                            boole = rep[j];
                        }
                        j = j + 1;
                    }
                    if (boole != -1) {
                        valuefra += boole;
                    } else {
                        valuefra += exp.charAt(i);
                    }
                }
                return valuefra;
            }
  
// deposita os espaços em brano em uma nova string
            public static String blankspaceremover(String origem) {
                String blankspacefrase = "";
                for (int i = 0; i < origem.length(); i = i + 1) {
                    if (origem.charAt(i) != ' ') {
                        blankspacefrase += origem.charAt(i);
                    }
                }
                return blankspacefrase;
            }


       
    
 //realoca espaços em branco e retorna uma expressao
    public static String expr(String blankspacefrase) {
        String noexpf = "";
        for (int i = 0; i < blankspacefrase.length(); i = i + 1) {
            if (!(blankspacefrase.charAt(i) >= '0' && blankspacefrase.charAt(i) <= '9')) {
                noexpf += blankspacefrase.charAt(i);
            }
        }
        return noexpf;
    }

    
  //  remaneja os dados de entrada em uma nova string 
    public static String expremoval(String blankspacefrase, int ent) {
        String noexpf = "";
        for (int i = 1; i <= ent; i++) {
            noexpf += blankspacefrase.charAt(i);
        }
        return noexpf;
    }

    //verifica a parte boleana da entrada de dados (redireciona a outras funcoes) 
    public static String avaliacao(String exp, int[] rep) {
        exp = putValues(exp, rep);
        exp = booleanexec(exp);
        return exp;
    }

   
  

 // executa a ordem dada na entrada (no caso baseando-se somente nos valores boleanos)
    public static String booleanexec(String exp) {
        int iF, pI = 0;
        while (!vef(exp, "0") && !vef(exp, "1")) {
            iF= frasevef(exp, recepcao[pI]);
            if (iF != -1) {
                exp = booleanchange(exp, iF, pI);
            }
            if (pI < recepcao.length - 1) {
                pI++;
            } else {
                pI = 0;
            }
        }
        return exp;
    }

    //movimentaçao dentro da parte booleana da entrada
    public static int frasevef(String fR, String standard) {
        int ii = -1;
        if (standard.length() <= fR.length()) {
            int i = 0;
            while (ii == -1 && i < fR.length()) {
                if (fR.charAt(i) == standard.charAt(0)) {
                    if (pattervef(fR, standard, i)) {
                        ii = i;
                    }
                }
                i = i  + 1;
            }
        }
        return ii;
    }



//coloca o valor entrado para o bolean  , de acordo com o posicionamento do ponteiro na recepcao
    public static String booleanchange(String exp, int idf, int iP) {
        String newexp = "";
        for (int i = 0; i < exp.length(); i++) {
            if (i == idf) {
                newexp += outToBox[iP];
                i = (idf + recepcao[iP].length() - 1);
            } else {
                newexp += exp.charAt(i);
            }
        }
        return newexp;
    }
//se existir qualquer padronizacao no boolean da entrada essa funcao e ativada(trigger)
    public static boolean pattervef(String frr, String standard, int k) {
        boolean pattern = true;
        int h = 0;
        while (pattern && k < frr.length() && h < standard.length()) {
            if (frr.charAt(k) != standard.charAt(h)) {
                pattern = false;
            }
            k = k + 1;
            h = h + 1;
        }
        return pattern;
    }



    
    //capta as entradas e as coloca em um array
    public static int[] goIn(String blankspacefrase) {
        int ent = Character.getNumericValue(blankspacefrase.charAt(0));
        int[] dados = new int[ent];
        String noexpf = expremoval(blankspacefrase, ent);

        for (int i = 0; i < noexpf.length(); i = i + 1) {
            int boole = Character.getNumericValue(noexpf.charAt(i));
            if (boole == 0 || boole == 1) {
                dados[i] = boole;
            }
        }
        return dados;
    }

          //verifica igualdade entre duas strings 
          public static boolean vef(String A, String B) {
            boolean equals = true;
            if (A.length() != B.length()) {
                equals = false;
            } else {
                int i = 0;
                while (i < A.length() && equals) {
                    if (A.charAt(i) != B.charAt(i)) {
                        equals = false;
                    }
                    i = i + 1;
                }
            }
            return equals;
        }
  

// metodo principal executa e chama as funcoes necessarias
// nem todas funcoes sao chamadas aqui pois algumas so tem 
//utilizacao dentro de outras funcoes que nao a main
    public static void main(String[] args) {
        String[] rep = new String[1000];
        int nE = 0;

        do {
            rep[nE] = MyIO.readLine();
        } while (vef(rep[nE++], "0") == false);
        nE--;

        for (int i = 0; i < nE; i = i + 1) {
            String blankspacefrase = blankspaceremover(rep[i]);
            int[] vE = goIn(blankspacefrase);
            String frExp = expr(blankspacefrase);
            MyIO.println(avaliacao(frExp, vE));
        }
    }

}