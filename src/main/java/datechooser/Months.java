package datechooser;

import java.awt.Cursor;
import javax.swing.JButton;

public final class Months extends javax.swing.JPanel {

    private Event event;
    private int m;

    public Months() {
        initComponents();
        for (int i = 0; i < getComponentCount(); i++) {
            JButton cmd = (JButton) getComponent(i);
            cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    private void addEvent() {
        for (int i = 0; i < getComponentCount(); i++) {
            ((Button) getComponent(i)).setEvent(event);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmd1 = new datechooser.Button();
        cmd2 = new datechooser.Button();
        cmd3 = new datechooser.Button();
        cmd4 = new datechooser.Button();
        cmd5 = new datechooser.Button();
        cmd6 = new datechooser.Button();
        cmd7 = new datechooser.Button();
        cmd8 = new datechooser.Button();
        cmd9 = new datechooser.Button();
        cmd10 = new datechooser.Button();
        cmd11 = new datechooser.Button();
        cmd12 = new datechooser.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(4, 4));

        cmd1.setForeground(new java.awt.Color(75, 75, 75));
        cmd1.setText("Tháng 1");
        cmd1.setName("1"); // NOI18N
        cmd1.setOpaque(true);
        add(cmd1);
        cmd1.getAccessibleContext().setAccessibleDescription("");

        cmd2.setForeground(new java.awt.Color(75, 75, 75));
        cmd2.setText("Tháng 2");
        cmd2.setName("2"); // NOI18N
        cmd2.setOpaque(true);
        add(cmd2);

        cmd3.setForeground(new java.awt.Color(75, 75, 75));
        cmd3.setText("Tháng 3");
        cmd3.setName("3"); // NOI18N
        cmd3.setOpaque(true);
        add(cmd3);

        cmd4.setForeground(new java.awt.Color(75, 75, 75));
        cmd4.setText("Tháng 4");
        cmd4.setName("4"); // NOI18N
        cmd4.setOpaque(true);
        add(cmd4);

        cmd5.setForeground(new java.awt.Color(75, 75, 75));
        cmd5.setText("Tháng 5");
        cmd5.setName("5"); // NOI18N
        cmd5.setOpaque(true);
        add(cmd5);

        cmd6.setForeground(new java.awt.Color(75, 75, 75));
        cmd6.setText("Tháng 6");
        cmd6.setName("6"); // NOI18N
        cmd6.setOpaque(true);
        add(cmd6);

        cmd7.setForeground(new java.awt.Color(75, 75, 75));
        cmd7.setText("Tháng 7");
        cmd7.setName("7"); // NOI18N
        cmd7.setOpaque(true);
        add(cmd7);

        cmd8.setForeground(new java.awt.Color(75, 75, 75));
        cmd8.setText("Tháng 8");
        cmd8.setName("8"); // NOI18N
        cmd8.setOpaque(true);
        add(cmd8);

        cmd9.setForeground(new java.awt.Color(75, 75, 75));
        cmd9.setText("Tháng 9");
        cmd9.setName("9"); // NOI18N
        cmd9.setOpaque(true);
        add(cmd9);

        cmd10.setForeground(new java.awt.Color(75, 75, 75));
        cmd10.setText("Tháng 10");
        cmd10.setName("10"); // NOI18N
        cmd10.setOpaque(true);
        add(cmd10);

        cmd11.setForeground(new java.awt.Color(75, 75, 75));
        cmd11.setText("Tháng 11");
        cmd11.setName("11"); // NOI18N
        cmd11.setOpaque(true);
        add(cmd11);

        cmd12.setForeground(new java.awt.Color(75, 75, 75));
        cmd12.setText("Tháng 12");
        cmd12.setName("12"); // NOI18N
        cmd12.setOpaque(true);
        add(cmd12);
    }// </editor-fold>//GEN-END:initComponents

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.Button cmd1;
    private datechooser.Button cmd10;
    private datechooser.Button cmd11;
    private datechooser.Button cmd12;
    private datechooser.Button cmd2;
    private datechooser.Button cmd3;
    private datechooser.Button cmd4;
    private datechooser.Button cmd5;
    private datechooser.Button cmd6;
    private datechooser.Button cmd7;
    private datechooser.Button cmd8;
    private datechooser.Button cmd9;
    // End of variables declaration//GEN-END:variables

}
