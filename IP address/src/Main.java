package com.herokuapp.tvolex;
import javafx.event.ActionEvent;
import sun.security.x509.IPAddressName;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.net.*;
public class Main {


    public static void main(String[] args) {

// Objects
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        JLabel lPLabel = new JLabel();
        JButton button = new JButton("Copy");

        Font font = new Font("Verdana", Font.PLAIN, 30);


        frame.setTitle("Your IP address");
        int FrameWidth = 700;
        int FrameHeight = 400;
        frame.setVisible(true);
        frame.setSize(FrameWidth,FrameHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
// Add objects to frame
        frame.add(button);
        frame.add(label);
        frame.add(lPLabel);


// General Label
        int labelWidth = 120;
        int labelHeight = 50;
        int labelCenterX = CenterX(FrameWidth,labelWidth);
        label.setVisible(true);
        label.setSize(labelWidth,labelHeight);
        label.setLocation(labelCenterX, 10);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setFont(font);
        label.setText("Your IP");
        label.setForeground(Color.black);

// Label IP
        String IP;
        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Exception e) {
            IP = "Error finding IP";
        }
        lPLabel.setVisible(true);
        lPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lPLabel.setVerticalAlignment(SwingConstants.CENTER);
        lPLabel.setText(IP);
        lPLabel.setFont(font);
        lPLabel.setForeground(Color.black);


// Button Sign In
        int WidthBtn = 200;
        int HeightBtn = 30;
        int BtnCenterX = CenterX(FrameWidth,WidthBtn);
        int BtnCenterY = CenterY(FrameHeight, HeightBtn);
        button.setVisible(true);
        button.setSize(WidthBtn,HeightBtn);
        button.setLocation(BtnCenterX, BtnCenterY + 100);
        button.setBackground(Color.darkGray);
        button.setForeground(Color.green);
        String ip = IP;

        button.addActionListener(e -> {
            StringSelection selection = new StringSelection(ip);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        });


    }
    public static int CenterX(int FrameWidth, int WidthObj) {
        int x = (FrameWidth / 2) - (WidthObj / 2);
        System.out.println("Center x : " + x);
        return x;
    }
    private static int CenterY(int FrameHeight,int HeightObj) {
        int y = (FrameHeight / 2) - (HeightObj / 2);
        System.out.println("Center y : " + y);
        return y;
    }

}