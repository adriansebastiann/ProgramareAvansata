package homework.dao;


import homework.model.Friendship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendshipDao extends CrudRepository<Friendship, Integer> {
}
