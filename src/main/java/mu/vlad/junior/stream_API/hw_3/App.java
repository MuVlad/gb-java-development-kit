package mu.vlad.junior.stream_API.hw_3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

/*
1. Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
  Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
   Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class App {

    private static final String FILE_JSON = "tasks.json";
    private static final String FILE_BIN = "tasks.bin";
    private static final String FILE_XML = "tasks.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) {

        Student student = new Student("Ivan", 17, 4.8);

        serialize(FILE_JSON, student);
        serialize(FILE_BIN, student);
        serialize(FILE_XML, student);

        System.out.println(deSerialize(FILE_JSON));
        System.out.println(deSerialize(FILE_BIN));
        System.out.println(deSerialize(FILE_XML));

    }

    public static <T> void serialize(String fileName, T object) {
        try {
            if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    objectOutputStream.writeObject(object);
                }
            } else if (fileName.endsWith(".json")) {
                objectMapper.writeValue(new File(fileName), object);
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), object);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Student deSerialize(String fileName) {
        Student student = null;

        File file = new File(fileName);

        if (file.exists()) {
            try {
                if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                        student = (Student) objectInputStream.readObject();
                    }
                } else if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, Student.class);
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, Student.class);
                }
            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }

        return student;
    }
}
