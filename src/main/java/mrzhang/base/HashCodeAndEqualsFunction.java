package mrzhang.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author zhangnianlei
 * @create 2019/9/5.
 * @description
 */
public class HashCodeAndEqualsFunction {

    public static void main(String[] args) {
        List<User> userList = getUserList();
        System.out.println(userList.contains(new User(1L)));
    }

    public static List<User> getUserList(){
        List list = new ArrayList(3);
        list.add(new User(1L));
        list.add(new User(2L));
        list.add(new User(3L));
        list.add(new User(4L));

        return list;
    }

    public static List<Long> getUserIds(List<User> list){
        Stream<User> streamIds = list.stream();
        List<Long> ids = new ArrayList<>(3);
        streamIds.forEach(n -> ids.add(n.id));
        return ids;
    }
    static class User{
        Long id;
        String username;
        String password;

        public User(Long id) {
            this.id = id;
        }

        /* use idea alt+insert to add equals and hashCode function */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(id, user.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
