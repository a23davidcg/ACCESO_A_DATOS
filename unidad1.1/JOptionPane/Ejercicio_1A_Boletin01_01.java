import javax.swing.JFileChooser;

public class Ejercicio_1A_Boletin01_01 {
    public static void main(String[] args) {
        //Parte 1
        /*public static Scanner sc = new Scanner(System.in)
                File fOrixe, fDestino;
        do {
            System.out.println("Introduce nome do arquivo de orixe");
            fOrixe = new File(sc.nextLine()); // Pasamos a cadea directamente ó
        }while (!fOrixe.exists());

        do {
            System.out.println("Introduce o nome do arquivo:");
            fDestino = new File(sc.nextLine());
        }while (fDestino.exists());

        try (FileOutputStream f2 = new FileOutputStream(fDestino));
        FileInputStream f1 = new FileInputStream(fOrixe); {
            int c ;
            while ((c=f1.read() !=-1));

        }
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Escribe o nome do arquivo: ");
        String file =  sc.nextLine();
        System.out.println("Escribe onde o queres gardar: ");*/


        //PARTE 2

       /* JFileChooser fc = new JFileChooser("e:\\");
        int val = fc.showOpenDialog(null);

        if (val == JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "abriches " + val);
        }*/


        //PARTE3
        String DireccionURL = javax.swing.JOptionPane.showInputDialog(null, "introduce a url");
        javax.swing.JFileChooser FC = new javax.swing.JFileChooser("D:\\");

        int respuesta = FC.showSaveDialog(FC);
        switch (respuesta){
            case JFileChooser.APPROVE_OPTION:
                System.out.println("Guardar");
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Cancelar");
                break;
            default:
                System.out.println("error:");
                break;
        }
        if ( FC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            System.out.println("Has seleccionado la imagen " + FC.getSelectedFile().getName());
        }


        }

       // InputStrem in = new URL(FILE_URL).openStream();





    }

