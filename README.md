[![Build Status](https://travis-ci.org/mabernardo/chess-challenge.svg?branch=master)](https://travis-ci.org/mabernardo/chess-challenge)

# chess-challenge
Finds all unique configurations of a set of normal chess pieces on a chess board with dimensions MxN where none of the pieces is in a position to take any of the others.

## Building
Clone the project and run:

	./gradlew build

## Usage

	java -jar build/libs/chess-challenge.jar [-v | -s]

    optional arguments:
	  -v    Prints a computation summary in the end.
	  -s    Only prints the computation summary (no board output).

or

    ./gradlew run -q [ -Dargs=[-v | -s] ]

## Input
The dimensions of the board: M, N
The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try and place on the board.

### Sample Input
3x3 board with 2 Kings and 1 Rock

	3 3
	2 0 0 1 0


### Sample Output

	K.K
	...
	.R.
	
	K..
	..R
	K..
	
	..K
	R..
	..K
	
	.R.
	...
	K.K

## Dependencies
JRE 1.8+