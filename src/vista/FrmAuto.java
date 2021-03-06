/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.AutoDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.TipoOrdenacion;
import javax.swing.JOptionPane;
import vista.modelo.ModeloTablaAuto;

/**
 *
 * @author jy
 */
public class FrmAuto extends javax.swing.JDialog {

    private ModeloTablaAuto mo = new ModeloTablaAuto();
    private AutoDao autoDao = new AutoDao();

    /**
     * Creates new form FrmEstudiante
     */
    public FrmAuto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
    }

    private void limpiar() {
        autoDao.setAuto(null);

    }

    private void cargarTabla() {
        mo.setLista(autoDao.listar());
        jTable1.setModel(mo);
        jTable1.updateUI();
    }

    private void guardar() {

        String[] marcas = {"HONDA", "AUDI", "CHEVROLET", "TOYOTA", "NISSAN", "MERCEDES", "ASTON MARTIN"
            + "ALFA ROMEO", "BMW", "BYD", "DACIA0", "FERRARI", "FIAT", "FORD", "HYUNDAI", "JEEP", "JAGUAR", "KIA",
            "LADA", "LAMBORGHINI", "LEXUS", "MASERATI", "MORGAN", "OPEL", "PROSHE", "SEAT", "SMART",
            "SUSUKI", "TESLA", "VOLKSWAGEN", "VOLVO"};

        String[] colores = {"BLANCO", "NEGRO", "AZUL", "AMARILLO", "NARANJA", "GRIS", "VERDE", "ROJO", "CAFE", "ROSADO", "CONCHE VINO", "FUCCIA"};
        try {
            for (int i = 0; i < 200; i++) {
                autoDao.getAuto().setModelo(marcas[(int) (Math.floor(Math.random() * ((marcas.length - 1) - 0 + 1) + 0))]);
                autoDao.getAuto().setColor(colores[(int) (Math.floor(Math.random() * ((colores.length - 1) - 0 + 1) + 0))]);
                autoDao.getAuto().setPlaca(generarPlaca());
                autoDao.guardar();
                this.limpiar();
            }

            JOptionPane.showMessageDialog(null, "Se ha guardado");
            cargarTabla();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static String generarPlaca() {

        char placa[] = new char[9];
        placa[0] = generarConsonante();
        placa[1] = generarConsonante();
        placa[2] = generarVocal();
        placa[3] = '-';
        placa[4] = generarNumero();
        placa[5] = generarNumero();
        placa[6] = generarNumero();
        return String.valueOf(placa);
    }

    public static char generarConsonante() {
        return generarRandomChar("BCDFGHJKLMNPQRSTVWXYZ");
    }

    public static char generarVocal() {
        return generarRandomChar("AEIOU");
    }

    public static char generarNumero() {
        return generarRandomChar("0123456789");
    }

    private static char generarRandomChar(String str) {
        char caracteres[] = str.toCharArray();
        int index = (int) (Math.random() * caracteres.length);
        return caracteres[index];
    }


    private void ordenar() {
        ListaEnlazada aux;
        TipoOrdenacion select = null;

        int select1 = cbmetodo.getSelectedIndex();
        String atributo = cbatributo.getSelectedItem().toString();
        if (cbdireccion.getSelectedIndex() == 0){
            select = TipoOrdenacion.ASCENDENTE;
        }else{
            select = TipoOrdenacion.DESCENDENTE;
        }
        
        if (select1 == 0) {
            aux = autoDao.listar().QuisortClase(atributo, 0, autoDao.listar().size() - 1, select);
        } else {
            aux = autoDao.listar().ShellClase(select , atributo);
 
        }
        mo.setLista(aux);
        jTable1.setModel(mo);
        jTable1.updateUI();
    }

    private void buscar() {

        ListaEnlazada aux;
        if (txbuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo necesario");
        } else {
            aux = (ListaEnlazada) mo.getLista().BusquedaBinariaClase(txbuscar.getText(), "placa");
       if (aux == null) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el elemento o ordene primero la lista para buscar el elemento");
       } else {
                mo.setLista(aux);
                jTable1.setModel(mo);
                jTable1.updateUI();
                txbuscar.setText("");
            }
        }
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbdireccion = new javax.swing.JComboBox<>();
        cbmetodo = new javax.swing.JComboBox<>();
        cbatributo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        txbuscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 20, 100, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 170, 630, 430);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        cbdireccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        jPanel2.add(cbdireccion);
        cbdireccion.setBounds(380, 20, 170, 30);

        cbmetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "quickshort", "Shell" }));
        jPanel2.add(cbmetodo);
        cbmetodo.setBounds(10, 20, 180, 30);

        cbatributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "modelo", "color", "placa" }));
        jPanel2.add(cbatributo);
        cbatributo.setBounds(200, 20, 170, 30);

        jButton2.setText("Ordenar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(190, 60, 180, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(140, 10, 560, 90);
        jPanel1.add(txbuscar);
        txbuscar.setBounds(270, 130, 220, 30);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(500, 130, 75, 23);

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(10, 60, 100, 23);

        jLabel1.setText("Busqueda por placa");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 140, 127, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 750, 630);

        setSize(new java.awt.Dimension(791, 676));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ordenar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cargarTabla();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAuto dialog = new FrmAuto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbatributo;
    private javax.swing.JComboBox<String> cbdireccion;
    private javax.swing.JComboBox<String> cbmetodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txbuscar;
    // End of variables declaration//GEN-END:variables

}
