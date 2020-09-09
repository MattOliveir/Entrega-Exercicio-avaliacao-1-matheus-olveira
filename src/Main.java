import java.util.Random;
import java.lang.Math;




public class Main {


    public static void main(String[] args) {

        Random aleatorio = new Random(200);

        long[] vetor1 = new long[32];
        long[] vetor2 = new long[2048];
        long[] vetor3 = new long[1048576];


        //32

        //populaVetorR(vetor1);
        //printaVetor(vetor1);

        //meuMergeSort(vetor1,0,31,0);

        //System.out.println("\n-------------- 1\n\n");

        //printaVetor(vetor1);

        //System.out.println("Valor Maximo do Vetor: "+(maxVal1(vetor1,32,2)));

        //System.out.println("Valor Maximo do Vetor(RECURSIVO)" + maxVal2(vetor1,0,31,2));



        //2048

        //populaVetorR(vetor2);
        //printaVetor(vetor2);

        //meuMergeSort(vetor2,0,2047,2);

        //System.out.println("\n------------- 2\n\n");

        //printaVetor(vetor2);

        //System.out.println("Valor Maximo do Vetor: "+(maxVal1(vetor2,2048,2)));

        //System.out.println("Valor Maximo do Vetor(RECURSIVO)" + maxVal2(vetor2,0,2047,2));


        //1048576

        populaVetorR(vetor3);
        //printaVetor(vetor3);

        //CASO RANDOMICO

        System.out.println("Valor Maximo do Vetor: "+(maxVal1(vetor3,1048576,2)));

        System.out.println("Valor Maximo do Vetor(RECURSIVO)" + maxVal2(vetor3,0,1048575,2));

        meuMergeSort(vetor3,0,1048575,2);

        System.out.println("\n--------------- 3\n\n");

        //printaVetor(vetor3);

        //PIOR CASO PQ JÁ TÁ ARRUMADO
        //System.out.println("Valor Maximo do Vetor: "+(maxVal1(vetor3,1048576)));


        //-----



        //3





        long um = multiply(8,4,8,2);

        long dois = multiply(8,4,1,2);

        long tres = multiply(22,40,8,2);

        long quatro = multiply(5000,1000,12,2);


        System.out.println("Multiply 1: "+ um);

        System.out.println("Multiply 2: "+ dois);

        System.out.println("Multiply 3: "+ tres);

        System.out.println("Multiply 4: "+ quatro);

    }


    // devolve o valor máximo da primeira metade e o máximo da segunda metade do mesmo vetor de entrada na recursao




    public static long maior(long A, long B){

        if(A < B) return B; else return A;

    }

    public static long maxVal1(long A[], int n,int cont) {


        cont = cont+3;
        long max = A[0];//3

        cont = cont+5;
        for (int i = 1; i < n; i++) {//5  -  3

            cont = cont+3;
            if( A[i] > max ){//3
                max = A[i];
                cont = cont+5;
            }//2
        }
        cont++;

        System.out.println("Iterações maxVal1: "+cont);
        return max;//1
    }

    public static long maxVal2(long A[], int init, int end,int cont) {

        //2

        if (end - init <= 1) {//4

            cont=cont+11;
            //System.out.println("iteracao2: " + cont+4);
            return maior(A[init], A[end]);//4 + 3 da execucao

        }
        else {
            cont=cont+5;
            int m = (init + end)/2;//4


            cont=cont+3;
            long v1 = maxVal2(A,init,m,cont);//3


            cont=cont+3;
            long v2 = maxVal2(A,m+1,end,cont);//3


            System.out.println("iteracao2: " + cont);
            cont=cont+5;
            return maior(v1,v2);//2

        }

    }

    public static void printaVetor(long[] vetorP){

        for(int i = 0;i< vetorP.length;i++){

            System.out.println(vetorP[i] + " - " + i+" | ");

        }


    }

    public static long[] populaVetorR(long[] vetorE){

        Random aleatorio = new Random(26);

        for (int i = 0; i < vetorE.length;i++){

            int NumR = aleatorio.nextInt(1000000);
            vetorE[i] = NumR;

        }
        return vetorE;
    }

