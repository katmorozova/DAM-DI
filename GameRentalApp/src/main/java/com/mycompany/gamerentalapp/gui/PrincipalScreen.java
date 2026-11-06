/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gamerentalapp.gui;

import com.mycompany.gamerentalapp.data.DataRepository;
import com.mycompany.gamerentalapp.data.SampleData;
import com.mycompany.gamerentalapp.model.Rental;
import com.mycompany.gamerentalapp.model.RentalStatus;
import java.awt.Component;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;

/**
 * Main application window for the video game rental management system
 * Handles the main rental table display, status row color rendering (green/red),
 * total rental counts, and navigation menu actions to open management dialogs
 * 
 * @author Ekaterina Morozova
 */

public class PrincipalScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrincipalScreen.class.getName());

    private DataRepository repository;
    
    /**
     * Creates new form PrincipalScreen
     */
    public PrincipalScreen() {
        //Initialize data repository and load mandatory sample data
        this.repository = new DataRepository();
        SampleData.cargarDatos(repository);
        initComponents();
        initCustomizations();
    }

    private void initCustomizations() {
        // Center the main window on screen
        setLocationRelativeTo(null);
        
        // Load initial rental data into the main table
        refreshRentalTable();
        
        // Register rental screen listener
        jMenuRegisterRent.addActionListener(e -> {
            RegisterRentalScreen dialog = new RegisterRentalScreen(this, true);
            dialog.setVisible(true);
            refreshRentalTable();
        });

        // Return rental screen listener
        jMenuReturnRent.addActionListener(e -> {
            ReturnRentalScreen dialog = new ReturnRentalScreen(this, true);
            dialog.setVisible(true);
            refreshRentalTable();
        });

        // Create user screen listener
        jMenuCrearUser.addActionListener(e -> {
            CreateUserScreen dialog = new CreateUserScreen(this, true);
            dialog.setVisible(true);
            refreshRentalTable();
        });
        
        // Create game screen listener
        jMenuCreateGame.addActionListener(e -> {
            CreateGameScreen dialog = new CreateGameScreen(this, true);
            dialog.setVisible(true);
            refreshRentalTable();
        });  
    }
    
    /**
     * Updates the rental JTable data sorted in descending order by 
     * registration number and applies status row background colors (Green/Red)
     */
    public void refreshRentalTable() {
        javax
                .swing
                .table
                .DefaultTableModel model = (javax.swing.table.DefaultTableModel)
                jTableRental.getModel()
        ;
        model.setRowCount(0); //Clear the table before reloading data

        List<Rental> rentals = repository.getRentals();
        
        //Sort rentals in descending order by registration number (rentalId)
        rentals.sort(java
                        .util
                        .Comparator
                        .comparing(Rental::getRentalId)
                .reversed()
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Rental rental : rentals) {
            String userName = (rental.getUser() != null) 
                    ? rental.getUser().getName() + 
                    " " + rental.getUser().getFirstName() 
                    : ""
            ;
            String gameTitle = (rental.getGame() != null) 
                    ? rental.getGame().getTitle() 
                    : ""
            ;
            String platform = (rental.getPlatform() != null) 
                    ? rental.getPlatform().getDisplayName() 
                    : ""
            ;
            String startDate = (rental.getStartDate() != null) 
                    ? rental.getStartDate().format(formatter) 
                    : ""
            ;
            String endDate = (rental.getExpectedReturn() != null) 
                    ? rental.getExpectedReturn().format(formatter) 
                    : ""
            ;
            String genre = (rental.getGame() != null && rental.getGame().getGenre() != null) 
                    ? rental.getGame().getGenre().getDisplayName() 
                    : ""
            ;

            model.addRow(new Object[]{
                rental.getRentalId(),
                gameTitle,
                userName,
                platform,
                startDate,
                endDate,
                genre
            });
        }

        //Update the total rentals counter label in the UI
        jLabelTextTotalNumRent.setText(String.valueOf(rentals.size()));

        //Apply cell renderer to paint rows based on rental status (Green/Red)
        jTableRental.setDefaultRenderer(
                Object.class, 
                new javax.swing.table.DefaultTableCellRenderer() 
        {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, 
                    Object value, 
                    boolean isSelected, 
                    boolean hasFocus, 
                    int row, 
                    int column
            ) {
                Component component = super.getTableCellRendererComponent(
                        table, 
                        value, 
                        isSelected, 
                        hasFocus, 
                        row, 
                        column
                );
                
                if (row < rentals.size()) {
                    Rental rental = rentals.get(row);
                    if (rental.getRentalStatus() == RentalStatus.RETURNED) {
                        //Light green for returned rentals
                        component.setBackground(new java.awt.Color(200, 230, 201)); 
                        component.setForeground(java.awt.Color.DARK_GRAY);
                    } else if (rental.getRentalStatus() == RentalStatus.OVERDUE) {
                        //Light red for overdue rentals
                        component.setBackground(new java.awt.Color(255, 205, 210)); 
                        component.setForeground(java.awt.Color.DARK_GRAY);
                    } else {
                        //Default colors for active rentals
                        component.setBackground(isSelected 
                                ? table.getSelectionBackground() 
                                : java.awt.Color.WHITE)
                        ;
                        component.setForeground(isSelected 
                                ? table.getSelectionForeground() 
                                : java.awt.Color.BLACK)
                        ;
                    }
                }
                return component;
            }
        });  
        jTableRental.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTableRental = new javax.swing.JTable();
        jLabelTextTotalRent = new javax.swing.JLabel();
        jLabelTextTotalNumRent = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuRent = new javax.swing.JMenu();
        jMenuRegisterRent = new javax.swing.JMenuItem();
        jMenuReturnRent = new javax.swing.JMenuItem();
        jMenuUser = new javax.swing.JMenu();
        jMenuCrearUser = new javax.swing.JMenuItem();
        jMenuDeleteUser = new javax.swing.JMenuItem();
        jMenuGame = new javax.swing.JMenu();
        jMenuCreateGame = new javax.swing.JMenuItem();
        jMenuDeleteGame = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestió del Lloguer de Videojocs");
        setFocusable(false);

        jTableRental.setBackground(new java.awt.Color(242, 242, 242));
        jTableRental.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Núm.registre", "Titol del joc", "Usuari que l'ha llogat", "Plataforma", "Data d'inici", "Data de tornada", "Gènere"
            }
        ));
        jScrollPane.setViewportView(jTableRental);

        jLabelTextTotalRent.setForeground(new java.awt.Color(0, 51, 102));
        jLabelTextTotalRent.setText("Total de lloguers:");

        jLabelTextTotalNumRent.setForeground(new java.awt.Color(0, 51, 102));
        jLabelTextTotalNumRent.setText("X");

        jMenuRent.setText("Lloguer");

        jMenuRegisterRent.setText("Registrar...");
        jMenuRent.add(jMenuRegisterRent);

        jMenuReturnRent.setText("Tornar...");
        jMenuRent.add(jMenuReturnRent);

        jMenuBar.add(jMenuRent);

        jMenuUser.setText("Usuari");

        jMenuCrearUser.setText("Crear...");
        jMenuUser.add(jMenuCrearUser);

        jMenuDeleteUser.setText("Borrar...");
        jMenuUser.add(jMenuDeleteUser);

        jMenuBar.add(jMenuUser);

        jMenuGame.setText("Joc");

        jMenuCreateGame.setText("Crear...");
        jMenuGame.add(jMenuCreateGame);

        jMenuDeleteGame.setText("Borrar...");
        jMenuGame.add(jMenuDeleteGame);

        jMenuBar.add(jMenuGame);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelTextTotalRent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTextTotalNumRent, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTextTotalRent)
                    .addComponent(jLabelTextTotalNumRent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PrincipalScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTextTotalNumRent;
    private javax.swing.JLabel jLabelTextTotalRent;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuCrearUser;
    private javax.swing.JMenuItem jMenuCreateGame;
    private javax.swing.JMenuItem jMenuDeleteGame;
    private javax.swing.JMenuItem jMenuDeleteUser;
    private javax.swing.JMenu jMenuGame;
    private javax.swing.JMenuItem jMenuRegisterRent;
    private javax.swing.JMenu jMenuRent;
    private javax.swing.JMenuItem jMenuReturnRent;
    private javax.swing.JMenu jMenuUser;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableRental;
    // End of variables declaration//GEN-END:variables
}
