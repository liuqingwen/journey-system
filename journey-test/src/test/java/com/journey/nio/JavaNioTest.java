package com.journey.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @author liuqingwen
 * @date 2018/9/25.
 */
public class JavaNioTest {

    public static void operate(String fName) {


        ByteBuffer byteBuffer = ByteBuffer.wrap("刘玉琛".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("真可爱".getBytes());

        int byteBufferLen = byteBuffer.limit();
        int byteBuffer2Len = byteBuffer2.limit();

        ByteBuffer[] byteBuffers = new ByteBuffer[]{byteBuffer, byteBuffer2};

        File f = new File(fName);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {

            FileChannel channel = fileOutputStream.getChannel();
            channel.write(byteBuffers);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer allocate = ByteBuffer.allocate(byteBufferLen);
        ByteBuffer allocate2 = ByteBuffer.allocate(byteBuffer2Len);
        ByteBuffer[] byteBuffers2 = new ByteBuffer[]{allocate, allocate2};
        File f2 = new File(fName);

        try (FileInputStream inputStream = new FileInputStream(f2)) {

            FileChannel channel = inputStream.getChannel();
            channel.read(byteBuffers2);

            String first = new String(allocate.array());
            String second = new String(allocate2.array());

            System.out.println(first + second);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test() {

        operate("/Users/liuqingwen/公司/出行日记/workspace/journey-system/journey-test/src/test/java/com/journey/nio/nio.txt");

    }

    private final static String FNAME = "/Users/liuqingwen/公司/出行日记/workspace/journey-system/journey-test/src/test/java/com/journey/nio/nio2.txt";

    @Test
    public void test2() {

        File f = new File(FNAME);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long s = 0;
        System.out.println(s = System.currentTimeMillis());
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {

            for (int index = 0; index < 4_000_000; index++) {
                dataOutputStream.writeInt(index);
            }

            dataOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("write" + "-" + (System.currentTimeMillis() - s));
        System.out.println("write" + "-" + System.currentTimeMillis());

        long s2 = 0;
        System.out.println(s2 = System.currentTimeMillis());
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {

            for (int index = 0; index < 4_000_000; index++) {
                dataInputStream.readInt();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("read" + "-" + (System.currentTimeMillis() - s2));
        System.out.println("read" + "-" + System.currentTimeMillis());

//        1537874775447
//        write-404
//        write-1537874775851
//        1537874775851
//        read-728
//        read-1537874776579
    }

    @Test
    public void test3() {

        File f = new File(FNAME);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long s = 0;
        System.out.println(s = System.currentTimeMillis());
        try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {

            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(4_000_000 * Integer.BYTES);
            for (int index = 0; index < 4_000_000; index++) {
                allocate.put(int2bytes(index));
            }

            allocate.flip();
            channel.write(allocate);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("write" + "-" + (System.currentTimeMillis() - s));
        System.out.println("write" + "-" + System.currentTimeMillis());

        long s2 = 0;
        System.out.println(s2 = System.currentTimeMillis());
        try (FileInputStream fileInputStream = new FileInputStream(f)) {

            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(4_000_000 * Integer.BYTES);
            channel.read(allocate);
            allocate.flip();
            while (allocate.hasRemaining()) {
                bytes2int(allocate.get(), allocate.get(), allocate.get(), allocate.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("read" + "-" + (System.currentTimeMillis() - s2));
        System.out.println("read" + "-" + System.currentTimeMillis());

//        1537875686406
//        write-166
//        write-1537875686573
//        1537875686573
//        read-51
//        read-1537875686624
    }

    private static byte[] int2bytes(int i) {

        byte[] bytes = new byte[4];
        bytes[3] = (byte) (i & 0xfff);
        bytes[2] = (byte) (i >>> 8 & 0xfff);
        bytes[1] = (byte) (i >>> 16 & 0xfff);
        bytes[0] = (byte) (i >>> 24 & 0xfff);
        return bytes;
    }

    private static int bytes2int(byte b1, byte byte2, byte byte3, byte byte4) {
        return b1 << 24 | (byte2 << 16) | (byte3 << 8) | (byte4);
    }

    @Test
    public void test4() {

        int i = 888;
        byte[] bytes = int2bytes(i);
        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes2int(bytes[0], bytes[1], bytes[2], bytes[3]));
    }

    @Test
    public void test5() {

        File f = new File(FNAME);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long s = 0;
        System.out.println(s = System.currentTimeMillis());
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw")) {

            FileChannel channel = randomAccessFile.getChannel();
            IntBuffer intBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 4_000_000 * Integer.BYTES).asIntBuffer();
            for (int index = 0; index < 4_000_000; index++) {
                intBuffer.put(index);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("write" + "-" + (System.currentTimeMillis() - s));
        System.out.println("write" + "-" + System.currentTimeMillis());

        long s2 = 0;
        System.out.println(s2 = System.currentTimeMillis());
        try {

            FileChannel fc = new FileInputStream(f).getChannel();
            MappedByteBuffer lib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            lib.asIntBuffer();
            while(lib.hasRemaining()) {
                lib.get();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("read" + "-" + (System.currentTimeMillis() - s2));
        System.out.println("read" + "-" + System.currentTimeMillis());

//        1537876941774
//        write-89
//        write-1537876941864
//        1537876941864
//        read-14
//        read-1537876941878
    }

}
