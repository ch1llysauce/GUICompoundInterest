package guicompoundinterest;

import guicompoundinterest.*;  // Import the Calculate class

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

public class GuiCompoundInterest extends JFrame implements ActionListener {

    private Map<Double, CalculateTime> calculates = new HashMap<>();
    private Map<Double, FinalAmount> calculatefin = new HashMap<>();
    private String time;
    private String finalamount;
    private String principalamount;
    private String Nominalrate;
    private JTextArea dispArea;
    private JPanel panelMain, panelAction;
    private JLabel lblTitle, lblStatus;
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
    
    public void LabelTabs(JLabel label){
        Font set = new Font("Arial", Font.PLAIN, 14);
        label.setFont(set);
        label.setForeground(new Color(0x1961dd));
    }

    private Color bgColor = new Color(0xCCF2C4);

    public void TFieldDesign(JTextField tField) {
        Font set = new Font("Arial", Font.PLAIN, 14);
        tField.setFont(set);
        tField.setForeground(new Color(0x1961dd));
    }

    //Main Window
    public GuiCompoundInterest() {
        // Main Frame Setup
        setTitle("Compound Interest Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);

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
        btnprinamount = new JButton("Principle Amount");
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

        // Add Components to Main Panel
        panelMain.add(lblTitle, BorderLayout.NORTH);
        panelMain.add(panelAction, BorderLayout.CENTER);
                
        // Add Main Panel to Frame
        add(panelMain, BorderLayout.CENTER);
        add(new JScrollPane(dispArea), BorderLayout.SOUTH);

        // Set Frame Visible
        // Set Frame Visible
        setVisible(true);
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
        setTitle("Time");
        TimeWindow.setSize(400, 400);
        TimeWindow.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);
        
        lblTitle = new JLabel("Solve for Time", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        LabelTabs(lblTitle);

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
        JTextField PrinAmountText = new JTextField();
        JTextField FinalAmountText = new JTextField();
        JTextField NomRateText = new JTextField();
        JTextField NumInterestText = new JTextField();
        TFieldDesign(PrinAmountText);
        TFieldDesign(FinalAmountText);
        TFieldDesign(NomRateText);
        TFieldDesign(NumInterestText);

        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);

        
        calculate.addActionListener(new ActionListener() {
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
        
        panel.add(PrincipalAmount);
        panel.add(FinalAmount);
        panel.add(NominalRate);
        panel.add(NumInterest);
        panel.add(PrinAmountText);
        panel.add(FinalAmountText);
        panel.add(NomRateText);
        panel.add(NumInterestText);
        panel.add(new JLabel());
        panel.add(calculate);
        panel.add(lblTitle, BorderLayout.NORTH);
        
        TimeWindow.add(panel);
        TimeWindow.setVisible(true);
      
    }
    
    
    private void showFinalAmountWindow(){
    JFrame FinalAmountWin = new JFrame("Final Amount");
        setTitle("Final Amount");
        FinalAmountWin.setSize(400, 400);
        FinalAmountWin.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);
        
        lblTitle = new JLabel("Solve for the Final Amount", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        LabelTabs(lblTitle);

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
        JTextField PrinAmountText = new JTextField();
        JTextField TimeText = new JTextField();
        JTextField NomRateText = new JTextField();
        JTextField NumInterestText = new JTextField();
        TFieldDesign(PrinAmountText);
        TFieldDesign(TimeText);
        TFieldDesign(NomRateText);
        TFieldDesign(NumInterestText);

        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);

        
        calculate.addActionListener(new ActionListener() {
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


                    JOptionPane.showMessageDialog(FinalAmountWin, "The time is: " + calculatefinal);
                } else {
                    JOptionPane.showMessageDialog(FinalAmountWin, "Invalid Input!");
                }
            }

        });
        
        panel.add(PrincipalAmount);
        panel.add(Time);
        panel.add(NominalRate);
        panel.add(NumInterest);
        panel.add(PrinAmountText);
        panel.add(TimeText);
        panel.add(NomRateText);
        panel.add(NumInterestText);
        panel.add(new JLabel());
        panel.add(calculate);
        panel.add(lblTitle, BorderLayout.NORTH);
        
