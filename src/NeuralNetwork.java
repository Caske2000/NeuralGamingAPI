/**
 * Created by Caske2000 on 26/05/2018.
 */
public class NeuralNetwork implements Cloneable
{
    // initialise variables
    final Layer inputLayer;
    Layer[] hiddenLayers;
    final Layer outputLayer;

    public NeuralNetwork(Layer inputLayer, Layer[] hiddenLayers, Layer outputLayer)
    {
        this.inputLayer = inputLayer;
        this.hiddenLayers = hiddenLayers;
        this.outputLayer = outputLayer;
    }

    public NeuralNetwork(int inputSize, int hiddenLayerCount, int hiddenLayerSize, int outputSize)
    {
        // initialise layers
        inputLayer = new Layer(inputSize);

        // every hidden layer must get input neurons (input layer for the first and the previous hidden layer for the rest
        for (int i = 0; i < hiddenLayerCount; i++)
        {
            if (i == 0)
                hiddenLayers[i] = new Layer(hiddenLayerSize, inputLayer);
            else
                hiddenLayers[i] = new Layer(hiddenLayerSize, hiddenLayers[i - 1]);
        }

        // if there is no hidden layer, the input layer becomes the previous layer
        if (hiddenLayerCount > 0)
            outputLayer = new Layer(outputSize, hiddenLayers[hiddenLayers.length - 1]);
        else
            outputLayer = new Layer(outputSize, inputLayer);
    }

    // TODO: if there is no hidden layer, this crashes
    // this calculates an output-array based on given inputs
    double[] response(double[] inputs)
    {
        double[] responses = new double[outputLayer.getSize()];

        // feed-forward propagation
        // 1) feed the inputs to the input layer
        for (int i = 0; i < inputLayer.getSize(); i++) {
            inputLayer.get(i).setOutput(inputs[i]);
        }
        // 2) the inputs now go to the hidden layer
        // iterate over every hidden layer
        for (Layer hiddenLayer : hiddenLayers)
        {
            // iterate over every neuron in the j-th hidden layer
            for (int k = 0; k < hiddenLayers[0].getSize(); k++)
            {
                hiddenLayer.get(k).calculate();
            }
        }
        // 3) the output of the last hidden layer goes to the output layer
        for (int k = 0; k < outputLayer.getSize(); k++) {
            responses[k] = outputLayer.get(k).calculate();
        }

        // now we return the outputs
        return responses;
    }

    public NeuralNetwork clone()throws CloneNotSupportedException{
        return (NeuralNetwork) super.clone();
    }
}
