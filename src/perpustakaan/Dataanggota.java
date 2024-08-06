package perpustakaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dataanggota extends javax.swing.JFrame {

    
private final DBConnection dbConnection; // Menyimpan instance DBConnection

    public Dataanggota() {
        initComponents();
    setcombo();
    this.setTitle("Input Data Mahasiswa");

    // Inisialisasi objek DBConnection
    dbConnection = new DBConnection();
    tabel(); // Panggil tabel setelah dbConnection diinisialisasi
    }
    
 private void setcombo() {
        cmbprodi.setEnabled(true);
        cmbprodi.addItem("Sistem Informasi");
        cmbprodi.addItem("Teknik Informatika");
        cmbprodi.addItem("Desain Komunikasi Visual");
        cmbprodi.addItem("Manajemen");
        cmbprodi.removeItem("Item 1");
        cmbprodi.removeItem("Item 2");
        cmbprodi.removeItem("Item 3");
        cmbprodi.removeItem("Item 4");
        
 }
 
  private void tabel() {
DefaultTableModel tb = new DefaultTableModel();
    tb.addColumn("NIM");
    tb.addColumn("Nama");
    tb.addColumn("Prodi");
    tb.addColumn("Tanggal");
    tabel.setModel(tb); // Mengatur model tabel dengan model yang baru

    try {
        Connection con = dbConnection.getConnection();
        if (con != null) {
            String sql = "SELECT * FROM mahasiswa";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getString("nim"),
                    res.getString("nama"),
                    res.getString("prodi"),
                    res.getString("tanggal")
                });
            }
        } else {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }
  
 private void loadData() {
    try {
        Connection con = dbConnection.getConnection();
        String sql = "SELECT nim, nama, prodi, tanggal FROM mahasiswa";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        // Menghapus semua baris yang ada di tabel sebelum memuat data baru
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);

        // Memuat data dari ResultSet ke dalam tabel
        while (rs.next()) {
            String nim = rs.getString("nim");
            String nama = rs.getString("nama");
            String prodi = rs.getString("prodi");
            String tanggal = rs.getString("tanggal");

            model.addRow(new Object[]{nim, nama, prodi, tanggal});
        }

        con.close(); // Tutup koneksi setelah selesai
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
 }
    
    private void searchByNim(String nim) {
        DefaultTableModel tb = (DefaultTableModel) tabel.getModel();
        tb.setRowCount(0); // Menghapus semua baris yang ada

        try {
            Connection con = dbConnection.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM mahasiswa WHERE nim LIKE ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, "%" + nim + "%");
                ResultSet res = pstmt.executeQuery();

                while (res.next()) {
                    tb.addRow(new Object[]{
                        res.getString("nim"),
                        res.getString("nama"),
                        res.getString("prodi"),
                        res.getString("tanggal")
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "Koneksi ke database gagal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtnim = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cmbprodi = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        txtSearchNim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KELOLA DATA PENGUNJUNG ");

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtnim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnimMouseClicked(evt);
            }
        });
        txtnim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnimActionPerformed(evt);
            }
        });
        txtnim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnimKeyReleased(evt);
            }
        });

        txtnama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnamaMouseClicked(evt);
            }
        });
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txttanggal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttanggalMouseClicked(evt);
            }
        });
        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

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

        cmbprodi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbprodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbprodiActionPerformed(evt);
            }
        });

        btnSearch.setText("Search NIM");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NIM");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tanggal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtnim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addComponent(txttanggal, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(txtSearchNim, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearchNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(jButton1)
                    .addComponent(cmbprodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnimMouseClicked
        txtnim.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnimMouseClicked

    private void txtnimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnimActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtnimActionPerformed

    private void txtnimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnimKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnimKeyReleased

    private void txtnamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnamaMouseClicked
        txtnama.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaMouseClicked

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txttanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttanggalMouseClicked
        txttanggal.setText(null);
    }//GEN-LAST:event_txttanggalMouseClicked

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
    
    }//GEN-LAST:event_txttanggalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String nim = txtnim.getText();
    String nama = txtnama.getText();
    String tanggal = txttanggal.getText();

    if (nim.equals("") || nama.equals("") || tanggal.equals("")) {
        JOptionPane.showMessageDialog(null, "Isi Semua Form Yang Tersedia ");
    } else if (cmbprodi.getSelectedItem().equals("")) {
        JOptionPane.showMessageDialog(null, "Pilih Prodi ");
    } else {
        try {
            Connection con = dbConnection.getConnection();

            if (con != null) {
                String sql = "INSERT INTO mahasiswa(nim, nama, prodi, tanggal) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, txtnim.getText());
                pstmt.setString(2, txtnama.getText());
                pstmt.setString(3, (String) cmbprodi.getSelectedItem());
                pstmt.setString(4, tanggal);

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");

                txtnim.setText("");
                txtnama.setText("");
                cmbprodi.setSelectedIndex(0);
                txttanggal.setText("");

                // Memuat ulang data ke dalam tabel setelah data berhasil disimpan
                loadData();
            } else {
                JOptionPane.showMessageDialog(null, "Koneksi ke database gagal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
int row = tabel.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan diupdate");
    } else {
        String nim = txtnim.getText();
        String nama = txtnama.getText();
        String tanggal = txttanggal.getText();

        if (nim.equals("") || nama.equals("") || tanggal.equals("")) {
            JOptionPane.showMessageDialog(null, "Isi Semua Form Yang Tersedia ");
        } else if (cmbprodi.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Pilih Prodi ");
        } else {
            try {
                Connection con = dbConnection.getConnection();

                if (con != null) {
                    String sql = "UPDATE mahasiswa SET nama=?, prodi=?, tanggal=? WHERE nim=?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, txtnama.getText());
                    pstmt.setString(2, (String) cmbprodi.getSelectedItem());
                    pstmt.setString(3, tanggal);
                    pstmt.setString(4, txtnim.getText());

                    int result = pstmt.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Update Data Berhasil");
                        txtnim.setText("");
                        txtnama.setText("");
                        cmbprodi.setSelectedIndex(0);
                        txttanggal.setText("");
                        loadData(); // Memuat ulang data setelah update
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal melakukan update");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Koneksi ke database gagal");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
  int row = tabel.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
    } else {
        // Mengambil NIM dari baris yang dipilih
        String nim = tabel.getValueAt(row, 0).toString(); // Ambil nilai dari kolom pertama (NIM)

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data dengan NIM " + nim + "?",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection con = dbConnection.getConnection();

                if (con != null) {
                    String sql = "DELETE FROM mahasiswa WHERE nim=?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, nim);

                    int result = pstmt.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                        loadData(); // Memuat ulang data setelah delete
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal menghapus data");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Koneksi ke database gagal");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }     
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbprodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbprodiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbprodiActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    String nim = txtSearchNim.getText();
    searchByNim(nim);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
     int row = tabel.getSelectedRow();
    if (row != -1) {
        // Mengambil data dari tabel
        String nim = tabel.getValueAt(row, 0).toString();
        String nama = tabel.getValueAt(row, 1).toString();
        String prodi = tabel.getValueAt(row, 2).toString();
        String tanggal = tabel.getValueAt(row, 3).toString();

        // Mengisi field dengan data dari tabel
        txtnim.setText(nim);
        txtnama.setText(nama);
        cmbprodi.setSelectedItem(prodi);
        txttanggal.setText(tanggal);
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
            java.util.logging.Logger.getLogger(Dataanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dataanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dataanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dataanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dataanggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbprodi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtSearchNim;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnim;
    private javax.swing.JTextField txttanggal;
    // End of variables declaration//GEN-END:variables

}


