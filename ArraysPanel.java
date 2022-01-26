import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArraysPanel extends VBox {

	private HBox topLabels;
	private HBox topStatsLabels;
	private HBox questions;
	private VBox optionsLabel;
	private HBox buttons;

	private Label name;
	private Label score;
	private Label countdown;
	private Label partOne;
	private Label partTwo;

	private Label optionOne;
	private Label optionTwo;
	private Label optionThree;
	private Label optionFour;

	private Button choiceOne;
	private Button choiceTwo;
	private Button choiceThree;
	private Button choiceFour;

	private Button generateReport;
	private Button startNewGame;

	private int currentQuestion = 0;

	private ArrayList<Game> games;
	private String currentPlayerName = "";
	ArrayList<Question> questionsList;
	private int currentGameTime = 0;

	private int questionTime = 6;

	Timer timer;

	public ArraysPanel() {
		questionsList = new ArrayList<>();
		games = new ArrayList<>();
		timer = new Timer();

		topLabels = new HBox();
		VBox.setMargin(topLabels, new Insets(20, 20, 0, 20));
		topLabels.setSpacing(120);

		topLabels.getChildren().add(new Label("Name  "));
		topLabels.getChildren().add(new Label("TotalPoint"));
		topLabels.getChildren().add(new Label("Countdown Clock"));
		getChildren().add(topLabels);

		topStatsLabels = new HBox();
		VBox.setMargin(topStatsLabels, new Insets(20, 20, 0, 20));
		topStatsLabels.setSpacing(120);

		topStatsLabels.getChildren().add(name = new Label("Haseeb"));
		topStatsLabels.getChildren().add(score = new Label("    0"));
		topStatsLabels.getChildren().add(countdown = new Label("\t\t5 sec"));

		getChildren().add(topStatsLabels);

		questions = new HBox();
		VBox.setMargin(questions, new Insets(60, 20, 20, 20));
		questions.setSpacing(120);

		questions.getChildren().add(partOne = new Label("Object 1"));
		questions.getChildren().add(new Label("+"));
		questions.getChildren().add(partTwo = new Label("Object 2"));
		getChildren().add(questions);

		optionsLabel = new VBox();
		VBox.setMargin(optionsLabel, new Insets(30, 20, 20, 20));
		optionsLabel.setSpacing(20);

		optionsLabel.getChildren().add(optionOne = new Label("optionOne"));
		optionsLabel.getChildren().add(optionTwo = new Label("optionTwo"));
		optionsLabel.getChildren().add(optionThree = new Label("optionThree"));
		optionsLabel.getChildren().add(optionFour = new Label("optionFour"));
		getChildren().add(optionsLabel);

		buttons = new HBox();
		VBox.setMargin(buttons, new Insets(0, 60, 0, 20));
		buttons.setSpacing(40);

		buttons.getChildren().add(choiceOne = new Button("Choice 1"));
		buttons.getChildren().add(choiceTwo = new Button("Choice 2"));
		buttons.getChildren().add(choiceThree = new Button("Choice 3"));
		buttons.getChildren().add(choiceFour = new Button("Choice 4"));

		disableChoiceButtons();

		choiceOne.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				currentGameTime += 5 - Integer.parseInt(countdown.getText().trim().substring(0, 1));
				if (questionsList.get(currentQuestion).getCorrectOption().toString()
						.equals(optionOne.getText().toString())) {
					score.setText(String.valueOf("    " + (Integer.parseInt(score.getText().trim()) + 1)));
				}
				setNext();

			}
		});

		choiceTwo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				currentGameTime += 5 - Integer.parseInt(countdown.getText().trim().substring(0, 1));
				if (questionsList.get(currentQuestion).getCorrectOption().toString()
						.equals(optionTwo.getText().toString())) {
					score.setText(String.valueOf("    " + (Integer.parseInt(score.getText().trim()) + 1)));
				}
				setNext();

			}
		});

		choiceThree.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				currentGameTime += 5 - Integer.parseInt(countdown.getText().trim().substring(0, 1));
				if (questionsList.get(currentQuestion).getCorrectOption().toString()
						.equals(optionThree.getText().toString())) {
					score.setText(String.valueOf("    " + (Integer.parseInt(score.getText().trim()) + 1)));
				}
				setNext();

			}
		});

		choiceFour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				currentGameTime += 5 - Integer.parseInt(countdown.getText().trim().substring(0, 1));
				if (questionsList.get(currentQuestion).getCorrectOption().toString()
						.equals(optionFour.getText().toString())) {
					score.setText(String.valueOf("    " + (Integer.parseInt(score.getText().trim()) + 1)));
				}
				setNext();

			}
		});

		getChildren().add(buttons);

		generateReport = new Button("Generate Report");
		VBox.setMargin(generateReport, new Insets(40, 20, 0, 200));
		getChildren().add(generateReport);
		
		generateReport.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				generateReport();
			}
		});
		

		startNewGame = new Button("Start New Game");
		VBox.setMargin(startNewGame, new Insets(40, 20, 0, 200));
		getChildren().add(startNewGame);

		startNewGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				
				TextInputDialog inputdialog = new TextInputDialog("Enter name");
		        inputdialog.setContentText("Text: ");
		        
		        inputdialog.showAndWait();
		        
		        currentPlayerName = inputdialog.getEditor().getText();
		        name.setText(currentPlayerName);
		        
				currentQuestion = 0;
				currentGameTime = 0;
				score.setText("    0");
				enableChoiceButtons();
				startTrivia();
				startTimer();

			}
		});

		readQuestions();

	}
	private void generateReport() {
		try {
			File file = new File("Report.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			for(Game game : games) {
				br.write(game.toString()+"\n");
			}

			br.close();
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (questionTime-- <= 0) {
							setNext();
						}

						//System.out.println(String.valueOf(questionTime));
						 countdown.setText(String.valueOf("\t\t"+ questionTime) + " sec");
					}
				});

			}
		}, 0, 1000);

	}

	private void disableChoiceButtons() {
		choiceOne.setDisable(true);
		choiceTwo.setDisable(true);
		choiceThree.setDisable(true);
		choiceFour.setDisable(true);

	}

	private void enableChoiceButtons() {
		choiceOne.setDisable(false);
		choiceTwo.setDisable(false);
		choiceThree.setDisable(false);
		choiceFour.setDisable(false);

	}

	private void setNext() {
		currentQuestion++;
		questionTime = 6;
		if (currentQuestion < questionsList.size()) {
			startTrivia();
		} else {
			disableChoiceButtons();
			// end the quiz
			Game game = new Game();
			game.setScore(Integer.parseInt(score.getText().trim()));
			game.setName(currentPlayerName);
			game.setTime(currentGameTime);
			games.add(game);
			timer.cancel();
			timer.purge();
			System.out.println(games);
		}
	}

	private void startTrivia() {
		Question question = questionsList.get(currentQuestion);
		System.out.println("Answer = " + question.getCorrectOption());

		partOne.setText(question.getPartOne().toString());
		partTwo.setText(question.getPartTwo().toString());

		optionOne.setText(question.getOptionOne().toString());
		optionTwo.setText(question.getOptionTwo().toString());
		optionThree.setText(question.getOptionThree().toString());
		optionFour.setText(question.getOptionFour().toString());

	}

	private void readQuestions() {
		try {
			Scanner fileReader = new Scanner(new File("input.txt"));

			while (fileReader.hasNext()) {
				String pOne = fileReader.next();
				String partTwo = fileReader.next();

				String optionOne = fileReader.next();
				String optionTwo = fileReader.next();
				String optionThree = fileReader.next();
				String optionFour = fileReader.next();
				Question question = new Question(pOne, partTwo, optionOne, optionTwo, optionThree, optionFour);
				checkIntegers(pOne, partTwo, optionOne, optionTwo, optionThree, optionFour, question);

				questionsList.add(question);

			}

			fileReader.close();
			System.out.println("List size: " + questionsList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void checkIntegers(String pOne, String partTwo, String optionOne, String optionTwo, String optionThree,
			String optionFour, Question question) {
		try {
			Integer pOneInt = Integer.parseInt(pOne);
			question.setPartOne(pOneInt);
		} catch (Exception e) {
			try {
				Double pOneInt = Double.parseDouble(pOne);
				question.setPartOne(pOneInt);
			} catch (Exception ee) {

			}
		}
		try {
			Integer pTwoInt = Integer.parseInt(partTwo);
			question.setPartTwo(pTwoInt);
		} catch (Exception e) {
			try {
				Double pTwoInt = Double.parseDouble(partTwo);
				question.setPartTwo(pTwoInt);
			} catch (Exception ee) {
			}
		}

		try {
			Integer val = Integer.parseInt(optionOne);
			question.setOptionOne(val);
		} catch (Exception e) {
			try {
				Double val = Double.parseDouble(optionOne);
				question.setOptionOne(val);
			} catch (Exception ee) {
			}
		}

		try {
			Integer val = Integer.parseInt(optionTwo);
			question.setOptionTwo(val);
		} catch (Exception e) {
			try {
				Double val = Double.parseDouble(optionTwo);
				question.setOptionTwo(val);
			} catch (Exception ee) {
			}
		}

		try {
			Integer val = Integer.parseInt(optionThree);
			question.setOptionThree(val);
		} catch (Exception e) {
			try {
				Double val = Double.parseDouble(optionThree);
				question.setOptionThree(val);
			} catch (Exception ee) {
			}
		}

		try {
			Integer val = Integer.parseInt(optionFour);
			question.setOptionFour(val);
		} catch (Exception e) {
			try {
				Double val = Double.parseDouble(optionFour);
				question.setOptionFour(val);
			} catch (Exception ee) {
			}
		}
	}

}
