package Persons.Console;


public class IconsState {

    private String state;

    public IconsState(){
        resState();
    }
    // 
    public IconsState(String action, int value) {
        switch (action) {
            case ("⚔-"):
                state = AnsiColors.RED_b + action + value + AnsiColors.CYAN_back + AnsiColors.BLACK_b;//
                break;
            case ("⚔+"):
                state = AnsiColors.GREEN_b + action + value + AnsiColors.GREEN_back + AnsiColors.WHITE_b; // ⚔
                break;
            case ("♥+"):
                state = AnsiColors.GREEN_b + action + value + AnsiColors.GREEN_back + AnsiColors.BLACK_b;
                break;
            case ("♥-"):
                state = AnsiColors.RED_b + action + value + AnsiColors.RED_back + AnsiColors.BLACK_b; // ♥
                break;
            case ("☠"):
                state = String.format(value + AnsiColors.RED_b);// ☠
                break;
            // case ("\uD83D\uDEE1"): //U+26E8 // F0 9F 9B A1 // \uD83D\uDEE1
            //     state = AnsiColors.RED_b + action + value + AnsiColors.RESET+""; // щит
            //     break;    
            default:
                state = AnsiColors.RESET+"";
                break;
        }
    }


    public IconsState(String str) {
        state = str;
    }

    public String getState() {
        return state;
    }

    public void resState(){
        state="";
    }

}
