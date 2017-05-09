package test.sprint1;
import static org.junit.Assert.*;

import org.junit.Test;

import sprint1.PARAGRP;
import sprint1.channel;
import sprint1.time;
import sprint1.chronotimer;
import sprint1.pressurePad;
public class testPARAGRP {
	private time t;
	private channel c1;
	private channel c2;
	private channel c3;
	private channel c4;
	private channel c5;
	private channel c6;
	private channel c7;
	private channel c8;
	private PARAGRP pGrp;
	private chronotimer chrono;
	private pressurePad ppad;
	public testPARAGRP(){
		chrono = new chronotimer();
		ppad = new pressurePad();
		t = new time();
		c1 = new channel(chrono,1,ppad);
		c2 = new channel(chrono,2,ppad);
		c3 = new channel(chrono,3,ppad);
		c4 = new channel(chrono,4,ppad);
		c5 = new channel(chrono,5,ppad);
		c6 = new channel(chrono,6,ppad);
		c7 = new channel(chrono,7,ppad);
		c8 = new channel(chrono,8,ppad);
		pGrp = new PARAGRP();
	}
	@Test
	public void testMaxComp(){
		//test max
		pGrp.addCompetitor(123);
		pGrp.addCompetitor(456);
		pGrp.addCompetitor(789);
		pGrp.addCompetitor(1234);
		pGrp.addCompetitor(2345);
		pGrp.addCompetitor(3456);
		pGrp.addCompetitor(4567);
		pGrp.addCompetitor(5679);
		assertEquals(8,pGrp.getVStart().size());
	}
	@Test
	public void testUnderMaxComp(){
		pGrp.addCompetitor(123);
		pGrp.addCompetitor(456);
		pGrp.addCompetitor(789);
		pGrp.addCompetitor(1234);
		pGrp.addCompetitor(2345);
		pGrp.addCompetitor(3456);
		pGrp.addCompetitor(4567);
		assertEquals(7,pGrp.getVStart().size());
	}
	@Test
	public void testOverMaxComp(){
		pGrp.addCompetitor(123);
		pGrp.addCompetitor(456);
		pGrp.addCompetitor(789);
		pGrp.addCompetitor(1234);
		pGrp.addCompetitor(2345);
		pGrp.addCompetitor(3456);
		pGrp.addCompetitor(4567);
		pGrp.addCompetitor(5679);
		pGrp.addCompetitor(1245);
		assertEquals(8,pGrp.getVStart().size());
	}
	@Test 
	public void testStart(){
		//add 7 competitors
		pGrp.addCompetitor(123);
		pGrp.addCompetitor(456);
		pGrp.addCompetitor(789);
		pGrp.addCompetitor(1234);
		pGrp.addCompetitor(2345);
		pGrp.addCompetitor(3456);
		pGrp.addCompetitor(4567);
		//start
		pGrp.start(t,c1);
		//finish
		pGrp.finish(t, c1);
		pGrp.finish(t, c3);
		pGrp.finish(t, c2);
		pGrp.finish(t, c4);
		pGrp.finish(t, c7);
		pGrp.finish(t, c6);
		pGrp.finish(t, c5);
		//check finish Vector that all competitors finished
		assertEquals(7,pGrp.getRun().size());
	}
	@Test
	public void testCancel(){
		pGrp.addCompetitor(123);
		pGrp.addCompetitor(456);
		pGrp.addCompetitor(789);
		pGrp.addCompetitor(1234);
		pGrp.addCompetitor(2345);
		pGrp.addCompetitor(3456);
		pGrp.addCompetitor(4567);
		pGrp.start(t,c1);
		pGrp.finish(t, c1);
		pGrp.finish(t, c3);
		pGrp.finish(t, c2);
		pGrp.finish(t, c4);
		pGrp.finish(t, c7);
		assertEquals(5,pGrp.getRun().size());
		pGrp.cancel();
		int counter = 0;
		for(int i = 0; i < 7;i++){
			if(pGrp.getRun().get(i).getFinish() == null)
				assertTrue(pGrp.getRun().get(i).isDNF());
		}
	}
}
