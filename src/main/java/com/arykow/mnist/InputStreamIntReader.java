package com.arykow.mnist;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class InputStreamIntReader {
	private final InputStream inputStream;
	private final ByteOrder byteOrder;

	public InputStreamIntReader(final InputStream inputStream, final ByteOrder byteOrder) {
		super();
		this.inputStream = inputStream;
		this.byteOrder = byteOrder;
	}

	public int nextUInt32() throws IOException {
		final byte[] bytes = new byte[32 / 8];
		inputStream.read(bytes, 0, bytes.length);
		final ByteBuffer buffer = ByteBuffer.wrap(bytes).order(byteOrder);
		return buffer.getInt();
	}

	public int nextUInt8() throws IOException {
		final byte[] bytes = new byte[8 / 8];
		inputStream.read(bytes, 0, bytes.length);
		return bytes[0];
	}

	public TrainImage nextTrainImage(final int rows, final int columns) throws IOException {
		final int capacity = rows * columns;
		final List<Integer> pixels = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++)
			pixels.add(nextUInt8());
		return new TrainImage(rows, columns, pixels);
	}
}
