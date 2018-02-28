package tests;


import com.javarush.task.task31.task3110.FileProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilePropertiesTest {

    FileProperties fileProperties = new FileProperties("test", 2048, 1024, 1);
    @Test
    void testString(){
        Assertions.assertEquals(fileProperties.toString(), "test 2 Kb (1 Kb) сжатие: 50%");
    }
}