package com.io2;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liuqingwen
 * @date 2018/12/12.
 */
public class IOTest {

    @Test
    public void test() {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("/data/logs/task-center-api/task-center-api.log", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1_000);
            while (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                System.out.print(new String(byteBuffer.array()));
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
