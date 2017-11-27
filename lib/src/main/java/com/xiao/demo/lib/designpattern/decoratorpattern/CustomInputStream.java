package com.xiao.demo.lib.designpattern.decoratorpattern;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileName:com.example.designpattern.decoratorpattern.CustomInputStream.java
 * Created on 2016/9/7
 * Version V1.0
 */
public class CustomInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public CustomInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int read = super.read();
        return read != -1 ? Character.toLowerCase((char)read) : read;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int c = super.read(b, off, len);
        for (int i = 0; i < c + off; i++) {
            b[i] = (byte) Character.toLowerCase((char)b[i]);
        }
        return c;
    }
}
