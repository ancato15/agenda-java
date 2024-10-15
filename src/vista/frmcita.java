package vista;

import controlador.citaController;
import javax.swing.table.DefaultTableModel;
import modelo.cita;
import modelo.contacto;

public class frmcita extends javax.swing.JFrame {
    Object[][] datosContacto;
    int fila = -1;
    
    public frmcita() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmventana = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbusqueda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcontacto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcontacto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txthora = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cboconsultorio = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        btnguardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbousuario = new javax.swing.JComboBox<>();
        btnlimpiar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();

        frmventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frmventana.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                frmventanaWindowOpened(evt);
            }
        });

        jLabel7.setText("Busqueda");

        btnbusqueda.setText("Buscar");

        tbcontacto.setModel(new javax.swing.table.DefaultTableModel(
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
        tbcontacto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tbcontacto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbusqueda)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout frmventanaLayout = new javax.swing.GroupLayout(frmventana.getContentPane());
        frmventana.getContentPane().setLayout(frmventanaLayout);
        frmventanaLayout.setHorizontalGroup(
            frmventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmventanaLayout.setVerticalGroup(
            frmventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Contacto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, 30));
        jPanel1.add(txtcontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 30));

        jLabel2.setText("Fecha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, 30));

        try {
            txtfecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfecha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, 30));

        jLabel3.setText("Hora");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, 30));

        try {
            txthora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txthora.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(txthora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 160, 30));

        jLabel4.setText("Consultorio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        cboconsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione---", "Uno", "Dos", "Tres" }));
        jPanel1.add(cboconsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, 30));

        jLabel5.setText("Descripción(Observaciones)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtdescripcion.setColumns(20);
        txtdescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setRows(5);
        jScrollPane1.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 240, 110));

        btnguardar.setText("Guardar");
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, 40));

        jLabel6.setText("Usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        cbousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione---" }));
        jPanel1.add(cbousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 332, 160, 30));

        btnlimpiar.setText("Limpiar");
        jPanel1.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 110, 40));

        btnbuscar.setText("....");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        frmventana.setVisible(true);
        frmventana.setSize(450, 280);
        frmventana.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void frmventanaWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_frmventanaWindowOpened
        Object[] columna = {"ID", "Cedula", "Nombres", "Apellidos", "Dirección", "Celular"};
        // se utiliza la funcion
        contacto c = new contacto();
        datosContacto = c.getContacto();
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(datosContacto, columna);
        tbcontacto.setModel(datos);
        tbcontacto.setDefaultEditor(Object.class, null);
        
    }//GEN-LAST:event_frmventanaWindowOpened

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cita citas = new cita();
        citaController citacc = new citaController(citas, this);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(frmcita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnbuscar;
    public javax.swing.JButton btnbusqueda;
    public javax.swing.JButton btnguardar;
    public javax.swing.JButton btnlimpiar;
    public javax.swing.JComboBox<String> cboconsultorio;
    public javax.swing.JComboBox<String> cbousuario;
    public javax.swing.JDialog frmventana;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tbcontacto;
    public javax.swing.JTextField txtbuscar;
    public javax.swing.JTextField txtcontacto;
    public javax.swing.JTextArea txtdescripcion;
    public javax.swing.JFormattedTextField txtfecha;
    public javax.swing.JFormattedTextField txthora;
    // End of variables declaration//GEN-END:variables
}
