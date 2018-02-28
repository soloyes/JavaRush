package tests;

import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.nio.file.Paths;
import java.util.Arrays;

class ZipFileManagerTest {

    ZipFileManager zipFileManager;

    @Test
    void testGetFilesList(){
        zipFileManager = new ZipFileManager(Paths.get("/home/sol/test.zip"));

        try {
            System.out.println(Arrays.deepToString(zipFileManager.getFilesList().toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testExtractAll(){
        zipFileManager = new ZipFileManager(Paths.get("/home/sol/test.zip"));

        try {
            zipFileManager.extractAll(Paths.get("/home/sol/test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRemoveFiles(){
        zipFileManager = new ZipFileManager(Paths.get("/home/sol/test1.zip"));

        try {
            zipFileManager.removeFiles(Arrays.asList(Paths.get("Wallpapers/Firefox_wallpaper.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testExtractAllException(){

        zipFileManager = new ZipFileManager(Paths.get("/home/sol/test.zip1"));

        Assertions.assertThrows(WrongZipFileException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                zipFileManager.extractAll(Paths.get("/tmp"));
            }
        });
    }
}