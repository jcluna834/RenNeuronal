package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.joone.engine.*;
import org.joone.engine.learning.*;
import org.joone.io.*;
import org.joone.net.NeuralNet;

public class RNA implements NeuralNetListener {

    private NeuralNet nnet;//Red Artificial
    private int cantidadLineas;//cantidad de patrones del archivo
    private String dirEntradas;//archivo que contiene las entradas
    private int ciclos;//cantidad de iteraciones a realizar en el entrenamiento
    private int tipo;//Tipo de red artificial 0-perceptron multicapa; 1-SOM
    private double factorAprendizaje;//Factor de aprendizaje
    private double momentum;//Factor de momentum

    /***
     * 
     * @param opc 
     */
    public RNA(int opc) {
        tipo = opc;
        LinearLayer entradas = new LinearLayer();
        nnet = new NeuralNet();
        cantidadLineas = -1;
        ciclos = -1;
        dirEntradas = null;
        factorAprendizaje = -1;
        momentum = -1;
        switch (opc) {
            case 0://en caso de ser un perceptron multicapa
                SigmoidLayer capa1 = new SigmoidLayer();
                SigmoidLayer capa2 = new SigmoidLayer();
                SigmoidLayer capa3 = new SigmoidLayer();
                SigmoidLayer capa4 = new SigmoidLayer();

                entradas.setLayerName("Entradas");
                capa1.setLayerName("Capa 1");
                capa2.setLayerName("Capa 2");
                capa3.setLayerName("Capa 3");
                capa4.setLayerName("Capa 4");

                entradas.setRows(9);
                capa1.setRows(9);
                capa2.setRows(6);
                capa3.setRows(4);
                capa4.setRows(3);

                FullSynapse synapse_IH1 = new FullSynapse();
                FullSynapse synapse_H1H2 = new FullSynapse();
                FullSynapse synapse_H2H3 = new FullSynapse();
                FullSynapse synapse_H3O = new FullSynapse();

                synapse_IH1.setName("IH1");
                synapse_H1H2.setName("H1H2");
                synapse_H2H3.setName("H2H3");
                synapse_H3O.setName("H3O");

                entradas.addOutputSynapse(synapse_IH1);
                capa1.addInputSynapse(synapse_IH1);

                capa1.addOutputSynapse(synapse_H1H2);
                capa2.addInputSynapse(synapse_H1H2);

                capa2.addOutputSynapse(synapse_H2H3);
                capa3.addInputSynapse(synapse_H2H3);

                capa3.addOutputSynapse(synapse_H3O);
                capa4.addInputSynapse(synapse_H3O);

                nnet.addLayer(entradas, NeuralNet.INPUT_LAYER);
                nnet.addLayer(capa1, NeuralNet.HIDDEN_LAYER);
                nnet.addLayer(capa2, NeuralNet.HIDDEN_LAYER);
                nnet.addLayer(capa3, NeuralNet.HIDDEN_LAYER);
                nnet.addLayer(capa4, NeuralNet.OUTPUT_LAYER);
                break;
            case 1://en caso de ser una red SOM
                GaussianLayer capaG = new GaussianLayer();
                entradas.setLayerName("Entradas");
                capaG.setLayerName("Capa 1");

                entradas.setRows(9);

                capaG.setInitialGaussianSize(5);
                capaG.setLayerHeight(5);
                capaG.setLayerWidth(5);
                capaG.setOrderingPhase(ciclos);
                capaG.setTimeConstant(200);

                KohonenSynapse synapse_IG1 = new KohonenSynapse();
                synapse_IG1.setName("IG1");

                entradas.addOutputSynapse(synapse_IG1);
                capaG.addInputSynapse(synapse_IG1);
                nnet.addLayer(entradas, NeuralNet.INPUT_LAYER);
                nnet.addLayer(capaG, NeuralNet.OUTPUT_LAYER);
                break;

            default://Cargar la Red desde un archivo
                nnet = null;
                try {
                    FileInputStream stream = new FileInputStream("bckup_red");
                    ObjectInput input = new ObjectInputStream(stream);
                    nnet = (NeuralNet) input.readObject();
                    if(nnet.getOutputLayer().getLayerName().compareTo("Capa 4")==0) {
                        tipo = 0;
                        stream = new FileInputStream("redMulticapa.ser");
                        input = new ObjectInputStream(stream);
                        nnet = (NeuralNet) input.readObject();
                    }else{
                        tipo = 1;
                        stream = new FileInputStream("redSOM.ser");
                        input = new ObjectInputStream(stream);
                        nnet = (NeuralNet) input.readObject();
                    }
                    setMomentum(nnet.getMonitor().getMomentum());
                    setFactorAprendizaje(nnet.getMonitor().getLearningRate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public double getFactorAprendizaje() {
        return factorAprendizaje;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setFactorAprendizaje(double factorAprendizaje) {
        this.factorAprendizaje = factorAprendizaje;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setDirEntradas(String dirEntradas) {
        this.dirEntradas = dirEntradas;
    }

    public void setCantidadLineas(int cantidadLineas) {
        this.cantidadLineas = cantidadLineas;
    }

    public int getCantidadLineas() {
        return cantidadLineas;
    }

    public String getDirEntradas() {
        return dirEntradas;
    }

    /***
     * 
     * @param dirError
     * @return
     * @throws Exception 
     */
    public String training(String dirError) throws Exception {
        if (cantidadLineas == -1) {
            throw new Exception("Archivo Sin Cargar");
        }
        if (ciclos == -1) {
            throw new Exception("Sin Configurar");
        }
        switch (tipo) {
            case 0://Entrenamiento Para RED con perceptron multicapa
                if (dirEntradas == null) {
                    throw new Exception("Sin Iniciar");
                }

                FileInputSynapse entradas = new FileInputSynapse();
                entradas.setAdvancedColumnSelector("1-9");
                entradas.setInputFile(new File(dirEntradas));

                Layer input = nnet.getInputLayer();
                input.addInputSynapse(entradas);

                FileInputSynapse salidaDeseada = new FileInputSynapse();
                salidaDeseada.setInputFile(new File(dirEntradas));
                salidaDeseada.setAdvancedColumnSelector("10-12");

                TeachingSynapse trainer = new TeachingSynapse();
                trainer.setDesired(salidaDeseada);

                FileOutputSynapse error = new FileOutputSynapse();
                error.setFileName(dirError);

                trainer.addResultSynapse(error);

                Layer output = nnet.getOutputLayer();
                output.addOutputSynapse(trainer);

                nnet.setTeacher(trainer);
                break;
            case 1://Entrenamiento Para RED SOM
                if (dirEntradas == null) {
                    throw new Exception("Sin Iniciar");
                }

                FileInputSynapse entradasSOM = new FileInputSynapse();
                entradasSOM.setAdvancedColumnSelector("1-9");
                entradasSOM.setInputFile(new File(dirEntradas));

                Layer inputSOM = nnet.getInputLayer();
                inputSOM.addInputSynapse(entradasSOM);
                break;
        }

        Monitor monitor = nnet.getMonitor();
        monitor.setLearningRate(factorAprendizaje);
        monitor.setMomentum(momentum);
        monitor.isSingleThreadMode();

        monitor.removeAllListeners();
        monitor.addNeuralNetListener(this);

        monitor.setTrainingPatterns(cantidadLineas);
        monitor.setTotCicles(ciclos);
        monitor.setLearning(true);

        nnet.go();
        nnet.join();
        if (tipo == 0) {//si la red es multicapa, retorna el error cuadratico medio
            return monitor.getGlobalError() + "";
        } else {//sino, retorna null
            return null;
        }
    }

    /***
     * 
     * @param dirSalidas
     * @throws Exception 
     */
    public void generate(String dirSalidas) throws Exception {
        if (dirEntradas == null) {
            throw new Exception("Sin Iniciar");
        }
        Layer input = nnet.getInputLayer();
        input.removeAllInputs();

        Layer output = nnet.getOutputLayer();
        output.removeAllOutputs();

        FileInputSynapse inputStream = new FileInputSynapse();
        inputStream.setAdvancedColumnSelector("1-9");
        inputStream.setInputFile(new File(dirEntradas));
        input.addInputSynapse(inputStream);

        FileOutputSynapse outputStream = new FileOutputSynapse();
        outputStream.setFileName(dirSalidas);
        output.addOutputSynapse(outputStream);

        Monitor monitor = nnet.getMonitor();
        monitor.isSingleThreadMode();
        monitor.removeAllListeners();
        monitor.addNeuralNetListener(this);
        monitor.setTrainingPatterns(cantidadLineas);
        monitor.setTotCicles(1);
        monitor.setLearning(false);
        nnet.go();
        nnet.join();
    }

    /***
     * 
     * @param e 
     */
    @Override
    public void netStopped(NeuralNetEvent e) {
        try {
            FileOutputStream stream = new FileOutputStream("bckup_red");
            FileOutputStream bckup = new FileOutputStream("bckup_red");
            if(tipo==0)
                stream = new FileOutputStream("redMulticapa.ser");
            if(tipo==1)
                stream = new FileOutputStream("redSOM.ser");
            ObjectOutputStream out = new ObjectOutputStream(stream);
            ObjectOutputStream sbck = new ObjectOutputStream(bckup);
            out.writeObject(nnet);
            sbck.writeObject(nnet);
            sbck.close();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /***
     * 
     * @param e 
     */
    @Override
    public void cicleTerminated(NeuralNetEvent e) {
    }

    /***
     * 
     * @param e 
     */
    @Override
    public void netStarted(NeuralNetEvent e) {
    }

    /***
     * 
     * @param e 
     */
    @Override
    public void errorChanged(NeuralNetEvent e) {
    }

    /***
     * 
     * @param e
     * @param error 
     */
    @Override
    public void netStoppedError(NeuralNetEvent e, String error) {
    }
}
