package test.sprint1;
import static org.junit.Assert.*;
import org.junit.Test;
import sprint1.channel;
import sprint1.chronotimer;
import sprint1.electric_eye;
public class testChannel {
	private channel c;
	private electric_eye eye;
	private chronotimer chrono;
	public testChannel(){
		chrono = new chronotimer();
		eye = new electric_eye();
	}
	@Test
	public void testConnect(){
		c = new channel(chrono,1,eye);
		assertNotNull(c.hasSensor());
		assertEquals(eye,c.getSensor());
		assertEquals(1,c.getChannelNumber());
	}
	@Test
	public void testDisconnect(){
		c = new channel(chrono,1,eye);
		assertNotNull(c.hasSensor());
		assertEquals(eye,c.getSensor());
		assertEquals(1,c.getChannelNumber());
		c.disconnectSensor();
		assertNull(c.getSensor());
	}
	@Test
	public void testEnable(){
		c = new channel(chrono,1,eye);
		c.enable();
		assertTrue(c.state());
	}
	@Test
	public void testDisable(){
		c = new channel(chrono,1,eye);
		c.enable();
		assertTrue(c.state());
		c.disable();
		assertFalse(c.state());
	}
}
