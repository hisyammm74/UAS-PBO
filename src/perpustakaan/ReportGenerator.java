/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perpustakaan;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JOptionPane;
import java.io.InputStream;

public class ReportGenerator {

    public static void main(String[] args) {
        new ReportGenerator().showReport();
    }

    public void showReport() {
    try {
        InputStream reportStream = getClass().getResourceAsStream("/perpustakaan/reporthbuku.jasper");
        
        if (reportStream == null) {
            JOptionPane.showMessageDialog(null, "Report file not found.");
            return; // Keluar dari metode jika file tidak ditemukan
        } else {
            JOptionPane.showMessageDialog(null, "Report file found.");
        }

        // Debugging: Tampilkan ukuran file
        int fileSize = reportStream.available();
        JOptionPane.showMessageDialog(null, "Report file size: " + fileSize + " bytes");

        // Jika file ditemukan, lanjutkan dengan memuat laporan
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null);
        JasperViewer.viewReport(jasperPrint, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error generating report: " + e.getMessage());
    }
}
}
