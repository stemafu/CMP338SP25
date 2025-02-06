
public class TestTimes implements TestTimesInterface {
	
	private long [] testTimes;
	private final int ArrayDefaultSize = 10;
	private int numTestTimes;
	
	public TestTimes() {
		testTimes = new long[ArrayDefaultSize];
		this.numTestTimes = 0;
	}
	
	
	@Override
	public long getLastTestTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long[] getTestTimes() {
		
		return this.testTimes;
	}

	@Override
	public void resetTestTimes() {
		testTimes = new long[ArrayDefaultSize];
		this.numTestTimes = 0;
		
	}

	@Override
	public void addTestTime(long testTime) {
	
		if(this.numTestTimes < testTimes.length) {
			this.testTimes[this.numTestTimes] = testTime;
			this.numTestTimes++;
		}else {
			/* The array is full.
			 * You need to shift the values
			 * 
			 */
			
		}
		
	}

	@Override
	public double getAverageTestTime() {
		
		return 0;
	}

}
