package com.junit.testsuite;

import com.core.comparable.ComparableMain;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ComparableMain.class
})
public class JunitTestSuite {
	
}
