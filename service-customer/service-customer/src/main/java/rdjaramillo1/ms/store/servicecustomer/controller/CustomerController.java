package rdjaramillo1.ms.store.servicecustomer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rdjaramillo1.ms.store.servicecustomer.entity.Customer;
import rdjaramillo1.ms.store.servicecustomer.entity.Region;
import rdjaramillo1.ms.store.servicecustomer.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // -------------------Retrieve All Customers--------------------------------------------

    @GetMapping
    public ResponseEntity<List<Customer>> listAllCustomers(@RequestParam(name = "regionId" , required = false) Long regionId ) {
        List<Customer> customers =  new ArrayList<>();
        if (null ==  regionId) {
            customers = customerService.findCustomerAll();
            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }else{
            Region Region= new Region();
            Region.setId(regionId);
            customers = customerService.findCustomersByRegion(Region);
            if ( null == customers ) {
                return  ResponseEntity.notFound().build();
            }
        }

        return  ResponseEntity.ok(customers);
    }

    // -------------------Retrieve Single Customer------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomer(id);
        if (  null == customer) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(customer);
    }

    // -------------------Create a Customer-------------------------------------------

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
            Customer customerDB = customerService.createCustomer (customer);

        return  ResponseEntity.status( HttpStatus.CREATED).body(customerDB);
    }

    // ------------------- Update a Customer ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {

        Customer currentCustomer = customerService.getCustomer(id);

        if ( null == currentCustomer ) {
            return  ResponseEntity.notFound().build();
        }
        customer.setId(id);
        currentCustomer=customerService.updateCustomer(customer);
        return  ResponseEntity.ok(currentCustomer);
    }

    // ------------------- Delete a Customer-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomer(id);
        if ( null == customer ) {
            return  ResponseEntity.notFound().build();
        }
        customer = customerService.deleteCustomer(customer);
        return  ResponseEntity.ok(customer);
    }
}
