import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlinkAnalysisTest {
    private static String sep = System.lineSeparator();

    public static void main(final String[] args) throws IOException {
        // Set up a buffered reader to read input from the user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Set up a test set of blinks
        TaskBlinkList taskBlinks = new TaskBlinkList();
        setupTestBlinkList(taskBlinks);

        char answer;
        ComparisonSpecification spec;
        int value;

        List<BlinkSelectionCriterion> blinkSelectionCriteria = new ArrayList<BlinkSelectionCriterion>();


        // Ask user for blink search criteria
        System.out.println("Specify blink search criteria");

        // Get a 50% start time criterion if the user wants to specify it.
        System.out.print("Would you like to specify a 50% start time criterion? [Y/N]: ");
        answer = reader.readLine().toUpperCase().charAt(0);


        if (answer == 'Y') {
            blinkSelectionCriteria.add(FiftyPercentStartTimeCriterion.getInstance(reader));
        }
        // Get the 50% end time criterion if the user wants to specify it.
        System.out.print("Would you like to specify a 50% end time criterion? [Y/N]: ");
        answer = reader.readLine().toUpperCase().charAt(0);
        
        if (answer == 'Y') {
            blinkSelectionCriteria.add(FiftyPercentEndTimeCriterion.getInstance(reader));
        }

        // Get the 50% window duration criterion if the user wants to specify it.
        System.out.print("Would you like to specify a 50% window duration criterion? [Y/N]: ");
        answer = reader.readLine().toUpperCase().charAt(0);
        
        if (answer == 'Y') {
            blinkSelectionCriteria.add(FiftyPercentWindowDurationCriterion.getInstance(reader));
        }

        // Get the amplitude criterion if the user wants to specify it.
        System.out.print("Would you like to specify an amplitude criterion? [Y/N]: ");
        answer = reader.readLine().toUpperCase().charAt(0);
        
        if (answer == 'Y') {
            blinkSelectionCriteria.add(AmplitudeCriterion.getInstance(reader));
        }

        // Get the style criterion if the user wants to specify it.
        System.out.print("Would you like to specify a blink style criterion? [Y/N]: ");
        answer = reader.readLine().toUpperCase().charAt(0);
        
        if (answer == 'Y') {
            System.out.print("style value " + BlinkStyle.allowedValues() + ": ");
            BlinkStyle style = BlinkStyle.lookup(reader.readLine());
            blinkSelectionCriteria.add(new BlinkStyleCriterion(style));
        }

        // Get the associated gaze shift criterion if the user wants to specify it.
        System.out.print("Would you like to specify an associated gaze shift criterion? [Y/N]: ");
        answer = reader.readLine().toUpperCase().charAt(0);
        
        if (answer == 'Y') {
            System.out.print("associated gaze shift value " + BlinkGazeAssociation.allowedValues() + ": ");
            BlinkGazeAssociation gazeAssociation = BlinkGazeAssociation.lookup(reader.readLine());
            blinkSelectionCriteria.add(new BlinkGazeCriterion(gazeAssociation));
        }

        // Search for blinks using specified criteria
        List<Blink> foundBlinks = taskBlinks.search(blinkSelectionCriteria);

        int foundCount = 0;
        for (Iterator<Blink> i = foundBlinks.iterator(); i.hasNext(); ) {
            Blink aFoundBlink = i.next();
            foundCount++;
            System.out.print(foundCount + " ");
            System.out.println(aFoundBlink);
        }
        if (foundCount == 0) {
            System.out.println(sep + "Sorry, no matching blinks found" + sep);
        }
    }

    private static void setupTestBlinkList(final TaskBlinkList taskBlinks) {

        // startTime, fiftyPercentStartTime, fiftyPercentEndTime, amplitude, style, gazeAssociation
        taskBlinks.addBlink(new Blink(2150, 30, 70, 350, BlinkStyle.FULL, BlinkGazeAssociation.NONE)); // matches
        taskBlinks.addBlink(new Blink(1000, 35, 88, 400, BlinkStyle.FULL, BlinkGazeAssociation.BOTH));
        taskBlinks.addBlink(new Blink(3230, 30, 70, 350, BlinkStyle.FULL, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(3390, 40, 90, 437, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(4150, 70, 150, 600, BlinkStyle.FULL, BlinkGazeAssociation.BOTH));
        taskBlinks.addBlink(new Blink(5000, 32, 50, 200, BlinkStyle.MICRO, BlinkGazeAssociation.NONE));
        taskBlinks.addBlink(new Blink(7536, 33, 70, 290, BlinkStyle.MICRO, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(10001, 50, 125, 900, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(12164, 32, 71, 350, BlinkStyle.FULL, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(13000, 36, 88, 400, BlinkStyle.FULL, BlinkGazeAssociation.BOTH));
        taskBlinks.addBlink(new Blink(14230, 38, 70, 280, BlinkStyle.MICRO, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(15390, 47, 98, 437, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(16150, 77, 157, 600, BlinkStyle.FULL, BlinkGazeAssociation.BOTH));
        taskBlinks.addBlink(new Blink(17000, 39, 57, 200, BlinkStyle.FULL, BlinkGazeAssociation.NONE)); // matches
        taskBlinks.addBlink(new Blink(17536, 31, 77, 290, BlinkStyle.MICRO, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(180001, 56, 125, 900, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(25150, 30, 70, 350, BlinkStyle.FULL, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(27000, 35, 88, 400, BlinkStyle.FULL, BlinkGazeAssociation.NONE));
        taskBlinks.addBlink(new Blink(32099, 30, 70, 350, BlinkStyle.FULL, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(35390, 40, 90, 437, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(44150, 70, 150, 600, BlinkStyle.FULL, BlinkGazeAssociation.BOTH));
        taskBlinks.addBlink(new Blink(44500, 32, 50, 200, BlinkStyle.MICRO, BlinkGazeAssociation.NONE));
        taskBlinks.addBlink(new Blink(47536, 33, 70, 290, BlinkStyle.MICRO, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(50001, 50, 125, 900, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(62164, 32, 71, 350, BlinkStyle.FULL, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(73000, 36, 88, 380, BlinkStyle.FULL, BlinkGazeAssociation.NONE)); // matches
        taskBlinks.addBlink(new Blink(84230, 38, 70, 280, BlinkStyle.MICRO, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(85390, 47, 98, 437, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
        taskBlinks.addBlink(new Blink(96150, 35, 187, 300, BlinkStyle.FULL, BlinkGazeAssociation.NONE));
        taskBlinks.addBlink(new Blink(97034, 39, 57, 200, BlinkStyle.MICRO, BlinkGazeAssociation.NONE));
        taskBlinks.addBlink(new Blink(100536, 31, 77, 290, BlinkStyle.MICRO, BlinkGazeAssociation.HORIZONTAL));
        taskBlinks.addBlink(new Blink(118001, 56, 125, 900, BlinkStyle.FULL, BlinkGazeAssociation.VERTICAL));
    }
}