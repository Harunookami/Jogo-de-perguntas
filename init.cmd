@echo off
chcp 65001 > nul

call compile

java -Dfile.encoding=UTF-8 -cp out JogoDePerguntas.JogoDePerguntas