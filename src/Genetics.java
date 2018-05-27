/**
 * Created by Caske2000 on 26/05/2018.
 */
public class Genetics
{
    public static NeuralNetwork createOffspring(NeuralNetwork parent1, NeuralNetwork parent2)
    {
        try
        {
            NeuralNetwork child = parent1.clone();



            return child;

        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
