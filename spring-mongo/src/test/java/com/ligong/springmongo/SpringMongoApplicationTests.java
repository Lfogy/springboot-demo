package com.ligong.springmongo;


import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SpringMongoApplicationTests {



   /* @Test
    void contextLoads() {
       mongoTemplate.createCollection("products");
        boolean b = mongoTemplate.collectionExists("products");
        System.out.println(b);
    }

    @Test
    void test2() {
        User user = new User();
        user.setId(1);
        user.setAddress("武汉市东西湖区");
        user.setSalary(12000.0);
        user.setName("李四");
        mongoTemplate.save(user);

    }

    @Test
    void test3() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(7);
        user.setAddress("武汉市东西湖区");
        user.setSalary(12000.0);
        user.setName("李四");

        User user2 = new User();
        user.setId(8);
        user.setAddress("武汉市洪山区");
        user.setSalary(11100.0);
        user.setName("王五");

        list.add(user);
        list.add(user2);

        mongoTemplate.insert(list,User.class);

    }
*/

}
