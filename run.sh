import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Run {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Run <ClassName>");
            System.out.println("Example: java Run dataAbstraction");
            return;
        }

        String className = args[0];

        try {
            Path javaFile = findJavaFile(Paths.get("src"), className + ".java");

            if (javaFile == null) {
                System.out.println("Error: " + className + ".java not found in src/");
                return;
            }

            File binDir = new File("bin");
            if (!binDir.exists()) {
                binDir.mkdirs();
            }

            System.out.println("Compiling " + javaFile + "...");

            Process compile = new ProcessBuilder(
                    "javac",
                    "-d",
                    "bin",
                    javaFile.toString()
            ).inheritIO().start();

            if (compile.waitFor() != 0) {
                System.out.println("Compilation failed!");
                return;
            }

            System.out.println("Running " + className + "...");

            Process run = new ProcessBuilder(
                    "java",
                    "-cp",
                    "bin",
                    className
            ).inheritIO().start();

            run.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Path findJavaFile(Path root, String fileName) throws IOException {
        try (Stream<Path> paths = Files.walk(root)) {
            return paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equals(fileName))
                    .findFirst()
                    .orElse(null);
        }
    }
}
