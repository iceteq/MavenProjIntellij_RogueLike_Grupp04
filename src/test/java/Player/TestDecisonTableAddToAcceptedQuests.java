package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class TestDecisonTableAddToAcceptedQuests {


	//Decision table R1.
	@Test
	public void addToAcceptedQuests_ShouldSucceed_When_PlayerMeetsRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(10);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla");
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla");
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla");

		playerKnight.addCompletedQuestForThisPlayer(requirementQuest1);
		playerKnight.addCompletedQuestForThisPlayer(requirementQuest2);
		playerKnight.addCompletedQuestForThisPlayer(requirementQuest3);

		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla");

		playerKnight.addQuestToAcceptForThisPlayer(testQuest);


		assertEquals(testQuest, playerKnight.getQuestLog().getAcceptedQuests().get(0));


	}

	//Decision table R2.
	@Test
	public void addToAcceptedQuests_ShouldThrowException_When_PlayerDoesntMeetLevelRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(5);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla");
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla");
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla");

		playerKnight.addCompletedQuestForThisPlayer(requirementQuest1);
		playerKnight.addCompletedQuestForThisPlayer(requirementQuest2);
		playerKnight.addCompletedQuestForThisPlayer(requirementQuest3);

		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla");



		assertThrows(IllegalStateException.class, () -> {
			playerKnight.addQuestToAcceptForThisPlayer(testQuest);
		});

	}

	//Decision table addToAcceptedQuests; R5.
	@Test
	public void addToAcceptedQuests_ShouldThrowException_When_PlayerDoesntMeetQuestRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(10);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla");
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla");
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla");

		playerKnight.addCompletedQuestForThisPlayer(requirementQuest1);
		playerKnight.addCompletedQuestForThisPlayer(requirementQuest2);


		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla");



		assertThrows(IllegalStateException.class, () -> {
			playerKnight.addQuestToAcceptForThisPlayer(testQuest);
		});

	}

	//Decision table addToAcceptedQuests; R6.
	@Test
	public void addToAcceptedQuests_ShouldThrowException_When_PlayerDoesntMeetLevelAndQuestRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(5);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla");
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla");
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla");

		playerKnight.addCompletedQuestForThisPlayer(requirementQuest1);
		playerKnight.addCompletedQuestForThisPlayer(requirementQuest2);


		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla");



		assertThrows(IllegalStateException.class, () -> {
			playerKnight.addQuestToAcceptForThisPlayer(testQuest);
		});

	}
	//Decision table addToAcceptedQuests; R3,R4,R7,R8. When class/quest type missmatch, throw assertion from addCompletedQuest().
	//Tested in Junit class QuestTest.


}