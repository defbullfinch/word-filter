# Five-Letter Word Alphabet Solver 🚀

An ultra-optimized Java tool designed to solve the famous "5 words, 25 unique letters" combinatorial puzzle inspired by Wordle and Matt Parker's Stand-up Maths challenge.

[![Matt Parker's Video](https://img.shields.io/badge/Watch-Matt%20Parker's%20Video-red?style=flat&logo=youtube)](https://www.youtube.com/watch?v=c33AZBnRHks)

---
## ⚡️ Performance Leap

Matt Parker's original Python script: ~32 days (2,760,670 seconds)

This Java implementation: ONLY ~67 milliseconds 😎

---
## 📖 The Puzzle

The goal is to find combinations of 5 words from a standard dictionary such that:

Each word has exactly 5 letters.

All 25 letters across the 5 words are completely unique.

Exactly 1 letter from the English alphabet remains unused ("v" in this words.txt file).

---
## 📝 Project description

The programme solves a combinatorial problem: it reads an array of words from a text file, identifies valid words (consisting of exactly 5 unique English letters) and, one by one, ‘crosses out’ these letters from the available alphabet. The process repeats cyclically until the alphabet is exhausted or there are no more valid word combinations.

---
## 🚀 Getting Started

1. Make sure you have **JDK 11** or later installed.
2. Place the dictionary file `words.txt` in the project’s root folder (each word must be on a new line).
3. Compile and run the programme:
