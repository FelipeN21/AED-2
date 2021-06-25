import java.io.*;
import java.net.*;

class Main {
    public static int[] getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        int br1 = 0;
        int table = 0;
        
       
  
        int[] array = new int[25];
        try {
            String anw = "";
            url = new URL(endereco);
            is = url.openStream();  
            br = new BufferedReader(new InputStreamReader(is));
// captacao da line
            while ((line = br.readLine()) != null) {
                anw = line;
                if (par2(anw)) {
                    table++;
                } else if (par2(anw)) {

                    br1++;
                } else {
//for -  identificacao das letras e gravacao em array 
                    for (int z = 0; z < anw.length(); z++) {
                        int e = 0;
                        if (anw.charAt(z) == 'a') {
                          e = 1;
                            array[0] += e;
                        } else if (anw.charAt(z) == 'e') {
                             e = 1;
                            array[1] += e;
                        } else if (anw.charAt(z) == 'i') {
                             e = 1;
                            array[2] += e;
                        } else if (anw.charAt(z) == 'o') {
                              e = 1;
                            array[3] += e;
                        } else if (anw.charAt(z) == 'u') {
                              e = 1;
                            array[4] += e;
                        } else if (anw.charAt(z) == 225) {
                              e = 1;
                            array[5] += e;
                        } else if (anw.charAt(z) == 233) {
                              e = 1;
                            array[6] += e;
                        } else if (anw.charAt(z) == 237) {
                              e = 1;
                            array[7] += e;
                        } else if (anw.charAt(z) == 243) {
                              e = 1;
                            array[8] += e;
                        } else if (anw.charAt(z) == 250) {
                              e = 1;
                            array[9] += e;
                        } else if (anw.charAt(z) == 224) {
                             e = 1;
                            array[10] += e;
                        } else if (anw.charAt(z) == 232) {
                              e = 1;
                            array[11] += e;
                        } else if (anw.charAt(z) == 236) {
                              e = 1;
                            array[12] += e;
                        } else if (anw.charAt(z) == 242) {
                              e = 1;
                            array[13] += e;
                        } else if (anw.charAt(z) == 249) {
                              e = 1;
                            array[14] += e;
                        } else if (anw.charAt(z) == 227) {
                             e = 1;
                            array[15] += e;
                        } else if (anw.charAt(z) == 245) {
                              e = 1;
                            array[16] += e;
                        } else if (anw.charAt(z) == 226) {
                              e = 1;
                            array[17] += e;
                        } else if (anw.charAt(z) == 234) {
                              e = 1;
                            array[18] += e;
                        } else if (anw.charAt(z) == 238) {
                              e = 1;
                            array[19] += e;
                        } else if (anw.charAt(z) == 244) {
                              e = 1;
                            array[20] += e;
                        } else if (anw.charAt(z) == 251) {
                             e = 1;
                            array[21] += e;
                        } else {
                          if(anw.charAt(z)>=97 && 122 >=anw.charAt(z) && anw.charAt(z) != 65 &&  anw.charAt(z) != 69&&  anw.charAt(z) != 73&&  anw.charAt(z) != 79 &&  anw.charAt(z) != 85)
                            if(tst(anw.charAt(z))){
                                   e = 1;
                            array[22] += e; // teste consoantes
                          
                            }
                            
                        }
                    }
                }


            }
          // leituras fora do array
            array[23] = br1;
            array[24] = table;

// tratamento de erros 
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            

        }

        return array;
    }
// retirada dos caracteres de maior e menor para operacao da funcao
    public static boolean tst(char hhh){
       boolean saber =true;
          if(hhh=='<'||hhh=='>'){
            saber = false;
           }
        return saber;
    }


//

//captacao flag = "FIM"
    public static boolean test(String hhh) {
        return (hhh.length() == 3 && hhh.charAt(0) == 'F' && hhh.charAt(1) == 'I' && hhh.charAt(2) == 'M');
    }

    //captacao table
    public static boolean par2(String hhh) {
        return (hhh.length() == 7 && hhh.charAt(0) == '<' && hhh.charAt(1) == 't' && hhh.charAt(2) == 'a' && hhh.charAt(3) == 'b' && hhh.charAt(4) == 'l' && hhh.charAt(5) == 'e' && hhh.charAt(6) == '>');

    }
//captacao br
    public static boolean par3(String hhh) {
        return (hhh.length() == 4 && hhh.charAt(0) == '<' && hhh.charAt(1) == 'b' && hhh.charAt(2) == 'r' && hhh.charAt(3) == '>');

    }


    public static void main(String[] args) throws Exception {
        String pag = MyIO.readLine();


        while (test(pag) != true) {
            String endereco = MyIO.readLine();
            int[] array = getHtml(endereco);
     //funcao acima printa de acordo com valor somado para cada letra, aramzenado dentro do array
          MyIO.println("a(" + array[0] + ") e(" + array[1] + ") i(" + array[2] + ") o(" + array[3] + ") u(" + array[4] + ") á(" + array[5] + ") é(" + array[6] + ") í(" + array[7] + ") ó(" + array[8] + ") ú(" + array[9] + ") à(" + array[10] + ") è(" + array[11] + ") ì(" + array[12] + ") ò(" + array[13] + ") ù(" + array[14] + ") ã(" + array[15] + ") õ(" + array[16] + ") â(" + array[17] + ") ê(" + array[18] + ") î(" + array[19] + ") ô(" + array[20] + ") û(" + array[21] + ") consoante(" + array[22] + ") <br>(" + array[23] + ") <table>(" + array[24] + ") " + pag);
  
            pag = MyIO.readLine();


        }

    }

}