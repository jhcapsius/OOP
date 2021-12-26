import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeihnachtsGUI extends JFrame implements ActionListener {
    // frame resolution
    private final int width = 1280;
    private final int height = 720;
    // frame title
    private final String title = "WeihnachtsGUI";

    // christmas tree area
    private Leinwand leinwand;

    private JPanel backgroud;

    // menu panel right next to the christmas tree area
    private JPanel menuPanel;

    // panel for the christmas card label and textfield
    private JPanel cardPanel;

    // panel for the parameter
    private JPanel paramPanel;

    private GridBagConstraints gbc;

    // christmascard label
    private JLabel christmasCardLabel;

    // status label
    private JLabel status;

    // christmas card textfield for the name of the receiver
    private JTextField name;

    // radio buttons for the christmas tree or a forest of christmas trees
    private JRadioButton christmasTreeRadioButton;
    private JRadioButton christmasTreeForestRadioButton;

    // button group for the two radio buttons
    private ButtonGroup buttonGroup;

    // checkbox for the decoration
    private JCheckBox decoration;

    // send button to confirm the inputs
    private JButton send;

    // status GUI
    private boolean christmasTreeState;
    private boolean christmasTreeForestState;
    private boolean decorationState;

    private class Leinwand extends JPanel {
        private boolean christmasTreeState;
        private boolean christmasTreeForestState;
        private boolean decoration;

        // resolution background
        private final int widthPanel = 960;
        private final int heigthPanel = 720;
        // color background
        private Color bgColor = new Color(0, 0, 0);

        Leinwand() {
            // init panel
            this.setPreferredSize(new Dimension(this.widthPanel, this.heigthPanel));
            this.christmasTreeState = false;
            this.christmasTreeForestState = false;
            this.decoration = false;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.setColor(bgColor);
            g.fillRect(0, 0, this.widthPanel, this.heigthPanel);

            if(this.christmasTreeState){
                g.setColor(Color.GREEN);
                g.fillRect(20, 20, 200, 200);
            }
        }

        public void drawCard(boolean cts, boolean ctfs, boolean d){
            setState(cts, ctfs, d);
            repaint();
        }

        private void setState(boolean cts, boolean ctfs, boolean d){
            this.christmasTreeState = cts;
            this.christmasTreeForestState = ctfs;
            this.decoration = d;
        }
    }

    WeihnachtsGUI() {
        initComponents();
        addComponentsToMenuPanel();
        addComponentsToContainer();
        this.setVisible(true);

    }

    private void initComponents() {
        initFrame();
        initChristmasTree();
        initPanel();
        initLabel();
        initTextfield();
        initRadioButton();
        initButtonGroup();
        initCheckbox();
        initButton();

    }

    private void addComponentsToContainer() {
        this.setContentPane(this.backgroud);
        this.backgroud.add(this.leinwand, BorderLayout.CENTER);
        this.backgroud.add(this.menuPanel, BorderLayout.EAST);
        this.backgroud.add(this.status, BorderLayout.SOUTH);

    }

    private void addComponentsToMenuPanel() {
        this.cardPanel.add(this.christmasCardLabel);
        this.cardPanel.add(this.name);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(2, 0, 0, 2);
        this.paramPanel.add(this.christmasTreeRadioButton, this.gbc);
        gbc.gridy++;
        gbc.weightx = 0.00001;
        gbc.weighty = 0.00001;
        this.paramPanel.add(this.christmasTreeForestRadioButton, this.gbc);
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.paramPanel.add(this.decoration, this.gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 0, 0, 2);
        gbc.weightx = 0.0000;
        gbc.weighty = 0.0000;
        this.menuPanel.add(this.cardPanel, gbc);
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.menuPanel.add(this.paramPanel, gbc);
        gbc.gridy++;
        gbc.weightx = -1;
        gbc.weighty = -1;
        this.menuPanel.add(this.send, gbc);
    }

    private void initFrame() {
        this.setSize(this.width, this.height);
        this.setTitle(this.title);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initChristmasTree() {
        this.leinwand = new Leinwand();
    }

    private void initPanel() {
        this.gbc = new GridBagConstraints();

        // init background panel
        this.backgroud = new JPanel();
        this.backgroud.setSize(this.width, this.height);
        this.backgroud.setLayout(new BorderLayout());

        // init menupanel
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new GridBagLayout());
        this.menuPanel.setPreferredSize(new Dimension(320, 720));

        // init cardpanel
        this.cardPanel = new JPanel();

        this.paramPanel = new JPanel();
        this.paramPanel.setLayout(new GridBagLayout());
        this.paramPanel.setPreferredSize(new Dimension(320, 320));
        this.paramPanel.setBorder(BorderFactory.createTitledBorder("Parameter"));

    }

    private void initLabel() {
        this.christmasCardLabel = new JLabel("Weihnachtskarte fuer");
        this.christmasCardLabel.setToolTipText("Beschriftung des Textfeldes");
        this.status = new JLabel("-");
        this.status.setToolTipText("Zeigt die aktuelle Auswahl an.");
    }

    private void initTextfield() {
        this.name = new JTextField("Name eingeben...");
        this.name.setToolTipText("Hier kann der Name der Person, fuer die die Karte ist, eingegeben werden");
        this.name.setPreferredSize(new Dimension(150, 20));
        // removes the text from the textbox if you click at it
        this.name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteTextfield(e);
            }

            private void deleteTextfield(MouseEvent e) {
                name.setText("");
            }
        });
    }

    private void initRadioButton() {
        this.christmasTreeRadioButton = new JRadioButton("Tannenbaum");
        this.christmasTreeRadioButton.setToolTipText("Zeichnet einen einzelnen Tannenbaum mittig der Karte");
        this.christmasTreeRadioButton.addActionListener(this);
        this.christmasTreeForestRadioButton = new JRadioButton("Wald");
        this.christmasTreeForestRadioButton.setToolTipText("Zeichnet einen ganzen Wald bestehend aus Tannenbaeumen. Jeder Tannenbaum hat eine unterschiedliche Farbe, Position und Baumgroesse");
        this.christmasTreeForestRadioButton.addActionListener(this);
    }

    private void initButtonGroup() {
        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(this.christmasTreeRadioButton);
        this.buttonGroup.add(this.christmasTreeForestRadioButton);
    }

    private void initCheckbox() {
        this.decoration = new JCheckBox("Verzierung");
        this.decoration.setToolTipText("Fuegt den Baeumen Baumschmuck und Baumstaemme hinzu. Außerdem wird ein Sternenhimmel erstellt");
        this.decoration.addActionListener(this);
    }

    private void initButton() {
        this.send = new JButton("Send");
        this.send.setToolTipText("Bestaetigt die Auswahl und erstellt eine neue Karte");
        this.send.setSize(320, 20);
        this.send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.christmasTreeRadioButton) {
            this.christmasTreeState = true;
            this.christmasTreeForestState = false;
            if (this.decorationState && this.christmasTreeState) {
                this.status.setText("Tannenbaum mit Verzierung");
            } else {
                this.status.setText("Tannenbaum");
            }
        } else if (e.getSource() == this.christmasTreeForestRadioButton) {
            this.christmasTreeState = false;
            this.christmasTreeForestState = true;
            if (this.decorationState && this.christmasTreeForestState) {
                this.status.setText("Wald mit Verzierung");
            } else {
                this.status.setText("Wald");
            }
        } else if (e.getSource() == this.decoration) {
            if (this.decorationState) {
                this.decorationState = false;
            } else {
                this.decorationState = true;
            }

            if (!this.decorationState && this.christmasTreeState) {
                this.status.setText("Tannenbaum");
            } else if (!this.decorationState && this.christmasTreeForestState) {
                this.status.setText("Wald");
            }

            if (this.decorationState && this.christmasTreeState) {
                this.status.setText("Tannenbaum plus Verzierung");
            } else if (this.decorationState && this.christmasTreeForestState) {
                this.status.setText("Wald plus Verzierung");
            }
        } else if (e.getSource() == this.send) {
            this.leinwand.drawCard(this.christmasTreeState, this.christmasTreeForestState, this.decorationState);
        }
    }

    public static void main(String[] args) {
        WeihnachtsGUI weihnachtsGUI = new WeihnachtsGUI();
    }

}
