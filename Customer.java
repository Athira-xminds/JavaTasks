/**
 1.Create a Customer and CustomerDto classes.
 Customer class contains fields-->id,name,email,address,password,active
 CustomerDto class contains fields--->id,name,email,address
 Make a list of customer objects.Convert it into a list of customerDto objects using stream methods.
 */
class Customer {
    String id;
    String name;
    String email;
    String address;
    String password;
    boolean active;

    public Customer(String id, String name, String email, String address, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.active = active;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
}

class CustomerDto {
    String id;
    String name;
    String email;
    String address;

    public CustomerDto(String id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String toString() {
        return "CustomerDto{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

