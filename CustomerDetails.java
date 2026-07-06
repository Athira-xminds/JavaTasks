import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDetails {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
                new Customer("1234562", "Ram", "ram@gmail.com", "Abcdf", "password@1", true),
                new Customer("245678", "Ravi", "ravi@gmail.com", "asdfg", "password@2", false)
        );

        List<CustomerDto> dtos = customers.stream()
                .map(cust -> new CustomerDto(cust.getId(), cust.getName(), cust.getEmail(), cust.getAddress()))
                .collect(Collectors.toList());

        System.out.println(dtos);
    }
}
