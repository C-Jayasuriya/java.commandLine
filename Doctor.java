class Doctor extends Record {
    
    private String emergencyContact;
    private String speciality;
    
    public Doctor(int id, String name, String emergencyContact,String speciality) {
        super(id, name);
        this.emergencyContact = emergencyContact;
        this.speciality = speciality;
    }
    
    private String getSpecialization() {
        return speciality;
    }
    
    private String getEmergencyContact(){
        return emergencyContact;
    }
    
    @Override
    public String toString() {
        return "Doctor ID: " + getId() +
                ", Name: " + getName() +
                ", Speciality: " + getSpecialization() +
                ", Contact: " + getEmergencyContact();
    }
}