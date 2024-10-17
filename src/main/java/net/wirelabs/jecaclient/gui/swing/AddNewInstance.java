package net.wirelabs.jecaclient.gui.swing;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AddNewInstance extends JDialog {


    private static final long serialVersionUID = 1L;

    private final JPanel contentPanel = new JPanel();
    private final JLabel lblHio;
    private final JTextField textField;
    private final JLabel lblPort;
    private final JLabel lblName;
    private final JTextField textField_2;
    private final JLabel lblPath;
    private final JTextField textField_3;
    private final JTextField textField_4;
    private final JLabel lblLogfile;
    private final JTextField textField_5;
    private final JCheckBox chckbxNewCheckBox;


    /**
     * Create the dialog.
     */
    public AddNewInstance() {
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Add new Ecasound session");
        setBounds(100, 100, 450, 239);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("gapx 1, gapy 1, insets 1", "[168.00,grow][217.00][grow]", "[][][][][][][]"));

        lblName = new JLabel("Name:");
        contentPanel.add(lblName, "cell 0 0,alignx left,growy");

        lblHio = new JLabel("Host:");
        contentPanel.add(lblHio, "cell 1 0,alignx left,growy");

        lblPort = new JLabel("Port:");
        contentPanel.add(lblPort, "cell 2 0,alignx left,growy");

        textField_2 = new JTextField();
        contentPanel.add(textField_2, "cell 0 1,grow");
        textField_2.setColumns(10);

        textField = new JTextField();
        contentPanel.add(textField, "cell 1 1,grow");
        textField.setColumns(10);

        textField_5 = new JTextField();
        contentPanel.add(textField_5, "cell 2 1,growx");
        textField_5.setColumns(10);

        chckbxNewCheckBox = new JCheckBox("spawn local");
        contentPanel.add(chckbxNewCheckBox, "cell 0 2,growx,aligny baseline");

        lblPath = new JLabel("Path:");
        contentPanel.add(lblPath, "flowx,cell 0 3,alignx left,growy");

        textField_3 = new JTextField();
        contentPanel.add(textField_3, "cell 0 4 3 1,grow");
        textField_3.setColumns(10);

        lblLogfile = new JLabel("Logfile:");
        contentPanel.add(lblLogfile, "flowx,cell 0 5,alignx left,growy");

        textField_4 = new JTextField();
        contentPanel.add(textField_4, "cell 0 6 3 1,grow");
        textField_4.setColumns(10);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(e -> dispose());
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
