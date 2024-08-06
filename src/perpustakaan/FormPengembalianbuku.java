
package perpustakaan;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormPengembalianbuku extends javax.swing.JFrame {

private final DBConnection dbConnection;
  
    public FormPengembalianbuku() {
        initComponents();
        dbConnection = new DBConnection(); // Inisialisasi objek DBConnection
        loadPengembalianToTable();
       
       cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baik", "Halaman Sobek", "Rusak", "Hilang" }));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnimPeminjam = new javax.swing.JTextField();
        txtJudulBuku = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtnobuku = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KELOLA DATA PENGEMBALIAN");

        txtnimPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnimPeminjamActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baik", "Rusak ringan", "Rusak ", "Hilang" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Judul Buku");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tgl Pengembalian");

        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtnobuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnobukuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Kode Buku");

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

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Judul Buku", "Kode Buku", "Tgl Pengembalian", "Status Buku"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnimPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnobuku, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnimPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnobuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnimPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnimPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnimPeminjamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String nim = txtnimPeminjam.getText().trim();
    String judulBuku = txtJudulBuku.getText().trim();
    String tglPengembalian = jTextField3.getText().trim();
    String nobuku = txtnobuku.getText().trim();
    String statusBuku = cmbStatus.getSelectedItem().toString();

    if (nim.isEmpty() || judulBuku.isEmpty() || tglPengembalian.isEmpty() || nobuku.isEmpty()) {
        JOptionPane.showMessageDialog(this, "NIM, Judul Buku, No Buku, dan Tanggal Pengembalian harus diisi!");
        return;
    }

    Connection con = null;
    try {
        con = dbConnection.getConnection();
        if (con != null) {
            con.setAutoCommit(false); // Mulai transaksi

            String sql = "INSERT INTO pengembalian_buku (nim, judul_buku, no_buku, tgl_pengembalian, status_buku) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nim);
            pstmt.setString(2, judulBuku);
            pstmt.setString(3, nobuku);
            pstmt.setString(4, tglPengembalian);
            pstmt.setString(5, statusBuku);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                if ("Baik".equals(statusBuku) || "Halaman Sobek".equals(statusBuku)) {
                    String updateQuantitySql = "UPDATE buku SET quantity = quantity + 1 WHERE no_buku = ?";
                    PreparedStatement updateQuantityPstmt = con.prepareStatement(updateQuantitySql);
                    updateQuantityPstmt.setString(1, nobuku);
                    updateQuantityPstmt.executeUpdate();
                }

                con.commit(); // Commit transaksi
                JOptionPane.showMessageDialog(this, "Data pengembalian berhasil disimpan.");

                loadPengembalianToTable();

                // Kosongkan field setelah data disimpan
                txtnimPeminjam.setText("");
                txtJudulBuku.setText("");
                jTextField3.setText("");
                txtnobuku.setText("");
                cmbStatus.setSelectedIndex(0);
            } else {
                con.rollback(); // Rollback transaksi jika gagal
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data pengembalian.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        try {
            if (con != null) {
                con.rollback(); // Rollback transaksi jika ada error
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saat rollback: " + e.getMessage());
        }
    } finally {
        try {
            if (con != null) {
                con.setAutoCommit(true); // Kembali ke mode auto-commit
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saat mengatur auto-commit: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int keluar;
        keluar = JOptionPane.showOptionDialog(this,
            "keluar dari Data Pengembalian",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(keluar==JOptionPane.YES_NO_OPTION){
            new Formutama().show();
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtnobukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnobukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnobukuActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
  int selectedRow = tabel.getSelectedRow();
    if (selectedRow != -1) {
        String nim = txtnimPeminjam.getText().trim();
        String judulBuku = txtJudulBuku.getText().trim();
        String tglPengembalian = jTextField3.getText().trim();
        String nobuku = txtnobuku.getText().trim();
        String statusBuku = cmbStatus.getSelectedItem().toString();

        if (nim.isEmpty() || judulBuku.isEmpty() || tglPengembalian.isEmpty() || nobuku.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM, Judul Buku, No Buku, dan Tanggal Pengembalian harus diisi!");
            return;
        }

        Connection con = null;
        String previousStatus = ""; // Untuk menyimpan status sebelumnya

        try {
            con = dbConnection.getConnection();
            if (con != null) {
                con.setAutoCommit(false); // Mulai transaksi
                
                // Ambil status buku sebelumnya
                String selectStatusSql = "SELECT status_buku FROM pengembalian_buku WHERE nim = ? AND no_buku = ?";
                PreparedStatement selectStatusPstmt = con.prepareStatement(selectStatusSql);
                selectStatusPstmt.setString(1, nim);
                selectStatusPstmt.setString(2, nobuku);
                ResultSet rs = selectStatusPstmt.executeQuery();
                if (rs.next()) {
                    previousStatus = rs.getString("status_buku");
                }

                // Update data pengembalian buku
                String sql = "UPDATE pengembalian_buku SET judul_buku = ?, no_buku = ?, tgl_pengembalian = ?, status_buku = ? WHERE nim = ? AND no_buku = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, judulBuku);
                pstmt.setString(2, nobuku);
                pstmt.setString(3, tglPengembalian);
                pstmt.setString(4, statusBuku);
                pstmt.setString(5, nim);
                pstmt.setString(6, nobuku);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    // Periksa perubahan status dan update quantity buku
                    if ("Baik".equals(previousStatus) && ("Rusak".equals(statusBuku) || "Hilang".equals(statusBuku))) {
                        String updateQuantitySql = "UPDATE buku SET quantity = quantity - 1 WHERE no_buku = ?";
                        PreparedStatement updateQuantityPstmt = con.prepareStatement(updateQuantitySql);
                        updateQuantityPstmt.setString(1, nobuku);
                        updateQuantityPstmt.executeUpdate();
                    } else if ("Baik".equals(statusBuku) || "Halaman Sobek".equals(statusBuku)) {
                        String updateQuantitySql = "UPDATE buku SET quantity = quantity + 1 WHERE no_buku = ?";
                        PreparedStatement updateQuantityPstmt = con.prepareStatement(updateQuantitySql);
                        updateQuantityPstmt.setString(1, nobuku);
                        updateQuantityPstmt.executeUpdate();
                    }

                    con.commit(); // Commit transaksi
                    JOptionPane.showMessageDialog(this, "Data pengembalian berhasil diperbarui.");
                    loadPengembalianToTable();

                    // Kosongkan field setelah data diperbarui
                    txtnimPeminjam.setText("");
                    txtJudulBuku.setText("");
                    jTextField3.setText("");
                    txtnobuku.setText("");
                    cmbStatus.setSelectedIndex(0);
                } else {
                    con.rollback(); // Rollback transaksi jika gagal
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui data pengembalian.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            try {
                if (con != null) {
                    con.rollback(); // Rollback transaksi jika ada error
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saat rollback: " + e.getMessage());
            }
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true); // Kembali ke mode auto-commit
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saat mengatur auto-commit: " + e.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin diperbarui dari tabel.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    int selectedRow = tabel.getSelectedRow();
        if (selectedRow != -1) {
            String nim = tabel.getValueAt(selectedRow, 0).toString();
            String nobuku = tabel.getValueAt(selectedRow, 2).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = dbConnection.getConnection();
                    if (con != null) {
                        String sql = "DELETE FROM pengembalian_buku WHERE nim = ? AND no_buku = ?";
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, nim);
                        pstmt.setString(2, nobuku);

                        int rowsDeleted = pstmt.executeUpdate();
                        if (rowsDeleted > 0) {
                            JOptionPane.showMessageDialog(this, "Data pengembalian berhasil dihapus.");
                            loadPengembalianToTable();
                        } else {
                            JOptionPane.showMessageDialog(this, "Gagal menghapus data pengembalian.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dari tabel.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
    int selectedRow = tabel.getSelectedRow();
    if (selectedRow != -1) {
        // Ambil data dari baris yang dipilih
        String nim = tabel.getValueAt(selectedRow, 0).toString();
        String judulBuku = tabel.getValueAt(selectedRow, 1).toString();
        String nobuku = tabel.getValueAt(selectedRow, 2).toString();
        String tglPengembalian = tabel.getValueAt(selectedRow, 3).toString();
        String statusBuku = tabel.getValueAt(selectedRow, 4).toString();

        // Set data ke field
        txtnimPeminjam.setText(nim);
        txtJudulBuku.setText(judulBuku);
        txtnobuku.setText(nobuku);
        jTextField3.setText(tglPengembalian);
        cmbStatus.setSelectedItem(statusBuku);
    }
    }//GEN-LAST:event_tabelMouseClicked
 
    private void loadPengembalianToTable() {
           DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    model.setRowCount(0); // Mengosongkan tabel sebelum memuat data baru

    try {
        Connection con = dbConnection.getConnection();
        if (con != null) {
            String sql = "SELECT nim, judul_buku, no_buku, tgl_pengembalian, status_buku FROM pengembalian_buku";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nim = rs.getString("nim");
                String judulBuku = rs.getString("judul_buku");
                String nobuku = rs.getString("no_buku");
                String tglPengembalian = rs.getString("tgl_pengembalian");
                String statusBuku = rs.getString("status_buku");

                model.addRow(new Object[]{nim, judulBuku, nobuku, tglPengembalian, statusBuku});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
           }
       }        
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
            java.util.logging.Logger.getLogger(FormPengembalianbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPengembalianbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPengembalianbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPengembalianbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPengembalianbuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtnimPeminjam;
    private javax.swing.JTextField txtnobuku;
    // End of variables declaration//GEN-END:variables
}
