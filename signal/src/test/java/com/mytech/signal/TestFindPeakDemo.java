package com.mytech.signal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFindPeakDemo {
	

	private static double[] signal = { 0.228, 0.423, 0.304, 0.16, 0.241, 0.265, 0.168, 0.038, -0.017, 0.54, 0.234,
			-0.069, -0.094, -0.086, -0.04, 0.007, 0.056, 0.129, 0.112, 0.003, -0.008, 0.051, 0.013, -0.129, -0.221,
			0.214, 0.345, -0.22, -0.289, -0.293 };
	
	private final double[] simpleSignal ={0.   ,  0.193,  0.381,  0.559,  0.723,  0.869,  0.994,  1.094, 1.169,  1.218,  1.24 ,  1.237,  1.21 ,  1.163,  1.098,  1.02 ,
            0.932,  0.838,  0.744,  0.653,  0.57 ,  0.498,  0.439,  0.396, 0.37 ,  0.362,  0.371,  0.396,  0.435,  0.485,  0.543,  0.605,
            0.668,  0.726,  0.776,  0.814,  0.836,  0.839,  0.82 ,  0.779, 0.713,  0.624,  0.512,  0.379,  0.227,  0.061, -0.117, -0.3  ,
            -0.486, -0.668, -0.843, -1.004, -1.148, -1.272, -1.371, -1.444, -1.49 , -1.507, -1.497, -1.459, -1.398, -1.314, -1.213, -1.098,
            -0.973, -0.843, -0.713, -0.587, -0.469, -0.363, -0.271, -0.196, -0.14 , -0.103, -0.084, -0.083, -0.097, -0.124, -0.161, -0.203,
            -0.248, -0.29 , -0.327, -0.353, -0.365, -0.361, -0.338, -0.295, -0.23 , -0.144, -0.039,  0.085,  0.224,  0.376,  0.535,  0.698,
            0.86 ,  1.016,  1.162,  1.292,  1.404,  1.493,  1.556,  1.592, 1.599,  1.577,  1.528,  1.451,  1.351,  1.229,  1.091,  0.939,
            0.779,  0.616,  0.455,  0.299,  0.153,  0.021, -0.094, -0.19 , -0.265, -0.319, -0.352, -0.365, -0.361, -0.341, -0.309, -0.27 ,
            -0.226, -0.181, -0.141, -0.109, -0.088, -0.081, -0.091, -0.119, -0.166, -0.232, -0.315, -0.414, -0.527, -0.649, -0.778, -0.909,
            -1.036, -1.157, -1.266, -1.358, -1.431, -1.481, -1.505, -1.502, -1.471, -1.411, -1.325, -1.213, -1.079, -0.925, -0.757, -0.578,
            -0.393, -0.208, -0.027,  0.146,  0.305,  0.448,  0.571,  0.672, 0.749,  0.802,  0.832,  0.84 ,  0.827,  0.797,  0.753,  0.698,
            0.637,  0.574,  0.513,  0.458,  0.413,  0.381,  0.364,  0.364, 0.381,  0.415,  0.466,  0.532,  0.611,  0.698,  0.791,  0.885,
            0.976,  1.06 ,  1.133,  1.189,  1.226,  1.242,  1.232,  1.197, 1.135,  1.047,  0.934,  0.799,  0.643,  0.472,  0.288,  0.097,
            -0.097, -0.288, -0.472, -0.643, -0.799, -0.934, -1.047, -1.135, -1.197, -1.232, -1.242, -1.226, -1.189, -1.133, -1.06 , -0.976,
            -0.885, -0.791, -0.698, -0.611, -0.532, -0.466, -0.415, -0.381, -0.364, -0.364, -0.381, -0.413, -0.458, -0.513, -0.574, -0.637,
            -0.698, -0.753, -0.797, -0.827, -0.84 , -0.832, -0.802, -0.749, -0.672, -0.571};
	
	@Test
	public void maximaTest() {
		int[] result = { 1, 5, 9, 17, 21, 26 };
		int[] out = JdspFindMaximaAndMinima.argrelmax(signal);
		Assertions.assertArrayEquals(result, out);
	}

	@Test
	public void minimaTest() {
		int[] result = { 3, 8, 12, 20, 24 };
		int[] out = JdspFindMaximaAndMinima.argrelmin(signal);
		Assertions.assertArrayEquals(result, out);
	}

	@Test
    public void peakDetectTest() {
        int[] resultPeaks = {10,  37,  75, 104, 133, 171, 197, 232};
        JdspFindMaximaAndMinima.find_peaks(simpleSignal);
	}
}