        FinalAmountWin.add(panel);
        FinalAmountWin.setVisible(true);
          
    }

    
    private void showPrincipalAmountWindow(){
    JFrame PrinAmountWin = new JFrame("Principal Amount");
        setTitle("Principal Amount");
        PrinAmountWin.setSize(400, 400);
        PrinAmountWin.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);
        
        lblTitle = new JLabel("Solve for the Principal Amount", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        LabelTabs(lblTitle);

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
        JTextField FinalAmountText = new JTextField();
        JTextField TimeText = new JTextField();
        JTextField NomRateText = new JTextField();
        JTextField NumInterestText = new JTextField();
        TFieldDesign(FinalAmountText);
        TFieldDesign(TimeText);
        TFieldDesign(NomRateText);
        TFieldDesign(NumInterestText);

        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);

        
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!FinalAmountText.getText().isEmpty() && !TimeText.getText().isEmpty()
                        && !NomRateText.getText().isEmpty()
                        && !NumInterestText.getText().isEmpty()) {

                    double FinalAmount = Double.parseDouble(FinalAmountText.getText());
                    double Time = Double.parseDouble(TimeText.getText());
                    double NomRate = Double.parseDouble(NomRateText.getText());
                    double NumInterest = Double.parseDouble(NumInterestText.getText());

                    PrincipalAmount calculatePrin = new PrincipalAmount(FinalAmount, Time, NomRate, NumInterest);
                    
                    double PrincipalAmount = calculatePrin.calculatePrin();


                    JOptionPane.showMessageDialog(PrinAmountWin, "The Principal Amount is: " + calculatePrin);
                } else {
                    JOptionPane.showMessageDialog(PrinAmountWin, "Invalid Input!");
                }
            }

        });
        
        panel.add(FinalAmount);
        panel.add(Time);
        panel.add(NominalRate);
        panel.add(NumInterest);
        panel.add(FinalAmountText);
        panel.add(TimeText);
        panel.add(NomRateText);
        panel.add(NumInterestText);
        panel.add(new JLabel());
        panel.add(calculate);
        panel.add(lblTitle, BorderLayout.NORTH);
        
        PrinAmountWin.add(panel);
        PrinAmountWin.setVisible(true);
          
    }
    
    
    private void showNominalRateWindow(){
    JFrame NomRateWin = new JFrame("Nominal Rate");
        setTitle("Nominal Rate");
        NomRateWin.setSize(400, 400);
        NomRateWin.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelDesign(panel);
        
        lblTitle = new JLabel("Solve for the Nominal Rate", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0x2596be));
        LabelDesign(lblTitle);

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
        TFieldDesign(PrinAmountText);
        TFieldDesign(TimeText);
        TFieldDesign(FinalAmountText);
        TFieldDesign(NumInterestText);

        JButton calculate = new JButton("Calculate");
        ButtonDesign(calculate);

        
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!PrinAmountText.getText().isEmpty() && !TimeText.getText().isEmpty()
                        && !FinalAmountText.getText().isEmpty()
                        && !NumInterestText.getText().isEmpty()) {

                    double PrinAmount = Double.parseDouble(PrinAmountText.getText());
                    double Time = Double.parseDouble(TimeText.getText());
                    double FinalAmount = Double.parseDouble(FinalAmountText.getText());
                    double NumInterest = Double.parseDouble(NumInterestText.getText());

                    NominalRate calculateFinal = new NominalRate(PrinAmount, Time, FinalAmount, NumInterest);
                    
                    double NominalRate = calculateFinal.calculateFinal();


                    JOptionPane.showMessageDialog(NomRateWin, "The Principal Amount is: " + calculateFinal);
                } else {
                    JOptionPane.showMessageDialog(NomRateWin, "Invalid Input!");
                }
            }

        });
        
        panel.add(FinalAmount);
        panel.add(Time);
        panel.add(PrinAmount);
        panel.add(NumInterest);
        panel.add(PrinAmountText);
        panel.add(TimeText);
        panel.add(FinalAmountText);
        panel.add(NumInterestText);
        panel.add(new JLabel());
        panel.add(calculate);
        panel.add(lblTitle, BorderLayout.NORTH);
        
        NomRateWin.add(panel);
        NomRateWin.setVisible(true);
          
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiCompoundInterest();
            }
        });
    }

}
