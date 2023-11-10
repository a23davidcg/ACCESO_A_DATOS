/*public class AppObject {
    public static void main(String[] args) {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("e:\\obxectos.dat"));){
            oo.writeObject(new Point(0,1));

        }catch (IOException ex){
            Logger.getLogger(AppObjectIO.class.getName()).log(Level.SEVERE);
        }
        try(ObjectInputStream oo = new ObjectInputStream(new FileInputStream("e:\\obxectos.dat"))){
            f = (JFileChooser) oo.readObject();
            f.showSaveDialog(null);
        }catch (IOException | ClassNotFoundException ex){
            Logger.getLogger(AppObjectIO.class.getName()).log(Level.SEVERE);
        }

    }
}*/
