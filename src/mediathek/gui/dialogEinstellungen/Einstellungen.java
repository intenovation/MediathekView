/*
 * MediathekView
 * Copyright (C) 2014 W. Xaver
 * W.Xaver[at]googlemail.com
 * http://zdfmediathk.sourceforge.net/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package mediathek.gui.dialogEinstellungen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import mediathek.config.Daten;
import mediathek.gui.MVStatusBar;
import mediathek.gui.PanelVorlage;
import mediathek.config.Konstanten;

public class Einstellungen extends javax.swing.JPanel {

    Daten daten;
    public boolean ok = false;
    private PanelEinstellungen panelEinstellungen;
    private PanelDownload panelDownload;
    private PanelMediaDB panelMediaDB;
    private PanelEinstellungenErweitert panelEinstellungenErweitert;
    private PanelEinstellungenGeo panelEinstellungenGeo;
    private PanelImport panelImport;
    private PanelEinstellungenColor panelEinstellungenColor;
    private PanelFilmlisteLaden panelImportFilme;
    private PanelExportFilmliste panelExportFilmliste;
    private PanelBlacklist panelBlacklist;
    private PanelErledigteUrls panelErledigteAbos;
    private PanelErledigteUrls panelHistory;
    private PanelDateinamen panelDateinamen;
    private PanelVorlage panelPset;
    private PanelPsetImport panelPsetVorlagen;
    // Infos
    private PanelProgrammInfos panelAbout;
    private final JPanel panelLeer = new JPanel();
    private final JFrame parentComponent;

    private final String NAME_einstellungen = "Einstellungen";
    private final String NAME_allgemeineEinstellungen = "Allgemein";
    private final String NAME_bandwidth = "Download";
    private final String NAME_mediaDB = "Mediensammlung";
    private final String NAME_allgemeineEinstellungenErweitert = "Erweitert";
    private final String NAME_allgemeineEinstellungenGeo = "Geo";
    private final String NAME_allgemeineEinstellungenImport = "Import";
    private final String NAME_allgemeineEinstellungenColor = "Farben";
    private final String NAME_filmListe = "Filmliste";
    private final String NAME_filmListeLaden = "Filmliste laden";
    private final String NAME_filmListeExportieren = "Filmliste exportieren";
    private final String NAME_blacklist = "Blacklist";
    private final String NAME_aufzeichnen = "Aufzeichnen und Abspielen";
    private final String NAME_dateiname = "Datei- und Pfadnamen";
    private final String NAME_programmset = "Set bearbeiten";
    private final String NAME_programmsetImportieren = "Set importieren";
    private final String NAME_infos = "Infos";
    private final String NAME_programmInfos = "Programminfos";
    private final String NAME_history = "History";
    private final String NAME_logfile = "Erledigte Abos";
    // ######## Einstellulngen ############
    private final DefaultMutableTreeNode treeNodeEinstellungen = new DefaultMutableTreeNode("Einstellungen");
    private final DefaultMutableTreeNode treeNodeAllgemeineEinstellungen = new DefaultMutableTreeNode(NAME_allgemeineEinstellungen);
    private final DefaultMutableTreeNode treeNodeAllgemeineEinstellungenEreweitert = new DefaultMutableTreeNode(NAME_allgemeineEinstellungenErweitert);
    private final DefaultMutableTreeNode treeNodeAllgemeineEinstellungenGeo = new DefaultMutableTreeNode(NAME_allgemeineEinstellungenGeo);
    private final DefaultMutableTreeNode treeNodeAllgemeineEinstellungenImport = new DefaultMutableTreeNode(NAME_allgemeineEinstellungenImport);
    private final DefaultMutableTreeNode treeNodeAllgemeineEinstellungenColor = new DefaultMutableTreeNode(NAME_allgemeineEinstellungenColor);
    // ######## Filme ###############
    private final DefaultMutableTreeNode treeNodeFilme = new DefaultMutableTreeNode("Filmliste");
    private final DefaultMutableTreeNode treeNodeFilmliste = new DefaultMutableTreeNode(NAME_filmListeLaden);
    private final DefaultMutableTreeNode treeNodeFilmlisteExport = new DefaultMutableTreeNode(NAME_filmListeExportieren);
    private final DefaultMutableTreeNode treeNodeBlacklist = new DefaultMutableTreeNode(NAME_blacklist);
    // ########### Programme ##############
    private final DefaultMutableTreeNode treeNodeDownload = new DefaultMutableTreeNode("Aufzeichnen und Abspielen");
    private final DefaultMutableTreeNode treeNodeBandwidth = new DefaultMutableTreeNode(NAME_bandwidth);
    private final DefaultMutableTreeNode treeNodeMediaDB = new DefaultMutableTreeNode(NAME_mediaDB);

    private final DefaultMutableTreeNode treeNodeDateinamen = new DefaultMutableTreeNode(NAME_dateiname);
    private final DefaultMutableTreeNode treeNodeProgramme = new DefaultMutableTreeNode(NAME_programmset);
    private final DefaultMutableTreeNode treeNodeImportProgramme = new DefaultMutableTreeNode(NAME_programmsetImportieren);
    // ####### Infos #########
    private final DefaultMutableTreeNode treeNodeInfos = new DefaultMutableTreeNode("Infos");
    private final DefaultMutableTreeNode treeNodeProgrammInfos = new DefaultMutableTreeNode(NAME_programmInfos);
    private final DefaultMutableTreeNode treeNodeHistory = new DefaultMutableTreeNode(NAME_history);
    private final DefaultMutableTreeNode treeNodeLogfile = new DefaultMutableTreeNode(NAME_logfile);

    public Einstellungen(JFrame parent, Daten d) {
        initComponents();
        parentComponent = parent;
        daten = d;
        init();
        initTree();
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
//                Daten.mediathekGui.setTabShown(MediathekGui.TABS.TAB_NIX);
                Daten.mediathekGui.getStatusBar().setIndexForLeftDisplay(MVStatusBar.StatusbarIndex.NONE);
            }
        });
    }

    private void init() {
        jPanelExtra.setLayout(new java.awt.BorderLayout());
        panelEinstellungen = new PanelEinstellungen(daten, parentComponent);
        panelDownload = new PanelDownload(daten, parentComponent);
        panelMediaDB = new PanelMediaDB(daten, parentComponent);
        panelEinstellungenErweitert = new PanelEinstellungenErweitert(daten, parentComponent);
        panelEinstellungenGeo = new PanelEinstellungenGeo(daten, parentComponent);
        panelImport = new PanelImport(daten, parentComponent);
        panelEinstellungenColor = new PanelEinstellungenColor(daten, parentComponent);
        panelImportFilme = new PanelFilmlisteLaden(daten, parentComponent);
        panelExportFilmliste = new PanelExportFilmliste(daten, parentComponent);
        panelBlacklist = new PanelBlacklist(daten, parentComponent, PanelBlacklist.class.getName());
        panelHistory = new PanelErledigteUrls(daten, parentComponent);
        panelHistory.initHistory();
        panelErledigteAbos = new PanelErledigteUrls(daten, parentComponent);
        panelErledigteAbos.initAbo();
        panelDateinamen = new PanelDateinamen(daten, parentComponent);
        panelPset = new PanelPset(daten, parentComponent);
        panelPsetVorlagen = new PanelPsetImport(daten, parentComponent);
        panelAbout = new PanelProgrammInfos(daten, parentComponent);
    }

    private void initTree() {
        //
        DefaultMutableTreeNode treeNodeStart = new DefaultMutableTreeNode(Konstanten.PROGRAMMNAME);
        // ===============================================================================
        // ######## Einstellulngen ############
        treeNodeEinstellungen.add(treeNodeAllgemeineEinstellungen);
        treeNodeEinstellungen.add(treeNodeAllgemeineEinstellungenEreweitert);
        treeNodeEinstellungen.add(treeNodeAllgemeineEinstellungenGeo);
        treeNodeEinstellungen.add(treeNodeAllgemeineEinstellungenImport);
        treeNodeEinstellungen.add(treeNodeAllgemeineEinstellungenColor);
        treeNodeEinstellungen.add(treeNodeMediaDB);
        treeNodeStart.add(treeNodeEinstellungen);
        // ===============================================================================
        // ######## Filme ###############
        treeNodeFilme.add(treeNodeFilmliste);
        treeNodeFilme.add(treeNodeFilmlisteExport);
        treeNodeFilme.add(treeNodeBlacklist);
        treeNodeStart.add(treeNodeFilme);
        // ===============================================================================
        // ########### Programme ##############
        treeNodeDownload.add(treeNodeDateinamen);
        treeNodeDownload.add(treeNodeBandwidth);
        treeNodeDownload.add(treeNodeProgramme);
        treeNodeDownload.add(treeNodeImportProgramme);
        treeNodeStart.add(treeNodeDownload);
        // ===============================================================================
        // ####### Infos #########
        treeNodeInfos.add(treeNodeProgrammInfos);
        treeNodeInfos.add(treeNodeHistory);
        treeNodeInfos.add(treeNodeLogfile);
        treeNodeStart.add(treeNodeInfos);

        // Aufbauen
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNodeStart));
        jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree1.setRootVisible(false);
        jTree1.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
            if (node == null) {
                // nix markiert
                jPanelExtra.removeAll();
                jPanelExtra.add(panelLeer);
            } else {
                String name1 = node.getUserObject().toString();
                switch (name1) {
                    //Einstellungen
                    case NAME_einstellungen:
                        jTree1.setSelectionPath(new TreePath(treeNodeAllgemeineEinstellungen.getPath()));
                        break;
                    case NAME_bandwidth:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelDownload);
                        break;
                    case NAME_mediaDB:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelMediaDB);
                        break;
                    case NAME_allgemeineEinstellungen:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelEinstellungen);
                        break;
                    case NAME_allgemeineEinstellungenErweitert:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelEinstellungenErweitert);
                        break;
                    case NAME_allgemeineEinstellungenGeo:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelEinstellungenGeo);
                        break;
                    case NAME_allgemeineEinstellungenImport:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelImport);
                        break;
                    case NAME_allgemeineEinstellungenColor:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelEinstellungenColor);
                        break;
                    //Filmliste
                    case NAME_filmListe:
                        jTree1.setSelectionPath(new TreePath(treeNodeFilmliste.getPath()));
                        break;
                    case NAME_filmListeLaden:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelImportFilme);
                        break;
                    case NAME_filmListeExportieren:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelExportFilmliste);
                        break;
                    case NAME_blacklist:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelBlacklist);
                        break;
                    //Aufzeichnen, Abspielen
                    case NAME_aufzeichnen:
                        jTree1.setSelectionPath(new TreePath(treeNodeDateinamen.getPath()));
                        break;
                    case NAME_dateiname:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelDateinamen);
                        break;
                    case NAME_programmset:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelPset);
                        break;
                    case NAME_programmsetImportieren:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelPsetVorlagen);
                        break;
                    //Infos
                    case NAME_infos:
                        jTree1.setSelectionPath(new TreePath(treeNodeProgrammInfos.getPath()));
                        break;
                    case NAME_programmInfos:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelAbout);
                        break;
                    case NAME_history:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelHistory);
                        break;
                    case NAME_logfile:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelErledigteAbos);
                        break;
                    default:
                        jPanelExtra.removeAll();
                        jPanelExtra.add(panelLeer);
                        break;
                }
            }
            jPanelExtra.updateUI();
        });
        // und jetzt noch aufklappen
        for (int i = 0; i < jTree1.getRowCount(); ++i) {
            jTree1.expandRow(i);
        }
        // und den Start setzen
        TreePath tp = new TreePath(treeNodeAllgemeineEinstellungen.getPath());
        jTree1.setSelectionPath(tp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelExtra = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(200);

        jScrollPane1.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout jPanelExtraLayout = new javax.swing.GroupLayout(jPanelExtra);
        jPanelExtra.setLayout(jPanelExtraLayout);
        jPanelExtraLayout.setHorizontalGroup(
            jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        jPanelExtraLayout.setVerticalGroup(
            jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanelExtra);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelExtra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
