package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.State;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private State state;

}
