/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.exam.bootcampexam;

import static com.tabeldata.exam.bootcampexam.bootCampExam.getKoneksiKeDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arrai
 */
public class EmployeesRepository {

    void showContacts() throws SQLException {
        PreparedStatement perintah = getKoneksiKeDB().prepareStatement("SELECT * FROM Contacts");
        ResultSet hasil = perintah.executeQuery();
        while (hasil.next()) {

            String IDkontak = hasil.getString("ID");
            String kontak = hasil.getString("Description");
            System.out.println("ID : " + IDkontak + "Description : " + kontak);
        }
    }

    public MITS saveData(MITS employee) throws SQLException {
        Connection koneksi = bootCampExam.getKoneksiKeDB();

        try {
            PreparedStatement perintah = koneksi.prepareStatement("INSERT INTO Employees (BirthDate, BirthPlace, BPJSKerjaNo, "
                    + "BPJSSehatNo, DriverLicenseExpDate, DriverLicenseNo, EmpNo, FirstName, LastName, MiddleName, NoKTP, NPWP, "
                    + "PhotoPath, ContactID, GenderID, LoginDetailsID, MaritalStatusID, NationalityID, ReligionID, WorkShiftID)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            perintah.setString(1, employee.getBirthDate());
            perintah.setString(2, employee.getBirthPlace());
            perintah.setString(3, employee.getBPJSKerjaNo());
            perintah.setString(4, employee.getBPJSKerjaNo());
            perintah.setString(5, employee.getDriverLicenseExpDate());
            perintah.setString(6, employee.getDriverLicenseNo());
            perintah.setString(7, employee.getEmpNo());
            perintah.setString(8, employee.getFirstName());
            perintah.setString(9, employee.getLastName());
            perintah.setString(10, employee.getMiddleName());
            perintah.setString(11, employee.getNoKTP());
            perintah.setString(12, employee.getNPWP());
            perintah.setString(13, employee.getPhotoPath());
            perintah.setInt(14, employee.getContactID());
            perintah.setInt(15, employee.getGenderID());
            perintah.setInt(16, employee.getLoginID());
            perintah.setInt(17, employee.getMartialStatusID());
            perintah.setInt(18, employee.getNationalityID());
            perintah.setInt(19, employee.getReligionID());
            perintah.setInt(20, employee.getWorkShiftID());

            perintah.executeUpdate();

            koneksi.commit(); //simpan data secara permanen
            System.out.println("Berhasil Update!");
            perintah.close();
            koneksi.close();

        } catch (SQLException sqle) {
            if (koneksi != null) {
                try {
                    koneksi.rollback();
                    System.out.println("Rollback Berhasil");
                } catch (SQLException sqle2) {
                    System.out.println("Tidak dapat melalukan rollback");
                    sqle2.printStackTrace();
                }
            }
        }
        return employee;
    }
}
