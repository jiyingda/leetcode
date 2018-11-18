package concurrent.thread005;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    private final static Path DEFAULT_CLASS_DIR = Paths.get("E:");

    private final Path classDir;

    public MyClassLoader(){
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }


    public MyClassLoader(String cDir){
        super();
        this.classDir = Paths.get(cDir);
    }

    public MyClassLoader(String cDir, ClassLoader parent){
        super(parent);
        this.classDir = Paths.get(cDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        if (null == classBytes || classBytes.length == 0){
            throw new ClassNotFoundException();
        }
        return this.defineClass(name,classBytes,0,classBytes.length);
    }


    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");

        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if(!classFullPath.toFile().exists()){
            throw new ClassNotFoundException();
        }


        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }

    }

    @Override
    public String toString(){
        return "My classloader";
    }

}
