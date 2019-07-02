package com.wangzhou.datastructure.serial;

import lombok.Data;

import java.io.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/19
 * Time:14:35
 **/
@Data
public class SerializableObject implements Serializable {

    private static final long serialVersionUID = 5235489545027557532L;
    private String a;
    private transient String b;
    private static String c = "abc";

    SerializableObject(String a, String b) {
        this.b = b;
        this.a = a;
    }

    private void writeObject(java.io.ObjectOutputStream s) throws Exception {
        System.out.println("我想自己控制序列化的过程");
        s.defaultWriteObject();
        s.writeInt(b.length());
        for (int i = 0; i < b.length(); i++)
            s.writeChar(b.charAt(i));
    }

    private void readObject(java.io.ObjectInputStream s) throws Exception {
        System.out.println("我想自己控制反序列化的过程");
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
        oos.writeObject(new SerializableObject("a", "b"));
        oos.close();
        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        SerializableObject so = (SerializableObject) ois.readObject();
        System.out.println("a = " + so.getA());
        System.out.println("b = " + so.getB());
        ois.close();
    }
}
