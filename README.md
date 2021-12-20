# Personality_Test_Software

## Describtion: 
Scoring users’ responses to the classic Myers–Briggs personality test. Assume that the test has 70 questions that determine a person’s personality in four dimensions. Each question has two answer choices that we’ll call the “A” and “B” answers. Questions are organized into 10 groups of seven questions, with the following repeating pattern in each group:

* The first question in each group (questions 1, 8, 15, 22, etc.) tells whether the person is introverted or extroverted.

* The next two questions (questions 2 and 3, 9 and 10, 16 and 17, 23 and 24, etc.) test whether the person is guided by his or her senses or intuition.

* The next two questions (questions 4 and 5, 11 and 12, 18 and 19, 25 and 26, etc.) test whether the person focuses on thinking or feeling.

* The final two questions in each group (questions 6 and 7, 13 and 14, 20 and 21, 27 and 28, etc.) test whether the person prefers to judge or be guided by perception.


In other words, if we consider introversion/extraversion (I/E) to be dimension 1, sensing/intuition (S/N) to be dimension 2, thinking/feeling (T/F) to be dimension 3, and judging/perception (J/P) to be dimension 4, the map of questions to their respective dimensions would look like this:
````
1223344122334412233441223344122334412233441223344122334412233441223344
BABAAAABAAAAAAABAAAABBAAAAAABAAAABABAABAAABABABAABAAAAAABAAAAAABAAAAAA
````

The following is a partial sample input file of names and responses:
````
Betty Boop
BABAAAABAAAAAAABAAAABBAAAAAABAAAABABAABAAABABABAABAAAAAABAAAAAABAAAAAA
Snoopy
AABBAABBBBBABABAAAAABABBAABBAAAABBBAAABAABAABABAAAABAABBBBAAABBAABABBB
````

If less than 50% of a person’s responses are B for a given personality dimension, the person’s type for that dimension should be the first of its two choices. If the person has 50% or more B responses, the person’s type for that dimension is the second choice. Your program should output each person’s name, the number of A and B responses for each dimension, the percentage of Bs in each dimension, and the overall personality type. The following should be your program’s output for the preceding input data:
````
Betty Boop:
1A–9B 17A–3B 18A–2B 18A–2B
[90%, 15%, 10%, 10%] = ISTJ
Snoopy:
7A–3B 11A–9B 14A–6B 6A–14B
[30%, 45%, 30%, 70%] = ESTP
````
