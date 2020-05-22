package com.readingFiles;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new IOException("Exception from close");
    }
    public void saySomething() throws IOException {
        throw new IOException("Exception form saySomething()");
    }
}
