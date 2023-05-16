import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.MatteBorder;

/**
 * @author (Sushasan Hamal)
 * @version (1.1)
 */

//===============================BANK CARD=====================================/
public class BankGUI 
{
    //JFrame represent the main application window, which will contain and display various GUI components and layouts.
    JFrame frame, debcrd_frame, Credcrd_frame;

    //JPanel is a GUI component that functions as a container to hold other components
    JPanel panel;

    //Jlabels are described here
    JLabel bctitle,bcsub_title,debcrdtitle, debcrdsub_title, debcrdpinnumber, debcrdwithdrawamount, debcrddateofwithdraw, 
    debcrdclientname, debcrdbalanceamount, debcrdcardid, debcrdbankaccount, debcrdissuerbank,
    credcrdtitle, credcrdsub_title, credcrdbankaccount, credcrdbalanceamount, credcrdclientname, credcrdcardid, credcrdissuerbank,
    credcrdcvcnmb, credcrdinterestrate, credcrdexpirationdate, credcrdcredlimit, credcrdgraceperiod, credcrdday;

    //JTextfield are described here
    JTextField debcrdtxtfieldpinnumber,debcrdtxtfieldwithdrawamount,debcrdtxtfieldwithdrawalamount,debcrdtxtfieldclientname,
    debcrdtxtfieldbalanceamount,debcrdtxtfieldcardid,debcrdtxtfieldbankaccount,debcrdtxtfieldissuerbank, credcrdtxtfieldcardid, 
    credcrdtxtfieldissuerbank, credcrdtxtfieldbankaccount, credcrdtxtfieldbalanceamount,credcrdtxtfieldclientname, 
    credcrdtxtfieldcvcnumber, credcrdtxtfieldinterestrate, credcrdtxtfieldcredlimit;

    //JButton are described here
    JButton bcdebit_card,bccredit_card,bcexitid,debcrdwithdrawdc,debcrdclear,debcrddisplay,
    debcrdaddtodebcrd,debcrdchngcredcrd,debcrdbtnmainmenu,debcrdexitid, credcrdaddcredcard, 
    credcrdcancel, credcrdsetcredlimit, credcrdclear, credcrddisplay, credcrdchngdebcrd, credcrdbtnmainmenu, credcrdexitid;

    //Combobox are descrided here
    JComboBox <Integer>debcrdday,debcrdyear, credcrdexpday,credcrdgraceday,credcrdyear;
    JComboBox <String> debcrdmonth,credcrdmonth;

    //ArrayList is declared here
    ArrayList<BankCard> arraybank = new ArrayList<BankCard>();

    public BankGUI()
    {
        JFrame Bankcard_frame = new JFrame("Main Menu");
        JPanel panel = new JPanel();

        //setting the logo
        JLabel label = new JLabel(); // Create a new JLabel object
        Bankcard_frame.add(label);
        label.setBounds (340,195,236,160);
        ImageIcon icon = new ImageIcon("logo.png");        
        label.setIcon(icon);

        //Label are added here
        bctitle = new JLabel("Bespoke Bank");
        bcsub_title = new JLabel("Handmade for you");

        //button are added here 
        bcdebit_card = new JButton("Debit Card");
        bccredit_card = new JButton("Credit Card");
        bcexitid = new JButton("Exit");

        //Label are added to the panel here
        panel.add(bctitle);
        panel.add(bcsub_title);
        panel.add(bcdebit_card);
        panel.add(bccredit_card);
        panel.add(bcexitid);

        //Font it's weight and size is set here
        bctitle.setFont(new Font("Helvetica", 26, 26));
        bcsub_title.setFont(new Font("Arial", 18, 13));

        //Bounds of button in the panel is set here
        bctitle.setBounds(345,20,230,25);
        bcsub_title.setBounds (371,45,115,20);
        bcdebit_card.setBounds (95,147,156,44);
        bccredit_card.setBounds (648,147,156,44);
        bcexitid.setBounds (354,436,156,64);

        //Purple color is set background of the buttons
        bcdebit_card.setBackground(new Color(128, 0, 128));
        bccredit_card.setBackground(new Color(128, 0, 128));
        bcexitid.setBackground(new Color(128, 0, 128));

        //For loop is used to make the button font white 
        for (JButton button : new JButton[]{ bcdebit_card,bccredit_card,bcexitid}) 
        {
            button.setForeground(Color.WHITE);
        }

        // Add an action listener to the Debit Card button
        bcdebit_card.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Create a new instance of the debit card frame and make it visible
                    debitcard();
                    Bankcard_frame.dispose(); 
                }
            });

        // Add an action listener to the Credit Card button
        bccredit_card.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Create a new instance of the Credit Card frame and make it visible
                    creditcard();
                    Bankcard_frame.dispose(); 
                }
            });    

        //Add an action listener to the Exit button to exit the program
        bcexitid.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    System.exit(0);
                }
            });

        panel.setLayout(null);
        Bankcard_frame.add(panel);
        Bankcard_frame.setResizable(false);
        Bankcard_frame.setVisible(true);
        Bankcard_frame.setSize(877,550);
        Bankcard_frame.setLocationRelativeTo(null);//sets the frame to the middel
        panel.setBackground(new Color(44, 120, 115)); // backgound of the panel is set gray 
        Bankcard_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //===============================DEBIT CARD=====================================//
    public void debitcard()
    {
        JPanel panel, debcrdlinePanel,leftpanel;
        // Creating a new JFrame and JPanel
        debcrd_frame = new JFrame("DebitCard");
        panel = new JPanel();

        //create new JPanel for the line
        debcrdlinePanel = new JPanel(); 
        debcrd_frame.add(panel);
        panel.setLayout(null);

        //add debcrdlinepanel to the panel
        panel.add(debcrdlinePanel);
        debcrdlinePanel.setLayout(null);

        //Add vertical line between fields
        debcrdlinePanel.setBounds(227, 0, 4, 550);

        // set MatteBorder as border for linePanel
        debcrdlinePanel.setBorder(new MatteBorder(0, 2, 0, 0, Color.green)); 

        //setting the logo
        JLabel debcrdimglabel = new JLabel(); // Create a new JLabel object
        panel.add(debcrdimglabel);
        debcrdimglabel.setBounds (678,9,180,107);
        ImageIcon debcrdicon = new ImageIcon("logo.png ");        
        debcrdimglabel.setIcon(debcrdicon);

        //Labels are added here
        debcrdtitle = new JLabel ("Bespoke Bank");
        debcrdsub_title = new JLabel ("Debit Cards made for you");
        debcrdclientname = new JLabel("Client Name:");
        debcrdissuerbank = new JLabel("Issuer Bank:");
        debcrdbankaccount = new JLabel("Bank Account");
        debcrdcardid = new JLabel("Card Id:");
        debcrdpinnumber = new JLabel("Pin Number:");
        debcrdwithdrawamount = new JLabel("Withdrawal Amount:");
        debcrddateofwithdraw = new JLabel("Date of Withdrawal:");
        debcrdbalanceamount = new JLabel("Balance Amount:");

        //Panel is added here for all the labels
        panel.add(debcrdtitle);
        panel.add(debcrdsub_title);
        panel.add(debcrdpinnumber);
        panel.add(debcrdwithdrawamount);
        panel.add(debcrddateofwithdraw);
        panel.add(debcrdclientname);
        panel.add(debcrdbalanceamount);
        panel.add(debcrdcardid);
        panel.add(debcrdbankaccount);
        panel.add(debcrdissuerbank);

        //Bounds of the labels in the panel are set here
        debcrdtitle.setBounds(24,0,168,33);
        debcrdsub_title.setBounds(24,48,160,22);
        debcrdbankaccount.setBounds(267,36,93,20);
        debcrdbalanceamount.setBounds(267,81,110,20);
        debcrdclientname.setBounds(250,140,85,20);        
        debcrdissuerbank.setBounds(250,189,82,20);
        debcrdcardid.setBounds(597,140,54,20);
        debcrdpinnumber.setBounds(583,188,82,20);
        debcrdwithdrawamount.setBounds(295,315,128,20);
        debcrddateofwithdraw.setBounds(423,370,126,20);

        //Font it's weight and size is set here
        debcrdtitle.setFont(new Font("Helvetica", 26, 26));
        debcrdsub_title.setFont(new Font("Arial", 18, 13));

        //Adding Textfield 
        debcrdtxtfieldclientname = new JTextField();
        debcrdtxtfieldissuerbank = new JTextField();
        debcrdtxtfieldbankaccount = new JTextField();
        debcrdtxtfieldcardid = new JTextField();
        debcrdtxtfieldpinnumber = new JTextField();
        debcrdtxtfieldwithdrawalamount = new JTextField();
        debcrdtxtfieldbalanceamount = new JTextField();

        //Panel is added here for all the Text Field
        panel.add(debcrdtxtfieldpinnumber);
        panel.add(debcrdtxtfieldbalanceamount);
        panel.add(debcrdtxtfieldcardid);
        panel.add(debcrdtxtfieldbankaccount);
        panel.add(debcrdtxtfieldissuerbank);
        panel.add(debcrdtxtfieldwithdrawalamount);
        panel.add(debcrdtxtfieldclientname);

        //Bounds of textfield in the panel is set here
        debcrdtxtfieldbankaccount.setBounds(380,36,244,24); 
        debcrdtxtfieldbalanceamount.setBounds(380,88,252,24);
        debcrdtxtfieldclientname.setBounds(351,140,180,32);
        debcrdtxtfieldissuerbank.setBounds(351,185,180,32);
        debcrdtxtfieldcardid.setBounds(678,140,180,32); 
        debcrdtxtfieldpinnumber.setBounds(678,188,180,32);
        debcrdtxtfieldwithdrawalamount.setBounds(453,311,180,32);      

        //Adding button 
        debcrdaddtodebcrd = new JButton("Add to Debit Card");
        debcrdwithdrawdc = new JButton("Withdraw");
        debcrddisplay = new JButton("Display");
        debcrdclear = new JButton("Clear");
        debcrdchngcredcrd = new JButton("Change to Credit Card");
        debcrdbtnmainmenu = new JButton("Back to Main Menu");
        debcrdexitid = new JButton("EXIT");

        //Panel is added here for all the Buttons
        panel.add(debcrdaddtodebcrd);
        panel.add(debcrdwithdrawdc);
        panel.add(debcrdclear);
        panel.add(debcrddisplay); 
        panel.add(debcrdchngcredcrd);
        panel.add(debcrdbtnmainmenu);
        panel.add(debcrdexitid);

        //Purple color is set background of the buttons
        for (JButton button : new JButton[]{debcrdaddtodebcrd, debcrdwithdrawdc, debcrddisplay, debcrdclear, debcrdchngcredcrd, debcrdbtnmainmenu, debcrdexitid}) 
        {
            button.setBackground (new Color(128, 0, 128));
        }

        //For loop is used to make the button font white 
        for (JButton button : new JButton[]{debcrdaddtodebcrd, debcrdwithdrawdc, debcrddisplay, debcrdclear, debcrdchngcredcrd, debcrdbtnmainmenu, debcrdexitid}) 
        {
            button.setForeground(Color.WHITE);
        }

        //Bounds of button in the panel is set here
        debcrdaddtodebcrd.setBounds(366,244,299,32);
        debcrdwithdrawdc.setBounds(366,458,251,32);
        debcrddisplay.setBounds(35,108,120,32);
        debcrdclear.setBounds(35,183,120,32);
        debcrdchngcredcrd.setBounds(20,258,178,32);
        debcrdbtnmainmenu.setBounds(20,338,178,32);
        debcrdexitid.setBounds(20,413,178,56);

        //Adding string for ComboBox
        Integer cbday[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        String cbmonth [] = {"January","February","March","April","May","June","July","August","September","October",
                "November","December"};
        Integer cbyear [] = {2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033};

        //Combobox are added here
        debcrdday = new JComboBox <Integer> (cbday);
        debcrdmonth = new JComboBox <String>(cbmonth);
        debcrdyear = new JComboBox <Integer> (cbyear);

        //Panel is added here for all the ComboBox
        panel.add(debcrdday);
        panel.add(debcrdmonth);
        panel.add(debcrdyear);

        //Bounds of ComboBox in the panel is set here
        debcrdday.setBounds(327,402,77,32);
        debcrdmonth.setBounds(417,402,91,32);
        debcrdyear.setBounds(521,402,90,32);

        // Add an action listener to the Credit Card button
        debcrdchngcredcrd.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Create a new instance of the Credit Card frame 
                    creditcard();
                    debcrd_frame.dispose(); 
                }
            });    

        debcrdbtnmainmenu.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Create a new instance of the Bank Card frame 
                    new BankGUI();
                    debcrd_frame.dispose(); 
                }
            });    

        //Add an action listener to the Exit button to exit the program
        debcrdexitid.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    System.exit(0);
                }
            });

        /**Debit card Clear button is set here**/
        debcrdclear.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if (arraybank.size() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "No Inputs to Clear", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    else 
                    {
                        debcrdtxtfieldcardid.setText("");
                        debcrdtxtfieldclientname.setText("");
                        debcrdtxtfieldissuerbank.setText("");
                        debcrdtxtfieldbankaccount.setText("");
                        debcrdtxtfieldbalanceamount.setText("");
                        debcrdtxtfieldpinnumber.setText("");
                        debcrdday.setSelectedIndex(0);
                        debcrdmonth.setSelectedIndex(0);
                        debcrdyear.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(frame, "All the inputs have been cleared out", "Cleared Out", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

        /**Debit Card is added here**/
        debcrdaddtodebcrd.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    boolean valid = true; // initialize flag
                    // check for empty fields
                    if (debcrdtxtfieldcardid.getText().isEmpty() || debcrdtxtfieldclientname.getText().isEmpty() 
                    ||debcrdtxtfieldissuerbank.getText().isEmpty()|| debcrdtxtfieldbankaccount.getText().isEmpty() 
                    || debcrdtxtfieldbalanceamount.getText().isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "Required Field Must be filled!", "Empty Field", JOptionPane.ERROR_MESSAGE); 
                        valid = false; 
                    }
                    // if true create object
                    if (valid) 
                    {
                        try 
                        {
                            int balanceAmount = Integer.parseInt(debcrdtxtfieldbalanceamount.getText());
                            int cardId = Integer.parseInt(debcrdtxtfieldcardid.getText());
                            String bankAccount = debcrdtxtfieldbankaccount.getText();
                            String issuerBank = debcrdtxtfieldissuerbank.getText();
                            String clientName = debcrdtxtfieldclientname.getText();
                            int pinNumber = Integer.parseInt(debcrdtxtfieldpinnumber.getText());

                            if (balanceAmount < 0 || cardId < 0 || pinNumber < 0) 
                            {
                                JOptionPane.showMessageDialog(frame, "Values cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            boolean cardIdExists = false;// check flag for existing card ID
                            for (BankCard card : arraybank) 
                            {
                                if (card instanceof DebitCard && card.getCardId() == cardId) 
                                {
                                    cardIdExists = true;
                                    break;
                                }
                            }
                            if (cardIdExists) 
                            {
                                JOptionPane.showMessageDialog(frame, "Card with the given ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                            } 
                            else 
                            {
                                BankCard objdebit = new DebitCard(balanceAmount, cardId, bankAccount, issuerBank, clientName, pinNumber);
                                arraybank.add(objdebit);
                                JOptionPane.showMessageDialog(frame, "Values have been stored", "Values", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } 
                        catch (NumberFormatException ex) 
                        {
                            debcrdtxtfieldbalanceamount.setText("");
                            debcrdtxtfieldcardid.setText("");
                            debcrdtxtfieldbankaccount.setText("");
                            debcrdtxtfieldissuerbank.setText("");
                            debcrdtxtfieldclientname.setText("");
                            debcrdtxtfieldpinnumber.setText("");
                            JOptionPane.showMessageDialog(frame, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                        } 
                        catch (NullPointerException ex) 
                        {
                            JOptionPane.showMessageDialog(frame, "Values are null", "System Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        /** Debit Card Display **/
        debcrddisplay.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if (arraybank.size() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "Nothing to Display", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    else 
                    {
                        for (BankCard display : arraybank)
                        {
                            if (display instanceof DebitCard) 
                            {
                                DebitCard debitCard = (DebitCard) display;
                                System.out.println("Card ID: " + debitCard.getCardId());
                                System.out.println("Client Name: " + debitCard.getClientName());
                                System.out.println("Issuer Bank: " + debitCard.getIssuerBank());
                                System.out.println("Bank Account: " + debitCard.getBankAccount());
                                System.out.println("Balance Amount: " + debitCard.getBalanceAmount());
                                System.out.println("PIN Number: " + debitCard.getPinNumber());
                                System.out.println();
                            }
                        }
                    }
                }
            });

        /**Debit Card withdrawal**/
        debcrdwithdrawdc.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    boolean fieldvalid = true; //check flag
                    if (debcrdwithdrawamount.getText().isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "Required Field Must be filled!", "Empty Field", JOptionPane.ERROR_MESSAGE);
                        fieldvalid = false; 
                    }
                    if (fieldvalid) 
                    {
                        if (arraybank.size() == 0) 
                        {
                            JOptionPane.showMessageDialog(frame, "No Balance to Withdraw", "Error", JOptionPane.ERROR_MESSAGE);
                        } 
                        else 
                        {
                            try 
                            {
                                int withdrawalamount = Integer.parseInt(debcrdtxtfieldwithdrawalamount.getText());
                                String day = (String) debcrdday.getSelectedItem().toString();
                                String month = (String) debcrdmonth.getSelectedItem().toString();
                                String year = (String) debcrdyear.getSelectedItem().toString();
                                String datewithdrawal = day + "/" + month + "/" + year;
                                int pinnumber = Integer.parseInt(debcrdtxtfieldpinnumber.getText());
                                int cardid = Integer.parseInt(debcrdtxtfieldcardid.getText());
                                boolean foundcard = false; //check flag is added here 

                                if (withdrawalamount < 0) 
                                {
                                    JOptionPane.showMessageDialog(frame, "Values cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                                for (BankCard withdraw : arraybank) 
                                {
                                    if (withdraw instanceof DebitCard) 
                                    { 
                                        int cardID = withdraw.getCardId();
                                        String clientName = withdraw.getClientName();
                                        String issuerBank = withdraw.getIssuerBank();
                                        String bankAccount = withdraw.getBankAccount();
                                        int balanceAmount = withdraw.getBalanceAmount();

                                        if (cardID == cardid) 
                                        {
                                            foundcard = true; //check flag is set true here
                                            DebitCard debit = (DebitCard) withdraw;
                                            debit.withdraw(withdrawalamount,datewithdrawal,pinnumber);
                                            System.out.println("");
                                        }
                                    }
                                } 
                                if (!foundcard) 
                                {
                                    JOptionPane.showMessageDialog(frame, "Credit card with the given ID has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } 
                            catch(NumberFormatException ex) 
                            {
                                debcrdtxtfieldwithdrawamount.setText("");
                                JOptionPane.showMessageDialog(frame, "Invalid input, please enter numeric values only","Error", JOptionPane.ERROR_MESSAGE);
                            } 
                            catch (NullPointerException ex) 
                            {
                                JOptionPane.showMessageDialog(frame, "Values are null", "System Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            });

        debcrd_frame.add(panel);
        debcrd_frame.setResizable(false);
        debcrd_frame.setVisible(true);
        debcrd_frame.setSize(880,550);
        debcrd_frame.setLocationRelativeTo(null);//sets the frame to the middel
        debcrd_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } 

    //================================CREDIT CARD=====================================// 
    public void creditcard()
    {
        JPanel panel , credcrdlinepanel;

        //Creating a new JFrame and JPanel 
        Credcrd_frame = new JFrame("Credit Card");
        panel = new JPanel();

        //create new JPanel for the line
        credcrdlinepanel = new JPanel(); 

        //add linePanel to the frame
        Credcrd_frame.add(credcrdlinepanel);   

        //Add vertical line between fields
        credcrdlinepanel.setBounds(227, 0, 4, 617);

        //set MatteBorder as border for linePanel
        credcrdlinepanel.setBorder(new MatteBorder(10, 10, 10, 0, Color.gray)); 

        //setting the logo
        JLabel label = new JLabel(); // Create a new JLabel object
        Credcrd_frame.add(label);
        label.setBounds (678,21,180,107);
        ImageIcon icon = new ImageIcon("logo.png");        
        label.setIcon(icon);

        //Labels are added here
        credcrdtitle = new JLabel("Bespoke Bank");
        credcrdsub_title = new JLabel("Credit Cards made for you");
        credcrdbankaccount = new JLabel("Bank Account:");
        credcrdbalanceamount = new JLabel("Balance Amount:");
        credcrdclientname = new JLabel("Client Name:");
        credcrdcardid = new JLabel("Card Id:");
        credcrdissuerbank = new JLabel("Issuer Bank:");
        credcrdcvcnmb = new JLabel("CVC Number:");
        credcrdinterestrate = new JLabel("Interest Rate:");
        credcrdexpirationdate = new JLabel("Expiration Date:");
        credcrdcredlimit = new JLabel("Credit Limit:");
        credcrdgraceperiod = new JLabel("Grace Period:");
        credcrdday = new JLabel("Day");

        //Panel is added here for all the labels
        panel.add(credcrdtitle);
        panel.add(credcrdsub_title);
        panel.add(credcrdbankaccount);
        panel.add(credcrdbalanceamount);
        panel.add(credcrdclientname);
        panel.add(credcrdcardid);
        panel.add(credcrdissuerbank);
        panel.add(credcrdcvcnmb);
        panel.add(credcrdinterestrate);
        panel.add(credcrdexpirationdate);
        panel.add(credcrdcredlimit);
        panel.add(credcrdgraceperiod);
        panel.add(credcrdday);

        //Bounds of the label in the panel is set here 
        credcrdtitle.setBounds(24, 0, 168, 33);
        credcrdsub_title.setBounds(24, 48, 160, 22);
        credcrdbankaccount.setBounds(267, 36, 93, 20);
        credcrdbalanceamount.setBounds(267, 81, 110, 20);
        credcrdclientname.setBounds(250, 140, 85, 20);
        credcrdissuerbank.setBounds(250, 189, 82, 20);
        credcrdcardid.setBounds(278, 238, 54, 20);
        credcrdcvcnmb.setBounds(570, 234, 91, 20);
        credcrdinterestrate.setBounds(570, 185, 88, 20);
        credcrdexpirationdate.setBounds(284, 279, 104, 20);
        credcrdcredlimit.setBounds(253, 448, 79, 20);
        credcrdgraceperiod.setBounds(264, 500, 90, 20);
        credcrdday.setBounds(498, 499, 54, 26);

        //Font it's weight and size is set here
        credcrdtitle.setFont(new Font("Helvetica", 26, 26));
        credcrdsub_title.setFont(new Font("Arial", 18, 13));

        //Adding Textfield 
        credcrdtxtfieldcardid = new JTextField();
        credcrdtxtfieldissuerbank = new JTextField();
        credcrdtxtfieldbankaccount = new JTextField();
        credcrdtxtfieldbalanceamount = new JTextField();
        credcrdtxtfieldclientname = new JTextField();
        credcrdtxtfieldcvcnumber = new JTextField();
        credcrdtxtfieldinterestrate = new JTextField();
        credcrdtxtfieldcredlimit = new JTextField();

        //Panel is added here for all the Text Field
        panel.add(credcrdtxtfieldcardid);
        panel.add(credcrdtxtfieldissuerbank);
        panel.add(credcrdtxtfieldbankaccount);
        panel.add(credcrdtxtfieldbalanceamount);
        panel.add(credcrdtxtfieldclientname);
        panel.add(credcrdtxtfieldcvcnumber);
        panel.add(credcrdtxtfieldinterestrate);
        panel.add(credcrdtxtfieldcredlimit);

        //Bounds of textfield in the panel is set here
        credcrdtxtfieldbankaccount.setBounds(388,36,244,24);
        credcrdtxtfieldbalanceamount.setBounds(388,81,252,24);
        credcrdtxtfieldclientname.setBounds(351,133,233,31);
        credcrdtxtfieldissuerbank.setBounds(351,185,180,24);
        credcrdtxtfieldcardid.setBounds(349,230,180,24);
        credcrdtxtfieldcvcnumber.setBounds(678,234,180,24);
        credcrdtxtfieldinterestrate.setBounds(678,185,180,24);
        credcrdtxtfieldcredlimit.setBounds(349,444,180,24);

        //Adding button 
        credcrdaddcredcard = new JButton("Add to Credit Card");
        credcrdcancel = new JButton("Cancel Credit Limit");
        credcrdsetcredlimit = new JButton("Set Credit Limit");
        credcrdclear = new JButton("Clear");
        credcrddisplay = new JButton("Dispaly");
        credcrdchngdebcrd = new JButton("Change to Debit Card");
        credcrdbtnmainmenu = new JButton("Back to Main Menu");
        credcrdexitid = new JButton("EXIT");

        //Setting Background and Foreground colour purple and white respectively
        for (JButton button : new JButton[] {credcrdaddcredcard, credcrdcancel, credcrdsetcredlimit,
            credcrdclear, credcrddisplay, credcrdchngdebcrd, credcrdbtnmainmenu, credcrdexitid}) 
        {
            button.setBackground(new Color (128, 0, 128));
        }

        for (JButton button : new JButton[] {credcrdaddcredcard, credcrdcancel, credcrdsetcredlimit,
            credcrdclear, credcrddisplay, credcrdchngdebcrd, credcrdbtnmainmenu, credcrdexitid}) 
        {
            button.setForeground(Color.white);
        }

        //Panel is added here for all the Buttons
        panel.add(credcrdaddcredcard);
        panel.add(credcrdcancel);
        panel.add(credcrdsetcredlimit);
        panel.add(credcrdclear);
        panel.add(credcrddisplay);
        panel.add(credcrdchngdebcrd);
        panel.add(credcrdbtnmainmenu);
        panel.add(credcrdexitid);

        //Bounds of button in the panel is set here
        credcrdaddcredcard.setBounds(349,380,298,37);
        credcrdcancel.setBounds(20,292,170,32);
        credcrdsetcredlimit.setBounds(351,566,251,38);
        credcrdclear.setBounds(20,199,170,32);
        credcrddisplay.setBounds(20,106,170,32);
        credcrdchngdebcrd.setBounds(12,385,178,32);
        credcrdbtnmainmenu.setBounds(12,478,178,32);
        credcrdexitid.setBounds(12,566,178,43);

        //Adding string for ComboBox
        Integer cbday  [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        Integer grcday [] = {10,20,30,40,50,60,70,80,90,100};
        String cbmonth [] = {"January","Febuary","March","April","May","June","July","August","September","October",
                "November","December"};
        Integer cbyear [] = {2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033};

        //Combobox are added here
        credcrdexpday = new JComboBox <Integer> (cbday);
        credcrdgraceday = new JComboBox <Integer> (grcday);
        credcrdmonth  = new JComboBox <String> (cbmonth);
        credcrdyear = new JComboBox <Integer> (cbyear);

        //Panel is added here for all the ComboBox
        panel.add(credcrdexpday);
        panel.add(credcrdgraceday);
        panel.add(credcrdmonth);
        panel.add(credcrdyear);

        //Bounds of ComboBox in the panel is set here
        credcrdexpday.setBounds(349,316,77,32);
        credcrdgraceday.setBounds(400,494,77,32);
        credcrdmonth.setBounds(446,316,91,32);
        credcrdyear.setBounds(557,316,90,32);

        // Add an action listener to the Debit Card button
        credcrdchngdebcrd.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Create a new instance of the Debit Card frame and make it visible
                    debitcard();
                    Credcrd_frame.dispose(); 
                }
            });

        credcrdbtnmainmenu.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Create a new instance of the Debit Card frame and make it visible
                    new BankGUI();
                    Credcrd_frame.dispose(); 
                }
            });   

        //Add an action listener to the Exit button to exit the program
        credcrdexitid.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    System.exit(0);
                }
            });

        /**Clear Credit Card**/
        credcrdclear.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if (arraybank.size() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "No Inputs to Clear", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    else 
                    {
                        credcrdtxtfieldcardid.setText("");
                        credcrdtxtfieldclientname.setText("");
                        credcrdtxtfieldissuerbank.setText("");
                        credcrdtxtfieldbankaccount.setText("");
                        credcrdtxtfieldbalanceamount.setText("");
                        credcrdtxtfieldcvcnumber.setText("");
                        credcrdtxtfieldinterestrate.setText("");
                        credcrdtxtfieldcredlimit.setText("");
                        credcrdexpday.setSelectedIndex(0);
                        credcrdmonth.setSelectedIndex(0);
                        credcrdyear.setSelectedIndex(0);
                        credcrdgraceday.setSelectedIndex(0);

                        JOptionPane.showMessageDialog(frame, "All the inputs have been cleared out", "Cleared Out", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

        /**Display Credit Card**/
        credcrddisplay.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if (arraybank.size() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "Nothing to display", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    else 
                    {
                        for (BankCard creddisplay : arraybank)
                        {
                            if (creddisplay instanceof CreditCard) 
                            {
                                CreditCard creditCard = (CreditCard) creddisplay;
                                System.out.println("Card ID: " + creditCard.getCardId());
                                System.out.println("Client Name: " + creditCard.getClientName());
                                System.out.println("Issuer Bank: " + creditCard.getIssuerBank());
                                System.out.println("Bank Account: " + creditCard.getBankAccount());
                                System.out.println("Balance Amount: " + creditCard.getBalanceAmount());
                                System.out.println("CVC Number: " + creditCard.getCvcNumber());
                                System.out.println("Interest Rate: " + creditCard.getInterestRate());
                                System.out.println("Expiration Date: " + creditCard.getExpirationDate());
                                System.out.println("Grace period: " + creditCard.getGracePeriod());
                                System.out.println("Credit Limit: " + creditCard.getCreditLimit());
                                System.out.println();
                            }
                        }
                    }
                }
            });

        /**Add to Credit Card**/
        credcrdaddcredcard.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    boolean valid = true; //check flag
                    if (credcrdtxtfieldcardid.getText().isEmpty() || credcrdtxtfieldclientname.getText().isEmpty() 
                    || credcrdtxtfieldissuerbank.getText().isEmpty() || credcrdtxtfieldbankaccount.getText().isEmpty() 
                    || credcrdtxtfieldbalanceamount.getText().isEmpty() || credcrdtxtfieldcvcnumber.getText().isEmpty() 
                    || credcrdtxtfieldinterestrate.getText().isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "Required Field Must be filled!", "Empty Field", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                    }
                    if (valid) 
                    {
                        try 
                        {
                            int cardId = Integer.parseInt(credcrdtxtfieldcardid.getText());
                            String clientName = credcrdtxtfieldclientname.getText();
                            String issuerBank = credcrdtxtfieldissuerbank.getText();
                            String bankAccount = credcrdtxtfieldbankaccount.getText();
                            int balanceAmount = Integer.parseInt(credcrdtxtfieldbalanceamount.getText());
                            int cvcNumber = Integer.parseInt(credcrdtxtfieldcvcnumber.getText());
                            double interestRate = Double.parseDouble(credcrdtxtfieldinterestrate.getText());
                            String day = credcrdexpday.getSelectedItem().toString();
                            String month = credcrdmonth.getSelectedItem().toString();
                            String year = credcrdyear.getSelectedItem().toString();
                            String expirationDate = day + "/" + month + "/" + year;
                            boolean cardIdExists = false; // flag to check if card ID already exists

                            if (cardId < 0 || balanceAmount < 0 || cvcNumber < 0 || interestRate < 0) 
                            {
                                JOptionPane.showMessageDialog(frame, "Values cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            for (BankCard set : arraybank) 
                            {
                                if (set instanceof CreditCard) 
                                {
                                    int existingCardId = set.getCardId();
                                    if (existingCardId == cardId) 
                                    {
                                        cardIdExists = true;
                                        JOptionPane.showMessageDialog(frame, "Credit card with the given ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                                        break; // exit the loop if card ID already exists
                                    }
                                }
                            }
                            if (!cardIdExists) 
                            {
                                CreditCard objcredit = new CreditCard(cardId, clientName, issuerBank, bankAccount, balanceAmount, cvcNumber, interestRate, expirationDate);
                                arraybank.add(objcredit);
                                JOptionPane.showMessageDialog(frame, "Values have been stored", "Values", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } 
                        catch (NumberFormatException ex) 
                        {
                            credcrdtxtfieldcardid.setText("");
                            credcrdtxtfieldclientname.setText("");
                            credcrdtxtfieldissuerbank.setText("");
                            credcrdtxtfieldbankaccount.setText("");
                            credcrdtxtfieldbalanceamount.setText("");
                            credcrdtxtfieldcvcnumber.setText("");
                            credcrdtxtfieldinterestrate.setText("");
                            JOptionPane.showMessageDialog(frame, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        catch (NullPointerException ex) 
                        {
                            JOptionPane.showMessageDialog(frame, "Required Field Must be filled!", "Empty Field", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        /**Set Credit Limit**/
        credcrdsetcredlimit.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    boolean fieldvalid = true; //check flag
                    if (credcrdtxtfieldcardid.getText().isEmpty() || credcrdtxtfieldcredlimit.getText().isEmpty() || 
                    credcrdtxtfieldbalanceamount.getText().isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "Required Field Must be filled!", "Empty Field", JOptionPane.ERROR_MESSAGE);
                        fieldvalid = false; 
                    }
                    if (fieldvalid) 
                    {
                        try 
                        {
                            int cardid = Integer.parseInt(credcrdtxtfieldcardid.getText());
                            int creditlimit = Integer.parseInt(credcrdtxtfieldcredlimit.getText());
                            String graceday = credcrdgraceday.getSelectedItem().toString();
                            int graceperiod = Integer.parseInt(graceday);
                            boolean foundcard = false; // flag for checking if card has been found

                            if (creditlimit <= 0) 
                            {
                                JOptionPane.showMessageDialog(frame, "Values cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            for (BankCard set : arraybank)
                            {
                                if (set instanceof CreditCard) 
                                {
                                    int cardID = set.getCardId();
                                    if (cardID == cardid) 
                                    {
                                        foundcard = true;
                                        CreditCard credit = (CreditCard) set;
                                        credit.setCreditLimit(creditlimit, graceperiod);
                                        JOptionPane.showMessageDialog(frame, "Credit Limit has been set", "Set Credit Limit", JOptionPane.INFORMATION_MESSAGE);
                                        break; // exit the loop once the card has been found and credit limit set
                                    }
                                }
                            }
                            if (!foundcard) 
                            {
                                JOptionPane.showMessageDialog(frame, "Credit card with the given ID has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } 
                        catch (NumberFormatException ex) 
                        {
                            credcrdtxtfieldcredlimit.setText("");
                            JOptionPane.showMessageDialog(frame, "Invalid input, please enter numeric values only","Error", JOptionPane.ERROR_MESSAGE);
                        } 
                        catch (NullPointerException ex) 
                        {
                            JOptionPane.showMessageDialog(frame, "One or more required fields are empty. Please fill in all required fields.", "Empty Field", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
            });

        /**Cancel Credit Card**/
        credcrdcancel.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        int cardid = Integer.parseInt(credcrdtxtfieldcardid.getText());
                        boolean cardFound = false; // check flag added here
                        for (BankCard cancel : arraybank) 
                        {
                            if (cancel instanceof CreditCard) 
                            {
                                int cardId = cancel.getCardId();
                                if (cardid == cardId) 
                                {
                                    CreditCard credit = (CreditCard) cancel;
                                    credit.cancelCreditCard();
                                    JOptionPane.showMessageDialog(frame, "Credit card has been cancelled", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    cardFound = true; // check flag set true here
                                }
                            }
                        }
                        if (!cardFound) 
                        {
                            JOptionPane.showMessageDialog(frame, "Given Credit ID is not found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "No credit card to cancel", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        panel.setLayout(null);
        Credcrd_frame.add(panel);
        Credcrd_frame.setResizable(false);
        Credcrd_frame.setVisible(true);
        Credcrd_frame.setSize(877,655);
        Credcrd_frame.setLocationRelativeTo(null); //sets the frame to the middel
        Credcrd_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits the frame

    }

    public static void main(String[] args) 
    {
        new BankGUI();
    }
}

