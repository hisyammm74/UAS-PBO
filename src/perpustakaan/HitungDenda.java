
package perpustakaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HitungDenda extends javax.swing.JFrame {

 private final DBConnection dbConnection;
    
    
    public HitungDenda() {
          initComponents();
        dbConnection = new DBConnection(); // Inisialisasi objek DBConnection
        loadDendaToTable();
        cmbKondisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terlambat", "Halaman Sobek", "Rusak", "Hilang" }));
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNamaPeminjam = new javax.swing.JTextField();
        txtJudulBuku = new javax.swing.JTextField();
        cmbKondisi = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtTotalDenda = new javax.swing.JTextField();
        btntotal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        txtNamaPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPeminjamActionPerformed(evt);
            }
        });

        txtJudulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulBukuActionPerformed(evt);
            }
        });

        cmbKondisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKondisiActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Judul Buku", "Status Buku", "Denda"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        btntotal.setText("Total");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM HITUNG DENDA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Judul Buku");

        jButton3.setText("Keluar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Semua Data Denda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(cmbKondisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDelete)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(txtNamaPeminjam, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btntotal)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTotalDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbKondisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntotal))
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int keluar;
        keluar = JOptionPane.showOptionDialog(this,
            "keluar dari Data Anggota",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(keluar==JOptionPane.YES_NO_OPTION){
            new Formutama().show();
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int selectedRow = tabel.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            String namaPeminjam = model.getValueAt(selectedRow, 0).toString();
            String judulBuku = model.getValueAt(selectedRow, 1).toString();

            try {
                Connection con = dbConnection.getConnection();
                if (con != null) {
                    String sql = "DELETE FROM denda_buku WHERE nama_peminjam = ? AND judul_buku = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, namaPeminjam);
                    pstmt.setString(2, judulBuku);

                    int rowsDeleted = pstmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Data denda berhasil dihapus.");
                        model.removeRow(selectedRow); // Hapus baris dari tabel GUI
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data denda.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int keluar;
        keluar = JOptionPane.showOptionDialog(this,
            "keluar dari Data Denda",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(keluar==JOptionPane.YES_NO_OPTION){
            new Formutama().show();
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        double totalDenda = 0.0;
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            totalDenda += (int) model.getValueAt(i, 3);
        }

        txtTotalDenda.setText(String.valueOf(totalDenda));
    }//GEN-LAST:event_btntotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String namaPeminjam = txtNamaPeminjam.getText().trim();
        String judulBuku = txtJudulBuku.getText().trim();
        String kondisiBuku = cmbKondisi.getSelectedItem().toString();
        int denda = hitungDenda(kondisiBuku); // Panggil fungsi hitungDenda() dengan kondisi buku yang dipilih

        if (namaPeminjam.isEmpty() || judulBuku.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Peminjam dan Judul Buku harus diisi!");
            return;
        }

        try {
            Connection con = dbConnection.getConnection();
            if (con != null) {
                String sql = "INSERT INTO denda_buku (nama_peminjam, judul_buku, kondisi_buku, denda) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, namaPeminjam);
                pstmt.setString(2, judulBuku);
                pstmt.setString(3, kondisiBuku);
                pstmt.setInt(4, denda);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data denda berhasil disimpan.");

                    // Kosongkan field setelah data disimpan
                    txtNamaPeminjam.setText("");
                    txtJudulBuku.setText("");
                    cmbKondisi.setSelectedIndex(0);

                    // Muat ulang data denda ke dalam tabel
                    loadDendaToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menyimpan data denda.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbKondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKondisiActionPerformed

    private void txtJudulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulBukuActionPerformed

    private void txtNamaPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPeminjamActionPerformed
       
    private int hitungDenda(String kondisi) {
        switch (kondisi) {
            case "Terlambat":
                return 5000;
            case "Halaman Sobek":
                return 15000;
            case "Rusak":
                return 50000;
            case "Hilang":
                return 150000;
            default:
                return 0;
        }
    }
 
        
        private void loadDendaToTable() {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0); // Mengosongkan tabel sebelum memuat data baru

        try {
            Connection con = dbConnection.getConnection();
            if (con != null) {
                String sql = "SELECT nama_peminjam, judul_buku, kondisi_buku, denda FROM denda_buku";
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String namaPeminjam = rs.getString("nama_peminjam");
                    String judulBuku = rs.getString("judul_buku");
                    String kondisiBuku = rs.getString("kondisi_buku");
                    int denda = rs.getInt("denda");

                    model.addRow(new Object[]{namaPeminjam, judulBuku, kondisiBuku, denda});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(HitungDenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HitungDenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HitungDenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HitungDenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HitungDenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btntotal;
    private javax.swing.JComboBox<String> cmbKondisi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtNamaPeminjam;
    private javax.swing.JTextField txtTotalDenda;
    // End of variables declaration//GEN-END:variables
}
