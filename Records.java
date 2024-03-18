import java.util.*;
public abstract class Records
{
    protected LinkedList<Record> records = new LinkedList<Record>();
    public Records()
    {
    }
    
    public void add(Record record)
    {
        records.add(record);   
    }
    
    public Record find(int id)
    {   
        for (Record record : records)
        {   
            if (record.matches(id))
                return record;  
        }
        return null;    
    }
    

    public int genID(){
        int lastID = records.size();
        return lastID+1;
    }
    
    public int size(){
        return records.size();
    }
    
    public LinkedList<Record> getAllRecords() {
        return records;
    }
    
    public String toString()
    {
        String s = "";
        for (Record record : records)
            s += "\n" + record.toString();
        return s;
    }
    
    public void displayAllRecords() {
        for (Record record : getAllRecords()) {
            System.out.println(record.toString());
        }
    } 
}

