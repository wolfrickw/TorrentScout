/*
 * Copyright (C) 2011 Life Technologies Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * FlowSelection.java
 *
 * Created on 02.12.2011, 08:33:10
 */
package com.iontorrent.torrentscout.explorer.process;

import com.iontorrent.expmodel.FiletypeListener;
import com.iontorrent.expmodel.FlowListener;
import com.iontorrent.guiutils.flow.FiletypePanel;
import com.iontorrent.guiutils.flow.FlowNrPanel;
import com.iontorrent.rawdataaccess.pgmacquisition.RawType;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Chantal Roth
 */
public class FlowSelection extends javax.swing.JPanel implements FlowListener, FiletypeListener {

    private FlowNrPanel flowPanel;
    private FiletypePanel typePanel;
    private int flow;
    private RawType filetype;

    /** Creates new form FlowSelection */
    public FlowSelection(String title) {
        initComponents();
        setLayout(new BorderLayout());

        flowPanel = new FlowNrPanel(this);


        typePanel = new FiletypePanel(this);
        add("North", new JLabel(title));
                
        add("Center", typePanel);
        add("South", flowPanel);


    }

    @Override
    public void flowChanged(ArrayList<Integer> flows) {
        setFlow((int) flows.get(0));

    }

    @Override
    public void fileTypeChanged(RawType filetype) {
        this.setFiletype(filetype);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * @return the flow
     */
    public int getFlow() {
        return flow;
    }

    /**
     * @param flow the flow to set
     */
    public void setFlow(int flow) {
        this.flow = flow;
        this.flowPanel.setFlow(flow);
    }

    /**
     * @return the filetype
     */
    public RawType getFiletype() {
        return filetype;
    }

    /**
     * @param filetype the filetype to set
     */
    public void setFiletype(RawType filetype) {
        this.filetype = filetype;
        this.typePanel.setType(filetype);
    }
}
