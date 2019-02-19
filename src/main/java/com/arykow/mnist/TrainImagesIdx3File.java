package com.arykow.mnist;

import java.io.IOException;
import java.nio.ByteOrder;

public class TrainImagesIdx3File {
	public final int magicNumber;
	public final int numberOfImages;
	public final int numberOfRows;
	public final int numberOfColumns;

	public TrainImagesIdx3File() {
		final InputStreamIntReader reader = new InputStreamIntReader(getClass().getResourceAsStream("/train-images-idx3-ubyte"), ByteOrder.BIG_ENDIAN);

		int magicNumber = 0;
		int numberOfImages = 0;
		int numberOfRows = 0;
		int numberOfColumns = 0;

		try {
			magicNumber = reader.nextUInt32();
			numberOfImages = reader.nextUInt32();
			numberOfRows = reader.nextUInt32();
			numberOfColumns = reader.nextUInt32();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		this.magicNumber = magicNumber;
		this.numberOfImages = numberOfImages;
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
	}
}