    public static void meuMergeSort(long[] vetor, int inicio,int fim,int cont){


        cont = cont+4;
        if (fim <= inicio)return;

        cont = cont+4;
        int meio = (inicio + fim) /2;

        cont++;
       meuMergeSort(vetor,inicio,meio,cont);

        cont++;
       meuMergeSort(vetor,meio+1,fim,cont);

        cont = cont+5;
        long[] A = new long[meio-inicio+1];


        cont = cont+3;
        long[] B = new long[fim-meio];


       //INICIALIZA A PRIMEIRA METADE

        cont = cont+7;
       for(int i =0;i<= meio-inicio;i++){

           cont = cont+5;

           cont = cont+4;
           A[i] = vetor[inicio+i];

       }

       // INICIALIZA A SEGUNDA METADE

        cont = cont+8;
       for(int i =0;i<= fim - meio-1;i++){

           cont = cont+6;

           cont = cont+4;
            B[i] = vetor[meio+1+i];

       }

       // CRIA VARIÁVEIS DE APOIO

        cont = cont+2;
        int i = 0;
        cont = cont+2;
        int j = 0;


        cont = cont+7;
        for (int k=inicio;k<= fim;k++){

            cont = cont+6;
            if(i< A.length && j < B.length){

                cont = cont+4;
                if(A[i] < B[j]){

                    cont = cont+5;
                    vetor[k] = A[i++];


                }else{
                    cont = cont+5;
                    vetor[k] = B[j++];
                }

            }else if(i < A.length){

                cont = cont+3;

                cont = cont+5;
                vetor[k] = A[i++];


            }else if(j < B.length){

                cont = cont+3;
                cont = cont+5;
                vetor[k] = B[j++];

            }

        }

        //System.out.println("Iterações MergeSort: " + cont);
    }


   /* A Multiplicação Inteira de n-bits recebe dois números inteiros x e y de n-bits e retorna o resutado de x * y.

            Assim, novamente:

    implemente o algortimo abaixo;
    teste-o para os 3 casos de valores inteiros: com 4 bits, com 16 bits e com 64 bits. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto.
    O algoritmo está dado abaixo:



    MULTIPLY(x, y, n)
    IF (n = 1)
    RETURN x * y.
            ELSE
    m ← ⎡ n / 2 ⎤.
    a ← ⎣ x / 2^m ⎦; b ← x mod 2^m.
            c ← ⎣ y / 2^m ⎦; d ← y mod 2^m.
            e ← MULTIPLY(a, c, m).
    f ← MULTIPLY(b, d, m).
    g ← MULTIPLY(b, c, m).
    h ← MULTIPLY(a, d, m).
    RETURN 2^(2m)*e + 2^m*(g + h) + f.
    Ajuste a assinatura da sua implementação para receber tipo inteiros long (em java).


    */


   public static long multiply(long x,long y,long n,int cont){


       cont=cont=4;
       if(n == 1){ //4
           System.out.println("Multiply iteraçoes: "+ cont);
           return (x*y);
       }
       else{

           //System.out.println("AAAAAAAAAAAAAAAA");

           cont=cont=3;
           long m = (n/2); //3

           cont=cont=5;
           long a = (long)(x/ Math.pow(2,m)); //5

           cont=cont=5;
           long b = (x% (long) Math.pow(2,m));//5

           cont=cont=5;
           long c = (y/(long)Math.pow(2,m)); //5

           cont=cont=5;
           long d = y % (long)Math.pow(2,m); //5

           cont=cont=3;
           long e = multiply(a,c,m,cont);//3

           cont=cont=3;
           long f = multiply(b,d,m,cont);//3

           cont=cont=3;
           long g = multiply(b,c,m,cont);//3

           cont=cont=3;
           long h = multiply(a,d,m,cont);//3

           cont=cont+11;

           //System.out.println("Multiply iteraçoes: "+ cont);
           return (long)Math.pow(2,(2*m))*(e) + ((long)Math.pow(2,m)) * ( g + h ) + f;//11


       }


   }


}
