package ok;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

class IsFirstNameAndSurname extends TypeSafeMatcher<List<java.lang.String>> {

    public void describeTo(Description description) {
        description.appendText("a positive integer");
    }

    @Factory
    public static Matcher<List<java.lang.String>> isFirstNameAndSurname() {
        return new IsFirstNameAndSurname();
    }

    @Override
    protected boolean matchesSafely(List<String> ts) {
        return ts.size() > 0 && ts.get(0).split(" ").length == 2;
    }
}
