package testSuite;

import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import test.sprint1.testAddCompetitor;
import test.sprint1.testGRP;
import test.sprint1.testIND;
import test.sprint1.testPARAGRP;
import test.sprint1.testPARAIND;
import test.sprint1.testChannel;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	testIND.class,
	testPARAGRP.class,
	testGRP.class,
	testPARAIND.class,
	testAddCompetitor.class,
	testChannel.class})

public class testSuite {
}