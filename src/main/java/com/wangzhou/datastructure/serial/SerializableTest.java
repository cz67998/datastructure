package com.wangzhou.datastructure.serial;

import lombok.Data;

import java.io.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/19
 * Time:15:07
 **/
@Data
public class SerializableTest implements Serializable{
    private static final long serialVersionUID = 3256344854610436079L;
    private String a;
    private transient String b;
    SerializableTest(String a, String b) {
        this.b = b;
        this.a = a;
    }
    private void writeObject(java.io.ObjectOutputStream s) throws Exception {
        System.out.println("SerializableTest序列化");
        s.defaultWriteObject();
        s.writeInt(b.length());
        for (int i = 0; i < b.length(); i++)
            s.writeChar(b.charAt(i));
    }

    private void readObject(java.io.ObjectInputStream s) throws Exception {
        System.out.println("SerializableTest反序列化");
        s.defaultReadObject();
        int length = s.readInt();
        char[] cs = new char[length];
        for (int i = 0; i < length; i++)
            cs[i] = s.readChar();
        b = new String(cs, 0, length);
    }

    public static void main(String[] args) throws Exception {

        File file = new File("D:\\Users\\Administrator\\Desktop" + File.separator + "s.txt");
        OutputStream os = new FileOutputStream(file);

        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(new SerializableTest("a", "b1"));
        oos.close();
        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        SerializableTest so = (SerializableTest) ois.readObject();
        System.out.println("a = " + so.getA());
        System.out.println("b = " + so.getB());
        ois.close();
    }
}
