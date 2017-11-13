/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White, with edits by Rebecca Young (Nov 2016)
 * @version April 2012
 */
public class Magpie3
{
    /**
     * Get a default greeting
     * 
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findKeyword(statement, "Archimedes") >= 0 )
        {
            response = "Archimedes was born in Syracuse, Sicily around the year 287 BC.";
        }
        else if (findKeyword(statement, "Newton") >= 0 || findKeyword(statement, "Isaac")  >= 0)
        {
            response = "Isaac Newton was born on Christmas Day, 1642 an hour or two after midnight in England. His book Philosophiæ Naturalis Principia Mathematica, first published in 1687, laid the foundations of classical mechanics. Newton also made pathbreaking contributions to optics, and he shares credit with Gottfried Wilhelm Leibniz for developing the infinitesimal calculus.";
        }
        else if (findKeyword(statement, "Kepler") >= 0 )
        {
            response = "Kepler was born on December 27, 1571 in Germany. Discovered the solar system’s planets follow elliptical paths; showed that tides on the earth are caused mainly by the moon; proved how logarithms work; discovered the inverse square law of light intensity; his laws of planetary motion led Newton to his law of gravitation.";
        }
        else if (findKeyword(statement, "Plato") >= 0 )
        {
            response = "Although usually remembered today as a philosopher, Plato was also one of ancient Greece’s most important patrons of mathematics. Plato the mathematician is perhaps best known for his identification of 5 regular symmetrical 3-dimensional shapes, which he maintained were the basis for the whole universe, and which have become known as the Platonic Solids: the tetrahedron (constructed of 4 regular triangles, and which for Plato represented fire), the octahedron (composed of 8 triangles, representing air), the icosahedron (composed of 20 triangles, and representing water), the cube (composed of 6 squares, and representing earth), and the dodecahedron (made up of 12 pentagons, which Plato obscurely described as the god used for arranging the constellations on the whole heaven).";
        }
        else if (findKeyword(statement, "Einstein") >= 0 )
        {
            response = "Albert Einstein was born at Ulm, in Württemberg, Germany, on March 14, 1879. At the start of his scientific work, Einstein realized the inadequacies of Newtonian mechanics and his special theory of relativity stemmed from an attempt to reconcile the laws of mechanics with the laws of the electromagnetic field. Albert Einstein received honorary doctorate degrees in science, medicine and philosophy from many European and American universities.";
        }
        else if (findKeyword(statement, "Tesla") >= 0)
        {
            response = "Nikola Tesla was a Serbian-American engineer and inventor who is highly regarded in energy history for his development of alternating current (AC) electrical systems. He also made extraordinary contributions in the fields of electromagnetism and wireless radio communications.";
        }
        else
        {
            response = getRandomResponse();
        }
        
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in the line below
        int pos = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a word
        while (pos >= 0)
        {
            // Find the char bef    ore and after the word
            char before = ' ';
            char after = ' ';
            if (pos > 0)
                before = phrase.charAt(pos - 1);
                
            if (pos + goal.length() < phrase.length())
                after = phrase.charAt( pos + goal.length());

            // If before and after aren't letters, we've found the word
            if (!Character.isLetter(before) && !Character.isLetter(after))
                return pos;

            // The last position didn't work, so let's find the next, if there is one.
            pos = phrase.indexOf(goal, pos + 1);
        }
        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * 
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }

}
