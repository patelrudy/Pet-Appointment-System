
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class represents a clinic class.
 * @author Rudreshbhai Patel
 * @version 1.2
 */

public class Clinic {
    private File patientFile;
    private int day;

    /**
     * A constructor for Clinic class with one parameter.
     * @param file a file that contains all info about the patients.
     */
    public Clinic(File file) {
        patientFile = file;
        day = 1;
    }

    /**
     * A constructor for Clinic class with one parameter.
     * @param fileName A string that takes in the name of the file.
     */
    public Clinic(String fileName) {
        this(new File(fileName));
    }

    /**
     * A method to get information on the patient from the appointment file.
     * @param f appointment file.
     * @return returns a string containing information on the patient.
     * @throws FileNotFoundException Throws this exception If file f is not found.
     */
    public String nextDay(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Scanner fileScan = new Scanner(f);
        String mainFileInString = "";
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            String[] lineSegments = line.split(",");
            String name = lineSegments[0];
            String typeOfPet = lineSegments[1];
            String entryTime = lineSegments[3];
            double health = 0;
            int painLevel = 0;
            if (!(typeOfPet.equals("Dog") || typeOfPet.equals("Cat"))) {
                System.out.println("hello");
                throw new InvalidPetException();
            }
            System.out.print("Consultation for " + name + " the "
                    + typeOfPet + " at " + entryTime + ".\nWhat is the health of " + name + "?\n");
            while (true) {
                try {
                    health = Double.parseDouble(scan.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number");
                }
            }
            System.out.print("On a scale of 1 to 10, how much pain is " + name + " in right now?\n");
            while (true) {
                try {
                    painLevel = Integer.parseInt(scan.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number");
                }
            }
            String droolRateOrMiceCaughtString = lineSegments[2];
            double droolRateOrMiceCaught = Double.parseDouble(droolRateOrMiceCaughtString);
            Pet pet = typeOfPet.equals("Dog") ? new Dog(name, health, painLevel, droolRateOrMiceCaught)
                    : new Cat(name, health, painLevel, (int) droolRateOrMiceCaught);
            pet.speak();
            String timeOut = addTime(entryTime, pet.treat());
            mainFileInString = mainFileInString + name + "," + typeOfPet + "," + droolRateOrMiceCaughtString + ","
                    + "Day " + day + "," + entryTime + "," + timeOut + "," + health + "," + painLevel + "\n";

        }
        scan.close();
        fileScan.close();
        return mainFileInString;
    }

    /**
     * A method to get information on the patient from the appointment file.
     * @param fileName takes in the file name of the file containing all the appointments.
     * @return returns a string containing informantion on the patient.
     * @throws FileNotFoundException throws this exception If file f is not found.
     */
    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    /**
     * This method adds new appointment information to the file.
     * @param patientInfo is information on the new appointment of the pet.
     * @return a boolean value true if the information is successfully added and false if not.
     */
    public boolean addToFile(String patientInfo) {
        boolean returnValue = true;
        //Scanner scan = new Scanner(patientInfo);
        String[] patientInfoSegments = patientInfo.split(",");
        String nameOfPet = patientInfoSegments[0];
        String dayOfPet = patientInfoSegments[3];
        String entryTimeOfPet = patientInfoSegments[4];
        String exitTimeOfPet = patientInfoSegments[5];
        String healthOfPet = patientInfoSegments[6];
        String painLevelOfPet = patientInfoSegments[7];
        String allPatients = "";
        String allPatientsBackup = "";
        String tempFileString = "";

        try {
            Scanner scanFile = new Scanner(patientFile);
            while (scanFile.hasNextLine()) {
                String patient = scanFile.nextLine();
                allPatients = allPatients + patient + "\n";
                allPatientsBackup = allPatientsBackup + patient + "\n";
            }

            String[] patients = allPatients.split("\\n");
            PrintWriter printInFile = new PrintWriter(patientFile);
            try {
                if (petAlreadyThereCheck(nameOfPet, allPatients)) {
                    int indexNumber = samePetLineFinder(nameOfPet, allPatients);
                    patients[indexNumber] = patients[indexNumber]
                            + "," + dayOfPet + "," + entryTimeOfPet + "," + exitTimeOfPet
                            + "," + healthOfPet + "," + painLevelOfPet;
                    for (int i = 0; i < patients.length; i++) {
                        tempFileString = tempFileString + patients[i] + "\n";
                    }
                    printInFile.print(tempFileString);
                } else {
                    allPatientsBackup = allPatientsBackup + patientInfo;
                    printInFile.print(allPatientsBackup);
                }
                scanFile.close();
                printInFile.close();

            } catch (Exception e) {
                returnValue = false;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return returnValue;
    }

    /**
     * This is the helper method to check if the Pet with an appointment is already in the patient file or not.
     * @param nameOfPet Name of the Pet.
     * @param allPatients A string contaning information on all the patients.
     * @return A boolean value.
     */
    private boolean petAlreadyThereCheck(String nameOfPet, String allPatients) {
        boolean bool = false;
        String[] patientsArray = allPatients.split("\\n");
        for (int i = 0; i < patientsArray.length; i++) {
            String[] patientSegments = patientsArray[i].split(",");
            String patientName = patientSegments[0];
            if (nameOfPet.equals(patientName)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    /**
     * Helper method to get the index/line of the String where the same patient information is.
     * @param nameOfPet name of the Pet.
     * @param allPatients A string that contains information on all patients.
     * @return returns the index/line of the String.
     */
    private int samePetLineFinder(String nameOfPet, String allPatients) {
        boolean bool = false;
        String[] patientsArray = allPatients.split("\\n");
        int numOfLine = 0;
        for (int i = 0; i < patientsArray.length; i++) {
            String[] patientSegments = patientsArray[i].split(",");
            String patientName = patientSegments[0];
            if (nameOfPet.equals(patientName)) {
                return i;
            }
        }

        System.out.println("check your logic............");
        return -1;
    }

    /**
     * A method to get the exit time of the pet.
     * @param timeIn A string type number which represents the time the pet came in.
     * @param treatmentTime an int type number which represents the treatment time.
     * @return a string which adds the time in and treatment time to get the exit time in military time format.
     */
    private String addTime(String timeIn, int treatmentTime) {
        int entryTime = Integer.parseInt(timeIn);
        int hoursMilitaryTime = entryTime / 100;
        int minutesMilitaryTime = (entryTime % 100);
        int militaryTimeIntoMinutes = (hoursMilitaryTime * 60) + minutesMilitaryTime;
        int totalMinutes = militaryTimeIntoMinutes + treatmentTime;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        String strHours = (hours < 10) ? "0" + Integer.toString(hours) : Integer.toString(hours);
        String strMinutes = (minutes < 10) ? "0" + Integer.toString(minutes) : Integer.toString(minutes);
        String str = strHours + strMinutes;

        return str;
    }
}
