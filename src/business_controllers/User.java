package business_controllers;

public class User {
    private int Id;
    private String Name;
    private String Phone;
    private String Username;
    private String Password;
    private String Address;
    private String Type;
   
    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getAddress() {
        return Address;
    }

    public String getType() {
        return Type;
    }
}
