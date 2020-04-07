# TODO List for Project 2 - Not So Elementary Cellular Automata

## CellState

### CellState getState(char symbol)

Given a symbol, '.' and 'O', this method will return the associated state
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String toString()

Returns the symbol associated with the CellState
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## Cell

### Cell()

The default constructor will make a Cell object with the state as OFF
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Cell(CellState state)

This constructor takes a CellState object and assigns the state of that enum type to the state field of Cell
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### CellState getState()

Returns the state of the Cell
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String toString()

Returns the symbol associated with the state of the Cell
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## EvolvedCell

### EvolvedCell(CellState state, int subruleNum)

This constructor makes an EvolvedCell object, which is almost identical to a Cell object except it has the subrule by which it evolved associated with it
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int getSubruleNum()

Returns the subrule by which the EvolvedCell evolved
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

## Generation

### Generation(CellState[] states)

This constructor takes an array of CellState objects, makes a Cell object for each CellState, and stores each Cell into the cells array
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Generation(String states)

This constructor takes a String, creates a Cell object for each symbol that is mapped to either CellState.OFF or CellState.ON, and stores each Cell into the cells array
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Generation(Cell[] states)

Probably the most straightforward Generation constructor, the constructor copies the states array and stores the copy into the cells array
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int size()

Returns the number of Cells in the Generation
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Cell getCell(int idx)

Returns the Cell at the specified index
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String toString

Returns the String representation of each Cell symbol in the Generation concatenated together
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## CircularBoundaryConditions

### CircularBoundaryConditions()

This boundary condition treats the cells as if they are in a circle, with the leftmost Cell's left neighbor being the rightmost Cell and the rightmost Cell's right neighbor being the leftmost Cell
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### getNeighbor(int cellIdx, int offset, Generation gen)

Using the idea specified above, this method gets the Cell offset Cells away from the Cell at cellIdx
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## FixedBoundaryConditions

### FixedBoundaryConditions(CellState left, CellState right)

Unlike the circular boundary condition, the leftmost Cell's left neighbors' state and rightmost Cell's right neighbors' state is fixed by the arguments given to this constructor
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### CellState getLeftState()

Returns the fixed state for cells left of the leftmost Cell
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### CellState getRightState()

Returns the fixed state for cells right of the rightmost Cell
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Cell getNeighbor(int cellIdx, int offset, Generation gen)

Using the idea specified above, this method gets the Cell offset Cells away from the Cell at cellIdx
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## Rule

### int getRuleNum()

Returns the decimal representation of the Rule number
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Generation evolve(Generation gen, BoundaryConditions bc)

Given a Generation and BoundaryCondition, this method will evolve the Generation based on the concrete Rule and ruleNum
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## ElementaryRule

### ElementaryRule(int ruleNum)

The ElementaryRule specifies that the state of a Cell in the next Generation is based on its current state as well as the states' of its neighbors on the left and right. Because the Cell in the next Generation can either be specified to be OFF or ON and there are 8 possible configurations of the 3 Cells determining the state of the Cell in the next Generation, there are a total of 256 possible rules.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int getNumOfSubrules

As said up above, there are 8 possible configurations of the 3 Cells and the state of the Cell in the next Generation associated with each of those configurations will be referred to as a "subrule". This method will simly return the int 8, as that value is constant for this kind of Rule.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### EvolvedCell evolve(Cell[] neighborhood)

This method is called repeatedly by the evolve method in the abstract parent Rule class and returns one EvolvedCell based on the configuration of the given Cell neighborhood and the ruleNum.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String toString()

Returns a sort of table to represent the rule. For example, if the ruleNum = 110 this method would return
```
OOO OO. O.O O.. .OO .O. ..O ...
 .   O   O   .   O   O   O   . 
```
with O representing ON states and . representing OFF states.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working



## TotalisticRule

### TotalisticRule(int ruleNum)

The TotalisticRule specifies that the state of a Cell in the next Generation is based on how many Cells in a certain span are currently ON. For this program, that span will include the current Cell as well as 2 Cells to its left and right. Because the Cell in the next Generation can either be specified to be OFF or ON and there are can be 6(0-5) ways the Cells can be ON, there are a total of 64 rules.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int getNumOfSubrules

As said up above, there are 6 possible ways the Cells in the span can be ON and the state of the Cell in the next Generation associated with each of those possibilities will be referred to as a "subrule". This method will simply return the int 6, as that value is constant for this kind of Rule.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### EvolvedCell evolve(Cell[] neighborhood)

This method is called repeatedly by the evolve method in the abstract parent Rule class and returns one EvolvedCell based on the configuration of the given Cell neighborhood and the ruleNum.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String toString()

Returns a sort of table to represent the rule. For example, if the ruleNum = 22 this method would return
```
5 4 3 2 1 0
. O . O O .
```
with O representing ON states and . representing OFF states.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working


## Automaton

### Automaton(Rule rule, Generation init, BoundaryConditions bc)

Given a type of Rule, a rule number, an initial Generation, and BoundaryCondition this constructor will create an Automaton which can exhibit some pretty complex behavior if evolved
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Rule getRule()

Returns the type of Rule the Automaton is following
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### Generation getGeneration(int stepNum)

Returns the generation of the Automaton at the specified index.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### BoundaryConditions getBoundaryConditions()

Returns the BoundaryCondition the Automaton is following
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### void evolve(int stepNum)

Evolves the Automaton the specified number of times and adds each Generation created to a List
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int getTotalSteps()

Returns the number of times the Automaton has been evolved(the number of Generations the Automaton has gone through - 1)
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String toString()

Returns a String representation of the most current Generation
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### String getHistory()

Returns a String representation of the entire evolution of the Automaton
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

## AutomatonMeasurements

### int hammingDistance(Generation g1, Generation g2)

Given 2 Generations, this method returns the number of Cells that would to be changed for the two Generations to become identical.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int hammingDistance(int stepNum, Automaton a)

Returns the number of Cells that would to be changed for the two Generations in the Automaton before and after the given stepNum to become identical.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int[] hammingDistances(Automaton a)

Returns an array of length equal to the number of evolutions the Automaton has gone through. The array contains the hammingDistances between subsequent Generations.
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int[] subRuleCount(int stepNum, Automaton a)

Returns an array that contains the how often each subrule was applied to the Generation of the Automaton at the stepNum index
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working

### int[][] subRuleCounts(Automaton a)

Returns a 2D array that contains the arrays created by the last method for each Generation of the Automaton
- [x] Write method
- [ ] Write comments
- [x] Write test
- [x] Check if method is working
