package serialization;

public class CustomerInfo {
    public String FirstName;
    public String LastName;
    public String UserName;
    public String Password;
    public String Email;


    public CustomerInfo(String firstName, String lastName, String userName, String password, String email) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.UserName = userName;
        this.Password = password;
        this.Email = email;
    }
}
