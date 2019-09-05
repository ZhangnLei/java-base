package mrzhang.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author zhangnianlei
 * @create 2019/9/5.
 * @description stream
 */
public class StreamAPI {
    public static void main(String[] args) {
//        UseStream();

        List<Long> userIds = getUserIds(getUserList());
        userIds.forEach(n -> System.out.println(n));
        System.out.println();

        List<User> userList = getUserList();
        System.out.println(userList.contains(new User(1L)));
    }

    private static void UseStream() {
        Stream<String> streamEmpty = Stream.empty();

        System.out.println(streamEmpty);
        System.out.println();

        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c").build();
        streamBuilder.forEach(n -> System.out.println(n));
        System.out.println();

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(n -> System.out.println(n));
        System.out.println();

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        streamOfCollection.forEach(n -> System.out.println(n));
        System.out.println();

//        Array也可以是Stream的源
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
//        它们也可以从现有数组或数组的一部分创建：
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    }

    public static List<User> getUserList(){
        List list = new ArrayList(3);
        list.add(new User(1L));
        list.add(new User(2L));
        list.add(new User(3L));

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
