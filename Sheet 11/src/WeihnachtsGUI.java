import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

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

        // farb codes
        private int r, g, b;

        // resolution background
        private final int widthPanel = 960;
        private final int heigthPanel = 720;

        // color background
        private final Color bgColor = new Color(0, 0, 0);

        // christmas tree color
        private final Color christmasTreeColor = new Color(34, 139, 34);

        // log color
        private final Color logColor = new Color(139, 69, 19);

        // color star
        private final Color starColor = new Color(255,255,255);

        // christmas tree coordinates first
        private final int[] treeX = { 450, 480, 510 };
        private final int[] treeY = { 410, 360, 410 };

        // forest start
        private final int[] forestX = { 100, 130, 160 };
        private final int[] forestY = { 350, 300, 350 };

        // forest log start

        // initial star coordianates
        private final int[] starX = { 30, 45, 50, 55, 70, 55, 50, 45 };
        private final int[] starY = { 30, 25, 10, 25, 30, 35, 50, 35 };

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

            // draw background
            g.setColor(bgColor);
            g.fillRect(0, 0, this.widthPanel, this.heigthPanel);

            // draw tree with decoration
            if (this.christmasTreeState && this.decoration) {
                // draw christmas tree
                g.setColor(this.christmasTreeColor);
                g.fillPolygon(this.treeX, this.treeY, this.treeX.length);
                g.fillPolygon(new int[] { this.treeX[0] - 10, this.treeX[1], this.treeX[2] + 10 },
                        new int[] { this.treeY[0] + 25, this.treeY[1] + 25, this.treeY[2] + 25 }, this.treeX.length);
                g.fillPolygon(new int[] { this.treeX[0] - 20, this.treeX[1], this.treeX[2] + 20 },
                        new int[] { this.treeY[0] + 50, this.treeY[1] + 50, this.treeY[2] + 50 }, this.treeX.length);

                // draw log
                g.setColor(this.logColor);
                g.fillRect(this.treeX[1] - 10, this.treeY[0] + 50, 20, 30);

                // draw decoration
                g.setColor(Color.RED);
                g.fillOval(445, 408, 10, 10);
                g.fillOval(505, 408, 10, 10);
                g.fillOval(435, 433, 10, 10);
                g.fillOval(515, 433, 10, 10);
                g.fillOval(425, 458, 10, 10);
                g.fillOval(525, 458, 10, 10);

                // draw stars
                int y;
                int x;
                int minX = 60;
                int maxX = 90;
                int minY = 45;
                int maxY = 50;
                g.setColor(this.starColor);
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 4; k++) {
                        x = ThreadLocalRandom.current().nextInt(minX, maxX);
                        y = ThreadLocalRandom.current().nextInt(minY, maxY);
                        g.fillPolygon(
                                new int[] { this.starX[0] + x, this.starX[1] + x, this.starX[2] + x,
                                        this.starX[3] + x, this.starX[4] + x, this.starX[5] + x, this.starX[6] + x,
                                        this.starX[7] + x },
                                new int[] { this.starY[0] + y, this.starY[1] + y, this.starY[2] + y,
                                        this.starY[3] + y, this.starY[4] + y, this.starY[5] + y, this.starY[6] + y,
                                        this.starY[7] + y },
                                this.starX.length);
                        minX += 200;
                        maxX += 250;
                    }
                    minX = 60;
                    maxX = 90;
                    minY += 45;
                    maxY += 60;
                }

                // draw christmas forrest with decoration
            } else if (this.christmasTreeForestState && this.decoration) {
                int y;
                int x;
                // deviation of the position
                int minX = -10;
                int maxX = 10;
                int minY = -10;
                int maxY = 10;
                // creates 10 trees with random position
                for (int i = 0; i < 2; i++) {
                    for (int k = 0; k < 5; k++) {
                        // sets random color for each tree
                        this.r = ThreadLocalRandom.current().nextInt(0, 255);
                        this.g = ThreadLocalRandom.current().nextInt(0, 255);
                        this.b = ThreadLocalRandom.current().nextInt(0, 255);
                        Color treeColor = new Color(this.r, this.g, this.b);
                        g.setColor(treeColor);

                        // creares random position for each tree
                        x = ThreadLocalRandom.current().nextInt(minX, maxX);
                        y = ThreadLocalRandom.current().nextInt(minY, maxY);

                        // draws the tree
                        g.fillPolygon(new int[] { this.forestX[0] + x, this.forestX[1] + x, this.forestX[2] + x },
                                new int[] { this.forestY[0] + y, this.forestY[1] + y, this.forestY[2] + y },
                                this.forestY.length);
                        g.fillPolygon(
                                new int[] { this.forestX[0] - 10 + x, this.forestX[1] + x, this.forestX[2] + 10 + x },
                                new int[] { this.forestY[0] + 25 + y, this.forestY[1] + 25 + y,
                                        this.forestY[2] + 25 + y },
                                this.forestY.length);
                        g.fillPolygon(
                                new int[] { this.forestX[0] - 20 + x, this.forestX[1] + x, this.forestX[2] + 20 + x },
                                new int[] { this.forestY[0] + 50 + y, this.forestY[1] + 50 + y,
                                        this.forestY[2] + 50 + y },
                                this.forestY.length);

                        // draws the log
                        g.setColor(this.logColor);
                        g.fillRect(this.forestX[1] - 10 + x, this.forestY[0] + 50 + y, 20, 30);

                        // draws the decoration
                        this.r = ThreadLocalRandom.current().nextInt(0, 255);
                        this.g = ThreadLocalRandom.current().nextInt(0, 255);
                        this.b = ThreadLocalRandom.current().nextInt(0, 255);
                        Color decoColor = new Color(this.r,this.g,this.b);
                        g.setColor(decoColor);
                        g.fillOval(this.forestX[0]-5+x, this.forestY[0]-2+y, 10, 10);
                        g.fillOval(this.forestX[02]-5+x, this.forestY[0]-2+y, 10, 10);
                        g.fillOval(this.forestX[0]-10+x-5, this.forestY[0]+22+y, 10, 10);
                        g.fillOval(this.forestX[02]+10+x-5, this.forestY[0]+22+y, 10, 10);
                        g.fillOval(this.forestX[0]-20+x-5, this.forestY[0]+48+y, 10, 10);
                        g.fillOval(this.forestX[02]+20+x-5, this.forestY[0]+48+y, 10, 10);

                        minX += 160;
                        maxX += 170;
                    }
                    minX = -10;
                    maxX = 10;
                    minY += 150;
                    maxY += 200;
                }

                // draw stars
                minX = 60;
                maxX = 90;
                minY = 45;
                maxY = 50;
                g.setColor(this.starColor);
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 4; k++) {
                        x = ThreadLocalRandom.current().nextInt(minX, maxX);
                        y = ThreadLocalRandom.current().nextInt(minY, maxY);
                        g.fillPolygon(
                                new int[] { this.starX[0] + x, this.starX[1] + x, this.starX[2] + x,
                                        this.starX[3] + x, this.starX[4] + x, this.starX[5] + x, this.starX[6] + x,
                                        this.starX[7] + x },
                                new int[] { this.starY[0] + y, this.starY[1] + y, this.starY[2] + y,
                                        this.starY[3] + y, this.starY[4] + y, this.starY[5] + y, this.starY[6] + y,
                                        this.starY[7] + y },
                                this.starX.length);
                        minX += 200;
                        maxX += 250;
                    }
                    minX = 60;
                    maxX = 90;
                    minY += 45;
                    maxY += 60;
                }
            } else if (this.christmasTreeState) {

                // draw tree
                g.setColor(this.christmasTreeColor);
                g.fillPolygon(this.treeX, this.treeY, 3);
                g.fillPolygon(new int[] { this.treeX[0] - 10, this.treeX[1], this.treeX[2] + 10 },
                        new int[] { this.treeY[0] + 25, this.treeY[1] + 25, this.treeY[2] + 25 }, this.treeX.length);
                g.fillPolygon(new int[] { this.treeX[0] - 20, this.treeX[1], this.treeX[2] + 20 },
                        new int[] { this.treeY[0] + 50, this.treeY[1] + 50, this.treeY[2] + 50 }, this.treeX.length);
            }else if(this.christmasTreeForestState){
                int y;
                int x;
                // deviation of the position
                int minX = -10;
                int maxX = 10;
                int minY = -10;
                int maxY = 10;
                // creates 10 trees with random position
                for (int i = 0; i < 2; i++) {
                    for (int k = 0; k < 5; k++) {
                        // sets random color for each tree
                        this.r = ThreadLocalRandom.current().nextInt(0, 255);
                        this.g = ThreadLocalRandom.current().nextInt(0, 255);
                        this.b = ThreadLocalRandom.current().nextInt(0, 255);
                        Color treeColor = new Color(this.r, this.g, this.b);
                        g.setColor(treeColor);

                        // creares random position for each tree
                        x = ThreadLocalRandom.current().nextInt(minX, maxX);
                        y = ThreadLocalRandom.current().nextInt(minY, maxY);

                        // draws the tree
                        g.fillPolygon(new int[] { this.forestX[0] + x, this.forestX[1] + x, this.forestX[2] + x },
                                new int[] { this.forestY[0] + y, this.forestY[1] + y, this.forestY[2] + y },
                                this.forestY.length);
                        g.fillPolygon(
                                new int[] { this.forestX[0] - 10 + x, this.forestX[1] + x, this.forestX[2] + 10 + x },
                                new int[] { this.forestY[0] + 25 + y, this.forestY[1] + 25 + y,
                                        this.forestY[2] + 25 + y },
                                this.forestY.length);
                        g.fillPolygon(
                                new int[] { this.forestX[0] - 20 + x, this.forestX[1] + x, this.forestX[2] + 20 + x },
                                new int[] { this.forestY[0] + 50 + y, this.forestY[1] + 50 + y,
                                        this.forestY[2] + 50 + y },
                                this.forestY.length);
                        minX += 160;
                        maxX += 170;
                    }
                    minX = -10;
                    maxX = 10;
                    minY += 150;
                    maxY += 200;
                }
            }
        }

        public void drawCard(boolean cts, boolean ctfs, boolean d) {
            setState(cts, ctfs, d);
            repaint();
        }

        private void setState(boolean cts, boolean ctfs, boolean d) {
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
        this.christmasTreeForestRadioButton.setToolTipText(
                "Zeichnet einen ganzen Wald bestehend aus Tannenbaeumen. Jeder Tannenbaum hat eine unterschiedliche Farbe, Position und Baumgroesse");
        this.christmasTreeForestRadioButton.addActionListener(this);
    }

    private void initButtonGroup() {
        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(this.christmasTreeRadioButton);
        this.buttonGroup.add(this.christmasTreeForestRadioButton);
    }

    private void initCheckbox() {
        this.decoration = new JCheckBox("Verzierung");
        this.decoration.setToolTipText(
                "Fuegt den Baeumen Baumschmuck und Baumstaemme hinzu. Außerdem wird ein Sternenhimmel erstellt");
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
                this.status.setText("Tannenbaum plus Verzierung");
            } else {
                this.status.setText("Tannenbaum");
            }
        } else if (e.getSource() == this.christmasTreeForestRadioButton) {
            this.christmasTreeState = false;
            this.christmasTreeForestState = true;
            if (this.decorationState && this.christmasTreeForestState) {
                this.status.setText("Wald plus Verzierung");
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
