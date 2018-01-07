package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;

public class ContactDetailsDTO {

    String contactName;
    String contactEmail;
    String contactNumber;

    public ContactDetailsDTO(String contactName, String contactEmail, String contactNumber) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
