import java.util.Scanner;

public class LaboratorySystem {
    private StaffMembers staffMembers = new StaffMembers();
    private Patients patients = new Patients();
    private Doctors doctors = new Doctors();

    public LaboratorySystem() {
        patients.setupPatients();
        menu();
    }

    private void menu() {
        char action = readAction();
        switch (action) {
            case 'A': addPatient(); break;
            case 'B': addStaffMember(); break;
            case 'C': addDoctor(); break;
            case 'D': displayPatients(); break;
            case 'E': displayStaffMembers(); break;
            case 'F': displayDoctors(); break;
            case 'G': updateReportStatus(); break;
            case 'H': filterAvailableStaff(); break;
            case 'X': exit(); break;
            case '?': help(); break;
            default: error();
        }
    }

    private char readAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------"
                +"\nMenu Options:\n" +
                "A - Add a new patient.\n" +
                "B - Add a staff member.\n" +
                "C - Add a doctor.\n" +
                "D - Display all patients.\n" +
                "E - Display all staff members.\n" +
                "F - Display all doctors.\n" +
                "G - Update patient report status.\n" +
                "H - Filter available staff members.\n" +
                "X - Exit the program.\n" +
                "? - Display help information.");

        return scanner.next().toUpperCase().charAt(0);
    }

    private void addPatient(){
        patients.addPatient();
        menu();
    }

    private void addStaffMember() {
        staffMembers.addStaffMember();
        menu();
    }

    private void addDoctor(){
        doctors.addDoctor();
        menu();
    }

    private void displayPatients(){
        patients.displayAllRecords();
        menu();
    }

    private void displayStaffMembers(){
        staffMembers.displayAllRecords();
        menu();
    }

    private void displayDoctors(){
        doctors.displayAllRecords();
        menu();
    }

    private void filterAvailableStaff(){
        staffMembers.displayAvailableRecords();
        menu();
    }

    private void updateReportStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the Patient who needs to change the report status:");
        int patientIdToUpdate = scanner.nextInt();
        patients.updateReportStatus(patientIdToUpdate);
        menu();
    }

    private void exit() {
        if (!confirm())
            menu();
        else
            System.out.println("\n-----Thank you for using Asiri Laboratory System-----");
    }

    private boolean confirm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure that you want to exit (y/n)?: ");
        return scanner.next().toUpperCase().charAt(0) == 'Y';
    }

    private void help() {
        System.out.println("Welcome to the Asiri Laboratory System Help Center. Below is an overview of the system functionalities:");
        System.out.println("\nA- This option allows you to add a new patient to the system. It requires details such as ID, name, and more.");
        System.out.println("B- This option allows you to add a new staff member to the system. Enter details like ID, name, and availability (A - Available, L - On leave, B - On Break).");
        System.out.println("C- This option allows you to add a new doctor to the system. Enter ID, name, emergency contact, and specialization details.");
        System.out.println("D- A list of all registered patients in the system.");
        System.out.println("E- A list of all registered staff members, including their availability status.");
        System.out.println("F- A list of all registered doctors, including their contact information and specialization.");
        System.out.println("G- Change the report status of a patient by entering the patient's ID.");
        System.out.println("H- View a list of staff members who are currently available for duty.");
        System.out.println("X- Close the Asiri Laboratory System. You will be prompted to confirm before exiting.");
        System.out.println("-------------------------\nFeel free to explore the system using the above options. Contact system administrator for any other concerns.");
        menu();
    }

    private void error() {a
        System.out.println("No valid actions found. Please Try again");
        menu();
    }

    public static void main(String[] args) {
        LaboratorySystem laboratorySystem = new LaboratorySystem();
    }
}
