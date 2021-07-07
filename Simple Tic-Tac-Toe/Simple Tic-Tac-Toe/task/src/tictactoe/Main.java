package tictactoe;

public class Main {
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[][] gridValues = new String[3][3];
		int count = 0, win = 0;
		String value = "X";
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				gridValues[i][j] = " ";
			}
		System.out.println("-----------");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= 4; j++) {
				if (j == 0 || j == 4) {
					System.out.print("| ");
				} else {
					System.out.print(gridValues[i][j - 1] + " ");

				}
			}
			System.out.println("");
		}
		System.out.println("-----------");
		int count1 = 0, count2 = 0;
		int first, second;
		String one, two;
		while (true) {

			System.out.print("enter the coordinates:");
			one = scanner.next();
			two = scanner.next();
			for (int i = 0; i < one.length(); i++) {
				if (Character.isDigit(one.charAt(i)) == false)
					count1++;
			}
			for (int i = 0; i < two.length(); i++) {
				if (Character.isDigit(two.charAt(i)) == false)
					count2++;
			}
			if (count1 > 0 || count2 > 0) {
				System.out.println("You should enter numbers!");
			} else {
				first = Integer.parseInt(one);
				second = Integer.parseInt(two);
				if (first > 0 && first <= 3 && second > 0 && second <= 3) {
					if (gridValues[first - 1][second - 1].equals(" ")) {
						gridValues[first - 1][second - 1] = value;
						if (value.equals("X"))
							value = "O";
						else
							value = "X";
						count++;
						//System.out.println(count);
						System.out.println("-----------");
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j <= 4; j++) {
								if (j == 0 || j == 4) {
									System.out.print("| ");
								} else {
									System.out.print(gridValues[i][j - 1] + " ");

								}
							}
							System.out.println("");
						}
						System.out.println("-----------");
					} else {
						System.out.println("This cell is occupied! Choose another one!");
					}
				} else
					System.out.println("Coordinates should be from 1 to 3!");

				for (int a = 0; a <= 8; a++) {
					String line = "abc";

					switch (a) {
					case 0:
						line = gridValues[0][0] + gridValues[0][1] + gridValues[0][2];
						break;
					case 1:
						line = gridValues[0][0] + gridValues[1][0] + gridValues[2][0];
						break;
					case 2:
						line = gridValues[0][0] + gridValues[1][1] + gridValues[2][2];
						break;
					case 3:
						line = gridValues[0][1] + gridValues[1][1] + gridValues[2][1];
						break;
					case 4:
						line = gridValues[1][0] + gridValues[1][1] + gridValues[1][2];
						break;
					case 5:
						line = gridValues[2][0] + gridValues[2][1] + gridValues[2][2];
						break;
					case 6:
						line = gridValues[0][2] + gridValues[1][2] + gridValues[2][2];
						break;
					case 7:
						line = gridValues[0][2] + gridValues[1][1] + gridValues[2][0];
						break;
					}
					//System.out.println(win);
					if (line.equals("XXX")) {
						win = 1;
					} else if (line.equals("OOO")) {
						win = 2;
					}
				}
				// System.out.println(win);
				if (win > 0) {
					if (win == 1) {
						System.out.println("X wins");
						break;
					} else if (win == 2) {
						System.out.println("O wins");
						break;
					}
				} else if (count == 9) {
					System.out.println("Draw");
					break;
				}
			}
		}
		scanner.close();
	}
}
