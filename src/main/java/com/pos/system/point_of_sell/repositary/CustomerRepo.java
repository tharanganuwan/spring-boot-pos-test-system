package com.pos.system.point_of_sell.repositary;

import com.pos.system.point_of_sell.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional //only use for the update  native quary
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerNameEquals(String customerName); // or we can use other user
    //List<Customer> findAllByCustomerNameIs(String customerName);
    //List<Customer> findAllByCustomerName(String customerName);


    List<Customer> findAllByActiveStateEquals(boolean b);

    @Modifying //only use for the update native quary
    @Query(value = "update customer set customer_name=?1,nic=?2 where  customer_id=?3",nativeQuery = true)
    void updateCustomerByQuery(String customerName, String nic, int id);

}
