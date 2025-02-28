public class Visitor {
    private String name;
    private String contactDetails;

    public Visitor(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    @Override
    public String toString() {
        return "Visitor: " + name + " | Contact: " + contactDetails;
    }
}


