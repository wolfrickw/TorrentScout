/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CurveSelectionPanel.java
 *
 * Created on 13.09.2011, 11:59:33
 */
package org.iontorrent.acqview;

import com.iontorrent.wellmodel.WellFlowDataResult.ResultType;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import javax.swing.JCheckBox;

/**
 *
 * @author Chantal Roth
 */
public class CurveSelectionPanel extends javax.swing.JPanel {

    private ArrayList<ResultBox> boxResults;
    private JCheckBox boxAllWells;
    private JCheckBox boxRaw;
    /** Creates new form CurveSelectionPanel */
    TorrentScoutAcqViewTopComponent parent;

    public CurveSelectionPanel(TorrentScoutAcqViewTopComponent parent) {
        initComponents();
        this.parent = parent;
        this.setOpaque(false);
        setupPanel();
    }

    private void setupPanel() {
        boxResults = new ArrayList<ResultBox>();
        int nrtypes = EnumSet.allOf(ResultType.class).size() + 1;
        setLayout(new GridLayout(3, nrtypes / 3 + 1));
        boxRaw = new JCheckBox("Show raw signal");
        boxRaw.setOpaque(false);
        boxRaw.setSelected(false);
        boxRaw.setToolTipText("The very raw signal without any bg correction or peak finding. The seleced data transformations however have been applied");
        boxRaw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.update();
            }
        });
        add(boxRaw);

        for (final ResultType type : EnumSet.allOf(ResultType.class)) {
            if (type.getName() != null && type.getName().length() > 0) {
                final ResultBox box = new ResultBox(type.getName(), type);
                box.setSelected(type.isShow());
                box.setOpaque(false);

                add(box);
                getBoxResults().add(box);
                box.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        type.setShow(box.isSelected());
                        parent.update();
                        //paintImmediately(0,0,1000, 1000);
                        //repaint();
                        invalidate();
                        validate();
                        Dimension dim = getSize();
                        setSize(dim);

                    }
                });
            }
        }

        boxAllWells = new JCheckBox("Use all wells from well table");
        getBoxAllWells().setOpaque(false);
        getBoxAllWells().setToolTipText("<html>Instead of using the signal of just one selected well, this would use the signal of <b>all wells</b> in your table, "
                + "<br>and it would use all empty wells in the entire area to compute the bg subtraction</html>");
        // pn.add("East", this.boxAllWells);
        add(getBoxAllWells());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * @return the boxResults
     */
    public ArrayList<ResultBox> getBoxResults() {
        return boxResults;
    }

    /**
     * @return the boxRaw
     */
    public JCheckBox getBoxRaw() {
        return boxRaw;
    }

    /**
     * @return the boxAllWells
     */
    public JCheckBox getBoxAllWells() {
        return boxAllWells;
    }
}
