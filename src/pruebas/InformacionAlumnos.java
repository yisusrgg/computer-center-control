/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pruebas;

import Otros.Limpiar_txt;
import Otros.imgTabla;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yisus
 */
public class InformacionAlumnos extends javax.swing.JFrame {

    /**
     * Creates new form InformacionAlumnos
     */
    
    private 
    
    /**
     * Creacion de rutas para guardado de archivos
     */
    Limpiar_txt lt = new Limpiar_txt();
    private String ruta_txt = "mi.txt"; 
    private String ruta_txt2 = "matriculas.txt";
    InformacionALumnosBackEnd1 p;
    InformacionAlumnosBackEnd2 rp;
    
    int clic_tabla;
            
    public InformacionAlumnos() {
        
        
        initComponents();
        btnRegresar.setBackground(new java.awt.Color(0,0,0,0));
        btnGuardar.setBackground(new java.awt.Color(0,0,0,0));
        btnModificar.setBackground(new java.awt.Color(0,0,0,0));
        btnEliminar.setBackground(new java.awt.Color(0,0,0,0));
        txtName.setBackground(new java.awt.Color(0,0,0,0));
        txtLastname.setBackground(new java.awt.Color(0,0,0,0));
        txtMatricula.setBackground(new java.awt.Color(0,0,0,0));
        txtTelefono.setBackground(new java.awt.Color(0,0,0,0));
        rp = new InformacionAlumnosBackEnd2();
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        tablaMouseClicked(evt);
        }
        });
        
        try{
            cargar_txt();
            listarRegistro();
        }
        catch(Exception ex){
            mensaje("No existe el archivo txt");
        }
    }
    
    /**
     * Este método carga datos desde un archivo de texto y los agrega como registros. 
     */
    public void cargar_txt(){
        File ruta = new File(ruta_txt);
        try{
            
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);
            
            
            String linea = null;
            while((linea = bu.readLine())!=null){
                StringTokenizer st = new StringTokenizer(linea, ",");
                p = new InformacionALumnosBackEnd1();
                
                p.setMatricula(st.nextToken());
                p.setName(st.nextToken());
                p.setLastname(st.nextToken());
                p.setTelefono(st.nextToken());
                rp.agregarRegistro(p);
            }
            bu.close();
        }
        catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Este metodo guarda los datos registrados en el archivo mi.txt, y las matriculas las guarda el archivo matriculas.txt 
     */
    public void grabar_txt(){
        FileWriter fw;
        PrintWriter pw;
        try{
            fw = new FileWriter(ruta_txt);
           
            pw = new PrintWriter(fw);
            
            for(int i = 0; i < rp.cantidadAlumnos(); i++){
                p = rp.obtenerAlumno(i);
                pw.println(String.valueOf(p.getMatricula()+", "+p.getName()+", "+p.getLastname() + ", "+ p.getTelefono()));
            }
             pw.close();
            
        }
        catch(Exception ex){
            mensaje("Error al grabar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
        try {
            FileWriter fwMatriculas = new FileWriter(ruta_txt2, true);
            PrintWriter pwMatriculas = new PrintWriter(fwMatriculas);
            pwMatriculas.println(p.getMatricula());
            pwMatriculas.close();
        } 
        catch (Exception ex) {
            mensaje("Error al grabar archivo de matrículas: " + ex.getMessage());
            System.out.println(ex.getMessage());
}
        
    }
    
    /**
     * este método recopila los datos ingresados en campos de texto, valida los campos y agrega un nuevo registro en el archivo mi.txt si los datos son válidos. Luego, guarda los registros en un archivo de texto y actualiza la lista de registros.
     * @param ruta 
     */
    public void ingresarRegistro(File ruta){
        String matricula = txtMatricula.getText().trim();
        String nombre = txtName.getText().trim().replace(" ", "_");
        String apellidos = txtLastname.getText().trim().replace(" ", "_");
        String telefono = txtTelefono.getText().trim().replace(" ", "_");

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar apellidos", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (matricula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar matricula", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar numero de telefono", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            p = new InformacionALumnosBackEnd1(matricula, nombre, apellidos, telefono);
            if (rp.buscaMatricula(p.getMatricula()) != -1) {
                mensaje("Este codigo ya existe");
            } 
            else {
                rp.agregarRegistro(p);
                grabar_txt();
                listarRegistro();
                lt.limpiar_texto(panel);
            }
        }
    }
    
    /**
     * este método recopila los datos ingresados en campos de texto, valida los campos y modifica el archivo mi.txt si los datos son válidos. Luego, guarda los registros modificados en un archivo de texto y actualiza la lista de registros.
     * @param ruta 
     */
    public void modificarRegistro(File ruta){
        String matricula = txtMatricula.getText().trim();
        String nombre = txtName.getText().trim().replace(" ", "_");
        String apellidos = txtLastname.getText().trim().replace(" ", "_");
        String telefono = txtTelefono.getText().trim().replace(" ", "_");

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar apellidos", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (matricula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar matricula", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar numero de telefono", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            int matriculaIndex = rp.buscaMatricula(matricula);
            p = new InformacionALumnosBackEnd1(matricula, nombre, apellidos, telefono);

            if (matriculaIndex == -1) {
                rp.agregarRegistro(p);
            } else {
                rp.modificarAlumno(matriculaIndex, p);
            }

            grabar_txt();
            listarRegistro();
            lt.limpiar_texto(panel);
        }
    }
    
    /**
     * este método verifica si se ha ingresado una matrícula válida, busca el registro correspondiente a esa matrícula y permite al usuario confirmar la eliminación del alumno. Si se confirma la eliminación, se realizan las acciones necesarias para eliminar el registro del archivo mi.txt y se actualiza el archivo de texto correspondiente.
     */
    public void eliminarRegistro() {
        try {
            if (leerMatricula() == null) {
                JOptionPane.showMessageDialog(null, "Ingresar matricula", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                int codigo = rp.buscaMatricula(leerMatricula());
                if (codigo == -1) {
                    JOptionPane.showMessageDialog(null, "Ingresar matricula", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                    int s = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a este alumno?", "Si/No", 0);
                    if (s == 0) {
                        rp.eliminarAlumno(codigo);
                        grabar_txt();
                        eliminarMatricula(leerMatricula());
                        listarRegistro();
                        lt.limpiar_texto(panel);
                    }
                }
            }
        } 
        catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    /**
     * Este método se encarga de eliminar una línea específica que contiene una matrícula del archivo de matrículas.txt.
     * @param matricula 
     */
    public void eliminarMatricula(String matricula) {
        try 
        {
            File archivoMatriculas = new File(ruta_txt2);
            File archivoTemp = new File("temp.txt");

            BufferedReader brMatriculas = new BufferedReader(new FileReader(archivoMatriculas));
            PrintWriter pwTemp = new PrintWriter(new FileWriter(archivoTemp));

            String linea;
            while ((linea = brMatriculas.readLine()) != null) {
                if (!linea.equals(matricula)) {
                    pwTemp.println(linea);
                }
            }

            brMatriculas.close();
            pwTemp.close();

            archivoMatriculas.delete();
            archivoTemp.renameTo(archivoMatriculas);
        } 
        catch (Exception ex) {
            mensaje("Error al eliminar matrícula del archivo de matrículas: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Este método se encarga de listar los registros de alumnos en una tabla visual en el programa.
     */
    public void listarRegistro(){
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Matricula");
        dt.addColumn("Nombre");
        dt.addColumn("Apellidos");
        dt.addColumn("Numero de telefono");
        
        
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        
        Object fila[] = new Object[dt.getColumnCount()];
        for(int i = 0; i < rp.cantidadAlumnos(); i++){
            p = rp.obtenerAlumno(i);
            fila[0] = p.getMatricula();
            fila[1] = p.getName();
            fila[2] = p.getLastname();
            fila[3] = p.getTelefono();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
    }
    
    public String leerMatricula() {
        try {
            String codigo = txtMatricula.getText().trim();
            return codigo;
        } 
        catch (Exception ex) {
            return null;
        }
    }
    

    /**
     * este método captura la selección de una fila en la tabla y obtiene los valores de las celdas de la fila seleccionada. Luego, asigna los valores a los campos de texto correspondientes para que puedan ser visualizados y editados en la interfaz gráfica.
     * @param evt 
     */
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
    int filaSeleccionada = tabla.getSelectedRow();

    if (filaSeleccionada >= 0) {
        String matricula = tabla.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tabla.getValueAt(filaSeleccionada, 1).toString();
        String apellidos = tabla.getValueAt(filaSeleccionada, 2).toString();
        String telefono = tabla.getValueAt(filaSeleccionada, 3).toString();
        
        txtMatricula.setText(matricula);
        txtName.setText(nombre);
        txtLastname.setText(apellidos);
        txtTelefono.setText(telefono);
        }
    }     
    
    /**
     * Este método funciona para arrojar un mensaje dependiendo de la circunstancia.
     * @param texto tipo String 
     */
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMatricula.setBackground(new java.awt.Color(255, 255, 255));
        txtMatricula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMatricula.setBorder(null);
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        panel.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 172, 220, 30));
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 100, 37, -1));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setBorder(null);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        panel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 530, 30));

        txtLastname.setBackground(new java.awt.Color(255, 255, 255));
        txtLastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLastname.setBorder(null);
        panel.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 530, 40));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombres", "Apellidos", "Numero de telefono"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 694, 275));

        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 150, 40));

        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panel.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 140, 40));

        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 140, 40));

        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panel.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 10, 50, 50));

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefono.setBorder(null);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        panel.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 190, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Apellidos (1).gif"))); // NOI18N
        panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 800));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para agregar evento al boton Modifcar que permite al usuario modificar los datos de una tabla grafica.
     * @param evt 
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        File ruta = new File(txtName.getText());
        this.modificarRegistro(ruta);
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Método para agregar un evento al boton Guardar que permite guardar los datos ingresados por el usuario.
     * @param evt 
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        File ruta = new File(txtName.getText());
        this.ingresarRegistro(ruta);
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMatriculaActionPerformed

    /**
     * Método para agregar un evento al boton Eliminar que permite eliminar los datos guardados por el usuario que se encuentran dentro de una tabla grafica y de una archivo txt.
     * @param evt 
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.eliminarRegistro();
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Metodo para agregar un evento al boton Regresar que permite hacer visible el menu principal.
     * @param evt 
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
