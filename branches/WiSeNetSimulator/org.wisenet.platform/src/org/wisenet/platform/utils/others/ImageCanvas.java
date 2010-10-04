/*
 *  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */

/*
 * ImageCanvas.java
 *
 * Created on Oct 3, 2010, 5:19:25 PM
 */
package org.wisenet.platform.utils.others;

import java.awt.Image;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import org.wisenet.platform.utils.ImageUtils;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class ImageCanvas extends javax.swing.JPanel {

    protected BufferedImage image;
    private boolean imageDisplayed = false;

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void paint(Graphics grphcs) {
        if (image != null) {
            grphcs.drawImage(image, 0, 0, image.getWidth(this), image.getHeight(this), this);
        }
    }

    /** Creates new form ImageCanvas */
    public ImageCanvas() {
        imageDisplayed = false;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void displayImage(Image image) {
        if (image == null) {
            return;
        }

        this.image = ImageUtils.toBufferedImage(image);
        refresh();
        this.imageDisplayed = true;
    }

    public void refresh() {
        if (image != null) {
            int _w = image.getWidth(this);
            int _h = image.getHeight(this);
            this.setSize(new Dimension(_w, _h));
            this.setPreferredSize(this.getSize());
            this.setMaximumSize(this.getSize());
            this.setMinimumSize(this.getSize());
            if (getParent() instanceof JScrollPane) {
                JScrollPane p = (JScrollPane) getParent();
                p.setViewportView(this);
                
            }


        }
        this.repaint();
        this.updateUI();
    }

    public boolean isImageDisplayed() {
        return imageDisplayed;
    }

}
