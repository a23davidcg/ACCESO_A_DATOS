import javax.swing.JOptionPane;

public class JFileChooser {
    public static void main(String[] args) {
        javax.swing.JFileChooser FC = new javax.swing.JFileChooser("e:\\");
        FC.showOpenDialog(null);

        int val = FC.showOpenDialog(null );
        if (val == javax.swing.JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "Abriches: " + val);

        }




    }
}
