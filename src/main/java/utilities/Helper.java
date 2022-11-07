package utilities;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class Helper {

    public boolean checkNull(JTextField field, String name) {
        if (field.getText().isEmpty()) {
            errorNull(null, name);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRegex(JTextField field, String regex, String message) {
        if (!field.getText().matches(regex)) {
            error(null, message);
            return true;
        } else {
            return false;
        }
    }

    public Date checkDate(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(d);
        } catch (ParseException ex) {
            error(null, "Vui lòng nhập đúng định dạng yyyy-MM-dd!");
        }
        return date;
    }
    
    public String formatDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(date);
        return result;
    }

    public BigDecimal convertToDecimal(JTextField field, String message) {
        BigDecimal result = null;
        try {
            result = BigDecimal.valueOf(Double.parseDouble(field.getText()));
        } catch (Exception e) {
            error(null, message);
        }
        return result;
    }

    public void alert(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Thông báo", 1);
    }

    public void error(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Thông báo", 0);
    }

    public void errorNull(Component component, String name) {
        JOptionPane.showMessageDialog(component, name + " không được để trống!", "Thông báo", 0);
    }

    public boolean confirm(Component component, String message) {
        int choice = JOptionPane.showConfirmDialog(component, message, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
