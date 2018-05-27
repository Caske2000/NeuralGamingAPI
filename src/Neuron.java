import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Caske2000 on 26/05/2018.
 */
public class Neuron implements Cloneable
{
    // initialise variables
    private Neuron[] inputNeurons;
    private double[] weights;
    private double output;

    public Neuron()
    {
    }

    public Neuron(Layer inputNeurons)
    {
        // initialise neurons and generate random weights
        this.inputNeurons = new Neuron[inputNeurons.getSize()];
        weights = new double[inputNeurons.getSize()];

        for (int i = 0; i < inputNeurons.getSize(); i++)
        {
            this.inputNeurons[i] = inputNeurons.get(i);
            weights[i] = ThreadLocalRandom.current().nextDouble(-1,1);
        }
    }

    // feed-forward propagation ==> calculation the output based on inputs & weights
    double calculate()
    {
        double inputSum = 0;
        for (int i = 0; i < inputNeurons.length; i++)
        {
            inputSum += inputNeurons[i].getOutput() * weights[i];
        }
        output = Activation.simoid(inputSum);

        return output;
    }

    Neuron[] getInput()
    {
        return inputNeurons;
    }

    void setOutput(double outputValue)
    {
        output = outputValue;
    }

    public double getOutput()
    {
        return output;
    }

    public double[] getWeights()
    {
        return weights;
    }

    public Neuron clone()throws CloneNotSupportedException{
        return (Neuron) super.clone();
    }
}
