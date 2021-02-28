/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author pseud
 */
public class IHMfrogger extends javax.swing.JFrame {

    private File fichierMapfrog = new File("src/imagesfrogger/backgroundfrog.png");
    private BufferedImage imageMapfrog;
    private File fichierPersonnagefrog = new File("src/imagesfrogger/trueiconfrogger40.png");
    private BufferedImage imagePersonnagefrog;
    private File fichierSprite = new File("src/imagesfrogger/test1.png");
    private BufferedImage imageSprite;
    private BufferedImage grenouille;
    //private BufferedImage voiture;
    private BufferedImage[] tabvoiture = new BufferedImage[3];

    private int xfrog = 300;
    private int yfrog = 650;

    private int xvoitures;
    int[] tabcoordonnees600 = new int[3];
    int[] tabcoordonnees550 = new int[3];
    int[] tabcoordonnees500 = new int[3];
    int[] tabcoordonnees450 = new int[3];
    int[] tabcoordonnees400 = new int[3];

    public IHMfrogger() {
        initComponents();
        setBounds(0, 0, 610, 750);//mesure pour que la map rentre bien //jpannel plus grande que la taille de l'image de base
        jPanel1.setFocusable(true);

        try {
            imageMapfrog = ImageIO.read(fichierMapfrog); //chargement
            imagePersonnagefrog = ImageIO.read(fichierPersonnagefrog);
            imageSprite = ImageIO.read(fichierSprite);
            grenouille = imageSprite.getSubimage(0, 0, 55, 65);
            //voiture = imageSprite.getSubimage(0, 320, 93, 455);
            for (int i = 0; i < 3; i++) {
                int x = i * 98;

                tabvoiture[i] = imageSprite.getSubimage(x, 320, 98, 49);
            }

        } catch (IOException ex) {
            System.out.println("fichier introuvable");
        }

        //Génération des coordonnées aléatoire pour les voitures sur la ligne 1
        xvoitures = genererInt(0, 500);
        tabcoordonnees600[0] = xvoitures;

        xvoitures = genererInt(0, 500);
        while (xvoitures > tabcoordonnees600[0] - 98 && xvoitures < tabcoordonnees600[0] + 98) {
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees600[1] = xvoitures;

        xvoitures = genererInt(0, 500);
        while ((xvoitures > tabcoordonnees600[0] - 98) && (xvoitures < tabcoordonnees600[0] + 98) || (xvoitures > tabcoordonnees600[1] - 98) && (xvoitures < tabcoordonnees600[1] + 98)) {
            //j'ai géléré parce que j'avais mis que des "&&" et je l'ai remplacé par un "||" et ça marche maintenant mais j'ai encore du mal à comprendre pourquoi le "&&" ça marche pas
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees600[2] = xvoitures;

        //Génération des coordonnées aléatoire pour les voitures sur la ligne 2
        xvoitures = genererInt(0, 500);
        tabcoordonnees550[0] = xvoitures;

        xvoitures = genererInt(0, 500);
        while (xvoitures > tabcoordonnees550[0] - 98 && xvoitures < tabcoordonnees550[0] + 98) {
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees550[1] = xvoitures;

        xvoitures = genererInt(0, 500);
        while ((xvoitures > tabcoordonnees550[0] - 98) && (xvoitures < tabcoordonnees550[0] + 98) || (xvoitures > tabcoordonnees550[1] - 98) && (xvoitures < tabcoordonnees550[1] + 98)) {
            //j'ai géléré parce que j'avais mis que des "&&" et je l'ai remplacé par un "||" et ça marche maintenant mais j'ai encore du mal à comprendre pourquoi le "&&" ça marche pas
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees550[2] = xvoitures;

        //Génération des coordonnées aléatoire pour les voitures sur la ligne 3
        xvoitures = genererInt(0, 500);
        tabcoordonnees500[0] = xvoitures;

        xvoitures = genererInt(0, 500);
        while (xvoitures > tabcoordonnees500[0] - 98 && xvoitures < tabcoordonnees500[0] + 98) {
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees500[1] = xvoitures;

        xvoitures = genererInt(0, 500);
        while ((xvoitures > tabcoordonnees500[0] - 98) && (xvoitures < tabcoordonnees500[0] + 98) || (xvoitures > tabcoordonnees500[1] - 98) && (xvoitures < tabcoordonnees500[1] + 98)) {
            //j'ai géléré parce que j'avais mis que des "&&" et je l'ai remplacé par un "||" et ça marche maintenant mais j'ai encore du mal à comprendre pourquoi le "&&" ça marche pas
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees500[2] = xvoitures;

        //Génération des coordonnées aléatoire pour les voitures sur la ligne 4
        xvoitures = genererInt(0, 500);
        tabcoordonnees450[0] = xvoitures;

        xvoitures = genererInt(0, 500);
        while (xvoitures > tabcoordonnees450[0] - 98 && xvoitures < tabcoordonnees450[0] + 98) {
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees450[1] = xvoitures;

        xvoitures = genererInt(0, 500);
        while ((xvoitures > tabcoordonnees450[0] - 98) && (xvoitures < tabcoordonnees450[0] + 98) || (xvoitures > tabcoordonnees450[1] - 98) && (xvoitures < tabcoordonnees450[1] + 98)) {
            //j'ai géléré parce que j'avais mis que des "&&" et je l'ai remplacé par un "||" et ça marche maintenant mais j'ai encore du mal à comprendre pourquoi le "&&" ça marche pas
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees450[2] = xvoitures;

        //Génération des coordonnées aléatoire pour les voitures sur la ligne 5
        xvoitures = genererInt(0, 500);
        tabcoordonnees400[0] = xvoitures;

        xvoitures = genererInt(0, 500);
        while (xvoitures > tabcoordonnees400[0] - 98 && xvoitures < tabcoordonnees400[0] + 98) {
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees400[1] = xvoitures;

        xvoitures = genererInt(0, 500);
        while ((xvoitures > tabcoordonnees400[0] - 98) && (xvoitures < tabcoordonnees400[0] + 98) || (xvoitures > tabcoordonnees400[1] - 98) && (xvoitures < tabcoordonnees400[1] + 98)) {
            //j'ai géléré parce que j'avais mis que des "&&" et je l'ai remplacé par un "||" et ça marche maintenant mais j'ai encore du mal à comprendre pourquoi le "&&" ça marche pas
            xvoitures = genererInt(0, 500);
        }
        tabcoordonnees400[2] = xvoitures;

        temps.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g)
            {g.drawImage(imageMapfrog,0,0,null);
                //g.drawImage(grenouille,305,635,null);
                //g.drawImage(voiture,400,550,null);
                g.drawImage(imagePersonnagefrog,xfrog,yfrog,null);

                for (int i = 0; i < 3; i++){

                    g.drawImage(tabvoiture[i],tabcoordonnees600[i],600,null);
                    g.drawImage(tabvoiture[i],tabcoordonnees550[i],550,null);
                    g.drawImage(tabvoiture[i],tabcoordonnees500[i],500,null);
                    g.drawImage(tabvoiture[i],tabcoordonnees450[i],450,null);
                    g.drawImage(tabvoiture[i],tabcoordonnees400[i],400,null);
                    //le but à la place de l'abssices c'est d'avoir un tableau avec les
                    //coordonnées des 3 voitures.
                }
            }
        }
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (yfrog > 120) {
            if (evt.getKeyChar() == 'd') {
                xfrog += 10;

            }
            if (evt.getKeyChar() == 'z') {
                yfrog -= 50;

            }
            if (evt.getKeyChar() == 'q') {
                xfrog -= 10;

            }
            if (evt.getKeyChar() == 's') {
                yfrog += 50;

            }
        } else {
            if (evt.getKeyChar() == 'd') {
                xfrog += 20;

            }
            if (evt.getKeyChar() == 'z') {
                yfrog -= 80;

            }
            if (evt.getKeyChar() == 'q') {
                xfrog -= 20;

            }
            if (evt.getKeyChar() == 's') {
                yfrog += 50;

            }
        }
        victoire();
        
        jPanel1.repaint();
        //c'est notre code principale 

    }//GEN-LAST:event_jPanel1KeyPressed

    public void victoire() {
        if (yfrog < 80 && xfrog < 58) {
            JOptionPane.showMessageDialog(this, "vous avez gagné", "félicitation", JOptionPane.INFORMATION_MESSAGE);

        }
        if (yfrog < 80 && xfrog > 124 && xfrog < 184) {
            JOptionPane.showMessageDialog(this, "vous avez gagné", "félicitation", JOptionPane.INFORMATION_MESSAGE);

        }
        if (yfrog < 80 && xfrog > 250 && xfrog < 311) {
            JOptionPane.showMessageDialog(this, "vous avez gagné", "félicitation", JOptionPane.INFORMATION_MESSAGE);

        }
        if (yfrog < 80 && xfrog > 378 && xfrog < 440) {
            JOptionPane.showMessageDialog(this, "vous avez gagné", "félicitation", JOptionPane.INFORMATION_MESSAGE);

        }
        if (yfrog < 80 && xfrog > 503) {
            JOptionPane.showMessageDialog(this, "vous avez gagné", "félicitation", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }

    public void defaite() {
        for (int i = 0; i < 3; i++) {
            if (xfrog > tabcoordonnees600[i] - 32 && xfrog < tabcoordonnees600[i] + 98 && yfrog > 550 && yfrog < 650) {
                JOptionPane.showMessageDialog(this, "vous avez perdu", "retente ta chance", JOptionPane.INFORMATION_MESSAGE);
                xfrog = 300; //essayer de faire pour que ça revienne au début
                yfrog = 650;

            }
            if (xfrog > tabcoordonnees550[i] - 32 && xfrog < tabcoordonnees550[i] + 98 && yfrog > 500 && yfrog < 600) {
                JOptionPane.showMessageDialog(this, "vous avez perdu", "retente ta chance", JOptionPane.INFORMATION_MESSAGE);
                xfrog = 300;
                yfrog = 650;

            }
            if (xfrog > tabcoordonnees500[i] - 32 && xfrog < tabcoordonnees500[i] + 98 && yfrog > 450 && yfrog < 550) {
                JOptionPane.showMessageDialog(this, "vous avez perdu", "retente ta chance", JOptionPane.INFORMATION_MESSAGE);
                xfrog = 300;
                yfrog = 650;

            }
            if (xfrog > tabcoordonnees450[i] - 32 && xfrog < tabcoordonnees450[i] + 98 && yfrog > 400 && yfrog < 500) {
                JOptionPane.showMessageDialog(this, "vous avez perdu", "retente ta chance", JOptionPane.INFORMATION_MESSAGE);
                xfrog = 300;
                yfrog = 650;

            }
            if (xfrog > tabcoordonnees400[i] - 32 && xfrog < tabcoordonnees400[i] + 98 && yfrog > 350 && yfrog < 450) {
                JOptionPane.showMessageDialog(this, "vous avez perdu", "retente ta chance", JOptionPane.INFORMATION_MESSAGE);
                xfrog = 300;
                yfrog = 650;

            }

        }

    }

    Timer temps = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 3; i++) {
                tabcoordonnees600[i] += 1;
                tabcoordonnees550[i] -= 2;
                tabcoordonnees500[i] += 4;
                tabcoordonnees450[i] -= 8;
                tabcoordonnees400[i] += 16;
                
                reappartionvoiture();
                defaite();
            }

            jPanel1.repaint();

        }

    });

    private void reappartionvoiture() {
        for (int i = 0; i < 3; i++) {
            
        

        if (tabcoordonnees600[i] > (580)) {
            tabcoordonnees600[i] = -98;
            
        }
        if (tabcoordonnees550[i] < (-98)) {
            tabcoordonnees550[i] = 580;
        }
        if (tabcoordonnees500[i] > (580)) {
            tabcoordonnees500[i] = -98;
        }
        if (tabcoordonnees450[i] < (-98)) {
            tabcoordonnees450[i] = 580;
        }
        if (tabcoordonnees400[i] > (580)) {
            tabcoordonnees400[i] = -98;
        }
  
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
            java.util.logging.Logger.getLogger(IHMfrogger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHMfrogger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHMfrogger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHMfrogger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHMfrogger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
