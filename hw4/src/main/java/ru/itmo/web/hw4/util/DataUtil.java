package ru.itmo.web.hw4.util;

import ru.itmo.web.hw4.model.Post;
import ru.itmo.web.hw4.model.User;
import ru.itmo.web.hw4.model.UserColour;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataUtil {
    private static final List<User> USERS = Arrays.asList(
            new User(1, "MikeMirzayanov", "Mike Mirzayanov", UserColour.BLUE),
            new User(6, "pashka", "Pavel Mavrin", UserColour.RED),
            new User(9, "geranazavr555", "Georgiy Nazarov", UserColour.GREEN),
            new User(11, "tourist", "Gennady Korotkevich", UserColour.RED)
    );
    
    private static final List<Post> POSTS = Arrays.asList(
            new Post(1, "useless post1", "qwwertyhngbfvdcssa", 1),
            new Post(3, "useless post2", "1234567876543423456754395869493457949347854738476746747546754674764637327632283681628762378623764783687567456746784648732776327327276426743373644757457654466347673267326732632732732673276326832678236327863287326782363276327832624762475236353265236732562353267523672356253265267325673252365326325632532653267325326532673526235326753263256325265235366476364674267327238732873476546673", 1),
            new Post(5, "useless post3", "qwwertyhngbfvdcssartgfhbfrfbngfbv", 9),
            new Post(6, "useless post4", "qwwertyhngbfvdcssartgfhbfrfbngfbv23454678i", 11)
    );

    private static final List<UserColour> COLOURS = Arrays.asList(
            UserColour.RED, UserColour.BLUE, UserColour.GREEN
    );


    public static void addData(HttpServletRequest request, Map<String, Object> data) {
        data.put("users", USERS);
        data.put("posts", POSTS);
        data.put("colours", COLOURS);

        for (User user : USERS) {
            if (Long.toString(user.getId()).equals(request.getParameter("logged_user_id"))) {
                data.put("user", user);
            }
        }
    }
}
