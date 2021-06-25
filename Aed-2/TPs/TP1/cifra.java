
public class cifra {
    public static void main(String[] args) {
     //le pela primeira vez
        String cifrar = MyIO.readLine();
        while(Vef(cifrar)==true) 
        {
            String cifrado = "";
             // navega na string passando caracter a caracter para a funçao
             for(int c = 0; c < cifrar.length(); c++){
                 cifrado += codificador(cifrar.charAt(c));
             }
             MyIO.println(cifrado);//printa o resultado
             cifrar = MyIO.readLine();//reinicia ou para o loop de acordo com o valor flag == "FIM"
        }

    }

    public static char codificador(char x) {
//pega cada caracter que vem do main e codifica na chave 3(somando +3 ao caracter)
       char volta = (char)(x+3);
       return volta;//devolve o valor para a funçao main
    }

    public static boolean Vef(String teste)
{// Metodo para verificar o flag
        boolean pa = true;
       
         if   (teste.length() == 3 && teste.charAt(0) == 'F' && teste.charAt(1) == 'I' && teste.charAt(2) == 'M')
         {
             pa = false;
         }
         return pa;
    }


}
