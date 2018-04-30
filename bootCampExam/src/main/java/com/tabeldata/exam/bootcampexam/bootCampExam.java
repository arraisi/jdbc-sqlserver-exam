package com.tabeldata.exam.bootcampexam;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class bootCampExam {

    public static Connection getKoneksiKeDB() throws SQLException {
        String username = "sa";
        String URL = "jdbc:sqlserver://localhost;databaseName=MITS;instanceName=SQLEXPRESS2017";
        String password = "16agustus1994";
        return DriverManager.getConnection(URL, username, password);
    }
//Connection koneksi = getKoneksiKeDB();

    

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        MITS mits = new MITS();
        
        EmployeesRepository employees = new EmployeesRepository();
        
        System.out.println("Masukan Tanggal Lahir 'YYYY-MM-DD' : ");
        mits.setBirthDate(input.next());
        System.out.println("Masukan Tempat Lahir : ");
        mits.setBirthPlace(input.next());
        System.out.println("Masukan No BPJS Ketenagakerjaan : ");
        mits.setBPJSKerjaNo(input.next());
        System.out.println("Masukan No BPJS Kesehatan : ");
        mits.setBPJSSehatNo(input.next());
        System.out.println("Masukan Jatuh Tempo SIM : ");
        mits.setDriverLicenseExpDate(input.next());
        System.out.println("Masukan No SIM : ");
        mits.setDriverLicenseNo(input.next());
        System.out.println("Masukan EmpNo : ");
        mits.setEmpNo(input.next());
        System.out.println("Masukan Nama Depan : ");
        mits.setFirstName(input.next());
        System.out.println("Masukan Nama Tengah : ");
        mits.setMiddleName(input.next());
        System.out.println("Masukan Nama Belakang : ");
        mits.setLastName(input.next());
        System.out.println("Masukan No. KTP : ");
        mits.setNoKTP(input.next());
        System.out.println("Masukan No. NPWP : ");
        mits.setNPWP(input.next());
        System.out.println("Masukan Poto Path : ");
        mits.setPhotoPath(input.next());
        //employees.showContacts();
        System.out.println("Masukan ID Contact : ");
        mits.setContactID(input.nextInt());
        System.out.println("Masukan ID Gender : ");
        mits.setGenderID(input.nextInt());
        System.out.println("Masukan ID login : ");
        mits.setLoginID(input.nextInt());
        System.out.println("Masukan ID Martial Status : ");
        mits.setMartialStatusID(input.nextInt());
        System.out.println("Masukan ID Nasionality : ");
        mits.setNationalityID(input.nextInt());
        System.out.println("Masukan ID Religion : ");
        mits.setReligionID(input.nextInt());
        System.out.println("Masukan ID Shift : ");
        mits.setWorkShiftID(input.nextInt());
        employees.saveData(mits);

    }
}
