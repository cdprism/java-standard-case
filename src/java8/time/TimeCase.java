package java8.time;

import java.time.LocalDate;

/**
 * @author shancm
 * @pachage java8.time
 * @description:
 * @date 2018/5/8
 */
public class TimeCase {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        for(int i=1; i<10; i++){
//            list.add(i);
//        }
//        list.forEach(n -> System.out.println(n));

//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);
//        System.out.println(new Date());

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbtms?Unicode=true&characterEncoding=UTF8", "root", "mysql");
//            String sql = "insert into tms_group_info values ('11111', 'hehe', 'fei', '1', '" + LocalDateTime.now() + "', '" + LocalDateTime.now() + "', '', '')";
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        System.out.println(LocalDate.now());
//        System.out.println(LocalTime.now());
//        System.out.println(Instant.now(Clock.systemDefaultZone()));

//        LocalDate date = LocalDate.of(2018, 5, 8);
//
//        LocalDate beforeWeek = date.minusWeeks(1);
//        System.out.println(beforeWeek);
//todo
//        Clock start = Clock.systemDefaultZone();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Clock.systemDefaultZone() - start);

//        System.out.println(Clock.systemDefaultZone());
//        System.out.println(Clock.systemUTC());


        LocalDate expiredDate = LocalDate.now().plusDays(6*30);

        LocalDate localDate = LocalDate.now();
        LocalDate pre = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
        LocalDate houlai = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.plusDays(1).getDayOfMonth());


        System.out.println(expiredDate);

    }
}
