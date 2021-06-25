import java.lang.reflect.Array;

class Celula {
   public int elemento; // elemento contido dentro da celula
   public Celula inf, sup, esq, dir; //referencias para apontar para outras celulas

   public Celula() {// construtor com padrao
      this(0);
   }

   public Celula(int elemento) { // construtor com parametragem
      this(elemento, null, null, null, null);
   }
// construtor com parametragem total
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}

class Matriz {
   private Celula inicio; //celula inicial
   private int linha, coluna; //linhas e colunas da matriz

   public Matriz() {
      this(3, 3);
   }

   public Matriz(int linha, int coluna) {
      this.linha = linha;
      this.coluna = coluna;

      // alocar a matriz com this.linha linhas e this.coluna colunas
      //Criando uma matriz "vazia" (um monte de 21 dentro dela)
      Celula T;
      Celula S;
      inicio = new Celula(3);
      int ll, cc;
      ll = cc = 1;
      for (S = inicio; cc < coluna; S = S.dir) {
         S.dir = new Celula(21);
         S.dir.esq = S;

         cc++;
      }
      for (T = inicio; ll < linha; T = T.inf, ll++) {
         T.inf = new Celula(21);
         T.inf.sup = T;

         for (S = T.inf, cc = 1; cc < coluna; S = S.dir, cc++) {
            S.dir = new Celula(21);
            S.dir.esq = S;
            S.dir.sup = S.sup.dir;
            S.sup.dir.inf = S.dir;

         }
      }

   }
//mostra a metriz
   public void mostrarMatriz() {
      for (Celula p = inicio; p != null; p = p.inf) {
         for (Celula pp = p; pp != null; pp = pp.dir) {
            System.out.print(pp.elemento + " ");
         }
         System.out.println(" ");
      }

   }
   //inseri elementos na matriz enquanto le a entrada
   public Celula colocar(int linhas, int colunas) {
      for (Celula p = inicio; p != null; p = p.inf) {
         for (Celula pp = p; pp != null; pp = pp.dir) {
            pp.elemento = MyIO.readInt();
         }

      }

      return this.inicio;
   }
   //acha um valor na matriz em uma posicao especifica
   public int localiza(int col, int lin) {
      Celula loc1;
      Celula loc2;

      int pitreto = 0;
      int pittorto = 0;
      int resultado = 0;
      for (loc1 = inicio, pitreto = 1; loc1 != null; loc1 = loc1.inf, pitreto++) {
         for (loc2 = loc1, pittorto = 1; loc2 != null; loc2 = loc2.dir, pittorto++) {
            if (pitreto == col && pittorto == lin) {
               resultado = loc2.elemento;

               

            }
         }

      }

      return resultado;
   }
   //soma duas matrizes e armazena na nova matriz 3
   public Matriz soma(Matriz m1, Matriz m2) {
      Matriz m3 = new Matriz(this.linha, this.coluna);

      int dsj1 = 0;
      int dsj2 = 0;
      Celula p;
      Celula pp;
      for (p = m3.inicio, dsj1 = 1; p != null; p = p.inf, dsj1++) // navegando na matriz de celulas
      {
         for (pp = p, dsj2 = 1; pp != null; pp = pp.dir, dsj2++) {
            pp.elemento = m1.localiza(dsj1, dsj2) + m2.localiza(dsj1, dsj2);

         }
      }

      m3.mostrarMatriz();

      return m3;
   }


//pega os valores da diagona principal e mostra na tela
   public void mostrarDiagonalPrincipal() {
      Celula loc1;
      Celula loc2;

      int pitreto = 0;
      int pittorto = 0;
      int resultado = 0;
      //como a diagonal principal sao sempre os valores iguais tipo: [1][1] || [2][2]
      //e so variar e colocar if para mostrar quando forem iguais
      for (loc1 = inicio, pitreto = 1; loc1 != null; loc1 = loc1.inf, pitreto++) {
         for (loc2 = loc1, pittorto = 1; loc2 != null; loc2 = loc2.dir, pittorto++) {
            if (pitreto == pittorto) {
               resultado = loc2.elemento;
               System.out.print(resultado + " ");

            }

         }

      }
     

   }
/*como a diagonal principal pode ser achada por acrecimo e decrecimo em col e linha de forma alternada
por exemplo: [1][3] depois vira [2][2] depois vira [3][1] seria a diag de uma 3x3
levando em conta que uso o indice inicial igual a 1 */
   public void mostrarDiagonalSecundaria(int col, int lin) {
      Celula loc1;
      Celula loc2;

      int pitreto = 0;
      int pittorto = 0;
      int aux1 = (col - lin) + 1;
      int aux2 = lin;
      int resultado = 0;
      for (loc1 = inicio, pitreto = 1; loc1 != null; loc1 = loc1.inf, pitreto++) {
         for (loc2 = loc1, pittorto = 1; loc2 != null; loc2 = loc2.dir, pittorto++) {
            if (pitreto == aux1 && pittorto == aux2) {
               resultado = loc2.elemento;
               System.out.print(resultado + " ");
               aux1++;
               aux2--;
            }

         }

      }
   }

