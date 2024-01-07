package com.core.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

/**
 * This class evaluates a user given expression
 * 
 * @author srinath.rayabarapu
 */
public class TestExpressionEvaluation {

	public static void main(String[] args) {
		new TestExpressionEvaluation().expressionEvaluation();
	}

	/**
	 * method used for evaluating a user given expression
	 */
	public void expressionEvaluation() {

		String inputFile1Path = "data/Input1.txt";
		String inputFile2Path = "data/Input2.txt";
		String exprFile = "data/Expr.txt";

		List<Double> file1DataList = getInputFileDataList(inputFile1Path);
		List<Double> file2DataList = getInputFileDataList(inputFile2Path);
		Map<Integer, List<String>> map = getExpressionFileData(exprFile,
				file1DataList, file2DataList);

		for (int i = 0; i < map.size(); i++) {
			printFileData(map.get(i));
		}
	}

	/**
	 * Reads a file and returns a List with the file data
	 * 
	 * @param inputFile
	 * @return List<Double>
	 */
	private List<Double> getInputFileDataList(String inputFile) {

		int i = 0;
		String token = null;
		List<Double> fileDataList = new ArrayList<Double>();
		BufferedReader reader = null;

		try {
			// reader = new BufferedReader(new FileReader(inputFile));

			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(inputFile);
			reader = new BufferedReader(new InputStreamReader(inputStream));

			while ((token = reader.readLine()) != null) {
				fileDataList.add(i, Double.parseDouble(token));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ignore) {
				// Ignore the exception
			}
		}
		return fileDataList;
	}

	/**
	 * reads Expression file and returns a map with an integer and file data
	 * list as key value pairs
	 * 
	 * @param exprFile
	 * @param file1DataList
	 * @param file2DataList
	 * @return Map<Integer,List<Object>>
	 */
	private Map<Integer, List<String>> getExpressionFileData(String exprFile,
			List<Double> file1DataList, List<Double> file2DataList) {

		BufferedReader reader = null;
		String fileLine = null;

		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		int i = 0;

		try {
			
//			reader = new BufferedReader(new FileReader(exprFile));
			
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(exprFile);
			reader = new BufferedReader(new InputStreamReader(inputStream));

			while ((fileLine = reader.readLine()) != null) {

				List<String> modifiedExprlist = new LinkedList<String>();

				StringTokenizer stringTokenizer = new StringTokenizer(fileLine,
						" ()+-/*%", true);
				// System.out.println("File Line : " + fileLine);

				while (stringTokenizer.hasMoreElements()) {

					String tempToken = stringTokenizer.nextToken();

					if (tempToken.contains("Input1")) {

						modifiedExprlist = getModifiedExpressionList(tempToken,
								file1DataList, modifiedExprlist);

					} else if (tempToken.contains("Input2")) {

						modifiedExprlist = getModifiedExpressionList(tempToken,
								file2DataList, modifiedExprlist);

					} else {
						modifiedExprlist.add(tempToken);
					}
				}
				// System.out.println("-------------------------");
				map.put(i, modifiedExprlist);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// Ignore
			}
		}
		return map;
	}

	/**
	 * prints a given user List
	 * 
	 * @param list
	 */
	private void printFileData(List<String> list) {
		StringBuffer contents = new StringBuffer();

		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			Object temp = iterator.next();
			// System.out.println(temp);
			contents.append(temp);
		}
		System.out.println("Modified Expression : " + contents.toString());

		evaluateExpression(list);

		System.out.println("-------------------------");
	}

	/**
	 * This method replaces expressions to valid data
	 * 
	 * @param tempToken
	 * @param fileDataList
	 * @param modifiedExprlist
	 * @return List<Object>
	 */
	private List<String> getModifiedExpressionList(String tempToken,
			List<Double> fileDataList, List<String> modifiedExprlist) {

		String stringParts[] = tempToken.split("\\.");

		int index = Integer.parseInt(stringParts[1]);
		double value = fileDataList.get(index - 1);
		modifiedExprlist.add(value + "");

		return modifiedExprlist;
	}

	/**
	 * Evaluates an input infix string
	 * 
	 * @param list
	 */
	public void evaluateExpression(List<String> list) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();

		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String temp = iterator.next();
			// System.out.println(temp);

			if (temp.equals("("))
				;

			else if (temp.equals("+")) {
				// System.out.println("Push into op stack "+temp);
				ops.push(temp);
			}

			else if (temp.equals("-")) {
				// System.out.println("Push into op stack "+temp);
				ops.push(temp);
			}

			else if (temp.equals("*")) {
				// System.out.println("Push into op stack "+temp);
				ops.push(temp);
			}

			else if (temp.equals("/")) {
				// System.out.println("Push into op stack "+temp);
				ops.push(temp);
			}

			else if (temp.equals("sqrt")) {
				// System.out.println("Push into op stack "+temp);
				ops.push(temp);
			}

			else if (temp.equals(")")) {

				String op = ops.pop();
				// System.out.println("Pop from op stack "+op);

				double v = vals.pop();
				// System.out.println("Pop from val stack "+v);

				if (op.equals("+")) {
					v = vals.pop() + v;
					// System.out.println("Pop from val stack when its + : "+v);
				}

				else if (op.equals("-")) {
					v = vals.pop() - v;
					// System.out.println("Pop from val stack when its - : "+v);
				}

				else if (op.equals("*")) {
					v = vals.pop() * v;
					// System.out.println("Pop from val stack when its * : "+v);
				}

				else if (op.equals("/")) {
					v = vals.pop() / v;
					// System.out.println("Pop from val stack when its / : "+v);
				}

				else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
					// System.out.println("Pop from val stack when its Sqrt : "+v);
				}

				System.out.println("Pushed into val stack " + vals.push(v));

			} else {
				// System.out.println("Pushed value into val stack "+Double.parseDouble(temp));
				vals.push(Double.parseDouble(temp));
			}
		}

		DecimalFormat twoDForm = new DecimalFormat("#.##");
		System.out.println("Final Value : "
				+ Double.valueOf(twoDForm.format(vals.pop())));
	}
}
