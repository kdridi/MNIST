package com.arykow.mnist;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class InputStreamIntReader {
	private final InputStream inputStream;
	private final ByteOrder byteOrder;

	public InputStreamIntReader(InputStream inputStream, ByteOrder byteOrder) {
		super();
		this.inputStream = inputStream;
		this.byteOrder = byteOrder;
	}

	public int nextUInt32() throws IOException {
		byte[] bytes = new byte[32 / 8];
		inputStream.read(bytes, 0, bytes.length);
		ByteBuffer buffer = ByteBuffer.wrap(bytes).order(byteOrder);
		return buffer.getInt();
	}
}
