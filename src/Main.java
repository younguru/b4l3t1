import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static boolean createFileDir(String path) {
        File file = new File(path);
        try {
//            так себе условие, но для нашей задачи пойдёт
            if (path.contains(".")) {
                if (file.createNewFile()) {
                    return true;
                }
            } else {
                if (file.mkdir()) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String fs = File.separator;
        String ls = System.getProperty("line.separator");
        String baseDir = "games";
        List<String> paths = new ArrayList<>(Arrays.asList(fs + baseDir,
                fs + baseDir + fs + "src",
                fs + baseDir + fs + "res",
                fs + baseDir + fs + "savegames",
                fs + baseDir + fs + "temp",
                fs + baseDir + fs + "src" + fs + "main",
                fs + baseDir + fs + "src" + fs + "test",
                fs + baseDir + fs + "src" + fs + "main" + fs + "Main.java",
                fs + baseDir + fs + "src" + fs + "main" + fs + "Utils.java",
                fs + baseDir + fs + "res" + fs + "drawables",
                fs + baseDir + fs + "res" + fs + "vectors",
                fs + baseDir + fs + "res" + fs + "icons",
                fs + baseDir + fs + "temp" + fs + "temp.txt"));
        StringBuilder log = new StringBuilder();

        for (String path : paths) {
            if (createFileDir(path)) {
                log.append(path).append("  created successfully").append(ls);
            } else {
                log.append(path).append("  creating error").append(ls);
            }
        }
        try (FileWriter file = new FileWriter(paths.get(12))) {
            file.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}