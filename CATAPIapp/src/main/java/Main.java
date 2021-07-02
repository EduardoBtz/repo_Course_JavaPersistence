import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int option = -1;
        String [] buttons  = {"1. See cats", "2. Exit"};

        do {
            String opt = (String) JOptionPane.showInputDialog(null,
                                                                "Java Cats",
                                                                "Main Menu",
                                                                JOptionPane.INFORMATION_MESSAGE,
                                                                null,
                                                                buttons,
                                                                buttons[0]);

            // Validate option
            for(int i=0;i<buttons.length;i++){
                if(opt.equals(buttons[i])){
                    option = i;
                }
            }

            switch(option){
                case 0:
                    CatService.seeCats();
                    break;
                default:
                    break;
            }
        }while (option != 1);
    }
}
