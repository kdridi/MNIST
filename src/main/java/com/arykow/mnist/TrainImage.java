package com.arykow.mnist;

import java.util.Collections;
import java.util.List;

public class TrainImage {
	public final int rows;
	public final int columns;
	public final List<Integer> pixels;

	public TrainImage(final int rows, final int columns, final List<Integer> pixels) {
		this.rows = rows;
		this.columns = columns;
		this.pixels = Collections.unmodifiableList(pixels);
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer((this.rows + 1) * (this.columns + 1));

		buffer.append('+');
		for (int j = 0; j < this.columns; j++) {
			buffer.append('-');
		}
		buffer.append('+');
		buffer.append('\n');

		for (int i = 0; i < this.rows; i++) {
			buffer.append('|');
			for (int j = 0; j < this.columns; j++) {
				int pixel = pixels.get(i * this.columns + j);
				buffer.append(String.format("%c", pixel == 0 ? ' ' : (pixel > 32 ? '*' : (pixel > 16 ? 'O' : (pixel > 8 ? 'o' : '.')))));
			}
			buffer.append('|');
			buffer.append('\n');
		}

		buffer.append('+');
		for (int j = 0; j < this.columns; j++) {
			buffer.append('-');
		}
		buffer.append('+');
		buffer.append('\n');

		return buffer.toString();
	}

}
