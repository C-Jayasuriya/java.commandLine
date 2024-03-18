class Patients extends Records {
    private Doctors doctors = new Doctors();
    public void setupTest(Patient newPatient) {
        TestType testType = getTestType();
        boolean reportStatus = isReportCollected();
    
        newPatient.setTestType(testType);
        newPatient.setReportStatus(reportStatus);
    
        addPatient(newPatient);
    
        System.out.println("Patient added to the system !\n" + newPatient.toString());
    }
    
    public void setupPatients() {
        add(new Patient(1, "John carlson", TestType.CBC, 25, false, doctors.findDoctorById(1)));
        add(new Patient(2, "Janna Ferdinando", TestType.FBC, 30, true,doctors.findDoctorById(2)));
        add(new Patient(3, "Bob calson", TestType.URINE, 40, false, doctors.findDoctorById(3)));
        add(new Patient(4, "Alice winterson", TestType.ENDOSCOPY, 35, true, doctors.findDoctorById(4)));
        add(new Patient(5, "Charlie quinn", TestType.MRI, 50, false, doctors.findDoctorById(1))); 
    }
    
    public void addPatient() {
        System.out.println("\n---Add a patient ---");
        int id = genID();
        String name = In.readMessage("patient's name");
   
        int age = In.readInt("Patient's age");
            
        Patient patient = new Patient(id, name, age);
        assignDoctor(patient);
        }
    
    public void assignDoctor(Patient newPatient) {
        System.out.println("Select the doctor for the patient:");
        doctors.displayAllRecords();
    
        int selectedDoctorId = In.nextInt();
        Record selectedRecord = doctors.find(selectedDoctorId);
    
        if (selectedRecord instanceof Doctor) {
            Doctor selectedDoctor = (Doctor) selectedRecord;
            newPatient.setDoctor(selectedDoctor);
            setupTest(newPatient);
        } else {
            System.out.println("Invalid doctor ID. Patient not added yet.");
            assignDoctor(newPatient);
        }
    }
    
    private TestType getTestType() {
        TestType testType = null;
        String testTypeString = In.readMessage(" patient test code: C-CBC, F-FBC, U-URINE, X-XRAY M-MRI").toUpperCase();
    
        while (!(testTypeString.equals("C") || testTypeString.equals("U") || testTypeString.equals("F") || testTypeString.equals("M") || testTypeString.equals("X"))) {
            System.out.println("Invalid test code. Enter a valid code ( patient test code: C-CBC, F-FBC, U-URINE, X-XRAY M-MRI)");
            testTypeString = In.nextLine().toUpperCase();
        }
    
        testType = TestType.fromTestCode(testTypeString);
        return testType;
    }
    
    
    private boolean isReportCollected() {
        String response = getValidResponse("Have you collected the report?");
        if (response.equals("Y")) {
            return true;
        } else if (response.equals("N")) {
            return false;
        } else {
            System.out.println("Invalid response. Please enter 'Y'  or 'N' ");
            return isReportCollected(); 
        }
    }
    
    private String getValidResponse(String prompt) {
        System.out.println(prompt + " (Y/N):");
        return In.nextLine().toUpperCase();
    }


    public void addPatient(Patient p){
        add(p);
    }
    
    public void updateReportStatus(int patientId) {
        Patient patientToUpdate = findPatientById(patientId);
    
        if (patientToUpdate != null) {
            displayCurrentStatus(patientToUpdate);
            updateStatus(patientToUpdate);
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }
    
    private Patient findPatientById(int patientId) {
            Record record = find(patientId);
        
            if (record instanceof Patient) {
                return (Patient) record;
            }
        
        return null;
    }
    
    private void displayCurrentStatus(Patient patientToUpdate) {
        System.out.println("Present Report Status for Patient ID " + patientToUpdate.getId() + ": " +
                patientToUpdate.getReportStatus());
    }
    
    private void updateStatus(Patient patientToUpdate) {
        System.out.println("Enter new report status (Y - Collected / N - To be collected):");
        boolean newReportStatus = In.nextUpperChar() == 'Y';
        patientToUpdate.setReportStatus(newReportStatus);
        System.out.println("Report Status Updated for Patient ID " + patientToUpdate.getId());
    }
}
