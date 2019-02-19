package com.arykow.mnist;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainImagesIdx3File {
	public final int magicNumber;
	public final List<TrainImage> images;

	public TrainImagesIdx3File() {
		final InputStreamIntReader reader = new InputStreamIntReader(getClass().getResourceAsStream("/train-images-idx3-ubyte"), ByteOrder.BIG_ENDIAN);

		int magicNumber = 0;
		int numberOfImages = 0;
		int numberOfRows = 0;
		int numberOfColumns = 0;
		List<TrainImage> images;

		try {
			magicNumber = reader.nextUInt32();
			numberOfImages = reader.nextUInt32();
			numberOfRows = reader.nextUInt32();
			numberOfColumns = reader.nextUInt32();

			images = new ArrayList<>(numberOfImages);
			for (int i = 0; i < numberOfImages; i++)
				images.add(reader.nextTrainImage(numberOfRows, numberOfColumns));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		this.magicNumber = magicNumber;
		this.images = Collections.unmodifiableList(images);
	}
}
