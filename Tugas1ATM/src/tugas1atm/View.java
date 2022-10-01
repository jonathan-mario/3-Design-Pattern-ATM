/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1atm;

/**
 *
 * @author jonat
 */
import java.util.Scanner;

/**
 *
 * @author
 */
public class View{
    Scanner sc = new Scanner(System.in);
    private static View view = new View();
    
    public View(){}
    
    public static View getInstance(){
        return view;
    }
    
    public int mainMenu(){
        System.out.println("\nSelamat datang di ATM");
        System.out.println("Masukan Pilihan Anda :");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Setor Tunai");
        System.out.println("4. Exit");
        System.out.print("Pilihan : ");
        
        return sc.nextInt();
    }
    
    public void cekSaldo(Model saldo){
        System.out.println("\nSaldo Anda Rp."+saldo.csaldo.getSaldo());
    }
    
    public void tarikTunai(Model saldo){
        int jumlah;
        System.out.print("Masukkan jumlah penarikan (Kelipatan 50000) : Rp.");
        jumlah = sc.nextInt();
        
        if(saldo.isLimit()){
            System.out.println("\nSaldo Anda Mencapai Limit");
        }else if((saldo.getSaldo() - jumlah) < saldo.limit()){
            System.out.println("\nJumlah Penarikan Melebihi Limit Saldo Anda");
        }else if((saldo.getSaldo() > jumlah) && (saldo.cekTransaksi(jumlah) == 0)){
            saldo.tarikSaldo(jumlah);
            System.out.println("Anda Mengambil Uang Sejumlah : Rp."+jumlah);
        }else{
            System.out.println("Harus Kelipatan 50000");
        }
    }
    
    public void setorTunai(Model saldo){
        int jumlah;
        System.out.print("Masukkan Jumlah Setoran (Kelipatan 50000) : Rp.");
        jumlah = sc.nextInt();
        if(saldo.cekTransaksi(jumlah) == 0){
            saldo.addSaldo(jumlah);
            System.out.println("Saldo Anda Bertambah Sejumlah : Rp."+jumlah);
        }else{
            System.out.println("Harus Kelipatan 50000");
        }
    }
}