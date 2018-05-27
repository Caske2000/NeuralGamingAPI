import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Caske2000 on 26/05/2018.
 */
public class Genetics
{
    private static final double MUTATION_RATE = 0.1;

    // Not yet implemented
    @Deprecated
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

    public static NeuralNetwork mutate(NeuralNetwork network)
    {
        try
        {
            NeuralNetwork clone = network.clone();

            // the chance of a given network being mutated
            double mutationRate = 0.01;

            // if the network shouldn't be mutated, return it right away
            if (ThreadLocalRandom.current().nextDouble(0, 1) > mutationRate)
                return clone;

            // mutate the input layer
            // inside each layer, we iterate through the neurons
            for (int i = 0; i < clone.inputLayer.getSize(); i++)
            {
                // inside each neuron we iterate through each weight
                for (int j = 0; j < clone.inputLayer.get(i).getWeights().length; j++)
                {
                    clone.inputLayer.get(i).getWeights()[j] *= MUTATION_RATE;
                }
            }

            // mutate the hidden layers
            // else mutate each layer of the network
            for (Layer layer : clone.hiddenLayers)
            {
                // inside each layer, we iterate through the neurons
                for (int i = 0; i < layer.getSize(); i++)
                {
                    // inside each neuron we iterate through each weight
                    for (int j = 0; j < layer.get(i).getWeights().length; j++)
                    {
                        layer.get(i).getWeights()[j] *= MUTATION_RATE;
                    }
                }
            }

            // mutate the output layer
            // inside each layer, we iterate through the neurons
            for (int i = 0; i < clone.outputLayer.getSize(); i++)
            {
                // inside each neuron we iterate through each weight
                for (int j = 0; j < clone.outputLayer.get(i).getWeights().length; j++)
                {
                    clone.outputLayer.get(i).getWeights()[j] *= MUTATION_RATE;
                }
            }

            return clone;

        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return network;
        }
    }
}
