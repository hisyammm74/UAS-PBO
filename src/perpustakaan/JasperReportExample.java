/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perpustakaan;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperReportExample {
    public static void main(String[] args) {
        try {
            // Memuat laporan dari file .jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\ADITYA\\Documents\\NetBeansProjects\\perpustakaan\\src\\perpustakaan\\reporthbuku.jasper");

            // Parameter untuk laporan, jika diperlukan
            Map<String, Object> parameters = new HashMap<>();

            // Membaca data dari database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus", "root", "");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

            // Menampilkan laporan
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException e) {
            e.printStackTrace();
        }
    }

}
    

