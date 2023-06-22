import java.util.ArrayList;

public class PossibleSquare {
    ArrayList<Coordinate> moves = new ArrayList<>();

    PossibleSquare(){
        moves.clear();
    }

    boolean check(int x, int y){

        if(x<1 || x>8 || y<1 || y>8){
            return false;
        }

        return true;
    }

    public ArrayList<Coordinate> getKnightMoves(int x, int y){

        moves.clear();

        int xOffset[]={-2,-2,-1,-1,1,1,2,2};
        int yOffset[]={1,-1,2,-2,2,-2,1,-1};

        for(int i=0;i<8;i++){

            int nextX= x+xOffset[i];
            int nextY = y+yOffset[i];

            if(check(nextX,nextY)){
                moves.add(new Coordinate(nextX, nextY));
            }
        }
        return moves;
    }

    private void bishopUtil(int x,int y,int xOffset,int yOffset){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(check(nextX, nextY)){
            moves.add(new Coordinate(nextX, nextY));
            nextX=nextX+xOffset;
            nextY=nextY+yOffset;
        }
    }
    public ArrayList<Coordinate> getBishopMoves(int x, int y){
        moves.clear();

        bishopUtil(x, y, 1, -1);
        bishopUtil(x, y, -1, -1);
        bishopUtil(x, y, -1, 1);
        bishopUtil(x, y, 1, 1);

        return moves;
    }

    public ArrayList<Coordinate> getRookMoves(int x, int y){
        moves.clear();
        for(int nextX=x-7; nextX<=8;nextX++){
            if(check(nextX, y)){
                moves.add(new Coordinate(nextX,y));
            }
        }

        for(int nextY=y-7;nextY<=8;nextY++){
            if(check(x, nextY)){
                moves.add(new Coordinate(x, nextY));
            }
        }

        return moves;
    }

    public ArrayList<Coordinate> getPawnMoves(int x, int y){
        moves.clear();

        if(check(x-1, y))
            moves.add(new Coordinate(x-1, y));
        
        if(check(x-2, y))
            moves.add(new Coordinate(x-2, y));
        
        if(check(x-1, y-1))
            moves.add(new Coordinate(x-1, y-1));
        
        if(check(x-1, y+1))
            moves.add(new Coordinate(x-1, y+1));

        return moves;

    }

    public ArrayList<Coordinate> getKingMoves(int x, int y){
        moves.clear();
        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){
            int nextX= x+xOffset[i];
            int nextY = y+yOffset[i];

            if(check(nextX, nextY)){
                moves.add(new Coordinate(nextX, nextY));
            }
            
        }

        return moves;

    }

}
