package com.journey.nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liuqingwen
 * @date 2018/9/9.
 */
public class NioTest {

    @Test
    public void test() {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/liuqingwen/Downloads/unreceived_exchange-code/20180908/6105.txt", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = channel.read(byteBuffer);
            while (read > -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
//                    System.out.print((byte)byteBuffer.get());
                    System.out.print(new String(byteBuffer.array()));
                }
                byteBuffer.clear();
                read = channel.read(byteBuffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
