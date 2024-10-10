package com.JavaProject2.program;

import java.util.Scanner;

public class QuizApllication {
	 static class Question {
	        String question;
	        String[] options;
	        int correctAnswer;

	        Question(String question, String[] options, int correctAnswer) {
	            this.question = question;
	            this.options = options;
	            this.correctAnswer = correctAnswer;
	        }
	    }

	    static Question[] questions = new Question[10];
	    static boolean usedFiftyFifty = false;
	    static boolean usedPhoneAFriend = false;
	    static int score = 0;

	    public static void main(String[] args) {
	        initializeQuestions();
	        Scanner scanner = new Scanner(System.in);

	        for (int i = 0; i < questions.length; i++) {
	            System.out.println(questions[i].question);
	            for (int j = 0; j < questions[i].options.length; j++) {
	                System.out.println((char)('a' + j) + ". " + questions[i].options[j]);
	            }

	            String answer = scanner.next();
	            if (answer.equalsIgnoreCase(String.valueOf((char)('a' + questions[i].correctAnswer - 1)))) {
	                System.out.println("Correct!");
	                score++;
	            } else {
	                if (!usedFiftyFifty || !usedPhoneAFriend) {
	                    System.out.println("Wrong answer. Do you want to use a lifeline?");
	                    if (!usedFiftyFifty) {
	                        System.out.println("1. Fifty Fifty");
	                    }
	                    if (!usedPhoneAFriend) {
	                        System.out.println("2. Phone a Friend");
	                    }
	                    System.out.println("3. No");

	                    int lifelineChoice = scanner.nextInt();
	                    if (lifelineChoice == 1 && !usedFiftyFifty) {
	                        usedFiftyFifty = true;
	                        useFiftyFifty(i, scanner);
	                    } else if (lifelineChoice == 2 && !usedPhoneAFriend) {
	                        usedPhoneAFriend = true;
	                        usePhoneAFriend(i, scanner);
	                    } else {
	                        break;
	                    }
	                } else {
	                    break;
	                }
	            }
	        }

	        double percentage = ((double) score / questions.length) * 100;
	        System.out.println("Quiz over! You scored " + percentage + "%.");
	    }

	    static void initializeQuestions() {
	        String[] questionsArray = {
	            "Which of the following datatype is not a part of Java?",
	            "What is the memory size of char in Java?",
	            "Base-2 value of 126 in Java?",
	            "Which of the following is not a Variable type in Java?",
	            "Instance variables will get memory in _____________ segment",
	            "Local variables will get memory in _____________ segment",
	            "Static variables will get memory in _____________ segment",
	            "Which of the following is not an identifier in Java?",
	            "Identify the Operator used in a+=b",
	            "Which of the following is not a looping statement in Java?"
	        };

	        String[][] optionsArray = {
	            {"byte", "char", "bit", "float"},
	            {"1-byte", "2-byte", "3-byte", "4-byte"},
	            {"10101010", "10010010", "01111111", "01111110"},
	            {"Local Variable", "Static Variable", "String Variable", "Instance Variable"},
	            {"Stack", "Heap", "Static", "None of these"},
	            {"Stack", "Heap", "Static", "None of these"},
	            {"Stack", "Heap", "Static", "None of these"},
	            {"$Java", "_name8", "8th_question", "All of these"},
	            {"Arithmetic Operator", "Relational Operator", "Logic Operator", "Assignment Operator"},
	            {"for each loop", "for loop", "while loop", "None of these"}
	        };

	        int[] correctAnswers = {3, 2, 4, 3, 2, 1, 3, 3, 4, 4};

	        for (int i = 0; i < questions.length; i++) {
	            questions[i] = new Question(questionsArray[i], optionsArray[i], correctAnswers[i]);
	        }
	    }

	    static void useFiftyFifty(int questionIndex, Scanner scanner) {
	        Question question = questions[questionIndex];
	        int correctIndex = question.correctAnswer - 1;
	        int[] fiftyFiftyOptions = new int[2];
	        fiftyFiftyOptions[0] = correctIndex;
	        int incorrectOption;
	        do {
	            incorrectOption = (int) (Math.random() * 4);
	        } while (incorrectOption == correctIndex);
	        fiftyFiftyOptions[1] = incorrectOption;

	        System.out.println(question.question);
	        for (int j = 0; j < fiftyFiftyOptions.length; j++) {
	            System.out.println((char)('a' + fiftyFiftyOptions[j]) + ". " + question.options[fiftyFiftyOptions[j]]);
	        }

	        String answer = scanner.next();
	        if (answer.equalsIgnoreCase(String.valueOf((char)('a' + correctIndex)))) {
	            System.out.println("Correct!");
	            score++;
	        } else {
	            System.out.println("Wrong again. Quiz over!");
	        }
	    }

	    static void usePhoneAFriend(int questionIndex, Scanner scanner) {
	        Question question = questions[questionIndex];
	        int[] percentages = new int[4];
	        percentages[question.correctAnswer - 1] = 70;
	        for (int i = 0; i < percentages.length; i++) {
	            if (i != question.correctAnswer - 1) {
	                percentages[i] = (int) (Math.random() * 15);
	            }
	        }

	        System.out.println(question.question);
	        for (int j = 0; j < question.options.length; j++) {
	            System.out.println((char)('a' + j) + ". " + question.options[j] + " (" + percentages[j] + "%)");
	        }

	        String answer = scanner.next();
	        if (answer.equalsIgnoreCase(String.valueOf((char)('a' + question.correctAnswer - 1)))) {
	            System.out.println("Correct!");
	            score++;
	        } else {
	            System.out.println("Wrong again. Quiz over!");
	        }
	    }
	}
