import java.util.*;
import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CSPStateListener;
import aima.core.search.csp.Domain;
import aima.core.search.csp.ImprovedBacktrackingStrategy;
import aima.core.search.csp.NotEqualConstraint;
import aima.core.search.csp.SolutionStrategy;
import aima.core.search.csp.Variable;

public class Main {

	private static CSP setupCSP() {
		CSP csp = null;
//		In five houses, each with a different color, live five persons of different nationality,
//		each of whom prefers a different brand of cigarettes, a different drink, and a different pet.
//		The five houses are arranged in a row (no house has more than 2 neighbors).   
//		# The Englishman lives in the red house.
//		# The Spaniard owns the dog.
//		# Coffee is drunk in the green house.
//		# The Ukrainian drinks tea.
//		# The green house is immediately to the right of the ivory house.
//		# The Old Gold smoker owns snails.
//		# Kools are smoked in the yellow house.
//		# Milk is drunk in the middle house.
//		# The Norwegian lives in the first house.
//		# The man who smokes Chesterfields lives in the house next to the man with the fox.
//		# Kools are smoked in the house next to the house where the horse is kept.
//		# The Lucky Strike smoker drinks orange juice.
//		# The Japanese smokes Parliaments.
//		# The Norwegian lives next to the blue house.
//
//		Now, who drinks water? Who owns the zebra?
				
		String[] colors = {"Red", "Green", "Ivory", "Yellow", "Blue"};
		String[] nations = {"Englishman", "Spaniard", "Norwegian", "Ukrainian", "Japanese"};
		String[] cigarettes = {"Old Gold", "Kools", "Chesterfields", "Lucky Strike", "Parliaments"};
		String[] drink = {"Water", "Orange juice", "Tea", "Coffee", "Milk"};
		String[] pet = {"Zebra", "Dog", "Fox", "Snails", "Horse"};
		
		// TODO create variables, e.g.,
		// Variable var1 = new Variable("name of the variable 1");
		// Variable var2 = new Variable("name of the variable 2");
		Variable red = new Variable(colors[0]);			//done
		Variable green = new Variable(colors[1]);		//done
		Variable ivory = new Variable(colors[2]);		//done
		Variable yellow = new Variable(colors[3]);		//done
		Variable blue = new Variable(colors[4]);		//done
		Variable englishMan = new Variable(nations[0]); //done
		Variable spaniard = new Variable(nations[1]);   //done
		Variable norwegian = new Variable(nations[2]);  //done
		Variable ukrainian = new Variable(nations[3]);  //done
		Variable japanese = new Variable(nations[4]);   //done
		Variable oldGold = new Variable(cigarettes[0]); //done
		Variable kools = new Variable(cigarettes[1]);	//done
		Variable chesterfields = new Variable(cigarettes[2]);//done
		Variable luckyStrike = new Variable(cigarettes[3]);//done
		Variable parliaments = new Variable(cigarettes[4]); //done
		Variable water = new Variable(drink[0]);//done
		Variable orangeJuice = new Variable(drink[1]);//done
		Variable tea = new Variable(drink[2]);//done
		Variable coffee = new Variable(drink[3]);//done
		Variable milk = new Variable(drink[4]); //done
		Variable zebra = new Variable(pet[0]); //done
		Variable dog = new Variable(pet[1]); //done
		Variable fox = new Variable(pet[2]); //done
		Variable snails = new Variable(pet[3]); //done
		Variable horse = new Variable(pet[4]);//done

		List<Variable> variables = new ArrayList<Variable>();
		// TODO add all your variables to this list, e.g.,
		variables.add(red);
		variables.add(green);
		variables.add(ivory);
		variables.add(yellow);
		variables.add(blue);
		variables.add(englishMan);
		variables.add(spaniard);
		variables.add(norwegian);
		variables.add(ukrainian);
		variables.add(japanese);
		variables.add(oldGold);
		variables.add(kools);
		variables.add(chesterfields);
		variables.add(luckyStrike);
		variables.add(parliaments);
		variables.add(water);
		variables.add(orangeJuice);
		variables.add(tea);
		variables.add(coffee);
		variables.add(milk);
		variables.add(zebra);
		variables.add(dog);
		variables.add(fox);
		variables.add(snails);
		variables.add(horse);
		
		//System.out.println(variables.size());
		csp = new CSP(variables);

		// TODO set domains of variables, e.g.,
		// Domain d1 = new Domain(new String[]{"foo", "bar"});
		// csp.setDomain(var1, d1);
		// Domain d2 = new Domain(new Integer[]{1, 2});
		// csp.setDomain(var2, d2);
		Domain redDomain = new Domain(new Integer[]{
			1, 2, 3, 4, 5,
		});
		Domain greenDomain = new Domain(new Integer[]{
			1, 2, 3, 4, 5,
		});
		Domain ivoryDomain = new Domain(new Integer[]{
			1, 2, 3, 4, 5,
		});
		Domain yellowDomain = new Domain(new Integer[]{
			1, 2, 3, 4, 5,
		});
		Domain blueDomain = new Domain(new Integer[]{
			1, 2, 3, 4, 5,
		});
		csp.setDomain(green, greenDomain);
		csp.setDomain(ivory, ivoryDomain);
		csp.setDomain(yellow, yellowDomain);
		csp.setDomain(blue, blueDomain);
		csp.setDomain(red, redDomain);

		Domain norwegianDomain = new Domain(new Integer[]{
			1
		});
		Domain englishmanDomain = new Domain(new Integer[]{
			2, 3, 4, 5
		});
		Domain spaniardDomain = new Domain(new Integer[]{
			2, 3, 4, 5
		});
		Domain ukrainianDomain = new Domain(new Integer[]{
			2, 3, 4, 5
		});
		Domain japaneseDomain = new Domain(new Integer[]{
			2, 3, 4, 5
		});
		csp.setDomain(norwegian, norwegianDomain);
		csp.setDomain(englishMan, englishmanDomain);
		csp.setDomain(spaniard, spaniardDomain);
		csp.setDomain(ukrainian, ukrainianDomain);
		csp.setDomain(japanese, japaneseDomain);
		/// 1= englishman, 2= spaniard , 3=norwegian, 4= ukrainian, 5 japanese

		Domain parliamentsDomain = new Domain(new Integer[]{
			5
		});
		Domain oldGoldDomain = new Domain(new Integer[]{
			1,2,3,4
		});
		Domain luckyStirkeDomain = new Domain(new Integer[]{
			1,2,3,4
		});
		Domain koolsDomain = new Domain(new Integer[]{
			1,2,3,4
		});
		Domain chesterfieldsDomain = new Domain(new Integer[]{
			1,2,3,4
		});
		csp.setDomain(parliaments, parliamentsDomain);
		csp.setDomain(oldGold, oldGoldDomain);
		csp.setDomain(spaniard, spaniardDomain);
		csp.setDomain(ukrainian, ukrainianDomain);
		csp.setDomain(japanese, japaneseDomain);

		Domain milkDomain = new Domain(new Integer[]{
			3
		});
		Domain waterDomain = new Domain(new Integer[]{
			1,2,4,5
		});
		Domain orangeJuiceDomain = new Domain(new Integer[]{
			1,2,4,5
		});
		Domain teaDomain = new Domain(new Integer[]{
			1,2,4,5
		});
		Domain coffeeDomain = new Domain(new Integer[]{
			1,2,4,5
		});
		csp.setDomain(water, waterDomain);
		csp.setDomain(orangeJuice, orangeJuiceDomain);
		csp.setDomain(tea, teaDomain);
		csp.setDomain(coffee, coffeeDomain);
		csp.setDomain(milk, milkDomain);

		/// 1= englishman, 2= spaniard , 3=norwegian, 4= ukrainian, 5 japanese
		Domain dogDomain = new Domain(new Integer[]{
			2
		});
		Domain zebraDomain = new Domain(new Integer[]{
			1,3,4,5
		});
		Domain foxDomain = new Domain(new Integer[]{
			1,3,4,5
		});
		Domain snailsDomain = new Domain(new Integer[]{
			1,3,4,5
		});
		Domain horseDomain = new Domain(new Integer[]{
			1,3,4,5
		});

		csp.setDomain(dog, dogDomain);
		csp.setDomain(zebra, zebraDomain);
		csp.setDomain(fox, foxDomain);
		csp.setDomain(snails, snailsDomain);
		csp.setDomain(horse, horseDomain);

		// TODO add constraints, e.g.,
		// csp.addConstraint(new NotEqualConstraint(var1, var2)); // meaning var1 != var2
		// csp.addConstraint(new EqualConstraint(var1, var2)); // meaning var1 == var2
		// csp.addConstraint(new SuccessorConstraint(var1, var2)); // meaning var1 == var2 + 1
		// csp.addConstraint(new DifferByOneConstraint(var1, var2)); // meaning var1 == var2 + 1 or var1 == var2 - 1 
		csp.addConstraint(new EqualConstraint(englishMan, red)); // 2
		csp.addConstraint(new EqualConstraint(coffee, green));   // 3
		csp.addConstraint(new EqualConstraint(ukrainian, tea));	 // 5
		csp.addConstraint(new SuccessorConstraint(green,ivory));  // 6
		csp.addConstraint(new EqualConstraint(oldGold, snails)); // 7
		//csp.addConstraint(new EqualConstraint(kools, yellow));  //8 not possible to compare a string[] domain to int[]
		csp.addConstraint(new EqualConstraint(kools, yellow)); // 8?
		csp.addConstraint(new DifferByOneConstraint(norwegian, blue)); // 15
		csp.addConstraint(new EqualConstraint(luckyStrike, orangeJuice)); // 13?
		csp.addConstraint(new DifferByOneConstraint(chesterfields, fox)); // 11 ?
		csp.addConstraint(new DifferByOneConstraint(yellow, horse)); // 12

		return csp;
	}

