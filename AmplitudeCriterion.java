import java.io.BufferedReader;
import java.io.IOException;

public class AmplitudeCriterion implements BlinkSelectionCriterion {

    private ComparisonSpecification comparisonSpec;
    private int criterionValue;

    public AmplitudeCriterion(ComparisonSpecification spec, int value) {
        this.comparisonSpec = spec;
        this.criterionValue = value;
    }
    
    public boolean doesBlinkMatch(Blink blink) {
        int valueToCheck = blink.getAmplitude();

        switch (this.comparisonSpec) {
            case LESS_THAN:
                return valueToCheck < criterionValue;
            case GREATER_THAN:
                return valueToCheck > criterionValue;
            case LESS_THAN_OR_EQUAL_TO:
                return valueToCheck <= criterionValue;
            default:
                throw new IllegalArgumentException("Unrecognized Comparision: " + comparisonSpec);
        }

    }
    public static AmplitudeCriterion getInstance(BufferedReader reader) throws IOException
{
        System.out.print("Amplitude comparison: " + ComparisonSpecification.allowedValues() + ": ");
            ComparisonSpecification spec = ComparisonSpecification.lookup(reader.readLine());
                System.out.print("Amplitude: ");
                    int value = Integer.parseInt(reader.readLine());
            return new AmplitudeCriterion(spec, value);
}
}


/*import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class AmplitudeCriterion implements BlinkSelectionCriterion

{

//private ComparisonSpecification comparisonSpec;

//private int criterionValue;







/*public static AmplitudeCriterion createCriterion() {

Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter comparison type (>, <, =, <=, or >=): ");
    
    String input = keyboard.next();
    
    System.out.print("Enter comparison value: ");
    
    int val = keyboard.nextInt();
    
    switch (input){ 
    
    case ">":
    
    return new AmplitudeCriterion(ComparisonSpecification.GREATER_THAN, val);
    
    case "<":
    
    return new AmplitudeCriterion(ComparisonSpecification.LESS_THAN, val);
    
    case "=":
    
    return new AmplitudeCriterion(ComparisonSpecification.EQUAL_TO, val);
    
    case "<=":
    
    return new AmplitudeCriterion(ComparisonSpecification.LESS_THAN_OR_EQUAL_TO, val);
    
    case ">=":
    
    return new AmplitudeCriterion(ComparisonSpecification.GREATER_THAN_OR_EQUAL_TO, val);
    
    default:
    
    System.out.println("Unrecognized comparison: " + input);
    
    return createCriterion();
    

}
}

public AmplitudeCriterion(ComparisonSpecification spec, int value) {

this.comparisonSpec = spec;

this.criterionValue = value;

}

public boolean doesBlinkMatch(Blink blink) {

int valueToCheck = blink.getAmplitude();

switch (this.comparisonSpec) {

case LESS_THAN:

return valueToCheck < criterionValue;

case GREATER_THAN:

return valueToCheck > criterionValue;

case LESS_THAN_OR_EQUAL_TO:

return valueToCheck <= criterionValue;

case GREATER_THAN_OR_EQUAL_TO:

return valueToCheck >= criterionValue;

default:

throw new IllegalArgumentException("Unrecognized Comparision: " + comparisonSpec);

}
}*/