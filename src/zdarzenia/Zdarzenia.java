package zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Zdarzenia extends JFrame implements ActionListener{

    public Zdarzenia()
    {
        super("Układ graficzny (Layout)");
        this.setBounds(300, 320, 300, 200);
        
        initComponents();
        //this.pack();
        this.setDefaultCloseOperation(3);
    }
    public void initComponents()
    {
        kolorCzerwony = new JButton("Czerwony");
        kolorCzarny = new JButton("Czarny");
        kolorZielony = new JButton("Zielony");
        kolorZolty = new JButton("Zolty");
        
        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED));
        kolorCzarny.addActionListener(new sluchaczKolorow(Color.BLACK));
        kolorZielony.addActionListener(new sluchaczKolorow(Color.GREEN));
        kolorZolty.addActionListener(this);
        
        panel.add(kolorCzerwony);
        panel.add(kolorCzarny);
        panel.add(kolorZielony);
        panel.add(kolorZolty);
        budujButton("Niebieski", Color.BLUE);
        this.getContentPane().add(panel);
    }
    
    JPanel panel = new JPanel();
    JButton kolorCzerwony;
    JButton kolorCzarny;
    JButton kolorZielony;
    JButton kolorZolty;
    
    public void budujButton(String nazwa, final Color k)
    {
        JButton przycisk = new JButton(nazwa);
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(k);
            }
        });
        panel.add(przycisk);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kolorZolty)
            panel.setBackground(Color.YELLOW);
    }
    
    private class sluchaczKolorow implements ActionListener
    {
        public sluchaczKolorow(Color k)
        {
            this.kolor = k;
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            panel.setBackground(kolor);
        }
        Color kolor;
    }
    
    public static void main(String[] args) {
        new Zdarzenia().setVisible(true);
    }
    
}
