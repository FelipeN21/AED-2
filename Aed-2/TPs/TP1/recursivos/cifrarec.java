
public class cifrarec {
    public static void main(String[] args) {
 
exec(true);
    }

    public static boolean exec(boolean ps)
    {
ps =  true;
        String cifrar = MyIO.readLine();
        if(Vef(cifrar)==true)
        {
         
        
            String cifrado = "";
             // navega na string passando caracter a caracter para a fun�ao
             for(int c = 0; c < cifrar.length(); c++){
                 cifrado += codificador(cifrar.charAt(c));
             }
             MyIO.println(cifrado);//printa o resultado
             
            

        return exec(ps);
            }
        else{
            return false;
        }
    }

    public static char codificador(char x) {
//pega cada caracter que vem do main e codifica na chave 3(somando +3 ao caracter)
       char volta = (char)(x+3);
       return volta;//devolve o valor para a fun�ao main
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
