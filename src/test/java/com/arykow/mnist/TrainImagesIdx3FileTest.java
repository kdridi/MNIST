package com.arykow.mnist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.nio.ByteOrder;

import org.junit.Test;

public class TrainImagesIdx3FileTest {
	@Test
	public void shouldExists() {
		assertNotNull(getClass().getResourceAsStream("/train-images-idx3-ubyte"));
	}

	@Test
	public void shouldHaveMagicNumber() {
		final InputStreamIntReader reader = new InputStreamIntReader(getClass().getResourceAsStream("/train-images-idx3-ubyte"), ByteOrder.BIG_ENDIAN);

		int magicNumber = 0;
		IOException exception = null;
		try {
			magicNumber = reader.nextUInt32();
		} catch (IOException e) {
			exception = e;
		}

		assertNull(exception);
		assertEquals(0x00000803, magicNumber);
	}

	@Test
	public void shouldHaveNumberOfImages() {
		final InputStreamIntReader reader = new InputStreamIntReader(getClass().getResourceAsStream("/train-images-idx3-ubyte"), ByteOrder.BIG_ENDIAN);

		int numberOfImages = 0;
		IOException exception = null;
		try {
			reader.nextUInt32();
			numberOfImages = reader.nextUInt32();
		} catch (IOException e) {
			exception = e;
		}

		assertNull(exception);
		assertEquals(60000, numberOfImages);
	}

	@Test
	public void shouldHaveNumberOfRows() {
		final InputStreamIntReader reader = new InputStreamIntReader(getClass().getResourceAsStream("/train-images-idx3-ubyte"), ByteOrder.BIG_ENDIAN);

		int numberOfRows = 0;
		IOException exception = null;
		try {
			reader.nextUInt32();
			reader.nextUInt32();
			numberOfRows = reader.nextUInt32();
		} catch (IOException e) {
			exception = e;
		}

		assertNull(exception);
		assertEquals(28, numberOfRows);
	}

	@Test
	public void shouldHaveNumberOfColumns() {
		final InputStreamIntReader reader = new InputStreamIntReader(getClass().getResourceAsStream("/train-images-idx3-ubyte"), ByteOrder.BIG_ENDIAN);

		int numberOfColumns = 0;
		IOException exception = null;
		try {
			reader.nextUInt32();
			reader.nextUInt32();
			reader.nextUInt32();
			numberOfColumns = reader.nextUInt32();
		} catch (IOException e) {
			exception = e;
		}

		assertNull(exception);
		assertEquals(28, numberOfColumns);
	}

	@Test
	public void shouldHaveHeader() {
		final TrainImagesIdx3File file = new TrainImagesIdx3File();

		assertEquals(0x00000803, file.magicNumber);
		assertEquals(60000, file.images.size());
		file.images.forEach(image -> {
			assertEquals(28, image.rows);
			assertEquals(28, image.columns);
		});
	}

}
