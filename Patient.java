class Patient extends Record {
    
    private int age;
    private TestType testType;
    private boolean reportStatus = false;
    private Doctor assignedDoctor;
    public Patient(int id, String name, TestType testType, int age, boolean reportStatus, Doctor assignedDoctor) {
        super(id, name);
        this.age = age;
        this.testType = testType;
        this.reportStatus = reportStatus;
        this.assignedDoctor = assignedDoctor;
    }
    
    public Patient(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }
    
    public Doctor getDAssigedDoctorr(){
        return assignedDoctor;
    }
    
    public int getAge() {
        return age;
    }

    public TestType getTestType() {
        //Returning the type of the test
        return testType; 
    }
    
    public void setTestType(TestType testType){
        this.testType = testType;
    }

    public String getReportStatus() {
    return reportStatus ? "Collected" : "To be Collected";
    }
    
    public void setReportStatus(boolean newReportStatus) {
        this.reportStatus = newReportStatus;
    }
    
    public Doctor getAssignedDoctor() {
        return (assignedDoctor);
    }

    public void setDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
    }
    
    @Override
    public String toString() {
        return "\nPatient ID: " + getId() +
                ", Name: " + getName() +
                ", Test Type: " + getTestType() +
                ", Age: " + getAge() +
                ", Report: " + getReportStatus()+
                ", \nAssigned Doctor: " + getAssignedDoctor();
    }
}