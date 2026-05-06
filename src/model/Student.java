package model;

public class Student {
    private int id;
    private String name;
    private String parentDetails;
    private String address;
    private String className;
    private String section;
    private String prevPerformance;

    public Student(String name, String parentDetails, String address, String className, String section, String prevPerformance) {
        this.name = name;
        this.parentDetails = parentDetails;
        this.address = address;
        this.className = className;
        this.section = section;
        this.prevPerformance = prevPerformance;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getParentDetails() { return parentDetails; }
    public String getAddress() { return address; }
    public String getClassName() { return className; }
    public String getSection() { return section; }
    public String getPrevPerformance() { return prevPerformance; }
}
