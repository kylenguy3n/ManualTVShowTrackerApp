package ui.gui;

import model.TelevisionShow;
import model.TelevisionShowList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// ListPanel
public class ListPanel extends JPanel implements ListSelectionListener {
    private DefaultListModel<String> listModel;
    private JList<TelevisionShow> showJList;
    private TelevisionShowList showList;
    private InfoPanel infoPanel;

    // EFFECTS:
    public ListPanel(TelevisionShowList showList, InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        refreshList(showList);
    }

    // MODIFIES: this
    // EFFECTS:
    public void refreshList(TelevisionShowList showList) {
        this.removeAll();
        this.revalidate();
        this.repaint();

        this.showList = showList;
        listModel = new DefaultListModel<>();

        for (TelevisionShow show : showList.getTelevisionShowList()) {
            listModel.addElement(show.getTitle());
        }

        showJList = new JList(listModel);
        showJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showJList.setLayoutOrientation(JList.VERTICAL);
        showJList.setVisibleRowCount(-1);

        JScrollPane showJListScroll = new JScrollPane(showJList);
        showJListScroll.setPreferredSize(new Dimension(340, 590));
        add(showJListScroll);

        showJList.addListSelectionListener(this);
    }

    // EFFECTS:
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedShow = showJList.getSelectedIndex();
        TelevisionShow correspondingShow = showList.getTelevisionShowList().get(selectedShow);
        infoPanel.displayShowInfo(correspondingShow);
    }

    // getters
    public JList<TelevisionShow> getJList() {
        return this.showJList;
    }
}
