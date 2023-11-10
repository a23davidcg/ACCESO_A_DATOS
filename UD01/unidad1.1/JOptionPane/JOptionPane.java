public class JOptionPane {
    public static void main(String[] args) {
        javax.swing.JOptionPane.showMessageDialog(null,"Hola mundo ", "saúdo" , javax.swing.JOptionPane.PLAIN_MESSAGE);
        javax.swing.JOptionPane.showInputDialog(null, "introduce o teu nome");


       /* JOptionPane.showMessageDialog(null, "Hola mundo", "saúdo",JOptionPane.PLAIN_MESSAGE );
        JOptionPane.showImputDialog(null, "Introduce o teu nome");*/

        int val = javax.swing.JOptionPane.showConfirmDialog(null, "Queres sair?");
        if (val == javax.swing.JOptionPane.OK_OPTION){
            System.out.println("adios");

        }





    }
}
