public class SimpleDotCom {

	int[] locationCells;
	int numOfHits = 0;

	public void setLocationCells([]int locations) {

		locationCells = locations;

	}

	public String checkYourself(String stringGuess) {

			int guess = Integer.ParseInt(stringGuess);
			String result = "miss";

			for (int cell : locationCells){
				if(guess==cell){
						result="hit!";
						numOfHits++;
						break;
					}
			}

			if(numOfHits==locationCells.length){
					result="kill!!";
			}

			System.out.Println(result);

			return result;

		}
}