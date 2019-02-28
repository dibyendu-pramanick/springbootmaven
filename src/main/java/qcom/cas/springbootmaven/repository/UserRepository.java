package qcom.cas.springbootmaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qcom.cas.springbootmaven.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.age > :age")
	List<User> findUsersByAge(@Param("age") int age);
	
	@Modifying
	@Query("UPDATE User SET firstName = :firstName WHERE id= :id")
	void updateFirstName(@Param("id") int id, @Param("firstName") String firstName);
	
	@Modifying
	@Query("UPDATE User SET lastName = :lastName WHERE id= :id")
	void updateLastName(@Param("id") int id, @Param("lastName") String lastName);

}
