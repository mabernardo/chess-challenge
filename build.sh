#!/bin/bash
mkdir ./bin
javac -d ./bin src/chess/challenge/*.java
jar cfm chess-challenge.jar MANIFEST.MF -C bin/ .
