import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeihnachtsGUI extends JFrame {
    //frame resolution
    private final int width = 1280;
    private final int height = 720;
    //frame title
    private final String title = "WeihnachtsGUI";
    
    //main panel
    private JPanel backgroud;
    
    //christmas tree area panel
    private ChristmasTree christmasTree;

    //menu panel right next to the christmas tree area
    private JPanel menuPanel;

    //panel for the christmas card label and textfield
    private JPanel cardPanel;

    //parameter panel
    private JPanel parameterPanel;

    //christmascard label
    private JLabel christmasCardLabel;

    //status label
    private JLabel status;

    //christmas card textfield for the name of the receiver
    private JTextField name;

    //radio buttons for the christmas tree or a forest of christmas trees
    private JRadioButton christmasTreeRadioButton;
    private JRadioButton christmasTreeForestRadioButton;

    //button group for the two radio buttons
    private ButtonGroup buttonGroup;

    //checkbox for the decoration
    private JCheckBox decoration;

    //send button to confirm the inputs
    private JButton send;

    WeihnachtsGUI(){
        initComponents();
        addComponentsToMenuPanel();
        addComponentsToContainer();
        this.setVisible(true);

    }


    private void initComponents(){
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

    private void addComponentsToContainer(){
        this.setContentPane(this.backgroud);
        this.backgroud.add(this.menuPanel, BorderLayout.EAST);
        this.backgroud.add(this.christmasTree, BorderLayout.WEST);
        this.backgroud.add(this.status, BorderLayout.SOUTH);
       
    }

    private void addComponentsToMenuPanel(){
        //adds card label and textfield to the card panel
        this.cardPanel.add(this.christmasCardLabel);
        this.cardPanel.add(this.name);

        //adds the christmas tree, forest and decoration button to the parameterpanel
        this.parameterPanel.add(this.christmasTreeRadioButton);
        this.parameterPanel.add(this.christmasTreeForestRadioButton);
        this.parameterPanel.add(this.decoration);

        //adds the card panel, parameter panel and the send button to the menu panel
        this.menuPanel.add(this.cardPanel, BorderLayout.NORTH);
        this.menuPanel.add(this.parameterPanel, BorderLayout.CENTER);
        this.menuPanel.add(this.send, BorderLayout.SOUTH);
    }

    private void initFrame() {
        this.setSize(this.width, this.height);
        this.setTitle(this.title);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initChristmasTree(){
        this.christmasTree = new ChristmasTree();
    }

    private void initPanel(){
        //init background panel
        this.backgroud = new JPanel();
        this.backgroud.setSize(this.width, this.height);
        this.backgroud.setLayout(new BorderLayout());
        
        //init menupanel
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new BorderLayout());
        this.menuPanel.setPreferredSize(new Dimension(320, 720));

        //init cardpanel
        this.cardPanel = new JPanel();

        //init parameterpanel
        this.parameterPanel = new JPanel();
        this.parameterPanel.setLayout(new GridLayout(0,1));
        this.menuPanel.setPreferredSize(new Dimension(320, 50));
    }

    private void initLabel(){
        this.christmasCardLabel = new JLabel("Weihnachtskarte fuer");
        
        this.status = new JLabel("-");
    }

    private void initTextfield(){
        this.name = new JTextField("Enter name");
        this.name.setPreferredSize(new Dimension(150,20));
        //removes the text from the textbox if you click at it
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

    private void initRadioButton(){
        this.christmasTreeRadioButton = new JRadioButton("Tannenbaum");
        this.christmasTreeForestRadioButton = new JRadioButton("Wald");
    }

    private void initButtonGroup(){
        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(this.christmasTreeRadioButton);
        this.buttonGroup.add(this.christmasTreeForestRadioButton);
    }

    private void initCheckbox(){
        this.decoration = new JCheckBox("Verzierung");
    }

    private void initButton(){
        this.send = new JButton("Send");
    }





    private class ChristmasTree extends JPanel{
        private int modus;
        
        //resolution background
        private final int widthPanel = 960;
        private final int heigthPanel = 720;
        //color background
        private final Color bgColor = new Color(0,0,0);

        ChristmasTree(){
            //init panel
            this.setPreferredSize(new Dimension(this.widthPanel, this.heigthPanel));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.setColor(bgColor);
            g.fillRect(0, 0, this.widthPanel, this.heigthPanel);

        }
    }
}
