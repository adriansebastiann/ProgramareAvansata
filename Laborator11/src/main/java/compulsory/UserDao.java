package compulsory;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
