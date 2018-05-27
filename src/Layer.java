/**
 * Created by Caske2000 on 26/05/2018.
 */
public class Layer implements Cloneable
{
    // initialise variables
    final Neuron[] neurons;

    public Layer(int neuronCount)
    {
        neurons = new Neuron[neuronCount];

        for (int i = 0; i < neuronCount; i++)
        {
            neurons[i] = new Neuron();
        }
    }

    public Layer(int neuronCount, Layer inputNeurons)
    {
        neurons = new Neuron[neuronCount];

        for (int i = 0; i < neuronCount; i++)
        {
            neurons[i] = new Neuron(inputNeurons);
        }
    }

    public int getSize()
    {
        return neurons.length;
    }

    public Neuron get(int index)
    {
        return neurons[index];
    }

    public Layer clone()throws CloneNotSupportedException{
        return (Layer) super.clone();
    }
}
