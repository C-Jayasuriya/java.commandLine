class StaffMember extends Record {
    
     private Availability availability;
    public StaffMember(int id, String name, Availability availability ) {
       super(id, name);
       this.availability = availability;
    }
     
    public Availability getAvailability() {
        return availability;
    }
    
    @Override
    public String toString()
    {
     return "Staff ID: " + getId() +
                    ", Name: " + getName() +
                    ", The Availability: " + getAvailability();   
    }
}