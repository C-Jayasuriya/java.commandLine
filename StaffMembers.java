class StaffMembers extends Records{

    public StaffMembers() {
        setupStaffMembers();
    }
    
    public void addStaffMember(StaffMember staffMember) {
        add(staffMember);
    }
    
    public void setupStaffMembers() {
        addStaffMember(new StaffMember(1, "John Smith", Availability.AVAILABLE));
        addStaffMember(new StaffMember(2, "Jane Doe", Availability.ON_LEAVE));
        addStaffMember(new StaffMember(3, "Bob Johnson", Availability.AVAILABLE));
        addStaffMember(new StaffMember(4, "Alice Brown", Availability.ON_BREAK));
        addStaffMember(new StaffMember(5, "Charlie Davis", Availability.AVAILABLE));
    }
    
    public void addStaffMember() {
        System.out.println("\nAdd a Staff Member");
        int id = genID();
        String name = In.readMessage("staff member's name");
        Availability availability = readAvailability();
    
        if (availability != null) {
            StaffMember newStaffMember = new StaffMember(id, name, availability);
            addStaffMember(newStaffMember);
            System.out.println("Staff member added successfully!\n" + newStaffMember.toString());
        } else {
            System.out.println("Invalid availability code. Please enter a valid code (A, L, B).\n");
        }
    }
    
        private Availability readAvailability() {
        Availability availability = null;
    
        while (availability == null) {
            System.out.println("Enter the current availability (A - Available / L - On leave / B - On Break):");
            String availabilityCode = In.nextLine().toUpperCase();
            availability = Availability.fromCode(availabilityCode);
    
            if (availability == null) {
                System.out.println("Please enter a valid code.");
            }
        }
    
        return availability;
    }

    public void displayAvailableRecords() {
        for (Record record : getAllRecords()) {
            if (record instanceof StaffMember) {
                StaffMember staffMember = (StaffMember) record;
    
                if (staffMember.getAvailability() == Availability.AVAILABLE) {
                    System.out.println(staffMember.toString());
                }
            }
        }
    }
}