package ui.gui;

import model.TelevisionShow;
import model.TelevisionShowList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// Creates a JList panel to list shows of a TV show list
public class ListPanel extends JPanel implements ListSelectionListener {
    private DefaultListModel<String> listModel;
    private JList<DefaultListModel> showJList;
    private TelevisionShowList showList;
    private InfoPanel infoPanel;

    // EFFECTS: initializes the JPanel to portray the JList of shows in a TV show list
    public ListPanel(TelevisionShowList showList, InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        refreshList(showList);
    }

    // MODIFIES: this
    // EFFECTS: Resets and initializes the JPanel's JList to contain the updated list of shows in the TV show list
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

    // MODIFIES: this, infoPanel
    // EFFECTS: Selected show in the JList will show the details of that show in the infoPanel
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedShow = showJList.getSelectedIndex();
        TelevisionShow correspondingShow = showList.getTelevisionShowList().get(selectedShow);
        infoPanel.displayShowInfo(correspondingShow);
    }

    // getters
    public JList<DefaultListModel> getJList() {
        return this.showJList;
    }
}
