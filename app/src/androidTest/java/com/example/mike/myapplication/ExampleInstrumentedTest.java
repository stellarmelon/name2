package com.example.mike.myapplication;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mike.myapplication", appContext.getPackageName());
    }

    @Test
    public void canGoToSecondActivityWithMessage() {
        onView(withId(R.id.UsernameEditText)).perform(typeText("Legit Name"));
        onView(withId(R.id.OccupationEditText)).perform(typeText("Legit Name"));
        onView(withId(R.id.descriptionEditText)).perform(typeText("Legit Name"));
        try {
            Intents.init();
            onView(withId(R.id.button)).perform(scrollTo(), click());
            intended(hasComponent(ProfileContentFragment.class.getName()));
            intended(hasExtra(Constants.KEY_Username, "Legit Name"));
            intended(hasExtra(Constants.KEY_Description, "Legit Name"));
            intended(hasExtra(Constants.KEY_Occupation, "Legit Name"));
        } finally {
            Intents.release();
        }
    }
}

