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


- [x] Copy repo
- [x] Create all classes based on UML diagram


- [x] Write the methods for EvolvedCell.java
- [x] Write the methods for CircularBoundaryConditions.java
- [x] Write the methods for FixedBoundaryConditions.java
- [ ] Write the methods for Generation.java
  * - [ ] Figure out if I am making Generation immutable
- [x] Write the methods for Rule.java
- [x] Write the methods for ElementaryRule.java
- [x] Write the methods for TotalisticRule.java
- [x] Write the methods for Automaton.java
- [ ] Write the methods for AutomatonMeasurements.java
  * - [ ] Figure out how to access subrule of EvolvedCell in given generation
