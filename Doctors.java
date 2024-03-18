import java.util.*;
public class Doctors extends Records {

    public Doctors() {
        setupDoctors();
    }

    public void addDoctor(Doctor doctor) {
        add(doctor);
    }

    public void setupDoctors() {
        add(new Doctor(1, "Dr. Gray Smith", "133-456-7890", "Cardiology"));
        add(new Doctor(2, "Dr. De Johnson", "967-654-3210", "Hematology"));
        add(new Doctor(3, "Dr. Gray willson", "555-223-4567", "Oncology"));
        add(new Doctor(4, "Dr. Carl Bossman", "777-898-9999", "Cardiology"));
    }
  
    public void addDoctor() {
        System.out.println("\nAdd a doctor");
        int id = genID();
        String name = In.readMessage("doctor's name");
        String emergencyContact = In.readMessage(" emergency contact");
        String specialization = In.readMessage("specialization");
        
        Doctor newDoctor = new Doctor(id, name, emergencyContact, specialization);
        addDoctor(newDoctor);
        
        System.out.println("Doctor added to the list successfully!\n" + newDoctor.toString());
    }
    
     public Doctor findDoctorById(int doctorId) {
        for (Record record : getAllRecords()) {
            Doctor doctor = (Doctor) record;
                if (doctor.getId() == doctorId) {
                    return doctor;
                }
        }
        return null;
    }
}
