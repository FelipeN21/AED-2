import java.util.Random;


public class alternador {

    public static void main (String[] args) // gera o valor aleatorio
    {
        Random gerador = new Random();
        gerador.setSeed(4);
       String[] teste = new String[1000];
       int t = 0;
       teste[t] = MyIO.readLine();
       while(Vef(teste[t])==true)
       {t++;
       teste[t] = MyIO.readLine();    
       }
       for(int y = 0; y < t; y++)
       {
           MyIO.println(formador(teste[y], gerador));
       }
    }



    public static String formador(String x, Random gerador) { // calcula qual letra deve ser alterada por qual ex: a deve ser alterada por b
        
        char sai = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
        char entra = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
        String alterada = "";

        for (int i = 0; i < x.length(); i = i + 1) {
            if (x.charAt(i) == sai) {
                alterada += entra;
            } else {
                alterada += x.charAt(i);
            }
            
            
        }
        return alterada;
    }


    public static boolean Vef(String teste) // verifica flag
{
        boolean pa = true;
       
         if   (teste.length() == 3 && teste.charAt(0) == 'F' && teste.charAt(1) == 'I' && teste.charAt(2) == 'M')
         {
             pa = false;
         }
         return pa;
    }
   
}