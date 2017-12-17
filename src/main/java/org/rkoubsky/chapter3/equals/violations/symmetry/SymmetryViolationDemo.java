package org.rkoubsky.chapter3.equals.violations.symmetry;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class SymmetryViolationDemo {
    public static void main(final String[] args) {
        final CaseInsensitiveStringBroken brokenString = new CaseInsensitiveStringBroken("English");
        final String s = "english";
        /*
        As expected, brokenString.equals(s) returns true . The problem is that while the
        equals method in CaseInsensitiveString knows about ordinary strings, the
        equals method in String is oblivious to case-insensitive strings. Therefore
        s.equals(brokenString) returns false, a clear violation of symmetry.
        * */
        System.out.println("Testing equals that breaks symmetry.");
        System.out.printf("Calling %s equals %s\n", brokenString, s);
        System.out.println("Result: " + brokenString.equals(s));
        System.out.printf("Calling %s equals %s\n", s, brokenString);
        System.out.println("Result: " + s.equals(brokenString) + "\n");

        final CaseInsensitiveString okString = new CaseInsensitiveString("English");
        System.out.println("Testing equals that does not break symmetry.");
        System.out.printf("Calling %s equals %s\n", okString, s);
        System.out.println("Result: " + okString.equals(s));
        System.out.printf("Calling %s equals %s\n", s, okString);
        System.out.println("Result: " + s.equals(okString));
    }
}
