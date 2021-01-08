package com.mytech.signal;

import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.github.psambit9791.jdsp.signal.peaks.FindPeak;
import com.github.psambit9791.jdsp.signal.peaks.Peak;

public class JdspFindMaximaAndMinima {

	public static int[] argrelmax(double... signal) {
		FindPeak findPeak = new FindPeak(signal);
		int[] maxRes = findPeak.detectRelativeMaxima();
		System.out.print("argrelmax :" + Arrays.stream(maxRes).boxed().collect(Collectors.toList()));
		return maxRes;
	}

	public static int[] argrelmin(double... signal) {
		FindPeak findPeak = new FindPeak(signal);
		int[] minRes = findPeak.detectRelativeMinima();
		System.out.print("\n argrelmin :" + Arrays.stream(minRes).boxed().collect(Collectors.toList()));
		return minRes;
	}

	public static int[] find_peaks(double... signal) {

		double[] negateVal = new double[signal.length];
		for (int i = 0; i < signal.length; i++) {
			negateVal[i] = (signal[i] * -1);
		}

		// get Absolute value
		double[] arrAbsSignal = new double[signal.length];
		for (int i = 0; i < signal.length; i++) {
			arrAbsSignal[i] = Math.abs(signal[i]);
		}
		Arrays.sort(arrAbsSignal);
		int len = arrAbsSignal.length;
		double res;

		// get Median
		if ((len % 2) != 0) {
			res = (double) arrAbsSignal[len / 2];
		} else {
			res = (double) (arrAbsSignal[(len - 1) / 2] + arrAbsSignal[len / 2]) / 2.0;
		}

		double proMdn = (res) * 2 - 50;
		FindPeak findPeak = new FindPeak(negateVal);
		Peak peak = findPeak.detectPeaks();
		int[] peaksArr = peak.getPeaks();
		int[] mediunArr = peak.filterByProminence(peaksArr, proMdn, null);
		System.out.print("\n filterByProminence :" + Arrays.stream(mediunArr).boxed().collect(Collectors.toList()));
		return mediunArr;
	}

	public static void main(String[] args) {
		// Get Input From JSON file .....
		JSONParser parser = new JSONParser();
		double[] signal = null;
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("signal_input\\1_1.json"));
			JSONObject jsonChildObject = (JSONObject) jsonObject.get("AC");
			JSONArray jsonArray = (JSONArray) jsonChildObject.get("signal");
			signal = new double[jsonArray.size()];
			for (int i = 0; i < jsonArray.size(); i++) {
				signal[i] = Double.parseDouble(jsonArray.get(i).toString());
			}
			JdspFindMaximaAndMinima.argrelmax(signal);
			JdspFindMaximaAndMinima.argrelmin(signal);
			// Find Peaks
			JdspFindMaximaAndMinima.find_peaks(signal);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
