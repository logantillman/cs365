// Author: Logan Tillman

package race;

import java.util.ArrayList;

class Race {
    ArrayList<Contestant> contestants = new ArrayList<Contestant>();
    SynchronizedRandom random = new SynchronizedRandom();

    Race(int numContestants) {
        try {
            TimeKeeper timeKeeper = new TimeKeeper(numContestants);
            Reporter reporter = new Reporter(timeKeeper, numContestants);

            for (int i = 1; i <= numContestants; i++) {
                Contestant contestant = new Contestant(i, random, timeKeeper);
                this.contestants.add(contestant);
            }
        
        } catch (Exception e) {
            System.out.println("Here");
        }


        // for (int i = 1; i <= numContestants; i++) {
        //     Contestant contestant = new Contestant(i, random, timeKeeper);
        //     this.contestants.add(contestant);
        // }
        
        printContestants();
    }

    void printContestants() {
        for (Contestant contestant : contestants) {
            System.out.println(contestant.contestantNumber);
        }
    }

    public static void main(String[] args) {
        try {
            int numContestants = Integer.parseInt(args[0]);
            new Race(numContestants);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number of contestants");
        }
    }
}