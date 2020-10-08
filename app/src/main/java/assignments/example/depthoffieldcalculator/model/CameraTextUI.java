package assignments.example.depthoffieldcalculator.model;

import assignments.example.depthoffieldcalculator.model.LensManager;
import assignments.example.depthoffieldcalculator.model.Lens;
import assignments.example.depthoffieldcalculator.model.DoFCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Text UI to interact with the user.
 */

/*
public class CameraTextUI {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private LensManager manager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public CameraTextUI(LensManager manager) {
        // Accept and store a reference to the lens manager (the model)
        // (this design is called "dependency injection")
        this.manager = manager;

        // Populate lenses (Make, max aperture (smallest supported F number), focal length [mm]):
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show() {
//        // BEGIN SAMPLE USING SCREEN AND KEYBOARD:
//        // (remove this: it's just to show you how to access the screen and keyboard!)
//        System.out.println("Enter an integer: ");
//        System.out.print(": ");
//        int count = in.nextInt();
//
//        System.out.println("Enter an double: ");
//        System.out.print(": ");
//        double value = in.nextDouble();
//
//        System.out.println("Printing " + value + " out " + count + " times (with formatting)!");
//        for (int i = 0; i < count; i++) {
//            System.out.println(" --> " + formatM(value));
//        }
//        // END SAMPLE

        // Display interactive text menu
        while (true) {

            // Show lenses
            System.out.println();
            System.out.println("Lenses to pick from:");
            for (int i = 0; i < manager.getNumLenses(); i++ ) {
                Lens l = manager.get(i);
                System.out.println("  " + i + ". " + l.getDescription());
            }
            System.out.println("  (-1 to exit)");

            // Read choice
            System.out.print(": ");
            int lensIdx = in.nextInt();

            // Done?
            if (lensIdx == -1) {
                break;
            }

            // Display DoF info
            if (lensIdx >= 0 && lensIdx < manager.getNumLenses()) {
                displayDoFForLens(lensIdx);
            } else {
                System.out.println("Error: Invalid lens index.");
            }
        }
    }

    private void displayDoFForLens(int lensIdx) {
        // Get lens:
        Lens lens = manager.get(lensIdx);

        // Input aperture
        System.out.print("Aperture [the F number]: ");
        double aperture = in.nextDouble();

        // Check aperture against lens
        if (aperture < lens.getMaxAperture()) {
            System.out.println("ERROR: This aperture is not possible with this lens");
            return;
        }

        // Input distance
        System.out.print("Distance to subject [m]: ");
        double distanceInM = in.nextDouble();

        // Display DoF
        DoFCalculator calculator = new DoFCalculator(COC, lens, aperture, distanceInM);
        System.out.println("  In focus: "
                + formatM(calculator.getNearFocalPointInM()) + "m"
                + " to "
                + formatM(calculator.getFarFocalPointInM()) + "m"
                + " [DoF = "
                + formatM(calculator.getDepthOfFieldInM()) + "m]");
        System.out.println("  Hyperfocal point: " + formatM(calculator.getHyperfocalDistanceInM()) + "m");
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}
*/