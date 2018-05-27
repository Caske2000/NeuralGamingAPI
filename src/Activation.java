/**
 * Created by Caske2000 on 26/05/2018.
 */
public class Activation
{
    // TODO: Maybe should precalculate this
    public static double simoid(double input)
    {
        return 1 / (1 + Math.exp(-1 * input));
    }

    public static double tanh(double input)
    {
        return 2 / (1 + Math.exp(-2 * input)) - 1;
    }

    public static double relu(double input)
    {
        return Math.max(0, input);
    }
}
