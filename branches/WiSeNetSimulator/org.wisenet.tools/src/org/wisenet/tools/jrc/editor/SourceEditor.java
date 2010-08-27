/*
 *  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */

/*
 * SourceEditor.java
 *
 * Created on Aug 13, 2010, 6:53:22 PM
 */
package org.wisenet.tools.jrc.editor;

import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;
import org.wisenet.tools.jrc.RuntimeCompilationException;
import org.wisenet.tools.jrc.RuntimeCompiler;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class SourceEditor extends javax.swing.JDialog {

    private final RuntimeCompiler runtimeCompiler;

    public SourceEditor(RuntimeCompiler runtimeCompiler) {
        super((JFrame) null, true);
        this.runtimeCompiler = runtimeCompiler;
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

        editorSplit = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        editor = new javax.swing.JEditorPane();
        editorToolbar = new javax.swing.JToolBar();
        cmdReload = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdCompile = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        statusPanelText = new javax.swing.JLabel();
        cursorPositionPanel = new javax.swing.JPanel();
        cursorPositionText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        editorSplit.setDividerLocation(200);
        editorSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        editorSplit.setOneTouchExpandable(true);

        outputTextArea.setColumns(20);
        outputTextArea.setEditable(false);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        editorSplit.setRightComponent(jScrollPane1);

        editor.setBackground(new java.awt.Color(254, 254, 254));
        editor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editorCaretUpdate(evt);
            }
        });
        editorSplit.setLeftComponent(editor);

        getContentPane().add(editorSplit, java.awt.BorderLayout.CENTER);

        editorToolbar.setRollover(true);

        cmdReload.setText("Reload");
        cmdReload.setFocusable(false);
        cmdReload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdReload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdReloadActionPerformed(evt);
            }
        });
        editorToolbar.add(cmdReload);

        cmdSave.setText("Save");
        cmdSave.setFocusable(false);
        cmdSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });
        editorToolbar.add(cmdSave);

        cmdCompile.setText("Compile");
        cmdCompile.setFocusable(false);
        cmdCompile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdCompile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCompileActionPerformed(evt);
            }
        });
        editorToolbar.add(cmdCompile);

        cmdClose.setText("Close");
        cmdClose.setFocusable(false);
        cmdClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });
        editorToolbar.add(cmdClose);

        getContentPane().add(editorToolbar, java.awt.BorderLayout.PAGE_START);

        statusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusPanel.setPreferredSize(new java.awt.Dimension(400, 25));
        statusPanel.setLayout(new java.awt.BorderLayout());

        statusPanelText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        statusPanelText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusPanel.add(statusPanelText, java.awt.BorderLayout.CENTER);

        cursorPositionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cursorPositionPanel.setMinimumSize(new java.awt.Dimension(400, 100));
        cursorPositionPanel.setOpaque(false);
        cursorPositionPanel.setLayout(new java.awt.BorderLayout());

        cursorPositionText.setFont(new java.awt.Font("Arial", 1, 12));
        cursorPositionText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cursorPositionText.setMaximumSize(new java.awt.Dimension(100, 15));
        cursorPositionText.setMinimumSize(new java.awt.Dimension(100, 15));
        cursorPositionText.setPreferredSize(new java.awt.Dimension(100, 15));
        cursorPositionPanel.add(cursorPositionText, java.awt.BorderLayout.CENTER);

        statusPanel.add(cursorPositionPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(statusPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editorCaretUpdate
        updateCaretPosition(evt.getDot());
    }//GEN-LAST:event_editorCaretUpdate

    private void cmdReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReloadActionPerformed
        try {
            reloadSourceFile();
        } catch (Exception ex) {
            Logger.getLogger(SourceEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdReloadActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        try {
            saveSourceFile();
        } catch (Exception ex) {
            Logger.getLogger(SourceEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCompileActionPerformed
        try {
            compileSourceFile();
        } catch (Exception ex) {
            Logger.getLogger(SourceEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCompileActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdCompile;
    private javax.swing.JButton cmdReload;
    private javax.swing.JButton cmdSave;
    private javax.swing.JPanel cursorPositionPanel;
    private javax.swing.JLabel cursorPositionText;
    private javax.swing.JEditorPane editor;
    private javax.swing.JSplitPane editorSplit;
    private javax.swing.JToolBar editorToolbar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel statusPanelText;
    // End of variables declaration//GEN-END:variables

    /**
     * @param file
     * @throws Exception
     */
    public void edit() throws Exception {
        this.setPreferredSize(new Dimension(800, 600));
        this.pack();
        reloadSourceFile();
        editorSplit.setDividerLocation(0.95);
        setVisible(true);
    }

    private void reloadSourceFile() throws IOException, MalformedURLException {
        Document doc = editor.getDocument();
        doc.putProperty(Document.StreamDescriptionProperty, null);
        editor.setPage(runtimeCompiler.getSourceFile().toURI().toURL());
        showStatusBarMessage("File loaded successfuly");
    }

    public static int getRow(int pos, JTextComponent editor) {
        int rn = (pos == 0) ? 1 : 0;
        try {
            int offs = pos;
            while (offs > 0) {
                offs = Utilities.getRowStart(editor, offs) - 1;
                rn++;
            }
        } catch (BadLocationException e) {
        }
        return rn;
    }

    public static int getColumn(int pos, JTextComponent editor) {
        try {
            return pos - Utilities.getRowStart(editor, pos) + 1;
        } catch (BadLocationException e) {
        }
        return -1;
    }

    /**
     * @param row
     * @param column
     */
    protected void updateCaretPosition(int dot) {

        cursorPositionText.setText(getRow(dot, editor) + " , " + getColumn(dot, editor));
    }

    /**
     * @throws Exception
     *
     */
    protected void compileSourceFile() throws Exception {
        saveSourceFile();
        outputTextArea.setText("");
        try {
            runtimeCompiler.compile();
        } catch (RuntimeCompilationException e) {
            outputTextArea.setText(e.getMessage());
            return;
        }
        outputTextArea.setText("File Compiled Without Errors!");
        showStatusBarMessage("File compiled successfuly");
    }

    /**
     * @throws Exception
     *
     */
    protected void saveSourceFile() throws Exception {
        FileWriter out = new FileWriter(runtimeCompiler.getSourceFile());
        out.write(editor.getText());
        out.close();
        showStatusBarMessage("File saved successfuly");
    }

    /**
     *
     */
    private void delayedStatusClean() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                statusPanelText.setText("");

            }
        }).start();

    }

    private void showStatusBarMessage(String msg) {
        statusPanelText.setText(msg);
        delayedStatusClean();

    }
}