	private static void printSolution(Assignment solution) {
		// TODO print out useful answer
		// You can use the following to get the value assigned to a variable:
		// Object value = solution.getAssignment(var); 
		// For debugging it might be useful to print the complete assignment and check whether
		// it makes sense.
		System.out.println("solution:" + solution);
	}
	
	/**
	 * runs the CSP backtracking solver with the given parameters and print out some statistics
	 * @param description
	 * @param enableMRV
	 * @param enableDeg
	 * @param enableAC3
	 * @param enableLCV
	 */
	private static void findSolution(String description, boolean enableMRV, boolean enableDeg, boolean enableAC3, boolean enableLCV) {
		CSP csp = setupCSP();

		System.out.println("======================");
		System.out.println("running " + description);
		
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		SolutionStrategy solver = new ImprovedBacktrackingStrategy(enableMRV, enableDeg, enableAC3, enableLCV);
		final int nbAssignments[] = {0};
		solver.addCSPStateListener(new CSPStateListener() {
			@Override
			public void stateChanged(Assignment arg0, CSP arg1) {
				nbAssignments[0]++;
			}
			@Override
			public void stateChanged(CSP arg0) {}
		});
		Assignment solution = solver.solve(csp);
		endTime = System.currentTimeMillis();
		System.out.println("runtime " + (endTime-startTime)/1000.0 + "s" + ", number of assignments (visited states):" + nbAssignments[0]);
		printSolution(solution);
	}

	/**
	 * main procedure
	 */
	public static void main(String[] args) throws Exception {
		// run solver with different parameters
		findSolution("backtracking + AC3 + most constrained variable + least constraining value", true, true, true, true);
		findSolution("backtracking + AC3 + most constrained variable", true, true, true, false);
		findSolution("backtracking + AC3", false, false, true, false);
		findSolution("backtracking + forward checking + most constrained variable + least constraining value", true, true, false, true);
		findSolution("backtracking + forward checking + most constrained variable", true, true, false, false);
		findSolution("backtracking + forward checking", false, false, false, false);
	}

}
