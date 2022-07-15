package com.course.producer;

import com.course.producer.entity.Picture;
import com.course.producer.producer.MyPictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

//    @Autowired
//    private RabbitProducer rabbitProducer;

//    @Autowired
//    private EmployeeJsonProducer employeeJsonProducer;

//    @Autowired
//    private HumanResourceProducer humanResourceProducer;

//    @Autowired
//    private PictureProducer pictureProducer;

//    @Autowired
//    private PictureProducerTwo pictureProducerTwo;
//
//    @Autowired
//    private FurnitureProducer furnitureProducer;

    @Autowired
    private MyPictureProducer myPictureProducer;

    private final List<String> colors = List.of("red", "white", "green");
    private final List<String> materials = List.of("wood", "plastic", "steel");


    private final List<String> sources = List.of("mobile", "web");
    private final List<String> types = List.of("jpg", "png", "svg");

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        String[] arr = new String[4];
//        arr[0]="Burak Kabasakal";
//        arr[1]="Aybike Kabasakal";
//        arr[2]="Uraz Kabasakal";
//        arr[3]="Eliz Kabasakal";
//
//        Arrays.stream(arr).forEach(element -> rabbitProducer.sendHello(element));

        //rabbitProducer.fixedRateMessage();

//        for(int i = 0 ; i< 5; i++){
//            Employee employee = Employee.builder()
//                    .name("emp"+i)
//                    .employeeID(String.valueOf(i))
//                    .birthDate(LocalDate.now().plusDays(i))
//                    .build();
//            //employeeJsonProducer.sendMessage(employee);
//            //humanResourceProducer.sendMessage(employee);
//        }

//        for (int i = 0 ; i<10; i++){
//            Picture picture = new Picture();
//            picture.setName("Picture"+ i);
//            picture.setSize(ThreadLocalRandom.current().nextLong(1,10000));
//            picture.setSource(sources.get(i % sources.size()));
//            picture.setType(types.get(i % types.size()));
//
//            // pictureProducer.sendMessage(picture);
//            pictureProducerTwo.sendMessage(picture);
//        }

//        for(int i = 0 ; i< 10 ;i++){
//            Furniture furniture = new Furniture();
//            furniture.setName("Furniture"+i);
//            furniture.setColor(colors.get(i % colors.size()));
//            furniture.setMaterial(materials.get(i % materials.size()));
//            furniture.setPrice(i);
//
//            furnitureProducer.sendMessage(furniture);
//        }

        for (int i = 0; i < 1; i++) {
            Picture picture = new Picture();
            picture.setName("Picture" + i);
            picture.setSize(ThreadLocalRandom.current().nextLong(9000, 10000));
            picture.setSource(sources.get(i % sources.size()));
            picture.setType(types.get(i % types.size()));

            myPictureProducer.sendMessage(picture);
        }

    }
}
