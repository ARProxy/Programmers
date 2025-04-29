import java.util.*;

public class Main {
    
    static int[][] array;
    static int n;
    static int minDiff = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        array = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        
        boolean[] startTeam = new boolean[n];
        calculateTeamAbility(0, 0, startTeam);
        System.out.println(minDiff);
        
        sc.close();
    }
    
    static void calculateTeamAbility(int player, int startCount, boolean[] startTeam) {
        if(player == n) {
            if(startCount == n/2) {
                int startTeamScore = 0;
                int linkTeamScore = 0;
                
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        if(startTeam[i] && startTeam[j]) {
                            startTeamScore += array[i][j];
                        } else if(!startTeam[i] && !startTeam[j]) {
                            linkTeamScore += array[i][j];
                        }
                    }
                }
                int diff = Math.abs(startTeamScore - linkTeamScore);
                minDiff = Math.min(minDiff, diff);
            }
            return;
        }
        startTeam[player] = true;
        calculateTeamAbility(player+1, startCount+1, startTeam);
        
        startTeam[player] = false;
        calculateTeamAbility(player+1, startCount, startTeam);
    }
}