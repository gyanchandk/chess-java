package version2;

public class GameControl {

    private static GameControl instance = new GameControl();
    private Team nextTurn;
    


    private GameControl(){
        nextTurn = Team.WHITE;
    }

    public static GameControl getInstance(){
        return instance;
    }

    public Team getNextTurn() {
        return nextTurn;
    }

    public void changeTurn(){
        if(nextTurn==Team.WHITE){
            nextTurn = Team.BLACK;
        }else{
            nextTurn= Team.WHITE;
        }

    }
    
}
