/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpustakaan;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormPeminjaman extends javax.swing.JFrame {

 private final DBConnection dbConnection;
 
    public FormPeminjaman() {
        initComponents();
        dbConnection = new DBConnection(); // Inisialisasi objek DBConnection
        loadDataToTable(); // Load data ke JTable saat form pertama kali dibuka
    }
    
    private void updateBookQuantity(String noBuku, int quantityChange) {
    try {
        Connection con = dbConnection.getConnection();
        if (con != null) {
            String sql = "UPDATE buku SET quantity = quantity + ? WHERE no_buku = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, quantityChange);
            pstmt.setString(2, noBuku);
            pstmt.executeUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
    
     private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0); // Reset data di tabel

        try {
            Connection con = dbConnection.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM peminjaman_buku";
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String nim = rs.getString("nim");
                    String judulBuku = rs.getString("judul_buku");
                    String nobuku = rs.getString("no_buku");
                    String tanggalPinjam = rs.getString("tanggal_pinjam");
                    String tanggal_hruskembali = rs.getString("tanggal_Hkembali");

                    model.addRow(new Object[]{nim, judulBuku, nobuku, tanggalPinjam, tanggal_hruskembali});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtnim = new javax.swing.JTextField();
        txtJudulBuku = new javax.swing.JTextField();
        txtTanggalPinjam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTglHKembali = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtnobuku = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KELOLA DATA PEMINJAMAN");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Judul Buku", "Kode Buku", "Tgl Pinjam", "Tgl Batas Kembali"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        txtnim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnimActionPerformed(evt);
            }
        });

        txtJudulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulBukuActionPerformed(evt);
            }
        });

        txtTanggalPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalPinjamActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Judul Buku");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tgl Pinjam");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTglHKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglHKembaliActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tgl Batas Waktu");

        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Kode Buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(144, 144, 144))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jButton1)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTglHKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnim, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnobuku, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnobuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTglHKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTanggalPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalPinjamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String nim = txtnim.getText();
    String judulBuku = txtJudulBuku.getText();
    String nobuku = txtnobuku.getText();
    String tanggalPinjam = txtTanggalPinjam.getText();
    String tanggal_hruskembali = txtTglHKembali.getText();

    if (nim.isEmpty() || judulBuku.isEmpty() || tanggalPinjam.isEmpty() || tanggal_hruskembali.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua kolom harus diisi");
    } else {
        Connection con = null;
        try {
            con = dbConnection.getConnection();
            if (con != null) {
                // Periksa quantity buku
                String sqlCheckQuantity = "SELECT quantity FROM buku WHERE no_buku = ?";
                PreparedStatement pstmtCheck = con.prepareStatement(sqlCheckQuantity);
                pstmtCheck.setString(1, nobuku);
                ResultSet rs = pstmtCheck.executeQuery();

                if (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(this, "Buku tidak tersedia/dipinjam");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Buku tidak ditemukan");
                    return;
                }

                // Simpan peminjaman
                String sqlInsert = "INSERT INTO peminjaman_buku (nim, judul_buku, no_buku, tanggal_pinjam, tanggal_Hkembali) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);
                pstmtInsert.setString(1, nim);
                pstmtInsert.setString(2, judulBuku);
                pstmtInsert.setString(3, nobuku);
                pstmtInsert.setString(4, tanggalPinjam);
                pstmtInsert.setString(5, tanggal_hruskembali);

                int result = pstmtInsert.executeUpdate();
                if (result > 0) {
                    // Kurangi quantity buku
                    updateBookQuantity(nobuku, -1);

                    JOptionPane.showMessageDialog(this, "Peminjaman berhasil disimpan");
                    // Reset form setelah berhasil menyimpan
                    txtnim.setText("");
                    txtJudulBuku.setText("");
                    txtnobuku.setText("");
                    txtTanggalPinjam.setText("");
                    txtTglHKembali.setText("");
                    // Reload data ke JTable
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menyimpan peminjaman");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTglHKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglHKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglHKembaliActionPerformed

    private void txtJudulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulBukuActionPerformed

    private void txtnimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnimActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int keluar;
        keluar = JOptionPane.showOptionDialog(this,
            "keluar dari Data Peminjam",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(keluar==JOptionPane.YES_NO_OPTION){
            new Formutama().show();
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
 String nim = txtnim.getText();
    String judulBuku = txtJudulBuku.getText();
    String nobuku = txtnobuku.getText();
    String tanggalPinjam = txtTanggalPinjam.getText();
    String tanggal_hruskembali = txtTglHKembali.getText();

    if (nim.isEmpty() || judulBuku.isEmpty() || tanggalPinjam.isEmpty() || tanggal_hruskembali.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua kolom harus diisi");
    } else {
        Connection con = null;
        try {
            con = dbConnection.getConnection();
            if (con != null) {
                // Ambil no_buku lama
                String oldNoBuku = "";
                String sqlSelect = "SELECT no_buku FROM peminjaman_buku WHERE nim = ?";
                PreparedStatement pstSelect = con.prepareStatement(sqlSelect);
                pstSelect.setString(1, nim);
                ResultSet rs = pstSelect.executeQuery();
                if (rs.next()) {
                    oldNoBuku = rs.getString("no_buku");
                }

                // Periksa quantity buku baru
                String sqlCheckQuantity = "SELECT quantity FROM buku WHERE no_buku = ?";
                PreparedStatement pstmtCheck = con.prepareStatement(sqlCheckQuantity);
                pstmtCheck.setString(1, nobuku);
                ResultSet rsQuantity = pstmtCheck.executeQuery();

                if (rsQuantity.next()) {
                    int quantity = rsQuantity.getInt("quantity");
                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(this, "Buku tidak tersedia/dipinjam");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Buku tidak ditemukan");
                    return;
                }

                // Update peminjaman
                String sqlUpdate = "UPDATE peminjaman_buku SET judul_buku = ?, no_buku = ?, tanggal_pinjam = ?, tanggal_Hkembali = ? WHERE nim = ?";
                PreparedStatement pstmtUpdate = con.prepareStatement(sqlUpdate);
                pstmtUpdate.setString(1, judulBuku);
                pstmtUpdate.setString(2, nobuku);
                pstmtUpdate.setString(3, tanggalPinjam);
                pstmtUpdate.setString(4, tanggal_hruskembali);
                pstmtUpdate.setString(5, nim);

                int result = pstmtUpdate.executeUpdate();
                if (result > 0) {
                    // Kembalikan quantity buku lama jika berbeda
                    if (!oldNoBuku.equals(nobuku)) {
                        updateBookQuantity(oldNoBuku, 1);  // Kembalikan quantity buku lama
                        updateBookQuantity(nobuku, -1);   // Kurangi quantity buku baru
                    }

                    JOptionPane.showMessageDialog(this, "Peminjaman berhasil diupdate");
                    // Reset form setelah berhasil menyimpan
                    txtnim.setText("");
                    txtJudulBuku.setText("");
                    txtnobuku.setText("");
                    txtTanggalPinjam.setText("");
                    txtTglHKembali.setText("");
                    // Reload data ke JTable
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal mengupdate peminjaman");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
   String nim = txtnim.getText();

    if (nim.isEmpty()) {
        JOptionPane.showMessageDialog(this, "NIM harus diisi");
    } else {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus peminjaman dengan NIM: " + nim + "?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection con = dbConnection.getConnection();
                if (con != null) {
                    String sql = "DELETE FROM peminjaman_buku WHERE nim = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, nim);

                    int result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Peminjaman berhasil dihapus");
                        // Reset form setelah berhasil menghapus
                        txtnim.setText("");
                        txtJudulBuku.setText("");
                        txtnobuku.setText("");
                        txtTanggalPinjam.setText("");
                        txtTglHKembali.setText("");
                        // Reload data ke JTable
                        loadDataToTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus peminjaman");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Koneksi ke database gagal");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
    int row = tabel.getSelectedRow();
    if (row != -1) {
        // Ambil data dari tabel
        String nim = tabel.getValueAt(row, 0).toString();
        String judulBuku = tabel.getValueAt(row, 1).toString();
        String nobuku = tabel.getValueAt(row, 2).toString();
        String tanggalPinjam = tabel.getValueAt(row, 3).toString();
        String tanggal_hruskembali = tabel.getValueAt(row, 4).toString();
        
        // Isi data ke dalam field
        txtnim.setText(nim);
        txtJudulBuku.setText(judulBuku);
        txtnobuku.setText(nobuku);
        txtTanggalPinjam.setText(tanggalPinjam);
        txtTglHKembali.setText(tanggal_hruskembali);
    }
    }//GEN-LAST:event_tabelMouseClicked

   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtTanggalPinjam;
    private javax.swing.JTextField txtTglHKembali;
    private javax.swing.JTextField txtnim;
    private javax.swing.JTextField txtnobuku;
    // End of variables declaration//GEN-END:variables
}
