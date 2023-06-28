package version2.clock;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import version2.Game;
import version2.GameStatus;
import version2.Team;

public class Clock extends TimerTask{

    private int  incrementInSeconds;
    private Timer timer;
    private int whiteTimeInMilliseconds;
    private int blackTimeInMilliseconds;
    private int timeInterval = 0;
    private JLabel whiteTime,blackTime;
    private int cutOffTimeInMinutes=1;



    Clock(int timeControlInMs,
        int incrementInSeconds,
        Timer timer,
        JLabel whiteTime,
        JLabel blackTime){
        
        this.incrementInSeconds = incrementInSeconds;
        this.timer = timer;

        whiteTimeInMilliseconds = timeControlInMs;
        blackTimeInMilliseconds = timeControlInMs;

        this.whiteTime = whiteTime;
        this.blackTime= blackTime;

        whiteTime.setText(convertToHMSM(whiteTimeInMilliseconds));
        blackTime.setText(convertToHMSM(blackTimeInMilliseconds));
    }

    @Override
    public void run() {

        if(Game.getGameStatus()==GameStatus.GAME_OVER){
            timer.cancel();
            return;
        }

        if(Game.getGameStatus()!=GameStatus.ONGOING){
            return;
        }
        timeInterval++;
        
        if(Game.getTurn()==Team.WHITE){
            whiteTimeInMilliseconds--;
            whiteTime.setText(convertToHMSM(whiteTimeInMilliseconds));
        }else{
            blackTimeInMilliseconds--;
            blackTime.setText(convertToHMSM(blackTimeInMilliseconds));
        }

        if(whiteTimeInMilliseconds ==0){
            Game.setGameStatus(GameStatus.GAME_OVER);
            System.out.println("GAME OVER --- Black wins");
            timer.cancel();
        }

        if(blackTimeInMilliseconds ==0){
            Game.setGameStatus(GameStatus.GAME_OVER);
            System.out.println("GAME OVER --- WHITE WINS");
            timer.cancel();
        }

        if(timeInterval==1000){
            System.out.println("white_time:"+whiteTimeInMilliseconds/1000+
                    "black_time:"+blackTimeInMilliseconds/1000);
            
            timeInterval=0;
        }
    }

    class ClockTimeFormat{
        int hour,minutes,seconds,milliseconds;
    }

    public String convertToHMSM(int ms){

        ClockTimeFormat time = new ClockTimeFormat();

        int hour = 60*60*1000;
        int min = 60*1000;
        int sec =1000;

        time.hour = ms/hour;
        ms = ms%hour;

        time.minutes = ms/min;
        ms= ms%min;

        time.seconds = ms/sec;

        time.milliseconds= ms%1000;

        StringBuilder sb = new StringBuilder();

        if(time.hour>0){
            sb.append(time.hour<10? "0"+time.hour:time.hour+"");
            sb.append(":");
        }
        
        sb.append(time.minutes<10?"0"+time.minutes:time.minutes+"");
        sb.append(":");

        sb.append(time.seconds<10?"0"+time.seconds:time.seconds+"");
        

        if(time.minutes<cutOffTimeInMinutes){
            sb.append(":");
            int tms = time.milliseconds%10;
            sb.append("0"+tms);
        }
        

        return sb.toString();

    }
    
}
