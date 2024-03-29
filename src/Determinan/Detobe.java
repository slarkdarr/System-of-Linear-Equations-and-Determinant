package Determinan;
import java.util.Scanner;

public class Detobe {
    public double determinan(double M[][]){
        //KAMUS LOKAL
        int i,j,k,l;
        int tukar = 0;
        int N = M.length;
        boolean nol;
        double temp[] = new double[N];
        Determinan.Detobe detobe = new Determinan.Detobe();

        //ALGORITMA
        //Pembuatan matriks eselon
        k=0;
        for (j=0; j<N; j++){
            //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
            detobe.pembulatan(M);

            // Menukar apabila baris pertama 0            
            if (M[k][j] == 0){
                nol = true;
                i = k+1;
                while ((nol==true) && (i<N)){
                    if (M[i][j] != 0){
                        temp = M[k];
                        M[k] = M[i];
                        M[i] = temp;
                        tukar += 1;
                        nol = false;
                    } 
                    else i+=1;
                }
            }
        
            if (M[k][j] != 0){
                //Operasi pengurangan
                for (i=k+1; i<N; i++){
                    double pengali = M[i][j];
                    double pembagi = M[k][j];
                    for (l=j; l<N; l++)
                        M[i][l] -= (pengali*M[k][l])/pembagi;
                }
                k+=1;
            }
        }

        //Menghitung determinan
        double det = M[0][0];
        for (i=1; i<N; i++)
            det *= M[i][i];
        if (tukar%2 == 1)
            det *= -1;

        return det;
    }

    public void pembulatan(double A[][]){
        //KAMUS
        int i,j;
        int N = A.length;
        int M = A.length;
        //ALGORITMA
        for (i=0; i<N; i++){
            for(j=0; j<M; j++){
                if ((Math.abs(A[i][j])%1>0.99999) || (Math.abs(A[i][j])%1<0.00001)){
                    A[i][j] = Math.round(A[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        // KAMUS
        int i,j;
        double hasil;
        Scanner scan = new Scanner(System.in);
        Determinan.Detobe detobe = new Determinan.Detobe();

        //PROGRAM UTAMA
        System.out.println("Determinan Reduksi Baris");
        System.out.print("Masukkan N : ");
        int N = scan.nextInt();

        double M[][] = new double[N][N];
        System.out.println("Masukkan Koefisien Matriks : ");
        for (i = 0; i < N; i++) 
            for (j = 0; j < N; j++)
              M[i][j] = scan.nextDouble();
        
        hasil = detobe.determinan(M);
        System.out.print("Determinan : " + hasil);
    }
}