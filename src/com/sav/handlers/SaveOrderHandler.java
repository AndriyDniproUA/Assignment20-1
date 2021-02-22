package com.sav.handlers;

import com.sav.entities.Order;
import com.sav.utils.DefaultOrderSerializer;
import com.sav.utils.OrderSerializer;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@RequiredArgsConstructor
public class SaveOrderHandler extends OrderHandler {
    private final String filePath;
    private OrderSerializer serializer = new DefaultOrderSerializer();

    @Override
    public void handle(Order o) {
        System.out.println("Saving order to file");
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Path.of(filePath),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.clear();
            buffer.put((serializer.serialize(o) + "\n").getBytes(StandardCharsets.UTF_8));
            buffer.limit(buffer.position());
            buffer.position(0);
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (next!=null) next(o);
    }
}

