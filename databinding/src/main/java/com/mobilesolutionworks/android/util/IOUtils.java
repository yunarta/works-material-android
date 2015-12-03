/*
 * Copyright 2015-present Yunarta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.mobilesolutionworks.android.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yunarta on 20/7/15.
 */
public class IOUtils
{
    /**
     * Copy source file into destination.
     *
     * @param source      source file
     * @param destination destination
     * @throws IOException if the source file is not found or copy operation failed
     */
    public static void copy(File source, File destination) throws IOException
    {
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(destination);

        copy(in, out);
        close(in);
        close(out);
    }

    /**
     * Close any closable gracefully
     *
     * @param closeable @Closable object.
     */
    public static void close(Closeable closeable)
    {
        try
        {
            closeable.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Consume an InputStream into a ByteArrayOutputStream.
     * <p>
     * This method did not close the input stream.
     *
     * @param in input stream
     * @return content of input stream in byte array output stream
     * @throws IOException if the operation failed
     */
    public static ByteArrayOutputStream consumeAsBuffer(InputStream in) throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buf = new byte[10240];
        int read;

        while (-1 != (read = in.read(buf)))
        {
            out.write(buf, 0, read);
        }

        return out;
    }

    /**
     * Consume an InputStream into String
     * <p>
     * This method did not close the input stream.
     *
     * @param in input stream
     * @return content of input stream as a String
     * @throws IOException if the operation failed
     */
    public static String consumeAsString(InputStream in) throws IOException
    {
        return consumeAsBuffer(in).toString("UTF-8");
    }

    /**
     * Copy InputStream content to specified OutputStream
     *
     * @param in  input stream
     * @param out output stream
     * @throws IOException if the operation failed
     */
    public static void copy(InputStream in, OutputStream out) throws IOException
    {
        byte[] buf = new byte[10240];
        int read;

        while (-1 != (read = in.read(buf)))
        {
            out.write(buf, 0, read);
        }
    }

    /**
     * Write the byte content input OutputStream
     *
     * @param bytes byte content
     * @param out   output stream
     * @throws IOException if the operation failed
     */
    public static void writeAndClose(byte[] bytes, OutputStream out) throws IOException
    {
        out.write(bytes);
        out.close();
    }
}
