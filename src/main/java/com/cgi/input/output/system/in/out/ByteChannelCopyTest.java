package com.cgi.input.output.system.in.out;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ychang on 7/10/2016.
 */
public class ByteChannelCopyTest {

  public static void main(String[] args) {
    try (FileChannel fcIn = new FileInputStream(args[0]).getChannel();
         FileChannel fcOut = new FileOutputStream(args[1]).getChannel()) {
      ByteBuffer buff = ByteBuffer.allocate((int) fcIn.size());
      fcIn.read(buff);
      buff.position(0);
      fcOut.write(buff);
    } catch (FileNotFoundException f) {
      out.println("File not found: " + f);
    } catch (IOException e) {
      out.println("IOException: " + e);
    }
  }
}
