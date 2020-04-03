# TODO List for Project 2 - Not So Elementary Cellular Automata

## CellState

### CellState getState(char symbol)

Given a symbol, '.' and 'O', this method will return the associated state
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### String toString()

Returns the symbol associated with the CellState
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement


## Cell

### Cell()

The default constructor will make a Cell object with the state as OFF
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### Cell(CellState state)

This constructor takes a CellState object and assigns the state of that enum type to the state field of Cell
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### CellState getState()

Returns the state of the Cell
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### String toString()

Returns the symbol associated with the state of the Cell
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement


## EvolvedCell

### EvolvedCell(CellState state, int subruleNum)

This constructor makes an EvolvedCell object, which is almost identical to a Cell object except it has the subrule by which it evolved associated with it
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### int getSubruleNum()

Returns the subrule by which the EvolvedCell evolved
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

## Generation

### Generation(CellState[] states)

This constructor takes an array of CellState objects, makes a Cell object for each CellState, and stores each Cell into the cells array
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### Generation(String states)

This constructor takes a String, creates a Cell object for each symbol that is mapped to either CellState.OFF or CellState.ON, and stores each Cell into the cells array
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### Generation(Cell[] states)

Probably the most straightforward Generation constructor, the constructor copies the states array and stores the copy into the cells array
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement


## CircularBoundaryConditions

### CircularBoundaryConditions()

This boundary condition treats the cells as if they are in a circle, with the leftmost Cell's left neighbor being the rightmost Cell and the rightmost Cell's right neighbor being the leftmost Cell
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### getNeighbor(int cellIdx, int offset, Generation gen)

Using the idea specified above, this method gets the Cell offset Cells away from the Cell at cellIdx
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement


## FixedBoundaryConditions

### FixedBoundaryConditions(CellState left, CellState right)

Unlike the circular boundary condition, the leftmost Cell's left neighbors' state and rightmost Cell's right neighbors' state is fixed by the arguments given to this constructor
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### getLeftState()

Returns the fixed state for cells left of the leftmost Cell
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### getRightState()

Returns the fixed state for cells right of the rightmost Cell
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement

### getNeighbor(int cellIdx, int offset, Generation gen)

Using the idea specified above, this method gets the Cell offset Cells away from the Cell at cellIdx
- [ ] (before:) test
- [ ] (after:) test
- [ ] (and later:) implement



- [x] Write the methods for Rule.java
- [x] Write the methods for ElementaryRule.java
- [x] Write the methods for TotalisticRule.java
- [x] Write the methods for Automaton.java
- [ ] Write the methods for AutomatonMeasurements.java
  * - [ ] Figure out how to access subrule of EvolvedCell in given generation
