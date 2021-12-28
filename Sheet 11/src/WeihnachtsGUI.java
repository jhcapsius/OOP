/**
 * With this class, you can draw a christmas card with different motives.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

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

    // background panel
    private JPanel backgroud;

    // christmas tree panel on the left side
    private Leinwand leinwand;

    // menu panel on the right side
    private JPanel menuPanel;

    // panel for the christmas card label and textfield
    private JPanel cardPanel;

    // panel for the parameter
    private JPanel paramPanel;

    // gridbagconstraints for the gridbaglayout
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

    // status for leinwand
    private boolean christmasTreeState;
    private boolean christmasTreeForestState;
    private boolean decorationState;

    /**
     * Private class Leinwand that acts as drawing ground
     */
    private class Leinwand extends JPanel {
        // status that tells the paint function which options have been selected
        private boolean christmasTreeState;
        private boolean christmasTreeForestState;
        private boolean decoration;

        // color codes
        private int r, g, b;

        // resolution of the leinwand panel
        private final int widthPanel = 960;
        private final int heigthPanel = 720;

        // color for the background
        private final Color bgColor = new Color(0, 0, 0);

        // christmas tree color
        private final Color christmasTreeColor = new Color(34, 139, 34);

        // log color
        private final Color logColor = new Color(139, 69, 19);

        // color stars
        private final Color starColor = new Color(255,255,255);

        // christmas tree coordinates first triangle
        private final int[] treeX = { 450, 480, 510 };
        private final int[] treeY = { 410, 360, 410 };

        // forest start coordinates of the first triangle
        private final int[] forestX = { 100, 130, 160 };
        private final int[] forestY = { 350, 300, 350 };

        // initial star coordianates
        private final int[] starX = { 30, 45, 50, 55, 70, 55, 50, 45 };
        private final int[] starY = { 30, 25, 10, 25, 30, 35, 50, 35 };

        /**
         * Constructor for the Leinwand class
         */
        Leinwand() {
            // init panel
            this.setPreferredSize(new Dimension(this.widthPanel, this.heigthPanel));
            this.christmasTreeState = false;
            this.christmasTreeForestState = false;
            this.decoration = false;
        }

        /**
         * draws the background and components
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            // draw background
            g.setColor(bgColor);
            g.fillRect(0, 0, this.widthPanel, this.heigthPanel);

            // draw single tree with decoration
            if (this.christmasTreeState && this.decoration) {
                // draw single christmas tree
                g.setColor(this.christmasTreeColor);
                g.fillPolygon(this.treeX, this.treeY, this.treeX.length);
                g.fillPolygon(new int[] { this.treeX[0] - 10, this.treeX[1], this.treeX[2] + 10 },
                        new int[] { this.treeY[0] + 25, this.treeY[1] + 25, this.treeY[2] + 25 }, this.treeX.length);
                g.fillPolygon(new int[] { this.treeX[0] - 20, this.treeX[1], this.treeX[2] + 20 },
                        new int[] { this.treeY[0] + 50, this.treeY[1] + 50, this.treeY[2] + 50 }, this.treeX.length);

                // draw christmas tree log
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
                        // creates random positions for each star
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
                // draw trees
                int y;
                int x;
                int minX = -10;
                int maxX = 10;
                int minY = -10;
                int maxY = 10;
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

                        // draws the trees
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

                        // draws the logs
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

            // draws a single christmas tree without decoration     
            } else if (this.christmasTreeState) {

                // draw tree
                g.setColor(this.christmasTreeColor);
                g.fillPolygon(this.treeX, this.treeY, 3);
                g.fillPolygon(new int[] { this.treeX[0] - 10, this.treeX[1], this.treeX[2] + 10 },
                        new int[] { this.treeY[0] + 25, this.treeY[1] + 25, this.treeY[2] + 25 }, this.treeX.length);
                g.fillPolygon(new int[] { this.treeX[0] - 20, this.treeX[1], this.treeX[2] + 20 },
                        new int[] { this.treeY[0] + 50, this.treeY[1] + 50, this.treeY[2] + 50 }, this.treeX.length);
            
            // draws a single christmas tree without decoration    
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

                        // creates random position for each tree
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

        /**
         * starter method the repaint the leinwand with the given options
         * @param cts status of christmas tree
         * @param ctfs status of christmastree forest
         * @param d status of decortion
         */
        public void drawCard(boolean cts, boolean ctfs, boolean d) {
            setState(cts, ctfs, d);
            repaint();
        }

        /**
         * setter method for the status of each option
         * @param cts status of christmas tree
         * @param ctfs status of christmastree forest
         * @param d status of decortion
         */
        private void setState(boolean cts, boolean ctfs, boolean d) {
            this.christmasTreeState = cts;
            this.christmasTreeForestState = ctfs;
            this.decoration = d;
        }
    }

    // starts the ui
    public void startGUI() {
        initComponents();
        addComponentsToMenuPanel();
        addComponentsToBackground();
        this.setVisible(true);

    }

    // initializes all components
    private void initComponents() {
        initFrame();
        initLeinwand();
        initPanel();
        initLabel();
        initTextfield();
        initRadioButton();
        initButtonGroup();
        initCheckbox();
        initButton();

    }

    /**
     * adds components to the background panel
     */
    private void addComponentsToBackground() {
        this.setContentPane(this.backgroud);
        this.backgroud.add(this.leinwand, BorderLayout.CENTER);
        this.backgroud.add(this.menuPanel, BorderLayout.EAST);
        this.backgroud.add(this.status, BorderLayout.SOUTH);

    }

    /**
     * adds components to the menu panel
     */
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

    /**
     * initializes the frame
     */
    private void initFrame() {
        this.setSize(this.width, this.height);
        this.setTitle(this.title);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * initializes the leinwand
     */
    private void initLeinwand() {
        this.leinwand = new Leinwand();
    }

    /**
     * initializes all panels
     */
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

        // init parameter panel
        this.paramPanel = new JPanel();
        this.paramPanel.setLayout(new GridBagLayout());
        this.paramPanel.setPreferredSize(new Dimension(320, 320));
        this.paramPanel.setBorder(BorderFactory.createTitledBorder("Parameter"));

    }

    /**
     * initializes all labels
     */
    private void initLabel() {
        // christmasCard Label
        this.christmasCardLabel = new JLabel("Weihnachtskarte fuer");
        this.christmasCardLabel.setToolTipText("Beschriftung des Textfeldes");
        
        // status label
        this.status = new JLabel("-");
        this.status.setToolTipText("Zeigt die aktuelle Auswahl an.");
    }

    /**
     * initializes the textfield
     */
    private void initTextfield() {
        this.name = new JTextField("Name eingeben...");
        this.name.setToolTipText("Hier kann der Name der Person, fuer die die Karte ist, eingegeben werden");
        this.name.setPreferredSize(new Dimension(150, 20));
        // removes the text from the textbox if you click at it
        
        //removes the content of the textfeld when clicked
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

    /**
     * initializes the radio buttons
     */
    private void initRadioButton() {
        // tannenbaum button
        this.christmasTreeRadioButton = new JRadioButton("Tannenbaum");
        this.christmasTreeRadioButton.setToolTipText("Zeichnet einen einzelnen Tannenbaum mittig der Karte");
        this.christmasTreeRadioButton.addActionListener(this);
        
        // wald button
        this.christmasTreeForestRadioButton = new JRadioButton("Wald");
        this.christmasTreeForestRadioButton.setToolTipText(
                "Zeichnet einen ganzen Wald bestehend aus Tannenbaeumen. Jeder Tannenbaum hat eine unterschiedliche Farbe, Position und Baumgroesse");
        this.christmasTreeForestRadioButton.addActionListener(this);
    }

    // initializes group button for tannenbaum and wald button
    private void initButtonGroup() {
        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(this.christmasTreeRadioButton);
        this.buttonGroup.add(this.christmasTreeForestRadioButton);
    }

    /**
     * initializes checkbox verzierung
     */
    private void initCheckbox() {
        this.decoration = new JCheckBox("Verzierung");
        this.decoration.setToolTipText(
                "Fuegt den Baeumen Baumschmuck und Baumstaemme hinzu. Außerdem wird ein Sternenhimmel erstellt");
        this.decoration.addActionListener(this);
    }

    /**
     * initializes send button
     */
    private void initButton() {
        this.send = new JButton("Send");
        this.send.setToolTipText("Bestaetigt die Auswahl und erstellt eine neue Karte");
        this.send.setSize(320, 20);
        this.send.addActionListener(this);
    }

    /**
     * action listener for the options and send button
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // sets status for tannen and tannenbaum plus verzierung
        if (e.getSource() == this.christmasTreeRadioButton) {
            this.christmasTreeState = true;
            this.christmasTreeForestState = false;
            if (this.decorationState && this.christmasTreeState) {
                this.status.setText("Tannenbaum plus Verzierung");
            } else {
                this.status.setText("Tannenbaum");
            }

        // sets status for wald and wald plus verzierung    
        } else if (e.getSource() == this.christmasTreeForestRadioButton) {
            this.christmasTreeState = false;
            this.christmasTreeForestState = true;
            if (this.decorationState && this.christmasTreeForestState) {
                this.status.setText("Wald plus Verzierung");
            } else {
                this.status.setText("Wald");
            }

        // sets status for decoration    
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
        
            // prints the chosen options    
        } else if (e.getSource() == this.send) {
            this.leinwand.drawCard(this.christmasTreeState, this.christmasTreeForestState, this.decorationState);
        }
    }
}
