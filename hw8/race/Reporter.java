// Author: Logan Tillman

package race;

class Reporter extends Thread {
    TimeKeeper timeKeeper;
    int numContestants;

    public void run() {

        /* Running the race until every contestant has finished */
        while (timeKeeper.finalQueue.size() < numContestants) {

            /* Sleeping for 2 seconds then printing out the current race information */
            try {
                sleep(2000);
                printInfo();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

        /* Once the race is finished, we print the results */
        printResults();
    }

    /* Method for printing out the current status of the race */
    void printInfo() {
        for (int i = 0; i < this.timeKeeper.cumulativeTime.length; i++) {
            boolean isNewSeg = timeKeeper.newSegment[i] == 0 ? false : true;
            System.out.printf("Contestant %2d: Segments Completed = %d Cumulative Time = %-5d New Result = %-5b Last Segment Time = %d%n", i+1, timeKeeper.numSegments[i], timeKeeper.cumulativeTime[i], isNewSeg, timeKeeper.lastSegment[i]);
            timeKeeper.newSegment[i] = 0;
        }
        System.out.println();
    }

    /* Method for printing out the final results of the race */
    void printResults() {
        System.out.printf("Results:%n");
        while (!this.timeKeeper.finalQueue.isEmpty()) {
            System.out.println(this.timeKeeper.finalQueue.pop().contestantNumber);
        }
    }

    Reporter(TimeKeeper timeKeeper, int numContestants) {
        this.timeKeeper = timeKeeper;
        this.numContestants = numContestants;
        this.start();
    }
}