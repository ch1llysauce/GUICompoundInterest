package guicompoundinterest;

import guicompoundinterest.*;  // Import classes

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public final class GuiCompoundInterest extends JFrame implements ActionListener {

    private JTextArea dispArea;
    private JPanel panelMain, panelAction;
    private JLabel lblTitle, lblName;
    private JButton btntime, btnfinalamount, btnprinamount, btnnomrate;

    public void ButtonDesign(JButton button) {
        button.setBackground(new Color(0x1961dd));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        Font set = new Font("Arial", Font.PLAIN, 14);
        button.setFont(set);
    }

    public void PanelDesign(JPanel panel) {
        panel.setBackground(Color.WHITE);
    }

    public void LabelDesign(JLabel label) {
        Font set = new Font("Arial", Font.BOLD, 20);
        label.setFont(set);
        label.setForeground(new Color(0x1961dd));
    }

    public void LabelTabs(JLabel label) {
        Font set = new Font("Arial", Font.BOLD, 14);
        label.setFont(set);
        label.setForeground(new Color(0x1961dd));
    }

    public void LabelName(JLabel label) {
        Font set = new Font("Arial", Font.PLAIN, 14);
        label.setFont(set);
        label.setForeground(new Color(0x1961dd));
    }

    private void jTextFieldKeyType(java.awt.event.KeyEvent evt){
    char c = evt.getKeyChar();
                
    if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){
    evt.consume();
        }
    }
    
    private Color bgColor = new Color(0xCCF2C4);

    public void TFieldDesign(JTextField tField) {
        Font set = new Font("Arial", Font.PLAIN, 14);
        tField.setFont(set);
        tField.setColumns(20);
        tField.setForeground(new Color(0x1961dd));

        this.add(tField);
        this.setVisible(true);
    }

    //Main Window
    public GuiCompoundInterest() {
        // Main Frame Setup
        setTitle("Compound Interest Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Initialize Panels
        panelMain = new JPanel(new BorderLayout());
        panelAction = new JPanel(new GridLayout(7, 1, 5, 5));
        PanelDesign(panelMain);
        PanelDesign(panelAction);

        // Initialize Labels
        lblTitle = new JLabel("Compound Interest Calculator", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 100));
        lblTitle.setForeground(new Color(0x1961dd));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        lblTitle.setPreferredSize(new Dimension(400, 150)); // Adjust this based on your needs
        LabelDesign(lblTitle);

        // Initialize Buttons
        btntime = new JButton("Time");
        btnfinalamount = new JButton("Final Amount");
        btnprinamount = new JButton("Principal Amount");
        btnnomrate = new JButton("Nominal Rate");

        ButtonDesign(btntime);
        ButtonDesign(btnfinalamount);
        ButtonDesign(btnprinamount);
        ButtonDesign(btnnomrate);

        // Set Button Action Listeners 
        btntime.addActionListener(this);
        btnfinalamount.addActionListener(this);
        btnprinamount.addActionListener(this);
        btnnomrate.addActionListener(this);

        // Add Components to Action Panel
        panelAction.add(btntime);
        panelAction.add(btnfinalamount);
        panelAction.add(btnprinamount);
        panelAction.add(btnnomrate);

        lblName = new JLabel("Made by: chillysauce!", SwingConstants.CENTER);
        lblName.setFont(new Font("Arial", Font.BOLD, 100));
        lblName.setForeground(new Color(0x1961dd));
        lblName.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        LabelName(lblName);

        // Add Components to Main Panel
        panelMain.add(lblTitle, BorderLayout.NORTH);
        panelMain.add(panelAction, BorderLayout.CENTER);
        panelMain.add(lblName, BorderLayout.SOUTH);

        // Add Main Panel to Frame
        add(panelMain, BorderLayout.CENTER);
        add(new JScrollPane(dispArea), BorderLayout.SOUTH);

        // Set Frame Visible
        // Set Frame Visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == btntime) {
            showTimeWindow();
        } else if (source == btnfinalamount) {
            showFinalAmountWindow();
        } else if (source == btnprinamount) {
            showPrincipalAmountWindow();
        } else if (source == btnnomrate) {
            showNominalRateWindow();
        }

    }

    private void showTimeWindow() {
        JFrame TimeWindow = new JFrame("Time");
        TimeWindow.setSize(400, 400);
        TimeWindow.setResizable(false);
        TimeWindow.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);

        lblTitle = new JLabel("Solve for Time", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelDesign(lblTitle);

        //Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0); //Space below the title
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        //Label Setup
        JLabel PrincipalAmount = new JLabel("Principal Amount: ");
        JLabel FinalAmount = new JLabel("Final Amount: ");
        JLabel NominalRate = new JLabel("Nominal Rate: ");
        JLabel NumInterest = new JLabel("Number of Interest: ");
        LabelTabs(PrincipalAmount);
        LabelTabs(FinalAmount);
        LabelTabs(NominalRate);
        LabelTabs(NumInterest);

        //Textfield Setup
        JTextField PrinAmountText = new JTextField(10);
        JTextField FinalAmountText = new JTextField(10);
        JTextField NomRateText = new JTextField(10);
        JTextField NumInterestText = new JTextField(10);

        //Adding Key Listeners to restrict input
        PrinAmountText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        FinalAmountText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NomRateText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NumInterestText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        Dimension textFieldSize = new Dimension(200, 25);
        PrinAmountText.setPreferredSize(textFieldSize);
        FinalAmountText.setPreferredSize(textFieldSize);
        NomRateText.setPreferredSize(textFieldSize);
        NumInterestText.setPreferredSize(textFieldSize);

        TFieldDesign(PrinAmountText);
        TFieldDesign(FinalAmountText);
        TFieldDesign(NomRateText);
        TFieldDesign(NumInterestText);

        //Setting up the labels and text fields in the grid
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(PrincipalAmount, gbc);

        gbc.gridx = 1;
        panel.add(PrinAmountText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(FinalAmount, gbc);

        gbc.gridx = 1;
        panel.add(FinalAmountText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(NominalRate, gbc);

        gbc.gridx = 1;
        panel.add(NomRateText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(NumInterest, gbc);

        gbc.gridx = 1;
        panel.add(NumInterestText, gbc);

        //Calculate Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0); //Space above button
        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);
        calculate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(calculate, gbc);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!PrinAmountText.getText().isEmpty() && !FinalAmountText.getText().isEmpty()
                        && !NomRateText.getText().isEmpty()
                        && !NumInterestText.getText().isEmpty()) {

                    double PrinAmount = Double.parseDouble(PrinAmountText.getText());
                    double FinalAmount = Double.parseDouble(FinalAmountText.getText());
                    double NomRate = Double.parseDouble(NomRateText.getText());
                    double NumInterest = Double.parseDouble(NumInterestText.getText());

                    CalculateTime calculate = new CalculateTime(PrinAmount, FinalAmount, NomRate, NumInterest);

                    double calculatedTime = calculate.calculateTime();

                    JOptionPane.showMessageDialog(TimeWindow, "The time is: " + calculatedTime);
                } else {
                    JOptionPane.showMessageDialog(TimeWindow, "Invalid Input!");
                }
            }

        });

        TimeWindow.add(panel, BorderLayout.CENTER);
        TimeWindow.setVisible(true);

    }

    private void showFinalAmountWindow() {
        JFrame FinalAmountWin = new JFrame("Final Amount");
        FinalAmountWin.setSize(400, 400);
        FinalAmountWin.setResizable(false);
        FinalAmountWin.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);

        lblTitle = new JLabel("Solve for the Final Amount", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelDesign(lblTitle);

        //Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0); //Space below the title
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        //Label Setup
        JLabel PrincipalAmount = new JLabel("Principal Amount: ");
        JLabel Time = new JLabel("Time (in years): ");
        JLabel NominalRate = new JLabel("Nominal Rate: ");
        JLabel NumInterest = new JLabel("Number of Interest: ");
        LabelTabs(PrincipalAmount);
        LabelTabs(Time);
        LabelTabs(NominalRate);
        LabelTabs(NumInterest);

        //Textfield Setup
        JTextField PrinAmountText = new JTextField(10);
        JTextField TimeText = new JTextField(10);
        JTextField NomRateText = new JTextField(10);
        JTextField NumInterestText = new JTextField(10);

        //Adding Key Listeners to restrict input
        PrinAmountText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        TimeText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NomRateText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NumInterestText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        Dimension textFieldSize = new Dimension(200, 25);
        PrinAmountText.setPreferredSize(textFieldSize);
        TimeText.setPreferredSize(textFieldSize);
        NomRateText.setPreferredSize(textFieldSize);
        NumInterestText.setPreferredSize(textFieldSize);

        TFieldDesign(PrinAmountText);
        TFieldDesign(TimeText);
        TFieldDesign(NomRateText);
        TFieldDesign(NumInterestText);

        //Setting up the labels and text fields in the grid
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(PrincipalAmount, gbc);

        gbc.gridx = 1;
        panel.add(PrinAmountText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(Time, gbc);

        gbc.gridx = 1;
        panel.add(TimeText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(NominalRate, gbc);

        gbc.gridx = 1;
        panel.add(NomRateText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(NumInterest, gbc);

        gbc.gridx = 1;
        panel.add(NumInterestText, gbc);

        //Calculate Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0); //Space above button
        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);
        calculate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(calculate, gbc);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!PrinAmountText.getText().isEmpty() && !TimeText.getText().isEmpty()
                        && !NomRateText.getText().isEmpty()
                        && !NumInterestText.getText().isEmpty()) {

                    double PrinAmount = Double.parseDouble(PrinAmountText.getText());
                    double Time = Double.parseDouble(TimeText.getText());
                    double NomRate = Double.parseDouble(NomRateText.getText());
                    double NumInterest = Double.parseDouble(NumInterestText.getText());

                    FinalAmount calculatefinal = new FinalAmount(PrinAmount, Time, NomRate, NumInterest);

                    double FinalAmount = calculatefinal.calculateFinal();

                    JOptionPane.showMessageDialog(FinalAmountWin, "The Final Amount is " + FinalAmount);
                } else {
                    JOptionPane.showMessageDialog(FinalAmountWin, "Invalid Input!");
                }
            }

        });

        FinalAmountWin.add(panel);
        FinalAmountWin.setVisible(true);

    }

    private void showPrincipalAmountWindow() {
        JFrame PrinAmountWin = new JFrame("Principal Amount");
        PrinAmountWin.setSize(400, 400);
        PrinAmountWin.setResizable(false);
        PrinAmountWin.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);

        lblTitle = new JLabel("Solve for the Principal Amount", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelDesign(lblTitle);

        //Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0); //Space below the title
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        //Label Setup
        JLabel FinalAmount = new JLabel("Final Amount: ");
        JLabel Time = new JLabel("Time (in years): ");
        JLabel NominalRate = new JLabel("Nominal Rate: ");
        JLabel NumInterest = new JLabel("Number of Interest: ");
        LabelTabs(FinalAmount);
        LabelTabs(Time);
        LabelTabs(NominalRate);
        LabelTabs(NumInterest);

        //Textfield Setup
        JTextField FinalAmountText = new JTextField(10);
        JTextField TimeText = new JTextField(10);
        JTextField NomRateText = new JTextField(10);
        JTextField NumInterestText = new JTextField(10);

        //Adding Key Listeners to restrict input
        FinalAmountText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        TimeText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NomRateText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NumInterestText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        
        Dimension textFieldSize = new Dimension(200, 25);// Width = 200 pixels, Height = 30 pixels
        FinalAmountText.setPreferredSize(textFieldSize);
        TimeText.setPreferredSize(textFieldSize);
        NomRateText.setPreferredSize(textFieldSize);
        NumInterestText.setPreferredSize(textFieldSize);

        TFieldDesign(FinalAmountText);
        TFieldDesign(TimeText);
        TFieldDesign(NomRateText);
        TFieldDesign(NumInterestText);

        //Setting up the labels and text fields in the grid
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(FinalAmount, gbc);

        gbc.gridx = 1;
        panel.add(FinalAmountText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(Time, gbc);

        gbc.gridx = 1;
        panel.add(TimeText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(NominalRate, gbc);

        gbc.gridx = 1;
        panel.add(NomRateText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(NumInterest, gbc);

        gbc.gridx = 1;
        panel.add(NumInterestText, gbc);

        //Calculate Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0); //Space above button
        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);
        calculate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(calculate, gbc);

        calculate.addActionListener(new ActionListener() {
            
            
            public void actionPerformed(ActionEvent e) {

                
                if (!FinalAmountText.getText().isEmpty() && !TimeText.getText().isEmpty()
                        && !NomRateText.getText().isEmpty()
                        && !NumInterestText.getText().isEmpty()) {

                    double FinalAmount = Double.parseDouble(FinalAmountText.getText());
                    double Time = Double.parseDouble(TimeText.getText());
                    double NomRate = Double.parseDouble(NomRateText.getText());
                    double NumInterest = Double.parseDouble(NumInterestText.getText());

                    PrincipalAmount calculate = new PrincipalAmount(FinalAmount, Time, NomRate, NumInterest);

                    double PrincipalAmount = calculate.calculatePrin();

                    JOptionPane.showMessageDialog(PrinAmountWin, "The Principal Amount is: " + PrincipalAmount);
                } else {
                    JOptionPane.showMessageDialog(PrinAmountWin, "Invalid Input!");
                }
            }

        });

        PrinAmountWin.add(panel);
        PrinAmountWin.setVisible(true);

    }

    private void showNominalRateWindow() {
        JFrame NomRateWin = new JFrame("Nominal Rate");
        NomRateWin.setSize(400, 400);
        NomRateWin.setResizable(false);
        NomRateWin.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);

        lblTitle = new JLabel("Solve for the Nominal Rate", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelDesign(lblTitle);

        //Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0); //Space below the title
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        //Label Setup
        JLabel FinalAmount = new JLabel("Final Amount: ");
        JLabel Time = new JLabel("Time (in years): ");
        JLabel PrinAmount = new JLabel("Principal Amount: ");
        JLabel NumInterest = new JLabel("Number of Interest: ");
        LabelTabs(FinalAmount);
        LabelTabs(Time);
        LabelTabs(PrinAmount);
        LabelTabs(NumInterest);

        //Textfield Setup
        JTextField PrinAmountText = new JTextField();
        JTextField TimeText = new JTextField();
        JTextField FinalAmountText = new JTextField();
        JTextField NumInterestText = new JTextField();

        //Adding Key Listeners to restrict input
        PrinAmountText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        TimeText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        FinalAmountText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        NumInterestText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                jTextFieldKeyType(evt);
            }
        });
        
        Dimension textFieldSize = new Dimension(200, 25);// Width = 200 pixels, Height = 30 pixels
        PrinAmountText.setPreferredSize(textFieldSize);
        FinalAmountText.setPreferredSize(textFieldSize);
        TimeText.setPreferredSize(textFieldSize);
        NumInterestText.setPreferredSize(textFieldSize);

        TFieldDesign(PrinAmountText);
        TFieldDesign(TimeText);
        TFieldDesign(FinalAmountText);
        TFieldDesign(NumInterestText);

        //Setting up the labels and text fields in the grid
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(FinalAmount, gbc);

        gbc.gridx = 1;
        panel.add(FinalAmountText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(Time, gbc);

        gbc.gridx = 1;
        panel.add(TimeText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(PrinAmount, gbc);

        gbc.gridx = 1;
        panel.add(PrinAmountText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(NumInterest, gbc);

        gbc.gridx = 1;
        panel.add(NumInterestText, gbc);

        //Calculate Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0); //Space above button
        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);
        calculate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(calculate, gbc);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!PrinAmountText.getText().isEmpty() && !TimeText.getText().isEmpty()
                        && !FinalAmountText.getText().isEmpty()
                        && !NumInterestText.getText().isEmpty()) {

                    double PrinAmount = Double.parseDouble(PrinAmountText.getText());
                    double Time = Double.parseDouble(TimeText.getText());
                    double FinalAmount = Double.parseDouble(FinalAmountText.getText());
                    double NumInterest = Double.parseDouble(NumInterestText.getText());

                    NominalRate calculate = new NominalRate(PrinAmount, Time, FinalAmount, NumInterest);

                    double NominalRate = calculate.calculateNomRate();

                    JOptionPane.showMessageDialog(NomRateWin, "The Principal Amount is: " + NominalRate);
                } else {
                    JOptionPane.showMessageDialog(NomRateWin, "Invalid Input!");
                }
            }

        });

        NomRateWin.add(panel);
        NomRateWin.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiCompoundInterest();
            }
        });
    }

}
