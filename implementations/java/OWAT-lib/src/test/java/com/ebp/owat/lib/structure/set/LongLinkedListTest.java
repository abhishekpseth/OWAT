package com.ebp.owat.lib.structure.set;

import com.ebp.owat.lib.datastructure.set.LongLinkedList;
import com.ebp.owat.lib.testModels.structure.set.ListTestCheckers;
import com.ebp.owat.lib.testModels.structure.set.LongLinkedListTestModels;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Tests the LongLinkedList class.
 *
 * Created by Greg Stewart on 4/1/17.
 */
public class LongLinkedListTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LongLinkedListTest.class);
	
	private LongLinkedList<Long> testingNodeList;
	private LinkedList<Long> checkingNodeList;
	
	@Before
	public void setup(){
		testingNodeList = null;
		checkingNodeList = null;
	}
	
	@Test
	public void testLongLinkedListConstructors(){
		LOGGER.info("Testing the constructors of the LongLinkedList");
		
		testingNodeList = new LongLinkedList<>();
		assertEquals("Basic constructor didn't set the default capacity correctly.", LongLinkedList.DEFAULT_CAPACITY, testingNodeList.getCapacity());
		assertEquals("Basic constructor somehow has nodes in it.", 0, testingNodeList.sizeL());
		
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingCapacity);
		assertEquals("Constructor didn't set the capacity correctly.", LongLinkedListTestModels.testingCapacity, testingNodeList.getCapacity());
		
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		assertEquals("Constructor has wrong number of nodes.", LongLinkedListTestModels.testingArray.size(), testingNodeList.sizeL());
		
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingCapacity, LongLinkedListTestModels.fullTestingArray);
		assertEquals("Constructor has wrong number of nodes.", LongLinkedListTestModels.fullTestingArray.size(), testingNodeList.sizeL());
		assertEquals("Constructor didn't set the capacity correctly.", LongLinkedListTestModels.testingCapacity, testingNodeList.getCapacity());
	}

	/**
	 * A ridiculous test to try to exercize the full ability of the long linked list.
	 *
	 * Relevant jvm options to run:
	 * -Xmx16g -XX:-UseGCOverheadLimit
	 */
	@Ignore("Ignored due to the fact that this will take too much time to run in a normal test, and will probably fail due to running out of memory.")
	@Test
	public void testLongLinkedListMakeSizeGTIntSize(){
		long goalLength = (long)Integer.MAX_VALUE + 1L;
		LOGGER.info("Attempting to make a LongLinkedList that is longer than Integer.MAX_VALUE ({}) values long. MIGHT take a while (if you have enough memory to run it completely)......", Integer.MAX_VALUE);
		LOGGER.info("Recommended to keep this test ignored (add the '@Ignore' annotation to the method) in order to keep the tests sane.");

		long i = 0;
		try {
			Boolean valToAdd = true;
			LongLinkedList<Boolean> testList = new LongLinkedList<>();
			for (i = 0; i <= goalLength; i++) {
				testList.addLast(valToAdd);
			}
			LOGGER.info("Built to the end of the list! Congratulations!");
			assertTrue(testList.lengthGTMaxInt());
			assertEquals(goalLength, testList.sizeL());
			assertEquals(Integer.MAX_VALUE, testList.size());
		}catch (OutOfMemoryError e){
			LOGGER.error("Out of memory error at iteration #{}/{} ({} iterations left): ", i, goalLength, goalLength - i, e);
			Assert.fail("Ran into out of memory error at iteration #"+i+".");
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////// Queue/Dequeue methods /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testLongLinkedListQueueMethodsAddFirstLast(){
		LOGGER.info("Testing LongLinkedListNodes.addFirst/Last that come from the Queue/Dequeue interface.");
		
		LOGGER.info("Testing add first/last with an empty list.");
		testingNodeList = new LongLinkedList<>();
		testingNodeList.addFirst(0L);
		assertEquals("addFirst did not add an element to the list.", 1, testingNodeList.size());
		testingNodeList = new LongLinkedList<>();
		testingNodeList.addLast(5L);
		assertEquals("addLast did not add an element to the list.", 1, testingNodeList.size());
		
		LOGGER.info("Testing add first/last with a list.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.fullTestingArray);
		testingNodeList.addFirst(0L);
		assertEquals("addFirst did not add an element to the list.", LongLinkedListTestModels.fullTestingArray.size() + 1, testingNodeList.size());
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.fullTestingArray);
		testingNodeList.addLast(5L);
		assertEquals("addLast did not add an element to the list.", LongLinkedListTestModels.fullTestingArray.size() + 1, testingNodeList.size());
		
		LOGGER.info("Testing add first/last with a full list.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingCapacity, LongLinkedListTestModels.fullTestingArray);
		try{
			testingNodeList.addFirst(0L);
			Assert.fail("addFirst in full list did not fail.");
		}catch (IllegalStateException e){}
		try{
			testingNodeList.addLast(0L);
			Assert.fail("addLast in full list did not fail.");
		}catch (IllegalStateException e){}
	}
	
	@Test
	public void testLongLinkedListQueueMethodsOfferFirstLast(){
		LOGGER.info("Testing LongLinkedListNodes.offerFirst/Last that come from the Queue/Dequeue interface.");
		
		LOGGER.info("Testing add first/last with an empty list.");
		testingNodeList = new LongLinkedList<>();
		assertTrue(testingNodeList.offerFirst(0L));
		assertEquals("offerFirst did not add an element to the list.", 1, testingNodeList.size());
		testingNodeList = new LongLinkedList<>();
		assertTrue(testingNodeList.offerLast(0L));
		assertEquals("offerLast did not add an element to the list.", 1, testingNodeList.size());
		
		LOGGER.info("Testing offer first/last with a list.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.fullTestingArray);
		assertTrue(testingNodeList.offerFirst(0L));
		assertEquals("offerFirst did not add an element to the list.", LongLinkedListTestModels.fullTestingArray.size() + 1, testingNodeList.size());
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.fullTestingArray);
		assertTrue(testingNodeList.offerLast(0L));
		assertEquals("offerLast did not add an element to the list.", LongLinkedListTestModels.fullTestingArray.size() + 1, testingNodeList.size());
		
		LOGGER.info("Testing offer first/last with a full list.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingCapacity, LongLinkedListTestModels.fullTestingArray);
		assertFalse("offerFirst returned true after list being full", testingNodeList.offerFirst(0L));
		assertFalse("offerLast returned true after list being full", testingNodeList.offerLast(0L));
	}
	
	@Test
	public void testLongLinkedListQueueMethodsRemoveFirstLast(){
		LOGGER.info("Testing LongLinkedList's remove first/last methods.");
		
		LOGGER.info("Testing that it throws on empty list.");
		testingNodeList = new LongLinkedList<>();
		try{
			testingNodeList.removeFirst();
			Assert.fail("Failed to throw when removing from empty list.");
		}catch(NoSuchElementException e){}
		try{
			testingNodeList.removeLast();
			Assert.fail("Failed to throw when removing from empty list.");
		}catch(NoSuchElementException e){}
		
		LOGGER.info("Testing that the LongLinkedList appropriately removes elements.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		
		Long valReturned = testingNodeList.removeLast();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(LongLinkedListTestModels.testingArray.size() - 1));
		assertEquals("Resulting size was wrong.", testingNodeList.size(), LongLinkedListTestModels.testingArray.size() - 1);
		
		valReturned = testingNodeList.removeFirst();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(0));
		assertEquals("Resulting size was wrong.", testingNodeList.size(), LongLinkedListTestModels.testingArray.size() - 2);
	}
	
	@Test
	public void testLongLinkedListQueueMethodsPollFirstLast(){
		LOGGER.info("Testing LongLinkedList's poll first/last methods.");
		
		LOGGER.info("Testing that it returns null on empty list.");
		testingNodeList = new LongLinkedList<>();
		assertNull("Empty list failed to return null on poll.", testingNodeList.pollFirst());
		assertNull("Empty list failed to return null on poll.", testingNodeList.pollLast());
		
		LOGGER.info("Testing that the LongLinkedList appropriately polls elements.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		
		Long valReturned = testingNodeList.pollLast();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(LongLinkedListTestModels.testingArray.size() - 1));
		assertEquals("Resulting size was wrong.", testingNodeList.size(), LongLinkedListTestModels.testingArray.size() - 1);
		
		valReturned = testingNodeList.pollFirst();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(0));
		assertEquals("Resulting size was wrong.", testingNodeList.size(), LongLinkedListTestModels.testingArray.size() - 2);
	}
	
	
	@Test
	public void testLongLinkedListQueueMethodsGetFirstLast(){
		LOGGER.info("Testing LongLinkedList's get first/last methods.");
		
		LOGGER.info("Testing that it throws on empty list.");
		testingNodeList = new LongLinkedList<>();
		try{
			testingNodeList.getFirst();
			Assert.fail("Failed to throw when getting from empty list.");
		}catch(NoSuchElementException e){}
		try{
			testingNodeList.getLast();
			Assert.fail("Failed to throw when getting from empty list.");
		}catch(NoSuchElementException e){}
		
		LOGGER.info("Testing that the LongLinkedList appropriately gets elements.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		
		Long valReturned = testingNodeList.getLast();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(LongLinkedListTestModels.testingArray.size() - 1));
		
		valReturned = testingNodeList.getFirst();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(0));
	}
	
	@Test
	public void testLongLinkedListQueueMethodsPeekFirstLast(){
		LOGGER.info("Testing LongLinkedList's peek first/last methods.");
		
		LOGGER.info("Testing that it returns null on empty list.");
		testingNodeList = new LongLinkedList<>();
		assertNull("Empty list failed to return null on peek.", testingNodeList.peekFirst());
		assertNull("Empty list failed to return null on peek.", testingNodeList.peekLast());
		
		LOGGER.info("Testing that the LongLinkedList appropriately peeks elements.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		
		Long valReturned = testingNodeList.peekLast();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(LongLinkedListTestModels.testingArray.size() - 1));
		valReturned = testingNodeList.peekFirst();
		assertEquals("Wrong value returned.",valReturned, LongLinkedListTestModels.testingArray.get(0));
	}
	
	
	@Test
	public void testLongLinkedListQueueMethodsRemoveFirstLastOccurrence(){
		LOGGER.info("Testing the remove first/last occurrence methods.");
		
		testingNodeList = new LongLinkedList<>();
		assertFalse("returned true when should have returned false in empty list.", testingNodeList.removeFirstOccurrence(0L));
		assertFalse("returned true when should have returned false in empty list.", testingNodeList.removeLastOccurrence(0L));
		
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		testingNodeList.addAll(LongLinkedListTestModels.testingArray);
		
		long origLength = testingNodeList.size();
		
		assertFalse("returned true when should have returned false in populated list.", testingNodeList.removeFirstOccurrence(-1L));
		assertFalse("returned true when should have returned false in populated list.", testingNodeList.removeLastOccurrence(-1L));
		
		assertTrue("", testingNodeList.removeFirstOccurrence(0L));
		assertEquals(testingNodeList.size(), origLength - 1);
		
		assertTrue("", testingNodeList.removeLastOccurrence(0L));
		assertEquals(testingNodeList.size(), origLength - 2);
		
		testingNodeList.addAll(LongLinkedListTestModels.testingArrayWithNulls);
		origLength = testingNodeList.size();
		
		assertTrue("", testingNodeList.removeFirstOccurrence(null));
		assertEquals(testingNodeList.size(), origLength - 1);
		
		assertTrue("", testingNodeList.removeLastOccurrence(null));
		assertEquals(testingNodeList.size(), origLength - 2);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////// List methods //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testLongLinkedListListMethodsAddAll(){
		LOGGER.info("Testing the (List)addAll method for LongLinkedList.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		LOGGER.info("Testing that methods throws appropriately on bad index.");
		try{
			testingNodeList.addAll((int)-1, LongLinkedListTestModels.testingArray);
			Assert.fail("Failed to throw on negative index.");
		}catch (IndexOutOfBoundsException e){}
		try{
			int outOfBoundsIndex = testingNodeList.size() + 1;
			testingNodeList.addAll(outOfBoundsIndex, LongLinkedListTestModels.testingArray);
			LOGGER.error("Numbers: Index given: {}, Size of list: {}", outOfBoundsIndex, testingNodeList.size());
			Assert.fail("Failed to throw on out of bounds index.");
		}catch (IndexOutOfBoundsException e){}
		
		testingNodeList = new LongLinkedList<>();
		ArrayList<Long> checkingArray = new ArrayList<>();
		
		LOGGER.info("Testing that nodes can be appropriately be inserted into empty list.");
		assertTrue(testingNodeList.addAll(0, LongLinkedListTestModels.testingArray));
		checkingArray.addAll(0, LongLinkedListTestModels.testingArray);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingArray);
		
		//check inserting at start of populated list
		assertTrue(testingNodeList.addAll(0, LongLinkedListTestModels.fullTestingArray));
		checkingArray.addAll(0, LongLinkedListTestModels.fullTestingArray);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingArray);
		
		//check inserting in middle of populated list
		assertTrue(testingNodeList.addAll(5, LongLinkedListTestModels.fullTestingArray));
		checkingArray.addAll(5, LongLinkedListTestModels.fullTestingArray);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingArray);
		
		//check inserting at end of populated list
		assertTrue(testingNodeList.addAll(testingNodeList.size(), LongLinkedListTestModels.fullTestingArray));
		checkingArray.addAll(checkingArray.size(), LongLinkedListTestModels.fullTestingArray);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingArray);
		
		//test capacity bounds
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingCapacity);
		testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		try{
			testingNodeList.addAll(0, LongLinkedListTestModels.fullTestingArray);
			Assert.fail("Failed to throw exception when capacity bounds would be broken.");
		}catch (IllegalStateException e){}
	}
	
	@Test
	public void testLongLinkedListListMethodsGet(){
		LOGGER.info("Testing the get method for LongLinkedList.");
		
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		
		LOGGER.info("Testing that methods throws appropriately on bad index.");
		try{
			testingNodeList.get((int)-1);
			Assert.fail("Failed to throw on negative index.");
		}catch (IndexOutOfBoundsException e){}
		try{
			int outOfBoundsIndex = testingNodeList.size();
			testingNodeList.get(outOfBoundsIndex);
			LOGGER.error("Numbers: Index given: {}, Size of list: {}", outOfBoundsIndex, testingNodeList.size());
			Assert.fail("Failed to throw on out of bounds index.");
		}catch (IndexOutOfBoundsException e){}
		
		LOGGER.info("Testing that we get correct values back.");
		for(int i = 0; i < testingNodeList.size(); i++){
			assertEquals(
				"The value returned by the LongLinkedList was wrong.",
				LongLinkedListTestModels.testingArray.get(i),
				testingNodeList.get(i)
			);
		}
	}
	
	@Test
	public void testLongLinkedListListMethodsSet(){
		LOGGER.info("Testing the (List)Set method for LongLinkedList.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		LOGGER.info("Testing that methods throws appropriately on bad index.");
		try{
			testingNodeList.set((int)-1, 0L);
			Assert.fail("Failed to throw on negative index.");
		}catch (IndexOutOfBoundsException e){}
		try{
			int outOfBoundsIndex = testingNodeList.size() + 1;
			testingNodeList.set(outOfBoundsIndex, 0L);
			LOGGER.error("Numbers: Index given: {}, Size of list: {}", outOfBoundsIndex, testingNodeList.size());
			Assert.fail("Failed to throw on out of bounds index.");
		}catch (IndexOutOfBoundsException e){}
		
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		checkingNodeList = new LinkedList<>(LongLinkedListTestModels.testingArray);
		
		Random rand = new Random();
		for(int i = 0; i < testingNodeList.size(); i++){
			long curNumToSetWIth = rand.nextLong();
			assertEquals(testingNodeList.set(i, curNumToSetWIth), checkingNodeList.get(i));
			checkingNodeList.set(i, curNumToSetWIth);
			ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingNodeList);
		}
	}
	
	@Test
	public void testLongLinkedListListMethodsAdd(){
		LOGGER.info("Testing the (List)add method for LongLinkedList.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		LOGGER.info("Testing that methods throws appropriately on bad index.");
		try{
			testingNodeList.add((int)-1, 0L);
			Assert.fail("Failed to throw on negative index.");
		}catch (IndexOutOfBoundsException e){}
		try{
			int outOfBoundsIndex = testingNodeList.size() + 1;
			testingNodeList.add(outOfBoundsIndex, 0L);
			LOGGER.error("Numbers: Index given: {}, Size of list: {}", outOfBoundsIndex, testingNodeList.size());
			Assert.fail("Failed to throw on out of bounds index.");
		}catch (IndexOutOfBoundsException e){}
		
		testingNodeList = new LongLinkedList<>();
		checkingNodeList = new LinkedList<>();
		
		LOGGER.info("Testing that a value can be appropriately be inserted into empty list.");
		testingNodeList.add(0, 0L);
		checkingNodeList.add(0, 0L);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingNodeList);
		
		//check inserting at start of populated list
		LOGGER.info("Testing that nodes can be appropriately be inserted into beginning of populated list.");
		testingNodeList.addAll(LongLinkedListTestModels.testingArray);
		checkingNodeList.addAll(LongLinkedListTestModels.testingArray);
		testingNodeList.add(0, 16L);
		checkingNodeList.add(0, 16L);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingNodeList);
		
		//check inserting in middle of populated list
		LOGGER.info("Testing that a value can be appropriately be inserted into middle of populated list.");
		testingNodeList.add(5, 0L);
		checkingNodeList.add(5, 0L);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingNodeList);
		
		//check inserting at end of populated list
		LOGGER.info("Testing that a value can be appropriately be inserted onto end of populated list.");
		testingNodeList.add(testingNodeList.size(), 0L);
		checkingNodeList.add(checkingNodeList.size(), 0L);
		ListTestCheckers.testListsAreTheSame(testingNodeList, true, checkingNodeList);
		
		//test capacity bounds
		LOGGER.info("Testing adding on capacity bounds.");
		testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingCapacity);
		testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		try{
			testingNodeList.add(0, 0L);
			Assert.fail("Failed to throw exception when capacity bounds would be broken.");
		}catch (IllegalStateException e){}
	}
	
	@Test
	public void testLongLinkedListListMethodsRemove(){
		LOGGER.info("Testing the remove(#) method.");
		
		this.testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.testingArray);
		this.checkingNodeList = new LinkedList<>(LongLinkedListTestModels.testingArray);
		
		LOGGER.info("Testing removing the first element.");
		assertEquals(this.testingNodeList.remove((int)0), this.checkingNodeList.remove((int)0));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		LOGGER.info("Testing removing a middle element.");
		assertEquals(this.testingNodeList.remove((int)testingNodeList.size()/2), this.checkingNodeList.remove((int) checkingNodeList.size()/2));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		LOGGER.info("Testing removing the last element.");
		assertEquals(this.testingNodeList.remove((int)testingNodeList.size() - 1), this.checkingNodeList.remove((int) checkingNodeList.size() - 1));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
	}
	
	@Test
	public void testLongLinkedListListMethodsIndexOf(){
		LOGGER.info("Testing indexOf methods");
		
		this.testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList = new LinkedList<>(LongLinkedListTestModels.fullTestingArray);
		this.testingNodeList.addLast(null);
		this.checkingNodeList.addLast(null);
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.testingNodeList.addLast(null);
		this.checkingNodeList.addLast(null);
		
		for (long i = -1; i < this.testingNodeList.sizeL() + 1L; i++){
			//LOGGER.info("Finding first/last index of {}", i);
			assertEquals(this.checkingNodeList.indexOf(i), this.testingNodeList.indexOf(i));
			assertEquals(this.checkingNodeList.lastIndexOf(i), this.testingNodeList.lastIndexOf(i));
		}
	}
	
	@Test
	public void testLongLinkedListListMethodsSublist(){
		LOGGER.info("Testing the sublist(#, #) method.");
		
		this.testingNodeList = new LongLinkedList<>(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList = new LinkedList<>(LongLinkedListTestModels.fullTestingArray);
		
		LOGGER.info("Testing that methods throws appropriately on bad indexes.");
		try{
			testingNodeList.subList(-1, 1);
			Assert.fail("Failed to throw on negative index.");
		}catch (IndexOutOfBoundsException e){}
		try{
			testingNodeList.subList(1, -1);
			Assert.fail("Failed to throw on negative index.");
		}catch (IndexOutOfBoundsException | IllegalArgumentException e){}
		try{
			int outOfBoundsIndex = testingNodeList.size() + 1;
			testingNodeList.subList(outOfBoundsIndex, 0L);
			LOGGER.error("Numbers: Index given: {}, Size of list: {}", outOfBoundsIndex, testingNodeList.size());
			Assert.fail("Failed to throw on out of bounds index.");
		}catch (IndexOutOfBoundsException | IllegalArgumentException e){}
		try{
			int outOfBoundsIndex = testingNodeList.size() + 1;
			testingNodeList.subList(0L, outOfBoundsIndex);
			LOGGER.error("Numbers: Index given: {}, Size of list: {}", outOfBoundsIndex, testingNodeList.size());
			Assert.fail("Failed to throw on out of bounds index.");
		}catch (IndexOutOfBoundsException e){}
		
		LOGGER.info("Testing sublist starting at 0 are correct.");
		ListTestCheckers.testListsAreTheSame(
				testingNodeList.subList(0, 1),
				true,
				checkingNodeList.subList(0,1)
		);
		
		LOGGER.info("Testing sublist ending at end of list are correct.");
		ListTestCheckers.testListsAreTheSame(
				testingNodeList.subList(1, testingNodeList.size() - 1),
				true,
				checkingNodeList.subList(1,checkingNodeList.size() - 1)
		);
		
		LOGGER.info("Testing sublist of whole list is correct.");
		ListTestCheckers.testListsAreTheSame(
				testingNodeList.subList(0, testingNodeList.size() - 1),
				true,
				checkingNodeList.subList(0,checkingNodeList.size() - 1)
		);
		
		LOGGER.info("Testing sublist of one element is correct.");
		ListTestCheckers.testListsAreTheSame(
				testingNodeList.subList(0, 0),
				true,
				checkingNodeList.subList(0,0)
		);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////// Collection methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testLongLinkedListCollectionMethodsMisc(){
	
	}
	
	@Test
	public void testLongLinkedListCollectionMethodsContains(){
		LOGGER.info("Testing the LongLinkedList's contains(Obj) method");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		LOGGER.info("Testing that the empty list returns appropriately.");
		assertEquals(this.testingNodeList.contains(0L), this.checkingNodeList.contains(0L));
		
		LOGGER.info("Testing that a populated list returns appropriately.");
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		for(long i = -1; i <= this.testingNodeList.size(); i++){
			assertEquals(this.testingNodeList.contains(i), this.checkingNodeList.contains(i));
		}
		
		LOGGER.info("Testing that a populated list with nulls returns appropriately.");
		this.testingNodeList.add(null);
		this.checkingNodeList.add(null);
		
		assertEquals(this.testingNodeList.contains(null), this.checkingNodeList.contains(null));
	}
	
	@Test
	public void testLongLinkedListCollectionMethodsContainsAll(){
		LOGGER.info("Testing the LongLinkedList's containsAll(Collection) method.");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		assertEquals(this.testingNodeList.containsAll(LongLinkedListTestModels.shortTestingArray), this.checkingNodeList.containsAll(LongLinkedListTestModels.shortTestingArray));
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		assertEquals(this.testingNodeList.containsAll(LongLinkedListTestModels.shortTestingArray), this.checkingNodeList.containsAll(LongLinkedListTestModels.shortTestingArray));
		assertEquals(this.testingNodeList.containsAll(LongLinkedListTestModels.fullTestingArray), this.checkingNodeList.containsAll(LongLinkedListTestModels.fullTestingArray));
	}
	
	@Test
	public void testLongLinkedListCollectionMethodsToArray(){
		LOGGER.info("Testing the LongLinkedList's toArray() method.");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		ListTestCheckers.testListsAreTheSame(this.testingNodeList.toArray(), true, this.checkingNodeList.toArray());
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		ListTestCheckers.testListsAreTheSame(this.testingNodeList.toArray(), true, this.checkingNodeList.toArray());
		
		try {
			this.testingNodeList.toArray(new Long[0]);
			fail("Failed to throw a UnsupportedOperationException when calling toArray([])");
		}catch (UnsupportedOperationException e){}
	}
	
	@Test
	public void testLongLinkedListCollectionMethodsAddAll(){
		LOGGER.info("Testing the LongLinkedList's addAll(Collection) method.");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		try {
			this.testingNodeList.addAll(null);
			fail("Failed to throw a nullPointer Exception when trying to addAll(null)");
		}catch (NullPointerException e){}
		assertEquals(this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray), this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray));
		
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
	}
	
	@Test
	public void testLongLinkedListCollectionMethodsRemoveAll(){
		LOGGER.info("Testing the LongLinkedList's removeAll(Collection) method.");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		assertEquals(this.checkingNodeList.removeAll(LongLinkedListTestModels.shortTestingArray), this.testingNodeList.removeAll(LongLinkedListTestModels.shortTestingArray));
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		assertEquals(this.checkingNodeList.removeAll(LongLinkedListTestModels.shortTestingArray), this.testingNodeList.removeAll(LongLinkedListTestModels.shortTestingArray));
	}
	
	@Test
	public void testLongLinkedListCollectionMethodsRetainAll(){
		LOGGER.info("Testing the LongLinkedList's retainAll(Collection) method.");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		assertEquals(this.checkingNodeList.retainAll(LongLinkedListTestModels.shortTestingArray), this.testingNodeList.retainAll(LongLinkedListTestModels.shortTestingArray));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		assertEquals(this.checkingNodeList.retainAll(LongLinkedListTestModels.shortTestingArray), this.testingNodeList.retainAll(LongLinkedListTestModels.shortTestingArray));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		assertEquals(this.checkingNodeList.retainAll(LongLinkedListTestModels.shortTestingArray), this.testingNodeList.retainAll(LongLinkedListTestModels.shortTestingArray));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		assertEquals(this.checkingNodeList.retainAll(new ArrayList<Long>()), this.testingNodeList.retainAll(new ArrayList<Long>()));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		this.testingNodeList.add(0L);
		this.checkingNodeList.add(0L);
		
		assertEquals(this.checkingNodeList.retainAll(Arrays.asList(1L)), this.testingNodeList.retainAll(Arrays.asList(1L)));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		this.testingNodeList.add(0L);
		this.checkingNodeList.add(0L);
		
		assertEquals(this.checkingNodeList.retainAll(Arrays.asList(0L)), this.testingNodeList.retainAll(Arrays.asList(0L)));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
		this.testingNodeList.add(0L);
		this.checkingNodeList.add(0L);
		
		assertEquals(this.checkingNodeList.retainAll(Arrays.asList(1L)), this.testingNodeList.retainAll(Arrays.asList(1L)));
		ListTestCheckers.testListsAreTheSame(this.testingNodeList, true, this.checkingNodeList);
		
	}
	
	@Test
	public void testAtCapacity(){
		this.testingNodeList = new LongLinkedList<>(5L);
		
		assertFalse(this.testingNodeList.atCapacity());
		
		this.testingNodeList.add(0L);
		this.testingNodeList.add(1L);
		
		assertFalse(this.testingNodeList.atCapacity());
		
		this.testingNodeList.add(2L);
		this.testingNodeList.add(3L);
		this.testingNodeList.add(4L);
		
		assertTrue(this.testingNodeList.atCapacity());
		
	}
	
	@Test
	public void testCanAdd(){
		this.testingNodeList = new LongLinkedList<>(5L);
		
		assertTrue(this.testingNodeList.canAdd(4L));
		assertTrue(this.testingNodeList.canAdd(5L));
		assertFalse(this.testingNodeList.canAdd(6L));
		
		this.testingNodeList.add(0L);
		this.testingNodeList.add(1L);
		
		assertTrue(this.testingNodeList.canAdd(3L));
		assertFalse(this.testingNodeList.canAdd(5L));
		
		this.testingNodeList.add(2L);
		this.testingNodeList.add(3L);
		this.testingNodeList.add(4L);
		assertFalse(this.testingNodeList.canAdd(1L));
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////// Other methods /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testLongLinkedListOtherMethodsContainsAll(){
		LOGGER.info("Testing the LongLinkedList's containsAllElements(Collection) method.");
		
		this.testingNodeList = new LongLinkedList<>();
		this.checkingNodeList = new LinkedList<>();
		
		assertEquals(this.testingNodeList.containsAllElements(LongLinkedListTestModels.shortTestingArray), this.checkingNodeList.containsAll(LongLinkedListTestModels.shortTestingArray));
		
		this.testingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		this.checkingNodeList.addAll(LongLinkedListTestModels.fullTestingArray);
		
		assertEquals(this.testingNodeList.containsAllElements(LongLinkedListTestModels.shortTestingArray), this.checkingNodeList.containsAll(LongLinkedListTestModels.shortTestingArray));
		assertEquals(this.testingNodeList.containsAllElements(LongLinkedListTestModels.fullTestingArray), this.checkingNodeList.containsAll(LongLinkedListTestModels.fullTestingArray));
	}
}
