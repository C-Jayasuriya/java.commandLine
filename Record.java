public class Record
{
    protected int id;
    protected String name;
    
    public Record(int id, String name)
    {
        this.id = id;
        this.name = name;
        
    }
    
    public boolean matches(int id)
    {
        return this.id == id;
    }
    
    public int getId() {
        return id ; 
    }
    
    public String getName() {
        return name; 
    }
    
    @Override
    public String toString()
    {
        return id + " " + name;
    }
}
