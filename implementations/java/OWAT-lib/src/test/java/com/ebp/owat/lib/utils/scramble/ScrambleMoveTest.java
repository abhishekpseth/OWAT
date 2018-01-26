package com.ebp.owat.lib.utils.scramble;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ScrambleMoveTest extends ScMoTest {
	private static final ScrambleMove SW = new ScrambleMove(ScrambleMoves.SWAP, 10L, 1L, 100L, 399L);
	private static final ScrambleMove SWR = new ScrambleMove(ScrambleMoves.SWAP_ROW, 10L, 399L);
	private static final ScrambleMove SWC = new ScrambleMove(ScrambleMoves.SWAP_COL, 10L, 399L);
	private static final ScrambleMove SLR = new ScrambleMove(ScrambleMoves.SLIDE_ROW, 10L, 399L);
	private static final ScrambleMove SLC = new ScrambleMove(ScrambleMoves.SLIDE_COL, 10L, 399L);
	private static final ScrambleMove RCL = new ScrambleMove(ScrambleMoves.ROT_CLOCK, 1, 10L, 1L, 100L, 399L);
	private static final ScrambleMove RCC = new ScrambleMove(ScrambleMoves.ROT_CCLOCK, 1, 10L, 1L, 100L, 399L);
	
	@Test
	public void testScrambleMoveBadConstructor(){
		try{
			new ScrambleMove(ScrambleMoves.SWAP, 1L);
			Assert.fail();
		}catch (IllegalArgumentException e){
		
		}
	}
	
	@Test
	public void testScrambleMoveParse(){
		assertEquals(SW, ScrambleMove.parse("sw:10x1,100x399;"));
		assertEquals(SWR, ScrambleMove.parse("swr:10,399;"));
		assertEquals(SWC, ScrambleMove.parse("swc:10,399;"));
		assertEquals(SLR, ScrambleMove.parse("slr:10,399;"));
		assertEquals(SLC, ScrambleMove.parse("slc:10,399;"));
		assertEquals(RCL, ScrambleMove.parse("rcl:1,10x1,100x399;"));
		assertEquals(RCC, ScrambleMove.parse("rcc:1,10x1,100x399;"));
		SW.hashCode();
	}
	
	@Test
	public void testScrambleMoveMultiParse(){
		assertEquals(
			Arrays.asList(SW,SWR),
			ScrambleMove.parseMulti("sw:10x1,100x399;swr:10,399;")
		);
	}
	
	@Test
	public void testScrambleMoveToKeyString(){
		assertEquals("sw:10x1,100x399;", SW.toKeyString());
		assertEquals("swr:10,399;", SWR.toKeyString());
		assertEquals("swc:10,399;", SWC.toKeyString());
		assertEquals("slr:10,399;", SLR.toKeyString());
		assertEquals("slc:10,399;", SLC.toKeyString());
		assertEquals("rcl:1,10x1,100x399;", RCL.toKeyString());
		assertEquals("rcc:1,10x1,100x399;", RCC.toKeyString());
	}
}
