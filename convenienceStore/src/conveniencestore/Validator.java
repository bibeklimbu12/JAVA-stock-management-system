package conveniencestore;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Validator {
    public void digitValidateField(Character c, KeyEvent evt){
                if(!(Character.isDigit(c))&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            evt.consume();
            JOptionPane.showMessageDialog(null, "Make use of numbers only!!");
        } 
    }
   public void TextValidateField(Character c, KeyEvent evt){
            if(!(Character.isAlphabetic(c))&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            evt.consume();
            JOptionPane.showMessageDialog(null, "Make use of letters only!!");
        } 
    }
   public void textDigitValidate(Character c, KeyEvent evt){
            if(!(Character.isAlphabetic(c))&&!(Character.isDigit(c))&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            evt.consume();
            JOptionPane.showMessageDialog(null, "Make use of letters or digits only!!");
        } 
    }
   public void mixValidateField(Character c, KeyEvent evt){
            if(!(Character.isAlphabetic(c))&&!(Character.isDigit(c))&&!(c==KeyEvent.VK_PERIOD)&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            evt.consume();
            JOptionPane.showMessageDialog(null, "Make use of letters or digits only!!");
        } 
    }
   public void mixCharacters(Character c, KeyEvent evt){
            if(!(Character.isAlphabetic(c))&&!(Character.isDigit(c))&&(c != KeyEvent.VK_MINUS)&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            evt.consume();
            JOptionPane.showMessageDialog(null, "Make use of letters,digits or hyphens only!!");
        } 
    }

   public void doubleFields(Character c, KeyEvent evt){
            if(!(Character.isDigit(c))&&(c != KeyEvent.VK_PERIOD)&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            evt.consume();
            JOptionPane.showMessageDialog(null, "Make use of digits and dot(.) only!!");
        } 
    }
   public static boolean doubleFieldsTable(Character c, KeyEvent evt){
        if(!(Character.isDigit(c))&&(c != KeyEvent.VK_PERIOD)&&(c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_DELETE) && (c !=KeyEvent.VK_ENTER)){ 
            //evt.consume();
            //JOptionPane.showMessageDialog(null, "Make use of digits and dot(.) only!!");
            return true;
        }else{
            return false;
        } 
    }
   
   public static boolean onlyContainNumbers (String text){
       try{
           Double.parseDouble(text);
           return true;
       }catch (NumberFormatException ex){
           return false;
       }
   }
   
}
