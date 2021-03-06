package com.ebp.owat.lib.runner.utils;

/**
 * Enum to describe the types of matrices
 */
public enum MatrixMode {
	HASHED("hashed"),
	LINKED("linked"),
	ARRAY("array");

	public final String name;

	MatrixMode(String name){
		this.name = name;
	}

	/**
	 * Determines which matrix type to use based on the number of elements in the set to hold.
	 * @param n The number of elements to hold
	 * @return The matrix mode best to use.
	 */
	public static MatrixMode determineModeToUse(long n){
		return ARRAY;//allways the most efficient, https://github.com/Epic-Breakfast-Productions/OWAT/blob/master/implementations/java/Matrix%20Implementation%20Analysis/OWAT_Matrix_Implementation_Analysis.md
	}
}
