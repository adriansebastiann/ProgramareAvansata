package homework.controller;


import homework.dao.FriendshipDao;
import homework.dao.UserDao;
import homework.model.Friendship;
import homework.model.User;
import homework.traditionalDB.UserTraditionalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Controller
@RequestMapping("/friendship")
public class FriendshipController {
    @Autowired
    private FriendshipDao dao;

    @Autowired
    private UserDao usr;

    @PostMapping("/insertFriendship")
    public String insertFriendship(@RequestBody List<Friendship> friendships) {
        dao.saveAll(friendships);
        return friendships.size() + " friendships were injected";
    }

    @GetMapping("/friendship/{id}")
    Optional<Friendship> one(@PathVariable int id) {
        return dao.findById(id);
    }

    /**
     * For the most popular users we count the ids from first row of the table
     * We put them into a hashmap, that is the key, and the value is the number of occurrences
     * We sort this hash map by the occurrences and took out the first "number occurrences"
     * @param number the number of the most popular user we want
     * @return the list with the required users
     */
    @GetMapping("/getPopularPersons/{number}")
    public List<User> getPopularUsers(@PathVariable int number) {
        List<Friendship> friendships = StreamSupport //
                .stream(dao.findAll().spliterator(), false) //
                .collect(Collectors.toList());
        List<Integer> userIds = new ArrayList<>();

        for (Friendship friendship : friendships) {
            userIds.add(friendship.getUserone());
            userIds.add(friendship.getUsertwo());
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer id : userIds) {
            Integer count = frequencyMap.get(id);
            if (count == null) {
                count = 0;
            }
            frequencyMap.put(id, count + 1);
        }

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        List<User> popularUsers = new ArrayList<>();
        for(int index = 0; index < number; index ++) {
            popularUsers.add(UserTraditionalDao.getUserById((int)sortedMap.keySet().toArray()[index]));
        }
        return popularUsers;
    }


}