   //apesar do nome essa funcao pega a matriz de celula e coloca ela em uma matriz
   public int[][] pegacoluna() {
      Celula loc1;
      Celula loc2;

      int pitreto = 0;
      int pittorto = 0;
      int controle = 0;
      int[][] resultado = new int[this.coluna][this.linha];
      int colunafake = 0;
      int linhafake = 0;
      //varia a matriz de celula e a normal (matriz resultado)
      for (loc1 = inicio, pitreto = 1, linhafake = 0; loc1 != null; loc1 = loc1.inf, pitreto++, linhafake++) {
         for (loc2 = loc1, pittorto = 1, colunafake = 0; loc2 != null; loc2 = loc2.dir, pittorto++, colunafake++) {

            resultado[linhafake][colunafake] = loc2.elemento;
            controle++;

         }

      }
      return resultado;
   }
//gera a multiplicacao entre matrizes 
   public int[][] recepta(Matriz m1, Matriz m2) {
      int[][] matriz1 = m1.pegacoluna();
      int[][] matriz2 = m2.pegacoluna();
      int[][] matrizResultante = new int[this.linha][this.coluna];

      for (int i = 0; i < this.linha; i++) {
         for (int j = 0; j < this.coluna; j++) {
            int sm = 0;
            for (int k = 0; k < this.linha; k++) {
               sm = sm + (matriz1[i][k] * matriz2[k][j]);
            }
            matrizResultante[i][j] = sm;
            
            
         }
      
      }
      return matrizResultante;
   }
   //passa a matriz ja multiplicada para a matriz de celulas
   public void multiplex(Matriz m1, Matriz m2) {
      Matriz m3 = new Matriz(this.linha, this.coluna);
      int[][] matriz1 = recepta(m1, m2);

      int dsj1 = 0;
      int dsj2 = 0;
      int variador1 = 0;
      int variador2 = 0;
      Celula p;
      Celula pp;
      for (p = m3.inicio, dsj1 = 1, variador1 = 0; p != null; p = p.inf, dsj1++, variador1++)// coluna /- linha
      {
         for (pp = p, dsj2 = 1, variador2 = 0; pp != null; pp = pp.dir, dsj2++, variador2++) {
            pp.elemento = matriz1[variador1][variador2];

         }
      }

      m3.mostrarMatriz();
   }
}
//main
class matrizFlex {

   public static void main(String[] args) {

      int numeroDeMatrizes = MyIO.readInt();
      //le as duas matrizes e chama as funcoes de execucao
      for (int i = 0; i < numeroDeMatrizes; i++) {
         int linha1 = MyIO.readInt();
         int coluna1 = MyIO.readInt();
         Matriz mat1 = new Matriz(linha1, coluna1);
         mat1.colocar(linha1, coluna1);

         int linha2 = MyIO.readInt();
         int coluna2 = MyIO.readInt();
         Matriz mat2 = new Matriz(linha2, coluna2);
         mat2.colocar(linha2, coluna2);

         Matriz mat3 = new Matriz(linha2, coluna2);

         mat1.mostrarDiagonalPrincipal();
         System.out.println(" ");
         mat1.mostrarDiagonalSecundaria(coluna1, linha1);
         System.out.println(" ");
         mat3.soma(mat1, mat2);
          
          mat3.multiplex(mat1, mat2);

      }

   }
}